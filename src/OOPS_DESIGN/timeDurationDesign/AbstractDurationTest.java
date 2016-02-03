package OOPS_DESIGN.timeDurationDesign;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Defines tests for {@code AbstractDuration}s, without knowing or caring
 * which concrete implementation is being tested. We can then subclass
 * this and override the {@code zero} method to specify how to obtain a
 * zero duration for the class we would like to test.
 */
public abstract class AbstractDurationTest {
  /**
   * Gets the zero duration of the class to test.
   * @return the zero duration
   */
  protected abstract AbstractDuration zero();

  /**
   * Helps by constructing durations of the appropriate class.
   * @param s duration in seconds
   * @return duration of the appropriate class
   */
  private Duration fromSeconds(long s) {
    return zero().fromSeconds(s);
  }

  /**
   * Helps by constructing durations of the appropriate class.
   * @param d days component of duration
   * @param h hours component of duration
   * @param m minutes component of duration
   * @param s seconds component of duration
   * @return duration of the appropriate class
   */
  private Duration fromDHMS(long d, int h, int m, int s) {
    return zero().fromDHMS(d, h, m, s);
  }

  /*
  @Test
  public void testFormatExample1() {
    assertEquals("3 days, 4 hours, 0 minutes, and 9 seconds",
                 fromDHMS(3, 4, 0, 9)
                   .format("%d days, %h hours, %m minutes, and %s seconds"));

  @Test
  public void testFormatExample2() {
    assertEquals("4:05:17",
                 fromDHMS(0, 4, 5, 17).format("%h:%M:%S"));
  }
  */

  static long s1 = 8049283294L;
  static long s2 = 328375982;
  static long s3111459 = 299699;

  @Test
  public void testGetDays() {
    assertEquals(4, fromDHMS(4, 22, 9, 19).getDays());
    assertEquals(3, fromSeconds(s3111459).getDays());
  }

  @Test
  public void testGetHours() {
    assertEquals(22, fromDHMS(4, 22, 9, 19).getHours());
    assertEquals(11, fromSeconds(s3111459).getHours());
  }

  @Test
  public void testGetMinutes() {
    assertEquals(9, fromDHMS(4, 22, 9, 19).getMinutes());
    assertEquals(14, fromSeconds(s3111459).getMinutes());
  }

  @Test
  public void testGetSeconds() {
    assertEquals(19, fromDHMS(4, 22, 9, 19).getSeconds());
    assertEquals(59, fromSeconds(s3111459).getSeconds());
  }

  @Test
  public void testPlus() {
    assertEquals(fromSeconds(s2), fromSeconds(0).plus(fromSeconds(s2)));
    assertEquals(fromSeconds(s1), fromSeconds(s1).plus(fromSeconds(0)));
    assertEquals(fromSeconds(s1 + s2), fromSeconds(s1).plus(fromSeconds(s2)));
  }

  @Test
  public void testMinus() {
    assertEquals(fromSeconds(s1), fromSeconds(s1).minus(fromSeconds(0)));
    assertEquals(fromSeconds(s1 - s2), fromSeconds(s1).minus(fromSeconds(s2)));
  }

  @Test
  public void testMinus_lowerBound() {
    assertEquals(fromSeconds(0), fromSeconds(0).minus(fromSeconds(s2)));
    assertEquals(fromSeconds(0), fromSeconds(s2).minus(fromSeconds(s1)));
  }

  @Test
  public void testEquals_packed() {
    assertEquals(fromSeconds(s1), new PackedDuration(s1));
  }

  @Test
  public void testEquals_wide() {
    assertEquals(fromSeconds(s1), new WideDuration(s1));
  }

  @Test
  public void testNormalization() {
    assertEquals(fromDHMS(235, 27, 12, 72), fromDHMS(236, 3, 13, 12));
    assertEquals(fromDHMS(0, 47, 45, 903), fromDHMS(2, 0, 0, 3));
  }
}
