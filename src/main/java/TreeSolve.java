import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class TreeSolve {
    /*
      optimal way :

      len = 2 * n
      n = len/2 ;

      distant element = n + 1 ;

      Example :
      nums = [5,1,5,2,5,3,5,4]
      Sort
      1,2,3,4,5,5,5,5

      We have only one element which repeated n times, other are unique

      We need to calculate first repeated number
    * */
    public int repeatedNTimes(int[] nums) {
        // calculate  n
        int len = nums.length;
        int n = len / 2;

        for (int i = 0; i <= len - n; i++) {
            int num = nums[i];
            for (int j = i+1; j < i + n; j++) {
                if(nums[j]==num){
                     return num ;
                }
            }
        }
         return -1;
    }
    public static void main(String[] args) {
        Runnable runnable = ()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        };

         Thread thread = new Thread(runnable);
         thread.start();
        System.out.println("Main Terminated");
    }
}
