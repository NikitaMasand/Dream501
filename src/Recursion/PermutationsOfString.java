package Recursion;

import java.util.HashSet;

public class PermutationsOfString {
    static HashSet<String> set = new HashSet<>();
    public static void printPermutations(char[] input, char[] result, int[] count, int level){
        if(level==input.length){
            if(!set.contains(String.copyValueOf(result))){
                set.add(String.copyValueOf(result));
                System.out.println(result);
            }
            return;
        }
        for(int i=0;i<input.length;i++){
            if(count[i]==0){
                continue;
            }
            else{
                result[level]=input[i];
                count[i]--;
                printPermutations(input,result,count,level+1);
                count[i]++;
            }
        }
    }
    public static void main(String[] args) {
        String input = "ACBC";
        char res[] = new char[input.length()];
        int count[] = new int[input.length()];
        for(int i=0; i<input.length();i++){
            count[i]=1;
        }

        printPermutations(input.toCharArray(),res,count,0);
    }
}
