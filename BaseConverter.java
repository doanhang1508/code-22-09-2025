/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package change.pkg2.pkg10.pkg16;

/**
 *
 * @author Thanh Hang
 */
public class BaseConverter {

    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        int power = 1;
        for(int i= binary.length()-1; i>=0;i--){
            int bit = binary.charAt(i)-'0';
            decimal += bit*power;
            power*=2;
        }
        return decimal;
    }

    public static String decimalToBinary(int decimal) {
        if(decimal==0) return "0";
        StringBuilder sb = new StringBuilder();
        while(decimal>0){
            sb.insert(0,decimal%2);
            decimal/=2;
        }
        return sb.toString();
    }

// ===== Hex <-> Decimal =====
    public static int hexToDecimal(String hex) {
       hex= hex.toUpperCase();
       int decimal = 0;
       int power =1;
       for(int i=hex.length()-1;i>=0;i--){
           char c = hex.charAt(i);
           int digit= (c>='0'&&c<='9')
                   ?(c-'0')
                   :(10+c-'A');
           decimal+=digit*power;
           power*=16;
       }
       return decimal;
    }

    public static String decimalToHex(int decimal) {
        if (decimal == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal%16;
            char c = (remainder<10)
                    ?(char)('0'+remainder)
                    :(char)('A'+remainder-10);
            sb.insert(0,c);
            decimal/=16;
        }
        return sb.toString();
    }

// ===== Binary <-> Hex =====
// Ý tưởng: đổi qua decimal làm trung gian cho dễ
    public static String binaryToHex(String binary) {
        return decimalToHex(binaryToDecimal(binary));
    }

    public static String hexToBinary(String hex) {
        return decimalToBinary(hexToDecimal(hex));
    }

}
