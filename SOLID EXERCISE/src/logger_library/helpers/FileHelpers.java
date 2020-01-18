package logger_library.helpers;

import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHelpers implements FileStorage {
    private File file;
    private String path;
    private long size;

    public FileHelpers() {
        this.path = "out.txt";
        this.file = new File(path);
        this.size = 0;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void write(String text) {

        this.actualizeSize(text);
        try {
            StringBuilder builder = new StringBuilder();
            byte[] bytes= Files.readAllBytes(Paths.get(file.getPath()));
            for (byte aByte : bytes) {
                builder.append(Character.valueOf((char) aByte));
            }
            builder.append(text);

            PrintWriter writer = new PrintWriter(this.file);
            writer.write(builder.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public long getSize() {
        return size;
    }

    private void actualizeSize(String text) {
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (Character.isAlphabetic(symbol)) {
                this.size += symbol;
            }
        }
    }
}
