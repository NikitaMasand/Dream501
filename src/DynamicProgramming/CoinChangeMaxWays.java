package DynamicProgramming;
//unbounded knapsack
public class CoinChangeMaxWays {
    public static int coinChangeMaxWays(int[]coin, int sum){
        int[][] dp = new int[coin.length+1][sum+1];
        for(int i=0;i<=coin.length;i++){
            for(int j=0;j<=sum;j++){
                if(i==0 || j==0){
                    if(i==0){
                        dp[i][j]=0;
                    }
                    if(j==0){
                        dp[i][j]=1;
                    }
                }
                else if(coin[i-1]<=j){
                    dp[i][j] = dp[i-1][j]+dp[i][j-coin[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coin.length][sum];
    }

    public static void main(String[] args) {
        int[] coin = {2,5,3,6};
        System.out.println("max ways coin change: ");
        System.out.println(coinChangeMaxWays(coin,10));
    }
}
