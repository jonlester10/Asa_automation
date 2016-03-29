/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configurations;

import ASA_Automation.ASAautomation;
import java.util.Scanner;



/**
 *
 * @author Jon
 */
public class ACL_config {
 
    private String menu;    
    private String promptMessage = 
               "\nPlease Enter Your Selection                                   "
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" ;

    
    public ACL_config(){
        menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +  "\n Enter Source Input                                           "
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +  "\n S - Single IP                                                "
            +  "\n N - Network                                                  "
            +  "\n O - Object                                                   "                
            +  "\n G - Object-group                                             "                
            +  "\n Q - Exit to Main Menu                                        "
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        
        
    }
    
public void display() {
        
        boolean done = false; // set flag to not done
        do {
            // prompt for and get players name
            String input = this.getInput();
            System.out.println(this.promptMessage);
            if (input.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the program
            
            String source = getSrc(input); //user inputs source IP
            
            //Set Menu for Destination
            
        menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +  "\n Enter Destination Input                                      "
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +  "\n S - Single IP                                                "
            +  "\n N - Network                                                  "
            +  "\n O - Object                                                   "                
            +  "\n G - Object-group                                             "                
            +  "\n Q - Exit to Main Menu                                        "
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
            
        input = this.getInput();
        
        String destination = setDst(input);
        
        } while (!done);
    }
        
    public String getInput() {
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        String value = "";
        boolean valid = false; //set flag to invalid value entered

        while(!valid) { // while a valid name has not been retrieved
        
            //prompt for the player's name
            System.out.println(this.menu);
        
            value = keyboard.nextLine(); //get the name from the keyboard
            value = value.trim(); //trim off the excess blanks
            value = value.toUpperCase(); // converts to upper case letter
        
            // if the name is invalid (less than one character in length))
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
        
    
    public String getSrc(String source){
    
            switch (source){
                case "S":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Source IP                                    "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    source = " host " + this.getInput();            
                    System.out.println(source);
                    break;
                case "N":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Source Network                               "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    source = this.getInput();
                    System.out.println(source);
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Source Subnet                                "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    String subnet = this.getInput();
                    source = source + " " + subnet;
                    System.out.println(source);
                    break;
                case "O":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Source Object                                "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    source = " object " + this.getInput();
                    break;
                case "G":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Source Object-Group                          "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    source = " object-group " + this.getInput();
                default:
                    System.out.println(
                                     "\n***************************************"
                                   + "\n***** Invalid Selection Try Again *****"
                                   + "\n***************************************");
                break;
            } 
        System.out.println(source);
        return source;
    }
    public String configCreation(String acl, String action, String source, String destination, String protocol, int port){
        
        ASAautomation.config = "\n access-list" + acl + "extended" + action + protocol + source + destination + " eq " + port;
        
        String returnMessage = "ACL Added Successfully";
        
        return returnMessage;
    }

    private String setDst(String Destination) {
            
            switch (Destination){
                case "S":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Source IP                                    "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    Destination = " host " + this.getInput();            

                    break;
                case "N":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Source Network                               "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    Destination = this.getInput();

                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Source Subnet                                "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    String subnet = this.getInput();
                    Destination = Destination + " " + subnet;

                    break;
                case "O":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Source Object                                "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    Destination = " object " + this.getInput();
                    break;
                case "G":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Source Object-Group                          "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    Destination = " object-group " + this.getInput();
                default:
                    System.out.println(
                                     "\n***************************************"
                                   + "\n***** Invalid Selection Try Again *****"
                                   + "\n***************************************");
                break;
            } 
        System.out.println(Destination);
        return Destination;
    }
    
}
