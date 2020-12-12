import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDateTime;

public class Main {
    private static StringBuilder log;
    private static final String catalog = "catalog";
    private static final String file = "file";

    public static void main(String[] args) {
        log = new StringBuilder();
        String root = "E://Games/";
        createCatalog(root, "Save Games");
        createCatalog(root + "src", "test");
        createFile(root + "src/main", "Main.java");
        createFile(root + "src/main", "Utils.java");
        createCatalog(root + "res", "drawables");
        createCatalog(root + "res", "vectors");
        createCatalog(root + "res", "icons");
        createFile(root + "temp", "temp.txt");
    }

    private static void createCatalog(String path, String fileName) {
        File file = new File(path, fileName);
        file.mkdirs();
        setSuccessfulLog(file.getAbsolutePath(), catalog);
    }

    private static void createFile(String path, String fileName) {
        File fileCreate = new File(path, fileName);
        fileCreate.getParentFile().mkdirs();
        try {
            fileCreate.createNewFile();
            setSuccessfulLog(fileCreate.getAbsolutePath(), file);
            try(FileWriter writer = new FileWriter(fileCreate)) {
                writer.write(log.toString());
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private static void setSuccessfulLog(String name, String type) {
        log.append(LocalDateTime.now().toLocalTime() + " " + name + " " + type + " was successfully created\n");
    }

    private static void setFailedLog(String name, String type, String exception) {
        log.append(LocalDateTime.now().toLocalTime() + " " + type + " " + name + " cannot be created: " + exception);
    }
}
