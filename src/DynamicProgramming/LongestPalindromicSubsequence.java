package DynamicProgramming;

public class LongestPalindromicSubsequence {

    public static int LCS(String x, String y){
        int m = x.length();
        int n = y.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
                else if(x.charAt(i-1)==y.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static String reverse(String x){
        StringBuilder y = new StringBuilder();
        for(int i=x.length()-1; i>=0; i--){
            y.append(x.charAt(i));
        }
        return y.toString();
    }

    public static void main(String[] args) {
      String x = "agbcba";
      String y = reverse(x);
       //agbcba
        //abcbga

        System.out.println("length of lps..");
        System.out.println(LCS(x,y));
    }
}
