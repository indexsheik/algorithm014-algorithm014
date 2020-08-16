package com.index.apache.thinking.in.algorithm.homework.week1;

import java.util.Stack;

/**
 * {@link Stack}
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/12 19:08
 * @Version： 1.0
 */
public class StackDemo {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        System.out.println(stack.search(4));

        stack.pop();
        stack.pop();
        Integer topElement = stack.peek();
        System.out.println(topElement);
        System.out.println("3的位置:" + stack.search(3));
    }
}
