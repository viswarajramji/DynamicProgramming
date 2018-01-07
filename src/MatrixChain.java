
public class MatrixChain {
	public int findCost(int[] arr) {
		int temp[][] = new int[arr.length][arr.length];
		for (int l = 2; l < arr.length; l++) {
			for (int i = 0; i < arr.length-l; i++) {
				int j = i + l;
				temp[i][j] = 1000000;
				for (int k = i + 1; k < j; k++) {
					int q = temp[i][k] + temp[k][j] + (arr[i] * arr[j] * arr[k]);
					if (temp[i][j] > q) {
						temp[i][j] = q;
					}
				}
			}
		}
		return temp[0][arr.length-1];
	}

	public static void main(String args[]) {
		MatrixChain mmc = new MatrixChain();
		int arr[] = { 4, 2, 3, 5, 3 };
		int cost = mmc.findCost(arr);
		System.out.print(cost);
	}

}
