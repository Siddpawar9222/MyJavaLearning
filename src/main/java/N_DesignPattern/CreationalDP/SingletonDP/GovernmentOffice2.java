package N_DesignPattern.CreationalDP.SingletonDP;

import java.io.Serializable;

public class  GovernmentOffice2 implements Serializable ,Cloneable{

    private static GovernmentOffice2 governmentOffice2;

    private GovernmentOffice2() {
        // if(governmentOffice!=null){
        //     throw new RuntimeException("You cannot create instace of class , it already exist...") ;
        //  } 
    }

    public static GovernmentOffice2 getgovernmentOffice2() {

        if (governmentOffice2 == null) {

            synchronized (GovernmentOffice2.class) {
                if (governmentOffice2 == null) {
                    governmentOffice2 = new GovernmentOffice2();
                }
            }

        }
        return governmentOffice2;
    }

    public Object readResolve(){
        return governmentOffice2 ;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();    
    }

}
/*
 The readResolve method is called when ObjectInputStream has read an object from the stream and is preparing to return it to the caller. ObjectInputStream checks whether the class of the object defines the readResolve method. If the method is defined, the readResolve method is called to allow the object in the stream to designate the object to be returned. The object returned should be of a type that is compatible with all uses. If it is not compatible, a ClassCastException will be thrown when the type mismatch is discovered.
 */