package emailapp;

import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args){
        Scanner s = new Scanner((System.in));
        //User info
        System.out.println("Enter first name: ");
        String f_name = s.next();
        System.out.println("Enter last name: ");
        String l_name = s.next();

        //creating object for email class
        Email em1 = new Email(f_name, l_name);
        int choice = -1;
        do{
            System.out.println("\n*******\nEnter your choice\n1.Show Info \n2.Change password" +
                    " \n3.Change mailbox capacity \n4. Set Alternate mail \n5.Store data in file \n6. Display data from file \n7.Exit");

            choice = s.nextInt();
            switch (choice){
                case 1:
                    em1.getInfo();
                    break;

                case 2:
                    em1.set_password();
                    break;

                case 3:
                    em1.set_mailCap();
                    break;

                case 4:
                    em1.alernate_email();
                    break;

                case 5:
                    em1.storeFile();
                    break;

                case 6:
                    em1.read_file();
                    break;

                case 7:
                    System.out.println("Thank you for using the app");
                    break;

                default:
                    System.out.println("Invalid choice!! \nEnter proper choice again");
            }
        }while (choice!=7);
    }
}
