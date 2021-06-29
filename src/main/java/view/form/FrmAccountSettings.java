/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.form;

import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Mihailo
 */
public class FrmAccountSettings extends javax.swing.JDialog {

    /**
     * Creates new form FrmAccountSettings
     */
    public FrmAccountSettings(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        Border border = BorderFactory.createTitledBorder("Account information");
        jPanelAccountInfo.setBorder(border);
        Border border1 = BorderFactory.createTitledBorder("Deactivate account");
        jPanelDeactivateAccount.setBorder(border1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancel = new javax.swing.JButton();
        btnEnableChanges = new javax.swing.JButton();
        jPanelAccountInfo = new javax.swing.JPanel();
        txtOldPassword = new javax.swing.JPasswordField();
        lblUsername = new javax.swing.JLabel();
        lblOldPassword = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblNewPassword = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JPasswordField();
        btnUpdate = new javax.swing.JButton();
        jPanelDeactivateAccount = new javax.swing.JPanel();
        btnDeactivate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtDeactivationCode = new javax.swing.JTextField();
        btnSendDeactivationCode = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCancel.setText("Cancel");

        btnEnableChanges.setText("Enable changes");

        txtOldPassword.setEditable(false);

        lblUsername.setText("Username:");

        lblOldPassword.setText("Old password:");

        txtUsername.setEditable(false);

        lblNewPassword.setText("New password:");

        txtNewPassword.setEditable(false);

        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);

        javax.swing.GroupLayout jPanelAccountInfoLayout = new javax.swing.GroupLayout(jPanelAccountInfo);
        jPanelAccountInfo.setLayout(jPanelAccountInfoLayout);
        jPanelAccountInfoLayout.setHorizontalGroup(
            jPanelAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccountInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAccountInfoLayout.createSequentialGroup()
                        .addGroup(jPanelAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblOldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsername)
                            .addComponent(txtOldPassword)
                            .addComponent(txtNewPassword, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanelAccountInfoLayout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelAccountInfoLayout.setVerticalGroup(
            jPanelAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAccountInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanelAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOldPassword))
                .addGap(28, 28, 28)
                .addGroup(jPanelAccountInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNewPassword))
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDeactivate.setText("Deactivate");
        btnDeactivate.setEnabled(false);

        jLabel1.setText("Deactivation code:");

        txtDeactivationCode.setEditable(false);

        btnSendDeactivationCode.setText("Send deactivation code");
        btnSendDeactivationCode.setEnabled(false);

        javax.swing.GroupLayout jPanelDeactivateAccountLayout = new javax.swing.GroupLayout(jPanelDeactivateAccount);
        jPanelDeactivateAccount.setLayout(jPanelDeactivateAccountLayout);
        jPanelDeactivateAccountLayout.setHorizontalGroup(
            jPanelDeactivateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDeactivateAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDeactivateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnDeactivate))
                .addGap(18, 18, 18)
                .addGroup(jPanelDeactivateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSendDeactivationCode)
                    .addComponent(txtDeactivationCode, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDeactivateAccountLayout.setVerticalGroup(
            jPanelDeactivateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDeactivateAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDeactivateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDeactivationCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanelDeactivateAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeactivate)
                    .addComponent(btnSendDeactivationCode))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelDeactivateAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnEnableChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel))
                    .addComponent(jPanelAccountInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanelAccountInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jPanelDeactivateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnEnableChanges))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeactivate;
    private javax.swing.JButton btnEnableChanges;
    private javax.swing.JButton btnSendDeactivationCode;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelAccountInfo;
    private javax.swing.JPanel jPanelDeactivateAccount;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JLabel lblOldPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtDeactivationCode;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtOldPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnDeactivate() {
        return btnDeactivate;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public JPasswordField getTxtNewPassword() {
        return txtNewPassword;
    }

    public JPasswordField getTxtOldPassword() {
        return txtOldPassword;
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public JButton getBtnEnableChanges() {
        return btnEnableChanges;
    }

    public JTextField getTxtDeactivationCode() {
        return txtDeactivationCode;
    }

    public JButton getBtnSendDeactivationCode() {
        return btnSendDeactivationCode;
    }

    public void btnUpdateAddActionListener(ActionListener actionListener) {
        btnUpdate.addActionListener(actionListener);
    }
    
    public void btnCancelAddActionListener(ActionListener actionListener) {
        btnCancel.addActionListener(actionListener);
    }
    
    public void btnDeactivateAddActionListener(ActionListener actionListener) {
        btnDeactivate.addActionListener(actionListener);
    }
    
    public void btnEnableChangesAddActionListener(ActionListener actionListener) {
        btnEnableChanges.addActionListener(actionListener);
    }
    
    public void btnSendDeactivationCodeAddActionListener(ActionListener actionListener) {
        btnSendDeactivationCode.addActionListener(actionListener);
    }
}
