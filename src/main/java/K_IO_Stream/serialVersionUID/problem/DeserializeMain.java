package K_IO_Stream.serialVersionUID.problem;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeMain {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student s = (Student) ois.readObject();
            System.out.println("Deserialized: " + s);
            System.out.println("email field: " + getEmailSafe(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static String getEmailSafe(Object obj) {
        try {
            java.lang.reflect.Field f = obj.getClass().getDeclaredField("id");
            f.setAccessible(true);
            Object val = f.get(obj);
            return String.valueOf(val);
        } catch (NoSuchFieldException nsfe) {
            return "<no email field>";
        } catch (Exception ex) {
            return "<error reading email>";
        }
    }
}
