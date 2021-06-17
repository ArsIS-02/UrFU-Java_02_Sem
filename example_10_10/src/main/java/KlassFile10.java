import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class KlassFile10 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        PrintWriter out = null;
        try { // Создание потоков
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(GetFileByName("MyFile1.txt")),"cp1251"));
            out = new PrintWriter(GetFileByName("MyFile2.txt"),"cp1251"); // Переписывание информации из одного файла в другой
            int lineCount = 0; String s;
            while ((s = br.readLine()) != null) {
                lineCount++; out.println(lineCount + ": " + s);
            }
        }
        catch (IOException e) {
            System.out.println("Ошибка !!!!!!!!");
        }
        finally{
            br.close();
            out.flush();
            out.close();
        }
    }

    private static String DirPath = "C:\\Test\\%s";
    public static File GetFileByName(String filename) throws IOException {
        File f1=new File(String.format(DirPath, filename));
        f1.createNewFile();
        return f1;
    }

}

