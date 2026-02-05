import java.util.Scanner;

class Student { // Task 1
    private final String name;
    private final int id;
    private int year;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.year = 1;
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public int getYear() { return year; }
    public void nextYear() { year++; }
}

class StarTriangle { // Task 2
    private final int width;

    public StarTriangle(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 1; row <= width; row++) {
            for (int col = 1; col <= row; col++) {
                sb.append("[*]");
            }
            if (row < width) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}

class Time { // Task 3
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }

    public void setTime(int hour, int minute, int second) {
        if (isValid(hour, minute, second)) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        } else {
            this.hour = 0;
            this.minute = 0;
            this.second = 0;
        }
    }

    private boolean isValid(int hour, int minute, int second) {
        return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59 && second >= 0 && second <= 59;
    }

    public String toUniversal() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public String toStandard() {
        int h = hour % 12;
        if (h == 0) h = 12;
        String ampm = hour < 12 ? "AM" : "PM";
        return String.format("%02d:%02d:%02d %s", h, minute, second, ampm);
    }

    public void add(Time other) {
        int total = this.toSeconds() + other.toSeconds();
        total %= 24 * 3600;
        this.hour = total / 3600;
        total %= 3600;
        this.minute = total / 60;
        this.second = total % 60;
    }

    private int toSeconds() {
        return hour * 3600 + minute * 60 + second;
    }
}

public class vatafa2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Task 1 output
        Student s = new Student("Mirza", 12345);
        s.nextYear();
        System.out.println("Task 1: " + s.getName() + " - id " + s.getId() + ", курс " + s.getYear());

        // Task 2 output
        System.out.print("Task 2. Enter triangle width: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        StarTriangle small = new StarTriangle(num);
        System.out.println(small.toString());

        // Task 3 output
        Time t = new Time(23, 5, 6);
        System.err.println("Task 3. Time: ");
        System.out.println(t.toUniversal());
        System.out.println(t.toStandard());
        System.err.println("Enter time to add (hour minute second): ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        Time t2 = new Time(a, b, c); // 4 24 33
        t.add(t2);
        System.out.println(t.toUniversal());
        System.out.println(t.toStandard());
    }
}
