/*Записать в файл с произвольным доступом данные о
заданном количестве сотрудников и считать информацию из файла.
Данные о сотрудниках:
– фамилия, должность – записывается в формате строки UTF-8;
– оклад – число типа int.
Один символ в формате UTF – 1 байт, число типа int – 4 байта.
Разное количество байтов для фамилии и должности дополним с
помощью «дозаписи» любых чисел типа byte до общего размера,
например, 20. Значение выбрано из расчета того, что фамилия и
должность будут иметь длину не более 20 символов. */
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RandAccF_record {
    public static void main(String[] args) {
        try {
            File folder = new File("C:\\Test\\My");
            if (!folder.exists())
                folder.mkdir();
            File f1 = new File("C:\\Test\\rec_RAF.txt");
            if (!f1.exists())
                f1.createNewFile();
            RandomAccessFile rf = new RandomAccessFile(f1,"rw"); // чтение и запись
            long fSize = rf.length(); // размер файла
            //System.out.println(rf.length());
            Scanner sc = new Scanner(System.in, "UTF-8");
            System.out.print("Введите количество сотрудников для записи в файл\n"
                    + "=> ");
            int kol = sc.nextInt();
            sc.nextLine(); // очистка буфера после ввода числа
            String fam, doljnost;
            int oklad;
//----ЗАПИСЬ ИНФОРМАЦИИ О СОТРУДНИКАХ В ФАЙЛ----
            for (int i = 0; i < kol; i++) {
                System.out.print("Введите фамилию " + (i + 1) + " сотрудника => ");
                fam = sc.next();
                rf.seek(rf.length()); // поиск конца файла

                rf.writeUTF(fam); // запись фамилии
                for (int j = 0; j < 20 - fam.length(); j++)
                    rf.writeByte(1); // добавление байтов до 20-ти любой цифрой (=1)
                System.out.print("Введите его должность => ");
                doljnost = sc.next();
                rf.seek(rf.length()); // поиск конца файла
                rf.writeUTF(doljnost); // запись должности
                for (int j = 0; j < 20 - doljnost.length(); j++)
                    rf.writeByte(1); // добавление байтов до кол=20 любым числом
                System.out.print("Введите его оклад => ");
                oklad = sc.nextInt();
                sc.nextLine(); // очистка буфера
                rf.seek(rf.length()); // поиск конца файла
                rf.writeInt(oklad); // запись оклада
            }
            rf.close();
//----ЧТЕНИЕ ИНФОРМАЦИИ О СОТРУДНИКАХ ИЗ ФАЙЛА----
            rf = new RandomAccessFile(f1, "r");
            rf.seek(0); // перемещение в начало файла
            System.out.println("Информация о сотрудниках");
            System.out.println("Фамилия \t\t Должность \t\t Оклад");
            for (int i = 0; i < kol; i++) {

                fam = rf.readUTF();
                for (int j = 0; j < 20 - fam.length(); j++)
                    rf.readByte();
                //System.out.println(fam);
                doljnost = rf.readUTF();
                for (int j = 0; j < 20 - doljnost.length(); j++)
                    rf.readByte();
                oklad = rf.readInt();
                //System.out.println(fam);
                //System.out.println(doljnost);
                //System.out.println(oklad);
                System.out.println(fam + "\t\t\t" + doljnost + "\t\t\t" + oklad);
                System.out.println(doljnost=="oklad");
            }
            rf.close();
        } catch (IOException e) {
            System.out.println("End of file " + e);
        } }}