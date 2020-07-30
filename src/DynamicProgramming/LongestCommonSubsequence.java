package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static int recursiveLCS(String x, String y, int m, int n){
        if(m==0 || n==0){
            return 0;
        }
        else if(x.charAt(m-1)==y.charAt(n-1)){
            return 1 + recursiveLCS(x,y,m-1,n-1);
        }

        return Math.max(recursiveLCS(x,y,m-1,n),
                        recursiveLCS(x,y,m,n-1)
                );
    }

    public static int memoizedLCS(String x, String y, int m, int n, int[][] memo){

        if(m==0 || n==0){
            return 0;
        }

        if(memo[m][n]!=-1)
            return memo[m][n];

        if(x.charAt(m-1)==y.charAt(n-1)){
            memo[m][n] = 1+memoizedLCS(x,y,m-1,n-1,memo);
            return memo[m][n];
        }

        memo[m][n] = Math.max(
                memoizedLCS(x,y,m-1,n,memo),
                memoizedLCS(x,y,m,n-1,memo)
        );
        return memo[m][n];
    }

    public static int dpLCS(String x, String y, int m, int n){
        int[][] dpLcs = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0){
                    dpLcs[i][j]=0;
                }
                else if(x.charAt(i-1)==y.charAt(j-1)){
                    dpLcs[i][j] = 1 + dpLcs[i-1][j-1];
                }
                else {
                    dpLcs[i][j] = Math.max(dpLcs[i][j-1],dpLcs[i-1][j]);
                }

            }
        }
        return dpLcs[m][n];
    }

    public static String printLCS(String x, String y, int m, int n){
        int[][] dpLcs = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0){
                    dpLcs[i][j]=0;
                }
                else if(x.charAt(i-1)==y.charAt(j-1)){
                    dpLcs[i][j] = 1 + dpLcs[i-1][j-1];
                }
                else {
                    dpLcs[i][j] = Math.max(dpLcs[i][j-1],dpLcs[i-1][j]);
                }

            }
        }
        int i=m;
        int j=n;
        StringBuilder resLCS = new StringBuilder();
        while (i>0 && j>0){
            if(x.charAt(i-1)==y.charAt(j-1)){
                resLCS.append(x.charAt(i-1));
                i--;
                j--;
            }
            else {
                if(dpLcs[i-1][j]>=dpLcs[i][j-1]){
                    i--;
                }
                else{
                    j--;
                }
            }
        }
        return resLCS.reverse().toString();
    }

    public static void main(String[] args) {
        String x = "abcdaf";
        String y = "aecbcf";
        int[][] memo = new int[x.length()+1][y.length()+1];
        for(int i=0; i<memo.length;i++){
            for(int j=0; j<memo[i].length;j++){
                memo[i][j]=-1;
            }
        }
        System.out.println("recursive lcs...");
        System.out.println(recursiveLCS(x,y,x.length(),y.length()));
        System.out.println("memoized lcs...");
        System.out.println(memoizedLCS(x,y,x.length(),y.length(),memo));
        System.out.println("dp lcs...");
        System.out.println(dpLCS(x,y,x.length(),y.length()));
        System.out.println("print lcs......");
        System.out.println(printLCS(x,y,x.length(),y.length()));
    }
}
