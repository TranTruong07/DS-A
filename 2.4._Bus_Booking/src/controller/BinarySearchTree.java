package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Bus;
import model.TreADT;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 * @param <T>
 */
import model.Node;
import model.TreeTraverseType;

public class BinarySearchTree<T extends Comparable<T>> implements TreADT<T> {

    private static Scanner sc = new Scanner(System.in);
    private int countNode = 0;
    private Node<T> root = null;
    private boolean checkLoad = false;

    @Override
    public boolean isEmpty() {
        return count() == 0;
    }

    public Node<T> getRoot() {
        return root;
    }

    @Override
    public int count() {
        return countNode;
    }

    @Override
    public int height() {
        if (root == null) {
            return 0;
        }
        return getHeight(root);
    }

    private int getHeight(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }

    @Override
    public boolean contains(T element) {
        return getContains(element, root);
    }

    private boolean getContains(T element, Node<T> node) {
        if (node == null) {
            return false;
        }
        int result = element.compareTo(node.getData());
        if (result > 0) {
            return getContains(element, node.getRight());
        }
        if (result < 0) {
            return getContains(element, node.getLeft());
        } else {
            return true;
        }
    }

    @Override
    public void insert(T element) {
        if (contains(element)) {
            System.out.println("can't duplicate");
            return;
        }
        root = getAdd(root, element);
        countNode++;
        System.out.println("done");
    }

    private Node getAdd(Node<T> node, T element) {
        if (node == null) {
            node = new Node(element, null, null);
        } else if (element.compareTo(node.getData()) > 0) {
            node.setRight(getAdd(node.getRight(), element));
        } else {
            node.setLeft(getAdd(node.getLeft(), element));
        }
        return node;
    }

    @Override
    public boolean remove(T element) {
        if (!contains(element)) {
            return false;
        }
        root = getRemove(root, element);
        countNode--;
        return true;
    }

    @Override
    public void traverse(TreeTraverseType type) {
        switch (type) {
            case PRE_ORDER: {
                preorder(root);
                break;
            }
            case IN_ORDER: {
                inorder(root);
                break;
            }
            case POS_ORDER: {
                postorder(root);
                break;
            }
            case BREADTH_FIRST: {
                printLevelOrder();
                break;
            }
            default:
                return;
        }
    }

    private Node<T> getRemove(Node<T> node, T element) {
        int result = element.compareTo(node.getData());
        if (result > 0) {
            node.setRight(getRemove(node.getRight(), element));
        } else if (result < 0) {
            node.setLeft(getRemove(node.getLeft(), element));
        } else {
            if (node.getLeft() == null) {
                Node rightNode = node.getRight();
                node.setData(null);
                node = null;
                return rightNode;
            } else if (node.getRight() == null) {
                Node leftNode = node.getLeft();
                node.setData(null);
                node = null;
                return leftNode;
            } else {
                T data = minRight(node);
                node.setData(data);
                node.setRight(getRemove(node, data));
            }
        }
        return node;
    }

    private T minRight(Node<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getData();
    }

    private T maxLeft(Node<T> node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node.getData();
    }

    @Override
    public void clear() {
        root = null;
        countNode = 0;
    }

    @Override
    public Node<T> min() {
        return null;
    }

    public int sum(Node<T> root) {
        if (root == null) {
            return 0;
        }
        return sum(root.getLeft()) + Integer.parseInt(root.getData() + "") + sum(root.getRight());
    }

    @Override
    public int avg() {
        return (int) (sum(root) / count());
    }

    public void preorder(Node<T> root) {
        if (root != null) {
            System.out.print(root.getData() + " \n");
            preorder(root.getLeft());
            preorder(root.getRight());
        }
    }

    private void inorder(Node<T> root) {
        if (root != null) {
            inorder(root.getLeft());
            System.out.print(root.getData() + " \n");
            inorder(root.getRight());
        }
    }

