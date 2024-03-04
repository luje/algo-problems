package org.home.ace.day8;

public class SearchInRotatedArray {

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }

    public int search(int[] nums, int target, int i, int j) {
        if (i >= j)
            return nums[i] == target ? i : -1;

        int mid = (i + j) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (nums[i] < nums[j - 1]) {
            if (nums[i] <= target && target < nums[mid]) {
                return search(nums, target, i, mid);
            } else if(mid + 1 < nums.length) {
                return search(nums, target, mid + 1, j);
            } else {
                return -1;
            }
        } else {
            int li = search(nums, target, i, mid);
            int ri = mid + 1 < nums.length ? search(nums, target, mid + 1, j) : -1;

            return li == -1 ? ri : li;
        }
    }

    public static void main(String[] args) {
        final SearchInRotatedArray solver = new SearchInRotatedArray();

        System.out.println(solver.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
