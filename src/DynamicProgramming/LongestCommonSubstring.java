package DynamicProgramming;

public class LongestCommonSubstring {

    public static int findLongestCommonSubstringLen(String x, String y){
        int maxLen = Integer.MIN_VALUE;
        int[][] matrix = new int[x.length()+1][y.length()+1];
        for(int i=0;i<matrix.length;i++){
            for(int j=0; j<matrix[i].length; j++){
                if(i==0 || j==0){
                    matrix[i][j]=0;
                }
                else if(x.charAt(i-1)==y.charAt(j-1)){
                    matrix[i][j] = 1+matrix[i-1][j-1];
                    maxLen = Math.max(maxLen,matrix[i][j]);
                }
                else {
                    matrix[i][j]=0;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String x = "yzabcdezx";
        String y = "zxabcdezy";

        System.out.println("len of longest common substring: ");
        System.out.println(findLongestCommonSubstringLen(x,y));
    }
}
