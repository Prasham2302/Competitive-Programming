package com.company;

import java.util.Scanner;

public class INTXOR {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            long c = scan.nextLong();
            String binary = Long.toBinaryString(c);
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            a.append("1");
            b.append("0");
            for(int i = 1;i<binary.length();i++){
                if(binary.charAt(i) == '1'){
                    b.append("1");
                    a.append("0");
                }
                else{
                    a.append("1");
                    b.append("1");
                }
            }
//            System.out.println(a.toString() + " " +b.toString());
            long mul = Long.parseLong(a.toString(),2) * Long.parseLong(b.toString(),2);
            System.out.println(mul);
        }
    }
}
