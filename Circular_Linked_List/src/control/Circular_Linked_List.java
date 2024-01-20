/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modle.Node;

/**
 *
 * @author Admin
 */
public class Circular_Linked_List {

    private Node head;
    private Node tail;

    public Circular_Linked_List() {
        this.head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = tail = null;
    }

    //10
    public int count() {
        int i = 0;
        if (isEmpty()) {
            return i;
        }
        Node a = head;
        do {
            i++;
            if (a.getNext() == head) {
                break;
            }
            a = a.getNext();
        } while (true);
        return i;
    }

    //1
    public void addToHead(int x) {
        Node current = new Node(x, head);
        if (isEmpty()) {
            head = tail = current;
            tail.setNext(head);
            return;
        }
        head = current;
        tail.setNext(head);
    }

    //2
    public void addToTail(int x) {
        if (isEmpty()) {
            addToHead(x);
            return;
        }
        Node current = new Node(x, head);
        tail.setNext(current);
        tail = current;
    }

    //3
    public void addAfter(Node p, int x) {
        if (isEmpty() || p == null) {
            return;
        }
        if (p.getNext() == head) {
            addToTail(x);
            return;
        }
        Node b = p.getNext();
        Node current = new Node(x, b);
        p.setNext(current);
    }

    //4
    public void traverse() {
        if (isEmpty()) {
            return;
        }
        Node a = head;
        do {
            System.out.print(a.getX() + " ");
            if (a == tail) {
                break;
            }
            a = a.getNext();
        } while (true);
    }

    //5
    public int deleteFromHead() {
        if (isEmpty()) {
            return -1;
        }
        int x = head.getX();
        Node a = head.getNext();
        head = null;
        tail.setNext(a);
        head = a;
        return x;
    }

    //6
    public int deleteFromTail() {
        if (isEmpty()) {
            return -1;
        }
        int x = tail.getX();
        if (head == tail) {
            return x;
        }
        Node a = head;
        do {
            if (a.getNext() == tail) {
                break;
            }
            a = a.getNext();
        } while (true);
        a.setNext(head);
        tail = null;
        tail = a;
        return x;
    }

    //7
    public int deleteAter(Node p) {
        if (isEmpty() || p == null) {
            return -1;
        }
        int x = p.getNext().getX();
        Node a = p.getNext();
        if (a == tail) {
            deleteFromTail();
            return x;
        }
        if (a == head) {
            deleteFromHead();
            return x;
        }
        Node b = p.getNext().getNext();
        p.setNext(b);
        return x;
    }

    //8
    public void dele(int x) {
        Node a = search(x);
        if (a == null) {
            return;
        }
        deleNode(a);
    }

    //9
    public Node search(int x) {
        Node a = head;
        do {
            if (a.getX() == x) {
                return a;
            }
            if(a == tail) break;
            a = a.getNext();
        } while (true);
        return null;
    }

    //11
    public void deleNode_i_th(int i) {
        int j = 0;
        if (isEmpty()) {
            return;
        }
        Node a = head;
        do {
            ++j;
            if (i == j) {
                deleNode(a);
                return;
            }
            if (a.getNext() == head) {
                break;
            }
            a = a.getNext();
        } while (true);
    }

    //13
    public void deleNode(Node p) {
        if (isEmpty() || p == null) {
            return;
        }
        if (p == head) {
            deleteFromHead();
            return;
        }
        if (p == tail) {
            deleteFromTail();
            return;
        }
        Node a = head;
        do {
            if (a.getNext() == p) {
                break;
            }
            a = a.getNext();
        } while (true);
        a.setNext(p.getNext());
    }

    //12
    public void sort() {
        if (toArray() == null) {
            return;
        }
        int[] arr = toArray();
        clear();
        for(int i = 0; i< arr.length; i++){
            for(int j = i; j< arr.length; j++){
                if(arr[i]>arr[j]){
                    int x = arr[i];
                    arr[i] = arr[j];
                    arr[j] = x;
                }
            }
        }
        for(int i = 0; i< arr.length; i++){
            addToTail(arr[i]);
        }
    }

