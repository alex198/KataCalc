package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine().trim();
            System.out.println(calc(input));
        }

    public static String calc(String input) throws Exception {
        return new CalcMethods().getNumbers(input);
    }

}
