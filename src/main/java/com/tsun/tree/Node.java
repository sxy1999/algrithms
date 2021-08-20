package com.tsun.tree;

/**
 * @author xiaoyu.swun
 */
public class Node {
    private String key;
    private String Value;
    private Node left, right;
    private int count;

    public Node(String key, String value) {
        this.key = key;
        this.Value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key='" + key + '\'' +
                ", Value='" + Value + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
