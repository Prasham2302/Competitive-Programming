package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String[]> input = new ArrayList<>();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\\s");
                System.out.println(1);
                System.out.println(Arrays.toString(tokens));
                input.add(tokens);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(input.size());
    }
}
