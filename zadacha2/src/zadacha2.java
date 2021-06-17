/*Создать проект, позволяющий из одного текстового файла, содержащего несколько строк (тип String) заранее подготовленного текста на русском языке (обратитесь к классике), построчно переписать в другой текстовый файл слова, отвечающие условию.
Условие:
Переписать в результирующий файл слова, которые начинаются с той же буквы, что и первое слово.
Требования:
–слова из предложения выделять методом split();
–в новом файле следует указать номер строки, в которой искомые слова находились в исходном файле;
–для каждой строки указать количество выбранных слов.
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class zadacha2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;
        int i = 0;
        try {
            in = new BufferedReader( new InputStreamReader( new FileInputStream(GetFileByName("Task3_Input.txt")),"UTF-8"));
            out = new PrintWriter(GetFileByName("Task3_Output.txt"), "UTF-8");
            String line;
            while ((line = in.readLine()) != null) {
                i++;
                int schet = 0;
                String[] words = line.split(" ");
                for (String word : words) {
                    if (StartsWithСonstant(word.toLowerCase(),String.valueOf(line.charAt(0)).toLowerCase())) {
                        System.out.println("строка "+i+": "+word);
                        out.println("строка "+i+": "+word);
                        schet = schet +1;
                    }
                }
                System.out.println("строка "+i+" слов: "+schet);
                System.out.println();
                out.println("строка "+i+" слов: "+schet);
                out.println();
            }}
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            in.close();
            out.flush();
            out.close();
        }
    }
    private static String DirPath = "C:\\Test\\zadacha\\%s";
    public static File GetFileByName(String filename) throws IOException {
        File f1=new File(String.format(DirPath, filename));
        return f1;
    }
    private static boolean StartsWithСonstant(String inStr,String k)
    {
        return k.contains(inStr.subSequence(0, 1));
    }
}

