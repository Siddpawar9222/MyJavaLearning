package M_Java8.D_Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Basic {
  

    public static void main(String[] args) {

        // Without stream
        List<Integer> list = new ArrayList<>();
        List<Integer> listOfEven = new ArrayList<>();
        list.add(10);
        list.add(1);
        list.add(22);
        list.add(30);
        list.add(20);
        for (Integer element : list) {
            if (element % 2 == 0) {
                listOfEven.add(element);
            }
        }
        // System.out.println(listOfEven);


        // with stream
        List<Integer> list1 = List.of(10, 1, 22, 30, 20);
        List<Integer> listOfEven1 = list1.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());

        System.out.println(listOfEven1);

    }
}

/*
 (java.util.stream package)
 -Stream is a sequence of elements that can be processed in a functional and declarative way. Think of it as a pipeline through which data flows, and you can perform operations on that data as it passes through the pipeline.
 The Stream API allows you to process data in a functional style, making the code more concise, readable, and potentially parallelizable.
 -This Stream is different from IO stream.
 -steps
   Get Stream instance -->  use streams methods(method chaining)--->collect data
 */