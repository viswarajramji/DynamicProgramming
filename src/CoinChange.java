
public class CoinChange {
	public static void main(String args[]) {
		int coins[] = { 7, 2, 3 };
		int sum = 5;
		int total[] = new int[sum + 1];
		total[0] = 0;
		for (int i = 1; i <= sum; i++) {
			total[i] = Integer.MAX_VALUE - 1;
		}
		for (int j = 0; j < coins.length; j++) {
			for (int i = 0; i <= sum; i++) {
				if (coins[j] <= i) {
					total[i] = Math.min(total[i], 1 + total[i - coins[j]]);
				}
			}

		}
		System.out.println(+total[sum]);
	}
}
