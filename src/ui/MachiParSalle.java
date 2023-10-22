/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lachgar
 */
public class MachiParSalle extends javax.swing.JInternalFrame {

  
    IDao<Salle> daos = null;
    IDao <Machine> dao = null;
    DefaultTableModel model = null;
    private int id;
     
    
    private void LoadSalle()
    {
       
        try {
            for(Salle s : daos.findAll())
            {
                listesalle.addItem(s);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MachineForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates new form MachineForm
     */
     
     private void LoadParSalle(Salle s)
     {
           
         
          model.setRowCount(0);
        try {
            for(Machine m : dao.findAll())
            {
                if(m.getSl().getId() == s.getId())                
                {
                     model.addRow(new Object [] {
                       m.getId(),
                         m.getRef(),
                         m.getMarque(),
                         m.getPrix()
                   
            });
                }
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MachiParSalle.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
           
     

    public MachiParSalle() {
        initComponents();
        
       
        
        model = (DefaultTableModel) listMachines.getModel();
        try {
        
            daos = (IDao<Salle>) Naming.lookup("rmi://localhost:1099/salle");
              dao = (IDao<Machine>) Naming.lookup("rmi://localhost:1099/mach");
            
        } catch (NotBoundException ex) {
            Logger.getLogger(MachiParSalle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MachiParSalle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(MachiParSalle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        model = (DefaultTableModel) listMachines.getModel();
        LoadSalle();
      
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMachines = new javax.swing.JTable();
        listesalle = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(225, 216, 216));
        setClosable(true);
        setForeground(new java.awt.Color(0, 153, 153));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Machine Par Salles");

        listMachines.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Référence", "Marque", "Prix"
            }
        ));
        listMachines.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMachinesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listMachinesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(listMachines);

        listesalle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listesalleItemStateChanged(evt);
            }
        });
        listesalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listesalleActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel1.setText("Salle: ");

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jTextField1.setText("         Affichage des Machines Par Salle");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(listesalle, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listesalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Machines Par Salle");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listMachinesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMachinesMouseClicked
       
    }//GEN-LAST:event_listMachinesMouseClicked

    private void listMachinesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMachinesMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_listMachinesMousePressed

    private void listesalleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listesalleItemStateChanged
        
    }//GEN-LAST:event_listesalleItemStateChanged

    private void listesalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listesalleActionPerformed
           Salle s = (Salle) listesalle.getSelectedItem();
         
        try {
            LoadParSalle(daos.findById(s.getId()));
        } catch (RemoteException ex) {
            Logger.getLogger(MachiParSalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listesalleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable listMachines;
    private javax.swing.JComboBox listesalle;
    // End of variables declaration//GEN-END:variables
}
