package K_IO_Stream.ByteStream.ObjectInput_OutputSteam.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serial {

	public static void main(String[] args) {

		try {
			Student student = new Student("Siddhesh Pawar", "sidd@email.com", "Korahle Khurd", 23);
            
			//write data in file
            FileOutputStream fos = new FileOutputStream("src/K_FileHandling/serialization/output.txt");
			
			ObjectOutputStream oos = new ObjectOutputStream(fos) ;   //* 
			
			//how to serialize
			oos.writeObject(student);
			oos.close();
			fos.close();
			System.out.println("Object state transerred to file !!");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
/*
 How we Perform serialization Here ? 
 - For which thing you want to serialize data ? 
 - In Which state you want to convert the data ?

 Here 
 i want to serialize data of object - ObjectOutputStream(fos)
 state in which want to convert the data - FileOutputStream
 */