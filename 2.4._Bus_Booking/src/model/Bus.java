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
public class Bus implements Comparable<Bus>{
//    bcode (string): the code of the bus (this variable is the key of the tree, thus it should be unique for the bus).
//bus_name (string): the name of the bus.
//seat (integer): the number of  seats in the bus (seat > 0).
//booked (integer): the number of  booked seats in the bus (booked >= 0 and booked ≤ seat).
//depart_time (double): The depature time of the bus (depart_time >= 0).
//arrival_time (double)
    
    private String bcode, bus_name;
    private int seat, booked;
    private double depart_time, arrival_time;

    public Bus(String bcode, String bus_name, int seat, int booked, double depart_time, double arrival_time) {
        this.bcode = bcode;
        this.bus_name = bus_name;
        this.seat = seat;
        this.booked = booked;
        this.depart_time = depart_time;
        this.arrival_time = arrival_time;
    }

    public Bus() {
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getBus_name() {
        return bus_name;
    }

    public void setBus_name(String bus_name) {
        this.bus_name = bus_name;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public double getDepart_time() {
        return depart_time;
    }

    public void setDepart_time(double depart_time) {
        this.depart_time = depart_time;
    }

    public double getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(double arrival_time) {
        this.arrival_time = arrival_time;
    }

    @Override
    public String toString() {
        return bcode+"  |  "+bus_name+"  |  "+seat+"  |  "+booked+"  |  "+depart_time+"  |  "+arrival_time;
    }

    @Override
    public int compareTo(Bus o) {
        return this.bcode.compareTo(o.bcode);
    }
    
    
}
