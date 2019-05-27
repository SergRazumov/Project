public class Student implements Comparable<Student> {
    private String lastName, firstName;
    private int group;
    private double average;

    public Student(String name, String firstName, int group, double average) {
        this.lastName = name;
        this.firstName = firstName;
        this.group = group;
        this.average = average;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getGroup() {
        return group;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public String toString() {
        return "(" + lastName + ", " +
                firstName +
                ", group=" + group +
                ", average=" + average + ")";
    }

    @Override
    public int compareTo(Student o) {
        return lastName.equals(o.lastName) ? firstName.compareTo(o.firstName) : lastName.compareTo(o.lastName);
    }
}
