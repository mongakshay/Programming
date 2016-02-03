package OOPS_DESIGN.timeDurationDesign;

/**
 * Durations in seconds, represented less compactly.
 */
public final class WideDuration extends AbstractDuration {
  private final long days;
  private final int hours;
  private final int minutes;
  private final int seconds;

  /**
   * Constructs a duration in terms of its length in days, hours,
   * minutes, and seconds.
   * @param days the number of days (non-negative)
   * @param hours the number of hours (non-negative)
   * @param minutes the number of minutes (non-negative)
   * @param seconds the number of seconds (non-negative)
   */
  public WideDuration(long days, int hours, int minutes, int seconds) {
    if (days < 0 || hours < 0 || minutes < 0 || seconds < 0) {
      throw new IllegalArgumentException("Duration components must be non-negative");
    }

    if (seconds > 59) {
      minutes += seconds / 60;
      seconds %= 60;
    }

    if (minutes > 59) {
      hours += minutes / 60;
      minutes %= 60;
    }

    if (hours > 24) {
      days += hours / 24;
      hours %= 24;
    }

    this.days = days;
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
  }

  /**
   * Constructs a duration in terms of its length in seconds.
   * @param inSeconds the number of seconds (non-negative)
   */
  public WideDuration(long inSeconds) {
    if (inSeconds < 0) {
      throw new IllegalArgumentException("Durations must be non-negative");
    }

    Duration temp = new PackedDuration(inSeconds);
    days = temp.getDays();
    hours = temp.getHours();
    minutes = temp.getMinutes();
    seconds = temp.getSeconds();
  }

  @Override
  protected Duration fromSeconds(long seconds) {
    return new WideDuration(seconds);
  }

  @Override
  protected Duration fromDHMS(long days, int hours, int minutes, int seconds) {
    return new WideDuration(days, hours, minutes, seconds);
  }

  @Override
  public long inSeconds() {
    return SECS_IN_DAY * days + 3600 * hours + 60 * minutes + seconds;
  }

  @Override
  public long getDays() {
    return days;
  }

  @Override
  public int getHours() {
    return hours;
  }

  @Override
  public int getMinutes() {
    return minutes;
  }

  @Override
  public int getSeconds() {
    return seconds;
  }

  @Override
  public String toString() {
    return "WideDuration{" +
        "days=" + days +
        ", hours=" + hours +
        ", minutes=" + minutes +
        ", seconds=" + seconds +
        '}';
  }
}
