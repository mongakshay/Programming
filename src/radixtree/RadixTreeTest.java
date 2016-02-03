package radixtree;

import org.junit.Test;

import static org.junit.Assert.*;

public class RadixTreeTest {
//
//    @Before
//    public void setUp() throws Exception {
//
//    }
//
//    @After
//    public void tearDown() throws Exception {
//
//    }

    @Test
    public void testLookupPrefixPartial() throws Exception {
        RadixTree tree = new RadixTree();
        RadixTree result;

        result = tree.lookupPrefixPartial("h");
        assertNull(result);

        result = tree.lookupPrefixPartial("hello");
        assertNull(result);

        tree.insert("h");
        result = tree.lookupPrefixPartial("h");
        assertNotNull(result);

        result = tree.lookupPrefixPartial("jekyll");
        assertNull(result);
    }

    @Test
    public void testInsert() throws Exception {
        RadixTree tree = new RadixTree();
        RadixTree result;

        tree.insert("jekyll");
        result = tree.lookupPrefixPartial("jekyll");
        assertNotNull(result);

        result = tree.lookupPrefixPartial("jek");
        assertNotNull(result);

        result = tree.lookupPrefixPartial("fek");
        assertNull(result);

        tree.insert("jekyllrc");
        result = tree.lookupPrefixPartial("jekyll");
        assertNotNull(result);
        assertEquals(result.mChilds.size(), 1);

        result = tree.lookupPrefixPartial("jekyllrc");
        assertNotNull(result);
        assertEquals(result.mValue, "rc");

        // now test splitting part
        result = tree.lookupPrefixPartial("jektra");
        assertNotNull(result);

        tree.insert("jektra");
        result = tree.lookupPrefixPartial("jektra");
        assertNotNull(result);
        assertEquals(result.mValue, "tra");

        result = tree.lookupPrefixPartial("jekyll");
        assertNotNull(result);
        assertEquals(result.mValue, "yll");

        result = tree.lookupPrefixPartial("jek");
        assertEquals(result.mValue, "jek");
        assertEquals(result.mChilds.size(), 2);

    }

    @Test
    public void testLookupPrefix() throws Exception {
        RadixTree tree = new RadixTree();
        RadixTree result;

        result = tree.lookupPrefix("jekyll");
        assertNull(result);

        tree.insert("jekyll");
        result = tree.lookupPrefix("jekyll");
        assertNotNull(result);

        result = tree.lookupPrefix("jekyllrc");
        assertNull(result);

        result = tree.lookupPrefix("jek");
        assertNotNull(result);

        result = tree.lookupPrefix("fek");
        assertNull(result);

        tree.insert("jekyllrc");
        result = tree.lookupPrefix("jekyll");
        assertNotNull(result);
        assertEquals(result.mChilds.size(), 1);

        result = tree.lookupPrefix("jekyllrc");
        assertNotNull(result);
        assertEquals(result.mValue, "rc");

        result = tree.lookupPrefix("jekyllrctw");
        assertNull(result);
    }

    @Test
    public void testChildValues() throws Exception {
        RadixTree tree = new RadixTree();
        tree.insert("romane");
        tree.insert("romanus");
        tree.insert("romulus");
        tree.insert("rubens");
        tree.insert("ruber");
        tree.insert("rubicon");
        tree.insert("rubicundus");

        RadixTree result;

        result = tree.lookupPrefix("rom");
        assertEquals(RadixTree.childValues("", result).size(), 3);

        result = tree.lookupPrefix("rube");
        assertEquals(RadixTree.childValues("", result).size(), 2);

        result = tree.lookupPrefix("roman");
        assertEquals(RadixTree.childValues("", result).size(), 2);

        assertEquals(RadixTree.childValues("", tree).size(), 7);
    }
}