package com.tsun.tree;

import org.junit.Assert;

public class RedBlackBST {

    private final static boolean RED = true;
    private final static boolean BLACK = false;


    private class Node {
        String key;
        String value;
        Node left, right;
        boolean color;

        public Node(String key, String value, boolean red) {
            this.key = key;
            this.value = value;
            this.color = red;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Assert.assertTrue(isRed(h.right));
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Assert.assertTrue(isRed(h.left));
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        Assert.assertTrue(isRed(h.left));
        Assert.assertTrue(isRed(h.right));
        Assert.assertTrue(!isRed(h));
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    /**
     * Right child RED, left child BLACK: rotate left;
     * Left child, left-left grandchild RED: rotate right;
     * Both children RED, flip colors.
     *
     * @param h     the current root node
     * @param key
     * @param value
     * @return the root node
     */
    private Node put(Node h, String key, String value) {
        if (h == null) return new Node(key, value, RED);
        int comp = key.compareTo(h.key);
        if (comp < 0) {
            h.left = put(h.left, key, value);
        } else if (comp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h.right);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        return h;
    }
}
