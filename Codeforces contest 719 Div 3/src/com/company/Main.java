package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
//        Scanner scan = new Scanner(System.in);
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            int len = Integer.parseInt(br.readLine());
            String k = br.readLine();
            HashSet<Character> set = new HashSet<>();
            char curr = k.charAt(0);
            set.add(curr);
            boolean suspicious = false;
            for(int i = 1;i<len;i++){
                char now = k.charAt(i);
                if(curr == now) {
                    continue;
                }
                else{
                    if(set.contains(now)){
                        suspicious = true;
                        break;
                    }
                    else{
                        curr = now;
                        set.add(curr);
                    }
                }
            }
            if(suspicious){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }

        }
    }
}
