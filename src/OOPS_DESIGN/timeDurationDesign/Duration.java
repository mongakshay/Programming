package OOPS_DESIGN.timeDurationDesign;

/**
 * Durations, in seconds. All durations are non-negative.
 */
public interface Duration extends Comparable<Duration> {
  /**
   * Formats a duration as a string, based on the template. The template
   * is a string that may contain both uninterpreted characters and
   * <i>format specifiers</i>; this method returns a copy of the
   * template string in which the format specifiers are replaced by
   * representations of the indicated value for {@code this} duration,
   * and all other characters are copied as-is.
   *
   * <p>In cases where multiple format specifiers overlap (<i>e.g.,</i>
   * {@code "%%t"}), the leftmost specifiers take precedence (so the
   * result would be {@code "%t"}).
   *
   * <table>
   *   <thead>
   *     <tr>
   *       <th>Format Specifier</th>
   *       <th>Meaning</th>
   *     </tr>
   *   </thead>
   *   <tr><td>{@code %t}</td><td>the whole duration in seconds</td></tr>
   *   <tr><td>{@code %d}</td><td>the days component of the decomposed
   *     duration</td></tr>
   *   <tr><td>{@code %h}</td><td>the hours component of the decomposed
   *     duration</td></tr>
   *   <tr><td>{@code %H}</td><td>the hours component of the decomposed
   *     duration, padded to 2 digits with leading zeros (<i>e.g.</i>,
   *     {@code 05} or {@code 11})</td></tr>
   *   <tr><td>{@code %m}</td><td>the minutes component of the decomposed
   *     duration</td></tr>
   *   <tr><td>{@code %M}</td><td>the minutes component of the decomposed
   *     duration, padded to 2 digits with leading zeros (<i>e.g.</i>,
   *     {@code 05} or {@code 56})</td></tr>
   *   <tr><td>{@code %s}</td><td>the seconds component of the decomposed
   *     duration</td></tr>
   *   <tr><td>{@code %S}</td><td>the seconds component of the decomposed
   *     duration, padded to 2 digits with leading zeros (<i>e.g.</i>,
   *     {@code 05} or {@code 56})</td></tr>
   *   <tr><td>{@code %%}</td><td>a literal percent sign ({@code %})</td></tr>
   *   <caption>Format specifiers</caption>
   * </table>
   *
   * @param template the template
   * @return the formatted string
   */
  // String format(String template);

  /**
   * Gets the total duration in seconds.
   * @return the number of seconds (non-negative)
   */
  long inSeconds();

  /**
   * Gets the days component of the duration expressed as days, hours, minutes,
   * and seconds.
   * @return the number of days (non-negative)
   */
  public long getDays();

  /**
   * Gets the hours component of the duration expressed as days, hours, minutes,
   * and seconds.
   * @return the number of hours (0 .. 23)
   */
  public int getHours();

  /**
   * Gets the minutes component of the duration expressed as days, hours,
   * minutes, and seconds.
   * @return the number of minutes (0 .. 59)
   */
  public int getMinutes();

  /**
   * Gets the seconds component of the duration expressed as days, hours,
   * minutes, and seconds.
   * @return the number of seconds (0 .. 59)
   */
  public int getSeconds();

  /**
   * Adds two durations.
   * @param other the duration to add to {@code this}
   * @return the sum of the durations
   */
  public Duration plus(Duration other);

  /**
   * Subtracts two durations. Returns the zero duration rather than
   * negative.
   * @param other the duration to subtract from {@code this}
   * @return the difference of the durations (or zero if {@code this}
   * is shorter than {@code other}).
   */
  public Duration minus(Duration other);
}
