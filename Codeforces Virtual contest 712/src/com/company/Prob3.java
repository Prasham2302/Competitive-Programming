package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Prob3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            int n = Integer.parseInt(br.readLine());
            String order = br.readLine();
            boolean flag = true;
            if(order.charAt(0) == '0') {
                flag = false;
            }
            Stack<Character> a_stack = new Stack<>();
            Stack<Character> b_stack = new Stack<>();
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            for(int i = 0;i<n;i++){
                if(order.charAt(i) == '1'){
                    if(a_stack.size() > 0 && b_stack.size() > 0){
                        a.append(')');
                        b.append(')');
                        a_stack.pop();
                        b_stack.pop();
                    }
                    else{
                        a.append('(');
                        b.append('(');
                        a_stack.push('(');
                        b_stack.push('(');
                    }
                }
                else{
                    if(a_stack.size() > 0 && b_stack.size() >0){
                        if(a_stack.size() > b_stack.size()){
                            a_stack.pop();
                            a.append(')');
                            b.append('(');
                            b_stack.push('(');
                        }
                        else{
                            b_stack.pop();
                            b.append(')');
                            a.append('(');
                            a_stack.push('(');
                        }
                    }
                    else if(a_stack.isEmpty() && b_stack.isEmpty()){
                        flag = false;
                        break;
                    }
                    else if(a_stack.isEmpty()){
                        b_stack.pop();
                        b.append(')');
                        a.append('(');
                        a_stack.push('(');
                    }
                    else if(b_stack.isEmpty()) {
                        a_stack.pop();
                        a.append(')');
                        b.append('(');
                        b_stack.push('(');
                    }
                }
            }
            if(flag && check(a.toString()) && check(b.toString()) && a.toString().equals(b.toString()) == false){
                System.out.println("YES");
                System.out.println(a.toString());
                System.out.println(b.toString());
            }
            else{
                System.out.println("NO");
            }
        }
    }
    public static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i< s.length();i++){
            char curr = s.charAt(i);
            if(curr == '('){
                stack.push(curr);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        if(stack.isEmpty())
            return true;
        else{
            return false;
        }
    }
}
