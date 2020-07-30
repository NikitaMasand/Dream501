package DynamicProgramming;
//unbounded knapsack
public class CoinChangeMinCoins {
    public static int getMinCoins(int[]coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=amount;j++){
                if(i==0 || j==0){
                    if(i==0){
                        dp[i][j] = Integer.MAX_VALUE-1;
                    }
                    if(j==0) {
                        dp[i][j]=0;
                    }
                }
                else if(coins[i-1]<=j){
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int res = dp[n][amount];
        if(res==Integer.MAX_VALUE || res==Integer.MAX_VALUE-1)
            return -1;
        return res;
    }
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        System.out.println("min coins...");
        System.out.println(getMinCoins(coins,5));
    }
}
