/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASA_Automation;

import View.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jon
 */
public class ASAautomation {
    
    //Public to allow other classes to edit.
   public static String config = "conf t";
   
   private static PrintWriter outFile = null;
   private static BufferedReader inFile = null;
   private static PrintWriter logFile = null;
    
    public static void main(String[] args) {
        
             try {
         ASAautomation.inFile = new BufferedReader(new InputStreamReader(System.in));
         
         ASAautomation.outFile = new PrintWriter(System.out, true);
      
         String filePath = "log.txt";
         ASAautomation.logFile = new PrintWriter(filePath);
         
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.display();
        return;
                
     } catch (Throwable e) {
         
         System.out.println("Exception: " + e.toString() +
                            "\nCause: " + e.getCause() +
                            "\nMessage: " + e.getMessage());
         
         e.printStackTrace();;
     } finally {
         try {
             if (ASAautomation.inFile != null){
                 ASAautomation.inFile.close();
             }
            if (ASAautomation.outFile != null) {
                ASAautomation.outFile.close();
            }
            if (ASAautomation.logFile != null) {
                ASAautomation.logFile.close();
            }
         } catch (IOException ex) {
             Logger.getLogger(ASAautomation.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    }

    public static String getConfig() {
        return config;
    }

    public static void setConfig(String config) {
        ASAautomation.config = config;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        ASAautomation.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        ASAautomation.inFile = inFile;
    }
    
    public void appendConfig(String conf) {
        this.config += conf;
    }
    
    
    
}
