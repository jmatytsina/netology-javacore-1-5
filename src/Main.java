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
        File root = new File("E://Games");
        File src = new File(root, "src");
        if (src.mkdir()) {
            setSuccessfulLog(src.getAbsolutePath(), catalog);
        }
        File res = new File(root, "res");
        if (res.mkdir()) {
            setSuccessfulLog(res.getAbsolutePath(), catalog);
        }
        File saveGames = new File(root, "Save Games");
        if (saveGames.mkdir()) {
            setSuccessfulLog(saveGames.getAbsolutePath(), catalog);
        }
        File temp = new File(root, "temp");
        if (temp.mkdir()) {
            setSuccessfulLog(temp.getAbsolutePath(), catalog);
        }
        File main = new File(src, "main");
        if (main.mkdir()) {
            setSuccessfulLog(main.getAbsolutePath(), catalog);
        }
        File test = new File(src, "test");
        if (test.mkdir()) {
            setSuccessfulLog(test.getAbsolutePath(), catalog);
        }
        File mainJava = new File(main, "Main.java");
        try {
            mainJava.createNewFile();
            setSuccessfulLog(mainJava.getAbsolutePath(), file);
        } catch (IOException e) {
            setFailedLog(mainJava.getAbsolutePath(), file, e.toString());
        }
        File utilsJava = new File(main, "Utils.java");
        try {
            utilsJava.createNewFile();
            setSuccessfulLog(utilsJava.getAbsolutePath(), file);
        } catch (IOException e) {
            setFailedLog(utilsJava.getAbsolutePath(), file, e.toString());
        }
        File drawables = new File(res, "drawables");
        if (drawables.mkdir()) {
            setSuccessfulLog(drawables.getAbsolutePath(), catalog);
        }
        File vectors = new File(res, "vectors");
        if (vectors.mkdir()) {
            setSuccessfulLog(vectors.getAbsolutePath(), catalog);
        }
        File icons = new File(res, "icons");
        if (icons.mkdir()) {
            setSuccessfulLog(icons.getAbsolutePath(), catalog);
        }
        File tempTxt = new File(temp, "temp.txt");
        try {
            tempTxt.createNewFile();
            setSuccessfulLog(tempTxt.getAbsolutePath(), file);
            try(FileWriter writer = new FileWriter(tempTxt)) {
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
