package OOPS_DESIGN.timeDurationDesign;

/**
 * Durations in seconds, represented compactly.
 */
public final class PackedDuration extends AbstractDuration {
  private final long seconds;

  /**
   * Construct a duration in terms of its length in seconds.
   * @param seconds the number of seconds (non-negative)
   */
  public PackedDuration(long seconds) {
    if (seconds < 0) {
      throw new IllegalArgumentException("duration must be non-negative");
    }
    this.seconds = seconds;
  }

  /**
   * Construct a duration in terms of its length in (standard) days, hours,
   * minutes, and seconds.
   * @param days the number of days (non-negative)
   * @param hours the number of hours (non-negative)
   * @param minutes the number of minutes (non-negative)
   * @param seconds the number of seconds (non-negative)
   */
  public PackedDuration(long days, int hours, int minutes, int seconds) {
    // WideDuration constructor will validate for us.
    this.seconds = new WideDuration(days, hours, minutes, seconds).inSeconds();
  }

  @Override
  protected Duration fromSeconds(long seconds) {
    return new PackedDuration(seconds);
  }

  @Override
  protected Duration fromDHMS(long days, int hours, int minutes, int seconds) {
    return new PackedDuration(days, hours, minutes, seconds);
  }

  @Override
  public long inSeconds() {
    return seconds;
  }

  @Override
  public long getDays() {
    return seconds / SECS_IN_DAY;
  }

  @Override
  public int getHours() {
    return (int)(seconds % SECS_IN_DAY) / 3600;
  }

  @Override
  public int getMinutes() {
    return (int)(seconds % 3600) / 60;
  }

  @Override
  public int getSeconds() {
    return (int)(seconds % 60);
  }

  @Override
  public String toString() {
    return "PackedDuration{" +
        "seconds=" + seconds +
        '}';
  }
}
