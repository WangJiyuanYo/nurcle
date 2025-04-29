/*
滑动窗口的解题思路
 */
public class _2962countSubarrays {
    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        int mx = 0;
        for (int num : nums) {
            mx = Math.max(num,mx);
        }

        int cntMx = 0, left = 0;
        for (int x : nums) {
            if (x == mx) {
                cntMx++;
            }
            while (cntMx == k) {
                if (nums[left] == mx) {
                    cntMx--;
                }
                left++;
            }
            ans += left;
        }

        return ans;
    }
}
