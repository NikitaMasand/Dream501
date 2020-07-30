package Recursion;
//unsupported operation exception. will see the issue later

import java.util.Iterator;
import java.util.Stack;

public class SortStack {
    static void sort(Stack<Integer> stack){
       if(stack.size()==1){
           return;
       }
       int temp = stack.pop();
       sort(stack);
       insert(stack,temp);
    }

    static void insert(Stack<Integer>stack, int temp) {
      if(stack.size()==0 || stack.peek()<=temp){
          stack.push(temp);
          return;
      }
        //let stack: 0,1,5 and temp=2. then we need to temp store 5 somewhere
        // so that 2 can be inserted into 0,1. thus storing and once 2 is inserted, we push back 5
      int value = stack.pop();
      insert(stack,temp);
      stack.push(value);
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
        System.out.println("stack before sorting: ");
        printStack(stack);
        System.out.println();
        sort(stack);
        System.out.println("stack after sorting");
        printStack(stack);
    }
}
