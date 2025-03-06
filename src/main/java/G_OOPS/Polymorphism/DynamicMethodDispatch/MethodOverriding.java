package G_OOPS.Polymorphism.DynamicMethodDispatch;
class Animal {
    int money=51541 ;

    Animal giveBirth() {
        return new Animal();
    }

    public int getHash(){
        return 100 ;
    }
}

class Dog extends Animal {
    @Override
    Dog giveBirth() {
        return new Dog();       //Covariant return type
    }

    @Override
     public int getHash(){
        return 200 ;
    }
    
    public String getId(){
        return "vgsvdhch54" ;
    }

}

public class MethodOverriding {
    public final static void main(String[] args) {
        Animal animal = new Dog();
        Animal newAnimal = animal.giveBirth();  // This will return a Dog instance.
        System.out.println(newAnimal.getClass().getName());
        System.out.println(newAnimal.getHash());
       // System.out.println(newAnimal.getId());
        // System.out.println(newAnimal.money);
    }
}

/*
Covariant return type is a feature introduced in Java 5 that allows a subclass method to override a superclass method and return a more specific (derived) type than the one specified in the superclass method's return type. In other words, it enables the return type of overridden method in a subclass to be a subtype of the return type of the method in the superclass.
*/