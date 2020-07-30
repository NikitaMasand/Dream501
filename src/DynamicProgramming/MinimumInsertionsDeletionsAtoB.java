package DynamicProgramming;

public class MinimumInsertionsDeletionsAtoB {
    public static int lenLCS(String x, String y) {
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
                else {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        String x="heap";
        String y="pea";
        int lcslen = lenLCS(x,y);

        //heap-->ea
        int minDeletions = y.length()-lcslen;
        //ea-->pea
        int minInsertions = x.length()-lcslen;
        System.out.println("minInsertions: "+minInsertions);
        System.out.println("minDeletions: "+minDeletions);
    }

}
