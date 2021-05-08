package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            String[] dest = br.readLine().split(" ");
            int x = Integer.parseInt(dest[0]);
            int y = Integer.parseInt(dest[1]);
            String dir = br.readLine();
            int U = 0, R = 0, D = 0, L = 0;
            for(int i = 0;i<dir.length();i++){
                if(dir.charAt(i) == 'U')
                    U++;
                else if(dir.charAt(i) == 'D')
                    D++;
                else if(dir.charAt(i) == 'L')
                    L++;
                else
                    R++;
            }
            if(y<=U&&x<=R&&x>=0&&y>=0)
                System.out.println("YES");
            else  if(y<=U&&-x<=L&&x<=0&&y>=0)
                System.out.println("YES");
            else  if(-y<=D&&-x<=L&&x<=0&&y<=0)
                System.out.println("YES");
            else  if(-y<=D&&x<=R&&x>=0&&y<=0)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }
}
