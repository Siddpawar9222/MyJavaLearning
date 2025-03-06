package G_OOPS.Polymorphism;
/* 
If we don't know how many argument we will have to pass in the method, variable arguments(varargs) is the better approach than Method overloading . 

Rules----
1)ellipses(only 3 ellipses allowed(dots))
2)variable arguments should be last argument of the method.
3)A method should contain only one variable argument
*/
public class Varargs {
    static void foo(int a , int...arr)
    {
        System.out.println("the length is "+arr.length);
        int sum=0 ;
        for(int element : arr)
        {
             sum += element ;   
        }

           sum  +=  a ;
        System.out.println("Addition is "+  sum);
    }
    public static void main(String[] args) {
        foo(10 , 50 , 60 ,100 ,200);
    }
}
