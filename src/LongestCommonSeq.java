
public abstract class LongestCommonSeq {
   public static void main(String args[])
   {
	   char a[]={'a','b','c','e','f'};
	   char b[]={'a','b','e','f'};
	   int total[][]=new int[a.length+1][b.length+1];
	   for(int i=0;i<=a.length;i++)
	   {
		   for(int j=0;j<=b.length;j++)
		   {
			   if(i==0|| j==0)
                  total[i][j]=0;
			   else
			   {
				   if(a[i-1]==b[j-1])
				   {
					   total[i][j]=total[i-1][j-1]+1;
				   }
				   else
				   {
					   total[i][j]=Math.max(total[i][j-1],total[i-1][j]);
				   }
			   }
		   }
	   }
	   System.out.println("longest SubSquence="+total[a.length][b.length]);
   }
}
