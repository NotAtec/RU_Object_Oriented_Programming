package slidingGame;
/**
 * An interface for representing nodes in a state space.
 */

import java.util.Collection;
import java.util.List;
import java.util.LinkedList;

public interface Configuration extends Comparable<Configuration> {
	/**
	 * To obtain the parent of the current configuration, i.e. the configuration
	 * which had this as one of its successors
	 *
	 * @return a reference to the parent
	 */
	public abstract Configuration getParent();

	/**
	 * To obtain the successors for a specific configuration
	 *
	 * @return a collection of configurations containing the successors
	 */
	public abstract Collection<Configuration> successors();

	/**
	 * For marking final / solution configurations.
	 * @return true if a this is a solution, false otherwise
	 */
	public abstract boolean isSolution();

	/**
	 * To build a path from the root configuration to the current one.
	 *
	 * @return a list of successive configurations from the root to 'this'
	 */
	public default List<Configuration> pathFromRoot() {
<<<<<<<<< Temporary merge branch 1
=========

		throw new UnsupportedOperationException("pathFromRoot: not supported yet.");

>>>>>>>>> Temporary merge branch 2
		List<Configuration> path = new LinkedList<Configuration>();
		path.add(this);
		Configuration step = this;

		while(step.getParent() != null) {
			path.add(step.getParent());
			step = step.getParent();
		}

		return this.reverseList(path);
	}

	private List<Configuration> reverseList(List<Configuration> list) {
		List<Configuration> reversed = new LinkedList<Configuration>();

		for (int i = list.size() - 1; i >= 0; i--) {
			reversed.add(list.get(i));
		}

		return reversed;
	}
}
