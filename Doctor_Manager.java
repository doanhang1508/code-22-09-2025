/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package doctor_manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Thanh Hang
 */
public class Doctor_Manager {

    /**
     * @param args the command line arguments
     */
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        DoctorHash db = new DoctorHash();

        while (true) {
            System.out.println("====Doctor Manager====");
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Serach Doctor");
            System.out.println("5. Display");
            System.out.println("6. Exit");

            try {
                int choice = Validation.inputInteger("Enter your choice: ", 1, 5);
                switch (choice) {
                    case 1:
                        addDoctorUI(db);
                        break;
                    case 2:
                        updateDoctorUI(db);
                        break;
                    case 3:
                        deleteDoctorUI(db);
                        break;
                    case 4:
                        searchDoctorUI(db);
                        break;
                    case 5:
                        db.displayAll();
                        break;
                    case 6: 
                        System.out.println("Exiting...");
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }

    public static void addDoctorUI(DoctorHash db) throws Exception {
        System.out.println("----Add Doctor----");
        String code = Validation.inputString("Enter code: ", "[A-Za-z0-9 ]+");
        String name = Validation.inputString("Enter name: ", "[\\p{L} ]+");
        String spec = Validation.inputString("Enter Specialization: ", "[\\p{L} ]+");
        int avail = Validation.inputAvailability("Enter Availability: ");

        Doctor d = new Doctor(code, name, spec, avail);
        db.addDoctor(d);
        System.out.println("Doctor added successfully.");
    }

    public static void updateDoctorUI(DoctorHash db) throws Exception {
        System.out.println("----Update Doctor----");
        String code = Validation.inputString("Enter code: ", "[A-Za-z0-9 ]+");

        System.out.println("Enter name: ");
        String name = sc.nextLine();
        if (!name.trim().isEmpty() && !name.matches("[\\p{L} ]+")) {
            System.out.println("Invalid name. Keeping old name");
            name = "";
        }
        System.out.println("Enter Specialization: ");
        String spec = sc.nextLine();
        if (!spec.trim().isEmpty() && !spec.matches("[\\p{L} ]+")) {
            System.out.println("Invalid specialization. Keeping old specialization");
            spec = "";
        }
        System.out.println("Enter Availability: ");
        int avail = Integer.parseInt(sc.nextLine().trim());
        try {
            if (avail < 0) {
                System.out.println("Invalid availability. Keeping old availability");
                avail = -1;
            }
        } catch (NumberFormatException e) {
            avail = -1;
        }
        Doctor d = new Doctor(code, name, spec, avail);
        db.updateDoctor(d);
        System.out.println("Doctor updated successfully.");
    }
    
    public static void deleteDoctorUI(DoctorHash db) throws Exception{
        System.out.println("----Delete Doctor----");
        String code = Validation.inputString("Enter code: ", "[A-Za-z0-9 ]+");
        Doctor d = new Doctor(code, null, null, 0);
        db.deleteDoctor(d);
        System.out.println("Doctor deleted successfully.");      
    }
    public static void searchDoctorUI(DoctorHash db) throws Exception{
        System.out.println("----Search Doctor----");
        String input = Validation.inputString("Enter text: ", ".+");
        HashMap<String,Doctor> result = db.searchDoctor(input);
        if(result.isEmpty()){
            System.out.println("Not found.");
        }else{
            System.out.println("------Result--------");
            System.out.printf("%-10s %-15s %-20s %-12s\n","Code", "Name", "Specializtion", "Availability");
            for(Doctor d : result.values()){
                System.out.printf("%-10s %-15s %-20s %-12s\n",d.getCode(), d.getName(), d.getSpecialization(), d.getAvailability());
            }
        }
    }
}
