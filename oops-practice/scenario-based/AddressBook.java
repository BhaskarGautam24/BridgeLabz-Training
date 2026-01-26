import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
public class AddressBook{
    static class Person{

        String firstName;
        String lastName;
        String address;
        String city;
        String state;
        String zip;
        String phoneNumber;
        String email;

        Person(String firstName,String lastName,String address,
               String city,String state,String zip,
               String phoneNumber,String email) {
            this.firstName=firstName;
            this.lastName=lastName;
            this.address=address;
            this.city=city;
            this.state=state;
            this.zip=zip;
            this.phoneNumber=phoneNumber;
            this.email=email;
        }
        public boolean equals(Object obj){
            if(this==obj)
                return true;

            if(obj==null||getClass()!=obj.getClass())
                return false;

            Person other=(Person) obj;
            return this.firstName.equalsIgnoreCase(other.firstName)
                    && this.lastName.equalsIgnoreCase(other.lastName);
        }
        public String toString(){
            return firstName+" "+lastName+" | "+city+", "+state+
                    " | Phone: "+phoneNumber;
        }
    }
    // address book class for managing persons
    static class AddressBookData{
        String name;
        ArrayList<Person> persons=new ArrayList<>();
        AddressBookData(String name){
            this.name=name;
        }
        public void addPerson(Scanner sc){
            System.out.print("Enter First Name:");
            String fn=sc.next();

            System.out.print("Enter Last Name:");
            String ln=sc.next();
            Person temp=new Person(fn, ln, "", "", "", "", "", "");
            if (persons.contains(temp)) {
                System.out.println("Duplicate person not allowed");
                return;
            }
            System.out.print("Enter Address:");
            temp.address=sc.next();

            System.out.print("Enter City:");
            temp.city=sc.next();

            System.out.print("Enter State:");
            temp.state=sc.next();

            System.out.print("Enter Zip:");
            temp.zip=sc.next();

            System.out.print("Enter Phone Number:");
            temp.phoneNumber=sc.next();

            System.out.print("Enter Email:");
            temp.email=sc.next();

            persons.add(temp);
            System.out.println("Person added succesfully");
        }
     public void editPerson(String firstName, Scanner sc) {
            for (Person p:persons){
                if (p.firstName.equalsIgnoreCase(firstName)) {
                    System.out.print("Enter new City:");
                    p.city=sc.next();

                    System.out.print("Enter new State:");
                    p.state=sc.next();
                    System.out.println("Person updated");
                    return;
                }
            }
            System.out.println("Person not found");
        }
        public void deletePerson(String firstName) {
            Person removePerson=null;
            for (Person p:persons){
                if (p.firstName.equalsIgnoreCase(firstName)) {
                    removePerson=p;
                    break;
                }
            }
            if (removePerson!=null){
                persons.remove(removePerson);
                System.out.println("Person deleted");
            } else{
                System.out.println("Person not found");
            }
        }

        public void viewPersons(){
            if(persons.size()==0){
                System.out.println("No persons found");
                return;
            }
            for(Person p:persons){
                System.out.println(p);
            }
        }

        public void searchByCityOrState(String value){
            for(Person p:persons){
                if (p.city.equalsIgnoreCase(value)||
                        p.state.equalsIgnoreCase(value)){
                    System.out.println(p);
                }
            }
        }

        public int countByCityOrState(String value){
            int count=0;
            for(Person p:persons){
                if(p.city.equalsIgnoreCase(value) ||
                        p.state.equalsIgnoreCase(value)){
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args){

        System.out.println("Welcome to Address Book Program");

        Scanner sc=new Scanner(System.in);
        HashMap<String, AddressBookData> addressBooks=new HashMap<>();

        while(true){
            System.out.println("1.Add Address Book");
            System.out.println("2.Add Person");
            System.out.println("3.Edit Person");
            System.out.println("4.Delete Person");
            System.out.println("5.View Persons");
            System.out.println("6.Search by City or State");
            System.out.println("7.Exit");
            System.out.println("8.Count by City or State");

            System.out.print("Choose option:");
            int choice=sc.nextInt();

            if(choice==7){
                System.out.println("Program ended");
                break;
            }

            System.out.print("Enter Address Book Name:");
            String bookName=sc.next();

            AddressBookData book=addressBooks.get(bookName);

            switch(choice){
                case 1:
                    if(!addressBooks.containsKey(bookName)){
                        addressBooks.put(bookName, new AddressBookData(bookName));
                        System.out.println("Address Book created");
                    } else {
                        System.out.println("Address Book already exist");
                    }
                    break;
                case 2:
                    if(book != null)
                        book.addPerson(sc);
                    else
                        System.out.println("Address Book not found");
                    break;
                case 3:
                    if(book != null){
                        System.out.print("Enter First Name to edit: ");
                        book.editPerson(sc.next(), sc);
                    } else
                        System.out.println("Address Book not found");
                    break;
                case 4:
                    if(book != null){
                        System.out.print("Enter First Name to delete:");
                        book.deletePerson(sc.next());
                    }else
                        System.out.println("Address Book not found");
                    break;
                case 5:
                    if(book != null)
                        book.viewPersons();
                    else
                        System.out.println("Address Book not found");
                    break;
                case 6:
                    System.out.print("Enter City or State:");
                    String value = sc.next();
                    for(AddressBookData ab : addressBooks.values()){
                        ab.searchByCityOrState(value);
                    }
                    break;
                case 8:
                    System.out.print("Enter City or State:");
                    String key = sc.next();
                    int totalCount = 0;
                    for (AddressBookData ab:addressBooks.values()){
                        totalCount = totalCount + ab.countByCityOrState(key);
                    }
                    System.out.println("Total persons count:" + totalCount);
                    break;

                default:
                    System.out.println("Wrong option");
            }
        }
    }
}
