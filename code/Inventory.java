/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ceid.db.tvondemandclientsideapp;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author dimet
 */
public class Inventory extends javax.swing.JFrame {

    

    /**
     * Creates new form Inventory
     */
    public Inventory(String email,String type) {
        this.email=email;
        initComponents();
        
        if(type.equals("film"))
        {
            jTabbedPane1.remove(jPanel2);
            jTabbedPane1.remove(jPanel3);
            fetchMovies();
        }
        else if(type.equals("series"))
        {
           jTabbedPane1.remove(jPanel1);
           jTable3.setVisible(false);
           fetchSeries();
        }
        else
        {
            fetchMovies();
            fetchSeries();
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inventory");
        setBackground(new java.awt.Color(153, 153, 153));
        setResizable(false);

        jTextArea1.setBackground(new java.awt.Color(197, 197, 197));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);
        jTextArea1.setEditable(false);

        jButton1.setText("Rent");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setText("<- Back");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTabbedPane1.setName("Movies"); // NOI18N

        jTable1.setFont(new java.awt.Font("Fira Sans Condensed", 2, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Release year", "Category", "Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Series", jPanel2);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title ", "Release Year", "Category", "Length"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Movies", jPanel1);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Season No", "Episode No", "Length", "Release Date"
            }
        ));
        jTable3.setToolTipText("");
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Episodes", jPanel3);

