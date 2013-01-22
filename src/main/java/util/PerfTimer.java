package util;

/**
 * @author kchung
 */
public class PerfTimer<T> {
	private long start;
	private long finish;

	public PerfTimer(){

	}

	public void start() {
		start = System.nanoTime();
	}

	public void finish() {
		finish = System.nanoTime();
		System.out.println((finish - start) * 1d/1000000d);
	}
}
