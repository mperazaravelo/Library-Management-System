/*
  Marla Peraza Ravelo
  CEN 3024C - Software Development 1
  January 24, 2025
  Main.java
  This class will create the Library Management System, display the menu for the user to choose the
  actions, and call the methods to manipulate the patrons list
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //creating the objects and variables
        LibraryManagementSystem lms = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int userInput;

        //do-while loop that contains the switch statement
        do {
            //Displaying title, patrons and menu
            System.out.println("\nLibrary Management System");
            System.out.println("****************************");
            lms.displayPatrons();
            lms.displayMenu();
            userInput = scanner.nextInt();
            // Consume newline character
            scanner.nextLine();

            //beginning of the switch statement
            switch (userInput) {
                //Add patrons from file
                case 1:
                    System.out.print("Enter file path: ");
                    String filePath = scanner.nextLine();
                    lms.newPatronFromFile(filePath);
                    break;
                //Add a patron manually
                case 2:
                    lms.newPatronManually(scanner);
                    break;
                //Remove a patron by ID
                case 3:
                    System.out.print("Enter ID to remove: ");
                    String id = scanner.nextLine();
                    lms.removePatronById(id);
                    break;
                //Display all patrons
                case 4:
                    lms.displayPatrons();
                    break;
                //xit
                case 5:
                    System.out.println("Exiting the system");
                    break;
                //Invalid choice
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (userInput != 5);

        //closing the scanner
        scanner.close();
    }
}

