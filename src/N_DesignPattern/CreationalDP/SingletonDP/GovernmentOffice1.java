package N_DesignPattern.CreationalDP.SingletonDP;

public class GovernmentOffice1 {
    
    //Eagar way to create Singleton object
    private final static GovernmentOffice1 governmentOffice1 = new GovernmentOffice1() ;

    private GovernmentOffice1(){

    }

    public static GovernmentOffice1 getgovernmentOffice(){
        return governmentOffice1 ;
    }
}
/*
   Eagar way is good in multithreaded environment but in big project it will create lets say i have multiple singleton classes , then even if i dont use some classes then still eagar way will create single object for each classes, .This become slow application
 */