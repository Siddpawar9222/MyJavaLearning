package N_DesignPattern.CreationalDP.SingletonDP;

import java.io.Serial;
import java.io.Serializable;

public class  GovernmentOffice2 implements Serializable ,Cloneable{

    private GovernmentOffice2() {
         if(GovernmentOffice2Holder.governmentOffice2 !=null){
             throw new RuntimeException("You cannot create instace of class , it already exist...") ;
          }
    }

    private static final class GovernmentOffice2Holder {
        private static final GovernmentOffice2 governmentOffice2 = new GovernmentOffice2();
    }

    public static GovernmentOffice2 getgovernmentOffice2() {

        return GovernmentOffice2Holder.governmentOffice2;
    }

    @Serial
    public Object readResolve(){
        return GovernmentOffice2Holder.governmentOffice2;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();    
    }

}
/*
When you make your Singleton class Serializable, Java allows the object to be saved and restored from a file.

❗ Problem:
During deserialization, Java creates a new object, which breaks the singleton (because now you have 2 objects in memory).

- How readResolve() fixes it?
    readResolve() is a special method of serialization.

When deserialization happens:
    Java creates a new object

Before returning that object, JVM checks:
Does this class have a readResolve() method?
If yes → JVM ignores the new object and returns the object provided by readResolve()

🔥 In simple words:

readResolve() replaces the deserialized object with the existing Singleton instance.
 */