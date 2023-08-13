import CustomExceptions.InvalidDataElementException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class program {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("/home/malgepav/GeekBrains/Developer/Exceptions/DZ/DZ3/src/main/resources/InputData.txt");
             BufferedReader br = new BufferedReader(fr);) {
            String line = br.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int stringScan(String inputString) throws InvalidDataElementException {
        if (inputString.strip().split(" ").length > 6) return 1;
        if (inputString.strip().split(" ").length < 6) return 2;

        Pattern phoneNumberPattern = Pattern.compile("[1-9][0-9]*");
        return 0;
    }
}
