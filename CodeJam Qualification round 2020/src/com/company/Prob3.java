package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Prob3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int p = 1;p<=t;p++){
            StringBuilder stringBuilder = new StringBuilder();
            int n = scan.nextInt();
            int[][] mat = new int[n][4];
//            HashMap<String, Integer> index = new HashMap<>();
//            HashMap<String, Character> ans = new HashMap<>();
            for(int i = 0;i<n;i++){
                mat[i][0] = scan.nextInt();
                mat[i][1] = scan.nextInt();
                mat[i][2] = i;
//                String temp = (mat[i][0]) + " " + (mat[i][1]);
//                index.put(temp,i);
            }
            Arrays.sort(mat, new Comparator<int[]>() {
                @Override
                public int compare(int[] t2, int[] t1) {
                    return Integer.compare(t2[0], t1[0]);
                }
            });
//            System.out.println(Arrays.deepToString(mat));
            boolean flag = true;
            int c = 0, j = 0;
            for(int i = 0;i<n;i++){
                int curr_start = mat[i][0];
                int curr_end = mat[i][1];
                String temp = (mat[i][0]) + " " + (mat[i][1]);
                if(c<=curr_start){
                    c = curr_end;
//                    ans.put(temp,'C');
                    mat[i][3] = 1;
                }
                else if(j <= curr_start){
                    j = curr_end;
                    mat[i][3] = 2;
//                    ans.put(temp,'J');
                }
                else{
                    flag = false;
                    break;
                }
            }
            if(flag == false){
                System.out.println("Case #" +p+": IMPOSSIBLE");
            }
            else{
                Character[] arr = new Character[n];
                for(int i = 0;i<n;i++){
                    String temp = (mat[i][0]) + " " + (mat[i][1]);
                    char person = 'C';
                    if(mat[i][3] == 2 ){
                        person = 'J';
                    }
//                    char person = ans.get(temp);
                    int ind = mat[i][2];
                    arr[ind] = person;
                }
                for(int i = 0;i<n;i++){
                    stringBuilder.append(arr[i]);
                }
                System.out.println("Case #" +p+": "+ stringBuilder.toString());
            }
        }
    }
}
