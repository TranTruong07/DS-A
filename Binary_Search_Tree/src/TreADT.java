
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public interface TreADT<T> {
    boolean isEmpty();
    
    int count();
    
    void clear();
    
    int height();
    Node<T> search(T x);
    boolean contains(T element);
    Node<T> min();
    Node<T> max();
   
    int avg();
    void insert(T x) ;
    boolean remove(T element);
    void traverse(TreeTraverseType type);
}
