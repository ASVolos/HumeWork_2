package FamilyTree.Writer;

import java.io.*;

public class FileHandler implements Writer {

//    private String filePath = "D:\\Study\\GeekBrains\\My\\Semestrer2\\Java_3_group\\HomeWork2\\family_members.ser";

    @Override
    public void serializeFamily(Serializable serializable) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("family_members.txt"))) {
            out.writeObject(serializable);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Object deserializeFamily() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("family_members.txt"))) {
            Object object = in.readObject();
            return object;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

//    @Override
//    public void setPath(String path) {
//
//    }
}