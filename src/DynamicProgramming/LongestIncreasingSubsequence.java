package DynamicProgramming;

public class LongestIncreasingSubsequence {
    public static int findLISLen(int[] arr){
        int[] lis = new int[arr.length];
        for(int i=0;i<lis.length;i++){
            lis[i]=1;
        }
        int maxlen = Integer.MIN_VALUE;
        int maxlenindex = -1;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && lis[i]<=lis[j]){
                    lis[i]=1+lis[j];
                    maxlen=Math.max(maxlen,lis[i]);
                    maxlenindex=i;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        res.append(arr[maxlenindex]);

        for(int i=maxlenindex-1;i>=0;i--){
            if(lis[i]==lis[maxlenindex]-1){
                res.append(arr[i]);
                maxlenindex=i;
            }
        }
        System.out.println("lis string.."+res.reverse().toString());
        return maxlen;
    }

    public static void main(String[] args) {
        int[] arr = {5,8,7,1,9};
        System.out.println("lis..");
        System.out.println(findLISLen(arr));
    }
}
