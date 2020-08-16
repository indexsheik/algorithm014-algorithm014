package com.index.apache.thinking.in.algorithm.homework.week1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 641. 设计循环双端队列
 * <p>
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 * <p>
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * 示例：
 * <p>
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 *  
 *  
 * <p>
 * 提示：
 * <p>
 * 所有值的范围为 [1, 1000]
 * 操作次数的范围为 [1, 1000]
 * 请不要使用内置的双端队列库。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-circular-deque
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: Xiao Xuezhi
 * @Date: 2020/8/14 22:08
 * @Version： 1.0
 */
public class DesignCircularDequeTime1 {

    static String[] methodName = new String[]{
            "MyCircularDeque", "insertFront", "getRear", "insertLast", "getFront",
            "insertLast", "getFront", "insertFront", "getRear", "getRear",
            "deleteFront", "deleteLast", "isFull", "getRear", "getRear",
            "getFront", "getRear", "deleteLast", "insertLast", "getFront",
            "isEmpty", "insertLast", "insertLast", "getRear", "insertFront",
            "insertLast", "deleteFront", "getRear", "getFront", "isFull",
            "isFull", "insertLast", "getRear", "getFront", "insertLast",
            "getRear", "deleteLast", "getRear", "getFront", "getRear",
            "insertFront", "getFront", "getFront", "getRear", "getRear",
            "insertFront", "getRear", "insertLast", "insertFront", "getRear", "getFront", "getFront", "insertLast", "getFront", "deleteFront", "getFront", "deleteLast", "getRear", "deleteLast", "getRear", "getRear", "getFront", "isEmpty", "getRear", "deleteLast", "insertFront", "insertFront", "getFront", "deleteFront", "insertLast", "getRear", "insertFront", "insertLast", "insertFront", "insertLast", "insertFront", "getFront", "getRear", "insertFront", "deleteLast", "getRear", "isFull", "insertLast", "getRear", "getFront", "getFront", "insertFront", "getRear", "getRear", "deleteFront", "isEmpty", "isFull", "deleteLast", "insertFront", "getFront", "insertFront", "deleteLast", "insertLast", "getRear", "insertFront", "getFront", "insertLast"};

    static Integer[][] param = {{96}, {72}, {}, {34}, {},
            {38}, {}, {91}, {}, {},
            {}, {}, {}, {}, {},
            {}, {}, {}, {27}, {},
            {}, {68}, {42}, {}, {68},
            {17}, {}, {}, {}, {},
            {}, {19}, {}, {}, {94},
            {}, {}, {}, {}, {},
            {85}, {}, {}, {}, {},
            {59}, {}, {40}, {60}, {},
            {}, {}, {5}, {}, {},
            {}, {}, {}, {}, {},
            {}, {}, {}, {}, {},
            {59}, {99}, {}, {}, {20},
            {}, {75}, {12}, {46}, {72},
            {0}, {}, {}, {5}, {}, {}, {}, {74}, {}, {}, {}, {93}, {}, {}, {}, {}, {}, {}, {37}, {}, {37}, {}, {11}, {}, {66}, {}, {63}};

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        MyCircularDeque circularDeque = new MyCircularDeque(param[0][0]); // 设置容量大小为3
        for (int i = 1; i < methodName.length; i++) {
            Integer[] params = param[i];
            if (params.length == 0) {
                Method method = MyCircularDeque.class.getDeclaredMethod(methodName[i]);
                method.setAccessible(true);
                Object invoke = method.invoke(circularDeque);
                System.out.println(invoke);
            } else {
                Class paramType = int.class;
                Method method = MyCircularDeque.class.getDeclaredMethod(methodName[i], paramType);
                method.setAccessible(true);
                Object invoke = method.invoke(circularDeque, params[0]);
                System.out.println(invoke);
            }
        }

//        System.out.println(circularDeque.insertLast(1));     // 返回 true
//        System.out.println(circularDeque.insertLast(2));     // 返回 true
//        System.out.println(circularDeque.insertFront(3));    // 返回 true
//        System.out.println(circularDeque.insertFront(4));    // 已经满了，返回 false
//        System.out.println(circularDeque.getRear());               // 返回 2
//        System.out.println(circularDeque.isFull());                // 返回 true
//        System.out.println(circularDeque.deleteLast());            // 返回 true
//        System.out.println(circularDeque.insertFront(4));    // 返回 true
//        System.out.println(circularDeque.getFront());              // 返回 4

    }

    public static class MyCircularDeque {

        private int size;

        private final int capacity;

        private DequeNode head;

        private DequeNode tail;


        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            this.size = 0;
            this.capacity = k;
            this.head = null;
            this.tail = null;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (size == capacity) {
                return false;
            }
            head = insertNode(value);
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (size == capacity) {
                return false;
            }
            tail = insertNode(value);
            return true;
        }

        private DequeNode insertNode(int value) {
            DequeNode node = new DequeNode(value);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                head.prev = node;
                node.next = head;
                tail.next = node;
                node.prev = tail;
            }
            size++;
            return node;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (head == null) {
                return false;
            }
            if (size == 1) {
                head = tail = null;
            } else if (size == 2) {
                head = tail;
                tail.next = null;
                tail.prev = null;
            } else {
                head = head.next;
                head.prev = tail;
                tail.next = head;
            }
            size--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (tail == null) {
                return false;
            }
            if (size == 1) {
                head = tail = null;
            } else if (size == 2) {
                tail = head;
                head.prev = null;
                head.next = null;
            } else {
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
            }
            size--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (head == null) {
                return -1;
            }
            return head.value;
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (tail == null) {
                return -1;
            }
            return tail.value;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return size == capacity;
        }

        private static class DequeNode {

            int value;

            DequeNode prev;

            DequeNode next;

            public DequeNode(int value) {
                this.value = value;
            }
        }
    }
}
