package bai16_io_file.bai_tap.e2_country;

import java.io.*;

public class Country {
    public void readCountry() throws IOException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(
                    new FileReader(
                            new File("src/bai16_io_file/bai_tap/e2_country/country.csv")));
            String line;
            String[] lineCountry;
            while((line = bufferedReader.readLine()) != null){
                lineCountry = line.split(",");
                System.out.println(lineCountry[5]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }
    }
    public static void main(String[] args) throws IOException {
        Country country = new Country();
        country.readCountry();
    }
}
