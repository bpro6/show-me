package learn.showme.domain;


import java.util.Stack;

public class ShowMeService {

    private final String specialChar = " !@#$%^&*(){}[]:;'<>?,./\"1234567890";


    public String encodeCaesarCypher(String input, int index) {


        char[] phrase = input.toUpperCase().toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (!specialChar.contains("" + phrase[i])) {
                result.append((char) (((((int) phrase[i] - 64) + index - 1) % 26) + 65));
            } else {
                result.append(phrase[i]);
            }
        }
        return result.toString();
    }

    public String decodeCaesarCypher(String input) {


        char[] phrase = input.toUpperCase().toCharArray();
        StringBuilder result = new StringBuilder();
        StringBuilder R1 = new StringBuilder();

        for (int j = 0; j < 26; j++) {
            for (int i = 0; i < input.length(); i++) {
                if (!specialChar.contains("" + phrase[i])) {
                    R1.append((char) (((((int) phrase[i] - 64) + j - 1) % 26) + 65));
                } else {
                    R1.append(phrase[i]);
                }
            }
            result.append(R1).append("\n");
            R1 = new StringBuilder();
        }
        return result.toString();
    }

    public String intToRoman(int input) {

        String res = "";
        int r = input;
        int m = r / 1000;
        for (int i = 0; i < m; i++) {
            res += "M";
        }
        r %= 1000;
        if (r >= 900) {
            res = "CM" + res;
            r -= 900;
        } else if (r >= 500) {
            res += "D";
            r -= 500;
        } else if (r >= 400) {
            res = "CD" + res;
            r -= 400;
        }

        int c = r / 100;
        for (int i = 0; i < c; i++) {
            res += "C";
        }
        r %= 100;

        if (r >= 90) {
            res = "XC" + res;
            r -= 90;
        } else if (r >= 50) {
            res += "L";
            r -= 50;
        } else if (r >= 40) {
            res = "XL";
            r -= 40;
        }
        int x = r / 10;
        for (int i = 0; i < x; i++) {
            res += "X";
        }

        r %= 10;
        if (r == 9) {
            res = "IX" + res;
            r = 0;
        } else if (r >= 5) {
            res += "V";
            r -= 5;
        } else if (r == 4) {
            res += "IV";
            r = 0;
        }
        for (int i = 0; i < r; i++) {
            res += "I";
        }

        return res;

    }

// public String romanToInt(String input) {

//  TODO:

//
//
//
//
//


    // TODO:
    public boolean isValidRomanNum(String rom) {


        String validChars = "IVXLCDM";

        Stack<CharSequence> stack = new Stack<>();

        String s = rom.toUpperCase();

        boolean iOff = false;
        boolean vOff = false;
        boolean xOff = false;
        boolean lOff = false;
        boolean cOff = false;
        boolean dOff = false;
        boolean mOff = false;

        for (int i = 0; i < s.length(); i++) {
            int I = s.length() - 1 - i;

            if (!validChars.contains(s.charAt(I) + "")) {
                return false;
            }

            if (s.charAt(I) == 'I' && iOff &&
                    (stack.peek() != 'X' + "" && stack.peek() != 'V' + "")) {
                return false;
            }
            if (s.charAt(I) == 'V' && vOff) {
                return false;
            } else {
                iOff = true;
                stack.push('V' + "");

            }

            if (s.charAt(I) == 'X' && xOff &&
                    stack.peek() != 'C' + "" && stack.peek() != 'L' + "") {
                return false;
            } else {
                iOff = true;
                vOff = true;
            }

            if (s.charAt(I) == 'L' && lOff) {
                return false;
            } else {
                iOff = true;
                vOff = true;
                xOff = true;
                lOff = true;

                stack.push('V' + "");
            }

            if (s.charAt(I) == 'C' && cOff
                    && stack.peek() != 'D'+"" && stack.peek() != 'M'+""){
                return false;
            }
            else{
                iOff = true;
                vOff = true;
                xOff = true;
                lOff = true;

                stack.push('C' + "");
            }

            if (s.charAt(I) == 'D' && dOff){
                return false;
            }
            else{
                iOff = true;
                vOff = true;
                xOff = true;
                lOff = true;
                dOff = true;

                stack.push('D'+"");
            }

            if(s.charAt(I) == 'M'){
                iOff = true;
                vOff = true;
                xOff = true;
                lOff = true;
                dOff = true;
            }


        }

        return true;

    }

}




