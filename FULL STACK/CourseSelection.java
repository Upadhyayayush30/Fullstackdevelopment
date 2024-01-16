import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CourseSelection {
    private static Map<String, Integer> courseCountMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Get user input for name
            System.out.print("Enter your name (type 'exit' to stop): ");
            String name = scanner.nextLine();

            // Check if the user wants to exit
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            // Get user input for course name
            System.out.print("Enter the course name: ");
            String courseName = scanner.nextLine();

            // Assign course ID based on the course name
            String courseID = generateCourseID(courseName);

            // Display the assigned course ID
            System.out.println("\nCourse ID for " + name + ": " + courseID);
        }

        // Close the scanner
        scanner.close();
    }

    // Helper method to generate the next available ID for the given course
    private static String generateCourseID(String courseName) {
        // Check if the courseName is already present in the map
        if (courseCountMap.containsKey(courseName)) {
            // If present, increment the count
            int count = courseCountMap.get(courseName);
            count++;
            courseCountMap.put(courseName, count);
            return courseName.substring(0, 1) + count;
        } else {
            // If not present, add it to the map with count 1
            courseCountMap.put(courseName, 1);
            return courseName.substring(0, 1) + 1;
        }
    }
}
