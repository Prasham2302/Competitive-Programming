package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ABBalance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0){
            t--;
            String str = br.readLine();
            int ab = 0;
            int ba = 0;
            char[] strchar = str.toCharArray();
            for(int i = 1;i<str.length();i++){
                int prev = str.charAt(i-1);
                int curr = str.charAt(i);
                if(prev == 'a' && curr == 'b'){
                    ab++;
                }
                else if(prev == 'b' && curr == 'a'){
                    ba++;
                }
            }
            if(ab == ba){
                System.out.println(str);
                continue;
            }
            else if (ab > ba) {
                for(int i = str.length()-1;i>0;i--){
                    if(str.charAt(i) == 'b'){
                        strchar[i] = 'a';
                        ab--;
                    }
                    if(ab == ba){
                        break;
                    }
                }
                System.out.println(new String(strchar));
            }
            else{
                for(int i = str.length()-1;i>0;i--){
                    if(str.charAt(i) == 'a'){
                        strchar[i] = 'b';
                        ba--;
                    }
                    if(ab == ba){
                        break;
                    }
                }
                System.out.println(new String(strchar));
            }
        }
    }
}
