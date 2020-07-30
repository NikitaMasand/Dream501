package DynamicProgramming;

public class PrintShortestCommonSupersequence {
    public static String scs(String x, String y) {
        int m = x.length();
        int n = y.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if (i==0||j==0) {
                    dp[i][j]=Integer.MAX_VALUE;
                }
                else if(i==1 || j==1){
                    if(i==1){
                        dp[i][j]=j;
                    }
                    else {
                        dp[i][j]=i;
                    }
                }
                else if(x.charAt(i-1)==y.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else {
                    dp[i][j]=1+Math.min(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

        StringBuilder res = new StringBuilder();
        int i = m;
        int j = n;
        while (i>0 && j>0){
            if(x.charAt(i-1)==y.charAt(j-1)){
                res.append(x.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i][j-1]<=dp[i-1][j]){
                    res.append(y.charAt(j-1));
                    j--;
                }
                else{
                    res.append(x.charAt(i-1));
                    i--;
                }
            }
        }
        return res.reverse().toString();
    }
    public static void main(String[] args) {
        String x = "acbcf";
        String y = "abcdaf";
        System.out.println("shortest common superseq...");
        System.out.println(scs(x,y));
    }
}
