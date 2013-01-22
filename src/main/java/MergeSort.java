import java.util.Arrays;

/**
 * @author kchung
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] a = {5, 4, 3, 2, 1};
		sort(a);
		System.out.println(Arrays.toString(a));
	}
	public static void sort(int[] a) {
		mergeSort(a, 0, a.length - 1);
	}

	public static void mergeSort(int[] a, int start, int end) {
		if (start >= end){

		} else{
			int mid = (start + end) / 2;
			mergeSort(a, start, mid);
			mergeSort(a, mid + 1, end);
			merge(a, start, mid, end);
		}
	}

	public static void merge(int[] a, int start, int mid, int end) {

		int[] left = copyArray(a, start, mid);
		int[] right = copyArray(a, mid + 1, end);

		int lp = 0;
		int rp = 0;
		for (int i = start; i <= end; i++){
			if (lp >= left.length){
				a[i] = right[rp++];
			} else if (rp >= right.length){
				a[i] = left[lp++];
			} else{
				if (left[lp] < right[rp]){
					a[i] = left[lp++];
				} else{
					a[i] = right[rp++];
				}
			}
		}
	}

	public static int[] copyArray(int[] a, int start, int end) {
		int[] copy = new int[end - start + 1];
		System.arraycopy(a, start, copy, 0, copy.length);
		return copy;
	}
}
