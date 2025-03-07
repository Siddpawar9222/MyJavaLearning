package M_Java8.D_Stream.New;

import java.util.List;

public class Employee {
    String name;
    Integer salary;
    List<String> skills ;

    public Employee() {

    }

    public Employee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name, List<String> skills){
         this.name=name;
         this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", skills=" + skills +
                '}';
    }
}
