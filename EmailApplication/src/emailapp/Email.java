package emailapp;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Email {
    public Scanner s = new Scanner(System.in); //scanner class

    //variables
    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alter_email;

    //constructor
    public Email(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
        System.out.println("New employee: " + this.fname + " " + this.lname);
        //Calling methods
        this.dept = this.setDept(); //Department
        this.password = this.generate_password(8); //Password
        this.email = this.generate_email(); //email generation
    }

    //Generate mail method
    private String generate_email(){
        return this.fname.toLowerCase()+ "." + this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".company.com";
    }

    //Asking for department
    private String setDept(){
        System.out.println("Department codes \n1 for sales \n2 for Development \n3 for Accounting \n0 for none");
        boolean flag = false;
        do{
            System.out.println("Enter Department code");
            int choice = s.nextInt();
            switch (choice){
                case 1: return "Sales";
                case 2: return "Development";
                case 3: return "Accounting";
                case 0: return "None";
                default: System.out.println("Invalid choice please choose again");
            }
        } while(!flag);
        return null;
    }

    //Generate Random password method
    private String generate_password(int length){
        Random r = new Random();
        String Captial_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars =   "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&?";
        //concatenation of strings
        String values = Captial_chars+Small_chars+numbers+symbols;
        String password="";

        for (int i =0; i<length; i++){
            password = password+values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

    //change password method
    public void set_password(){
        boolean flag = false;
        do{
            System.out.println("Do you want to change your password? (Y/N");
            char choice = s.next().charAt(0);

            if (choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.println("Enter current password");
                String temp = s.next();

                if (temp.equals(this.password)) {
                    System.out.println("Enter new password: ");
                    this.password = s.next();
                    System.out.println("Password changed successfully.");
                } else {
                    System.out.println("Incorrect password");
                }
            }
                else if (choice == 'N'|| choice == 'n'){
                    flag =true;
                    System.out.println("Password changed option cancelled");
                }
                else System.out.println("Enter valid choice");
            }
        while (!flag);
        }

        public void set_mailCap(){
            System.out.println("Current capacity = " + this.mailCapacity+ "mb");
            System.out.println("Enter new mailbox capacity: ");
            this.mailCapacity = s.nextInt();
            System.out.println("Mailbox capacity is successfully changed.");
        }

        public void alernate_email(){
         System.out.println("Enter new alternate mail: ");
         this.alter_email = s.next();
            System.out.println("Alternate email is set");
        }

        //Display user information method
        public void getInfo(){
            System.out.println("New:"+this.fname+" "+this.lname);
            System.out.println("Department:"+this.dept);
            System.out.println("Email: "+ this.email);
            System.out.println("Password: "+ this.password); //printing purposes only
            System.out.println("Mailbox capacity: "+ this.mailCapacity);
            System.out.println("Alternate mail: "+ this.alter_email);
        }

        //Store in File
    public void storeFile(){
        try{
            FileWriter in = new FileWriter("/Users//maherabdoualy//Desktop//EmailApplication/info.txt");
            in.write("First namer: "+ this.fname);
            in.append("\nLast name: "+ this.lname);
            in.append("\nEmail: "+this.email);
            in.append("\nPassword: "+this.password);
            in.append("\nCapacity: "+this.mailCapacity);
            in.append("\nAlternate mail: "+this.alter_email);
            in.close();
            System.out.println("Data stored..");

        }catch (Exception e) {
            System.out.println(e);
            }
         }

         //reading file method
    public void read_file() {
        try {
            FileReader f1 = new FileReader("/Users//maherabdoualy//Desktop//EmailApplication/info.txt");
            int i;
            while ((i=f1.read()) != -1) {
                System.out.print((char) i);
            }
            f1.close();
        } catch (Exception e) {
            System.out.println(e);
          }
        }
    }

