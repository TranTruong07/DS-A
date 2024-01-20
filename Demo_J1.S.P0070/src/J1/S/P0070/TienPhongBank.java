/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0070;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class TienPhongBank {

    private static Scanner sc = new Scanner(System.in);
    private ResourceBundle rsBun;
    private Locale lc;
    private String acount, password, captcha;
    
    public void disPlay() {
        do {
            System.out.println("----------Login----------");
            System.out.println("1. Vietnamese\n"
                    + "2. English\n"
                    + "3. Exit");
            if (slect()) {
                return;
            }
            rsBun = ResourceBundle.getBundle("j1.s.p0070.properties", lc);
            acount = Validation.getRegex(rsBun.getString("Account"), "^[0-9]{10}$", rsBun.getString("AccountErro"));
            password = Validation.getRegex(rsBun.getString("Password"), "^(?=.*[0-9])(?=.*[a-zA-Z])[0-9a-zA-Z]{8,31}$", rsBun.getString("PasswordErro"));
            captcha = getCaptcha(6);
            System.out.println(rsBun.getString("Captcha") + captcha);
            while (true) {                
                System.out.println(rsBun.getString("InputCaptcha"));
                String s = sc.nextLine();
                if (s.equals(captcha)) {
                    System.out.println("Login successful");
                    break;
                } else {
                    System.out.println(rsBun.getString("CaptchaErro"));
                }
            }
            
        } while (true);
    }
    
    private boolean slect() {
        int chose = Validation.getInt("Enter your choice: ", 1, 3);
        if (chose == 1) {
            this.lc = new Locale("vi", "VN");
            return false;
        } else if (chose == 2) {
            this.lc = new Locale("en", "UK");
            return false;
        } else {
            return true;
        }
    }
    private static String character = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    private String getCaptcha(int leng) {
        Random r = new Random();
        
        String s = "";
        do {
            int x = r.nextInt(62);
            s += character.charAt(x);
        } while (s.length() < 6);
        return s;
    }
}
