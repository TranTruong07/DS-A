/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.My_List;
import controller.Validation;

/**
 *
 * @author Admin
 */
public class Gui {

    public static void show() {
        System.out.println("1. Input data\n"
                + "2. Display booking data\n"
                + "3. Sort  by pcode + ccode\n"
                + "4. Exit");
    }
    public static void disPlays(){
        My_List list = new My_List();
        do {
            show();
            int chose = Validation.getInt("Enter your option: ", 1, 4);
            switch (chose) {
                case 1:
                    list.addBooking();
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
}
