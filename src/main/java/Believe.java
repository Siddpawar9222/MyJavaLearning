import java.util.*;

public class Believe {


    Set<String> uniqueValidateStrings = new HashSet<>();


    private void solve(int idx, int n, int k, StringBuilder sb, int sum, List<String> ans) {
        // if sum greater than k or udx greater than k
        if (sum > k || idx > k) {
            return;
        }

        // add  valid string in ans
        ans.add(sb.toString());

        for (int i = idx; i < n; i++) {
            sb.setCharAt(i, '1');
            solve(idx + 2, n, k, sb, sum + i, ans);
            sb.setCharAt(i, '0'); // backtracking
        }
    }

    public List<String> generateValidStrings(int n, int k) {
        List<String> ans = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append('0');
        }

        solve(0, n, k, sb, 0, ans);

        return ans;
    }

    public static void main(String[] args) {
//        int x = 1_10_152;  // provides readability
//        double y = 1e8;      // Scientific notation →  1e = 10
//        double z = Math.pow(10, 8);  // Math function


        Believe b = new Believe();

        int n = 3;
        int k = 1;

        System.out.println(b.generateValidStrings(n, k));


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