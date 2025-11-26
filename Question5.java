// ------------------------------------------------------------
// 🧮 Question 5: Reverse String (LeetCode #344)
// ------------------------------------------------------------
// 🧩 Reverse character array in-place
// 🔑 Core: Two pointers swapping from ends
// 💡 Pattern: Two Pointers (left and right)
//
// Level: 🟢 Easy | Tags: #TwoPointers #Arrays #String
// ------------------------------------------------------------

public class Question5 {

  public static void reverseString(char[] s) {

    // WHAT: Start from both ends of array
    int left = 0;
    int right = s.length - 1;

    // WHY: Swap characters from ends moving toward center
    // HOW: Continue until pointers meet in middle
    while (left < right) {

      // WHAT: Swap characters at left and right positions
      // WHY: To reverse the array
      // HOW: Use temp variable for swapping
      char temp = s[left]; // Save left character
      s[left] = s[right]; // Put right character at left
      s[right] = temp; // Put saved character at right

      // WHAT: Move pointers closer to center
      // WHY: To process next pair of characters
      // HOW: Increment left, decrement right
      left++;
      right--;
    }
  }

  public static void main(String[] args) {
    char[] str = { 'h', 'e', 'l', 'l', 'o' };

    System.out.print("Original: ");
    System.out.println(str);

    reverseString(str);

    System.out.print("Reversed: ");
    System.out.println(str);
    // Output: olleh
  }
}

// ⚡ Time: O(n) | Space: O(1)
// 🗣️ "Two pointers from ends. Swap and move toward center."

// ------------------------------------------------------------
// 🧠 TRACE: ['h','e','l','l','o']
// ------------------------------------------------------------
//
// Initial: left=0, right=4
// ['h', 'e', 'l', 'l', 'o']
// ↑ ↑
// left right
//
// Step 1: Swap 'h' and 'o'
// ['o', 'e', 'l', 'l', 'h']
// ↑ ↑
// left right
//
// Step 2: Swap 'e' and 'l'
// ['o', 'l', 'l', 'e', 'h']
// ↑ ↑
// left right
//
// Step 3: left=2, right=2 (left >= right, stop)
// Final: ['o', 'l', 'l', 'e', 'h'] ✓

// ------------------------------------------------------------
// 🔑 KEY CONCEPT: Two Pointers Pattern
// ------------------------------------------------------------
//
// Start: [h, e, l, l, o]
// ↑ ↑
// left right
//
// After swaps move inward:
// [o, e, l, l, h]
// ↑ ↑
// meet here
//
// Stop when pointers meet or cross!

// ------------------------------------------------------------
// 🧠 EDGE CASES
// ------------------------------------------------------------
// Single char ['a']: No swap needed (left=0, right=0)
// Two chars ['a','b']: One swap → ['b','a']
// Empty []: No operation (left > right immediately)
