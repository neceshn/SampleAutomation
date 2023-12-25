package utils;

import java.io.*;

public class IOHelper {
    public static void writeTxt(String Filename ,String text) throws IOException {
        FileWriter writer = new FileWriter(Filename );
        writer.write(text);
        writer.close();
    }

    public static String readTxt(String Filename) throws FileNotFoundException {
        File file = new File(Filename);

        try (FileReader fr = new FileReader(file)) {
            char[] chars = new char[(int) file.length()];
            fr.read(chars);

            String fileContent = new String(chars);
            return fileContent;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
