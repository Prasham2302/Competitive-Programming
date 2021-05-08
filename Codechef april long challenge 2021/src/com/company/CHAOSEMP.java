package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHAOSEMP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int t = Integer.parseInt(st[0]);
        int q = Integer.parseInt(st[1]);
        int d = Integer.parseInt(st[2]);
        while(t>0) {
            t--;
            long lx = -1 * ((long) Math.pow(10, 18));
            long ly = -1 * ((long) Math.pow(10, 18));
            long rx = 1 * ((long) Math.pow(10, 18));
            long ry = 1 * ((long) Math.pow(10, 18));
            lx--;
            ly--;
            ry++;
            rx++;
            long curr = 1;
            String ans = "";
            if (d == 0) {
                boolean hellfire = true;
                long l = -2*((long) Math.pow(10,18));
                long y1 = -2*((long) Math.pow(10,18)) ;
                long r = 2*((long) Math.pow(10,18)) ;
                long y2 = 2*((long) Math.pow(10,18));
                while(l<=r){
                    long mid = (l+r)/2;
                    if(hellfire){
                        System.out.println(1 +" "+mid +" "+y1);
                        System.out.flush();
                    }
                    else{
                        System.out.println(2+" "+mid+" "+y1+" "+mid+" "+y2);
                        System.out.flush();
                    }
                    ans = br.readLine();
                    if(ans.charAt(0) == 'X'){
                        hellfire = false;
                    }
                    else if(ans.charAt(0) == 'N'){
                        l = mid + 1;
                    }
                    else if(ans.charAt(0) == 'P'){
                        r= mid-1;
                    }
                    else if(ans.charAt(0) == 'O'){
                        break;
                    }
                    else if(ans.equals("FAILED")) {
                        break;
                    }
                }
            } else {
                while(true){
                    if(curr == 1){
                        if((rx-2) >= lx && (ry-2) >= ly){
                            long midx = (rx+lx)/2;
                            long midy = (ry+ly)/2;
                            System.out.println(1 + " "+midx+" "+midy);
                            ans = br.readLine();
                            if(ans.equals("O") || ans.equals("FAILED")){
                                break;
                            }
                            if(ans.charAt(0) == 'X'){
                                lx = midx-1;
                                rx = midx+1;
                            }
                            else if(ans.charAt(0) == 'P'){
                                if(d == 0){
                                    rx = midx-1;
                                }
                                else{
                                    rx = midx;
                                    lx--;
                                }
                            }
                            else{
                                if(d == 0){
                                    lx = midx+1;
                                }
                                else{
                                    lx = midx;
                                    rx++;
                                }
                            }
                            if(ans.charAt(1) == 'Y'){
                                ly = midy - 1;
                                ry = midy + 1;
                            }
                            else if(ans.charAt(1) == 'P'){
                                if(d == 0){
                                    ry = midy-1;
                                }
                                else{
                                    ry = midy;
                                    ly--;
                                }
                            }
                            else{
                                if(d == 0){
                                    ly = midy + 1;
                                }
                                else{
                                    ly = midy;
                                    ry++;
                                }
                            }
                            if(d == 0) {
                            }
                            else{
                                if(rx<=(lx+3) && ry<= (ly+3)){
                                    curr=2;
                                }
                            }
                        }
                        else{
                            curr = 2;
                            System.out.println(2 +" "+lx+" "+ly+" "+rx+" "+ry);
                            break;
                        }
                    }
                    else{
                        if((rx == (lx+3)) &&((ry == (ly+3)))){
                            System.out.println(2 +" "+lx+" "+ly+" "+(lx+2)+" "+ry);
                            ans = br.readLine();

                            if(ans.equals("O")){
                                break;
                            }
                            else if(ans.equals("IN")){
                                rx = lx+2;
                            }
                            else {
                                lx = lx + 2;
                                rx++;
                            }

                        }
                        if((rx==(lx+2))&&((ry==(ly+3)))){
                            System.out.println(2 +" "+lx+" "+ly+" "+rx+" "+(ly+2));
                            ans = br.readLine();
                            if(ans.equals("O")){

                            }
                            else if(ans.equals("IN")){
                                System.out.println(2 +" "+lx+" "+ly+" "+rx+" "+(ly+2));
                                ans = br.readLine();
                            }
                            else{
                                System.out.println(2 +" "+lx+" "+(ly+2)+" "+rx+" "+(ly+4));
                                ans = br.readLine();
                            }
                            break;
                        }
                        if((rx==(lx+3))&&((ry==(ly+2)))){
                            System.out.println(2 +" "+lx+" "+ly+" "+(lx+2)+" "+ry);
                            ans = br.readLine();
                            if(ans.equals("O")){
                            }
                            else if(ans.equals("IN")){
                                System.out.println(2 +" "+lx+" "+ly+" "+(lx+2)+" "+ry);
                                ans = br.readLine();
                            }
                            else{
                                System.out.println(2 +" "+(lx+2)+" "+ly+" "+(lx+4)+" "+ry);
                                ans = br.readLine();
                            }
                            break;
                        }
                        else{
                            System.out.println(2 +" "+lx+" "+ly+" "+rx+" "+ry);

                            ans = br.readLine();
                            break;
                        }
                    }
                    System.out.flush();
                }
                System.out.flush();


            }
        }
    }
}
