import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void createDir(String path, StringBuilder logStr) {
        File dir = new File(path);
        if (dir.mkdir())
            logStr.append("Каталог " + dir + " создан" + "\n");
    }

    public static void createFile(String path, StringBuilder logStr) {
        File file = new File(path);
        try {
            if (file.createNewFile())
                logStr.append("Файл " + file + " создан" + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        StringBuilder string = new StringBuilder();
        String[] dirNames = {"D://Games2/src",
                "D://Games2/res",
                "D://Games2/savegames",
                "D://Games2/temp",
                "D://Games2/src/main",
                "D://Games2/src/test",
                "D://Games2/res/drawables",
                "D://Games2/res/vectors",
                "D://Games2/res/icons"};
        String[] fileNames = {"D://Games2/src/main/Main.java",
                "D://Games2/src/main/Utils.java",
                "D://Games2/temp/temp.txt"};

        for (String s : dirNames) {
            createDir(s, string);
        }

        for (String f : fileNames) {
            createFile(f, string);
        }

        try (FileWriter writer = new FileWriter(new File("D://Games2/temp", "temp.txt"))) {
            // запись в файл
            writer.write(String.valueOf(string));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(string);
    }
}
