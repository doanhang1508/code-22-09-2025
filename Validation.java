/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doctor_manager;

/**
 *
 * @author Thanh Hang
 */
import java.util.Scanner;

public class Validation {
         private static Scanner sc = new Scanner(System.in);

    /**
     * Nhập số nguyên trong khoảng [min, max]
     */
    public static int inputInteger(String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                String line = sc.nextLine().trim();
                int value = Integer.parseInt(line);
                if (value < min || value > max) {
                    System.out.println("Value must be between " + min + " and " + max);
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    /**
     * Nhập chuỗi theo regex (ví dụ: cho phép cả khoảng trắng)
     */
    public static String inputString(String msg, String regex) {
        while (true) {
            System.out.print(msg);
            String value = sc.nextLine().trim();
            if (value.isEmpty()) {
                System.out.println("Input cannot be empty.");
            } else if (!value.matches(regex)) {
                System.out.println("Invalid input format.");
            } else {
                return value;
            }
        }
    }

    /**
     * Nhập availability (>= 0)
     */
    public static int inputAvailability(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                String line = sc.nextLine().trim();
                int value = Integer.parseInt(line);
                if (value < 0) {
                    System.out.println("Availability must be >= 0");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }
}
