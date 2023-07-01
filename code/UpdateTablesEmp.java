/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ceid.db.tvondemandclientsideapp;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author dimet
 */
public class UpdateTablesEmp extends javax.swing.JFrame {

    /**
     * Creates new form UpdateTablesEmp
     */
    public UpdateTablesEmp(String s) {
        initComponents();
        fetchData(s);
        selection = s;
        jTabbedPane1.setEnabledAt(1, false);
        jButton5.setVisible(false);
  
      //  System.out.println(selection);
    }
    
    public void fetchData(String s)
    {
         try(Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tvondemandv2", "tester", "@Toor1234");)
        {
          Statement st = con.createStatement();
          ResultSet data = st.executeQuery("select * from "+s.toLowerCase());
          Statement st2 = con.createStatement();
          DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
          switch (s) 
            {
            case "Actor":
               
                setTitle("Actor Updating Tab");
                
                model.addColumn("actor id");
                model.addColumn("first name");
                model.addColumn("last name");
                
                while(data.next())
                model.addRow(new Object[]{data.getInt(1),data.getString(2),data.getString(3)});
                
                st.close();
                data.close();
                con.close();
                
            break;
            
            case "Film":
                setTitle("Film Updating Tab");
                
                
                ResultSet originallang = st2.executeQuery("select name from film "
                        + "left join language on film.original_language_id = language.language_id");
                
               
                model.addColumn("film id");
                model.addColumn("title");
                model.addColumn("description");
                model.addColumn("release year");
                model.addColumn("Original Language");
                model.addColumn("length");
                model.addColumn("rating");
                model.addColumn("special features");
                
                while(data.next()&&originallang.next())
                model.addRow(new Object[]{data.getInt(1),data.getString(2),data.getString(3),data.getString(4),originallang.getString(1),data.getString(6)
                ,data.getString(7),data.getString(8)});
                
                st.close();
                data.close();
                con.close();
            break;
            
            case "Series":
                setTitle("Series Updating Tabe");
                ResultSet originallangser = st2.executeQuery("select name from series "
                        + "left join language on series.original_language_id = language.language_id");
                
               
                model.addColumn("series id");
                model.addColumn("title");
                model.addColumn("description");
                model.addColumn("start year");
                model.addColumn("Original Language");
                model.addColumn("Rating");
                
                while(data.next()&&originallangser.next())
                model.addRow(new Object[]{data.getInt(1),data.getString(2),data.getString(3),data.getString(4),originallangser.getString(1),data.getString(6)});
                
                st.close();
                data.close();
                con.close();
                    
                    
                    
            break;
            
            case "Season":
                    setTitle("Season Updating Tabe");
                    
                model.addColumn("series id");
                model.addColumn("season id");
                model.addColumn("title");
                model.addColumn("description");
                model.addColumn("release year");
                model.addColumn("number of episodes");
                model.addColumn("rating");
                
                while(data.next())
                model.addRow(new Object[]{data.getInt(1),data.getInt(2),data.getString(3),data.getString(4),data.getString(5),data.getString(6),data.getString(7)});
                
                st.close();
                data.close();
                con.close();
            break;
            
            case "Episode":
                    setTitle("Episodes Updating Tabe");
                    
                model.addColumn("episode id");
                model.addColumn("series id");
                model.addColumn("season id");
                model.addColumn("no");
                model.addColumn("description");
                model.addColumn("length");
                model.addColumn("release date");
                model.addColumn("special features");
                
                while(data.next())
                model.addRow(new Object[]{data.getInt(1),data.getInt(2),data.getInt(3),data.getString(4),data.getString(5),data.getString(6),data.getString(7),data.getString(8)});
                
                st.close();
                data.close();
                con.close();
                    
            break;
            
            case "Language":
                    setTitle("Languages Updating Tabe");
                model.addColumn("language id");
                model.addColumn("name");
           
                
                while(data.next())
                model.addRow(new Object[]{data.getInt(1),data.getString(2)});
                
                st.close();
                data.close();
                con.close();
            break;
            
            case "Category":
                    setTitle("Category Updating Tabe");
                model.addColumn("category id");
                model.addColumn("name");
           
                
                while(data.next())
                model.addRow(new Object[]{data.getInt(1),data.getString(2)});
                
                st.close();
                data.close();
                con.close();
            break;
            
            case "Film_Inventory":
                    setTitle("Film Inventory Updating Tabe");
               
                ResultSet title = st2.executeQuery("select title from film "
                        + "right join film_inventory on film.film_id = film_inventory.film_id");
                    
                    
                model.addColumn("film inventory id");
                model.addColumn("name");
           
                
                while(data.next()&&title.next())
                model.addRow(new Object[]{data.getInt(1),title.getString(1)});
                
                st.close();
                data.close();
                con.close();
            break;
            case "Episode_Inventory":
                    setTitle("Episode Inventory Updating Tab");
                    
                ResultSet titleser = st2.executeQuery("select *\n" +
                "from (select distinct CONCAT(series.title,\" \",episode.season_id,\" \",episode.no)\n" +
                "from series inner join season on series.series_id = season.series_id \n" +
                "inner join episode on season.season_id=episode.season_id and season.series_id=episode.series_id\n" +
                "inner join episode_inventory on episode_inventory.episode_id = episode.episode_id) s");
                    
                    
                model.addColumn("episode inventory id");
                model.addColumn("Series name/Season no/Episode no");
           
                
                while(data.next()&&titleser.next())
                model.addRow(new Object[]{data.getInt(1),titleser.getString(1)});
                
                st.close();
                data.close();
                con.close();
                    
            break;
            
            }
        }
         catch (SQLException e)
        {
            e.printStackTrace();
        }
         
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Data", jScrollPane1);

        jTextField1.setText("Enter your Data");

        jTextField2.setText("Enter your Data");

        jTextField3.setText("Enter your Data");

        jTextField4.setText("Enter your Data");

        jTextField5.setText("Enter your Data");

        jTextField6.setText("Enter your Data");

        jTextField7.setText("Enter your Data");

        jTextField8.setText("Enter your Data");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("INSERT NEW DATA");

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setForeground(new java.awt.Color(204, 204, 255));
        jButton5.setText("Cancel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setForeground(new java.awt.Color(204, 204, 255));
        jButton6.setText("Confirm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(20, 20, 20))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addGap(34, 34, 34))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton5))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Insertion", jPanel1);

        jButton1.setText("Insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");

        jButton3.setText("Update");

        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(164, 164, 164)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addGap(9, 9, 9)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setEnabledAt(1, true);
        jTabbedPane1.setEnabledAt(0, false);
        jTabbedPane1.setSelectedComponent(jPanel1);
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton5.setVisible(true);
       
        getSelectedPinaka( evt);
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane1.setEnabledAt(0, true);
        jTabbedPane1.setSelectedComponent(jScrollPane1);
        jButton5.setVisible(false);
        jButton1.setVisible(true);
        jButton2.setVisible(true);
        jButton3.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try(Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tvondemandv2", "tester", "@Toor1234");)
        {
            
           // Statement st = con.createStatement();
           // st.execute(getSelectedPinaka());
            
            System.out.println( getSelectedPinaka(evt));
        
           
          // st.close();
           con.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
       
    }//GEN-LAST:event_jButton6ActionPerformed

    
    
    public String getSelectedPinaka(java.awt.event.ActionEvent evt)
    {

        switch (selection) 
            {
            case "Actor":
 
            if(evt.getSource() == jButton1)   
            {
                System.out.println("Here");
                jTextField1.setText("First Name:");
                jTextField2.setText("Last Name:");
                jTextField3.setVisible(false);
                jTextField4.setVisible(false);
                jTextField5.setVisible(false);
                jTextField6.setVisible(false);
                jTextField7.setVisible(false);
                jTextField8.setVisible(false);
            }  
            return "Insert into actor values(Default,'"+jTextField1.getText()+"','"+jTextField2.getText()+"')";
            case "Film":
                if(evt.getSource() == jButton1)   
            {
                jTextField1.setText("Title");
                jTextField2.setText("description");
                jTextField3.setText("Release year");
                jTextField4.setText("");
                jTextField5.setText("Length");
                jTextField6.setText("Rating");
                jTextField7.setText("Special Features");
            }  
            return "Insert into film values(Default,'"+jTextField1.getText()+"','"+jTextField2.getText()+"')";
          
            
            case "Series":
                            
                    
            break;
            
            case "Season":
          
            break;
            
            case "Episode":
              
            break;
            
            case "Language":
                
            break;
            
            case "Category":
           
            break;
            
            case "Film_Inventory":
                
            break;
            case "Episode_Inventory":
                 
                    
            break;
  
    }
      return new String();
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
            java.util.logging.Logger.getLogger(UpdateTablesEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateTablesEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateTablesEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateTablesEmp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateTablesEmp("Actor").setVisible(true);
            }
        });
    }

    private int modul=1;
    private String selection;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
