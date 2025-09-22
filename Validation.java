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
    public static String inputValue(String msg, int base) {
     while (true) {
        System.out.print(msg);
        String input = sc.nextLine().trim().toUpperCase();

        boolean isValid = true;

        // kiểm tra hợp lệ theo base
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (base == 2) { // chỉ chấp nhận 0 hoặc 1
                if (c != '0' && c != '1') {
                    isValid = false;
                    break;
                }
            } else if (base == 16) { // 0-9 hoặc A-F
                if (!((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F'))) {
                    isValid = false;
                    break;
                }
            }
        }

        if (isValid && input.length() > 0) {
            return input;
        } else {
            System.out.println("❌ Giá trị không hợp lệ cho hệ cơ số " + base);
        }
    }
}
}
