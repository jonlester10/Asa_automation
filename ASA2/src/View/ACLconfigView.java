/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import ASA_Automation.ASAautomation;
import Configurations.ACL_config;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 *
 * @author jblester
 */
public class ACLconfigView {
    
    
    
    private String menu;    
    private String promptMessage = 
               "\nPlease Enter Your Selection                                   "
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" ;
    
    protected final BufferedReader keyboard = ASAautomation.getInFile();
    protected final PrintWriter console = ASAautomation.getOutFile();
    

    public void ACLconfigView() {
        
    }
    public void display() {
        ACL_config acl = new ACL_config();
        
        
        boolean done = false; // set flag to not done
        do {
        //Access-list Query    
        menu = acl.getAccessMenu();          
        String input = this.getInput();
            if (input.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the program
        String access = input;
        
        //Action Query
        menu = acl.getActionMenu();
        input = this.getOptionInput();
        String action = acl.setAction(input);
        
        //Protocol Query
        menu = acl.getProtocolMenu();
        input = this.getInput();
        String protocol = acl.setProtocol(input);
        
        //Source Query
        menu = acl.srcMenu();
        input = this.getOptionInput();
            if (input.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the program
        String source = acl.getSrc(input); //user inputs source IP
            
        //Destination Query    
        menu = acl.dstMenu();           
        input = this.getOptionInput();
            if (input.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the program
        String destination = acl.setDst(input);
        
        //Port Query
        menu = acl.getPortMenu();
        input = this.getOptionInput();
        String port = acl.setPort(input);
        
        done = acl.configCreation(access, action, source, destination, protocol, port);
        
        } while (!done);
    }
 
public String getInput() {
    String value = "";
    try {  
        
        boolean valid = false; //set flag to invalid value entered

        while(!valid) { // while a valid name has not been retrieved
        
            //prompt for the player's name
            this.console.println(this.menu);
        
            value = this.keyboard.readLine(); //get the name from the keyboard
            value = value.trim(); //trim off the excess blanks
        
            // if the name is invalid (less than one character in length))
            if (value.length() < 1) {
               this.console.println(
                       "\n*****************************************************"
                     + "\n***** Invalid value - the value cannot be blank *****"
                     + "\n*****************************************************");
              continue; // and repeat again
            }
            valid = true; // set flag to end repetition
        }
    } catch(Exception e) {
        this.console.println("Class: " + this.getClass().getName() + "Error Reading IO: "  + e.getMessage());
    }
    return value; // return the value
    }
public String getOptionInput() {
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
}
