import java.util.Arrays;
import java.util.Stack;

public class Believe {
    int maxWater(int arr[]){
       int n = arr.length;
       int waterTrapped = 0 ;
        Stack<Integer> stack = new Stack<>(); // Element will store in increasing order
        for (int i = 0; i < n; i++) {
             // i = right
             while (!stack.isEmpty() && stack.peek()<arr[i]){
                  int middle = stack.pop();
                  if(stack.isEmpty()){
                       break;
                  }
                  int left = stack.peek();
                  int distance = i - left -1 ;
                  int minHeight = Math.min(arr[left],arr[i])-arr[middle];
                  if(distance>0 && minHeight>0){
                      waterTrapped += distance * minHeight;
                  }
             }
             stack.push(i);
        }

        return waterTrapped;
    }
    public static void main(String[] args) {

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