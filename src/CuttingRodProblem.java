
public class CuttingRodProblem {
	public static void main(String args[]) {
		int len = 5;
		int lens[] = new int[] { 1, 2, 3, 4 };
		int cost[] = new int[] { 2, 5, 7, 8 };
		int temp[][] = new int[lens.length + 1][len + 1];
		for (int i = 0; i <= lens.length; i++) {
			for (int j = 0; j <= len; j++) {
				if (i == 0 || j == 0)
					temp[i][j] = 0;
				else {
					if (j >= lens[i - 1]) {
						temp[i][j] = Math.max(temp[i - 1][j], cost[i - 1] + temp[i][j - lens[i - 1]]);
					} else {
						temp[i][j] = temp[i - 1][j];
					}
				}
			}
		}
		System.out.println(temp[lens.length][len]);
	}

}
