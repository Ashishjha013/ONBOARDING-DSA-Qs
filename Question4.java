// ------------------------------------------------------------
// 🧮 Question 4: Pascal's Triangle (LeetCode #118)
// ------------------------------------------------------------
// 🧩 Generate first numRows of Pascal's Triangle
// 🔑 Core: Each element = sum of two elements above it
// 💡 Pattern: Dynamic Programming (build row by row)
//
// Level: 🟢 Easy | Tags: #Arrays #DP #Math
// ------------------------------------------------------------

import java.util.*;

public class Question4 {

  // WHAT: Each row starts/ends with 1, middle = sum of two above
  // WHY: Generate Pascal's Triangle with numRows rows
  // HOW: Build each row using previous row
  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();

    // WHAT: Initialize with base case
    // WHY: First row is always [1]
    // HOW: Create list with single element 1
    result.add(new ArrayList<>());
    result.get(0).add(1);

    // WHAT: Each new row depends on previous row
    // WHY: Build remaining rows one by one
    // HOW: Loop from row 1 to numRows-1
    for (int row = 1; row < numRows; row++) {
      List<Integer> newRow = new ArrayList<>();

      // WHAT: First element is always 1
      // WHY: Every row starts with 1
      // HOW: Add 1 at beginning
      newRow.add(1);

      // WHAT: Each element = sum of two elements from previous row
      // WHY: Calculate middle elements
      // HOW: prevRow[i] + prevRow[i-1]
      List<Integer> prevRow = result.get(row - 1);
      for (int i = 1; i < row; i++) {
        newRow.add(prevRow.get(i) + prevRow.get(i - 1));
      }

      // WHAT: Last element is always 1
      // WHY: Every row ends with 1
      // HOW: Add 1 at end
      newRow.add(1);

      result.add(newRow);
    }

    return result;
  }

  public static void main(String[] args) {
    int numRow = 5;
    List<List<Integer>> pascalTriangle = generate(numRow);

    for (List<Integer> row : pascalTriangle) {
      System.out.println(row);
    }
    // Output:
    // [1]
    // [1, 1]
    // [1, 2, 1]
    // [1, 3, 3, 1]
    // [1, 4, 6, 4, 1]
  }
}

// ⚡ Time: O(n²) | Space: O(n²) for output
// 🗣️ "Build row by row. Each element = sum of two above it."

// ------------------------------------------------------------
// 🧠 VISUAL: Pascal's Triangle (5 rows)
// ------------------------------------------------------------
// [1] row 0
// [1,1] row 1
// [1,2,1] row 2
// [1,3,3,1] row 3
// [1,4,6,4,1] row 4
//
// Pattern:
// - Edges always 1
// - Middle: element[i] = prevRow[i] + prevRow[i-1]

// ------------------------------------------------------------
// 🧠 TRACE: Building row 3 from row 2
// ------------------------------------------------------------
// prevRow = [1, 2, 1]
// newRow starts: [1]
//
// i=1: newRow.add(prevRow[1] + prevRow[0])
// newRow.add(2 + 1) = 3
// newRow = [1, 3]
//
// i=2: newRow.add(prevRow[2] + prevRow[1])
// newRow.add(1 + 2) = 3
// newRow = [1, 3, 3]
//
// End with 1: newRow = [1, 3, 3, 1] ✓

// ------------------------------------------------------------
// 🔑 KEY INSIGHT: Building each element
// ------------------------------------------------------------
// [1, 2, 1] ← prevRow (row 2)
// ↓ ↓
// 1+2=3
// [1, 3, ?, 1] ← newRow (row 3)
//
// [1, 2, 1]
// ↓ ↓
// 2+1=3
// [1, 3, 3, 1] ✓
//
// Each middle element = sum of two elements directly above!

// ------------------------------------------------------------
// 🧠 EDGE CASES
// ------------------------------------------------------------
// numRows=1: [[1]]
// numRows=2: [[1], [1,1]]
// numRows=0: [] (empty triangle)
