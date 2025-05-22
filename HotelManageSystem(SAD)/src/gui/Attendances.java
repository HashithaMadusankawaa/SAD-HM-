/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Mysql2;

/**
 *
 * @author ABC
 */
public class Attendances extends javax.swing.JDialog {

    private HashMap<String, String> monthMap = new HashMap<>();

    public Attendances(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        LoadMonths();
        LoadAttendenceList();
    }

    private void LoadMonths() {
        try {

            ResultSet resultSet = Mysql2.msearch("SELECT * FROM `month`");
            Vector<String> vector = new Vector<>();
            vector.add("Select ");

            while (resultSet.next()) {
                vector.add(resultSet.getString("month"));
                monthMap.put(resultSet.getString("month"), resultSet.getString("id"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void LoadAttendeType() {
        try {

            ResultSet resultSet = Mysql2.msearch("SELECT * FROM `month`");
            Vector<String> vector = new Vector<>();
            vector.add("Select ");

            while (resultSet.next()) {
                vector.add(resultSet.getString("month"));
                monthMap.put(resultSet.getString("month"), resultSet.getString("id"));
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadAttendenceList() {
        try {

            ResultSet resultSet = Mysql2.msearch("SELECT * FROM attendance INNER JOIN employee ON attendance.employee_id = employee.id WHERE attendance.date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH);");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();

                vector.add(resultSet.getString("employee.id"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("date"));
                vector.add(resultSet.getString("time"));
                vector.add(resultSet.getString("status"));

                model.addRow(vector);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadAttendence01List() {
        try {

            ResultSet resultSet = Mysql2.msearch("SELECT * FROM attendance INNER JOIN employee ON attendance.employee_id = employee.id WHERE MONTH(attendance.date) = 1 AND attendance.date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH);");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();

                vector.add(resultSet.getString("employee.id"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("date"));
                vector.add(resultSet.getString("time"));
                vector.add(resultSet.getString("status"));

                model.addRow(vector);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadAttendence02List() {
        try {

            ResultSet resultSet = Mysql2.msearch("SELECT * FROM attendance INNER JOIN employee ON attendance.employee_id = employee.id WHERE MONTH(attendance.date) = 2 AND attendance.date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH);");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();

                vector.add(resultSet.getString("employee.id"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("date"));
                vector.add(resultSet.getString("time"));
                vector.add(resultSet.getString("status"));

                model.addRow(vector);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadAttendence03List() {
        try {

            ResultSet resultSet = Mysql2.msearch("SELECT * FROM attendance INNER JOIN employee ON attendance.employee_id = employee.id "
                    + "WHERE MONTH(attendance.date) = 3 AND attendance.date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH);");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();

                vector.add(resultSet.getString("employee.id"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("date"));
                vector.add(resultSet.getString("time"));
                vector.add(resultSet.getString("status"));

                model.addRow(vector);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadAttendence04List() {
        try {

            ResultSet resultSet = Mysql2.msearch("SELECT * FROM attendance INNER JOIN employee ON attendance.employee_id = employee.id "
                    + "WHERE MONTH(attendance.date) = 4 AND attendance.date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH);");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();

                vector.add(resultSet.getString("employee.id"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("date"));
                vector.add(resultSet.getString("time"));
                vector.add(resultSet.getString("status"));

                model.addRow(vector);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadAttendence05List() {
        try {

            ResultSet resultSet = Mysql2.msearch("SELECT * FROM attendance INNER JOIN employee ON attendance.employee_id = employee.id "
                    + "WHERE MONTH(attendance.date) = 5 AND attendance.date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH);");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();

                vector.add(resultSet.getString("employee.id"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("date"));
                vector.add(resultSet.getString("time"));
                vector.add(resultSet.getString("status"));

                model.addRow(vector);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadAttendence06List() {
        try {

            ResultSet resultSet = Mysql2.msearch("SELECT * FROM attendance INNER JOIN employee ON attendance.employee_id = employee.id "
                    + "WHERE MONTH(attendance.date) = 6 AND attendance.date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH);");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();

                vector.add(resultSet.getString("employee.id"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("date"));
                vector.add(resultSet.getString("time"));
                vector.add(resultSet.getString("status"));

                model.addRow(vector);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadAttendence07List() {
        try {

            ResultSet resultSet = Mysql2.msearch("SELECT * FROM attendance INNER JOIN employee ON attendance.employee_id = employee.id "
                    + "WHERE MONTH(attendance.date) = 7 AND attendance.date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH);");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();

                vector.add(resultSet.getString("employee.id"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("date"));
                vector.add(resultSet.getString("time"));
                vector.add(resultSet.getString("status"));

                model.addRow(vector);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadAttendence08List() {
        try {

            ResultSet resultSet = Mysql2.msearch("SELECT * FROM attendance INNER JOIN employee ON attendance.employee_id = employee.id "
                    + "WHERE MONTH(attendance.date) = 8 AND attendance.date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH);");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();

                vector.add(resultSet.getString("employee.id"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("date"));
                vector.add(resultSet.getString("time"));
                vector.add(resultSet.getString("status"));

                model.addRow(vector);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadAttendence09List() {
        try {

            ResultSet resultSet = Mysql2.msearch("SELECT * FROM attendance INNER JOIN employee ON attendance.employee_id = employee.id "
                    + "WHERE MONTH(attendance.date) = 9 AND attendance.date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH);");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();

                vector.add(resultSet.getString("employee.id"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("date"));
                vector.add(resultSet.getString("time"));
                vector.add(resultSet.getString("status"));

                model.addRow(vector);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadAttendence10List() {
        try {

            ResultSet resultSet = Mysql2.msearch("SELECT * FROM attendance INNER JOIN employee ON attendance.employee_id = employee.id "
                    + "WHERE MONTH(attendance.date) = 10 AND attendance.date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH);");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();

                vector.add(resultSet.getString("employee.id"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("date"));
                vector.add(resultSet.getString("time"));
                vector.add(resultSet.getString("status"));

                model.addRow(vector);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadAttendence11List() {
        try {

            ResultSet resultSet = Mysql2.msearch("SELECT * FROM attendance INNER JOIN employee ON attendance.employee_id = employee.id "
                    + "WHERE MONTH(attendance.date) = 11 AND attendance.date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH);");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();

                vector.add(resultSet.getString("employee.id"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("date"));
                vector.add(resultSet.getString("time"));
                vector.add(resultSet.getString("status"));

                model.addRow(vector);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadAttendence12List() {
        try {

            ResultSet resultSet = Mysql2.msearch("SELECT * FROM attendance INNER JOIN employee ON attendance.employee_id = employee.id "
                    + "WHERE MONTH(attendance.date) = 12 AND attendance.date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH);");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();

                vector.add(resultSet.getString("employee.id"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("date"));
                vector.add(resultSet.getString("time"));
                vector.add(resultSet.getString("status"));

                model.addRow(vector);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelRound1 = new test.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        panelRound2 = new test.PanelRound();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Attendance");

        jPanel1.setBackground(new java.awt.Color(13, 208, 157));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Attendance");

        panelRound1.setBackground(new java.awt.Color(32, 48, 47));
        panelRound1.setRoundBottomLeft(15);
        panelRound1.setRoundBottomRight(15);
        panelRound1.setRoundTopLeft(15);
        panelRound1.setRoundTopRight(15);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Employee", "Date", "Time", "Attendance Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1229, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("Poppins Medium", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Mark Attendance");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        panelRound2.setBackground(new java.awt.Color(32, 48, 47));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Month : ");

        jLabel3.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Attendance Type :");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Half Day Leave", "Full Day Leave", "Days Leave", "Full Day Present" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Mark_Atttendance atttendance = new Mark_Atttendance(null, true);
        atttendance.setVisible(true);
        LoadAttendenceList();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        String month = String.valueOf(jComboBox1.getSelectedItem());
        if (month.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select Month.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                if (month.equals("January")) {
                    LoadAttendence01List();
                } else if (month.equals("February")) {
                    LoadAttendence02List();
                } else if (month.equals("March")) {
                    LoadAttendence03List();
                } else if (month.equals("April")) {
                    LoadAttendence04List();
                } else if (month.equals("May")) {
                    LoadAttendence05List();
                } else if (month.equals("June")) {
                    LoadAttendence06List();
                } else if (month.equals("July")) {
                    LoadAttendence07List();
                } else if (month.equals("August")) {
                    LoadAttendence08List();
                } else if (month.equals("September")) {
                    LoadAttendence09List();
                } else if (month.equals("October")) {
                    LoadAttendence10List();
                } else if (month.equals("November")) {
                    LoadAttendence11List();
                } else if (month.equals("December")) {
                    LoadAttendence12List();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
       String type = String.valueOf(jComboBox2.getSelectedItem());
       
       try {

            ResultSet resultSet = Mysql2.msearch("SELECT * FROM attendance INNER JOIN employee ON attendance.employee_id = employee.id WHERE attendance.date >= DATE_SUB(CURDATE(), INTERVAL 12 MONTH) AND attendance.`status`='"+type+"';");

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {
                Vector<String> vector = new Vector<>();

                vector.add(resultSet.getString("employee.id"));
                vector.add(resultSet.getString("fname"));
                vector.add(resultSet.getString("date"));
                vector.add(resultSet.getString("time"));
                vector.add(resultSet.getString("status"));

                model.addRow(vector);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
       
       
    }//GEN-LAST:event_jComboBox2ItemStateChanged

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
            java.util.logging.Logger.getLogger(Attendances.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Attendances.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Attendances.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Attendances.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Attendances dialog = new Attendances(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private test.PanelRound panelRound1;
    private test.PanelRound panelRound2;
    // End of variables declaration//GEN-END:variables
}
