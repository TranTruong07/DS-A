/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doubly_linked_list;

/**
 *
 * @author Admin
 */
public class My_List {
    Node head, tail;

    public My_List() {
        head = tail = null;
    }
    
    boolean isEmpty() {
        return count() == 0;
    }

    void clear() {
        head = tail = null;
    }

    //10
    private int count() {
        int i = 0;
        Node a = head;
        while(a != null){
            i++;
            a = a.next;
        }
        return i;
    }
    //1
    void addToHead(int x) {
        if(isEmpty()) {head = tail = new Node(x, null, null); return;}
        Node a = new Node(x, null, head);
        head.setPrev(a);
        head = head.prev;
    }
    //2
    void addToTail(int x) {
        if(isEmpty()) {head = tail = new Node(x, null, null); return;}
        Node a = new Node(x, tail, null);
        tail.setNext(a);
        tail = tail.next;
    }
    //3
    void addAfter(Node p, int x) {
        if(isEmpty() || p == null) return;
        if(p == tail) {addToTail(x); return;}
        Node a = p.next;
        Node b = new Node(x, p, a);
        a.setPrev(b);
        p.setNext(b);
    }
    //4
    void traverse() {
        if(isEmpty()) return;
        String s = "";
        Node a = head;
        while(a!= null){
            s += a.getX()+ "  ";
            a = a.next;
        }
        s+= "";
        System.out.println(s);
    }
    //5
    int deleteFromHead() {
        if(isEmpty()) return -1;
        int x = head.getX();
        if(head.next == null) {clear(); return x;}
        head = head.next;
        head.setPrev(null);
        return x;
    }
    //6
    int deleteFromTail(){
        if(isEmpty()) return -1;
        int x = tail.getX();
        if(tail.prev == null) {clear(); return x;}
        tail = tail.prev;
        tail.setNext(null);
        return x;
    } 
    //7
    int deleteAter(Node p) {
        if(isEmpty()|| p == null || p.next == null) return -1;
        int x = p.next.getX();
        if(p.next == tail) {deleteFromTail(); return x;}
        Node a = p.next;
        Node b = a.next;
        p.setNext(b);
        b.setPrev(p);
        a = null;
        return x;
    }
    //8
    void dele(int x){
        Node a = search(x);
        if(a== null) return;
        deleteAter(a.prev);
    }
    //9
    Node search(int x) {
        if(isEmpty()) return null;
        Node a = head;
        while(a.getX()!= x){
            a = a.next;
        }
        if(a.getX() == x){
            return a;
        }else{
            return null;
        }
    }
    //11
    void deleNode_i_th(int i) {
        if(isEmpty()) return;
        int j = 0;
        Node a = head;
        while(a!= null){
            j++;
            if(j == i){
                deleNode(a);
                return;
            }
            a = a.next;
        }
    }
    //13
    void deleNode(Node p) {
        if(isEmpty()||p == null) return;
        if(p  == head) {deleteFromHead(); return;}
        if(p == tail) {deleteFromTail(); return;}
        Node a = head;
        while(a!= null){
            if(a == p){
                break;
            }
            a = a.next;
        }
        if(a != null){
            Node b = p.next;
            Node c = p.prev;
            c.setNext(b);
            b.setPrev(c);
            p = null;
        }else{
            return;
        }
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
    //16
    void addBefore(Node p, int x) {
        if(isEmpty()||p==null) return;
        if(p == head) {addToHead(x); return;}
        Node h = head;
        while(h.next != p){
            h = h.next;
        }
        
        Node a = new Node(x, h, p);
        h.setNext(a);
        p.setPrev(a);
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
    // 17 
    public void attach(My_List otherList) {
        if (head == null) {
            head = otherList.head;
        } else {
            Node a = otherList.head;
            tail.setNext(a);
            a.setPrev(tail);
        }
    }
}
