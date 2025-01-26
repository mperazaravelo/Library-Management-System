/*
  Marla Peraza Ravelo
  CEN 3024C - Software Development 1
  January 24, 2025
  Patron.java
  This class creates a Patron object and will print the id, name, address and overdue fine of each Patron
 */
class Patron {
   //Attributes
    private String id;
    private String name;
    private String address;
    private double overdueFine;

    /*
      method: Patron
      parameters: id (String), name (String), address(String), overdueFine(double)
      return: -
      purpose: Constructor method, creates a Patron object
     */
    public Patron(String id, String name, String address, double overdueFine) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.overdueFine = overdueFine;
    }
    /*
      method: getId
      parameters: None
      return: String
      purpose: retrieves the id from the Patron object
     */
    public String getId() {
        return id;
    }

    /*
      method: toString
      parameters: None
      return: String
      purpose: prints the details of the Patron object
     */
    @Override
    public String toString(){
      return  "{Id = " + id +"; Name = " + name + "; address = " + address + "; Overdue Fine = $" + overdueFine +"}";
    }
}
