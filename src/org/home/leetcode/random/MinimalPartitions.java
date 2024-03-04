package org.home.leetcode.random;

//https://leetcode.com/problems/optimal-partition-of-string/?envType=study-plan-v2&envId=amazon-spring-23-high-frequency
public class MinimalPartitions {

    public int partitionString(String s) {

        var p = new int['z' - 'a' + 1];
        var count = 1;

        for (char c : s.toCharArray()) {
            if(p['z' - c] == count) {
                count++;
            }

            p['z' - c] = count;
        }

        return count;
    }

    public static void main(String[] args) {
        var solver = new MinimalPartitions();

        System.out.println("4 = " + solver.partitionString("abacaba"));
        System.out.println("6 = " + solver.partitionString("ssssss"));
    }
}
