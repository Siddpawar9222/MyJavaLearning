package A_Basic.WrapperClasses;

public class C_Doubt {
    public static void main(String[] args) {
         long a = 10 ; // Widening (10 int → long)
         //Long b = 10 ; // won't automatically convert int to Long
         Long b1 = 10L ; // Widening (10L long → Long) : same primitive type
         Long c = a ; // Autoboxing (long → Long) : same primitive type
    }
}
/*
 variable =a ,b,c
 literals = constant = 10

 ⚠️ Important Distinction
Concept	Meaning
Widening	Converting a smaller primitive to a larger one (int → long)
Autoboxing	Converting a primitive to a wrapper object (long → Long) : same primitive type
Unboxing	Converting a wrapper to a primitive (Long → long) : same primitive type

All above process is automatically (implicit by java)

IMP :
when there is literals assignment then compiler consider
 - widening or autoboxing
 - size of literal (e.g. short b1 = 63 ; here 63 is int which is greater than short but compiler will check is 63 withing short range and allowed)

when there is variable assignment then compiler consider
 - widening or autoboxing



Java Literal Suffixes

Suffix	       Type	       Example	        Notes
L or l	       long	       10L	            Use L, not l (to avoid confusion with 1)
F or f	       float       3.14F	        Needed for float literals
D or d	       double      2.718D	        Optional (default for decimal is double)
No suffix   int or double  100, 3.14	    Default types




Examples:
long a = 100L;    // long literal
float b = 3.14F;  // float literal
double c = 2.71;  // double literal (default)
double d = 2.71D; // double literal (with suffix)

Why do we need F for float?
float x = 3.14;   //  Error: 3.14 is double by default
float y = 3.14F;  //
* */