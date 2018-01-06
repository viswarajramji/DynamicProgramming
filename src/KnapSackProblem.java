/**
 * @author viswarajramji
 * 
 * */
public class KnapSackProblem {
	  public static void main(String[] args) {
	        int val[] = {1, 4, 5, 7};
	        int wt[] = {1, 3, 4, 5};
	        int sum = 7;
	        int total[][] = new int[wt.length + 1][sum + 1];
	        for (int i = 0; i <= wt.length; i++) {
	            for (int j = 0; j <= sum; j++) {
	                if (i == 0 || j == 0) {
	                    total[i][j] = 0;
	                } else {
	                    if (j >= wt[i - 1]) {
	                        total[i][j] = Math.max(val[i - 1] + total[i - 1][j - wt[i - 1]], total[i - 1][j]);
	                    } else {
	                        total[i][j] = total[i - 1][j];
	                    }
	                }
	            }
	        }
	        System.out.println(""+total[wt.length][sum]);

	    }
}

