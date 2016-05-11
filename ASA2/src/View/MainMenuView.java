/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import ASA_Automation.ASAautomation;
import Configurations.*;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Jon
 */
public class MainMenuView {
    protected final BufferedReader keyboard = ASAautomation.getInFile();
    protected final PrintWriter console = ASAautomation.getOutFile();
    private String menu;    
    private String promptMessage = 
               "\nPlease Enter Your Selection                                   "
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" ;
    private String ACLconfig= "";
    
    public MainMenuView() {
        menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +  "\n Main Menu                                                    "
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +  "\n O - Create Object                                            "
            +  "\n A - Create ACL Entry                                         "
            +  "\n W - Write Configuration to a file                            "
            +  "\n Q - Quit Program                                             "
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
 }
        public void display() {
        
        boolean done = false; // set flag to not done
        do {
            // prompt for and get players name
            String value = this.getInput();
            if (value.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game
            
            // do the requested action and display the next view
            done = this.doAction(value);
        } while (!done);
        
    }
        
        public String getInput() {
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        String value = "";
        boolean valid = false; //set flag to invalid value entered

        while(!valid) { // while a valid name has not been retrieved
        
            //prompt for the player's name
            System.out.println(this.menu);
            System.out.println(this.promptMessage);
        
            value = keyboard.nextLine(); //get the name from the keyboard
            value = value.trim(); //trim off the excess blanks
            value = value.toUpperCase(); // converts to upper case letter
        
            // if the name is invalid (less than one character in length))
            if (value.length() >= 2) {
              System.out.println(
                "\n*************************************************************"
               + "\n***** Invalid value - the value cannot be more than one *****"
               + "\n*************************************************************");
                continue; // and repeat again
            }
            if (value.length() < 1) {
               System.out.println(
                       "\n*****************************************************"
                     + "\n***** Invalid value - the value cannot be blank *****"
                     + "\n*****************************************************");
              continue; // and repeat again
            }
            valid = true; // set flag to end repetition
        }
    return value; // return the value
    }
        
            public boolean doAction(String choice) {
        
        switch (choice) {
            case "A":
                this.aclConfig();
                break;
            case "N":
                this.natConfig();
                break;
            case "O":
                this.objConfig();
                break;
            case "G":
                this.objGroupConfig();
                break;
            case "W":
                this.printConfig();
                break;
            case "F":
                this.faqView();
            default:
                System.out.println(
                                     "\n***************************************"
                                   + "\n***** Invalid Selection Try Again *****"
                                   + "\n***************************************");
                break;
        }
        return false;
    }

    private void aclConfig() {
        ACLconfigView acl = new ACLconfigView();
        acl.display();
        
        this.ACLconfig += acl.getACLconfig();
    }

    private void natConfig() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void objConfig() {
        Objectconfigview obj = new Objectconfigview();
        obj.display();
        
    }

    private void objGroupConfig() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void printConfig() {
        this.console.println("\n\nEnter the file path for the output of the configuration:");
        String filePath = this.getStringInput();
        try {
            ASAautomation.config += this.ACLconfig;
            ASAautomation.config += "\r\nend"
                                  + "\r\nwr mem";
            try (PrintWriter fops = new PrintWriter(filePath)){
                fops.println(ASAautomation.config);
            } catch (Exception e){
                this.console.println("Error Writing to the file location");
            }
        } catch (Exception ex) {
                this.console.println("Error Writing to the file location");
        }
        
    }

    private void faqView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     private String getStringInput() {
                
        String value = "";
        boolean valid = false; //set flag to invalid value entered
try {
        while(!valid) { // while a valid name has not been retrieved
        
            
            //prompt for the player's na
        

            value = this.keyboard.readLine();//get the name from the keyboard
            value = value.trim(); //trim off the excess blanks
            value = value.toUpperCase(); // converts to upper case letter  
            
 // and repeat again
            
            if (value.length() < 1) {
               this.console.println(this.getClass().getName() + 
                       "\n*****************************************************"
                     + "\n***** Invalid value - the value cannot be blank *****"
                     + "\n*****************************************************");
              continue; // and repeat again
}             
            valid = true; // set flag to end repetition
}
} catch(Exception e) { 
            this.console.println(this.getClass().getName() + "Error Reading Input: " + e.getMessage());
            
            }
            return value;
    }  
}

