
import Common.Utils;
import Controllers.UsersController;
import Logic.UsersLogic;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nico
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        // TODO code application logic here
        //UsersLogic ul = new UsersLogic("1234");
        //Se convierte la contrasena a UTF8
        UsersController uc = new UsersController();
        uc.newUser("nicolas.handalian@gmail.com", "estaeslaprimercontrasena", "Nicolas", "Handalian");
        
    }
    
}
