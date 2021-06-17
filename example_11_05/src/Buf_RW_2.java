/*Код программы Buf_RW_2 - чтение из одного файла и запись в другой файл с использованием класса PrintWriter.*/
import java.io.*;
public class Buf_RW_2 {
    public static void main(String[] args) {
        BufferedReader br = null;
        PrintWriter out=null;
        try { // Создание потоков
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("C:\\Test\\MyFile1.txt"),"UTF-8"));
            out = new PrintWriter("C:\\Test\\MyFile2.txt", "UTF-8");
            int lineCount = 0; String s;
            while ((s = br.readLine()) != null) { lineCount++; out.println(lineCount + ": " + s);
            }
        } catch (IOException e) { System.out.println("Ошибка !!!!!!!!"); }
        finally{
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.flush();
            out.close();
        }}}
//PrintWriter out = new PrintWriter(System.out);
//int lineCount = 0; String s; // Вывод информации из файла на монитор
//while ((s = br.readLine()) != null) { lineCount++; out.println(lineCount + ": " + s);
//}
