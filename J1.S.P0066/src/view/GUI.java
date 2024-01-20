/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.ExceptionCar;
import control.ManageShowroom;
import java.util.Scanner;
import model.Car;
import model.Color;
import model.Day;

/**
 *
 * @author Admin
 */
public class GUI {

    public static void display() {
        // Function 1: Display Gui And Input Data
        Scanner scanner = new Scanner(System.in);
        try {
            // Get car name
            System.out.print("Enter car name (AUDI, MERCEDES, BMW): ");
            String carName = scanner.nextLine().toUpperCase().trim();
            Car car = ManageShowroom.getCar(carName);
            // Get car color
            System.out.print("Enter car color: ");
            String colorName = scanner.nextLine().toUpperCase().trim();
            Color color = ManageShowroom.getColor(colorName);
            // Get car price
            System.out.print("Enter car price: ");
            String price = scanner.nextLine().trim();
            // Get day of sale
            System.out.print("Enter day of sale: ");
            String dayName = scanner.nextLine().toUpperCase().trim();
            Day day = ManageShowroom.getDay(dayName);
            // Validate customer's request
            Car matchedCar = ManageShowroom.checkCar(car, color, day, price);
            System.out.println("Sell Car\nDo you want find more?(Y/N): ");
            String s = scanner.nextLine();
        } catch (ExceptionCar e) {
            System.out.println(e.getMessage());
        }
    }
}
