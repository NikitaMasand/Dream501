package CompanyPreparation.MorganStanley;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumJumpsReachEnd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0) {
            int n = Integer.parseInt(br.readLine());
            String[] arrinput = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(arrinput[i]);
            }
            int[] dp = new int[n];
            dp[0] = 0;
            for (int i = 1; i < n; i++) {
                dp[i] = Integer.MAX_VALUE - 1;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 1; (j <= arr[i] && i+j < n); j++) {

                    dp[i + j] = Math.min(1 + dp[i], dp[i + j]);
                }
            }
            int res = dp[n - 1] != Integer.MAX_VALUE - 1 ? dp[n - 1] : -1;
            System.out.println("min num of jumps to reach end...");
            System.out.println(res);
        }
    }
}
