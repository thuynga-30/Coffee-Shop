package Controller;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Database.Connect;
import View.Home;
import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;

public class PanelLoginAndSignup extends JLayeredPane {
	private JPanel signup; 
	private JPanel login;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JTextField textField_2;
	 Connection con = null ;
	 ResultSet rs = null;
	 Statement st = null;
	public PanelLoginAndSignup() {
		setLayout(new CardLayout(0, 0));
		
		login = new JPanel();
		login.setBackground(new Color(255, 255, 255));
		add(login, "name_54676048997200");
		login.setLayout(null);

		signup = new JPanel();
		signup.setBackground(new Color(255, 255, 255));
		add(signup, "name_54730580100100");
		signup.setLayout(null);
	
		initSignUp();
		initLogIn();
		login.setVisible(false);
		signup.setVisible(true);
	}
	private void initSignUp() {
		
		JLabel lblNewLabel = new JLabel("CREATE ACCOUNT");
		lblNewLabel.setBackground(new Color(97, 64, 22));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(86, 32, 275, 41);
		signup.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Full Name");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1.setBounds(30, 133, 87, 19);
		signup.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField.setBounds(154, 123, 263, 32);
		signup.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("PhoneNumber");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(30, 204, 114, 19);
		signup.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(154, 197, 263, 32);
		signup.add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Password");
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(30, 271, 87, 19);
		signup.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Re-Password");
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(30, 347, 114, 19);
		signup.add(lblNewLabel_1_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(154, 270, 263, 32);
		signup.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(154, 346, 263, 32);
		signup.add(passwordField_1);
		
		JButton btnNewButton = new JButton("CREATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name, phone, pass,repass;
				int rowsAffected = 0;

				try {
					con= Connect.getConnection();
					st = con.createStatement();

					if ("".equals(textField_1.getText()) || textField_1.getText().length() != 10) {
						JOptionPane.showMessageDialog(new JFrame(), "Phone Number is required", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if ("".equals(passwordField.getText())) {
						JOptionPane.showMessageDialog(new JFrame(), "Password is required", "Error",
								JOptionPane.ERROR_MESSAGE);
					}else if ("".equals(new String(passwordField_1.getPassword())) || 
					        !new String(passwordField_1.getPassword()).equals(new String(passwordField.getPassword()))) {
							JOptionPane.showMessageDialog(new JFrame(), "re-enter password", "Error",
									JOptionPane.ERROR_MESSAGE);
						
					} else if ("".equals(textField.getText())) {
						JOptionPane.showMessageDialog(new JFrame(), "FullName is required", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						name = textField.getText();
						phone = textField_1.getText();
						pass = passwordField.getText();
						repass  = passwordField_1.getText();
						try {
							String checkQuery = "SELECT * FROM public.\"Staff\" WHERE \"PhoneNumber\" = '" + phone + "'";
							ResultSet rs = st.executeQuery(checkQuery);
							while (rs.next()) {
								
								JOptionPane.showMessageDialog(new JFrame(), "Phone Number already exists", "Error",
										JOptionPane.ERROR_MESSAGE);
							}
							 if (rs != null) rs.close();
						} catch (Exception e2) {
							// TODO: handle exception
						}
						String query = "INSERT INTO public.\"Staff\"(\"FullName\",\"PhoneNumber\", \"Password\",\"Re-password\") VALUES ('"
								+ name + "','" + phone + "','" + pass + "','"+repass+"');";
						rowsAffected = st.executeUpdate(query);
						if (rowsAffected > 0) {
							JOptionPane.showMessageDialog(new JFrame(), "User registered successfully", "Success",
									JOptionPane.INFORMATION_MESSAGE);
							
							
						} else {
							JOptionPane.showMessageDialog(new JFrame(), "Failed to register user", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
						textField.setText("");
						textField_1.setText("");
						passwordField.setText("");
						passwordField_1.setText("");
					}

				} catch (Exception e1) {
					e1.printStackTrace();

				} finally {
					try {
						
						if (st != null)
							st.close();
						if (con != null)
							con.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBackground(new Color(214, 160, 89));
		btnNewButton.setForeground(new Color(97, 64, 22));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton.setBounds(165, 449, 114, 41);
		signup.add(btnNewButton);
		}
	private void initLogIn() {
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(152, 249, 275, 32);
		login.add(passwordField_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Password");
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(28, 246, 87, 19);
		login.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(152, 176, 275, 32);
		login.add(textField_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("PhoneNumber");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(28, 179, 114, 19);
		login.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("LOG IN");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBackground(new Color(97, 64, 22));
		lblNewLabel.setBounds(172, 66, 124, 41);
		login.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_2.getText().isEmpty() || new String(passwordField_2.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both username and password.");
                    return;
                } 
                PreparedStatement ps = null;
                try {
                    con = Connect.getConnection();
                    String sql = "SELECT * FROM \"Staff\" WHERE \"PhoneNumber\" = ? AND \"Password\" = ?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, textField_2.getText());
                    ps.setString(2, new String(passwordField_2.getPassword()));
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        Home sw = new Home();
                        sw.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        sw.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect username or password!");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                } finally {
                    try {
                        if (rs != null) rs.close();
                        if (ps != null) ps.close();
                        if (con != null) con.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
			}
		});
		btnNewButton.setForeground(new Color(97, 64, 22));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(214, 160, 89));
		btnNewButton.setBounds(174, 350, 114, 41);
		login.add(btnNewButton);
	}
	public void showSignUp(boolean show) {
		if (show) {
			signup.setVisible(true);
			login.setVisible(false);
		}else {
			signup.setVisible(false);	
			login.setVisible(true);
		}
	}
}

