import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        printHeader();
        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Enter your choice: ");
            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            switch (choice) {
                case 1:  quickSortAndBinarySearch(); break;
                case 2:  mergeSortAndLinearSearch(); break;
                case 3:  heapSort(); break;
                case 4:  knapsackGreedy(); break;
                case 5:  dijkstra(); break;
                case 6:  prims(); break;
                case 7:  kruskal(); break;
                case 8:  knapsackDP(); break;
                case 9:  tsp(); break;
                case 10: lcs(); break;
                case 11: nQueens(); break;
                case 12: sumOfSubsets(); break;
                case 13: naiveStringMatch(); break;
                case 14: kmpStringMatch(); break;
                case 15:
                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 15.");
            }
            if (running && choice >= 1 && choice <= 14) {
                if (!askContinue()) running = false;
            }
        }
    }

    static void printHeader() {
        System.out.println("========================================");
        System.out.println("Parth Arjun Shukla");
        System.out.println("24SCSE1180208");
        System.out.println("========================================");
    }

    static void printMenu() {
        System.out.println("\n================ MENU ================");
        System.out.println(" 1.  Quick Sort + Binary Search");
        System.out.println(" 2.  Merge Sort + Linear Search");
        System.out.println(" 3.  Heap Sort");
        System.out.println(" 4.  Knapsack - Greedy Technique");
        System.out.println(" 5.  Dijkstra's Algorithm");
        System.out.println(" 6.  Prim's Algorithm");
        System.out.println(" 7.  Kruskal's Algorithm");
        System.out.println(" 8.  Knapsack - Dynamic Programming");
        System.out.println(" 9.  Travelling Salesman Problem (TSP)");
        System.out.println("10.  Longest Common Subsequence (LCS)");
        System.out.println("11.  N-Queens Problem (Backtracking)");
        System.out.println("12.  Sum of Subsets (Backtracking)");
        System.out.println("13.  String Matching - Naive Algorithm");
        System.out.println("14.  String Matching - KMP Algorithm");
        System.out.println("15.  Exit");
        System.out.println("======================================");
    }

    static boolean askContinue() {
        System.out.print("\nDo you want to continue? (Y/N): ");
        String ans = sc.nextLine().trim().toUpperCase();
        return ans.equals("Y");
    }

    static int[] readArray() {
        System.out.print("Enter number of elements: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("  [" + i + "]: ");
            arr[i] = Integer.parseInt(sc.nextLine().trim());
        }
        return arr;
    }

    static void printArray(int[] arr) {
        System.out.print("[ ");
        for (int x : arr) System.out.print(x + " ");
        System.out.println("]");
    }

    static int partitionAsc(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = tmp;
        return i + 1;
    }

    static int partitionDesc(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] >= pivot) {
                i++;
                int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = tmp;
        return i + 1;
    }

    static void quickSortAsc(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionAsc(arr, low, high);
            quickSortAsc(arr, low, pi - 1);
            quickSortAsc(arr, pi + 1, high);
        }
    }

    static void quickSortDesc(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionDesc(arr, low, high);
            quickSortDesc(arr, low, pi - 1);
            quickSortDesc(arr, pi + 1, high);
        }
    }

    static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    static void quickSortAndBinarySearch() {
        System.out.println("\n--- Quick Sort + Binary Search ---");
        int[] arr = readArray();
        System.out.print("Original:  "); printArray(arr);

        System.out.print("Sort in (1) Ascending or (2) Descending? ");
        int order = Integer.parseInt(sc.nextLine().trim());

        int[] sorted = Arrays.copyOf(arr, arr.length);
        if (order == 1) {
            quickSortAsc(sorted, 0, sorted.length - 1);
            System.out.print("Sorted Ascending:  "); printArray(sorted);
        } else {
            quickSortDesc(sorted, 0, sorted.length - 1);
            System.out.print("Sorted Descending: "); printArray(sorted);
        }

        System.out.print("\nEnter element to search (Binary Search on ascending sorted array): ");
        int key = Integer.parseInt(sc.nextLine().trim());
        int[] ascSorted = Arrays.copyOf(arr, arr.length);
        quickSortAsc(ascSorted, 0, ascSorted.length - 1);
        System.out.print("Sorted array for search: "); printArray(ascSorted);
        int idx = binarySearch(ascSorted, key);
        if (idx == -1) System.out.println("Element " + key + " NOT found.");
        else System.out.println("Element " + key + " found at index " + idx + " in sorted array.");
    }

    static void mergeSortAsc(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortAsc(arr, left, mid);
            mergeSortAsc(arr, mid + 1, right);
            mergeAsc(arr, left, mid, right);
        }
    }

    static void mergeAsc(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] L = new int[n1], R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    static void mergeSortDesc(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortDesc(arr, left, mid);
            mergeSortDesc(arr, mid + 1, right);
            mergeDesc(arr, left, mid, right);
        }
    }

    static void mergeDesc(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] L = new int[n1], R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) arr[k++] = (L[i] >= R[j]) ? L[i++] : R[j++];
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) if (arr[i] == key) return i;
        return -1;
    }

    static void mergeSortAndLinearSearch() {
        System.out.println("\n--- Merge Sort + Linear Search ---");
        int[] arr = readArray();
        System.out.print("Original:  "); printArray(arr);

        System.out.print("Sort in (1) Ascending or (2) Descending? ");
        int order = Integer.parseInt(sc.nextLine().trim());

        int[] sorted = Arrays.copyOf(arr, arr.length);
        if (order == 1) {
            mergeSortAsc(sorted, 0, sorted.length - 1);
            System.out.print("Sorted Ascending:  "); printArray(sorted);
        } else {
            mergeSortDesc(sorted, 0, sorted.length - 1);
            System.out.print("Sorted Descending: "); printArray(sorted);
        }

        System.out.print("\nEnter element to search (Linear Search on original array): ");
        int key = Integer.parseInt(sc.nextLine().trim());
        int idx = linearSearch(arr, key);
        if (idx == -1) System.out.println("Element " + key + " NOT found in original array.");
        else System.out.println("Element " + key + " found at index " + idx + " in original array.");
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i, left = 2 * i + 1, right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;
        if (largest != i) {
            int tmp = arr[i]; arr[i] = arr[largest]; arr[largest] = tmp;
            heapify(arr, n, largest);
        }
    }

    static void heapSort() {
        System.out.println("\n--- Heap Sort ---");
        int[] arr = readArray();
        System.out.print("Original:  "); printArray(arr);

        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int tmp = arr[0]; arr[0] = arr[i]; arr[i] = tmp;
            heapify(arr, i, 0);
        }
        System.out.print("Sorted Ascending:  "); printArray(arr);
        System.out.print("Sorted Descending: [ ");
        for (int i = n - 1; i >= 0; i--) System.out.print(arr[i] + " ");
        System.out.println("]");
    }

    static void knapsackGreedy() {
        System.out.println("\n--- Fractional Knapsack (Greedy) ---");
        System.out.print("Enter number of items: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        double[] weights = new double[n], values = new double[n], ratio = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " - Weight: ");
            weights[i] = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Item " + (i + 1) + " - Value:  ");
            values[i] = Double.parseDouble(sc.nextLine().trim());
            ratio[i] = values[i] / weights[i];
        }
        System.out.print("Enter Knapsack Capacity: ");
        double capacity = Double.parseDouble(sc.nextLine().trim());

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> Double.compare(ratio[b], ratio[a]));

        double totalValue = 0, remaining = capacity;
        System.out.println("\nSelection Process:");
        System.out.printf("%-8s %-10s %-10s %-12s %-12s%n", "Item", "Weight", "Value", "Ratio", "Taken");
        for (int i = 0; i < n && remaining > 0; i++) {
            int item = idx[i];
            double taken = Math.min(weights[item], remaining);
            totalValue += taken * ratio[item];
            remaining -= taken;
            System.out.printf("%-8d %-10.2f %-10.2f %-12.4f %-12.2f%n",
                    item + 1, weights[item], values[item], ratio[item], taken);
        }
        System.out.printf("Total Value in Knapsack: %.4f%n", totalValue);
    }

    static final int INF = Integer.MAX_VALUE / 2;

    static void dijkstra() {
        System.out.println("\n--- Dijkstra's Shortest Path Algorithm ---");
        System.out.print("Enter number of vertices: ");
        int v = Integer.parseInt(sc.nextLine().trim());
        int[][] graph = new int[v][v];
        System.out.println("Enter adjacency matrix (0 = no edge between different vertices):");
        for (int i = 0; i < v; i++)
            for (int j = 0; j < v; j++) {
                System.out.print("  graph[" + i + "][" + j + "]: ");
                graph[i][j] = Integer.parseInt(sc.nextLine().trim());
            }
        System.out.print("Enter source vertex (0-based): ");
        int src = Integer.parseInt(sc.nextLine().trim());

        int[] dist = new int[v], parent = new int[v];
        boolean[] visited = new boolean[v];
        Arrays.fill(dist, INF); Arrays.fill(parent, -1);
        dist[src] = 0;

        for (int count = 0; count < v - 1; count++) {
            int u = -1, minD = INF;
            for (int i = 0; i < v; i++) if (!visited[i] && dist[i] < minD) { minD = dist[i]; u = i; }
            if (u == -1) break;
            visited[u] = true;
            for (int w = 0; w < v; w++) {
                if (!visited[w] && graph[u][w] != 0 && dist[u] + graph[u][w] < dist[w]) {
                    dist[w] = dist[u] + graph[u][w];
                    parent[w] = u;
                }
            }
        }

        System.out.println("\nShortest distances from vertex " + src + ":");
        System.out.printf("%-10s %-12s %-25s%n", "Vertex", "Distance", "Path");
        for (int i = 0; i < v; i++) {
            System.out.printf("%-10d %-12s %-25s%n", i,
                    dist[i] == INF ? "Unreachable" : String.valueOf(dist[i]),
                    buildPath(parent, src, i));
        }
    }

    static String buildPath(int[] parent, int src, int dest) {
        if (dest == src) return String.valueOf(src);
        if (parent[dest] == -1) return "No path";
        return buildPath(parent, src, parent[dest]) + " -> " + dest;
    }

    static void prims() {
        System.out.println("\n--- Prim's Minimum Spanning Tree ---");
        System.out.print("Enter number of vertices: ");
        int v = Integer.parseInt(sc.nextLine().trim());
        int[][] graph = new int[v][v];
        System.out.println("Enter adjacency matrix (0 = no edge):");
        for (int i = 0; i < v; i++)
            for (int j = 0; j < v; j++) {
                System.out.print("  graph[" + i + "][" + j + "]: ");
                graph[i][j] = Integer.parseInt(sc.nextLine().trim());
            }

        int[] key = new int[v], par = new int[v];
        boolean[] inMST = new boolean[v];
        Arrays.fill(key, INF); key[0] = 0; par[0] = -1;

        for (int count = 0; count < v - 1; count++) {
            int u = -1, minKey = INF;
            for (int i = 0; i < v; i++) if (!inMST[i] && key[i] < minKey) { minKey = key[i]; u = i; }
            if (u == -1) break;
            inMST[u] = true;
            for (int w = 0; w < v; w++) {
                if (graph[u][w] != 0 && !inMST[w] && graph[u][w] < key[w]) {
                    key[w] = graph[u][w]; par[w] = u;
                }
            }
        }

        System.out.println("\nMinimum Spanning Tree (Prim's):");
        System.out.printf("%-15s %-10s%n", "Edge", "Weight");
        int total = 0;
        for (int i = 1; i < v; i++) {
            System.out.printf("%-15s %-10d%n", par[i] + " - " + i, graph[par[i]][i]);
            total += graph[par[i]][i];
        }
        System.out.println("Total MST Cost: " + total);
    }

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;
        Edge(int s, int d, int w) { src = s; dest = d; weight = w; }
        public int compareTo(Edge o) { return this.weight - o.weight; }
    }

    static int[] dsuParent, dsuRank;

    static int find(int x) {
        if (dsuParent[x] != x) dsuParent[x] = find(dsuParent[x]);
        return dsuParent[x];
    }

    static void union(int x, int y) {
        int px = find(x), py = find(y);
        if (dsuRank[px] < dsuRank[py]) dsuParent[px] = py;
        else if (dsuRank[px] > dsuRank[py]) dsuParent[py] = px;
        else { dsuParent[py] = px; dsuRank[px]++; }
    }

    static void kruskal() {
        System.out.println("\n--- Kruskal's Minimum Spanning Tree ---");
        System.out.print("Enter number of vertices: ");
        int v = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter number of edges: ");
        int e = Integer.parseInt(sc.nextLine().trim());

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            System.out.print("  Edge " + (i + 1) + " - Source: ");
            int s = Integer.parseInt(sc.nextLine().trim());
            System.out.print("  Edge " + (i + 1) + " - Dest:   ");
            int d = Integer.parseInt(sc.nextLine().trim());
            System.out.print("  Edge " + (i + 1) + " - Weight: ");
            int w = Integer.parseInt(sc.nextLine().trim());
            edges.add(new Edge(s, d, w));
        }
        Collections.sort(edges);

        dsuParent = new int[v]; dsuRank = new int[v];
        for (int i = 0; i < v; i++) dsuParent[i] = i;

        List<Edge> mst = new ArrayList<>();
        int total = 0;
        for (Edge edge : edges) {
            if (find(edge.src) != find(edge.dest)) {
                mst.add(edge); total += edge.weight;
                union(edge.src, edge.dest);
                if (mst.size() == v - 1) break;
            }
        }

        System.out.println("\nMinimum Spanning Tree (Kruskal's):");
        System.out.printf("%-15s %-10s%n", "Edge", "Weight");
        for (Edge edge : mst)
            System.out.printf("%-15s %-10d%n", edge.src + " - " + edge.dest, edge.weight);
        System.out.println("Total MST Cost: " + total);
    }

    static void knapsackDP() {
        System.out.println("\n--- 0/1 Knapsack (Dynamic Programming) ---");
        System.out.print("Enter number of items: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        int[] weights = new int[n], values = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " - Weight: ");
            weights[i] = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Item " + (i + 1) + " - Value:  ");
            values[i] = Integer.parseInt(sc.nextLine().trim());
        }
        System.out.print("Enter Knapsack Capacity: ");
        int W = Integer.parseInt(sc.nextLine().trim());

        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++)
            for (int w = 0; w <= W; w++) {
                dp[i][w] = dp[i - 1][w];
                if (weights[i - 1] <= w)
                    dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
            }

        System.out.println("\nDP Table (rows = items 0..n, cols = capacity 0..W):");
        System.out.print("     ");
        for (int w = 0; w <= W; w++) System.out.printf("%4d", w);
        System.out.println();
        for (int i = 0; i <= n; i++) {
            System.out.printf("i=%-3d", i);
            for (int w = 0; w <= W; w++) System.out.printf("%4d", dp[i][w]);
            System.out.println();
        }

        System.out.println("\nMaximum Value: " + dp[n][W]);
        System.out.print("Items selected: ");
        int w = W;
        List<Integer> selected = new ArrayList<>();
        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) { selected.add(i); w -= weights[i - 1]; }
        }
        Collections.reverse(selected);
        for (int item : selected)
            System.out.print("Item" + item + "(w=" + weights[item-1] + ",v=" + values[item-1] + ") ");
        System.out.println();
    }

    static void tsp() {
        System.out.println("\n--- Travelling Salesman Problem (DP with Bitmask) ---");
        System.out.print("Enter number of cities: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        int[][] dist = new int[n][n];
        System.out.println("Enter cost/distance matrix (0 = same city):");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                System.out.print("  dist[" + i + "][" + j + "]: ");
                dist[i][j] = Integer.parseInt(sc.nextLine().trim());
            }

        int FULL = (1 << n) - 1;
        int[][] dp = new int[n][1 << n];
        int[][] next = new int[n][1 << n];
        for (int[] row : dp) Arrays.fill(row, INF);
        for (int[] row : next) Arrays.fill(row, -1);
        dp[0][1] = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) == 0 || dp[u][mask] == INF) continue;
                for (int v = 0; v < n; v++) {
                    if ((mask & (1 << v)) != 0 || dist[u][v] == 0) continue;
                    int newMask = mask | (1 << v);
                    int newCost = dp[u][mask] + dist[u][v];
                    if (newCost < dp[v][newMask]) {
                        dp[v][newMask] = newCost;
                        next[u][mask] = v;
                    }
                }
            }
        }

        int minCost = INF, lastCity = -1;
        for (int u = 1; u < n; u++) {
            if (dist[u][0] != 0 && dp[u][FULL] != INF) {
                int cost = dp[u][FULL] + dist[u][0];
                if (cost < minCost) { minCost = cost; lastCity = u; }
            }
        }

        if (minCost == INF) {
            System.out.println("No valid Hamiltonian tour found.");
        } else {
            System.out.println("Minimum TSP Tour Cost: " + minCost);
            System.out.print("Tour: 0");
            int mask = FULL, cur = 0;
            while (next[cur][mask] != -1) {
                int nxt = next[cur][mask];
                System.out.print(" -> " + nxt);
                mask ^= (1 << cur);
                cur = nxt;
            }
            System.out.println(" -> 0");
        }
    }

    static void lcs() {
        System.out.println("\n--- Longest Common Subsequence (LCS) ---");
        System.out.print("Enter first string:  ");
        String s1 = sc.nextLine().trim();
        System.out.print("Enter second string: ");
        String s2 = sc.nextLine().trim();

        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }

        System.out.println("\nLCS DP Table:");
        System.out.print("      ");
        for (char c : s2.toCharArray()) System.out.printf("%3c", c);
        System.out.println();
        for (int i = 0; i <= m; i++) {
            System.out.printf("%3s: ", i == 0 ? " " : String.valueOf(s1.charAt(i-1)));
            for (int j = 0; j <= n; j++) System.out.printf("%3d", dp[i][j]);
            System.out.println();
        }

        StringBuilder lcsStr = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) { lcsStr.insert(0, s1.charAt(i-1)); i--; j--; }
            else if (dp[i-1][j] > dp[i][j-1]) i--;
            else j--;
        }

        System.out.println("\nLCS Length: " + dp[m][n]);
        System.out.println("LCS String: " + lcsStr);
    }

    static int nqN;
    static int[] nqBoard;
    static int nqCount;

    static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++)
            if (nqBoard[i] == col || Math.abs(nqBoard[i] - col) == Math.abs(i - row)) return false;
        return true;
    }

    static void solveNQ(int row) {
        if (row == nqN) {
            nqCount++;
            System.out.println("Solution " + nqCount + ":");
            for (int i = 0; i < nqN; i++) {
                System.out.print("  ");
                for (int j = 0; j < nqN; j++) System.out.print(nqBoard[i] == j ? "Q " : ". ");
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int col = 0; col < nqN; col++) {
            if (isSafe(row, col)) { nqBoard[row] = col; solveNQ(row + 1); }
        }
    }

    static void nQueens() {
        System.out.println("\n--- N-Queens Problem (Backtracking) ---");
        System.out.print("Enter value of N: ");
        nqN = Integer.parseInt(sc.nextLine().trim());
        nqBoard = new int[nqN];
        nqCount = 0;
        System.out.println("\nAll solutions for " + nqN + "-Queens problem:");
        solveNQ(0);
        if (nqCount == 0) System.out.println("No solution exists for N = " + nqN + ".");
        else System.out.println("Total solutions: " + nqCount);
    }

    static int[] ssSet;
    static int ssTarget, ssN;

    static void findSubsets(int idx, int curSum, List<Integer> current) {
        if (curSum == ssTarget) {
            System.out.println("  Subset: " + current);
            return;
        }
        for (int i = idx; i < ssN; i++) {
            if (curSum + ssSet[i] <= ssTarget) {
                current.add(ssSet[i]);
                findSubsets(i + 1, curSum + ssSet[i], current);
                current.remove(current.size() - 1);
            }
        }
    }

    static void sumOfSubsets() {
        System.out.println("\n--- Sum of Subsets (Backtracking) ---");
        ssSet = readArray();
        System.out.print("Enter target sum: ");
        ssTarget = Integer.parseInt(sc.nextLine().trim());
        ssN = ssSet.length;
        Arrays.sort(ssSet);
        System.out.println("Sorted Set: "); printArray(ssSet);
        System.out.println("\nSubsets that sum to " + ssTarget + ":");
        boolean[] found = {false};
        findSubsets(0, 0, new ArrayList<>());
    }

    static void naiveStringMatch() {
        System.out.println("\n--- Naive String Matching Algorithm ---");
        System.out.print("Enter text:    ");
        String text = sc.nextLine().trim();
        System.out.print("Enter pattern: ");
        String pattern = sc.nextLine().trim();

        int n = text.length(), m = pattern.length();
        boolean found = false;
        int comparisons = 0;
        System.out.println("\nMatching pattern \"" + pattern + "\" in \"" + text + "\":");
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) { comparisons++; if (text.charAt(i+j) != pattern.charAt(j)) break; }
            if (j == m) { System.out.println("  Pattern found at index: " + i); found = true; }
        }
        if (!found) System.out.println("  Pattern NOT found in text.");
        System.out.println("Total comparisons made: " + comparisons);
    }

    static int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0, i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) lps[i++] = ++len;
            else { if (len != 0) len = lps[len-1]; else lps[i++] = 0; }
        }
        return lps;
    }

    static void kmpStringMatch() {
        System.out.println("\n--- KMP String Matching Algorithm ---");
        System.out.print("Enter text:    ");
        String text = sc.nextLine().trim();
        System.out.print("Enter pattern: ");
        String pattern = sc.nextLine().trim();

        int n = text.length(), m = pattern.length();
        int[] lps = computeLPS(pattern);

        System.out.print("LPS (Failure Function) Array: [ ");
        for (int x : lps) System.out.print(x + " ");
        System.out.println("]");

        boolean found = false;
        int i = 0, j = 0;
        System.out.println("\nMatching pattern \"" + pattern + "\" in \"" + text + "\":");
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) { i++; j++; }
            if (j == m) {
                System.out.println("  Pattern found at index: " + (i - j));
                j = lps[j-1]; found = true;
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) j = lps[j-1]; else i++;
            }
        }
        if (!found) System.out.println("  Pattern NOT found in text.");
        System.out.println("KMP avoids redundant comparisons using the LPS table.");
    }
}