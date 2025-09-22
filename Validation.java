/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package change.pkg2.pkg10.pkg16;

import java.util.Scanner;

/**
 *
 * @author Thanh Hang
 */
public class Validation {
    private static Scanner sc = new Scanner(System.in);

    /**
     * Nhập số nguyên trong khoảng [min, max]
     */
    public static int inputInteger(String msg, int min, int max){
        int input;
        while(true){
            try{
                 System.out.println(msg);
                input=Integer.parseInt(sc.nextLine().trim());
                if(input<min||input>max){
                    System.out.println("Invalid input!");
                }else{
                    return input;
                }
            }catch(NumberFormatException e){
                System.out.println("Please enter a number!");
            }
        }
    }
    public static int parseCustom(String value, int base) {
    value = value.trim().toUpperCase();
    int result = 0;

    for (int i = 0; i < value.length(); i++) {
        char c = value.charAt(i);
        int digit;

        if (c >= '0' && c <= '9') {
            digit = c - '0';
        } else if (c >= 'A' && c <= 'Z') {
            digit = 10 + (c - 'A');
        } else {
            throw new NumberFormatException("Ký tự không hợp lệ: " + c);
        }

        if (digit >= base) {
            throw new NumberFormatException(
                "Ký tự '" + c + "' không hợp lệ trong hệ cơ số " + base
            );
        }

        result = result * base + digit;
    }

    return result;
}
    public static String inputValue(String msg, int base){
        while(true){
            System.out.println(msg);
            String value = sc.nextLine().trim();
            try{
                parseCustom(value, base);
                return value;
            }catch(NumberFormatException e){
                System.out.println("Input not invalid in base " +base );
            }
        }
    }
}
