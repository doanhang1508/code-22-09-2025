/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package checkform;

import java.util.Scanner;

/**
 *
 * @author Thanh Hang
 */
public class CheckForm {

 
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String phone, email, date, msg;
       while (true) {
            System.out.print("Enter phone number: ");
            phone = sc.nextLine();
            msg = Validation.checkPhone(phone);
            if (msg.isEmpty()) break;  // hợp lệ, thoát vòng lặp
            System.out.println(msg);
        }

        // Nhập ngày
        while (true) {
            System.out.print("Enter date (dd/MM/yyyy): ");
            date = sc.nextLine();
            msg = Validation.checkDate(date);
            if (msg.isEmpty()) break;
            System.out.println(msg);
        }

        // Nhập email
        while (true) {
            System.out.print("Enter email: ");
            email = sc.nextLine();
            msg = Validation.checkEmail(email);
            if (msg.isEmpty()) break;
            System.out.println(msg);
        }

        System.out.println("\nAll inputs are correct!");
    }
    
}