        jMenu1.setText("Search");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(444, 444, 444)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)))
                .addGap(59, 59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Movies");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //logout button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    //series
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        String fetchquery = "select title,description,group_concat(name),series_id\n" +
"from (select distinct series.title,series.description,language.name,series.series_id\n" +
"from series inner join season on series.series_id = season.series_id \n" +
"inner join episode on season.season_id=episode.season_id and season.series_id=episode.series_id\n" +
"inner join episode_inventory on episode_inventory.episode_id = episode.episode_id\n" +
"inner join series_subtitles on series_subtitles.series_id = series.series_id \n" +
"inner join language on language.language_id = series_subtitles.lang_id) s\n" +
"group by title,description,series_id";//correct
        
        ArrayList<String> descriptions = new ArrayList<>();
        ArrayList<String> languages = new ArrayList<>();
        ArrayList<Integer> seriesid = new ArrayList<>();
        try(Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tvondemandv2", "tester", "@Toor1234");)
        {
            Statement st = con.createStatement();
            Statement st2 = con.createStatement();
            ResultSet extraseries = st.executeQuery(fetchquery);
          
            
            while(extraseries.next())
            {               
               descriptions.add("Description:"+extraseries.getString(2));
               languages.add("Language(s):"+extraseries.getString(3));
               seriesid.add(extraseries.getInt(4));
            }
           
            
           
        
            
           extraseries.close();
           st.close();
           con.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        
        //helper
        setSeriesid(seriesid.get(jTable1.getSelectedRow()));
            
        jTextArea1.selectAll();
        jTextArea1.replaceSelection("");
        jTextArea1.setText(descriptions.get(jTable1.getSelectedRow())+"\n"+languages.get(jTable1.getSelectedRow()));
        
        //delete preexisting episodes on next click
        DefaultTableModel tMOdel = (DefaultTableModel) jTable3.getModel();
        tMOdel.setRowCount(0);
        
        
        fetchEpisodes(seriesid.get(jTable1.getSelectedRow()));   
        
        
        jTable1.setAutoCreateRowSorter(true);
        jTable3.setVisible(true);  
    }//GEN-LAST:event_jTable1MouseClicked

    
    
    //movies
    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
         String fetchquery = "select distinct title,description,group_concat(name),rating,special_features\n" +
"from film_inventory natural join film inner join film_subtitles on film.film_id=film_subtitles.film_id \n" +
"inner join language on film_subtitles.lang_id = language.language_id\n" +
"group by title,description,film_inventory_id,rating,special_features";
        
         ArrayList<String> mvdesc = new ArrayList<>();
         ArrayList<String> mvlanguages = new ArrayList<>();
         ArrayList<String> mvrating = new ArrayList<>();
         ArrayList<String> mvspecialFeatures = new ArrayList<>();
        try(Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tvondemandv2", "tester", "@Toor1234");)
        {
            
            Statement st = con.createStatement();
            ResultSet pinakasmovies = st.executeQuery(fetchquery);
            
            
            
            while(pinakasmovies.next())
            {
                mvdesc.add(pinakasmovies.getString(2));
                mvlanguages.add(pinakasmovies.getString(3));
                mvrating.add(pinakasmovies.getString(4));
                mvspecialFeatures.add(pinakasmovies.getString(5));  
            }
            
            
           pinakasmovies.close();
           st.close();
           con.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println(mvdesc.size());
        jTextArea1.selectAll();
        jTextArea1.replaceSelection("");
        jTextArea1.setText("Description:"+mvdesc.get(jTable2.getSelectedRow())+"\nOriginal_language:"+mvlanguages.get(jTable2.getSelectedRow())
        +"\nRating:"+mvrating.get(jTable2.getSelectedRow())+"\nSpecial Features:"+mvspecialFeatures.get(jTable2.getSelectedRow()));
        
        
    }//GEN-LAST:event_jTable2MouseClicked

    
    //episodes
    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        
         jTextArea1.selectAll();
         jTextArea1.replaceSelection("");
         jTextArea1.setText(getDescriptions().get(jTable3.getSelectedRow())+"\n"+getSpecialFeatures().get(jTable3.getSelectedRow()));
    }//GEN-LAST:event_jTable3MouseClicked

    
    //Rent button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(!jTable2.getSelectionModel().isSelectionEmpty())//movies
        {
           System.out.println("Here");
           int selrow = jTable2.getSelectedRow();
           
           
           
           String customeridquery = "select customer_id from customer where email like '"+email+"'";
           String filminvidquery = "select film_inventory_id from film_inventory "
                   + "inner join film on film_inventory.film_id = film.film_id where title like '"+jTable2.getValueAt(selrow, 0)+"'";
           
           try(Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tvondemandv2", "tester", "@Toor1234");)
        {
            PreparedStatement st = con.prepareStatement(customeridquery);
            PreparedStatement st2 = con.prepareStatement(filminvidquery); 
            
            ResultSet customeridr = st.executeQuery();
            ResultSet filminvidr =st2.executeQuery();
            
            customeridr.next();
            filminvidr.next();
            
            PreparedStatement st3 = con.prepareStatement("Insert into film_rental values(Default,CURRENT_TIMESTAMP(),"+filminvidr.getInt(1)+","+customeridr.getInt(1)+")");
            try{
                st3.executeUpdate();
            }
            catch(SQLIntegrityConstraintViolationException e)
            {
                JOptionPane.showMessageDialog(new JFrame(),"You can't rent the movie again today.");
            }
                    
            
           customeridr.close();
           filminvidr.close();
           st.close();
           st2.close();
           con.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
           
           
           System.out.println(jTable2.getValueAt(selrow, 0));
            
            
           jTable2.getSelectionModel().removeSelectionInterval(selrow, selrow);
        }
        
        else if(!jTable3.getSelectionModel().isSelectionEmpty())//an epilexei epeisodio seiras
        {
            System.out.println("Here2");
            
            int selrow = jTable3.getSelectedRow();
            
            
            
           String customeridquery = "select customer_id from customer where email like '"+email+"'";
           String episodeidquery = "select episode_id from episode where series_id ="+getSeriesid()+" and season_id ="+jTable3.getValueAt(selrow, 0)+" and no = "+jTable3.getValueAt(selrow, 1);
           System.out.println(episodeidquery);
           
           try(Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tvondemandv2", "tester", "@Toor1234");)
        {
            PreparedStatement st = con.prepareStatement(customeridquery);
            PreparedStatement st2 = con.prepareStatement(episodeidquery); 
           
            
            ResultSet customeridr = st.executeQuery();
            ResultSet episodeidr = st2.executeQuery();
            
            customeridr.next();
            episodeidr.next();
            
            PreparedStatement st3 = con.prepareStatement("select episode_inventory_id from episode_inventory where episode_id = "+episodeidr.getInt(1)); 
            ResultSet episodeinvid = st3.executeQuery();
            episodeinvid.next();
            
            PreparedStatement st4 = con.prepareStatement("Insert into episode_rental values(Default,CURRENT_TIMESTAMP(),"+episodeinvid.getInt(1)+","+customeridr.getInt(1)+")");
            try{
                st4.executeUpdate();
            }
            catch(SQLIntegrityConstraintViolationException e)
            {
                JOptionPane.showMessageDialog(new JFrame(),"You can't rent this episode again today.");
            }
            
            
           customeridr.close();
           episodeidr.close();
           st.close();
           st2.close();
           con.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
           
           
           System.out.println(jTable3.getValueAt(selrow, 0));
            
            
            
            
            
            jTable3.getSelectionModel().removeSelectionInterval(selrow, 0);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public void fetchMovies()
    {
        
        String fetchquery = "select distinct title,release_year,group_concat(name) as category,length from film_inventory natural join film natural join film_category natural join category\n" +
                            "group by title,film_inventory_id,release_year,length";
        
        try(Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tvondemandv2", "tester", "@Toor1234");)
        {
            Statement st = con.createStatement();
            ResultSet pinakasmovies = st.executeQuery(fetchquery);
                       
            while(pinakasmovies.next())
            {
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                model.addRow(new Object[]{pinakasmovies.getString(1), pinakasmovies.getString(2), pinakasmovies.getString(3),pinakasmovies.getInt(4)});
                
            }
                       
            
           pinakasmovies.close();
           st.close();
           con.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        jTable2.setAutoCreateRowSorter(true);
    }
    
    
    public void fetchSeries()
    {
         String fetchquery = "select title,start_year,group_concat(name),rating\n" +
"from(select distinct series.title,series.start_year,category.name,series.rating  \n" +
"from series inner join season on series.series_id=season.series_id\n" +
"inner join episode on season.series_id=episode.series_id and season.season_id=episode.season_id\n" +
"inner join episode_inventory on episode.episode_id=episode_inventory.episode_id\n" +
"inner join series_category on series.series_id=series_category.series_id\n" +
"inner join category on series_category.category_id=category.category_id)s\n" +
"group by  title,start_year,rating";
        
        
        try(Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tvondemandv2", "tester", "@Toor1234");)
        {
            Statement st = con.createStatement();
            ResultSet pinakasseries = st.executeQuery(fetchquery);
          
            
            while(pinakasseries.next())
            {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                
                model.addRow(new Object[]{pinakasseries.getString(1), pinakasseries.getString(2), pinakasseries.getString(3),pinakasseries.getString(4)});
            }
            
            
           pinakasseries.close();
           st.close();
           con.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        jTable1.setAutoCreateRowSorter(true);
    }

    
    public void fetchEpisodes(int row)
    {
        String fetchquery = "select season_id,no,length,release_date,description,special_features from episode natural join episode_inventory where series_id = "+row;
   
        
        ArrayList<String> descriptionss = new ArrayList<>();
        ArrayList<String> specialFeaturess = new ArrayList<>();
        try(Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tvondemandv2", "tester", "@Toor1234");)
        {
            Statement st = con.createStatement();
            Statement st2 = con.createStatement();
            ResultSet extraseries = st.executeQuery(fetchquery);
          
            
            while(extraseries.next())
            {               
               descriptionss.add("Description:"+extraseries.getString(5));
               specialFeaturess.add("Special Features:"+extraseries.getString(6));
               DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
               model.addRow(new Object[]{extraseries.getInt(1), extraseries.getInt(2), extraseries.getInt(3),extraseries.getString(4)});
            }
           
            setDescriptions(descriptionss);
            setSpecialFeatures(specialFeaturess);

        
            
           extraseries.close();
           st.close();
           con.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        
       // for(String s: specialFeatures)
       // System.out.println(s);
        
     jTable3.setAutoCreateRowSorter(true);
        
        
    }
    
    
    
    
    //getters and setters
    public int getSeriesid()
    {
        return selseries_id;
    }
    
    public ArrayList<String> getDescriptions()
    {
        return descriptions;
    }
    
     public ArrayList<String> getSpecialFeatures()
    {
        return specialFeatures;
    }
    
    public void setSeriesid(int s)
    {
        selseries_id = s;
    }
     
     
    public void setDescriptions(ArrayList<String> d)
    {
        descriptions = new ArrayList<>(d);
    }
    
     public void setSpecialFeatures(ArrayList<String> sp)
    {
        specialFeatures = new ArrayList<>(sp);
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
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventory("steliosid@gmail.com","both").setVisible(true);
            }
        });
    }
    
    private int selseries_id;
    private ArrayList<String> specialFeatures;
    private ArrayList<String> descriptions;
    private final String email;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}