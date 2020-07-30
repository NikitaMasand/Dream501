package Recursion;

import java.util.Iterator;
import java.util.Stack;

public class ReverseStack {
    static void reverse(Stack<Integer> stack) {
        if(stack.size()==1)
            return;
        int val = stack.pop();
        reverse(stack);
        insertAtEnd(stack,val);
    }

    static void insertAtEnd(Stack<Integer> stack, int x) {
        if (stack.size()==0) {
            stack.push(x);
            return;
        }
        int val = stack.pop();
        insertAtEnd(stack,x);
        stack.push(val);

    }

    static void printStack(Stack<Integer> stack){
        Iterator iterator = stack.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(0);
        stack.push(5);
        stack.push(2);
        System.out.println("stack before reversing: ");
        printStack(stack);
        System.out.println();
        reverse(stack);
        System.out.println("stack after reversing: ");
        printStack(stack);
    }


}

