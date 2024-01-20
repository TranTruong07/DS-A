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
public class Booking implements Comparable<Booking>{
//    bcode (string): the code of the bus to be booked.
//ccode (string): the code of the customer.
//seat (integer): 
    private String bcode, ccode;
    private int seat;

    public Booking(String bcode, String ccode, int seat) {
        this.bcode = bcode;
        this.ccode = ccode;
        this.seat = seat;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return bcode + "  |  " + ccode + "  |  " + seat;
    }

    @Override
    public int compareTo(Booking o) {
        if(this.bcode.compareTo(o.bcode)== 0){
            return this.ccode.compareTo(o.ccode);
        }else{
            return this.bcode.compareTo(o.bcode);    
        }
    }
    
}
