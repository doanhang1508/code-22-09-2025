/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doctor_manager;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Thanh Hang
 */
public class DoctorHash {

    private HashMap<String, Doctor> doctors;

    public DoctorHash() {
        doctors = new HashMap<>();
    }

    /**
     * Thêm một bác sĩ mới
     */
    public boolean addDoctor(Doctor doctor) throws Exception {
        
        
        

        doctors.put(doctor.getCode(), doctor);
        return true;
    }

    /**
     * Cập nhật thông tin bác sĩ
     */
    public boolean updateDoctor(Doctor doctor) throws Exception {
        
        
        doctors.replace(doctor.getCode(), doctor);
        return true;
    }

    /**
     * Xóa thông tin bác sĩ
     */
    public boolean deleteDoctor(Doctor doctor) throws Exception {
         if (doctor == null) {
        throw new Exception("Doctor doesn’t exist");
    }
        if (!doctors.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code doesn’t exist");
        }

        doctors.remove(doctor.getCode());
        return true;
    }

    /**
     * Tìm kiếm bác sĩ theo từ khóa
     */
    public HashMap<String, Doctor> searchDoctor(String input) throws Exception {
        
        HashMap<String, Doctor> result = new HashMap<>();
        for (String key : doctors.keySet()) {
            Doctor d = doctors.get(key);
            if (d.getCode().toLowerCase().contains(input.toLowerCase())
                    || d.getName().toLowerCase().contains(input.toLowerCase())
                    || d.getSpecialization().toLowerCase().contains(input.toLowerCase())) {
                result.put(d.getCode(), d);
            }
        }
        return result;
    }
    public HashMap<String, Doctor> getDoctors() {
    return doctors;
}

    /**
     * Hiển thị toàn bộ danh sách bác sĩ
     */
    public void displayAll() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
        } else {
            List<Doctor> list = new ArrayList<>(doctors.values());
            list.sort(Comparator.comparing(Doctor::getCode)); // sắp xếp theo Code

            System.out.printf("%-10s %-15s %-20s %-12s\n",
                    "Code", "Name", "Specialization", "Availability");
            for (Doctor d : list) {
                System.out.printf("%-10s %-15s %-20s %-12d\n",
                        d.getCode(), d.getName(), d.getSpecialization(), d.getAvailability());
            }
        }
    }

}
