package bai11_queue_stack.bai_tap.e1_reverse;

import java.util.Arrays;
import java.util.Stack;

public class MyStack {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        Stack<Integer> myReserveStack = new Stack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        System.out.println(myStack.toString());
        int size = myStack.size();
        for (int i = 0; i < size; i++){
            myReserveStack.push(myStack.pop());
        }
        System.out.println(myReserveStack.toString());


        String text = "One Two Three Four";
        String[] textArr;
        Stack<String> myString = new Stack<>();
        Stack<String> myReserveString = new Stack<>();
        textArr = text.split(" ");
        for (String s : textArr) {
            myString.push(s);
        }
        int sizeStr = myString.size();
        for (int i = 0; i < sizeStr; i++){
            myReserveString.push(myString.pop());
        }
        System.out.println();
        System.out.println(Arrays.toString(textArr));
        System.out.println(myReserveString.toString());
    }
}
