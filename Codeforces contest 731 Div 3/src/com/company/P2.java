package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            String curr = br.readLine();
            int left = 0;
            int right = curr.length()-1;
            char max = 'z';
            if(curr.length() == 1 && curr.charAt(0) == 'a'){
                System.out.println("YES");
                continue;
            }
            else if(curr.length() == 1){
                System.out.println("NO");
                continue;
            }
            if(curr.charAt(left) > curr.charAt(right)){
                max = curr.charAt(left);
                left++;
            }
            else{
                max = curr.charAt(right);
                right--;
            }
            boolean passed  = true;
            while(left <= right){

                if(curr.charAt(left) == max - 1){
                    max = curr.charAt(left);
                    left++;
                }
                else if(curr.charAt(right) == max - 1){
                    max = curr.charAt(right);
                    right--;
                }
                else{
                    passed = false;
                    break;
                }
            }
            if(passed && max == 'a'){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
