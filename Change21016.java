/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package change.pkg2.pkg10.pkg16;

/**
 *
 * @author Thanh Hang
 */
public class Change21016 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== CHƯƠNG TRÌNH CHUYỂN ĐỔI HỆ CƠ SỐ ===");
            System.out.println("1. Binary -> Decimal");
            System.out.println("2. Decimal -> Binary");
            System.out.println("3. Hexadecimal -> Decimal");
            System.out.println("4. Decimal -> Hexadecimal");
            System.out.println("5. Binary -> Hexadecimal");
            System.out.println("6. Hexadecimal -> Binary");
            System.out.println("7. Thoát");

            int choice = Validation.inputInteger("👉 Chọn chức năng (1-7): ", 1, 7);

            if (choice == 7) {
                System.out.println("👋 Thoát chương trình.");
                break;
            }

            switch (choice) {
                case 1: { // Binary -> Decimal
                    String binary = Validation.inputValue("Nhập số nhị phân: ", 2);
                    int result = BaseConverter.binaryToDecimal(binary);
                    System.out.println("✅ Kết quả (Decimal): " + result);
                    break;
                }
                case 2: { // Decimal -> Binary
                    int decimal = Validation.inputInteger("Nhập số thập phân: ", 0, Integer.MAX_VALUE);
                    String result = BaseConverter.decimalToBinary(decimal);
                    System.out.println("✅ Kết quả (Binary): " + result);
                    break;
                }
                case 3: { // Hex -> Decimal
                    String hex = Validation.inputValue("Nhập số hex: ", 16);
                    int result = BaseConverter.hexToDecimal(hex);
                    System.out.println("✅ Kết quả (Decimal): " + result);
                    break;
                }
                case 4: { // Decimal -> Hex
                    int decimal = Validation.inputInteger("Nhập số thập phân: ", 0, Integer.MAX_VALUE);
                    String result = BaseConverter.decimalToHex(decimal);
                    System.out.println("✅ Kết quả (Hexadecimal): " + result);
                    break;
                }
                case 5: { // Binary -> Hex
                    String binary = Validation.inputValue("Nhập số nhị phân: ", 2);
                    String result = BaseConverter.binaryToHex(binary);
                    System.out.println("✅ Kết quả (Hexadecimal): " + result);
                    break;
                }
                case 6: { // Hex -> Binary
                    String hex = Validation.inputValue("Nhập số hex: ", 16);
                    String result = BaseConverter.hexToBinary(hex);
                    System.out.println("✅ Kết quả (Binary): " + result);
                    break;
                }
            }
        }
    }
    
}
