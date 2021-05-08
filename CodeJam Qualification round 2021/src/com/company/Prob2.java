package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Prob2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int TestNumber = 1;TestNumber <= t; TestNumber++){
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String painting = input[2];

            int total_cost = 0;


            painting = removeDuplicates(painting);
            //Removed duplicates
//            System.out.println(painting);
            if(painting.charAt(0) == '?'){
                painting = painting.substring(1);
            }
            int len = painting.length();
            if(len < 2){
                System.out.println("Case #" +TestNumber +": 0");
            }
            else{
                if(painting.charAt(len-1) == '?'){
                    painting = painting.substring(0,len-1);
                }
                StringBuilder st = new StringBuilder(painting);
                //Replacing ? with C and J
                for(int i = 1;i<painting.length()-1;i++){
                    if(painting.charAt(i) == '?'){
                        if((painting.charAt(i-1) == 'C' && painting.charAt(i+1) == 'J') || (painting.charAt(i-1) == 'J' && painting.charAt(i+1) == 'C')){
                            st.setCharAt(i, 'J');
                        }
                        else if(painting.charAt(i-1) == 'C' && painting.charAt(i+1) == 'C'){
                            st.setCharAt(i, 'C');
                        }
                        else if(painting.charAt(i-1) == 'J' && painting.charAt(i+1) == 'J'){
                            st.setCharAt(i, 'J');
                        }
                    }
                }
                painting = st.toString();
                //Calculating cost
                for(int i = 0;i<painting.length()-1;i++){
                    if(painting.charAt(i) == 'C' && painting.charAt(i+1) == 'J'){
                        total_cost += x;
                    }
                    else if(painting.charAt(i) == 'J' && painting.charAt(i+1) == 'C'){
                        total_cost+=y;
                    }
                }

                System.out.println("Case #" +TestNumber +": "+total_cost);
            }

        }
    }

    private static String removeDuplicates(String painting) {
        Stack<Character> stack = new Stack<>();
        stack.push(painting.charAt(0));
        for(int i = 1;i<painting.length();i++){
            if(stack.peek() != painting.charAt(i)){
                stack.push(painting.charAt(i));
            }
        }
        StringBuilder st = new StringBuilder();
        for(Character ch : stack){
            st.append(ch);
        }
        return st.toString();
    }
}
