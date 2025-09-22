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

    private static DoctorHash dh = new DoctorHash();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nDOCTOR MANAGEMENT PROGRAM");
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Search Doctor");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(sc.nextLine().trim());
            try {
                switch (choice) {
                    case 1: addDoctorUI(); break;
                    case 2: updateDoctorUI(); break;
                    case 3: deleteDoctorUI(); break;
                    case 4: searchDoctorUI(); break;
                    case 5:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void addDoctorUI() throws Exception {
        String code;
        while (true) {
        code = Validation.inputString("Enter code: ", "[A-Za-z0-9]+").trim().toUpperCase();
        if (dh.getDoctors().containsKey(code)) {
            System.out.println("Doctor code " + code + " already exists. Please enter another one.");
        } else {
            break; // hợp lệ, thoát khỏi vòng lặp
        }
    }
        String name = Validation.inputString("Enter name: ", "[\\p{L} ]+");
        String specialization = Validation.inputString("Enter specialization: ", "[\\p{L} ]+");
        int avail = Validation.inputInteger("Enter availability: ", 0, Integer.MAX_VALUE);

        dh.addDoctor(new Doctor(code, name, specialization, avail));
        System.out.println("Doctor added successfully!");
    }

    private static void updateDoctorUI() throws Exception {
        String code = Validation.inputString("Enter code to update: ", "[A-Za-z0-9 ]+").trim().toUpperCase();
        Doctor oldDoc = dh.getDoctors().get(code);
        if (oldDoc == null) {
            throw new Exception("Doctor code doesn’t exist");
        }

        System.out.print("Enter new name (blank to skip): ");
        String name = sc.nextLine().trim();
        if (!name.isEmpty()) oldDoc.setName(name);

        System.out.print("Enter new specialization (blank to skip): ");
        String spec = sc.nextLine().trim();
        if (!spec.isEmpty()) oldDoc.setSpecialization(spec);

        System.out.print("Enter new availability (blank to skip): ");
        String avail= sc.nextLine().trim();
        if (!avail.isEmpty()) {
            int newAvail = Integer.parseInt(avail);
            if (newAvail < 0) throw new Exception("Availability must be >= 0");
            oldDoc.setAvailability(newAvail);
        }

        dh.updateDoctor(oldDoc);
        System.out.println("Doctor updated successfully!");
    }

    private static void deleteDoctorUI() throws Exception {
        String code = Validation.inputString("Enter code to delete: ", "[A-Za-z0-9 ]+").trim().toUpperCase();
        Doctor delDoc = dh.getDoctors().get(code);
        dh.deleteDoctor(delDoc);
        System.out.println("Doctor deleted successfully!");
    }

    private static void searchDoctorUI() throws Exception {
        String search = Validation.inputString("Enter keyword to search: ", "[A-Za-z0-9 ]+");
        HashMap<String, Doctor> result = dh.searchDoctor(search);
        if (result.isEmpty()) {
            System.out.println("No doctor found.");
        } else {
            System.out.printf("%-10s%-20s%-20s%-5s\n", "Code", "Name", "Specialization", "Avail");
            for (Doctor d : result.values()) {
                System.out.println(d);
            }
        }
    }
}
