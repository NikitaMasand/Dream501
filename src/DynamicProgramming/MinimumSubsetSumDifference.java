package DynamicProgramming;

public class MinimumSubsetSumDifference {

    public static int getMinimumSubsetSumDifference(int[] arr){
        int sum = 0;
        int n = arr.length;
        for(int i=0; i<n; i++){
            sum+=arr[i];
        }
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=sum; j++){
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
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        boolean[] arrToCheckValidSums = dp[n];
        int maxSumForS1 = 0;
        for(int i=0;i<=sum/2;i++){
            if(arrToCheckValidSums[i])
                maxSumForS1=i;
        }
        return sum-(2*maxSumForS1);
    }
    public static void main(String[] args) {
        int[] arr = {1,6,11,5};
        //1,2,7
        System.out.println(getMinimumSubsetSumDifference(arr));
    }
}
