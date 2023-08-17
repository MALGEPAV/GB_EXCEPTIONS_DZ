import CustomExceptions.*;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class program {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("src/main/java/InputData.txt");
             BufferedReader br = new BufferedReader(fr);) {
            String inputString;
            while((inputString = br.readLine()) != null) {
                try {
                    int r = stringScan(inputString);
                    switch (r){
                        case 1:
                            System.out.println("Слишком много данных в строке\n"+"'"+inputString+"'");
                            break;
                        case 2:
                            System.out.println("Недостаточно данных в строке\n"+"'"+inputString+"'");
                            break;
                        default:
                            break;
                    }
                } catch (InvalidDataElementException e){
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int stringScan(String inputString) throws InvalidDataElementException {
        if (inputString.strip().split(" ").length > 6) return 1;
        if (inputString.strip().split(" ").length < 6) return 2;

        Pattern datePattern = Pattern.compile("[0-9]{2}[.][0-9]{2}[.][0-9]{4}");
        Pattern phoneNumberPattern = Pattern.compile("[1-9][0-9]{4,}");
        Pattern genderPattern = Pattern.compile("[mf]");
        Pattern namePattern = Pattern.compile("[а-яА-Я]+ +[а-яА-Я]+ +[а-яА-Я]+");

        Scanner lineScanner = new Scanner(inputString);

        String newGender = lineScanner.findInLine(genderPattern);
        if (newGender == null) throw new InvalidGenderException(inputString);

        lineScanner = new Scanner(inputString);
        String newDateOfBirth = lineScanner.findInLine(datePattern);
        DateOfBirth newDB = null;
        if (newDateOfBirth != null) {
            String[] dateArray = newDateOfBirth.split("[.]");
            newDB = new DateOfBirth(Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1]), Integer.parseInt(dateArray[2]));
        }
        if (newDB == null || !newDB.isValid()) throw new InvalidDateException(inputString);


        lineScanner = new Scanner(inputString);
        String newPhone = lineScanner.findInLine(phoneNumberPattern);
        if (newPhone == null) throw new InvalidPhoneNumberException(inputString);

        lineScanner = new Scanner(inputString);
        String newName = lineScanner.findInLine(namePattern);
        if (newName == null) throw new InvalidNameException(inputString);
        String[] newNameArray = newName.split(" +");
        Name newFIO = new Name(newNameArray[0], newNameArray[1], newNameArray[2]);


        Entry newEntry = new Entry(newFIO,newPhone, newGender.charAt(0), newDB);
        File newFile = new File("src/main/java/"+newEntry.name.lastName);
        try(FileWriter fw = new FileWriter(newFile,true);
        BufferedWriter bw = new BufferedWriter(fw)){
            bw.write(newEntry.toString());
            bw.newLine();
        } catch (IOException e){
            e.printStackTrace();
        }

        return 0;
    }
}
