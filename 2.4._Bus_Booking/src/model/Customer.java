/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Customer {
    public String ccode;
    public String cus_name;
    public String phone;
    public Customer next;

    public Customer() {
    }

    public Customer(String ccode, String cus_name, String phone) {
        this.ccode = ccode;
        this.cus_name = cus_name;
        this.phone = phone;
        this.next = null;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Customer getNext() {
        return next;
    }

    public void setNext(Customer next) {
        this.next = next;
    }
    
}