    private void postorder(Node<T> root) {
        if (root != null) {
            postorder(root.getLeft());
            postorder(root.getRight());
            System.out.print(root.getData() + " \n");
        }
    }

    public String getCode(String msg) {
        System.out.println(msg);
        String x = "";
        while (true) {
            x = sc.nextLine();
            if (!checkDuplicate(x)) {
                return x;
            } else {
                System.out.println("Duplicate ID, Enter again: ");
            }
        }
    }

    public boolean checkDuplicate(String x) {
        return checkDuplicateNode(root, x);
    }

    private boolean checkDuplicateNode(Node<T> node, String x) {
        if (node == null) {
            return false;
        }

        Bus currentNodeData = (Bus) node.getData();
        Bus newBus = new Bus(x, x, 0, 0, 0, 0);

        if (newBus.compareTo(currentNodeData) > 0) {
            return checkDuplicateNode(node.getRight(), x);
        } else if (newBus.compareTo(currentNodeData) < 0) {
            return checkDuplicateNode(node.getLeft(), x);
        } else {
            return true; // Trùng lặp ID
        }
    }

    void printLevelOrder() {
        int h = height();
        int i;
        for (i = 1; i <= h; i++) {
            printCurrentLevel(root, i);
        }
    }

    void printCurrentLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.getData() + " \n");
        } else if (level > 1) {
            printCurrentLevel(root.getLeft(), level - 1);
            printCurrentLevel(root.getRight(), level - 1);
        }
    }

    public void searchByCode() {
        System.out.println("Enter code: ");
        String x = sc.nextLine();
        if (checkDuplicate(x)) {
            System.out.println(search(x).getData());
            return;
        }
        System.out.println("Not found");
    }

    public Node<T> search(String x) {
        return searchNode(root, x);
    }

    private Node<T> searchNode(Node<T> node, String x) {
        if (node == null) {
            return null;
        }

        Bus currentNodeData = (Bus) node.getData();
        Bus newBus = new Bus(x, x, 0, 0, 0, 0);

        if (newBus.compareTo(currentNodeData) > 0) {
            return searchNode(node.getRight(), x);
        } else if (newBus.compareTo(currentNodeData) < 0) {
            return searchNode(node.getLeft(), x);
        } else {
            return node; // Trùng lặp ID
        }
    }

    
    public void deleteByCode() {
        System.out.println("Enter code: ");
        String x = sc.nextLine();
        if (checkDuplicate(x)) {
            Bus b = (Bus) search(x).getData();
            if (remove((T) b)) {
                System.out.println("done");
            } else {
                System.out.println("can't remove");
            }
            return;
        }
        System.out.println("Not found");
    }

    
    
    
    public void showCountNode() {
        System.out.println("Count number of buses: " + countNode);
    }
    //8

    public void balance() {
        List<Node<T>> nodes = new ArrayList<>();
        inOrderTraverse(root, nodes);

        root = buildBalancedTree(nodes, 0, nodes.size() - 1);
    }

    private void inOrderTraverse(Node<T> node, List<Node<T>> nodes) {
        if (node == null) {
            return;
        }

        inOrderTraverse(node.getLeft(), nodes);
        nodes.add(node);
        inOrderTraverse(node.getRight(), nodes);
    }

    private Node<T> buildBalancedTree(List<Node<T>> nodes, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node<T> node = nodes.get(mid);

        node.setLeft(buildBalancedTree(nodes, start, mid - 1));
        node.setRight(buildBalancedTree(nodes, mid + 1, end));

        return node;
    }

    public void load(String pathFile) {
        LoadFile l = new LoadFile();
        List<Bus> lb = l.readBusFromFile(pathFile);
        if (lb.isEmpty()) {
            System.out.println("list empty");
            return;
        }
        checkLoad = true;
        clear();
        for (Bus bus : lb) {
            insert((T) bus);
        }
        System.out.println("done");
    }

    public void inorderFromFile() {
        if (checkLoad) {
            inorder(root);
        } else {
            System.out.println("Please load file first\n");
        }
    }
}
