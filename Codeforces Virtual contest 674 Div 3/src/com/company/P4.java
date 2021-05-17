package com.company;

import java.util.Arrays;
import java.util.Scanner;

class NumArray {
    int[] tree;
    int n;
    public NumArray(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }
    private void buildTree(int[] nums) {
        for (int i = n, j = 0;  i < 2 * n; i++,  j++)
            tree[i] = nums[j];
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }
    public int sumRange(int l, int r) {
        // get leaf with value 'l'
        l += n;
        // get leaf with value 'r'
        r += n;
        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) {
                sum += tree[l];
                l++;
            }
            if ((r % 2) == 0) {
                sum += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }

}

public class P4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int[] arr = new int[t];
        for(int i = 0;i<t;i++){
            arr[i] = scan.nextInt();
        }
        NumArray tree = new NumArray(arr);
        int count = 0;
//        System.out.println(Arrays.toString(tree.tree));
        for(int i = 0;i<t-1;i++){
            for(int j = i+1;j<t;j++){
                int temp = tree.sumRange(i,j);
                if(temp == 0){
                    System.out.println(i +" "+j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
