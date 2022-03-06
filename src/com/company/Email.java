package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int defaultPasswordLength = 8;
    private String companySuffix = "technology.com";
    private  int mailBoxCapacity = 600;
    private String email;
    private String alternativeEmail;


    public Email(String fName, String lName){
        this.firstName = fName;
        this.lastName = lName;

        //method that return the department
        this.department = choiceDepartment();

        //method that generate random password
        this.password = randomPassword(defaultPasswordLength);

        //generate email
        this.email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + this.department + "." + this.companySuffix;
    }

    //ask for the department
    public String choiceDepartment(){
        System.out.print("Enter the department:\n1 for Engineering\n2 for Software\n3 for Marketing\n4 for Management\n0 for none\nEnter department code:");
        Scanner input = new Scanner(System.in);
        int departmentChoice = input.nextInt();
        switch (departmentChoice){
            case 1:
                return "Eng.";
            case 2:
                return "Dev";
            case 3:
                return "Marketing";
            case 4:
                return "Management";
            case 0:
                return " ";
        }
        return "No department selected!...";
    }

    //generate random password
    public String randomPassword(int passwordlength){
        String passwordSet = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwyz!@#$%&";
        char [] password = new char[passwordlength];
        for (int i = 0; i < passwordlength; i ++){
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }

        return new String (password);
    }

    // set the mailbox capacity
    public void setMailBoxCapacity(int mailBoxCapacity) {
        this.mailBoxCapacity = mailBoxCapacity;
    }

    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }
    //set the alternate email
    public void setAlternativeEmail(String alternativeEmail) {
        this.alternativeEmail = alternativeEmail;
    }

    public String getAlternativeEmail() {
        return alternativeEmail;
    }
    //change password
    public void changePassword(String password){
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void displayInfo(){

        System.out.println("=============== EMPLOYEE INFORMATION =================== \nEmployee Name: "+firstName+ " "+lastName +"\nDepartment: "+ this.department+"\nPassword: "+this.password+ "\nCompany Email: "+ this.email+"\nMailBox Capacity: " + this.getMailBoxCapacity()+ "mb");
    }
}
