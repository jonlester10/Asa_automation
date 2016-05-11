/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import ASA_Automation.ASAautomation;
import Configurations.OBJ_config;
import java.io.BufferedReader;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.Scanner;



/**
 *
 * @author jblester
 */
class Objectconfigview {
    private String menu;
    private String[] objects;
    private String promptMessage = 
               "\nPlease Enter Your Selection                                   "
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" ;
    protected final BufferedReader keyboard = ASAautomation.getInFile();
    protected final PrintWriter console = ASAautomation.getOutFile();
    
  public void Objectconfigview() {
     
      
  }
  public void display(){
      OBJ_config conf = new OBJ_config();
      
      menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
          +  "\n Please enter how many objects you wish to create             "
          +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
      
      String input = getInput();
      int num = parseInt(input);
      
      for (int i = 1; i < num; i++){
          
          
          
      }
        
        
        
        

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
            value = value.toUpperCase();            // if the name is invalid (less than one character in length))
            
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
            this.console.println(this.menu);
            this.console.println(this.promptMessage);
        
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
