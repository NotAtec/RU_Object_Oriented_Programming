package slidingGame;

import java.util.Queue;
import java.util.Collection;
import java.util.List;
import java.util.LinkedList;
import java.lang.StringBuilder;

/**
 * A class that implements a breadth-first search algorithm for finding the
 * Configurations for which the isSolution predicate holds
 */
public class Solver {
	// A queue for maintaining states that are not visited yet.
	private Queue<Configuration> toExamine;
	// A collection of states that have been visited
	private Collection<Configuration> encountered;

	public Solver(Configuration g) {
		toExamine = new PriorityQueue<>();
		toExamine.add(g);
		encountered = new ArrayList<Configuration>();  
	}

	/**
	 * A skeleton implementation of the solver
	 *
	 * @return a string representation of the solution
	 */
	public String solve() {
		while (!toExamine.isEmpty()) {
			Configuration next = toExamine.remove();
			if (next.isSolution()) {
				List<Configuration> path = next.pathFromRoot();
				String solution = makeString(path);
				return solution;
			} else {
				for (Configuration succ : next.successors()) {
					if (!find(encountered, succ)) {
						toExamine.add(succ);
						encountered.add(succ);
					}
				}
			}
		}
		return "Failure!";
	}


	private static boolean find(Collection<Configuration> encountered, Configuration succ) {
		for (Configuration enc : encountered) {
			if (enc.equals(succ)) {
				return true;
			}
		}
		return false;
	}

	private static String makeString(List<Configuration> list) {
		StringBuilder string = new StringBuilder();

		for (Configuration node : list) {
			string.append(node.toString());
		}

		return string.toString();
	}
}
