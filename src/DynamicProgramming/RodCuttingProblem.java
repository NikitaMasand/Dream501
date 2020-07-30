package DynamicProgramming;
//unbounded knapsack

public class RodCuttingProblem {

    public static int getMaxProfitRodCutting(int[] price, int[] length, int lengthOfRod){
        int n = price.length;
        int[][] dp = new int[n+1][lengthOfRod+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=lengthOfRod; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else if(length[i-1]<=j){
                    dp[i][j] = Math.max(dp[i-1][j],
                            price[i-1]+dp[i][j-length[i-1]]
                            );
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][lengthOfRod];
    }
    public static void main(String[] args) {
        int lengthOfRod = 8;
        int[] length = {1,2,3,4,5,6,7,8};
        int[] price = {1,5,8,9,10,17,17,20};
        System.out.println("max profit rod cutting..");
        System.out.println(getMaxProfitRodCutting(price,length,lengthOfRod));
    }
}
