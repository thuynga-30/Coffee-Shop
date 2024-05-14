package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;

public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblPrice;
	private JLabel lblType;
	private JLabel Images;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 160, 89));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(25, 69, 88, 27);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		textField.setBounds(131, 66, 237, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(131, 143, 237, 33);
		contentPane.add(textField_1);
		
		lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblPrice.setBounds(25, 146, 88, 27);
		contentPane.add(lblPrice);
		
		lblType = new JLabel("Type");
		lblType.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblType.setBounds(25, 221, 88, 27);
		contentPane.add(lblType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Food", "Drink", "Coffee"}));
		comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		comboBox.setBounds(131, 221, 88, 33);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("UpLoad");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
			        
			    
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton.setBounds(735, 316, 88, 27);
		contentPane.add(btnNewButton);
		
		Images = new JLabel("");
		Images.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		Images.setBounds(674, 66, 212, 219);
		contentPane.add(Images);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnSave.setBounds(404, 416, 88, 35);
		contentPane.add(btnSave);
	}
	
}
