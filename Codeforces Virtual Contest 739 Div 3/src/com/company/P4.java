package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class P4 {
    public static boolean check(String num ){
        HashSet<Character> set = new HashSet<>();
        for(char curr : num.toCharArray()){
            set.add(curr);
        }
        return set.size() == 2;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-- > 0 ){
            int n = scan.nextInt();
            int k = scan.nextInt();
            if(k == 1){
                char[] num = Integer.toString(n).toCharArray();
                char first = num[0];
                char[] target = new char[num.length];
                Arrays.fill(target,first);
                String temp = new String(target);
//                System.out.println("temp "+temp);
                if(temp.compareTo(new String(num)) >= 0){
                    System.out.println(temp);
                    continue;
                }
                else if(first != '9'){
                    Arrays.fill(target, (char) (first+1));
                    System.out.println(new String(target));
                    continue;
                }
                else{
                    Arrays.fill(target,'1');
                    System.out.println(new String(target)+"1");
                    continue;
                }
            }
            else{
                String input = Integer.toString(n);
                if(check(input)){
                    System.out.println(input);
                    continue;
                }
                char[] num = Integer.toString(n).toCharArray();
                char first = num[0];
                String withK1 = "";
                char[] target = new char[num.length];
                Arrays.fill(target,first);
                String temp = new String(target);
//                System.out.println("temp "+temp);
                if(temp.compareTo(new String(num)) >= 0){
                    withK1 = temp;
                }
                else if(first != '9'){
                    Arrays.fill(target, (char) (first+1));
                    withK1 = new String(target);
                }
                else{
                    Arrays.fill(target,'1');
                    withK1 = (new String(target)+"1");
                }
                int p1 = 0;
                int p2 = 0;
                if(withK1.length() > input.length()){
                    p1++;
                }
            }
        }
    }
}