    // 14
    public int[] toArray() {
        if (isEmpty()) {
            return null;
        }
        int[] arr = new int[count()];
        int i = 0;
        Node a = head;
        do {
            arr[i++] = a.getX();
            if (a.getNext() == head) {
                break;
            }
            a = a.getNext();
        } while (true);
        return arr;
    }

    //15
    public boolean Merge(Circular_Linked_List a, Circular_Linked_List b) {
        if(a.isEmpty() && b.isEmpty()) return false;
        clear();
        int[] a1 = a.toArray();
        int[] b1 = b.toArray();
        int[] ab = new int[a1.length+b1.length];
        int k = 0;
        for(int i = 0; i<a1.length; i++){
            ab[k++] = a1[i];
        }
        for(int i = 0; i<b1.length; i++){
            ab[k++] = b1[i];
        }
        for (int i : ab) {
            addToTail(i);
        }
        sort();
        return true;
    }

    //16
    public void addBefore(Node p, int x) {
        if(isEmpty()|| p == null) return;
        if(p == head) {addToHead(x); return;}
        Node a = head;
        do {
            if (a.getNext() == p ||a.getNext() == head) {
                break;
            }
            a = a.getNext();
        } while (true);
        if(a.getNext() == head) return;
        Node current = new Node(x, p);
        a.setNext(current);
    }

    //18
    public int max() {
        if(isEmpty()) return -1;
        Node a = head;
        int max = a.getX();
        do {            
            if(a.getX()> max){
                max = a.getX();
            }
            if(a == tail) break;
            a = a.getNext();
        } while (true);
        return max;
    }

    //19
    public int min() {
        if(isEmpty()) return -1;
        Node a = head;
        int min = a.getX();
        do {            
            if(a.getX()< min){
                min = a.getX();
            }
            if(a == tail) break;
            a = a.getNext();
        } while (true);
        return min;
    }

    //20
    public int sum() {
        if(isEmpty()) return 0;
        Node a = head;
        int sum = 0;
        do {            
            sum+=a.getX();
            if(a == tail) break;
            a = a.getNext();
        } while (true);
        return sum;
    }

    //21
    public int avg() {
        if(isEmpty()) return 0;
        Node a = head;
        int sum = 0;
        do {            
            sum+=a.getX();
            if(a == tail) break;
            a = a.getNext();
        } while (true);
        int avg = (int)sum/count();
        return avg;
    }

    //22
    public boolean sorted() {
        if(isEmpty()) return false;
        Node a = head;
        do {    
            if(a == tail) break;
            if(a.getX()>a.getNext().getX()){
                return false;
            }
            a = a.getNext();
        } while (true);
        return true;
    }

    //23
    public void insert(int x) {
        if(isEmpty()) {addToHead(x); return;}
        sort();
        if(x<head.getX()) {addToHead(x); return;}
        if(x>tail.getX()) {addToTail(x); return;}
        Node a = head;
        do {    
            if(a == tail) break;
            if(x > a.getX()){
                break;
            }
            a = a.getNext();
        } while (true);
        addAfter(a, x);
    }

    //24
    public void Reverse() {
        if(isEmpty())return;
        int[] arr = toArray();
        int i = 0, j = count()-1;
        while(i<j){
            int x = arr[i];
            arr[i] = arr[j];
            arr[j] = x;
            i++;
            j--;
        }
        clear();
        for(int k = 0; k< arr.length; k++){
            addToTail(arr[k]);
        }
    }

    public boolean checkSameConten(Circular_Linked_List a, Circular_Linked_List b) {
        if(a.isEmpty() || b.isEmpty()) return false;
        a.sort(); b.sort();
        int[] a1 = a.toArray();
        int[] b1 = b.toArray();
        if(a1.length != b1.length) return false;
        for(int i = 0; i< a1.length; i++){
            if(a1[i] != b1[i]) return false;
        }
        return true;
    }

    // 17 
    public void attach(Circular_Linked_List otherList) {
        if (head == null) {
            head = otherList.head;
        } else {
            Node a = otherList.head;
            tail.setNext(a);
            otherList.tail.setNext(head);
            tail = otherList.tail;
        }
    }

}
