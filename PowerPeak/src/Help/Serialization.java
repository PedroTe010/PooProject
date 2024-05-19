package Help;

import java.io.*;

public class Serialization {
    private String file;

    public void setFile (String file) {
        this.file = file; //file name for the serialization
    }

    //method to deserialize an object
    public Object getObject () throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(fileIn); //open file for reading purposes

        Object obj = in.readObject(); //get the deserialized object
        in.close(); //close input stream
        return obj;
    }

    //method to serialize an object
    public void writeObject (Object obj) throws IOException, ClassNotFoundException {
        FileOutputStream fileTo = new FileOutputStream(file);
        ObjectOutputStream usersS = new ObjectOutputStream(fileTo); //open file for writing purposes

        usersS.writeObject(obj); //write/serialize the object
        usersS.close(); //close output stream
    }
}
