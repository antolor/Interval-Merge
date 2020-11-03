package btb.gmbh.alorenz.interval.pojo;

/**
 * POJO class representing an interval with a beginning and an ending.
 * 
 * @author Antony Lorenz
 */
public class Interval {

	/**
	 * Beginning of the interval
	 */
	private int beginning;

	/**
	 * Ending of the interval
	 */
	private int ending;

	/**
	 * {@link Constructor}
	 * 
	 * @param beginning {@link Integer}
	 * @param ending {@link Integer}
	 */
	public Interval(int beginning, int ending) {
		this.beginning = beginning;
		this.ending = ending;
	}

	/**
	 * Accessor for "beginning"
	 * 
	 * @return beginning {@link Integer}
	 */
	public int getBeginning() {
		return beginning;
	}

	/**
	 * Mutator for "beginning"
	 * 
	 * @param beginning {@link Integer}
	 */
	public void setBeginning(int beginning) {
		this.beginning = beginning;
	}

	/**
	 * Accessor for "ending"
	 * 
	 * @return ending {@link Integer}
	 */
	public int getEnding() {
		return ending;
	}

	/**
	 * Mutator for "ending"
	 * 
	 * @param ending {@link Integer}
	 */
	public void setEnding(int ending) {
		this.ending = ending;
	}

}
