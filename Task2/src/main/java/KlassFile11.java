import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.UUID;
public class KlassFile11 {
    private static final int UTF_COUNT = 3;
    private static final int DBL_COUNT = 5;
    public static void main(String[] args) throws IOException
    {
        DataInputStream in = null;
        PrintWriter out = null;
        try {
            in = new DataInputStream(new FileInputStream(PrepareFile(GetFileByName("Task2_Input.txt"))));
            out = new PrintWriter(GetFileByName("Task2_Output.txt"),"cp1251");
            for (int i = 0; i < UTF_COUNT; i++) {
                String string = in.readUTF();
                if (i==1) {
                    out.println(string);
                }
                System.out.println("Строка №" + i+1 + ": " + string);
            }
            for (int i = 0; i < DBL_COUNT; i++) {
                double dbl = in.readDouble();
                if (dbl > 0) {
                    out.println(dbl);
                }
                System.out.println("Число №" + i+1 + ": " + dbl);
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            assert in != null;
            in.close();
            assert out != null;
            out.flush();
            out.close();
        }
    }

    public static File GetFileByName(String filename) throws IOException {
        boolean newFile = false;
        String dirPath = "C:\\Test\\%s";
        File f1=new File(String.format(dirPath, filename));
        newFile = f1.createNewFile();
        return f1;
    }
    public static File PrepareFile(File file) throws IOException {
        try (DataOutputStream in = new DataOutputStream(new FileOutputStream(file))) {
            Random r = new Random();
            for (int i = 0; i < UTF_COUNT; i++) {
                in.writeUTF(UUID.randomUUID().toString());
            }
            for (int i = 0; i < DBL_COUNT; i++) {
                in.writeDouble(-1000 + 2000 * r.nextDouble());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return file;
    }
}
