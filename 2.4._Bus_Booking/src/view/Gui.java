/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BinarySearchTree;
import controller.List_Customer;
import controller.My_List;
import controller.Validation;
import java.util.Scanner;
import model.Bus;
import model.Customer;
import model.TreeTraverseType;

/**
 *
 * @author Admin
 */
public class Gui {

    private static Scanner sc = new Scanner(System.in);

    public static void showMenuBus() {
        System.out.println("1. Load data from file\n"
                + "2. Input & insert data\n"
                + "3. In-order traverse\n"
                + "4. Breadth-first traverse\n"
                + "5. In-order traverse to file\n"
                + "6. Search by pcode\n"
                + "7. Delete by pcode by copying\n"
                + "8. Simply balancing\n"
                + "9. Count number of buses\n"
                + "10. Exit");
    }

    public static void showMenuCustomer() {
        System.out.println("Customer List:");
        System.out.println("1. Load data from file");
        System.out.println("2. Input & add to the end");
        System.out.println("3. Display data");
        System.out.println("4. Save customer list to file");
        System.out.println("5. Search by ccode");
        System.out.println("6. Delete by ccode");
        System.out.println("7. Exit");
    }

    public static void showMenuBooking() {
        System.out.println("1. Input data\n"
                + "2. Display booking data\n"
                + "3. Sort  by pcode + ccode\n"
                + "4. Exit");
    }

    public static void show() {
        System.out.println("1. Bus\n"
                + "2. Customer\n"
                + "3. Booking\n"
                + "4. Exit");
    }

    public static void displays() {
        BinarySearchTree<Bus> BST = new BinarySearchTree<>();
        My_List list = new My_List();
        List_Customer customerList = new List_Customer();
        do {
            show();
            int chose = Validation.getInt("Enter your option: ", 1, 4);
            switch (chose) {
                case 1:
                    BST = displaysBus(BST);
                    break;
                case 2:
                    customerList = disPlaysCustomer(customerList);
                    break;
                case 3:
                    disPlaysBooking(BST, list, customerList);
                    break;
                case 4:
                    return;
            }
        } while (true);
    }

    public static List_Customer disPlaysCustomer(List_Customer customerList) {
        do {
            showMenuCustomer();
            int chose = Validation.getInt("Enter your option: ", 1, 7);

            switch (chose) {
                case 1:
                    customerList.loadFromFile("customer.txt");
                    break;
                case 2:
                    System.out.print("Enter customer ccode: ");
                    String ccode = sc.nextLine();
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter customer phone: ");
                    String phone = sc.nextLine();
                    customerList.addCustomer(new Customer(ccode, name, phone));
                    break;
                case 3:
                    customerList.displayData();
                    break;
                case 4:
                    customerList.saveToFile("customer.txt");
                    break;
                case 5:
                    System.out.print("Enter ccode to search: ");
                    ccode = sc.nextLine();
                    Customer customer = customerList.searchByCcode(ccode);
                    if (customer != null) {
                        System.out.println(customer.ccode + " " + customer.cus_name + " " + customer.phone);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter ccode to delete: ");
                    ccode = sc.nextLine();
                    customerList.deleteByCcode(ccode);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return customerList;
            }
        } while (true);
    }

    public static void disPlaysBooking(BinarySearchTree<Bus> BST, My_List list, List_Customer customerList) {
        do {
            showMenuBooking();
            int chose = Validation.getInt("Enter your option: ", 1, 4);
            switch (chose) {
                case 1:
                    list.addBooking(BST, customerList);
                    break;
                case 2:
                    list.traverse();
                    break;
                case 3:
                    list.sort();
                    break;
                case 4:
                    return;
            }
        } while (true);
    }

    public static BinarySearchTree<Bus> displaysBus(BinarySearchTree<Bus> BST) {
        do {
            showMenuBus();
            int chose = Validation.getInt("Enter your option: ", 1, 10);
            switch (chose) {
                case 1:
                    System.out.println("Load File");
                    BST.load("bus.txt");
                    break;
                case 2:
                    String bcode = BST.getCode("Enter code: ");
                    System.out.println("Enter Bus Name: ");
                    String bName = sc.nextLine();
                    int seat = Validation.getInt("Enter seat: ", 1, Integer.MAX_VALUE);
                    int booked = Validation.getInt("Enter booked: ", 0, seat);
                    double depart_time = Validation.getDouble("Enter depart_time: ", 0, Double.MAX_VALUE);
                    double arrival_time = Validation.getDouble("Enter arrival_time: ", depart_time, Double.MAX_VALUE);
                    Bus b = new Bus(bcode, bName, seat, booked, depart_time, arrival_time);
                    BST.insert(b);
                    break;
                case 3:
                    System.out.println("IN_ORDER");
                    BST.traverse(TreeTraverseType.IN_ORDER);
                    break;
                case 4:
                    System.out.println("BREADTH_FIRST");
                    BST.traverse(TreeTraverseType.BREADTH_FIRST);
                    break;
                case 5:
                    System.out.println("IN_ORDER FROM FILE");
                    BST.inorderFromFile();
                    break;
                case 6:
                    BST.searchByCode();
                    break;
                case 7:
                    BST.deleteByCode();
                    break;
                case 8:
                    BST.balance();
                    break;
                case 9:
                    BST.showCountNode();
                    break;
                case 10:
                    return BST;
            }
        } while (true);
    }
}
