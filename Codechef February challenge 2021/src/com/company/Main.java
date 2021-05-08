package com.company;

import java.io.*;

public class Main {
    static int[] SieveOfAtkin(int limit)
    {
        int count = 0;
        if (limit > 2)
            count++;
        if (limit > 3)
            count++;
        boolean sieve[] = new boolean[limit+1];
        int[] prime_count = new int[limit+1];
        for (int i = 0; i < limit; i++)
            sieve[i] = false;
        for (int x = 1; x * x < limit; x++) {
            for (int y = 1; y * y < limit; y++) {
                int n = (4 * x * x) + (y * y);
                if (n <= limit && (n % 12 == 1 || n % 12 == 5))
                    sieve[n] ^= true;
                n = (3 * x * x) + (y * y);
                if (n <= limit && n % 12 == 7)
                    sieve[n] ^= true;

                n = (3 * x * x) - (y * y);
                if (x > y && n <= limit && n % 12 == 11)
                    sieve[n] ^= true;
            }
        }
        for (int r = 5; r * r < limit; r++) {
            if (sieve[r]) {
                for (int i = r * r; i < limit;
                     i += r * r)
                    sieve[i] = false;
            }
        }
        prime_count[0] = 0;
        prime_count[1] = 0;
        prime_count[2] = 1;
        prime_count[3] = 2;
        prime_count[4] = 2;
        for (int a = 5; a < limit; a++) {
            if (sieve[a])
                count++;
            prime_count[a] = count;
        }
        return prime_count;
    }
    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[] count = SieveOfAtkin(1000001);
        while(t>0){
            t--;
            String[] st = br.readLine().split(" ");
            int x = Integer.parseInt(st[0]);
            int y = Integer.parseInt(st[1]);

//            System.out.println(primes);
            if(count[x]>y){
                log.write("Divyam \n");
                log.flush();
            }
            else{
                log.write("Chef \n");
                log.flush();
            }
        }
    }
}
