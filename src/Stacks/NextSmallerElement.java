package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static int[] findNextSmaller(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        stack.push(arr[n-1]);
        res[n-1]=-1;

        for(int i=n-2; i>=0;i--){
            if(stack.isEmpty()){
                res[i]=-1;
            }
            else if(stack.peek()<arr[i]){
                res[i]=stack.peek();
            }
            else{
                while (!stack.isEmpty()&&stack.peek()>=arr[i]){
                    stack.pop();
                }
                res[i]=stack.isEmpty()?-1:stack.peek();
            }
            stack.push(arr[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,2,10,8};
        int[] res = NextSmallerElement.findNextSmaller(arr);
        System.out.println(Arrays.toString(res));
    }
}
