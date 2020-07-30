package DynamicProgramming;

public class SubsetSumProblem {

    public static boolean checkIfsubsetSumExists(int[] arr, int sum){
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sum+1];

        for(int i=0; i<=n; i++){
            for(int j=0;j<=sum;j++){
                if(i==0 || j==0) {
                    if (i == 0) {
                        dp[i][j] = false;
                    }
                    if (j == 0) {
                        dp[i][j] = true;
                    }
                }

                else if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        int[] arr = {2,3,7,8,10};
        System.out.println(checkIfsubsetSumExists(arr,11));
    }
}
