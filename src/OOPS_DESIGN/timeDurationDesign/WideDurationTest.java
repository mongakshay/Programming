package OOPS_DESIGN.timeDurationDesign;

public class WideDurationTest extends AbstractDurationTest {
  @Override
  protected AbstractDuration zero() {
    return new WideDuration(0);
  }
}