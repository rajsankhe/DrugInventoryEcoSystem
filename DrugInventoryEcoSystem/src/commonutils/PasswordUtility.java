/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commonutils;

import java.util.Random;

/**
 *
 * @author Tej Sankhe
 */
public class PasswordUtility {
    public static String createPassword(String un){
            Random randomInts =  new Random();
            randomInts.ints(0, 9);
            return un+"@"+(randomInts.ints(0, 9)).findAny().getAsInt()+randomInts.ints(0, 9).findAny().getAsInt()+randomInts.ints(0, 9).findAny().getAsInt();
        }
}
