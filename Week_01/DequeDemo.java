package com.index.apache.thinking.in.algorithm.homework.week1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * {@link Deque}
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/12 19:18
 * @Version： 1.0
 */
public class DequeDemo {

    public static void main(String[] args) {
        oldAPI();
        System.out.println("---------");
        newAPI();
    }

    private static void oldAPI(){
        Deque<String> deque = new LinkedList<>();

        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size()>0){
            System.out.println(deque.poll());
        }
        System.out.println(deque);
    }

    private static void newAPI(){
        Deque<String> deque = new LinkedList<>();

        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.getFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size()>0){
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }
}
