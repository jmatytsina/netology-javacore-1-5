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
        String[] first = {"src", "res", "Save Games", "temp"};
        String[] second = {"main", "test"};
        String[] third = {"drawables", "vectors", "icons"};
        for (String s : first) {
            File file = new File(root, s);
            makeDirectory(file);
            switch (s) {
                case "src":
                    for (String s2 : second) {
                        File file1 = new File(file, s2);
                        makeDirectory(file1);
                        if (s2.equals("main")) {
                            File mainJava = new File(file1, "Main.java");
                            makeFile(mainJava);
                            File utilsJava = new File(file1, "Utils.java");
                            makeFile(utilsJava);
                        }
                    }
                    break;
                case "res":
                    for (String s3 : third) {
                        File file2 = new File(file, s3);
                        makeDirectory(file2);
                    }
                    break;
                case "temp":
                    File tempTxt = new File(file, "temp.txt");
                    makeFile(tempTxt);
            }

        }
    }

    private static void makeDirectory(File file) {
        if (file.mkdir()) {
            setSuccessfulLog(file.getAbsolutePath(), catalog);
        }
    }

    private static void makeFile(File fileInput) {
        try {
            fileInput.createNewFile();
            setSuccessfulLog(fileInput.getAbsolutePath(), file);
            try(FileWriter writer = new FileWriter(fileInput)) {
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
