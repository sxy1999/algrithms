package com.tsun.linked_list;

import java.util.Random;
import java.util.StringJoiner;

/**
 * @author xiaoyu.swun
 */
public class ReverseLinkedList {

    private static Random random = new Random();

    public static void main(String[] args) {
        Node head = generateLinkedList(10);
        StringJoiner sj = new StringJoiner(",", "{", "}");
        Node current = head;
        while (true) {
            sj.add(current.value + "");
            if (current.next == null) {
                break;
            }
            current = current.next;
        }
        System.out.println(sj.toString());

        Node newHead = reverseLinkedList(head);
        StringJoiner sj1 = new StringJoiner(",", "{", "}");
        current = newHead;
        while (true) {
            sj1.add(current.value + "");
            if (current.next == null) {
                break;
            }
            current = current.next;
        }
        System.out.println(sj1.toString());
    }

    private static Node generateLinkedList(int length) {
        Node head = new Node();
        head.value = random.nextInt(20);
        Node prev = head;
        for (int i = 0; i < length; i++) {
            Node node = new Node();
            node.value = random.nextInt(20);
            prev.next = node;
            prev = node;
        }

        return head;
    }

    private static Node reverseLinkedList(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node remaining = reverseLinkedList(node.next);
        node.next.next = node;
        node.next = null;
        return remaining;
    }


    static class Node {
        int value;
        Node next;
    }
}


