import java.util.*;
import java.io.*;

public class Task2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student full name: ");
        String fullName = sc.nextLine();

        System.out.print("Enter student ID: ");
        String studentID = sc.nextLine();

        // PF marks to check for OOP
        System.out.print("Enter marks obtained in PF Lab: ");
        int pfLabMarks = sc.nextInt();

        System.out.print("Enter marks obtained in PF Theory: ");
        int pfTheoryMarks = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        ArrayList<String> courses = new ArrayList<>();
        int totalCredits = 0;
        int maxCredits = 15;
        int creditPerCourse = 3;

        String[] availableCourses = {
                "English",
                "Applied Physics",
                "Calculus",
                "Islamic Studies",
                "ICP"
        };

        System.out.println("Adding courses...");
        for (String course : availableCourses) {
            if (totalCredits + creditPerCourse <= maxCredits) {
                courses.add(course);
                totalCredits += creditPerCourse;
                System.out.println(course + " added. Total credits so far: " + totalCredits);
            } else {
                System.out.println("Cannot add " + course + " due to credit hour limit reached.");
            }
        }

        // check PF prerequisite before adding OOP courses
        boolean pfCleared = (pfLabMarks >= 50 && pfTheoryMarks >= 50);

        if (pfCleared) {
            System.out.println("PF cleared. Checking if OOP Lab and Theory can be added...");

            if (totalCredits + creditPerCourse <= maxCredits) {
                courses.add("OOP Lab");
                totalCredits += creditPerCourse;
                System.out.println("OOP Lab added. Total credits: " + totalCredits);
            } else {
                System.out.println("Cannot add OOP Lab - credit limit reached.");
            }

            if (totalCredits + creditPerCourse <= maxCredits) {
                courses.add("OOP Theory");
                totalCredits += creditPerCourse;
                System.out.println("OOP Theory added. Total credits: " + totalCredits);
            } else {
                System.out.println("Cannot add OOP Theory - credit limit reached.");
            }
        } else {
            System.out.println("PF not cleared.OOP Lab and Theory cannot be registered.");
        }

        // create the file using student name
        String fileName = fullName.replace(" ", "_") + ".txt";
        File studentFile = new File(fileName);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(studentFile));
            bw.write("Student Name: " + fullName);
            bw.newLine();
            bw.write("Student ID: " + studentID);
            bw.newLine();
            bw.write("Total Credit Hours: " + totalCredits);
            bw.newLine();
            bw.newLine();
            bw.write("Registered Courses:");
            bw.newLine();

            for (int i = 0; i < courses.size(); i++) {
                bw.write((i + 1) + ". " + courses.get(i) + " (3 credit hours)");
                bw.newLine();
            }

            bw.close();
            System.out.println("Student data written to file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        // read and display
        System.out.println("--- Reading from file --");
        try {
            BufferedReader br = new BufferedReader(new FileReader(studentFile));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        sc.close();
    }
}