/*Используя рассмотренные в данной работе примеры 8 и 
9, выполнить задание согласно условию в виде двух проектов: 
1-й проект – работа с файлом с произвольным доступом; 
2-й проект – работа через сериализацию. 
Условие: 
Записать в исходный файл информацию о фильмах: 
Название_фильма, год_выпуска, страна, жанр, стоимость_проката 
Количество фильмов задать с клавиатуры. 
Создать программным способом другой файл и переписать в него 
информацию о фильмах, выпущенных в России. */
import java.io.*;
import java.util.Objects;
import java.util.Scanner;
class Film implements Serializable {
    String nazvanie, god, strana, zhanr;
    int stoimost;
}
public class zadacha3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in, "UTF-8");
        PrintWriter out = null;
// создается файл на диске
        File f = new File("C:\\Test\\My\\MyFileSer1.txt");
        f.createNewFile();
// -------------ЗАПИСЬ ОБЪЕКТА В ФАЙЛ-------------
// Создается поток для записи объекта
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        System.out.print("Введите количество фильмов для записи в файл\n"
                + "=> ");
        int kol = sc.nextInt();
        sc.nextLine(); // очистка буфера после ввода числа
        for (int i = 0; i < kol; i++) {
// Вводится информация об объекте
            Film film = new Film();
            System.out.println("Введите название фильма" + (i + 1) + ": ");
            System.out.print("Название фильма => ");
            film.nazvanie = sc.nextLine();
            System.out.print("Год выпуска=> ");
            film.god = sc.nextLine();
            System.out.print("Страна выпуска=> ");
            film.strana = sc.nextLine();
            System.out.print("Жанр=> ");
            film.zhanr = sc.nextLine();
            System.out.print("Введите стоимость его проката => ");
            film.stoimost = sc.nextInt();
            sc.nextLine(); // очистка буфера после ввода числа
// Объект записывается в файл
            oos.writeObject(film);}
// Дописывается информация и закрывается файловый поток
        oos.flush();
        oos.close();
// -------------ЧТЕНИЕ ОБЪЕКТА ИЗ ФАЙЛА-------------
        out = new PrintWriter(GetFileByName("rec_RAF_res1.txt"), "UTF-8");

// Создается поток для чтения объекта из файла
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream oin = new ObjectInputStream(fis);
// Объект считывается, и на экран выводится требуемая информация
        System.out.println("Название \t\t Год выпуска \t\t Страна \t\t Жанр \t\t Стоимость проката");
        for (int i = 0; i < kol; i++) {
            Film film = new Film();
            film = (Film) oin.readObject();
            System.out.println(film.nazvanie + "\t\t\t" + film.god + "\t\t\t" + film.strana + "\t\t\t" + film.zhanr + "\t\t\t" + film.stoimost);
            String kk = "Russia";
            if (Objects.equals(kk,film.strana.toLowerCase())) {
                out.println("Название \t\t Год выпуска \t\t Страна \t\t Жанр \t\t Стоимость проката");
                out.println(film.nazvanie + "\t\t\t" + film.god + "\t\t\t" + film.strana + "\t\t\t" + film.zhanr + "\t\t\t" + film.stoimost);
            }
        }
// Поток закрывается
        oos.close();
        out.flush();
        out.close();
    }
    private static String DirPath = "C:\\Test\\My\\%s";
    public static File GetFileByName(String filename) throws IOException {
        File f1 = new File(String.format(DirPath, filename));
        return f1;
    }
}
