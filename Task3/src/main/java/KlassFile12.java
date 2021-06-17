import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class KlassFile12 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;
        int i = 0;
        try {
            in = new BufferedReader( new InputStreamReader( new FileInputStream(GetFileByName("Task3_Input.txt")),"cp1251"));
            out = new PrintWriter(GetFileByName("Task3_Output.txt"), "cp1251");
            String line;
            while ((line = in.readLine()) != null) {
                i++;
                for (String string : GetWords(line/*.replaceAll(",|.", "")*/)) {
                    System.out.println(i+": "+string);
                    out.println(i+": "+string);
                }
                in.readLine();
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

    private static final String DirPath = "C:\\Test\\%s";
    public static File GetFileByName(String filename) {
        return new File(String.format(DirPath, filename));
    }

    private static ArrayList<String> GetWords(String inStr)
    {
        var res = new ArrayList<String>();
        for (String string : inStr.split(" ")) {
            if (StartsWithConsonant(string)) {
                res.add(string);
            }
        }
        return res;
    }
    private static final String ConsonantList = "бвгджзйклмнпрстфхцчшщ";
    private static boolean StartsWithConsonant(String inStr)
    {
        return ConsonantList.contains(inStr.subSequence(0, 1));
    }
}

