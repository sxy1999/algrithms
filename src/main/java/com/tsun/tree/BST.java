package com.tsun.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    private Node root;

    public void put(String key, String value) {
        root = put(root, key, value);
    }

    private Node put(Node x, String key, String value) {
        if (x == null) {
            x = new Node(key, value);
            x.setCount(1);
            return x;
        }
        int cmp = key.compareTo(x.getValue());
        if (cmp < 0) {
            x.setLeft(put(x.getLeft(), key, value));
        } else if (cmp > 0) {
            x.setRight(put(x.getLeft(), key, value));
        } else {
            x.setValue(value);
        }
        x.setCount(1 + size(x.getLeft()) + size(x.getRight()));
        return x;
    }

    public String get(String key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.getKey());
            if (cmp == 0) {
                return x.getValue();
            } else if (cmp < 0) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        return null;
    }

    public String floor(String key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.getKey();
    }

    private Node floor(Node x, String key) {
        if (x == null) {
            return null;
        }

        int comp = key.compareTo(x.getKey());
        if (comp == 0) {
            return x;
        }
        if (comp < 0) {
            return floor(x.getLeft(), key);
        }

        Node t = floor(x.getRight(), key);
        if (t != null) {
            return t;
        }
        return x;
    }

    public void delete(String key) {

    }

    public Iterable<String> iterator() {
        Queue<String> q = new LinkedList<>();
        inOrderTraverse(root, q);
        return q;
    }

    private void preOrderTraverse(Node x, Queue<String> q) {
        if (x == null) {
            return;
        }
        q.add(x.getKey());
        preOrderTraverse(x.getLeft(), q);
        preOrderTraverse(x.getRight(), q);
    }

    private void inOrderTraverse(Node x, Queue<String> q) {
        if (x == null) {
            return;
        }
        inOrderTraverse(x.getLeft(), q);
        q.add(x.getKey());
        inOrderTraverse(x.getRight(), q);
    }

    private void postOrderTraverse(Node x, Queue<String> q) {
        if (x == null) {
            return;
        }
        postOrderTraverse(x.getLeft(), q);
        postOrderTraverse(x.getRight(), q);
        q.add(x.getKey());
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) return 0;
        return x.getCount();
    }

    public int rank(String key) {
        return rank(key, root);
    }

    private int rank(String key, Node x) {
        if (x == null) {
            return 0;
        }
        int comp = key.compareTo(x.getKey());
        if (comp < 0) {
            return rank(key, x.getLeft());
        } else if (comp > 0) {
            return rank(key, x.getLeft()) + rank(key, x.getRight());
        } else {
            return size(x.getLeft());
        }
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.getLeft() == null) {
            return x.getRight();
        }
        x.setLeft(deleteMin(x.getLeft()));
        x.setCount(1 + size(x.getLeft()) + size(x.getRight()));
        return x;
    }


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
