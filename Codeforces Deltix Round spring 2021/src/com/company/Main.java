package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t>0){
            t--;
            String[] inp = br.readLine().split(" ");
            int n = Integer.parseInt(inp[0]);
            int m = Integer.parseInt(inp[1]);
            char[] arr;
            arr = br.readLine().toCharArray();
            for(int i = 0;i<m;i++){
                char[] arr2 = new String(arr).toCharArray();
                boolean change = false;
//                System.out.println("arr 2 "+new String(arr2));
                if(arr2[1] == '1'){
                    arr[0] = '1';
                }
                if(arr2[n-2] == '1'){
                    arr[n-1] = '1';
                }

                for(int j = 1;j<n-1;) {

                    if (arr[j] == '0') {
                        if (arr2[j - 1] == '1' && arr2[j + 1] == '0') {
                            arr[j] = '1';
                            j++;
                            change = true;
                        }
                        if (j < n -1 && j > 0 && arr2[j - 1] == '0' && arr2[j + 1] == '1' ) {
                            arr[j] = '1';
                            j++;
                            change = true;
                        }
                        j++;
                    }
                    else{
                        j++;
                    }
                }
                if(change == false){
                    break;
                }
            }
            System.out.println(new String(arr));
        }
    }
}
