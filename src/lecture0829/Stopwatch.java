package lecture0829;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class Stopwatch {
  private ThreadMXBean bean;
  private long startNanos;

  public Stopwatch() {
    bean = ManagementFactory.getThreadMXBean();
  }

  public void start() {
    startNanos = bean.getCurrentThreadCpuTime();
  }

  public double stop() {
    long endNanos = bean.getCurrentThreadCpuTime();
    return (endNanos - startNanos) / 1e9;
  }
}