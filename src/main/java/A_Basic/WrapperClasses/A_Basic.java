package A_Basic.WrapperClasses;

public class A_Basic {
    public static void main(String[] args) {
        int a = 10;                 // primitive
        Integer b = Integer.valueOf(a); // wrapper object

        System.out.println(b);     // Output: 10

    }
}
/*

What are Wrapper Classes?
In Java, wrapper classes are used to convert primitive data types into objects.
 Primitive → Object

Java has 8 primitive types like:
int, char, boolean, float, double, long, short, byte

But Java is an object-oriented language — and sometimes, we need to use primitives as objects (for example, in collections like ArrayList, or for autoboxing).]
To make java 100% Object-Oriented  we use wrapper classes

Example :

Primitive Type	Wrapper Class
byte	Byte
short	Short
int	    Integer
long	Long
float	Float
double	Double
char	Character
boolean	Boolean
* */