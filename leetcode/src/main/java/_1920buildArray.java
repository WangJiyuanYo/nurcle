import java.util.Arrays;

public class _1920buildArray {
    public int[] buildArray(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            int index = nums[i];
            ans[i] = nums[index];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5, 0, 1, 2, 3, 4};
        int[] ans = new _1920buildArray().buildArray(nums);
        System.out.println(Arrays.toString(ans));
    }
}
