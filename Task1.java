import java.util.*;
import java.io.*;

public class Task1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> myList = new ArrayList<>();

        System.out.println("Enter 5 elements:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            String val = sc.nextLine();
            myList.add(val);
        }

        // get desktop path and create file there
        String desktopPath = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "mylist.txt";
        File file = new File(desktopPath);

        // writing to file using BufferedWriter
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (String item : myList) {
                bw.write(item);
                bw.newLine();
            }
            bw.close();
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error while writing: " + e.getMessage());
        }

        // reading back from the file
        System.out.println("Reading from file:");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int count = 1;
            while ((line = br.readLine()) != null) {
                System.out.println("Item " + count + ": " + line);
                count++;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error while reading: " + e.getMessage());
        }

        // delete the file
        if (file.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("Could not delete the file.");
        }

        sc.close();
    }
}