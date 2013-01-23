import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;

/**
 * @author kchung
 */
public class Permutation {
	public static void main(String[] args) {


		permute(new ArrayList<Integer>(), ImmutableSet.of(1, 2, 3));
	}

	/**
	 * Returns a list of all permutations of numbers 1 to n.
	 * @param n
	 * @return
	 */
	public static List<List<Integer>> allPermutations(int n){
		List<Integer> elements = new ArrayList<Integer>();
		for(int i=0; i<n ;i++){
			elements.add(i);
		}

		return permute(elements, n);
	}

	public static List<List<Integer>> permute(List<Integer> elements, int end){
		if(end == 1){
			ArrayList<Integer> perm = new ArrayList<Integer>();
			perm.add(elements.get(0));
			List<List<Integer>> allperms = new ArrayList<List<Integer>>();
			allperms.add(perm);
			return allperms;
		} else{
			List<List<Integer>> perms = permute(elements, end - 1);
			List<List<Integer>> newPerms = new ArrayList<List<Integer>>();
			for(List<Integer> perm: perms){
				for (int i = 0; i < end; i++){
					List<Integer> newPerm = new ArrayList<Integer>(perm);
					newPerm.add(i, elements.get(end-1));
					newPerms.add(newPerm);
				}
			}
			return newPerms;
		}
	}


	public static void permute(List<Integer> partialPerm, Set<Integer> allElements) {

		//process solution
		if(partialPerm.size() == allElements.size()){
			System.out.println(Joiner.on(",").join(partialPerm));
		} else{
			for(Integer c: getCandidates(partialPerm, allElements)){
				partialPerm.add(c);
				permute(partialPerm, allElements);
				partialPerm.remove(partialPerm.size() - 1);
			}
		}
	}

	private static List<Integer> getCandidates(List<Integer> partialPerm, Set<Integer> allElements) {
		List<Integer> candidates = new ArrayList<Integer>();
		for (Integer c : allElements){
			if(!partialPerm.contains(c)){
				candidates.add(c);
			}
		}
		return candidates;
	}
}
