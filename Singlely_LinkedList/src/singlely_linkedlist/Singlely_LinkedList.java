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
public class Singlely_LinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        My_List t = new My_List();
        // add to head
//        t.traverse();
//        System.out.println("");
//        // add to tail
//        t.addToTail(8);
//        t.addToHead(3);
//        t.traverse();
//        
//        // delete from head
//        t.deleteFromHead();
//        t.traverse();
//        // delete from tail
//        t.deleteFromTail();
//        t.traverse();

        for (int i = 0; i < 5; i++) {
            t.addToTail(i);
        }
        t.traverse();
        //
        Node a = t.search(3);
        t.deleteAter(a);
        t.traverse();
        t.dele(2);
        t.traverse();
        t.addAfter(a, 10);
        t.traverse();

        System.out.println("Number nodes: " + t.count());
        t.deleNode_i_th(3);
        t.traverse();
        System.out.println("");
        t.addToHead(5);
        t.traverse();
        t.sort();
        t.traverse();
        
        System.out.println("");
        Node z = t.search(5);
        t.dele(z);
        t.traverse();
        System.out.println("");
        for (int arg : t.toArray()) {
            System.out.print(arg+" ");
        }
        System.out.println("");
        
        Node g = t.search(1);
        t.addBefore(g, 8);
        t.traverse();
        
        // max, min, sum, avg
        System.out.println("");
        System.out.println(t.max());
        System.out.println(t.min());
        System.out.println(t.sum());
        System.out.println(t.avg());
        
        // check sort
        System.out.println("Sort: "+t.sorted());
        t.traverse();
        t.sort();
        System.out.println("Sort: "+t.sorted());
        t.traverse();
        
        System.out.println("");
        t.insert(11);
        t.traverse();
        
        System.out.println("");
        
        t.Reverse();
        t.traverse();
        System.out.println("");
        // check merge
        System.out.println("check merge");
        My_List ab = new My_List();
        My_List bc = new My_List();
        for(int i = 0; i< 4; i++){
            ab.addToHead(i);
        }
        for(int i = 4; i< 7; i++){
            bc.addToTail(i);
        }
        ab.traverse();
        bc.traverse();
        t.Merge(ab, bc);
        t.traverse();
//        System.out.println("check same conten");
//        My_List ab = new My_List();
//        My_List bc = new My_List();
//        for(int i = 0; i< 4; i++){
//            ab.addToHead(i);
//        }
//        ab.traverse();
//        for(int i = 0; i< 4; i++){
//            bc.addToTail(i);
//        }
//        bc.traverse();
//        System.out.println(t.checkSameConten(ab, bc)); 
    }

}
