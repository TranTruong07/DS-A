/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Bus;
import model.Customer;

/**
 *
 * @author Admin
 */
public class List_Customer {
    Customer head;

    // 2.1. Load data from file
    public void loadFromFile(String fileName) {
        LoadFile l = new LoadFile();
        List<Customer> lb = readBusFromFile(fileName);
        if(lb.isEmpty()){
            System.out.println("list empty");
            return;
        }
        head = null;
        for (Customer cus : lb) {
            addCustomer(cus);
        }
        System.out.println("done");
        
    }
public List<Customer> readBusFromFile(String filePath) {
        List<Customer> listBus = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|\\s*");
                if (data.length == 3) {
                    Customer b = new Customer();
                    b.setCcode(data[0].trim());
                    b.setCus_name(data[1].trim());
                    b.setPhone(data[2].trim());
                    listBus.add(b);
                }
            }
        } catch (IOException e) {
        }

        return listBus;
    }
    // 2.2. Input & add to the end
    public void addCustomer(Customer customer) {
        if (head == null) {
            head = customer;
            return;
        }
        Customer temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = customer;
    }

    // 2.3. Display data
    public void displayData() {
        Customer temp = head;
        while (temp != null) {
            System.out.println(temp.ccode + " " + temp.cus_name + " " + temp.phone);
            temp = temp.next;
        }
    }

    // 2.4. Save customer list to file
    public void saveToFile(String fileName) {
        try {
            PrintWriter writer = new PrintWriter(fileName);
            Customer temp = head;
            while (temp != null) {
                writer.println(temp.ccode + "," + temp.cus_name + "," + temp.phone);
                temp = temp.next;
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error saving to file.");
        }
    }

    // 2.5. Search by ccode
    public Customer searchByCcode(String ccode) {
        Customer temp = head;
        while (temp != null) {
            if (temp.ccode.equals(ccode)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // 2.6. Delete by ccode
    public void deleteByCcode(String ccode) {
        if (head == null) return;
        if (head.ccode.equals(ccode)) {
            head = head.next;
            return;
        }
        Customer temp = head;
        while (temp.next != null && !temp.next.ccode.equals(ccode)) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
}
