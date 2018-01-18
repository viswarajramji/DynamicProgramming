
public class TextClassification {
	public static void main(String args[]) {
		String[] words = {"Tushar","roy","likes","to","code"};
		int width = 10;
		TextClassification tc = new TextClassification();
		tc.performTextOperation(width, words);
	}

	void performTextOperation(int width, String words[]) {
		int min[] = new int[words.length];
		int result[] = new int[words.length];
		int temp[][] = new int[words.length][words.length];
		for (int i = 0; i < words.length; i++) {
			temp[i][i] = width - words[i].length();
			for (int j = i + 1; j < words.length; j++) {
				temp[i][j] = temp[i][j - 1] - words[j].length() - 1;
			}
		}

		for (int i = 0; i < words.length; i++) {
			for (int j = i; j < words.length; j++) {
				if (temp[i][j] < 0) {
					temp[i][j] = Integer.MAX_VALUE;
				} else {
					temp[i][j] = (int) Math.pow(temp[i][j], 2);
				}
			}
		}

		for (int i = words.length - 1; i >= 0; i--) {
			min[i] = temp[i][words.length - 1];
			result[i] = words.length;
			for (int j = words.length - 1; j > i; j--) {
				if (temp[i][j - 1] == Integer.MAX_VALUE) {
					continue;
				}
				if (min[i] > min[j] + temp[i][j - 1]) {
					min[i] = (min[j] + temp[i][j - 1]);
					result[i] = j;
				}
			}
		}

		int i = 0;
		int j = 0;
		do {
			j = result[i];
			for (int k = i; k < j; k++) {
				System.out.println(words[k]);
			}
			i = j;
		} while (i < words.length - 1);

	}
}
