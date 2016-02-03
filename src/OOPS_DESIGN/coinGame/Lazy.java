package OOPS_DESIGN.coinGame;

import java.util.function.Supplier;

/**
 * Lazy boxes. A {@code Lazy&lt;T&gt;} represents a possibly-deferred
 * computation of a value of type {@code T}. The value is computed only once,
 * when first required, and then cached for future accesses. This can be used to
 * implement lazy initialization for other classes.
 */
public final class Lazy<T> implements Supplier<T> {
  private T value;
  private Supplier<T> thunk;

  /**
   * Constructs a {@code Lazy&lt;T&gt;} from the {@code Supplier&lt;T&gt;}
   * that will compute its value.
   *
   * @param thunk the function object for computing the value (non-null)
   */
  public Lazy(Supplier<T> thunk) {
    if (thunk == null) {
      throw new NullPointerException("thunk cannot be null");
    }
    this.value = null;
    this.thunk = thunk;
  }

  /**
   * Constructs an already-forced {@code Lazy&lt;T&gt;} from its value.
   *
   * @param value the value
   */
  public Lazy(T value) {
    this.value = value;
    this.thunk = null;
  }

  /**
   * Has the value of {@code this} been computed yet?
   *
   * @return whether {@code this} has been forced
   */
  public boolean isForced() {
    return thunk == null;
  }

  /**
   * Forces the value to be computed if it hasn't been yet.
   */
  public void force() {
    if (thunk != null) {
      value = thunk.get();
      thunk = null;
    }
  }

  /**
   * Computes the value if necessary, saves it for next time, and
   * returns it.
   *
   * @return the value of the deferred computation
   */
  @Override
  public T get() {
    force();
    return value;
  }
}
