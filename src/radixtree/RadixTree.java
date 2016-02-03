package radixtree;

import java.util.ArrayList;
import java.util.List;

public class RadixTree {
    List<RadixTree> mChilds = new ArrayList<RadixTree>();
    RadixTree       mParent = null;
    String          mValue;
    boolean         mIsValue = false;

    class PrefixLookupResult {
        RadixTree       node;
        int             nodeValue;
        int             searchValue;

        PrefixLookupResult(RadixTree node, int nodeValue, int searchValue) {
            this.nodeValue = nodeValue;
            this.searchValue = searchValue;
            this.node = node;
        }
    }

    public RadixTree() {
        mValue = "";
    }

    public RadixTree(String value) {
        mValue = value;
    }

    PrefixLookupResult _lookupPrefixPartial(CharSequence value, int progress) {
        int processed = 0;
        int matched = processed + progress;

        while (processed < mValue.length() &&
                matched < value.length() &&
                mValue.charAt(processed) == value.charAt(matched)) {
            ++processed;
            matched = processed + progress;
        }

        if (processed == 0 && mChilds.size() == 0) {
            return null;
        } else if (mValue.length() == processed) {
            for (RadixTree child : mChilds) {
                PrefixLookupResult result = child._lookupPrefixPartial(value, matched);
                if (result != null) {
                    return result;
                }
            }
        }

        return (processed != 0) ? new PrefixLookupResult(this, processed, matched) : null;
    }

    public RadixTree lookupPrefixPartial(CharSequence value) {
        PrefixLookupResult result = _lookupPrefixPartial(value, 0);
        return (result != null) ? result.node : null;
    }

    public RadixTree lookupPrefix(CharSequence value) {
        PrefixLookupResult result = _lookupPrefixPartial(value, 0);

        if (result == null || result.searchValue < value.length()) {
            return null;
        }

        return result.node;
    }

    private static void _childValues(String prefix, RadixTree tree, List<String> childValues) {
        if (tree.mIsValue) {
            childValues.add(prefix + tree.mValue);
        }

        for (RadixTree child : tree.mChilds) {
            _childValues(prefix + tree.mValue, child, childValues);
        }
    }

    public static List<String> childValues(String prefix, RadixTree tree) {
        ArrayList<String> result = new ArrayList<String>();
        _childValues(prefix, tree, result);
        return result;
    }

    public void insert(String value) {
        PrefixLookupResult result = _lookupPrefixPartial(value, 0);

        if (result == null) {
            RadixTree node = new RadixTree(value);
            node.mParent = this;
            node.mIsValue = true;
            mChilds.add(node);
        } else if (result.nodeValue == result.node.mValue.length() && result.searchValue == value.length()) {
            result.node.mIsValue = true;
        } else if (result.nodeValue == result.node.mValue.length() && result.searchValue < value.length()) {
            RadixTree node = new RadixTree(value.substring(result.searchValue));
            node.mParent = result.node;
            node.mIsValue = true;
            result.node.mChilds.add(node);
        } else {
            RadixTree node = new RadixTree(result.node.mValue.substring(0, result.nodeValue));
            node.mParent = result.node.mParent;
            result.node.mParent.mChilds.remove(result.node);
            result.node.mParent.mChilds.add(node);
            node.mIsValue = false;

            result.node.mValue = result.node.mValue.substring(result.nodeValue);
            result.node.mParent = node;

            node.mChilds.add(result.node);

            RadixTree newNode = new RadixTree(value.substring(result.searchValue));
            newNode.mParent = node;
            node.mChilds.add(newNode);
            newNode.mIsValue = true;
        }
    }
}
