import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void createDir(String path, String dirname, StringBuilder logStr) {
        File dir = new File(path + "/" + dirname);
        if (dir.mkdir())
            logStr.append("Каталог " + dir + " создан" + "\n");
    }

    public static void createFile(String path, String filename, StringBuilder logStr) {
        File file = new File(path, filename);
        try {
            if (file.createNewFile())
                logStr.append("В директории " + path + " создан файл " + file.getName() + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        StringBuilder string = new StringBuilder();
        File dir = new File("D://Games");
        String dirTest = "D://";
        createDir(dirTest, "Games2", string);

        List<String> dirs = Arrays.asList("src", "res", "savegames", "temp");
        for (String s : dirs) {
            createDir("D://Games2", s, string);
        }
        createDir("D://Games2/src", "main", string);
        createDir("D://Games2/src", "test", string);

        List<String> dirsRes = Arrays.asList("drawables", "vectors", "icons");
        for (String d : dirsRes
        ) {
            createDir("D://Games2/res", d, string);
        }
        createFile("D://Games2/src/main", "Main.java", string);
        createFile("D://Games2/src/main", "Utils.java", string);
        createFile("D://Games2/temp", "temp.txt", string);

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
