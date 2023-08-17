public class Name {
    String firstName;
    String lastName;
    String middleName;

    public Name(String lastName, String firstName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        return String.format("<%s><%s><%s>",lastName,firstName,middleName);
    }
}
