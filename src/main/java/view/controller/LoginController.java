/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller;
import comm.Operation;
import comm.Request;
import communication.Communication;
import domain.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import view.coordinator.MainCoordinator;
import view.form.FrmLogin;

/**
 *
 * @author Mihailo
 */
public class LoginController {
    private final FrmLogin frmLogin;

    public LoginController(FrmLogin frmLogin) {
        this.frmLogin = frmLogin;
        addActionListener();
        addKeyListener();
    }

    public void openForm() {
        frmLogin.setVisible(true);
        frmLogin.setLocationRelativeTo(null);
        frmLogin.setTitle("Login form");
    }
    
    private void addKeyListener() {
        frmLogin.loginAddKeyPressedListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    login();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
    }

    private void addActionListener() {
        frmLogin.loginAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                login();
            }
        });
        frmLogin.registerAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainCoordinator.getInstance().openRegisterForm();
            }
        });
    }
    
    private void resetErrorFields() {
        frmLogin.getLblUsernameError().setText("");
        frmLogin.getLblPasswordError().setText("");
    }

    private void validateForm(String username, String password) throws Exception {
        String errorMessage = "";

        if (username.isEmpty()) {
            frmLogin.getLblUsernameError().setText("Username can not be empty!");
            errorMessage += "Username can not be empty!\n";
        }
        if (password.isEmpty()) {
            frmLogin.getLblPasswordError().setText("Password can not be empty!");
            errorMessage += "Password can not be empty!\n";
        }
        if (!errorMessage.isEmpty()) {
            throw new Exception(errorMessage);
        }
    }
    
    private void login() {
        resetErrorFields();
        try {
            String username = frmLogin.getTxtUsername().getText().trim();
            String password = String.copyValueOf(frmLogin.getTxtPassword().getPassword());

            validateForm(username, password);
            
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            
            Request request = new Request(Operation.LOGIN, user);
            Communication.getInstance().sendUserRequest(request);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frmLogin, e.getMessage(), "Login error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public FrmLogin getFrmLogin() {
        return frmLogin;
    }
    
    
}
