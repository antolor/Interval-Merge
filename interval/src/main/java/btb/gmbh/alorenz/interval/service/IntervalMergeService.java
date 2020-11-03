package btb.gmbh.alorenz.interval.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import btb.gmbh.alorenz.interval.pojo.Interval;

/**
 * Class for handling the merging process of given intervals.
 * 
 * @author Antony Lorenz
 *
 */
public class IntervalMergeService {

	/**
	 * Method for merging a given list of intervals.
	 * 
	 * @param intervalsToMergeList
	 *            {@link List} of {@link Integer}
	 * @return {@link List} of {@link Integer}
	 */
	public List<Interval> mergeIntervals(List<Interval> intervalsToMergeList) {
		List<Interval> mergedIntervalList = new ArrayList<>();

		// Check if the given list contains more than one interval.
		if (intervalsToMergeList.size() <= 1) {
			return mergedIntervalList;
		}

		// Sort the intervals in increasing order of beginning time
		List<Interval> sortedIntervalList = intervalsToMergeList.stream()
				.sorted(Comparator.comparingInt(Interval::getBeginning)).collect(Collectors.toList());

		// After sorting, start merging process with the interval with the smallest beginning-number.
		Interval pre = sortedIntervalList.get(0);
		for (Interval currentInterval : sortedIntervalList) { 
			
			// Check if all overlapping intervals have been merged
			if (currentInterval.getBeginning() > pre.getEnding()) {
				mergedIntervalList.add(pre);
				pre = currentInterval;
			} else {
				// Intervals are overlapping, so they get merged
				pre = new Interval(pre.getBeginning(),
						Math.max(pre.getEnding(), currentInterval.getEnding()));
			}
		}
		mergedIntervalList.add(pre);

		return mergedIntervalList;
	}

	/**
	 * Method for building a formatted String with the given list of intervals.
	 * 
	 * @param intervalList
	 *            {@link List}
	 * @return {@link String}
	 */
	public String buildResultString(List<Interval> intervalList) {
		StringBuilder stringBuilder = new StringBuilder();

		intervalList.forEach(interval -> 
			stringBuilder.append("[").append(interval.getBeginning()).append(",").append(interval.getEnding())
					.append("]"));

		return stringBuilder.toString();
	}
}
