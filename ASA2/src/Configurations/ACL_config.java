/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configurations;

import ASA_Automation.ASAautomation;



/**
 *
 * @author Jon
 */
public class ACL_config extends Configuration {
 
    private String menu;    
    private String promptMessage = 
               "Please Enter Your Selection                                   "
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" ;

    
    public ACL_config(){
            
    }
    //Access-List
    public String getAccessMenu() {
        String accessMenu = 
               "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +  "\n Please Enter the name of the  Access-list                    "
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";

        
        return accessMenu;
    }
    
    //Action
    public String getActionMenu() {
        String actionMenu = 
               "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +  "\n Please Choose the rule Action" 
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +  "\n P - Permit"
            +  "\n D - Deny"
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        
        return actionMenu;
    }
    public String setAction(String input){
        String action = null;
        switch(input){
            case"P":
                action = " permit";
                break;
            case "D":
                action = " deny";
                break;
            default:
                this.console.println(
                                "\n***************************************"
                              + "\n***** Invalid Selection Try Again *****"
                              + "\n***************************************");
                break;
        }
        return action;
    }
    
    //Protocol
    public String getProtocolMenu() {
        String protocolMenu =
               "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +  "\n Please Choose the rule Protocol" 
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +  "\n T - TCP"
            +  "\n U - UDP"
            +  "\n I - IP"
            +  "\n C - ICMP"
            +  "\n O - Object-group"
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                
        return protocolMenu;
    }
    public String setProtocol(String input){
        String protocol = null;
        switch(input){
            case "T":
                protocol = " tcp";
                break;
            case "U":
                protocol = " udp";
                break;
            case "I":
                protocol = " ip";
                break;
            case "C":
                protocol = " icmp";
                break;
            case "O":
                menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                    +  "\nPlease Enter The Service Object-Group                         "
                    +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                protocol = " object-group " + getInput();
            default:
                 this.console.println(
                                "\n***************************************"
                              + "\n***** Invalid Selection Try Again *****"
                              + "\n***************************************");
                break;
        }
        return protocol;
    }
    
    // Source
    public String srcMenu() {
        String srcMenu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +  "\n Enter Source Input                                           "
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +  "\n S - Single IP                                                "
            +  "\n N - Network                                                  "
            +  "\n O - Object                                                   "                
            +  "\n G - Object-group                                             "
            +  "\n A - Any                                                      "
            +  "\n Q - Exit to Main Menu                                        "
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        
        return srcMenu;
    }
    public String getSrc(String source){
    
            switch (source){
                case "S":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Source IP                                    "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    source = " host " + this.getInput();            
                    break;
                case "N":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Source Network                               "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    source = this.getInput();
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Source Subnet                                "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    String subnet = this.getInput();
                    source += " " + subnet;
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
                    break;
                case "A":
                    source = " any ";
                    break;
                default:
                    System.out.println(
                                     "\n***************************************"
                                   + "\n***** Invalid Selection Try Again *****"
                                   + "\n***************************************");
                    source = null;
                break;
            } 
        return source;
    }
     
    //Destination
    public String dstMenu(){
        String dstMenu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +  "\n Enter Destination Input                                      "
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +  "\n S - Single IP                                                "
            +  "\n N - Network                                                  "
            +  "\n O - Object                                                   "                
            +  "\n G - Object-group                                             "
            +  "\n A - Any                                                      "
            +  "\n Q - Exit to Main Menu                                        "
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        
        return dstMenu;   
    }
    public String setDst(String Destination) {
            
            switch (Destination){
                case "S":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Destination IP                               "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    Destination = " host " + this.getInput();            

                    break;
                case "N":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Destination Network                          "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    Destination = this.getInput();
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Destination Subnet                           "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    String subnet = this.getInput();
                    Destination += " " + subnet;
                    break;
                case "O":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Destination Object                           "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    Destination = " object " + this.getInput();
                    break;
                case "G":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Destination Object-Group                     "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    Destination = " object-group " + this.getInput();
                    break;
                case "A":
                    Destination = " any";
                    break;
                default:
                    this.console.println(
                                     "\n***************************************"
                                   + "\n***** Invalid Selection Try Again *****"
                                   + "\n***************************************");
                    Destination = null;
                    break;
            } 
        return Destination;
    }
    
    //Port
    public String getPortMenu(){
        String portMenu = 
               "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +  "\n Please Choose the Port Requirements" 
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +  "\n E - Equals"
            +  "\n G - Greater Than"
            +  "\n L - Less Than"
            +  "\n N - Not"
            +  "\n R - Range"
            +  "\n O - Object-Group" 
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"; 
        
        return portMenu;
    }
    public String setPort(String input){
        String port= null;
        switch(input){
            case "E":
                menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                    +  "\nPlease Enter The Port Number                                  "
                    +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                port = " eq " + getInput();
                break;
            case "G":
                menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                    +  "\nPlease Enter The Port Number                                  "
                    +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                port = " gt " + getInput();
                break;
            case "L":
                menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                    +  "\nPlease Enter The Port Number                                  "
                    +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                port = " lt " + getInput();
                break;
            case "N":
                menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                    +  "\nPlease Enter The Port Number                                  "
                    +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                port = " neq " + getInput();
                break;
            case "R":
                menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                    +  "\nPlease Enter The First Port Number                            "
                    +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                 int int1 = Integer.parseInt(getInput());
                menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                    +  "\nPlease Enter The Second Port Number                           "
                    +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                int int2 = Integer.parseInt(getInput());
                if (int1 < int2) {
                    port = " rng " + int1 + " " + int2;
                } else {
                    this.console.println(
                                "\n**************************************************************"
                              + "\n***** Your first Number Must be smaller than your second *****"
                              + "\n**************************************************************");
                    port = null;
                }
            break;
            default:
                this.console.println(
                                "\n***************************************"
                              + "\n***** Invalid Selection Try Again *****"
                              + "\n***************************************");
                break;
        }
        
        return port;
    } 
    
    //Rule Creation
    public boolean configCreation(String acl, String action, String source, String destination, String protocol, String port){
        
        ASAautomation.config += "\r\naccess-list " + acl + " extended" + action + protocol + source + destination  + port;
        
        //TEST OUTPUT
        this.console.println(ASAautomation.config);
        
        boolean returnMessage = true;
        
        return returnMessage;
    }

    @Override    
    public String getInput() {
        String value = "";
        boolean valid = false; //set flag to invalid value entered
try {
        while(!valid) { // while a valid name has not been retrieved
        
            //prompt for the player's name
            this.console.println(menu);
            this.console.println(promptMessage);
            value = this.keyboard.readLine(); //get the name from the keyboard
            value = value.trim(); //trim off the excess blanks
        
            // if the name is invalid (less than one character in length)
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
    this.console.println(" Class: " + getClass().getName() + "Error Reading Input: " + e.getMessage());
}
    return value; // return the value
    }
   
}
