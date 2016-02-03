package OOPS_DESIGN.coinGame;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Simple tests for the {@code Lazy} class.
 */
public class LazyTest {
  int x = 0;
  Lazy<Integer> delayed = new Lazy<>(() -> ++x);
  Lazy<Integer> ready   = new Lazy<>(3);

  // The main idea here is that forcing {@code delayed} has a side effect
  // (updating the {@code x} field). No matter how many times we need the
  // value of {@code delayed}, the forcing (and thus the side effect) should
  // happen at most once.

  @Test
  public void testIsForced_delayed() {
    assertFalse(delayed.isForced());
    delayed.force();
    assertTrue(delayed.isForced());
  }

  @Test
  public void testIsForced_ready() {
    assertTrue(ready.isForced());
  }

  @Test
  public void testForce_delayed() {
    assertEquals(0, x);
    assertFalse(delayed.isForced());
    assertEquals(0, x);
    delayed.force();
    assertEquals(1, x);
    assertTrue(delayed.isForced());
    assertEquals(1, x);
  }

  @Test
  public void testForce_ready() {
    assertTrue(ready.isForced());
    ready.force();
    assertTrue(ready.isForced());
  }

  @Test
  public void testGet_delayed() {
    assertEquals(0, x);
    assertFalse(delayed.isForced());
    assertEquals(0, x);
    assertEquals(1, (int)delayed.get());
    assertEquals(1, x);
    assertTrue(delayed.isForced());
    assertEquals(1, x);
    assertEquals(1, (int)delayed.get());
    assertEquals(1, x);
  }

  @Test
  public void testGet_ready() {
    assertEquals(3, (int)ready.get());
  }
}