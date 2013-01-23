package util;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author kchung
 */
public class PermuteTest {
	@Test
	public void testRandomPermutation() throws Exception {
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] perm = Permute.randomPermutation(a);
		Set<Integer> aset = convertToSet(a);
		Set<Integer> permset = convertToSet(perm);
		assertEquals(aset, permset);
	}

	private static Set<Integer> convertToSet(int[] a) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i: a){
			set.add(i);
		}
		return set;
	}
}
