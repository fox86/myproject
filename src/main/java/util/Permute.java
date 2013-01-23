package util;

import java.util.Arrays;
import java.util.Random;

/**
 * @author kchung
 */
public class Permute {
	/**
	 * Randomly permutes a[]. Could potentially return the same permutation twice.
	 */
	public static int[] randomPermutation(int[] a) {
		//make a copy so that original array is in tact
		int[] acopy = Arrays.copyOf(a, a.length);
		int[] perm = new int[a.length];

		Random random = new Random();

		int p = 0; //points to index that should be used to get new elements
		for (int i = 0; i < a.length; i++){
			int index = p + random.nextInt(a.length - p);
			perm[i] = acopy[index];

			//switch used
			acopy[index] = acopy[p++];
		}

		return perm;
	}
}
