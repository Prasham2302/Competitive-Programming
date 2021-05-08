package com.company;

import java.util.*;

public class Main {
    static int largestPower(int n, int p) {
        // Initialize result
        int x = 0;

        // Calculate x = n/p + n/(p^2) + n/(p^3) + ....
        while (n > 0) {
            n /= p;
            x += n;
        }
        return x;
    }

    // Utility function to do modular exponentiation.
// It returns (x^y) % p
    static int power(int x, int y, int p) {
        int res = 1; // Initialize result
        x = x % p; // Update x if it is more than or
        // equal to p
        while (y > 0) {
            // If y is odd, multiply x with result
            if (y % 2 == 1) {
                res = (res * x) % p;
            }

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res;
    }

    // Returns n! % p
    static int modFact(int n, int p) {
        if (n >= p) {
            return 0;
        }

        int res = 1;

        // Use Sieve of Eratosthenes to find all primes
        // smaller than n
        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Consider all primes found by Sieve
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                // Find the largest power of prime 'i' that divides n
                int k = largestPower(n, i);

                // Multiply result with (i^k) % p
                res = (res * power(i, k, p)) % p;
            }
        }
        return res;
    }

    public static void main(String[] args) {
	// write your code here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t>0){
            t--;
            int n = scan.nextInt();
            int m = scan.nextInt();
            int[] a = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0;i<n;i++){
                a[i] = scan.nextInt();
                map.putIfAbsent(a[i],0);
                int x = map.get(a[i]);
                map.put(a[i], x + 1);
            }
            int p = 1000000007;

            long denom = 1;
            long num = modFact(n,p);
            System.out.println("num" + num);
            for(Integer i : map.keySet()){
                long curr = map.get(i)%p;
                denom = (curr * denom)%p;
            }
            System.out.println("denom" + denom);
            System.out.println((num / denom) % p);

//            for(int i = 0;i<n;i++){
//                b[i] = scan.nextInt();
//            }
//            if(sum < m){
//                System.out.println(-1);
//                continue;
//            }
//            else{
//                ArrayList<Integer> norm = new ArrayList<>();
//                ArrayList<Integer> imp = new ArrayList<>();
//                for(int i = 0;i<n;i++){
//                    if(b[i] == 2){
//                        imp.add(a[i]);
//                    }
//                    else{
//                        norm.add(a[i]);
//                    }
//                }
//                Collections.sort(norm, Collections.reverseOrder());
//                Collections.sort(imp, Collections.reverseOrder());
////                System.out.println(norm);
//                long ans = Long.MAX_VALUE;
//                long[] sum_norm = new long[norm.size() + 1];
//                long[] sum_imp = new long[imp.size() + 1];
////                Arrays.fill(sum_imp,0);
////                Arrays.fill(sum_norm,0);
////                System.out.println(Arrays.toString(sum_norm));
//                for(int i = 0;i<norm.size();i++){
////                    System.out.println(i);
////                    System.out.println(Arrays.toString(sum_norm));
//                    sum_norm[i + 1] = sum_norm[i] + norm.get(i);
//                }
//                for(int i = 0;i<imp.size();i++){
//                    sum_imp[i + 1] = sum_imp[i] + imp.get(i);
//                }
//                for(int i = 0;i<norm.size()+1;i++){
//                    int l = 0, r = imp.size();
//                    int pts = i;
//                    long rem = (m - sum_norm[i]);
//                    while(l < r){
//                        int mid = (l + r) / 2;
//                        if(sum_imp[mid] < rem){
//                            l = mid+1;
//                        }
//                        else{
//                            r = mid;
//                        }
//                    }
//                    if(sum_imp[l] >= rem ){
//                        ans = Math.min(ans, pts + l*2);
//                    }
//                }
//                System.out.println(ans);
//            }

        }
    }
}
