/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Common.Utils;
import Logic.UsersLogic;
import Models.Users;
import java.security.MessageDigest;
import JpaControllers.UsersJpaController;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Resource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

/**
 *
 * @author nico
 */
public class UsersController {
    
    public UsersController(){
        
    }
    
    public Users newUser(String email, String password, String nombre, String ape){
        UsersLogic ul = new UsersLogic(password);
        try{
            if(ul.checkPasswordWithPwned()){
                String passSHA1 = Utils.applySHA1(password);
                
                Users usuario = new Users(email, passSHA1,nombre,ape);
                //this.getEntityManager();
                
                UsersJpaController uc = new UsersJpaController();
                try
                {
                    uc.create(usuario);
                    return usuario;
                }
                catch(Exception e){
                    return null;
                }
                
            }
            return null;
        }
        catch(Exception e){
            return null;
        }
    }
    
    public Users login(String email, String password){
        UsersJpaController uc = new UsersJpaController();
        Users usuarioEncontrado = uc.findUsers(email);
        if(usuarioEncontrado!=null){
            try{
                String passSHA1 = Utils.applySHA1(password);
               if(passSHA1.equals(usuarioEncontrado.getPassword())){
                   return usuarioEncontrado;
               }
            }
            catch(Exception e){
                return null;
            }
            
        }
        return null;
    }
    
    
}
