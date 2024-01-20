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
public class Doubly_Linked_List {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        My_List t = new My_List();
        System.out.println("ADD ELEMENTS");
        t.addToHead(10);
        t.traverse();
        t.addToHead(20);
        t.traverse();
        t.addToTail(1);
        t.traverse();
        t.addAfter(t.search(10), 15);
        t.traverse();
        System.out.println("add befor Node");
        t.addBefore(t.search(15), 12);
        t.traverse();
        System.out.println("DELETE");
        t.deleteFromHead();
        t.traverse();
        t.deleteFromTail();
        t.traverse();
        t.addToTail(3);
        t.addToTail(5);
        t.traverse();
        t.deleteAter(t.search(10));
        t.traverse();
        t.dele(3);
        t.traverse();
        t.addToTail(3);
        t.addToTail(8);
        t.addToTail(2);
        t.addToTail(1);
        t.traverse();
        
        t.deleNode(t.search(3));
        t.traverse();
        
        t.deleNode_i_th(4);
        t.traverse();
        
        System.out.println("Sort");
        t.sort();
        t.traverse();
        System.out.println("");
        
        My_List a = new My_List();
        My_List b = new My_List();
        for(int i = 0; i< 4; i++){
            a.addToHead(i);
        }
        a.traverse();
        for(int i = 0; i< 4; i++){
            b.addToHead(i);
        }
        b.traverse();
        System.out.println("Check same content");
        System.out.println(t.checkSameConten(a, b));
        System.out.println("Merge");
        t.Merge(a, b);
        t.traverse();
        
        System.out.print("Max, Min, Sum, Avg: ");
        System.out.print(t.max()+" "); System.out.print(t.min()+" "); System.out.print(t.sum()+" ");System.out.println(t.avg());
        
        System.out.println("check sort");
        t.addToHead(20);
        t.traverse();
        System.out.println(t.sorted());
        t.sort();
        t.traverse();
        System.out.println(t.sorted());
        System.out.println("check Insert");
        t.traverse();
        t.insert(5);
        t.traverse();
        System.out.println("Reverse");
        t.Reverse();
        t.traverse();
        System.out.println("attach");
        t.attach(a);
        t.traverse();
    }
}
