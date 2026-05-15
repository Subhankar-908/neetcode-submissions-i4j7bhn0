// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int n = nums.length;
//         int[] arr = new int[n];

//         // Prefix products
//         arr[0] = 1;
//         for (int i = 1; i < n; i++) {
//             arr[i] = arr[i - 1] * nums[i - 1];
//         }

//         // Suffix products
//         int suffix = 1;
//         for (int i = n - 1; i >= 0; i--) {
//             arr[i] = arr[i] * suffix;
//             suffix *= nums[i];
//         }

//         return arr;
//     }
// }
class Solution {
    public int[] productExceptSelf(int[] nums) {
        return result(nums);
    }

    private int[] result(int[] nums) {
        int[] arr = new int[nums.length];
        int r = 1;
        int i = 0;
        int j = 0;
        int c = 0;

        // Product of non-zero elements
        while (i < nums.length) {
            if (nums[i] == 0) {
                c++;
            } else {
                r *= nums[i];
            }
            i++;
        }

        i = 0;

        while (j < nums.length) {

            if (nums[j] == 0 && c == 1) {
                arr[i++] = r;

            } else if ( c > 1) {
                arr[i++] = 0;

            } else if (nums[j] != 0 && c == 1) {
                arr[i++] = 0;

            } else {
                arr[i++] = (r / nums[j]);
            }

            j++;
        }

        return arr;
    }
}