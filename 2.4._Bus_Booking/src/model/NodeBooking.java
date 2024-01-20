package model;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class NodeBooking<T> {
    private T data;
    private NodeBooking<T> next;

    public NodeBooking(T data, NodeBooking<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeBooking<T> getNext() {
        return next;
    }

    public void setNext(NodeBooking<T> next) {
        this.next = next;
    }

    

}
