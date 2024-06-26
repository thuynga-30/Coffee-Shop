package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.table.DefaultTableModel;

import Controller.CoffeeManager;
import Controller.DrinkManager;
import Controller.FileTypeFilter;
import Controller.FoodManager;
import Database.Connect;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField price;
	private JLabel lblPrice;
	private JLabel lblType;
	private JLabel Images;
	private JComboBox type;
	String anh = "";
	private Home home;

	public Add(Home home) {
		setTitle("Add new product");
		// setExtendedState(JFrame.DISPOSE_ON_CLOSE);
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

		name = new JTextField();
		name.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		name.setBounds(131, 66, 237, 33);
		contentPane.add(name);
		name.setColumns(10);

		price = new JTextField();
		price.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		price.setColumns(10);
		price.setBounds(131, 143, 237, 33);
		contentPane.add(price);

		lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblPrice.setBounds(25, 146, 88, 27);
		contentPane.add(lblPrice);

		lblType = new JLabel("Type");
		lblType.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblType.setBounds(25, 221, 88, 27);
		contentPane.add(lblType);

		type = new JComboBox();
		type.setModel(new DefaultComboBoxModel(new String[] { "Food", "Drink", "Coffee" }));
		type.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		type.setBounds(131, 221, 126, 33);
		contentPane.add(type);

		JButton btnNewButton = new JButton("UpLoad");
		btnNewButton.setForeground(new Color(219, 160, 89));
		btnNewButton.setBackground(new Color(97, 64, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setDialogTitle("ADD IMAGE");
				jFileChooser.setMultiSelectionEnabled(false);
				jFileChooser.setFileFilter(new FileTypeFilter(".jpg", ".JPG"));
				jFileChooser.setFileFilter(new FileTypeFilter(".gif", ".GIF"));
				jFileChooser.setFileFilter(new FileTypeFilter(".png", ".PNG"));
				int result = jFileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File file = jFileChooser.getSelectedFile();
					ImageIcon icon = new ImageIcon(file.getAbsolutePath());
					// Kích thước tối đa của hình ảnh trên khung hình
					
					int maxWidth = 211;
					int maxHeight = 219;
					// Thích ứng kích thước của hình ảnh
					Image img = icon.getImage();
					Image newImg = img.getScaledInstance(maxWidth, maxHeight, Image.SCALE_SMOOTH);
					icon = new ImageIcon(newImg);
					Images.setIcon(icon);
					anh = file.getAbsolutePath().replace("/", "//");
				}

			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton.setBounds(735, 316, 88, 35);
		contentPane.add(btnNewButton);

		Images = new JLabel("");
		Images.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		Images.setBounds(674, 66, 212, 219);
		contentPane.add(Images);

		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(219, 160, 89));
		btnAdd.setBackground(new Color(97, 64, 22));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = Connect.getConnection();
					if (type.getSelectedItem() == "Food") {
						
						// Đọc dữ liệu từ tệp ảnh và chuyển đổi thành mảng byte
						File file = new File(anh);
						FileInputStream fis = new FileInputStream(file);
						byte[] imageData = new byte[(int) file.length()];
						fis.read(imageData);
						fis.close();

						FoodManager.addFood(name.getText(), price.getText(), imageData);

					} else if (type.getSelectedItem() == "Drink") {

					
						// Đọc dữ liệu từ tệp ảnh và chuyển đổi thành mảng byte
						File file = new File(anh);
						FileInputStream fis = new FileInputStream(file);
						byte[] imageData = new byte[(int) file.length()];
						fis.read(imageData);
						fis.close();
						DrinkManager.addDrink(name.getText(), price.getText(), imageData);
					} else if (type.getSelectedItem() == "Coffee") {
						File file = new File(anh);
						FileInputStream fis = new FileInputStream(file);
						byte[] imageData = new byte[(int) file.length()];
						fis.read(imageData);
						fis.close();
						CoffeeManager.addCoffee(name.getText(),price.getText(), imageData);
					}
					name.setText("");
					price.setText("");
					Images.setIcon(null);
					type.setSelectedItem("Food");
					home.refreshTable();
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error!");
				}
			}
			
		});
		
		btnAdd.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnAdd.setBounds(404, 416, 101, 53);
		contentPane.add(btnAdd);
       
	}

}
