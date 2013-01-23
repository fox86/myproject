import java.util.Arrays;
import java.util.Random;

/**
 * @author kchung
 */
public class RandomMfromN {
	public static void main(String[] args) {
		int[] n = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] ints = mIntFromN(9, n);
		System.out.println(Arrays.toString(ints));
	}

	public static int[] mIntFromN(int m, int[] narray) {
		int[] rand = new int[m];

		for(int i=0; i<m; i++){
			int randIndex = chooseRandomIndex(narray, i);
			int random = narray[randIndex];
			rand[i] = random;
			narray[randIndex] = narray[i];
		}

		return rand;
	}


	public static int chooseRandomIndex(int[] narray, int startIndex) {
		Random random = new Random();
		return startIndex  + random.nextInt(narray.length - startIndex);
	}
}
