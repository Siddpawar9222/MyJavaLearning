import java.sql.Array;
import java.util.*;

public class Believe {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        int i = 0;

        // new interval start and end pointers
        int start = newInterval[0];
        int end = newInterval[1];

        List<int[]> temp = new ArrayList<>();

        while (i < n) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (start > currEnd) {
                temp.add(new int[]{currStart, currEnd});
            } else if (end < currStart) {
                break;
            } else {  // overlapping conditions
                start = Math.min(start, currStart);
                end = Math.max(end, currEnd);
            }

            i++;
        }

        // break conditions remaining non-overlapping intervals
        while (i < n) {
            temp.add(intervals[i]);
            i++;
        }


        int[][] array = temp.toArray(new int[temp.size()][]); // we gave 2D array to add this elements. [] = unknown column size


        return array;
    }
}
/*
https://leetcode.com/problems/grumpy-bookstore-owner/solutions/
https://leetcode.com/problems/sum-of-square-numbers/description/
https://leetcode.com/problems/most-profit-assigning-work/description/
https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/submissions/1293747751/
https://leetcode.com/problems/count-number-of-nice-subarrays/description/?envType=daily-question&envId=2024-06-22
https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/?envType=daily-question&envId=2024-06-23
https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/description/
https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/?envType=daily-question&envId=2024-06-25
https://leetcode.com/problems/balance-a-binary-search-tree/description/?envType=daily-question&envId=2024-06-26
https://leetcode.com/problems/find-center-of-star-graph/description/
https://leetcode.com/problems/maximum-total-importance-of-roads/description/
https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/description/
https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/description/
https://leetcode.com/problems/number-of-atoms/description/
https://leetcode.com/problems/maximum-score-from-removing-substrings/description/
https://leetcode.com/problems/robot-collisions/description/
2096. Step-By-Step Directions From a Binary Tree Node to Another
https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/
 */