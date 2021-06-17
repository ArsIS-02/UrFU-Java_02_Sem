/*Чтение из одного файла и запись в другой файл данных 
построчно с использованием буферизации символьных потоков основанных на 
байтовых файловых потоках.*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.File;
import java.io.IOException;

public class KlassFile9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try { // —оздание потоков дл¤ чтени¤ и записи с нужной кодировкой
            br = new BufferedReader( new InputStreamReader( new FileInputStream(GetFileByName("MyFile1.txt")),"cp1251"));
            bw = new BufferedWriter( new OutputStreamWriter( new FileOutputStream(GetFileByName("MyFile2.txt")),"cp1251"));
            int lineCount = 0; // счетчик строк
            String s;
            while ((s = br.readLine()) != null) {
                lineCount++; System.out.println(lineCount + ": " + s);
                bw.write(lineCount + ": " + s); // запись без перевода строки
                bw.newLine(); // принудительный переход на новую строку
            }
        } catch (IOException e) { System.out.println("Ошибка!!!!!!!!");
        }
        finally{
            br.close();
            bw.flush();
            bw.close();
        }
    }

    private static String DirPath = "C:\\Test\\%s";
    public static File GetFileByName(String filename) throws IOException {
        File f1=new File(String.format(DirPath, filename));
        f1.createNewFile();
        return f1;
    }
}
