/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configurations;

import ASA_Automation.ASAautomation;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author jblester
 */
public abstract class Configuration implements ConfigurationInterface{
    
    protected String menu;
    protected String promptMessage;
    
    protected final BufferedReader keyboard = ASAautomation.getInFile();
    protected final PrintWriter console = ASAautomation.getOutFile();
    
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
