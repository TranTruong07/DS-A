/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Scanner;
import model.Booking;
import model.Node;

/**
 *
 * @author Admin
 */
public class My_List<T extends Comparable<T>>{
    private static Scanner sc = new Scanner(System.in);
    Node<T> head, tail;

    public My_List() {
        head = tail = null;
    }
    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }
    
    //1
    void addToHead(int x) {
        Node a = new Node(x, head);
        head = a;
        if(head.getNext() == null){
            tail = a;
        }
    }
    //2
    void addToTail(T x) {
        Node a = new Node(x, null);
        if(isEmpty()) {
            head = tail = a;
            return;
        }
        tail.setNext(a);
        tail = a;
    }
//    //3
//    void addAfter(Node p, int x) {
//        if(isEmpty() || p == null) return;
//        if(p == tail) {addToTail(x);return;}
//        Node a = p.getNext();
//        Node p1 = new Node(x, a);
//        p.next = p1;
//        if(p == tail)
//            tail = p1;
//    }
    //4
    public void traverse() {
        if(isEmpty()) return;
        Node a = head;
        while(a!= null){
            System.out.println(a.getData().toString());
            a = a.getNext();
        }
    }
    //5
    T deleteFromHead() {
        if(isEmpty()) return null;
        T a = head.getData();
        head = head.getNext();
        if(head == null){
            tail = null;
            return null;
        }
        return a;
    }
    // 6
    T deleteFromTail() {
        if(isEmpty()) return null;
        T z = tail.getData();
        if(head == tail){
            clear();
            return z;
        }
        Node<T> a = head;
        while(a.getNext() != tail){
            a = a.getNext();
        }
        a.setNext(null);
        return z;
    }
    //7
//    int deleteAter(Node p) {
//        if(isEmpty() || p == null||p.next == null) return -1;
//        int x = p.next.getX();
//        if(p.next == tail){
//            p.next = null;
//            tail = p;
//            return x;
//        }else{
//            Node a = p.next;
//            Node h = head;
//            while(h != a) h = h.next;
//            Node b = h.next;
//            p.next = b;
//            if(b == tail) tail = p.next;
//            return x;
//        }
//    }
    // 8
    void dele(T x) {
        Node a = search(x);
        if(a == head) {deleteFromHead(); return;}
        if(a == tail) {deleteFromTail(); return;}
        Node h = head;
        while(h.getNext() != a){
            h = h.getNext();
        }
        Node temp = a.getNext();
        h.setNext(temp);
        a = null;
    }
    // 9
    Node search(T x){
        Node a = head;
        while(a != null){
            if(a.getData() == x){
                return a;
            }
            a = a.getNext();
        }
        return null;    
    }
