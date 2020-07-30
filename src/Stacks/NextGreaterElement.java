package Stacks;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] findNextGreaterElements(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];
//        int i = n-1;
        stack.push(arr[n-1]);
        res[n-1]=-1;
        for (int i=n-2;i>=0;i--){
            if(stack.isEmpty()){
                res[i]=-1;
                stack.push(arr[i]);
            }
            else if(stack.peek()>arr[i]){
                res[i] = stack.peek();
                stack.push(arr[i]);
            }
            else {
                while (!stack.isEmpty() && stack.peek()<=arr[i]){
                    stack.pop();
                }
                res[i]=stack.isEmpty()?-1:stack.peek();
                stack.push(arr[i]);
            }


        }
        return res;
    }

    public static int[] findNextGreaterIndex(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];
//        int i = n-1;
        stack.push(n-1);
        res[n-1]=-1;
        for (int i=n-2;i>=0;i--){
            if(stack.isEmpty()){
                res[i]=-1;
            }
            else if(arr[stack.peek()]>arr[i]){
                res[i] = stack.peek();
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
        int[] arr = {1,3,0,0,1,2,4};
        int[] res = NextGreaterElement.findNextGreaterElements(arr);
        System.out.println(Arrays.toString(res));
        int[] resindex = NextGreaterElement.findNextGreaterIndex(arr);
        System.out.println(Arrays.toString(resindex));
    }
}
