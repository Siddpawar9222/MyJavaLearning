import java.util.*;

public class Believe {
    int a;

    public static void main(String[] args) {
//        int x = 1_10_152;  // provides readability
//        double y = 1e8;      // Scientific notation →  1e = 10
//        double z = Math.pow(10, 8);  // Math function


        Believe b = new Believe();

        final int a = 10;
        //a = 10 ;
        //System.out.println(a);
        List<Integer> list = new ArrayList<>(
                List.of(100, 463, 50, 975, 63, 78)
        );

        List<String> strList = new ArrayList<>(
                List.of("Name", "Siddhesh", "Pawar", "Java")
        );

        strList.stream()
                .sorted((s1, s2) -> s1.charAt(1) - s2.charAt(1)).forEach(System.out::println);

//        Collections.sort(list);
//        System.out.println(list);
//
//        Integer result = list.stream()
//                .sorted(Comparator.reverseOrder())
//                .skip(1)
//                .findFirst()
//                .orElse(null);
//
//        System.out.println(result);
        int[] nums = {2, -3};
        System.out.println(b.vowelConsonantScore("axeyizou"));
    }


    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int vowelConsonantScore(String s) {
        int v = 0;
        int c = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                if (isVowel(ch)) {
                    v++;
                } else {
                    c++;
                }
            }
        }
        return c > 0 ? Math.floorDiv(v, c) : 0;
    }


    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        for (int i = 1; i < arr.length; i++) {
            int a = arr[i - 1];
            int b = arr[i];

            int diff = Math.abs(b - a);
            List<List<Integer>> pairs;
            if (!map.containsKey(diff)) {
                pairs = new ArrayList<>();
            } else {
                pairs = map.get(diff);
            }
            pairs.add(List.of(a, b));
            map.put(diff, pairs);
        }

        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {

            int a = arr[i - 1];
            int b = arr[i];

            int currDiff = Math.abs(b - a);

            if(currDiff<minDiff){
                  minDiff = currDiff;
                  ans.clear();
            }
            ans.add(List.of(a,b));
        }

        return ans;
    }


    /*
     Brute force : Use two loops and  define s and t , check for every character s.charAt(i) - t.charAt(i) is same
     Optimal :
     Normalize every string w.r.t char 'a'
    *  */

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