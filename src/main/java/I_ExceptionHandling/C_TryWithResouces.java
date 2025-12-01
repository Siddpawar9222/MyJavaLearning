package I_ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class C_TryWithResouces {
    public static void main(String[] args) {

           // without try with resources
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader("data.txt"));
                String line = br.readLine();
                System.out.println(line);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (br != null) {
                        br.close();  // we must close manually
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // With try with resources
        try (BufferedReader br1 = new BufferedReader(new FileReader("data.txt"))) {
            String line = br1.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
}
/*
TryWithResouces :
- It is used to automatically close resources like files, database connections, input streams, output streams, etc., without writing finally block.
- Advantages :
     No need of finally block.
     Auto close when try block ends.
     Clean, short, safe code.
     If exception happens, resource still closes.

Which classes can be used in try-with-resources?
Any class that implements AutoCloseable interface.
Example classes:
FileReader
BufferedReader
FileInputStream
Connection (JDBC)
Scanner
PrintWriter
ZipInputStream
Socket
All these close automatically.
* */