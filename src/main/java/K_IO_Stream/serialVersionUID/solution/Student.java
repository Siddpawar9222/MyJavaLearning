package K_IO_Stream.serialVersionUID.solution;

import java.io.Serial;
import java.io.Serializable;

public class Student implements Serializable {
    @Serial
    private static  final long serialVersionUID = 1L ;
    int id;
    String name;
    // add email field later after creating student.ser file and again run Deserialize class you will see InvalidClassException
    String email;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                 "}" ;
    }
}