package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class PreviousGreaterElement {
    public static int[] findPreviousGreater(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[n];
        res[0]=-1;
        for(int i=1;i<n;i++){
            if(stack.isEmpty()){
                res[i]=-1;
            }
            else if(stack.peek()>arr[i]){
                res[i]=stack.peek();
            }
            else {
                while (!stack.isEmpty() && stack.peek()<=arr[i]){
                    stack.pop();
                }
                res[i]=stack.isEmpty()?-1:stack.peek();
            }
            stack.push(arr[i]);
        }
        return res;
    }

    public static int[] findPreviousGreaterIndex(int[] arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int res[] = new int[n];
        res[0]=-1;
        for(int i=1;i<n;i++){
            if(stack.isEmpty()){
                res[i]=-1;
            }
            else if(arr[stack.peek()]>arr[i]){
                res[i]=stack.peek();
            }
            else {
                while (!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                    stack.pop();
                }
                res[i]=stack.isEmpty()?-1:stack.peek();
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,4};
        int[] res = PreviousGreaterElement.findPreviousGreater(arr);
        System.out.println(Arrays.toString(res));
        res = PreviousGreaterElement.findPreviousGreaterIndex(arr);
        System.out.println(Arrays.toString(res));
    }
}
