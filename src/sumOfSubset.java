
public class sumOfSubset {
	public static void main(String args[]) {
		int arr[] = { 1, 2, 4, 9 };
		int sum = 8;
		boolean temp[][] = new boolean[arr.length + 1][sum + 1];
		for (int i = 1; i < sum + 1; i++) {
			temp[0][i] = false;
		}
		for (int j = 0; j < arr.length + 1; j++) {
			temp[j][0] = true;
		}
		for (int i = 1; i < arr.length + 1; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i - 1] <= j) {
					temp[i][j] = (temp[i - 1][j] || temp[i - 1][j - arr[i - 1]]);

				} else {
					temp[i][j] = temp[i - 1][j];
				}
			}
		}
		System.out.println(temp[arr.length][sum]);
	}
}
