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
    private String access;
    private String action;
    private String protocol;
    private String source;
    private String destination;
    private String port;

    public void ACLconfigView() {
        
    }
    public void display() {
        ACL_config acl = new ACL_config();
        
        
        boolean done = false; // set flag to not done
        do {
        //Access-list Query
        do {
        menu = acl.getAccessMenu();          
        String input = this.getInput();
            if (input.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the program
        this.access = input;
        
            } while (access == null);
        //Action Query
        do{
        menu = acl.getActionMenu();
        String input = this.getOptionInput();
        this.action = acl.setAction(input);
            } while (action == null);
        //Protocol Query
        do {
        menu = acl.getProtocolMenu();
        String input = this.getInput();
        this.protocol = acl.setProtocol(input);
        } while (protocol == null);
        //Source Query
        do {
        menu = acl.srcMenu();
        String input = this.getOptionInput();
            if (input.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the program
        this.source = acl.getSrc(input); //user inputs source IP
        } while (source == null);
        //Destination Query
        do {
        menu = acl.dstMenu();           
        String input = this.getOptionInput();
            if (input.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the program
        this.destination = acl.setDst(input);
        } while (destination == null);
        //Port Query
        do {
        menu = acl.getPortMenu();
        String input = this.getOptionInput();
        this.port = acl.setPort(input);
        } while (port == null);
        
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
