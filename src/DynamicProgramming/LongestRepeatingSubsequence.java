package DynamicProgramming;

public class LongestRepeatingSubsequence {
    public static int longestRepeatingSubsequence(String x, String y){
        int m = x.length();
        int n = y.length();

        int[][]dp = new int[m+1][n+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
                else if(x.charAt(i-1)==y.charAt(j-1) && i!=j){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String x = "AABEBCDD";
        System.out.println("length of longest repeating subsequence...");
        System.out.println(longestRepeatingSubsequence(x,x));
    }
}
