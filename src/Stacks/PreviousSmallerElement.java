package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class PreviousSmallerElement {
    public static int[] findPreviousSmaller(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        stack.push(arr[0]);
        res[0]=-1;

        for(int i=1; i<n;i++){
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
        int[] res = PreviousSmallerElement.findPreviousSmaller(arr);
        System.out.println(Arrays.toString(res));
    }
}
