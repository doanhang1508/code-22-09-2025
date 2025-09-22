/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package checkform;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

/**
 *
 * @author Thanh Hang
 */
public class Validation {
    public static String checkPhone(String phone){
        if(!phone.matches("\\d+")){
            return "Phone number must be number"; 
        }
        if(phone.length()!=10){
            return "Phone number must be 10 digits";
        }
        return "";
    }
    public static String checkDate(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try{
            sdf.parse(date);
            return "";
        }catch(ParseException e){
            return "Date to correct format(dd/MM/yyyy)";
        }
    }
     public static String checkEmail(String email){
         String regex = "^[A-Za-z0-9+_.-]+@gmail\\.com$";
         if(!Pattern.matches(regex, email)){
             return "Email must be correct format";
         }
         return "";
     }
}
