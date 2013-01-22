import java.util.Arrays;
import java.util.Random;

/**
 * @author kchung
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] a = {5,1,3,2, 4, 4};
		sort(a);
		System.out.println(Arrays.toString(a));
	}
	public static void sort(int[] a) {
		quickSort(a, 0, a.length-1);
	}

	public static void quickSort(int[] a, int start, int end){
		if(start >= end){

		} else{
			int piv = chosePivot(a, start, end);
			piv = rearrange(a, start, end, piv);
			quickSort(a, start, piv-1);
			quickSort(a, piv+1,  end);
		}
	}

	private static int rearrange(int[] a, int start, int end, int piv) {
		//swap last and piv
		int temp = a[end];
		a[end] = a[piv];
		a[piv] = temp;

		int firstHigh = start;
		for (int i = start; i < end; i++){
			if(a[i] < a[end]){
				int tmp = a[firstHigh];
				a[firstHigh] = a[i];
				a[i] = tmp;
				firstHigh++;
			} else{

			}
		}
		//swap piv and firstHigh
		temp = a[firstHigh];
		a[firstHigh] = a[end];
		a[end] = temp;
		return firstHigh;
	}

	public static int chosePivot(int[] a, int start, int end) {
		Random rand = new Random();
		int piv = rand.nextInt(end - start + 1);
		return piv + start;
	}

}
