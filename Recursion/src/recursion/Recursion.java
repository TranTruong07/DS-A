/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author Admin
 */
public class Recursion {

    public int giaithua(int n){
        if(n == 1){
            return 1;
        }else{
            return n*giaithua(n-1);
        }
    }
    public static void main(String[] args) {
        Recursion r = new Recursion();
        System.out.println(r.giaithua(5));
    }
    
}
