package L_CollectionFramework.MyList;


import java.util.Comparator;
import java.util.TreeSet;

class KthLargest {

    private final TreeSet<Integer> set ;   // we want unique score in sorted manner
    private final int  k ;

    public KthLargest(int k, int[] nums) {
          this.set = new TreeSet<>(Comparator.reverseOrder());
          this.k=k;
    }

    public int add(int val) {
           set.add(val);
           if(set.size()>k){
                set.pollFirst();
           }
           return set.first();
    }
}

public class A_Basic {

}
