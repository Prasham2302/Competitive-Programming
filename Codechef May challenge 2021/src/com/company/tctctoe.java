package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class tctctoe {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            char[][] inp = new char[3][3];
            for(int i = 0;i<3;i++){
                inp[i] = br.readLine().toCharArray();
            }
            int x = 0;
            int o = 0;
            for(int i = 0;i<3;i++){
                if(inp[i][0] == inp[i][1] && inp[i][1] == inp[i][2]){
                    if(inp[i][0] == 'X'){
                        x++;
                    }
                    else if(inp[i][0] == 'O'){
                        o++;
                    }
                }
            }
            for(int i = 0;i<3;i++){
                if(inp[0][i] == inp[1][i] && inp[1][i] == inp[2][i]){
                    if(inp[0][i] == 'X'){
                        x++;
                    }
                    else if(inp[0][i] == 'O'){
                        o++;
                    }
                }
            }
            if(inp[0][0] == inp[1][1] && inp[1][1] == inp[2][2]){
                if (inp[0][0] == 'X') {
                    x++;
                }
                else if(inp[0][0] == 'O'){
                    o++;
                }
            }
            if(inp[0][2] == inp[1][1] && inp[1][1] == inp[2][0]){
                if(inp[1][1] == 'X'){
                    x++;
                }
                else if(inp[1][1] == 'O'){
                    o++;
                }
            }
            int count_x = 0;
            int count_o = 0;
            int count__ = 0;
            for(int i = 0;i<3;i++){
                for(int j = 0;j<3;j++){
                    if(inp[i][j] == 'X'){
                        count_x++;
                    }
                    else if(inp[i][j] == 'O'){
                        count_o++;
                    }
                    else{
                        count__++;
                    }
                }
            }
//            System.out.println(count_x +" "+count__+" "+count_o);
//            System.out.println(x+" "+o);
            if(count_o > count_x || count_x - count_o > 1)
                System.out.println(3);
            else if(count_x>count_o && x == 1 && o == 0){
                System.out.println(1);
            }
            else if(count_x == count_o && o == 1 && x == 0){
                System.out.println(1);
            }
            else if(count__ == 0 && ((x+o == 0) || (x == 2))){
                System.out.println(1);
            }
            else if(count__ > 0 && (x+o == 0)){
                System.out.println(2);
            }
            else{
                System.out.println(3);
            }
        }

    }
}
