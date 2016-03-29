/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import View.MainMenuView;
import java.util.Scanner;

/**
 *
 * @author Jon
 */
public class StartProgramView {
    
    private String menu;    
    private String promptMessage = 
               "\nPlease Enter Your Selection                                   "
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" ;
    
    public StartProgramView() {
        menu = "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +  "\n Cisco ASA Configuration Generator                            "
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +  "\n S - Start new Configuration                                  "
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
            case "S":
                this.startConfiguration();
                break;
            default:
                System.out.println(
                                     "\n***************************************"
                                   + "\n***** Invalid Selection Try Again *****"
                                   + "\n***************************************");
                break;
        }
        return false;
    }

    private void startConfiguration() {
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.display();
    }
}
