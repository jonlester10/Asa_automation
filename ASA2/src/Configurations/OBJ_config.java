/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configurations;

/**
 *
 * @author jblester
 */
public class OBJ_config  extends Configuration {
        private String menu;
        private String objconfig = "";
        
    public String objTypeMenu(){
        menu = 
               "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
            +  "\n Please Enter the name of the Object                          "
            +  "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";       
        return menu;
             
    }
    public String nameMenu(){
        menu = "";
        
        return menu;
    }
    
    
    public boolean objCreate(String name, String input) {
        
        
        this.objconfig += "\r\n object network" + name +
                "\r\n" + input +
                "\r\n exit";
                
        return true;
    }
            
}
