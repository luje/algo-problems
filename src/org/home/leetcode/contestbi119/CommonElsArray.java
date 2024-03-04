package org.home.leetcode.contestbi119;

//https://leetcode.com/contest/biweekly-contest-119/problems/find-common-elements-between-two-arrays/
public class CommonElsArray {

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        return new int[]{
                count(nums2, nums1),
                count(nums1, nums2)
        };
    }

    public int count(int[] source, int[] target) {
        var result = 0;
        var f = new boolean[100];

        for (int e : source) {
            f[e] = true;
        }

        for (int e : target) {
            if(f[e]) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }

}
