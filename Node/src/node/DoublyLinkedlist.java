/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package node;

/**
 *
 * @author Admin
 */
public interface DoublyLinkedlist<T> extends Iterable<T>{
    void clear();
    
    int size();
    
    boolean isEmpty();
    
    void add(T element);
    
    void addFirst(T element);
    
    void addLast(T element);
    
    T peekFirst();
    
    T peekLast();
    
    T removeFirst();
    
    T removeLast();
    
    T remove(Node<T> node);
    
    boolean remove(Object object);
    
    T removeAt(int index);
    
    int indexOf(Object object);
    
    boolean contans(Object object);
}
