/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0070;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validation {
    public static Scanner sc = new Scanner(System.in);
    public static int getInt(String msg, int min, int max){
        int x = -1;
        System.out.println(msg);
        while (true) {            
            try {
               x = Integer.parseInt(sc.nextLine());
               if(x <= max && x >= min){
                   break;
               }
               throw new Exception();
            } catch (Exception e) {
                System.out.println("Please enter integer number in range: "+min+" - "+max);
            }
        }
        return x;
    }

    static String getRegex(String msg, String regex, String erromsg) {
        String x = "";
        System.out.println(msg);
        while (true) {            
            try {
               x = sc.nextLine();
               if(x.matches(regex)){
                   break;
               }
               throw new Exception();
            } catch (Exception e) {
                System.out.println(erromsg);
            }
        }
        return x;
    }
}
