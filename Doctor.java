/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doctor_manager;

/**
 *
 * @author Thanh Hang
 */
public class Doctor {
     private String code;
    private String name;
    private String specialization;
    private int availability;

    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code.replaceAll("\\s+", "").toUpperCase();
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    // Getter & Setter
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        if (specialization != null && !specialization.trim().isEmpty()) {
            this.specialization = specialization;
        }
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        if (availability >= 0) {
            this.availability = availability;
        }
    }

    @Override
    public String toString() {
        return String.format("Code: %s | Name: %s | Specialization: %s | Availability: %d",
                code, name, specialization, availability);
    }
}
