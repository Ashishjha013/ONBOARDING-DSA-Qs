// ------------------------------------------------------------
// 🧮 Question 3: Find Pivot Index (LeetCode #724)
// ------------------------------------------------------------
// 🧩 Find index where left sum equals right sum
// 🔑 Core Concept: Two-pass - calculate total, then balance check
// 💡 Pattern: Prefix Sum
//
// Level: 🟢 Easy
// Tags: #Arrays #PrefixSum #Math
// ------------------------------------------------------------

public class Question3 {

  // WHY: Find pivot where sum of left elements = sum of right elements
  // WHAT: nums = input array
  // HOW: Calculate total sum, then check balance at each index
  public static int pivotIndex(int[] nums) {

    // STEP 1: Calculate total sum (initially treated as right sum)

    // WHY: Need total sum to calculate right side sums
    // WHAT: rightSum = sum of all elements
    // HOW: Loop through array and add all elements
    int rightSum = 0;
    for (int num : nums) {
      rightSum += num;
    }

    // STEP 2: Check each index for balance

    // WHY: Track sum of elements to the left
    // WHAT: leftSum starts at 0 (no elements to left of index 0)
    // HOW: Will accumulate as we move right
    int leftSum = 0;

    // WHY: Check every index as potential pivot
    // WHAT: Loop through array with index
    // HOW: Compare leftSum with rightSum (excluding current element)
    for (int i = 0; i < nums.length; i++) {

      // WHY: Check if current index is pivot
      // WHAT: leftSum should equal rightSum excluding nums[i]
      // HOW: rightSum - nums[i] gives sum of elements to the right
      if (leftSum == rightSum - nums[i]) {
        return i; // Found pivot!
      }

      // WHY: Update sums for next iteration
      // WHAT: Add current element to left, remove from right
      // HOW: Move boundary - current element now part of left side
      leftSum += nums[i]; // Current moves to left side
      rightSum -= nums[i]; // Current removed from right side
    }

    // WHY: No pivot found
    // WHAT: Return -1 to indicate failure
    // HOW: If loop completes without return, no valid pivot exists
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 7, 3, 6, 5, 6 };
    System.out.println(pivotIndex(nums)); // Output: 3
  }
}

// ⚡ Time: O(n) | Space: O(1)
// 🗣️ Interview: "Calculate total sum first. Then iterate, maintaining leftSum
// and rightSum. At each index, check if leftSum == rightSum-current."

// ------------------------------------------------------------
// 🧠 TRACE: nums = [1, 7, 3, 6, 5, 6]
// ------------------------------------------------------------
// Initial: rightSum = 1+7+3+6+5+6 = 28, leftSum = 0
//
// i=0: leftSum(0) == rightSum-nums[0](28-1=27)? No
// leftSum=1, rightSum=27
//
// i=1: leftSum(1) == rightSum-nums[1](27-7=20)? No
// leftSum=8, rightSum=20
//
// i=2: leftSum(8) == rightSum-nums[2](20-3=17)? No
// leftSum=11, rightSum=17
//
// i=3: leftSum(11) == rightSum-nums[3](17-6=11)? Yes! ✓
// Return 3
//
// Verification: Left=[1,7,3]=11, Right=[5,6]=11 ✓

// ------------------------------------------------------------
// 🔑 KEY INSIGHT: Why rightSum - nums[i]?
// ------------------------------------------------------------
// At index i:
// - leftSum = sum of elements before i
// - rightSum = total sum (includes all elements)
// - rightSum - nums[i] = sum after i (excludes current)
//
// Example at i=3: [1,7,3, |6| ,5,6]
// leftSum = 1+7+3 = 11
// rightSum - nums[3] = 28 - 6 = 22 - 11 = 11 ✓
// (rightSum still includes 6, so subtract it!)

// ------------------------------------------------------------
// 🧠 EDGE CASES
// ------------------------------------------------------------
// Single element [5]: returns 0 (left=0, right=0)
// No pivot [1,2,3]: returns -1
// Pivot at start [0,1,1]: returns 0 (left=0, right=2)
// Multiple pivots [1,0,0]: returns 0 (leftmost)