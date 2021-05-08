package com.company;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Scanner;

public class Main {
    public static boolean isPalindrome(String s){
        String reverse = new StringBuffer(s).reverse().toString();
        if (s.equals(reverse))
            return true;
        else
            return false;
    }
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            String string = br.readLine();
            boolean flag = false;
            StringBuilder stringBuilder = new StringBuilder(string);
            for(int i = 0;i<string.length();i++){
                if(stringBuilder.charAt(i) != 'a'){
                    stringBuilder.insert(string.length()  - i, 'a');
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println("YES");
                System.out.println(stringBuilder.toString());
            }
            else
                System.out.println("NO");
        }
    }
}
