/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validation {
    private static Scanner sc = new Scanner(System.in);
    public static int getInt(String msg, int min, int max) {
        System.out.println(msg);
        int x = -1;
        while (true) {
            try {
                x = Integer.parseInt(sc.nextLine());
                if (x >= min && x <= max) {
                    break;
                }
                System.out.println("please enter from "+min+" - "+ max);
            } catch (NumberFormatException e) {
                System.out.println("Enter Integer number in range: "+min+" - "+max);
            }
        }
        return x;
    }

    public static double getDouble(String msg, double min, double max) {
        System.out.println(msg);
        double x = -1;
        while (true) {
            try {
                x = Double.parseDouble(sc.nextLine());
                if (x >= min && x <= max) {
                    break;
                }
                System.out.println("please enter from "+min+" - "+ max);
            } catch (NumberFormatException e) {
                System.out.println("Enter real number in range: "+min+" - "+max);
            }
        }
        return x;
    }
    
    
}
