<div align="center">

```
╔══════════════════════════════════════════════════════════╗
║                                                          ║
║        ██████╗  █████╗  █████╗                          ║
║        ██╔══██╗██╔══██╗██╔══██╗                         ║
║        ██║  ██║███████║███████║                         ║
║        ██║  ██║██╔══██║██╔══██║                         ║
║        ██████╔╝██║  ██║██║  ██║                         ║
║        ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝                         ║
║                                                          ║
║     Design and Analysis of Algorithms — Lab File        ║
║                                                          ║
╚══════════════════════════════════════════════════════════╝
```

# 🧠 DAA Lab — Java Practical File

**Parth Arjun Shukla** · `24SCSE1180208`

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Algorithm](https://img.shields.io/badge/Algorithms-14%20Programs-blueviolet?style=for-the-badge)
![Single File](https://img.shields.io/badge/Single%20File-Main.java-success?style=for-the-badge)
![No External Libs](https://img.shields.io/badge/Dependencies-None-informational?style=for-the-badge)

</div>

---

## 📋 Overview

A complete, menu-driven **Design and Analysis of Algorithms** practical file written in a single `Main.java` file. Covers all major algorithmic paradigms — sorting, greedy, dynamic programming, graph algorithms, backtracking, and string matching — with fully interactive user input and clear output.

Every program runs through a numbered menu. After each operation, you're asked whether to continue, keeping the workflow smooth during lab sessions.

---

## 🚀 Quick Start

### Compile
```bash
javac Main.java
```

### Run
```bash
java Main
```

### What you'll see on launch
```
========================================
Parth Arjun Shukla
24SCSE1180208
========================================

================ MENU ================
 1.  Quick Sort + Binary Search
 2.  Merge Sort + Linear Search
...
```

---

## 📚 Programs at a Glance

| # | Program | Technique | Time Complexity |
|---|---------|-----------|-----------------|
| 1 | Quick Sort + Binary Search | Divide & Conquer | O(n log n) avg / O(log n) search |
| 2 | Merge Sort + Linear Search | Divide & Conquer | O(n log n) / O(n) search |
| 3 | Heap Sort | Heap Data Structure | O(n log n) |
| 4 | Knapsack — Greedy | Greedy | O(n log n) |
| 5 | Dijkstra's Algorithm | Greedy + Graph | O(V²) |
| 6 | Prim's Algorithm | Greedy + MST | O(V²) |
| 7 | Kruskal's Algorithm | DSU + MST | O(E log E) |
| 8 | Knapsack — Dynamic Programming | DP | O(n × W) |
| 9 | Travelling Salesman Problem | Bitmask DP | O(2ⁿ × n²) |
| 10 | Longest Common Subsequence | DP | O(m × n) |
| 11 | N-Queens Problem | Backtracking | O(n!) |
| 12 | Sum of Subsets | Backtracking | O(2ⁿ) |
| 13 | String Matching — Naive | Brute Force | O(n × m) |
| 14 | String Matching — KMP | Pattern Matching | O(n + m) |

---

## 🔍 Program Details

### 1️⃣ Quick Sort + Binary Search
- Sorts in **ascending or descending** order using the Lomuto partition scheme
- Performs **binary search** on the sorted array
- Pivot = last element; O(n²) worst case, O(n log n) average

### 2️⃣ Merge Sort + Linear Search
- Stable sort using **divide and conquer** merge
- Both ascending and descending supported
- **Linear search** scans the original (unsorted) array — useful for unsorted data

### 3️⃣ Heap Sort
- Builds a **max-heap**, then extracts elements in order
- Outputs both ascending and descending results
- In-place, O(1) extra space

### 4️⃣ Knapsack — Greedy (Fractional)
- Sorts items by **value-to-weight ratio**
- Allows **fractional** item selection
- Outputs a selection table showing exactly how much of each item was taken

### 5️⃣ Dijkstra's Algorithm
- Finds **shortest paths** from a source vertex to all others
- Uses an adjacency matrix input
- Prints distance + **full path reconstruction** for every vertex

### 6️⃣ Prim's Algorithm
- Builds a **Minimum Spanning Tree** starting from vertex 0
- Uses a key-array greedy approach
- Prints each MST edge and the total MST cost

### 7️⃣ Kruskal's Algorithm
- Sorts all edges by weight, adds them greedily
- Uses **Union-Find (Disjoint Set Union)** with path compression and union by rank
- Prints the MST edges and total cost

### 8️⃣ Knapsack — Dynamic Programming (0/1)
- Classic **0/1 Knapsack** — each item is either included or excluded
- Prints the **complete DP table** so the derivation is visible
- Traces back selected items from the table

### 9️⃣ Travelling Salesman Problem
- Solved using **Bitmask Dynamic Programming**
- Finds the minimum-cost Hamiltonian tour
- Reconstructs and prints the **optimal route**

### 🔟 Longest Common Subsequence
- Classic **2D DP table** approach
- Prints the full DP table for visualization
- Reconstructs and prints the **actual LCS string**

### 1️⃣1️⃣ N-Queens Problem
- Uses **backtracking** to find all valid queen placements
- Prints every solution as a chessboard grid (`Q` = queen, `.` = empty)
- Reports total number of solutions

### 1️⃣2️⃣ Sum of Subsets
- **Backtracking with pruning** on a sorted input set
- Finds all subsets whose elements add up to the target sum
- Sorts the input first for efficient pruning

### 1️⃣3️⃣ String Matching — Naive
- Brute-force **sliding window** approach
- Reports all occurrence indices and total comparisons made
- Useful as a baseline to compare against KMP

### 1️⃣4️⃣ String Matching — KMP
- Computes the **LPS (Failure Function)** array and prints it
- Avoids redundant character comparisons using the LPS table
- Reports all occurrence indices efficiently

---

## 🗂️ File Structure

```
Main.java                  ← entire program (single file, ~720 lines)
README.md                  ← this file
```

### Key design choices inside `Main.java`
```
Main
├── main()                 menu loop, switch-case dispatcher
├── Utility helpers        readArray(), printArray(), askContinue()
├── Sorting programs       quickSort, mergeSort, heapSort variants
├── Greedy algorithms      knapsackGreedy, dijkstra, prims, kruskal
├── DP algorithms          knapsackDP, tsp, lcs
├── Backtracking           nQueens (solveNQ, isSafe), sumOfSubsets
├── String matching        naiveStringMatch, kmpStringMatch, computeLPS
└── Inner class            Edge (for Kruskal's — implements Comparable)
```

---

## 🧩 Algorithmic Paradigms Covered

```
┌─────────────────────────────────────────────────────────┐
│  DIVIDE & CONQUER     Quick Sort · Merge Sort           │
├─────────────────────────────────────────────────────────┤
│  GREEDY               Fractional Knapsack               │
│                       Dijkstra · Prim · Kruskal         │
├─────────────────────────────────────────────────────────┤
│  DYNAMIC PROGRAMMING  0/1 Knapsack · TSP (Bitmask)      │
│                       LCS                               │
├─────────────────────────────────────────────────────────┤
│  BACKTRACKING         N-Queens · Sum of Subsets         │
├─────────────────────────────────────────────────────────┤
│  STRING MATCHING      Naive · KMP                       │
├─────────────────────────────────────────────────────────┤
│  HEAP-BASED SORTING   Heap Sort                         │
└─────────────────────────────────────────────────────────┘
```

---

## 💡 Sample Interaction

```
================ MENU ================
 8.  Knapsack - Dynamic Programming
...
Enter your choice: 8

--- 0/1 Knapsack (Dynamic Programming) ---
Enter number of items: 3
Item 1 - Weight: 2
Item 1 - Value:  6
Item 2 - Weight: 2
Item 2 - Value:  10
Item 3 - Weight: 3
Item 3 - Value:  12
Enter Knapsack Capacity: 5

DP Table (rows = items 0..n, cols = capacity 0..W):
       0   1   2   3   4   5
i=0    0   0   0   0   0   0
i=1    0   0   6   6   6   6
i=2    0   0  10  10  16  16
i=3    0   0  10  12  16  22

Maximum Value: 22
Items selected: Item2(w=2,v=10) Item3(w=3,v=12)

Do you want to continue? (Y/N):
```

---

## ⚙️ Requirements

| Requirement | Detail |
|-------------|--------|
| Java Version | Java 8 or above |
| External Libraries | None |
| IDE Support | Any — IntelliJ, Eclipse, VS Code, BlueJ, NetBeans |
| Compilation | `javac Main.java` |
| Execution | `java Main` |

---

## 📝 Notes

- All programs take **live user input** — no hardcoded test cases
- After each operation, the program asks `Do you want to continue? (Y/N)` before returning to the menu
- Invalid menu choices are handled gracefully with an error message
- The DP table is printed for Knapsack and LCS so the derivation is visible — useful for vivas
- Kruskal's uses **path-compressed Union-Find** (not a naive union), which is the standard expected implementation

---

<div align="center">

---

*Submitted as part of the DAA Lab Practical File*
**Parth Arjun Shukla · 24SCSE1180208**

</div>
