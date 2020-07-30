package CompanyPreparation.MorganStanley;

public class MinimumFibonacciJumps {
    public static int findMinFibJumps(int[] arr){
        int n = arr.length;
        int[] fib = new int[30];
        fib[0]=0;
        fib[1]=1;
        for(int i=2; i<30; i++){
            fib[i]=fib[i-1]+fib[i-2];
        }
        int dp[] = new int[n+2];
        dp[0]=0;
        for(int i=1;i<=n+1;i++){
            dp[i]=Integer.MAX_VALUE-1;
        }
        for(int i=1;i<=n+1;i++){
            for(int j=1;j<30;j++){
                if((i==n+1 || arr[i-1]==1) && i-fib[j]>=0){
//                    System.out.println(i+" "+dp[i]);
                    dp[i] = Math.min(dp[i],1+dp[i-fib[j]]);
                }
            }
        }
        return dp[n+1]!=Integer.MAX_VALUE-1 ? dp[n+1] : -1;

    }
    public static void main(String[] args) {
        int[] arr = {0,0,0,1,1,0,1,0,0,0,0};
        System.out.println("min fib jumps...");
        System.out.println(findMinFibJumps(arr));
    }
}
