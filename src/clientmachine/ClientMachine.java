/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientmachine;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lachgar
 */
public class ClientMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        try {
            IDao<Salle> salle = (IDao<Salle>) Naming.lookup("rmi://localhost:1099/salle");
            IDao<Machine> mach = (IDao<Machine>) Naming.lookup("rmi://localhost:1099/mach");
            
            
             //salle.create(new Salle("CC1"));
            //salle.create(new Salle("CC2"));
         
            
              
           
            
            //mach.create(new Machine("RT45","HP",9000,salle.findById(1)));
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientMachine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientMachine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientMachine.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
   
}
