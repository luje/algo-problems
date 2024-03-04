package neetcode150;

public class BinarySearch {

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }

    public int search(int[] nums, int target, int i, int j) {
        int low = i;
        int high = j - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = nums[mid];

            if (target < val) {
                high = mid - 1;
            } else if (target > val) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public int search2(int[] nums, int target, int i, int j) {
        if (i >= j) {
            return i < nums.length && nums[i] == target ? i : -1;
        }

        int mid = (i + j) / 2;

        return target == nums[mid] ? mid :
                target < nums[mid] ?
                        search(nums, target, i, mid) :
                        search(nums, target, mid + 1, j);
    }

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();

        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 13));
        System.out.println(solution.search(new int[]{5}, -5));
    }
}
