package G_OOPS.Object.EqualsAndHashCode;

public class Main {
    public static void main(String[] args) {
          Employee employee1 = new Employee(10,"Siddhesh");
          Employee employee2 = new Employee(11,"Pawar");
          Employee employee3 = new Employee(10,"Siddhesh");

        System.out.println(employee1.hashCode());
        System.out.println(employee2.hashCode());
        System.out.println(employee3.hashCode());
    }
}
