package DynamicProgramming;

public class Knapsack {
    public static int recursiveKnapsack(int[] wt, int[] val, int W, int n){
        if(W==0 || n==0) {
            return 0;
        }
        if(wt[n-1]<=W){
            return Math.max(recursiveKnapsack(wt,val,W,n-1),
                    val[n-1]+recursiveKnapsack(wt,val,W-wt[n-1],n-1));
        }
        else{
            return recursiveKnapsack(wt,val,W,n-1);
        }
    }

    public static int dpKnapsack(int[] wt, int[] val, int W, int n) {
        int dp[][] = new int[n+1][W+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=W; j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }

                else if(wt[i-1]<=j){
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i-1][j-wt[i-1]]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String args[]){
        int[] wt = {2,3,4,5};
        int[] val = {1,2,5,6};

        System.out.println("recursive knapsack...");
        System.out.println(recursiveKnapsack(wt,val,8,4));

        System.out.println("dp knapsack...");
        System.out.println(dpKnapsack(wt,val,8,4));
    }
}
