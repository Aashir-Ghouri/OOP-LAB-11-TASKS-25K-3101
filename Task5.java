import java.util.*;
import java.io.*;

public class Task5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // create the confidential file
        File confidentialFile = new File("Confidential.txt");

        try {
            if (confidentialFile.createNewFile()) {
                System.out.println("Confidential.txt created successfully.");
            } else {
                System.out.println("File already exists.");
            }

            // write something in it
            BufferedWriter bw = new BufferedWriter(new FileWriter(confidentialFile));
            bw.write("This is a confidential document.");
            bw.close();

        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }

        System.out.print("Enter your designation (Faculty/Student): ");
        String designation = sc.nextLine().trim();

        if (designation.equalsIgnoreCase("Faculty")) {
            // give RWX permissions to faculty
            confidentialFile.setReadable(true);
            confidentialFile.setWritable(true);
            confidentialFile.setExecutable(true);
            System.out.println("Faculty access granted: Read, Write, Execute permissions set.");

        } else if (designation.equalsIgnoreCase("Student")) {
            // students only get read permission
            confidentialFile.setReadable(true);
            confidentialFile.setWritable(false);
            confidentialFile.setExecutable(false);
            System.out.println("\nStudent access granted: Read-only permission set.");

        } else {
            System.out.println("Unknown designation. No permissions assigned.");
        }
        
        System.out.println("ACCESS RIGHTS STATUS : ");
        System.out.println("File Name : " + confidentialFile.getName());
        System.out.println("Readable  : " + confidentialFile.canRead());
        System.out.println("Writable  : " + confidentialFile.canWrite());
        System.out.println("Executable: " + confidentialFile.canExecute());

        sc.close();
    }
}
