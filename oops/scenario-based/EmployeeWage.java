class EmployeeWage {
    static final int FULL_TIME = 2;
    static final int PART_TIME = 1;
    static final int WAGE_PER_HOUR = 20;
    static final int FULL_HOUR = 8;
    static final int PART_HOUR = 4;
    static final int MAX_DAYS = 20;
    static final int MAX_HOURS = 100;

    // instance variables
    private int totalWage = 0;
    private int totalHours = 0;
    private int totalDays = 0;

    // checking attendance
    public int checkAttendance() {

        // random type
        int type = (int) (Math.random() * 3);
        return type;
    }
    // monthly wage logic
    public void calculateWage() {
        // looping till limits
        while (totalDays < MAX_DAYS && totalHours < MAX_HOURS) {
            totalDays++;

            // getting type
            int empType = checkAttendance();
            int hours = 0;

          switch(empType){
            case PART_TIME: 
            hours = PART_HOUR;
            break;
            case FULL_TIME:
              hours = FULL_HOUR;
              break;
            default:
              hours =0; 
          }

            // adding values
            totalHours = totalHours + hours;
            totalWage = totalWage + (hours * WAGE_PER_HOUR);
        }
    }
    public void showResult() {

        System.out.println("days: " + totalDays);
        System.out.println("hours: " + totalHours);
        System.out.println("wage: " + totalWage);
    }
    public static void main(String[] args) {
        // object creation
        EmployeeWage emp = new EmployeeWage();

        // calling logic
        emp.calculateWage();

        // printing output
        emp.showResult();
    }
}
