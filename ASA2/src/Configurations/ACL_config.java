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

    private String ACLconfig = "";

    public String getACLconfig() {
        return ACLconfig;
    }

    public void setACLconfig(String ACLconfig) {
        this.ACLconfig = ACLconfig;
    }
    
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
    public String[] getSrc(String source){
        String[] output = new String[20];
            switch (source){
                case "S":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Source IP                                    "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    String stage0 = this.getInput();
                    String[] arrstage0 = stage0.split(",", -1);
                    for ( int i = 0; i < arrstage0.length; i ++){
                        output[i] = " host " + arrstage0[i];                               
                    }
                    break;
                case "N":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Source Network                               "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    String stage1 = this.getInput();
                    String[] arrstage1 = stage1.split(",", -1);
                    String[] network = new String[20];
                    for ( int i = 0; i < arrstage1.length; i ++){
                        network[i] = arrstage1[i];
                    }
                    for (int i = 0; i < network.length; i++){
                        if (network[i]== null){
                            break;
                        } else {
                        menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                            +  "\nPlease Enter The Subnet for network " + network[i] + "        "
                            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                        String[] subnet = new String[20];
                        subnet[i] = this.getInput();
                        output[i] = network[i] + " " + subnet[i];
                        }
                    }
                    break;
                case "O":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Source Object                                "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    String stage2 = this.getInput();
                    String[] arrstage2 = stage2.split(",", -1);
                    for ( int i = 0; i < arrstage2.length; i ++){
                        output[i] = " object " + arrstage2[i];
                    }
                    break;
                case "G":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Source Object-Group                          "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    String stage3 = this.getInput();
                    String[] arrstage3 = stage3.split(",", -1);
                    for ( int i = 0; i < arrstage3.length; i ++){
                        output[i] = " object-group " + arrstage3[i];
                    }
                    break;
                case "A":
                    output[0] = " any ";
                    break;
                default:
                    System.out.println(
                                     "\n***************************************"
                                   + "\n***** Invalid Selection Try Again *****"
                                   + "\n***************************************");
                    source = null;
                break;
            } 
        return output;
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
    public String[] setDst(String Destination) {
        String[] output = new String[20];    
            switch (Destination){
                case "S":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Destination IP                               "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    String stage0 = this.getInput();
                    String[] arrstage0 = stage0.split(",", -1);
                    for ( int i = 0; i < arrstage0.length; i ++){
                        output[i] = " host " + arrstage0[i];                               
                    }           

                    break;
                case "N":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Destination Network                          "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    String stage1 = this.getInput();
                    String[] arrstage1 = stage1.split(",", -1);
                    String[] network = new String[20];
                    for ( int i = 0; i < arrstage1.length; i ++){
                        network[i] = arrstage1[i];
                    }
                    for (int i = 0; i < network.length; i++){
                        if (network[i]== null){
                            break;
                        } else {
                        menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                            +  "\nPlease Enter The Subnet for network " + network[i] + "        "
                            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                        String[] subnet = new String[20];
                        subnet[i] = this.getInput();
                        output[i] = network[i] + " " + subnet[i];
                        }
                    }
                    break;
                case "O":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Destination Object                           "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    String stage2 = this.getInput();
                    String[] arrstage2 = stage2.split(",", -1);
                    for ( int i = 0; i < arrstage2.length; i ++){
                        output[i] = " object " + arrstage2[i];
                    }
                    break;
                case "G":
                    menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                        +  "\nPlease Enter The Destination Object-Group                     "
                        +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                    String stage3 = this.getInput();
                    String[] arrstage3 = stage3.split(",", -1);
                    for ( int i = 0; i < arrstage3.length; i ++){
                        output[i] = " object-group " + arrstage3[i];
                    }
                    break;
                case "A":
                    output[0] = " any ";
                    break;
                default:
                    this.console.println(
                                     "\n***************************************"
                                   + "\n***** Invalid Selection Try Again *****"
                                   + "\n***************************************");
                    Destination = null;
                    break;
            } 
        return output;
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
            //+  "\n R - Range"
            +  "\n O - Object-Group" 
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"; 
        
        return portMenu;
    }
    public String[] setPort(String input){
        String[] port = new String[20]; 
        switch(input){
            case "E":
                menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                    +  "\nPlease Enter The Port Number                                  "
                    +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                String stage0 = this.getInput();
                String[] arrstage0 = stage0.split(",", -1);
                for ( int i = 0; i < arrstage0.length; i++){
                port[i] = " eq " + arrstage0[i];
                }
                break;
            case "G":
                menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                    +  "\nPlease Enter The Port Number                                  "
                    +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                String stage1 = this.getInput();
                String[] arrstage1 = stage1.split(",", -1);
                for ( int i = 0; i < arrstage1.length; i++ ) {
                    port[i] = " gt " + arrstage1[i];
                }
                break;
            case "L":
                menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                    +  "\nPlease Enter The Port Number                                  "
                    +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                String stage2 = this.getInput();
                String[] arrstage2 = stage2.split(",", -1);
                for ( int i = 0; i < arrstage2.length; i++ ) {
                   port[i] = " lt " + arrstage2[i]; 
                }
                
                break;
            case "N":
                menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"                
                    +  "\nPlease Enter The Port Number                                  "
                    +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
                String stage3 = this.getInput();
                String[] arrstage3 = stage3.split(",", -1);
                for ( int i = 0; i < arrstage3.length; i++ ) {
                    port[i] = " neq " + arrstage3[i];
                }
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
                    //port = " rng " + int1 + " " + int2;
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
    public boolean configCreation(String acl, String action, String[] source, String[] destination, String protocol, String[] port){
         
        for (int i = 0; i < source.length; i++) {
            if (source[i] == null){
                break;
            } else {
            for (int j =0; j < destination.length; j++)  {
                if (destination[j] == null){
                    break;
                } else {
                for (int k = 0; k < port.length; k++) {
                    if (port[k] == null){
                        break;
                    } else {
                    this.ACLconfig += "\r\naccess-list " + acl + " extended" + action + protocol + source[i] + destination[k]  + port[k];
                    }
                  }
            }
            }
        }
        }
        //TEST OUTPUT
        this.console.println(this.ACLconfig);
        
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
