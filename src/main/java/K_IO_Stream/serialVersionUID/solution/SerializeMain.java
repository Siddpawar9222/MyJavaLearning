package K_IO_Stream.serialVersionUID.solution;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeMain {
    public static void main(String[] args) {
        Student student = new Student(1, "Siddhesh") ;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            oos.writeObject(student);
            System.out.println("Serialized: " + student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
