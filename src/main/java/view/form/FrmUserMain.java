/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.form;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Mihailo
 */
public class FrmUserMain extends javax.swing.JFrame {

    /**
     * Creates new form FrmUserMain
     */
    public FrmUserMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCurrentUser = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMovies = new javax.swing.JTable();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnShowAll = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuMyMovies = new javax.swing.JMenu();
        jmiViewMyMovies = new javax.swing.JMenuItem();
        jMenuReviews = new javax.swing.JMenu();
        jmiReviews = new javax.swing.JMenuItem();
        jMenuAccount = new javax.swing.JMenu();
        jmiSettings = new javax.swing.JMenuItem();
        jmiLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblMovies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblMovies);

        lblSearch.setText("Search:");

        btnSave.setText("Save");
        btnSave.setEnabled(false);

        btnSearch.setText("Search");

        btnShowAll.setText("Show all");

        jMenuMyMovies.setText("My movies");

        jmiViewMyMovies.setText("View");
        jMenuMyMovies.add(jmiViewMyMovies);

        jMenuBar1.add(jMenuMyMovies);

        jMenuReviews.setText("My reviews");

        jmiReviews.setText("View");
        jMenuReviews.add(jmiReviews);

        jMenuBar1.add(jMenuReviews);

        jMenuAccount.setText("Account");

        jmiSettings.setText("Settings");
        jMenuAccount.add(jmiSettings);

        jmiLogout.setText("Logout");
        jMenuAccount.add(jmiLogout);

        jMenuBar1.add(jMenuAccount);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCurrentUser)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch)
                                .addGap(18, 18, 18)
                                .addComponent(btnShowAll)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblCurrentUser)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(btnShowAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnShowAll;
    private javax.swing.JMenu jMenuAccount;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuMyMovies;
    private javax.swing.JMenu jMenuReviews;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jmiLogout;
    private javax.swing.JMenuItem jmiReviews;
    private javax.swing.JMenuItem jmiSettings;
    private javax.swing.JMenuItem jmiViewMyMovies;
    private javax.swing.JLabel lblCurrentUser;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTable tblMovies;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    public JLabel getLblCurrentUser() {
        return lblCurrentUser;
    }
    
    public JTextField getTxtSearch() {
        return txtSearch;
    }
    
    public JTable getTblMovies() {
        return tblMovies;
    }

    public JButton getBtnSave() {
        return btnSave;
    }
    
    public void jmiViewMyMoviesActionListener(ActionListener actionListener) {
        jmiViewMyMovies.addActionListener(actionListener);
    }
    
    public void jmiAccountSettings(ActionListener actionListener) {
        jmiSettings.addActionListener(actionListener);
    }
    
    public void jmiReviews(ActionListener actionListener) {
        jmiReviews.addActionListener(actionListener);
    }
    
    public void jmiLogoutActionListener(ActionListener actionListener) {
        jmiLogout.addActionListener(actionListener);
    }
    
    public void btnSaveActionListener(ActionListener actionListener) {
        btnSave.addActionListener(actionListener);
    }
    
    public void btnSearchActionListener(ActionListener actionListener) {
        btnSearch.addActionListener(actionListener);
    }
    
    public void tblMoviesAddListSelectionListener(ListSelectionListener listSelectionListener) {
        tblMovies.getSelectionModel().addListSelectionListener(listSelectionListener);
    }
    
    public void btnShowAllActionListener(ActionListener actionListener) {
        btnShowAll.addActionListener(actionListener);
    }
}
