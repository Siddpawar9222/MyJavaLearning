package A_Basic.TypeCasting;

public class TypeCasting2 {

    public static void main(String[] args) {
      
      //dividing integer by integer
      int x = 10 ;
      int y = 20 ;
      //float z =  x/y ; //Wrong output
      float z = (float)x/y ;  // Rule 6
      System.out.println(z);
  
      
  
      //dividing float by integer
      float a = (float)10.10 ;  // Rule 1
     // OR //float a1 = 10.10f ;
      int b = 10 ; 
  
      float c = a/b ;  // Rule 6 and Rule 5
      System.out.println(c);
      
       float  k = 7/2 * 16/5 ;
       float  k1 = (float)7/2 * 16/5 ;   //*
       System.out.println(k);
       System.out.println(k1);
      
    }
  }
  /*
  Note : 
  Decimal value(fractional number) : e.g. 1205.56
  Whole number value : e.g. 45451 ,-62542
  
  Rules : 
  
  1]Decimal literals without any suffix are treated as double by default. For example, 10.10 is treated as a double.

  2]Whole number literals (without any decimal point) are treated as integers by default. For example, 10 is treated as an int.
  
  3] Types of typecasting for primitive data types :
     A] Implicit(Default or Widening) typecasting :
        Done by java automatically,safe
        conversion of smaller value to larger value
        e.g. int to long , float to double etc

    B] Explicit(narrowing) typecasting :
         Developer has to do , not safe
         conversion of larger value to smaller value
         e.g.. long to int , double to float etc


  4]In Java, when you perform operations (like addition, subtraction,  multiplication, or division) between same numeric types, the  result is we get also of same numeric types.
  
  5]
  In Java, when you perform operations (like addition, subtraction, multiplication, or division) between different numeric types, the result is automatically promoted to the widest data type involved in the operation.
  
  e.g..
  float a = (float)10.10 ;
  int b = 10 ; 

  float c = a/b ;
  In this case:
  
     a is a float.
     b is an int.
  The wider type here is float because it can accommodate both integer and floating-point values. So, during the division operation, Java automatically promotes b to a float before performing the division. This means that the division operation is essentially between two float values (a and the promoted b).

    float c = a/b ;
  if c would have defined double , it would have been worked , beacuse double is biggger than float , and it would work . (Rule 3)

  6]Hence to get correct result when you divide same numeric types value (like Integer to Integer) ,you have cast one of the integers to a float or a double, like this: (float)10/20 or 10.0/20 . Now in expression widest datatype would be here float or double. 
  

  //* -- >
    (float)7/2 * 16/5 ==> 3.5 * 16/5 ==> 56.00/5 (According to Rule 5 ) ==> 11.2

      Typecasting  type for Objects :
       Upcasting(Parent reference to Child object) : implicitly done by java : safe
       Down-casting(Child reference to Parent object) : explicitly done by developer : not safe
      I have mentioned this in OPPS.Objects.java file
   */