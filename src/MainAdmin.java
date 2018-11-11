
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mohammed_aljohani
 */
public class MainAdmin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    String usernameFromLog;
    private People allPeople;
    private String username;
    private AddUser AddUser;
    private EditUser editUser;
    private MysqlDatabase MyDB;
    private AvailableProjects AvailableProject ; 

    public MainAdmin() {
        initComponents();
    }

    public MainAdmin(String username) throws Exception {
        initComponents();
        this.usernameFromLog = username;
        this.PrepareConstructor();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        DeleteButton = new javax.swing.JButton();
        AddUserButton = new javax.swing.JButton();
        EditUser = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        searchText = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Person ID ", "Type", "User Name", "Password", "Name", "Tag line", "Title", "Interest Area", "Office", "Website", "Phone", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        DeleteButton.setText("Delete User ");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        AddUserButton.setText("Add User");
        AddUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserButtonActionPerformed(evt);
            }
        });

        EditUser.setText("Edit User ");
        EditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditUserActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("search by name ");

        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        jButton2.setText("Available Projects");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddUserButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DeleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EditUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Search, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchText)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DeleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddUserButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EditUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(Search)
                        .addGap(38, 38, 38)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PrepareConstructor() {
        this.allPeople = new People(this.username);
        try {
            this.addToTable(this.allPeople.ListingPeople());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int userIndex = jTable1.getSelectedRow();
        if (userIndex != -1) {
            String userName = (String) this.jTable1.getValueAt(userIndex, 2);
            int peopleID = (int) this.jTable1.getValueAt(userIndex, 0);
            People userToRemove = new People(peopleID);

            try {

                int dailgRsult = JOptionPane.showConfirmDialog(this, "Are you sure to remove: " + userName + " from the Database ", null, 1);
                switch (dailgRsult) {
                    case JOptionPane.YES_OPTION:
                        userToRemove.delete();
                        JOptionPane.showMessageDialog(this, userName + " Was Deleted Successfuly!");
                        DefaultTableModel myTableModel = (DefaultTableModel) this.jTable1.getModel();
                        myTableModel.removeRow(userIndex);
                        break;
                    case JOptionPane.NO_OPTION:
                        // if the Admin chose no, deletion will be terminated:
                        JOptionPane.showMessageDialog(this, userName + " Was Not Deleted!");
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        // if the Admin chose no, deletion will be cancelled:
                        JOptionPane.showMessageDialog(this, userName + " Deletion Cancelled!");
                        break;
                    default:
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void AddUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserButtonActionPerformed
        this.AddUser = new AddUser(this);
        // hiding the current window
        this.setVisible(false);
        // showing the CreateUser window
        this.AddUser.setVisible(true);
    }//GEN-LAST:event_AddUserButtonActionPerformed

    private void EditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditUserActionPerformed
        int userIndex = this.jTable1.getSelectedRow();
        if (userIndex != -1) {
            // Get the column that have the username of the selected row of the table:
            int id = (int) this.jTable1.getValueAt(userIndex, 0);
            // Creating a new object of type People that was taken from the Table:
            People userToEdit = new People(id);
            try {
                // fetching all the information of the selected user
                userToEdit.fetch2();
                // Create a new object of EditUser window and include in the
                // constructor the desired user to be editied
                this.editUser = new EditUser(userToEdit, this);
                // Showing the EditUser Window
                this.editUser.setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_EditUserActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        try {
            addToTable(this.allPeople.ListingPeople(this.searchText.getText()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_SearchActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AvailableProject = new AvailableProjects(this); 
        AvailableProject.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * This method is to fill up the table that is in the main window of the
     * Admin.
     *
     *
     * @param thePeople a list of all the users in the database.
     * @throws Exception
     */
    private void addToTable(ArrayList<People> thePeople) throws Exception {

        DefaultTableModel myTableModel = (DefaultTableModel) this.jTable1.getModel();
        // making sure that the Table is empty before adding anything and each time this
        // method is called:
        //this.jTable1.removeAll();
        // extra check to make sure that the table has rows:
        this.jTable1.removeAll();
        //  if (myTableModel.getRowCount() > 0) {
        // this will do the same thing to make the table empty before adding anything to it
        myTableModel.setRowCount(0);
        for (int i = 0; i < thePeople.size(); i++) {
            // System.out.println("thePeople username : " + thePeople.get(i).getUserName() + " the size of the people" +thePeople.size());
            // during each loop, fetching happens of the user:
            System.out.println("thePeople.get(i) : " + thePeople.get(i).getPeopleiID()); 
            People aUser = thePeople.get(i); // getting first user from the list
            aUser.fetch2();
            // there are 7 columns in the table, each column will
            // contain a specific information about the user:
            Object[] tableContent = new Object[12];
            // username in first cell of the row
            tableContent[0] = aUser.getPeopleiID();
            // user type in second cell of the row
            tableContent[1] = aUser.getType();
            // user first name in the third
            tableContent[2] = aUser.getUserName();
            // last name in the fifth
            tableContent[3] = aUser.getPassword();
            // email in the sixth
            tableContent[4] = aUser.getName();
            // phone in the 7th
            tableContent[5] = aUser.getTagline();
            // office location in the 8th
            tableContent[6] = aUser.gettitle();
            // adding the whole row the table
            tableContent[7] = aUser.getInterestArea();

            tableContent[8] = aUser.getOffice();

            tableContent[9] = aUser.getWebsite();

            tableContent[10] = aUser.getPhone();

            tableContent[11] = aUser.getEmail();

            myTableModel.addRow(tableContent);
            //}
        }
        // setting the model that have all the information to be the model of the tabel
        this.jTable1.setModel(myTableModel);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainAdmin().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddUserButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditUser;
    private javax.swing.JButton Search;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchText;
    // End of variables declaration//GEN-END:variables
}