import util.AssortedMethods;

/**
 * @author kchung
 */
public class MaxSubMatrix {
	public static void main(String[] args) {
		int[][] matrix = AssortedMethods.randomMatrix(10, 10, -5, 5);
		AssortedMethods.printMatrix(matrix);
		System.out.println(findMax(matrix));
	}

	public static int findMax(int[][] matrix) {
		int[][] ps = buildPartialSumMatrix(matrix);
		System.out.println("partial sum matrix");
		AssortedMethods.printMatrix(ps);

		int maxSum = Integer.MIN_VALUE;
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				for (int i2 = i; i2 < matrix.length; i2++){
					for (int j2 = j; j2< matrix[i2].length; j2++){
						int currSum;
						if(i==0 && j==0){
							currSum = ps[i2][j2];
						} else if(i==0){
							currSum = ps[i2][j2] - ps[i][j - 1];
						} else if(j==0){
							currSum = ps[i2][j2] - ps[i-1][j];
						} else{
							currSum = ps[i2][j2] - ps[i2][j - 1] - ps[i - 1][j2] + ps[i][j];
						}

						if(currSum > maxSum){
							System.out.println("Max found at (" + i + ", " + j + ") and ("+ i2 + ", " + j2 + ")");
							maxSum = currSum;

						}
					}
				}
			}
		}
		return maxSum;
	}

	public static int[][] buildPartialSumMatrix(int[][] matrix) {
		int[][] s = new int[matrix.length][matrix[0].length];

		for(int i=0; i< matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				if (i == 0 && j == 0){
					s[i][j] = matrix[i][j];
				} else{
					if(i==0){//first row
						s[i][j] = s[i][j - 1] + matrix[i][j];
					} else if(j==0){ //first col
						s[i][j] = s[i - 1][j] + matrix[i][j];
					} else{
						s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + matrix[i][j];
					}
				}
			}
		}
		return s;
	}
}
