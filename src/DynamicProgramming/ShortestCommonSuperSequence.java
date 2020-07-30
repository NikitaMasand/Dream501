package DynamicProgramming;

public class ShortestCommonSuperSequence {
    public static int findLenLCS(String x, String y) {
        int m = x.length();
        int n = y.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                if(i==0 || j==0){
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
    public static void main(String[] args) {
        String x = "AGGTAB";
        String y = "GXTXAYB";

        int lcslen = findLenLCS(x,y);
        //as lcs will be present two times in x+y string, thus subtracting it once.
        //that is the best seq we can subtract to get scs
        //scs: AGGXTXAYB
        int scslen = x.length()+y.length()-lcslen;
        System.out.println("Length of scs..");
        System.out.println(scslen);

    }
}
