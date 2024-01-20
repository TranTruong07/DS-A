/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import control.Circular_Linked_List;

/**
 *
 * @author Admin
 */
public class Test {
    public static void main(String[] args) {
        Circular_Linked_List t = new Circular_Linked_List();
        System.out.println("Test ADD");
        t.addToHead(10);
        System.out.println(t.count());
        t.addToHead(12);
        t.addToTail(5);
        t.traverse();
        System.out.println("");
        t.addAfter(t.search(12), 11);
        t.traverse();
        System.out.println("");
        t.addBefore(t.search(5), 8);
        t.traverse();
        System.out.println("\nTest delete");
        t.deleteFromHead();
        t.traverse();
        System.out.println("");
        t.deleteFromTail();
        t.traverse();
        System.out.println("");
        t.deleteAter(t.search(12));
        t.traverse();
        System.out.println("");
        t.addToHead(10);
        t.addToHead(5);
        t.addToHead(7);
        t.traverse();
        System.out.println("");
        t.deleNode(t.search(5));
        t.traverse();
        System.out.println("");
        t.dele(7);
        t.traverse();
        t.addToTail(4);
        t.addToHead(8);
        System.out.println("");
        t.traverse();
        System.out.println("\nDelete Node thu i");
        t.deleNode_i_th(3);
        t.traverse();
        System.out.println("");
        System.out.println("check sort");
        t.sort();
        t.traverse();
        System.out.println("check merge");
        Circular_Linked_List ab = new Circular_Linked_List();
        Circular_Linked_List bc = new Circular_Linked_List();
        for(int i = 0; i< 4; i++){
            ab.addToHead(i);
        }
        for(int i = 4; i< 7; i++){
            bc.addToTail(i);
        }
        ab.traverse();
        System.out.println("");
        bc.traverse();
        System.out.println("");
        t.Merge(ab, bc);
        t.traverse();
        
        System.out.println("\n Max, min, sum, avg");
        System.out.println(t.max());
        System.out.println(t.min());
        System.out.println(t.sum());
        System.out.println(t.avg());
        
        System.out.println("check sort");
        t.addToHead(20);
        t.traverse();
        System.out.println("");
        System.out.println(t.sorted());
        t.sort();
        t.traverse();
        System.out.println("");
        System.out.println(t.sorted());
        System.out.println("Test insert");
        t.insert(6);
        t.traverse();
        System.out.println("\nTest reverse");
        t.Reverse();
        t.traverse();
        System.out.println("");
        Circular_Linked_List a = new Circular_Linked_List();
        Circular_Linked_List b = new Circular_Linked_List();
        for(int i = 0; i< 4; i++){
            a.addToHead(i);
        }
        a.traverse();
        System.out.println("");
        for(int i = 0; i< 4; i++){
            b.addToHead(i);
        }
        b.traverse();
        System.out.println("\nCheck same content");
        System.out.println(t.checkSameConten(a, b));
        
        System.out.println("check attach");
        t.attach(b);
        t.traverse();
    }
}
