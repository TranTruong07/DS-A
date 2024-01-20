
import java.util.Iterator;

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
public class BinarySearchTree<T extends Comparable<T>> implements TreADT<T>{
    private int countNode = 0;
    private Node<T> root = null;
    @Override
    public boolean isEmpty() {
        return count()==0;
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
        if(root == null) return 0;
        return getHeight(root);
    }
    private int getHeight(Node<T> node){
        if(node == null) return 0;
        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }
    @Override
    public boolean contains(T element) {
        return getContains(element, root);
    }
    private boolean getContains(T element, Node<T> node){
        if(node == null) return false;
        int result = element.compareTo(node.getData());
        if(result > 0) return getContains(element, node.getRight());
        if(result < 0) return getContains(element, node.getLeft());
        else return true;
    }
    @Override
    public Node<T> search(T x) {
        if(!contains(x)) return null;
        Node a = root;
        while(a != null){
            if((x+"").compareTo((a.getData()+""))>0){
                a = a.getRight();
            }else if((x+"").compareTo((a.getData()+""))<0){
                a = a.getLeft();
            }else{
                return a;
            }
        }
        System.out.println("not found");
        return null;
    }
    @Override
    public void insert(T element) {
        if(contains(element)) {System.out.println("can't duplicate"); return;}
        root = getAdd(root, element);
        countNode++;
        System.out.println("done");
    }
    private Node getAdd(Node<T> node, T element){
        if(node == null){
            node = new Node(element, null, null);
        }else if(element.compareTo(node.getData())>0){
            node.setRight(getAdd(node.getRight(), element));
        }else{
            node.setLeft(getAdd(node.getLeft(), element));
        }
        return node;
    }
    @Override
    public boolean remove(T element) {
        if(!contains(element)) return false;
        root = getRemove(root, element);
        countNode--;
        return true;
    }

    @Override
    public void traverse(TreeTraverseType type) {
        switch(type){
            case PRE_ORDER: {preorder(root); break;}
            case IN_ORDER: {inorder(root);break;}
            case POS_ORDER: {postorder(root);break;}
            default: return;
        }
    }

    private Node<T> getRemove(Node<T> node, T element) {
        int result = element.compareTo(node.getData());
        if(result > 0){
            node.setRight(getRemove(node.getRight(), element));
        }else if(result < 0){
            node.setLeft(getRemove(node.getLeft(), element));
        }else{
            if(node.getLeft()== null){
                Node rightNode = node.getRight();
                node.setData(null);
                node = null;
                return rightNode;
            }else if(node.getRight()== null){
                Node leftNode = node.getLeft();
                node.setData(null);
                node = null;
                return leftNode;
            }else{
                T data = minRight(node);
                node.setData(data);
                node.setRight(getRemove(node, data));
            }
        }
        return node;
    }

    private T minRight(Node<T> node) {
        while(node.getLeft()!= null) node = node.getLeft();
        return node.getData();
    }
    private T maxLeft(Node<T> node) {
        while(node.getRight()!= null) node = node.getRight();
        return node.getData();
    }
    @Override
    public void clear() {
        root = null;
        countNode = 0;
    }

    

    @Override
    public Node<T> min() {
        T x = minRight(root);
        return search(x);
    }

    @Override
    public Node<T> max() {
        T x = maxLeft(root);
        return search(x);
    }

    public int sum(Node<T> root) {
        if (root == null) {
            return 0;
        }
        return sum(root.getLeft()) + Integer.parseInt(root.getData()+"") + sum(root.getRight());
    }

    @Override
    public int avg() {
        return (int)(sum(root)/count());
    }


  
   
    public void preorder(Node<T> root) {
        if(root != null){
        System.out.print(root.getData()+" \n");
        preorder(root.getLeft());
        preorder(root.getRight());
        }
    }

    private void inorder(Node<T> root) {
        if(root != null){
            inorder(root.getLeft());
            System.out.print(root.getData()+" \n");
            inorder(root.getRight());
        }
    }

    private void postorder(Node<T> root) {
        if(root != null){
            postorder(root.getLeft());
            postorder(root.getRight());
            System.out.print(root.getData()+" \n");
    }
    }
    
}
