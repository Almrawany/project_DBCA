
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
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
public class Faculty extends javax.swing.JFrame {

    MysqlDatabase Mysql = new MysqlDatabase();
    private javax.swing.JFrame prevWindow;
    private String userName;
    private People user;
    private EditUser editUser;
    private AddingProject addingproject;
    final ObservableList options = FXCollections.observableArrayList();
    private People_projects peopleProjects;
    private Projects projects;

    /**
     * Creates new form Faculty
     */
    public Faculty(String userName) throws Exception {
        this.userName = userName;
        initComponents();
        this.fillCombo();
    }

    private Faculty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        updatingInformation = new javax.swing.JButton();
        AddingProject = new javax.swing.JButton();
        DeletingProject = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        selectedProject = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        updatingInformation.setText("Update Information");
        updatingInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatingInformationActionPerformed(evt);
            }
        });

        AddingProject.setText("Add project");
        AddingProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddingProjectActionPerformed(evt);
            }
        });

        DeletingProject.setText("Delete project");
        DeletingProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletingProjectActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Person name", "Person type", "Status ", "Comment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setText("Selected Project : ");

        selectedProject.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        jButton1.setText("Accept request ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reject request");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updatingInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddingProject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(selectedProject, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DeletingProject, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectedProject, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeletingProject))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(updatingInformation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddingProject)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updatingInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatingInformationActionPerformed

        People userToEdit = new People(userName);
        try {
            userToEdit.fetch();
            this.editUser = new EditUser(userToEdit, this);
            this.editUser.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_updatingInformationActionPerformed

    private void AddingProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddingProjectActionPerformed
        try {
            this.addingproject = new AddingProject(this, userName);
            this.fillCombo();
        } catch (DLException ex) {
            Logger.getLogger(Faculty.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.addingproject.setVisible(true);
    }//GEN-LAST:event_AddingProjectActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try {
            addToTable(jComboBox1.getSelectedItem().toString());
            selectedProject.setText(jComboBox1.getSelectedItem().toString());
        } catch (Exception ex) {
            Logger.getLogger(Faculty.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void DeletingProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletingProjectActionPerformed

        projects = new Projects(this.jComboBox1.getSelectedItem().toString());
        peopleProjects = new People_projects();
        try {
            projects.fetch2();
            this.peopleProjects.delete(projects.getProjectID());
            this.projects.delete(projects.getProjectID());
            jComboBox1.removeAllItems();
            this.fillCombo();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }//GEN-LAST:event_DeletingProjectActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int userIndex = jTable1.getSelectedRow();
        if (userIndex != -1) {
            String projectName = selectedProject.getText();
            String personName =  (String) this.jTable1.getValueAt(userIndex, 0);
            try {
                System.out.println("personName " + personName);
                System.out.println("projectName " + projectName);
                projects = new Projects(projectName);
                user = new People(personName);
                projects.fetch2();
                System.out.println("usprojectser.getPeopleiID()" + projects.getProjectID()); 
                user.fetchByName(personName);
                System.out.println("user.getPeopleiID()" + user.getPeopleiID()); 
                People_projects peopleProjects = new People_projects(projects.getProjectID(), user.getPeopleiID());
                peopleProjects.setStatus("Accepted");
                peopleProjects.setProjectcomment(" ");
                peopleProjects.put(); 
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         int userIndex = jTable1.getSelectedRow();
        if (userIndex != -1) {
            String projectName = selectedProject.getText();
            String personName =  (String) this.jTable1.getValueAt(userIndex, 0);
            try {
                System.out.println("personName " + personName);
                System.out.println("projectName " + projectName);
                projects = new Projects(projectName);
                user = new People(personName);
                projects.fetch2();
                System.out.println("usprojectser.getPeopleiID()" + projects.getProjectID()); 
                user.fetchByName(personName);
                System.out.println("user.getPeopleiID()" + user.getPeopleiID()); 
                People_projects peopleProjects = new People_projects(projects.getProjectID(), user.getPeopleiID());
                peopleProjects.setStatus("Rejected");
                peopleProjects.setProjectcomment(" ");
                peopleProjects.put(); 
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Faculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Faculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Faculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Faculty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Faculty().setVisible(true);
            }
        });
    }

    private void addToTable(String projectName) throws Exception {
        String query = "select name, type ,status comment from people ,people_projects where id = PeopleID and ProjectID in (select ProjectID from projects where projectName ='" + projectName + "')";

        System.out.println(query);

        DefaultTableModel myTableModel = (DefaultTableModel) this.jTable1.getModel();
        this.jTable1.removeAll();
        myTableModel.setRowCount(0);
        ArrayList<String[]> table = Mysql.getData(query);
        Object[] tableContent = new Object[4];
        for (String[] row : table) {
            for (int i = 0; i < row.length; i++) {
                tableContent[i] = row[i];
            }
            myTableModel.addRow(tableContent);
        }

        this.jTable1.setModel(myTableModel);

    }

    private void fillCombo() throws DLException {
        //jComboBox1.removeAllItems();
        String query = "select projectName from projects where ProjectID in (select ProjectID from people_projects where PeopleID in (select id from people where username ='" + userName + "'));";
        ArrayList<String[]> table = Mysql.getData(query);
        jComboBox1.addItem("Choose a project");
        for (String[] row : table) {
            for (int i = 0; i < row.length; i++) {
                jComboBox1.addItem(row[i]);
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddingProject;
    private javax.swing.JButton DeletingProject;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel selectedProject;
    private javax.swing.JButton updatingInformation;
    // End of variables declaration//GEN-END:variables
}
