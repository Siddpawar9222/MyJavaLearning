package M_Java8.B_MCR;
import java.util.Arrays;
import java.util.List;


public class Basic2 {
    public static void main(String[] args) {    
        //instance method(With paramter)
        // List<Integer> list = List.of(10, 20, 60, 1);
        // list.stream().sorted().forEach(e -> System.out.println(e));
        // list.stream().sorted().forEach(System.out::println);

        List<String> strings = Arrays.asList("hello", "world", "welcome");
        strings.stream().sorted(String::compareToIgnoreCase).forEach(System.out::println);//Example1
        strings.stream().filter(e->e.startsWith("A")).map(e->e.toUpperCase()).forEach(e->System.out.println(e));//Example 2

        strings.stream().filter(e->e.startsWith("A")).map(e->e.toUpperCase()).forEach(e->System.out.println(e));//Example 2
 

    }
}

/*

 Example 1 :
  sorted() method takes Comparator as parameter

  Comparator(Functional Interface) ---> int compare(T o1, T o2);

  String Class  --->
  public int compareToIgnoreCase(String str) {
        return CASE_INSENSITIVE_ORDER.compare(this, str);
  }
   
  In Lambda
  (o1,o2)->o1.compareToIgnoreCase(o2);
   
  In method reference it will 
  String::compareToIgnoreCase
  
  So what is Conclusion here :
  -Most IMP Paramter should be same(compareToIgnoreCase requires two paramter and compare method has two paramter)
  -Return type should be equal.

  //=================================================================================//

  Example 2 :
  filter method takes Predicate as parameter
  
  Predicate(Functional Interface)--->boolean test(T t);
  
  String Class  --->
  public boolean startsWith(String prefix) {
        return startsWith(prefix, 0);
  }

   In Lambda
  (t)->t.startsWith("A");

  In method reference it will not possible because test() method takes 1 paramter and startsWith() requires two parameter.


 */