package practise;

/**
 * Sorted Search, No Size: You are given an array-like data structure Listy
 * which lacks a size method. It does, however, have an elementAt ( i) method
 * that returns the element at index i in 0( 1) time. If i is beyond the bounds
 * of the data structure, it returns -1. (For this reason, the data structure
 * only supports positive integers.) Given a Listy which contains sorted,
 * positive integers, find the index at which an element x occurs. If x occurs
 * multiple times, you may return any index.
 * 
 * @author isokhi
 *
 */
public class SortedSearchNoSize {

	static int arr[] = { 10, 20, 30, 40, 50, 60 };

	public static void main(String[] args) {
		int x = 60;
		/**
		 * Brute Force implementation
		 */
		// BruteForce(x);
		/**
		 * Jump Search Implementation
		 */
		BestMethod(x);

	}

	private static void BestMethod(int x) {
		boolean found = false;
		int prev = 0;
		int next = 2;
		while (elementAt(next) != -1) {
			int max = elementAt(next);
			int min = elementAt(prev);
			if (min == x) {
				System.out.println(prev);
				found = true;
				break;
			}
			if (max == x) {
				System.out.println(next);
				found = true;
				break;
			}
			if (max > x && x > min) {
				if (linearSearch(prev + 1, next, x)) {
					found = true;
					break;
				}
			}
			prev = next + 1;
			next *= 2;
		}

		if (!found) {
			while (elementAt(prev) != -1) {
				if (elementAt(prev) == x) {
					System.out.println(prev);
					found = true;
					break;
				}
				prev++;
			}
		}

		if (!found) {
			System.out.println("Not Found");
		}

	}

	private static boolean linearSearch(int prev, int next, int x) {
		for (int i = prev; i < next; i++) {
			if (elementAt(i) == x) {
				System.out.println(i);
				return true;
			}
		}
		return false;

	}

	private static void BruteForce(int x) {
		int i = 0;
		boolean found = false;
		while (elementAt(i) != -1) {
			if (elementAt(i) == x) {
				System.out.println(i);
				found = true;
				break;
			}
			i++;
		}
		if (!found) {
			System.out.println("Not Found");
		}
	}

	public static int elementAt(int index) {
		if (index >= arr.length) {
			return -1;
		}
		return arr[index];
	}
}
