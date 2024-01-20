/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlely_linkedlist;

/**
 *
 * @author Admin
 */
public class My_List<T>{
    Node head, tail;

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
        if(head.next == null){
            tail = a;
        }
    }
    //2
    void addToTail(int x) {
        Node a = new Node(x, null);
        if(isEmpty()) {
            head = tail = a;
            return;
        }
        tail.next = a;
        tail = a;
    }
    //3
    void addAfter(Node p, int x) {
        if(isEmpty() || p == null) return;
        if(p == tail) {addToTail(x);return;}
        Node a = p.next;
        Node p1 = new Node(x, a);
        p.next = p1;
        if(p == tail)
            tail = p1;
    }
    //4
    void traverse() {
        if(isEmpty()) return;
        String s = "(";
        Node a = head;
        while(a!= null){
            s = s+ " "+a.getX();
            a = a.next;
        }
        s+= ")";
        System.out.println(s);
    }
    //5
    int deleteFromHead() {
        if(isEmpty()) return -1;
        int a = head.getX();
        head = head.next;
        if(head == null){
            tail = null;
            return -1;
        }
        return a;
    }
    // 6
    int deleteFromTail() {
        if(isEmpty()) return -1;
        int z = tail.getX();
        if(head == tail){
            clear();
            return z;
        }
        Node a = head;
        while(a.next != tail){
            a = a.next;
        }
        a.next = null;
        return z;
    }
    //7
    int deleteAter(Node p) {
        if(isEmpty() || p == null||p.next == null) return -1;
        int x = p.next.getX();
        if(p.next == tail){
            p.next = null;
            tail = p;
            return x;
        }else{
            Node a = p.next;
            Node h = head;
            while(h != a) h = h.next;
            Node b = h.next;
            p.next = b;
            if(b == tail) tail = p.next;
            return x;
        }
    }
    // 8
    void dele(int x) {
        Node a = search(x);
        if(a == head) {deleteFromHead(); return;}
        if(a == tail) {deleteFromTail(); return;}
        Node h = head;
        while(h.next != a){
            h = h.next;
        }
        Node temp = a.next;
        h.next = temp;
        a = null;
    }
    // 9
    Node search(int x){
        Node a = head;
        while(a != null){
            if(a.getX() == x){
                return a;
            }
            a = a.next;
        }
        return null;    
    }
    //10
    int count() {
        int i = 0;
        Node a = head;
        while(a!= null){
            i++;
            a = a.next;
        }
        return i;
    }
    //11
    void deleNode_i_th(int i){
        Node a = null;
        int j = 0;
        Node aa = head;
        while(aa!= null){
            j++;
            if(i == j){
                break;
            }
            aa = aa.next;
        }
        dele(aa.getX());
    }
    //12
    void sort() {
        if(isEmpty()|| count() < 2) return;
        Node a = head, b;
        while(a != null){
            b= a.next;
            while(b!= null){
                if(b.getX()<a.getX()){
                    int c = b.getX(); b.setX(a.getX());a.setX(c);
                }
                b = b.next;
            }
            a = a.next;
        }
    }
    //13
    void dele(Node p) {
        if(isEmpty() || p == null) return;
        if(p == head) {deleteFromHead(); return;}
        if(p == tail) {deleteFromTail(); return;}
        Node a = head;
        int i = 0;
        while(a!= null){
            i++;
            if(a == p){
                break;
            }
            a = a.next;
        }
        deleNode_i_th(i);
    }
    // 14
    int [] toArray() {
        if(isEmpty()) return null;
        int[] arr = new int[count()];
        Node a = head;
        int i = 0;
        while(a!= null){
            arr[i++] = a.getX();
            a = a.next;
        }
        return arr;
    }
    //16
    void addBefore(Node p, int x) {
        if(isEmpty()||p == null) return;
        if(p == head) {addToHead(x);return;}
        Node a = head;
        while(a.next != p){
            a = a.next;
        }
        Node z = new Node(x, p);
        a.next = z;
    }
    //18
    int max() {
        if(isEmpty())return -1;
        int x = head.getX();
        Node a = head;
        while(a!=null){
            if(a.getX()>x){
                x = a.getX();
            }
            a = a.next;
        }
        return x;
    }
    
    //19
    int min() {
        if(isEmpty())return -1;
        int x = head.getX();
        Node a = head;
        while(a!=null){
            if(a.getX()<x){
                x = a.getX();
            }
            a = a.next;
        }
        return x;
    }
    //20
    int sum() {
        if(isEmpty())return -1;
        int x = 0;
        Node a = head;
        while(a!=null){
            x += a.getX();
            a = a.next;
        }
        return x;
    }
    //21
    int avg() {
        if(isEmpty())return -1;
        int x = 0;
        Node a = head;
        while(a!=null){
            x += a.getX();
            a = a.next;
        }
        int avg = (int)x / count();
                
        return avg;
    }
    //22
    boolean sorted() {
        if(isEmpty()) return false;
        Node a = head; 
        while(a.next!=null){
            if(a.getX()>a.next.getX()){
                return false;
            }
            a = a.next;
        }
        return true;
    }
    //23
    void insert(int x){
        if(isEmpty()) return;
        sort();
        Node a = head;
        if(x>max()){
            addToTail(x);
            return;
        }
        if(x<min()){
            addToHead(x);
            return;
        }
        while(a != null){
            if(x <= a.getX()){
                break;
            }
            a = a.next;
        }
        addBefore(a, x);
    }
    //24
    void Reverse(){
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
    
    //15
    boolean Merge(My_List a, My_List b){
        if(a.isEmpty() && b.isEmpty()) return false;
        clear();
        a.sort(); b.sort();
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
    
    //25
    boolean checkSameConten(My_List a, My_List b){
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
}
