package OOPS_DESIGN.timeDurationDesign;

/**
 * Abstract base class for durations. Provides functionality common to
 * both representational subclasses, including comparisons, hashing,
 * addition, subtraction, and the ability to construct new durations of
 * the same class as a given instance.
 */
abstract class AbstractDuration implements Duration {
  protected static final int SECS_IN_DAY = 24 * 60 * 60;

  /**
   * Constructs a new duration having the same class as {@code this}.
   * @param seconds length of the new duration in seconds (non-negative)
   * @return the new duration
   */
  protected abstract Duration fromSeconds(long seconds);

  /**
   * Constructs a new duration having the same class as {@code this}.
   * @param days the days component of the new duration (non-negative)
   * @param hours the hours component of the new duration (non-negative)
   * @param minutes the minutes component of the new duration (non-negative)
   * @param seconds the seconds component of the new duration (non-negative)
   * @return the new duration
   */
  protected abstract Duration fromDHMS(long days, int hours,
                                       int minutes, int seconds);

  /**
   * Adds two durations. The result will have the same (dynamic) class
   * as {@code this}.
   * @param other the duration to add to {@code this}
   * @return the sum of the durations
   */
  @Override
  public Duration plus(Duration other) {
    long result = inSeconds() + other.inSeconds();

    if (result < 0) {
      throw new RuntimeException("Duration overflow");
    }

    return fromSeconds(result);
  }

  /**
   * Subtracts two durations. Returns the zero duration rather than
   * negative. The result will have the same (dynamic) class as {@code
   * this}.
   * @param other the duration to subtract from {@code this}
   * @return the difference of the durations (or zero if {@code this}
   * is shorter than {@code other}).
   */
  @Override
  public Duration minus(Duration other) {
    long result = inSeconds() - other.inSeconds();
    return fromSeconds(result < 0 ? 0 : result);
  }

  @Override
  public int compareTo(Duration other) {
    if (inSeconds() < other.inSeconds()) {
      return -1;
    }

    if (inSeconds() > other.inSeconds()) {
      return 1;
    }

    return 0;
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Duration)) return false;
    return inSeconds() == ((Duration)other).inSeconds();
  }

  @Override
  public int hashCode() {
    return (int) (inSeconds() ^ (inSeconds() >>> 32));
  }
}
