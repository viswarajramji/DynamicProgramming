public class EggDropingProblem {

	public int calculate(int eggs, int floors) {
		int temp[][] = new int[eggs + 1][floors + 1];
		for (int i = 0; i <= floors; i++) {
			temp[1][i] = i;
		}
		for (int e = 2; e <= eggs; e++) {
			for (int f = 1; f <= floors; f++) {
				temp[e][f] = Integer.MAX_VALUE;
				for (int k = 1; k <= f; k++) {
					int c = 1 + Math.max(temp[e - 1][k - 1], temp[e][f - k]);
					if (temp[e][f] > c) {
						temp[e][f] = c;
					}
				}
			}
		}
		return temp[eggs][floors];
	}

	public static void main(String args[]) {
		EggDropingProblem egg = new EggDropingProblem();
		System.out.println(egg.calculate(2, 5));

	}

}