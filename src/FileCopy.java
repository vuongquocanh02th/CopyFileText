import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Vui long cung cap tep nguon va tep dich!");
            return;
        }
        String sourceFilePath = "D:\\CodeGym\\Module2\\copy-file-text\\source.txt";
        String targetFilePath =  "D:\\CodeGym\\Module2\\copy-file-text\\target.txt";;
        File sourceFile = new File(sourceFilePath);
        File targetFile = new File(targetFilePath);
        if (!sourceFile.exists()) {
            System.out.println("Source file not found!");
            return;
        }
        if (targetFile.exists()) {
            System.out.println("Target file already exists!");
            return;
        }
        //Sao chep file
        try (FileReader reader = new FileReader(sourceFile);
             FileWriter writer = new FileWriter(targetFile)) {
            int character;
            int count = 0;
            //Doc ky tu tu tep nguon va ghi vao tep dich
            while ((character = reader.read()) != -1) {
                writer.write(character);
                count++;
            }
            System.out.println("Copying complete!");
            System.out.println("Number of character in source file: " + count);
        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }
}
