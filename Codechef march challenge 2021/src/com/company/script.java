package com.company;
import java.io.FileNotFoundException;
import java.io.PrintWriter; // Step 1
import java.io.IOException;

public class script {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter out = new PrintWriter("test_cases2.txt");
        int cases = 1;
        out.println(cases);
        int Min = 1, Max = 100;
        long min = 0, max = 60;
        while(cases > 0){
            cases--;
            int n = Min + (int)(Math.random() * ((Max - Min) + 1));
            out.println(n);
            for(int i = 0;i<n;i++){
                long power = min + (long)(Math.random() * ((max - min) + 1));
                out.print((long)Math.pow(2,power)+" ");
            }
            out.println();
        }
    }
}
