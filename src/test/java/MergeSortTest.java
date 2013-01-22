import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author kchung
 */
public class MergeSortTest {
	@Test
	public void testMergeSort() throws Exception {
		double msconv = 1d / 1000000d;
		int size = 10;
		Random r = new Random();

		int[] array = new int[size];
		for (int i = 0; i < size; i++){
			array[i] = r.nextInt(10);
		}

		int[] control = Arrays.copyOf(array, array.length);
		int[] source = Arrays.copyOf(array, array.length);

		long start = System.nanoTime();
		Arrays.sort(control);
		long end = System.nanoTime();
		System.out.println((end - start) * msconv);

		start = System.nanoTime();
		MergeSort.sort(source);
		end = System.nanoTime();
		System.out.println((end - start) * msconv);

		assertArrayEquals(control, source);
	}
}
