package N_DesignPattern.CreationalDP.FactoryMethodDP;

public class ComputerFactory {
     public static Computer getComputer(String type ,String ram,String hdd, String cpu){

         if (type == null) {
             return null;
         }

         return switch (type) {
             case "PC" -> new PC(ram, hdd, cpu);
             case "Server" -> new Server(ram, hdd, cpu);
             default -> throw new IllegalArgumentException("Invalid Computer Type " + type);
         };
     }
}
