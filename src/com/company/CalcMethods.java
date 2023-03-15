package com.company;

public class CalcMethods {

    String[] arguments = new String[3];
    String[] romans = {"","I","II","III","IV","V","VI","VII","VIII","IX","X"};
    String[] romans10 = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC","C"};

    String getNumbers(String s) throws Exception {
        String[] str = s.split("[-+/*]");
        if (str.length == 2) {
            arguments[0] = str[0].trim();
            arguments[1] = str[1].trim();
            if(s.contains("+")) {
                arguments[2] = "+";
            } else if(s.contains("-")) {
                arguments[2] = "-";
            } else if(s.contains("/")) {
                arguments[2] = "/";
            } else {
                arguments[2] = "*";
            }
        } else {
            throw new Exception();
        }
        return calculate(arguments);
    }

    String calculate(String[] arr) throws Exception {
        int a,b;
        String str1 = arr[0];
        String str2 = arr[1];
        String result;
        if(isNumeric(str1) && isNumeric(str2)) {
            a = Integer.parseInt(str1);
            b = Integer.parseInt(str2);
            result = "" + calc(a,b, arr[2]);
        } else if (isRomanNumeric(str1) && isRomanNumeric(str2)) {
            a = getNumber(str1);
            b = getNumber(str2);
            result = convertToRoman(calc(a, b, arr[2]));
        } else {
            throw new Exception();
        }
        return result;
    }

    boolean isNumeric(String string) {
       if(string.matches("^[0-9]+$") && Integer.parseInt(string) < 11) {
           return true;
       } else
           return false;
    }

    boolean isRomanNumeric(String string) {
        if(string.matches("^[I,II,III,IV,V,VI,VII,VIII,IX,X]+$")) {
            return true;
        } else
            return false;
    }

    int getNumber(String string) throws Exception {
        int num = 0;
        for(int i = 0; i < 11; i++) {
            if(romans[i].equals(string)) {
                num = i;
            }
        }
        if(num == 0) {
            throw new Exception();
        }
        return num;
    }

    int calc(int a, int b, String operator) {
        int res = 0;
        switch (operator) {
            case "+":
                res = a + b;
                break;
            case "-":
                res = a - b;
                break;
            case "/":
                res = a / b;
                break;
            case "*":
                res = a * b;
                break;
        }
        return res;
    }

    //максимально возможное число равно 100
    String convertToRoman(int num) throws Exception {
        StringBuilder romanResult = new StringBuilder("");
        if(num <= 100 && num > 0) {
            int a = num/10;
            int b = num % 10;
            romanResult.append(romans10[a]);
            romanResult.append(romans[b]);
        } else {
            throw new Exception();
        }
        return romanResult.toString();
    }

}
