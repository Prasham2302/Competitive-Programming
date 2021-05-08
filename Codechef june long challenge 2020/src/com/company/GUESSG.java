package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GUESSG {
    static int even_st = 1, odd_st = 1;
    static int even_end,odd_end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 1;
        int even = n/2;
        int odd = n/2;
        even_end = n;
        odd_end = n;
        String curr = "S";

        while(curr.charAt(0) != 'E') {
            //System.out.println("in loop");
            if(count %2 == 1){
                System.out.println(odd);
            }
            else{
                System.out.println(even);
            }
            curr = br.readLine();
            if (curr.charAt(0) == 'E') {
                System.exit(0);
            }
            if(count % 2 == 0){
                even = binary(even,curr,count);
            }
            else{
                odd = binary(odd,curr,count);
            }
            count++;
        }
    }

    public static int binary(int num, String curr,int count) {
        if(count%2 == 0){
            if(curr.charAt(0) == 'G'){
                even_st = num+1;
            }
            else{
                even_end = num;
            }
            num = (even_st+even_end)/2;
        }
        else{
            if(curr.charAt(0) == 'G'){
                odd_st = num;
            }
            else{
                odd_end = num;
            }
            num = (odd_st+odd_end)/2;
        }
        return num;
    }
}
