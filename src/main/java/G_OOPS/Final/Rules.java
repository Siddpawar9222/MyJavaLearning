package G_OOPS.Final;


//Final variable cannot change Throughout the program 
//Final method cannot be overridden by subclass 
//Final class cannot be extended 
public class Rules {
      private final int id ;    //blank final field (need to defined constructor)
      private static final String str ;  // static final (need to define static block)
      
      public Rules(int id){
        this.id = id ;
      }

      static{
        str = "Siddhesh" ;
      }
     

      // public void setId(int id){
      //   this.id =id ;
      // }
      
}
/*
We can assign blank final field only with constructor
We can assign static blank final field only with static block

 */