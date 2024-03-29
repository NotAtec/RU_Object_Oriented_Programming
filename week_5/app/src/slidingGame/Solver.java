package slidingGame;

<<<<<<<<< Temporary merge branch 1
=========
import java.util.*;
>>>>>>>>> Temporary merge branch 2
import java.util.Queue;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.lang.StringBuilder;
import java.util.PriorityQueue;
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
<<<<<<<<< Temporary merge branch 1
=========
		toExamine = new PriorityQueue<>();
		toExamine.add(g);
		encountered = new ArrayList<Configuration>();  
>>>>>>>>> Temporary merge branch 2
		toExamine = new PriorityQueue<Configuration>();
		toExamine.add(g);
		encountered = new HashSet<Configuration>();  
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
<<<<<<<<< Temporary merge branch 1
=========
				return next.toString();
			} else if (!encountered.contains(next)) {
				encountered.add(next);
				for (Configuration succ : next.successors()) {
						toExamine.add(succ);
>>>>>>>>> Temporary merge branch 2
				List<Configuration> path = next.pathFromRoot();
				String solution = makeString(path);
				return solution;
			} else {
				for (Configuration succ : next.successors()) {
					if (!encountered.contains(succ)) {
						toExamine.add(succ);
						encountered.add(succ);
					}
				}
			}
		}
		return "Failure!";
	}

	private static String makeString(List<Configuration> list) {
		StringBuilder string = new StringBuilder();

		for (Configuration node : list) {
			string.append(node.toString());
			string.append("\n");
		}

		return string.toString();
	}
}
