// ------------------------------------------------------------
// 🧮 Question: 1
// Leetcode: 485 Max Consecutive Ones (LeetCode #485)
// ------------------------------------------------------------
// 🧩 Find maximum number of consecutive 1's in binary array
// 🔑 Core Concept: Track current streak and update max
// 💡 Pattern: Single Pass with Reset
//
// Level: 🟢 Easy
// Tags: #Arrays #Counting
// ------------------------------------------------------------

public class MaxConsecutiveOnes {

  // WHY: Find longest sequence of 1's
  // WHAT: nums = binary array (contains only 0 and 1)
  // HOW: Track current count, update max when streak breaks
  public int findMaxConsecutiveOnes(int[] nums) {

    // WHY: Track the maximum streak found so far
    // WHAT: maxCount stores best result
    // HOW: Update whenever current streak ends
    int maxCount = 0;

    // WHY: Track current ongoing streak of 1's
    // WHAT: Count stores length of current consecutive 1's
    // HOW: Increment on 1, reset to 0 on encountering 0
    int Count = 0;

    // WHY: Check every element to find streaks
    // WHAT: Loop through entire array
    // HOW: Enhanced for-loop
    for (int num : nums) {

      // WHY: Found a 1 - continue/start streak
      // WHAT: If current element is 1
      // HOW: Increment Count (extend current streak)
      if (num == 1) {
        Count++;
      }

      // WHY: Found a 0 - streak broken
      // WHAT: If current element is 0
      // HOW: Update maxCount, reset Count to 0
      else {
        maxCount = Math.max(maxCount, Count); // Save streak if it's best
        Count = 0; // Reset for next streak
      }
    }

    // WHY: Handle case where array ends with 1's
    // WHAT: Final comparison between maxCount and Count
    // HOW: Return max of both (Count might be largest streak)
    return Math.max(maxCount, Count);
  }
}

// ⚡ Time: O(n) | Space: O(1)
// 🗣️ Interview: "Track current streak of 1's. When hit 0, update max and
// reset count. Final check handles array ending with 1's."

// ------------------------------------------------------------
// 🧠 TRACE: nums = [1,1,0,1,1,1,0,1]
// ------------------------------------------------------------
// Start: maxCount=0, Count=0
//
// num=1: Count=1
// num=1: Count=2
// num=0: maxCount=max(0,2)=2, Count=0
// num=1: Count=1
// num=1: Count=2
// num=1: Count=3
// num=0: maxCount=max(2,3)=3, Count=0
// num=1: Count=1
//
// Final: max(3,1) = 3 ✓

// ------------------------------------------------------------
// 🔑 KEY INSIGHT: Why final Math.max()?
// ------------------------------------------------------------
// Array ending with 1's: [1,1,1,0,1,1,1]
//
// After loop: maxCount=3, Count=3
// Without final check: returns maxCount=3 ✓
//
// But: [1,1,1,1,1]
// After loop: maxCount=0, Count=5
// Without final check: returns maxCount=0 ✗
// With final check: returns max(0,5)=5 ✓
//
// Final check ensures we don't miss last streak!

// ------------------------------------------------------------
// 🧠 EDGE CASES
// ------------------------------------------------------------
// All 1's [1,1,1]: returns 3 (Count never reset, final check catches it)
// All 0's [0,0,0]: returns 0 (Count stays 0)
// Single 1 [1]: returns 1 (final check catches it)
// Alternating [1,0,1,0]: returns 1