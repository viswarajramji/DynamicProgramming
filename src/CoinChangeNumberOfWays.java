
public class CoinChangeNumberOfWays {
	public static void main(String args[]) {
		int coins[] = { 1, 2, 3 };
		int sum = 5;
		int temp[][] = new int[coins.length + 1][sum + 1];
		for (int i = 0; i < coins.length; i++) {
			temp[i][0] = 1;
		}
		for (int i = 1; i < sum + 1; i++) {
			temp[0][i] = 0;
		}
		for (int i = 1; i <=coins.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (coins[i - 1] <= j) {
					temp[i][j] = (temp[i - 1][j] + temp[i][j - coins[i - 1]]);
				} else {
					temp[i][j] = temp[i - 1][j];
				}
			}
		}
		System.out.println(temp[coins.length][sum]);
	}
}
