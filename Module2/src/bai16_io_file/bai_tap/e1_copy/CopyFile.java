package bai16_io_file.bai_tap.e1_copy;

import java.io.*;

public class CopyFile {
    public void copyFile() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(
                        new File("src/bai16_io_file/bai_tap/e1_copy/pack_a/file_a.csv")));
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(
                        new File("src/bai16_io_file/bai_tap/e1_copy/pack_a/file_a.csv")));
        BufferedWriter bufferedWriter_B = new BufferedWriter(
                new FileWriter(
                        new File("src/bai16_io_file/bai_tap/e1_copy/pack_b/file_b.csv")));
        for (int index = 1; index < 10; index++){
            bufferedWriter.write("num " + index);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter_B.write("B: " + line);
            bufferedWriter_B.newLine();
        }
        bufferedWriter_B.close();
    }

    public static void main(String[] args) throws IOException {
        CopyFile copyFile = new CopyFile();
        copyFile.copyFile();
    }
}
