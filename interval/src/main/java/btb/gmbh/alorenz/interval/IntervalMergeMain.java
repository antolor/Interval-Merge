package btb.gmbh.alorenz.interval;

import java.util.Arrays;
import java.util.List;

import btb.gmbh.alorenz.interval.pojo.Interval;
import btb.gmbh.alorenz.interval.service.IntervalMergeService;

/**
 * Main class of the program for merging lists of intervals.
 * 
 * @author Antony Lorenz
 *
 */
public class IntervalMergeMain {

	private static final long MEGABYTE = 1024L * 1024L;

	public static void main(String[] args) {

		IntervalMergeService intervalMergeService = new IntervalMergeService();

		List<Interval> intervalsToMergeList = Arrays.asList(new Interval(25, 30), new Interval(2, 19),
				new Interval(14, 23), new Interval(4, 8));

		// Merge the given list of intervals.
		List<Interval> mergedIntervalList = intervalMergeService.mergeIntervals(intervalsToMergeList);

		// Print intervals before and after merge.
		System.out.println("Input: " + intervalMergeService.buildResultString(intervalsToMergeList));
		System.out.println("Output: " + intervalMergeService.buildResultString(mergedIntervalList));

		Runtime runtime = Runtime.getRuntime();
		double totalMemory = runtime.totalMemory() / MEGABYTE;
		double blockedMemory = totalMemory - runtime.freeMemory() / MEGABYTE;

		//Print memory usage.
		System.out.println("Available memory in megabytes: " + totalMemory);
		System.out.println("Memory used by the program in megabytes: " + blockedMemory);
		System.out.println("Available memory in megabytes: " + totalMemory);
	}
}
