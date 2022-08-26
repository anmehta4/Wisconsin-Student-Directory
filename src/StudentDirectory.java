// --== CS400 File Header Information ==--
// Name: Arnav Mehta
// Email: anmehta4@wisc.edu
// Team: LC
// Role: Test Engineer 2
// TA: Divyanshu Saxena
// Lecturer: Gary Dahl
// Notes to Grader: None

import java.util.ArrayList;
import java.util.Scanner;

public class StudentDirectory implements WiscIDList {
  public static HashTableMap<String, Integer> map = new HashTableMap<String, Integer>(50);
  public static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    insertStudents();
    System.out.println("**WELCOME TO THE STUDENT GUIDE**");
    runApp();
  }

  /**
   * Method to run the Student Directory application. Will run until user exits the app.
   */
  public static void runApp() {
    map.mapToCsv();
    int option = chooseOption(); // Displays main menu.

    while (option != 2) {
      if (option == 1) // If user wants to search for a student by name
      {
        System.out.println("Enter NetID or Last name of Student: ");
        String input = scanner.next();
        String input2 = "";
        if (map.containsKey(input))// Checks if key/ similar name is in Hash table.
        {
          while (map.get(input).size() != 2) {
            ArrayList<String> value = map.get(input);
            System.out.println("Possible NetIDs : ");
            for (int i = 0; i <= value.size() - 1; i++) {
              System.out.println(value.get(i));
              i++;
            }
            System.out.println("Enter correct NetID to get more information : ");
            input = scanner.next();
          }
          input2 = input;
          if (map.containsKey(input2))// Checks if key/ similar name is in Hash table.
          {
            ArrayList<String> value3 = map.get(input2);
            System.out.println(value3.get(0));

            int option2 = chooseOption2(); // Displays sub menu/second menu.
            while (option2 != 4) {
              if (option2 == 1) // Retrieves 10 digit Campus ID
              {
                if (map.containsKey(input))// Checks for key in Hash table.
                {
                  ArrayList<String> value2 = map.get(input2);
                  System.out.println("10 digit Campus ID for " + input2 + " is " + value2.get(1));
                  option2 = chooseOption2();
                }
              } else if (option2 == 2) // Retrieves NetID
              {
                if (map.containsKey(input))// Checks for key in Hash table.
                {
                  ArrayList<String> value2 = map.get(input2);
                  System.out.println("Wisc email :  " + value2.get(0).concat("@wisc.edu")); // Displays
                                                                                            // Wisc
                                                                                            // email
                  option2 = chooseOption2();
                }
              } else if (option2 == 3) {
                break;
              } else if (option2 == 4) {
                System.out.println("Goodbye.");
                System.exit(0);
              }
            }

            option = chooseOption();

          } else {
            System.out.println("Student does not exist.");
            option = chooseOption();
          }
        } else // Wrong input - student not in university.
        {
          System.out.println("Student does not exist.");
          option = chooseOption();
        }
      } else if (option == 2) // Exit app.
      {
        System.out.println("Goodbye.");
        System.exit(0);
      }
    }
    System.out.println("Goodbye.");
    System.exit(0);
  }


  /**
   * Setup method to put 50 students' information into Hash table.
   */
  public static void insertStudents() {
    map.put("acrego", Student1.getID());
    map.put("jcharleso", Student2.getID());
    map.put("mqhmed", Student3.getID());
    map.put("ppewds", Student4.getID());
    map.put("bmars", Student5.getID());
    map.put("jjolu", Student6.getID());
    map.put("vdavid", Student7.getID());
    map.put("hjames", Student8.getID());
    map.put("fben", Student9.getID());
    map.put("djames", Student10.getID());
    map.put("abruno", Student11.getID());
    map.put("galex", Student12.getID());
    map.put("jmichael", Student13.getID());
    map.put("djohnson", Student14.getID());
    map.put("wsmith", Student15.getID());
    map.put("jsmith", Student16.getID());
    map.put("ijohnson", Student17.getID());
    map.put("mjordan", Student18.getID());
    map.put("abaker", Student19.getID());
    map.put("cvella", Student20.getID());
    map.put("ttim", Student21.getID());
    map.put("anieves", Student22.getID());
    map.put("csanders", Student23.getID());
    map.put("sdickerson", Student24.getID());
    map.put("mdominguez", Student25.getID());
    map.put("troman", Student26.getID());
    map.put("ehills", Student27.getID());
    map.put("hmedrano", Student28.getID());
    map.put("hday", Student29.getID());
    map.put("rmichael", Student30.getID());
    map.put("phumphrey", Student31.getID());
    map.put("kmac", Student32.getID());
    map.put("hreeves", Student33.getID());
    map.put("kwalters", Student34.getID());
    map.put("gbuck", Student35.getID());
    map.put("ewitt", Student36.getID());
    map.put("ggraham", Student37.getID());
    map.put("kyoder", Student38.getID());
    map.put("aboone", Student39.getID());
    map.put("smann", Student40.getID());
    map.put("ahinton", Student41.getID());
    map.put("rmill", Student42.getID());
    map.put("asalter", Student43.getID());
    map.put("acompton", Student44.getID());
    map.put("tpaine", Student45.getID());
    map.put("mholder", Student46.getID());
    map.put("rchambers", Student47.getID());
    map.put("acarty", Student48.getID());
    map.put("swebster", Student49.getID());
    map.put("bcamacho", Student50.getID());
  }



  /**
   * Main menu.
   * 
   * @return
   */
  public static int chooseOption() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please Enter your option:-" + "\n"
        + "1. Search for Student with NetID or Last Name" + "\n" + "2. Exit.");
    int option = scanner.nextInt();
    return option;
  }

  /**
   * Second menu.
   * 
   * @return
   */
  public static int chooseOption2() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please Enter your option:-" + "\n" + "1. Get Campus ID" + "\n"
        + "2. Get Wisc Email." + "\n" + "3. Enter new NetID/ Last name." + "\n" + "4. Exit.");
    int option2 = scanner.nextInt();
    return option2;
  }
}
