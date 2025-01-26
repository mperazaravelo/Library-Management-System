/*
 Marla Peraza Ravelo
 CEN 3024C - Software Development 1
 January 24, 2025
 LibraryManagementSystem.java
 This class contains all the methods necessary to manipulate a Patron object,
 including adding patrons from a file or manually, removing patrons, displaying the current patrons in the
 system, and displaying the LMS menu.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    //Attribute
    private List<Patron> patrons;

    /*
      method: LibraryManagementSystem
      parameters: None
      return: -
      purpose: Constructor method, creates a LibraryManagementSystem object
     */
    public LibraryManagementSystem() {
        patrons = new ArrayList<>();
    }

    /*
      method: newPatronFromFile
      parameters: filePath(string)
      return: void
      purpose: reads the contents of a file using the file path, breaks them into id, name,
      address, and overdue fine, and creates a new Patron object to be added to the patrons list
     */
   public void newPatronFromFile(String path) {
        try (BufferedReader r = new BufferedReader(new FileReader(path))) {
            String ln; //line
            while ((ln = r.readLine()) != null) {
                String[] parts = ln.split("-");
                if (parts.length == 4) {
                    String id = parts[0];
                    String name = parts[1];
                    String address = parts[2];
                    double overdueFine = Double.parseDouble(parts[3]);
                    patrons.add(new Patron(id, name, address, overdueFine));
                }
            }
        } catch (IOException e) {
           System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    /*
      method: newPatronManually
      parameters: scanner(Scanner)
      return: void
      purpose: prompts the user to input id, name, address and overdue fine, and creates a
      new Patron object to be added to the patrons list
     */
    public void newPatronManually(Scanner scanner) {
        try {
            System.out.print("Enter a 7-digit ID: ");
            String id = scanner.nextLine();
            if (id.length() != 7) {
                throw new InvalidIdException("The ID has to have exactly 7 digits");
            }
            System.out.print("Enter a name: ");
            String name = scanner.nextLine();
            System.out.print("Enter an address: ");
            String address = scanner.nextLine();
            System.out.print("Enter the overdue fine (from 0.00 to 250.00): ");
            double overdueFine = scanner.nextDouble();
            if (overdueFine < 0.00 || overdueFine > 250.00) {
                throw new OverdueRangeException("Overdue Fine should be between $0 and $250.00");
            }
            // Get rid of the newline character
            scanner.nextLine();

            patrons.add(new Patron(id, name, address, overdueFine));
            System.out.println("Patron has been added.");
        } catch (InvalidIdException e) {
            System.out.println(e.getMessage());
        }
          catch(OverdueRangeException e){
            System.out.println(e.getMessage());
            }
    }
    /*
      method: removePatronById
      parameters: id (String)
      return: void
      purpose: Removes a patron from the patrons list given its id
     */

    public void removePatronById(String id) {
        boolean isRemoved = patrons.removeIf(patron -> patron.getId().equals(id));
        if (isRemoved) {
            System.out.println("Patron has been removed");
        } else
            System.out.println("Id provided does not match any existing patrons");
    }

    /*
      method: displayPatrons
      parameters: None
      return: void
      purpose: displays all the current patrons' information on the screen. If the
      list is empty, returns a corresponding message
     */
    public void displayPatrons() {
        if (patrons.isEmpty()) {
            System.out.println("\nCurrently there are no patrons in the system");
        } else {
            System.out.println("Patrons in the system:");
            for (Patron p : patrons) {
                System.out.println(p);
            }
        }
    }

    /*
      method: displayMenu
      parameters: None
      return: void
      purpose: displays the LMS menu
     */
    public void displayMenu() {
        System.out.println("\n1. Add patrons from a file"+
                "\n2. Add a patron manually" +
                "\n3. Remove a patron using ID number"+
                "\n4. Display all patrons"+
                "\n5. Exit"+
                "\nEnter a number to start: ");
    }
}