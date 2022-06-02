import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder string = new StringBuilder();
        File dir = new File("D://Games");
        if (dir.mkdir())
            string.append("Каталог " + dir + " создан" + "\n");

        List<String> dirs = Arrays.asList("src", "res", "savegames", "temp");
        for (String s : dirs
        ) {
            if ((new File(dir, s)).mkdir())
                string.append("Каталог " + s + " создан" + "\n");
        }
        File dirSrc = new File("D://Games/src/main");
        File dirSrc2 = new File("D://Games/src/test");
        File dirSrc3 = new File("D://Games/temp");
        if (dirSrc.mkdir())
            string.append("Каталог " + dirSrc.getAbsolutePath() + " создан" + "\n");
        if (dirSrc2.mkdir())
            string.append("Каталог " + dirSrc2.getAbsolutePath() + " создан" + "\n");

        List<String> dirsRes = Arrays.asList("drawables", "vectors", "icons");
        for (String d : dirsRes
        ) {
            if ((new File("D://Games/res", d)).mkdir())
                string.append("Каталог " + d + " создан" + "\n");
        }
        File myFile = new File(dirSrc, "Main.java");
        File myFile2 = new File(dirSrc, "Utils.java");
        File myFile3 = new File(dirSrc3, "temp.txt");
        try {
            if (myFile.createNewFile())
                string.append("В директории " + dirSrc + " создан файл " + myFile.getName() + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            if (myFile2.createNewFile())
                string.append("В директории " + dirSrc + " создан файл " + myFile2.getName() + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            if (myFile3.createNewFile())
                string.append("В директории " + dirSrc3 + " создан файл " + myFile3.getName() + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try (FileWriter writer = new FileWriter(myFile3)) {
            // запись в файл
            writer.write(String.valueOf(string));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(string);
    }
}
