package Recursion;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class DeleteMiddleElementStack {
    public static void deleteMiddleElement(Stack<Integer> stack, int n) {
        if(stack.size()==0)
            return;
        if(stack.size()==(n/2 + 1)){
            stack.pop();
            deleteMiddleElement(stack,n);
            return;
        }
        int value = stack.pop();
        deleteMiddleElement(stack,n);
        stack.push(value);
    }

    static void printStack(Stack<Integer> stack){
        ListIterator<Integer> iterator = stack.listIterator();
        while (iterator.hasNext()){
            iterator.next();
        }
        while (iterator.hasPrevious()){
            System.out.print(iterator.previous()+" ");
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println("stack before deleting..");
        printStack(stack);
        System.out.println();
        deleteMiddleElement(stack,stack.size());
        System.out.println("stack after deleting..");
        printStack(stack);
    }
}
