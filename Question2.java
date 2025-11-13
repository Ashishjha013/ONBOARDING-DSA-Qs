// ------------------------------------------------------------
// 🧮 Question 2: Find Numbers with Even Number of Digits (LeetCode #1295)
// ------------------------------------------------------------
// 🧩 Count how many numbers have even number of digits
// 🔑 Core Concept: Count digits, check if count is even
// 💡 Pattern: Digit Counting using Division
//
// Level: 🟢 Easy
// Tags: #Arrays #Math #DigitCounting
// ------------------------------------------------------------

public class Question2 {

  // WHY: Count numbers that have even number of digits
  // WHAT: nums = array of integers
  // HOW: For each number, count digits, check if even
  public static int findNumbers(int[] nums) {

    // WHY: Track how many numbers have even digit count
    // WHAT: count = result counter
    // HOW: Increment when find number with even digits
    int count = 0;

    // WHY: Check every number in array
    // WHAT: Loop through all numbers
    // HOW: Enhanced for-loop
    for (int num : nums) {

      // WHY: Count digits in current number
      // WHAT: digits = number of digits in num
      // HOW: Divide by 10 repeatedly until 0
      int digits = 0;
      int n = num; // Copy to avoid modifying original

      // WHY: Extract digits one by one
      // WHAT: Keep dividing by 10 until number becomes 0
      // HOW: Each division removes rightmost digit
      while (n > 0) {
        digits++; // Count this digit
        n /= 10; // Remove rightmost digit
      }

      // WHY: Check if digit count is even
      // WHAT: If digits divisible by 2, increment count
      // HOW: Use modulo operator (% 2 == 0)
      if (digits % 2 == 0) {
        count++;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    int[] arr = { 12, 345, 2, 6, 7896 };
    int result = findNumbers(arr);
    System.out.println("Count: " + result);
    // Output: 2 (12 has 2 digits, 7896 has 4 digits)
  }
}

// ⚡ Time: O(n * d) where d=avg digits | Space: O(1)
// 🗣️ Interview: "For each number, count digits by dividing by 10 repeatedly.
// Increment result if digit count is even."

// ------------------------------------------------------------
// 🧠 TRACE: arr = [12, 345, 2, 6, 7896]
// ------------------------------------------------------------
// num=12: n=12 → 1 → 0, digits=2 → 2%2==0 ✓ → count=1
// num=345: n=345 → 34 → 3 → 0, digits=3 → 3%2==0 ✗
// num=2: n=2 → 0, digits=1 → 1%2==0 ✗
// num=6: n=6 → 0, digits=1 → 1%2==0 ✗
// num=7896: n=7896 → 789 → 78 → 7 → 0, digits=4 → 4%2==0 ✓ → count=2
//
// Result: 2 ✓

// ------------------------------------------------------------
// 🔑 KEY INSIGHT: How digit counting works
// ------------------------------------------------------------
// Example: num = 345
//
// n=345, digits=0
// Loop 1: digits=1, n=345/10=34
// Loop 2: digits=2, n=34/10=3
// Loop 3: digits=3, n=3/10=0
// Exit loop (n==0)
//
// Division by 10 removes rightmost digit each time!

// ------------------------------------------------------------
// 🧠 EDGE CASES
// ------------------------------------------------------------
// Single digit [5,7,9]: returns 0 (all have 1 digit, odd)
// All even digits [10,20,30]: returns 3 (all have 2 digits)
// Mixed [1,22,333,4444]: returns 2 (22 and 4444)