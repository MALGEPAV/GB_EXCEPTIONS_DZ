import jdk.jfr.Unsigned;

public class Entry {
    Name name;
    String phoneNumber;
    char gender;
    DateOfBirth dateOfBirth;

    public Entry(Name name, String phoneNumber, char gender, DateOfBirth dateOfBirth) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return String.format("%s%s<%s><%c>",name,dateOfBirth,phoneNumber,gender);
    }
}
