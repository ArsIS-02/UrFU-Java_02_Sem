/*Прочитать и вывести на экран информацию из трех источников: файла 
на диске, интернет-страницы и массива данных типа byte. Указать кодировку, 
поддерживающую кириллицу. */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;

public class KlassFile8 {
    public static void readAllByByte( Reader in) throws IOException {
        while (true) {
            int oneByte = in.read(); // читает 1 байт
            if (oneByte != -1) { // признак конца файла
                System.out.print((char) oneByte);
            }
            else {
                System.out.print("\n" + " конец ");
                break;
            }
        }
    }public static void main(String[] args) {
        try {
            // С потоком связан файл
            InputStream inFile = new FileInputStream("D:\\MyFile1.txt"); // байтовый
            // поток
            Reader rFile= new InputStreamReader(inFile,"cp1251"); // символьный
            // поток
            readAllByByte(rFile);
            System.out.print("\n\n\n");
            inFile.close();
            rFile.close();
            // С потоком связана интернет-страница
            //передается «русская» кодировка
            InputStream inUrl = new URL("http://google.com").openStream(); // байтовый
            // поток
            Reader rUrl=new InputStreamReader(inUrl, "cp1251"); // символьный
            // поток
            readAllByByte(rUrl);
            System.out.print("\n\n\n");
            inUrl.close();
            rUrl.close();
            // С потоком связан массив типа byte
            InputStream inArray = new ByteArrayInputStream( new byte[] {5, 8, 3, 9, 11});
            Reader rArray=new InputStreamReader(inArray,"cp1251" ); // символьный
            // поток
            readAllByByte(rArray);
            System.out.print("\n\n\n");
            inArray.close();
            rArray.close();
        }
        catch (IOException e) {
            System.out.println("Ошибка: "+ e);
        }
    }
}