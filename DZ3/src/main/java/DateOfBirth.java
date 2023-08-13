public class DateOfBirth {
    int day;
    int month;
    int year;
    public DateOfBirth(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("<%02d.%02d.%04d>",day,month,year);
    }
    public boolean isValid(){
        if (year != 2){
            return day <= 30 + (month + (int)((month - 0.5) / 7)) % 2;
        }
        return day <= 28 + yearIsLeap();
    }
    public int yearIsLeap(){
        if ((year % 400 == 0) || (year % 100 != 0) && (year % 4 == 0)){
            return 1;
        }
        return 0;
    }
}