//    //10
//    int count() {
//        int i = 0;
//        Node a = head;
//        while(a!= null){
//            i++;
//            a = a.next;
//        }
//        return i;
//    }
//    //11
//    void deleNode_i_th(int i){
//        Node a = null;
//        int j = 0;
//        Node aa = head;
//        while(aa!= null){
//            j++;
//            if(i == j){
//                break;
//            }
//            aa = aa.next;
//        }
//        dele(aa.getX());
//    }
//    //12
     public void sort() {
        if (head == null || head.getNext() == null) {
            return;
        }

        Node<T> current = head;
        Node<T> index = null;
        T temp;

        while (current != null) {
            index = current.getNext();

            while (index != null) {
                if (current.getData().compareTo(index.getData()) > 0) {
                    temp = current.getData();
                    current.setData(index.getData());
                    index.setData(temp);
                }
                index = index.getNext();
            }
            current = current.getNext();
        }
    }

    public void addBooking() {
        System.out.println("Enter bcode: ");
        String bcode = sc.nextLine();
        System.out.println("Enter ccode: ");
        String ccode = sc.nextLine();
        int seat = Validation.getInt("Enter seat", 1, Integer.MAX_VALUE);
        Booking b = new Booking(bcode, ccode, seat);
        addToTail((T) b);
        System.out.println("done");
    }
}
//    //13
//    void dele(Node p) {
//        if(isEmpty() || p == null) return;
//        if(p == head) {deleteFromHead(); return;}
//        if(p == tail) {deleteFromTail(); return;}
//        Node a = head;
//        int i = 0;
//        while(a!= null){
//            i++;
//            if(a == p){
//                break;
//            }
//            a = a.next;
//        }
//        deleNode_i_th(i);
//    }
//    // 14
//    int [] toArray() {
//        if(isEmpty()) return null;
//        int[] arr = new int[count()];
//        Node a = head;
//        int i = 0;
//        while(a!= null){
//            arr[i++] = a.getX();
//            a = a.next;
//        }
//        return arr;
//    }
//    //16
//    void addBefore(Node p, int x) {
//        if(isEmpty()||p == null) return;
//        if(p == head) {addToHead(x);return;}
//        Node a = head;
//        while(a.next != p){
//            a = a.next;
//        }
//        Node z = new Node(x, p);
//        a.next = z;
//    }
//    //18
//    int max() {
//        if(isEmpty())return -1;
//        int x = head.getX();
//        Node a = head;
//        while(a!=null){
//            if(a.getX()>x){
//                x = a.getX();
//            }
//            a = a.next;
//        }
//        return x;
//    }
//    
//    //19
//    int min() {
//        if(isEmpty())return -1;
//        int x = head.getX();
//        Node a = head;
//        while(a!=null){
//            if(a.getX()<x){
//                x = a.getX();
//            }
//            a = a.next;
//        }
//        return x;
//    }
//    //20
//    int sum() {
//        if(isEmpty())return -1;
//        int x = 0;
//        Node a = head;
//        while(a!=null){
//            x += a.getX();
//            a = a.next;
//        }
//        return x;
//    }
//    //21
//    int avg() {
//        if(isEmpty())return -1;
//        int x = 0;
//        Node a = head;
//        while(a!=null){
//            x += a.getX();
//            a = a.next;
//        }
//        int avg = (int)x / count();
//                
//        return avg;
//    }
//    //22
//    boolean sorted() {
//        if(isEmpty()) return false;
//        Node a = head; 
//        while(a.next!=null){
//            if(a.getX()>a.next.getX()){
//                return false;
//            }
//            a = a.next;
//        }
//        return true;
//    }
//    //23
//    void insert(int x){
//        if(isEmpty()) return;
//        sort();
//        Node a = head;
//        if(x>max()){
//            addToTail(x);
//            return;
//        }
//        if(x<min()){
//            addToHead(x);
//            return;
//        }
//        while(a != null){
//            if(x <= a.getX()){
//                break;
//            }
//            a = a.next;
//        }
//        addBefore(a, x);
//    }
//    //24
//    void Reverse(){
//        if(isEmpty())return;
//        int[] arr = toArray();
//        int i = 0, j = count()-1;
//        while(i<j){
//            int x = arr[i];
//            arr[i] = arr[j];
//            arr[j] = x;
//            i++;
//            j--;
//        }
//        clear();
//        for(int k = 0; k< arr.length; k++){
//            addToTail(arr[k]);
//        }
//    }
    
    //15
//    boolean Merge(My_List a, My_List b){
//        if(a.isEmpty() && b.isEmpty()) return false;
//        clear();
//        a.sort(); b.sort();
//        int[] a1 = a.toArray();
//        int[] b1 = b.toArray();
//        int[] ab = new int[a1.length+b1.length];
//        int k = 0;
//        for(int i = 0; i<a1.length; i++){
//            ab[k++] = a1[i];
//        }
//        for(int i = 0; i<b1.length; i++){
//            ab[k++] = b1[i];
//        }
//        for (int i : ab) {
//            addToTail(i);
//        }
//        sort();
//        return true;
//    }
//    
//    //25
//    boolean checkSameConten(My_List a, My_List b){
//        if(a.isEmpty() || b.isEmpty()) return false;
//        a.sort(); b.sort();
//        int[] a1 = a.toArray();
//        int[] b1 = b.toArray();
//        if(a1.length != b1.length) return false;
//        for(int i = 0; i< a1.length; i++){
//            if(a1[i] != b1[i]) return false;
//        }
//        return true;
//    }
//}
