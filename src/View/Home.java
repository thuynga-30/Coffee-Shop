package View;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme;
import com.k33ptoo.components.KButton;
import com.k33ptoo.components.KGradientPanel;

import Controller.*;
import Database.*;
import Model.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.util.*;
import javax.swing.Timer;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	private JLabel jTxttime;
	private JTable Drinktable;
	private JTable Coffeetable;
	private JPanel Home;
	private JPanel Product;
	private JPanel Food;
	private JPanel Drink;
	private JPanel Statistic;
	private JPanel Coffee;
	private JTable Foodtable;
	private JTextArea textArea;
	private JScrollPane jScrollPane1;
	private JTextField recieve;
	private JButton totalBtn;
	private DefaultTableModel drinkModel;
	private DefaultTableModel foodModel;
	private DefaultTableModel coffeeModel;
	private Timer refreshTimer;
	private JTable purchaseTable;
	 private Timer timer;
	private int total = 0;
	private int x = 0;
	
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		FlatMacLightLaf.setup();

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					Home frame = new Home();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void clear() {
		total = 0;
		x = 0;
		totalBtn.setEnabled(true);
		recieve.setText("0.000");
		textArea.setText("");
		}

	public void setTime() {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd/MM/yyyy HH:mm:ss");
		String timeString = dateFormat.format(date);
		jTxttime.setText(timeString);
	}

	public void timeStart() {
		Timer timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTime();
			}
		});
		timer.start();
	}

	public Home() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1552, 819);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel menu = new JPanel();
		menu.setBackground(new Color(219, 160, 89));
		menu.setBounds(0, 0, 290, 800);
		contentPane.add(menu);
		menu.setLayout(null);

		JButton home = new JButton("HOME");
		home.setForeground(new Color(219, 160, 89));
		home.setBackground(new Color(97, 64, 22));
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.setVisible(true);
				Product.setVisible(false);
				Statistic.setVisible(false);
			}
		});
		home.setFont(new Font("Segoe UI", Font.BOLD, 14));
		home.setBounds(84, 325, 113, 68);
		menu.add(home);

		JButton btnNewButton_1 = new JButton("PRODUCT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.setVisible(false);
				Product.setVisible(true);
				Statistic.setVisible(false);

			}
		});
		btnNewButton_1.setForeground(new Color(219, 160, 89));
		btnNewButton_1.setBackground(new Color(97, 64, 22));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_1.setBounds(84, 438, 113, 68);
		menu.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("STATISTIC");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.setVisible(false);
				Product.setVisible(false);
				Statistic.setVisible(true);
				showData();
			}
		});
		btnNewButton_2.setForeground(new Color(219, 160, 89));
		btnNewButton_2.setBackground(new Color(97, 64, 22));
		btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_2.setBounds(84, 546, 113, 68);
		menu.add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/Image/ffff.png")));
		lblNewLabel.setBounds(10, 32, 239, 178);
		menu.add(lblNewLabel);

		JButton btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAndSingup logIn = new LoginAndSingup();
				logIn.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1.setIcon(new ImageIcon(Home.class.getResource("/Image/icons8-exit-50.png")));
		btnNewButton_2_1.setForeground(new Color(219, 160, 89));
		btnNewButton_2_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_2_1.setBackground(new Color(97, 64, 22));
		btnNewButton_2_1.setBounds(26, 687, 82, 68);
		menu.add(btnNewButton_2_1);

		JPanel header = new JPanel();
		header.setBackground(new Color(219, 160, 89));
		header.setBounds(287, 0, 951, 55);
		contentPane.add(header);
		header.setLayout(null);

		jTxttime = new JLabel("New label");
		jTxttime.setHorizontalAlignment(SwingConstants.RIGHT);
		jTxttime.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jTxttime.setBounds(706, 10, 235, 35);
		header.add(jTxttime);

		JPanel order = new JPanel();
		order.setBackground(new Color(219, 160, 89));
		order.setBounds(1236, 0, 332, 800);
		contentPane.add(order);
		order.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("ORDER");
		lblNewLabel_1_1.setBounds(0, 54, 101, 50);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		order.add(lblNewLabel_1_1);

		totalBtn = new JButton("Total");
		totalBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (total == 0.000) {
					JOptionPane.showMessageDialog(null, "You haven't select any item");
				} else {
					textArea.setText(
							textArea.getText() + "\n*************************************************************\n"
									+ "Total: \t\t" + total + ".000 VND\n");
				}

			}
		});
		totalBtn.setBounds(37, 682, 101, 39);
		totalBtn.setForeground(new Color(219, 160, 89));
		totalBtn.setBackground(new Color(97, 64, 22));
		totalBtn.setFont(new Font("Segoe UI", Font.BOLD, 16));
		order.add(totalBtn);

		JButton btnNewButton_4_1 = new JButton("Print");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (total != 0) {

					if (recieve.getText() != "0.000") {

						try {
							textArea.print();
						} catch (PrinterException e1) {
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "You should calculate th total cost first");
					}
				} else {
					JOptionPane.showMessageDialog(null, "You haven't purchased any product");
				}
			}
		});
		btnNewButton_4_1.setBounds(184, 682, 93, 39);
		btnNewButton_4_1.setForeground(new Color(219, 160, 89));
		btnNewButton_4_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton_4_1.setBackground(new Color(97, 64, 22));
		order.add(btnNewButton_4_1);

		JLabel lblNewLabel_2 = new JLabel("Recieved");
		lblNewLabel_2.setBounds(10, 614, 76, 30);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		order.add(lblNewLabel_2);

		recieve = new JTextField();
		recieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double d = Double.parseDouble(recieve.getText());
				if (d < total) {
					JOptionPane.showMessageDialog(null, "Insufficient amount");
				} else {
					textArea.setText(
							textArea.getText() + "\n*************************************************************\n"
									+ "Recieved: \t\t" + recieve.getText() + " VND\n" + "Change: \t\t" + (d - total)
									+ "00 VND\n" + "***************************Thank you************************\n");
				}
			}
		});
		recieve.setBounds(96, 615, 170, 33);
		recieve.setHorizontalAlignment(SwingConstants.CENTER);
		recieve.setFont(new Font("Segoe UI", Font.BOLD, 14));
		recieve.setText("0.000");
		order.add(recieve);
		recieve.setColumns(10);

		JButton btnNewButton_4_1_1 = new JButton("Reset");
		btnNewButton_4_1_1.setBounds(120, 732, 76, 39);
		btnNewButton_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				displayFood();
				displayDrink();
				displayCoffee();
			}
		});
		btnNewButton_4_1_1.setForeground(new Color(219, 160, 89));
		btnNewButton_4_1_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton_4_1_1.setBackground(new Color(97, 64, 22));
		order.add(btnNewButton_4_1_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 96, 304, 508);
		order.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JPanel Main = new JPanel();
		Main.setBackground(new Color(97, 64, 22));
		Main.setBounds(287, 53, 951, 800);
		contentPane.add(Main);
		Main.setLayout(new CardLayout(0, 0));

		Home = new JPanel();
		Home.setBackground(new Color(97, 64, 22));
		Main.add(Home, "name_1074981603393700");
		Home.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("MENU");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1.setBounds(39, 16, 101, 50);
		Home.add(lblNewLabel_1);

		JButton btnNewButton_3 = new JButton("Foods");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayFood();
			}
		});
		btnNewButton_3.setBackground(new Color(219, 160, 89));
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_3.setBounds(274, 28, 95, 29);
		Home.add(btnNewButton_3);

		JButton btnNewButton_3_1 = new JButton("Drinks");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayDrink();
			}
		});
		btnNewButton_3_1.setBackground(new Color(219, 160, 89));
		btnNewButton_3_1.setForeground(new Color(0, 0, 0));
		btnNewButton_3_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_3_1.setBounds(422, 28, 85, 29);
		Home.add(btnNewButton_3_1);

		JButton btnNewButton_3_2 = new JButton("Coffee");
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayCoffee();
			}
		});
		btnNewButton_3_2.setBackground(new Color(219, 160, 89));
		btnNewButton_3_2.setForeground(new Color(0, 0, 0));
		btnNewButton_3_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_3_2.setBounds(548, 28, 95, 29);
		Home.add(btnNewButton_3_2);

		jScrollPane1 = new JScrollPane();
		jScrollPane1.setBounds(0, 76, 951, 682);
		Home.add(jScrollPane1);

		Product = new JPanel();
		Product.setBackground(new Color(97, 64, 22));
		Main.add(Product, "name_1075069397474600");
		Product.setLayout(null);

		JLabel lblNewLabel_1_2 = new JLabel("MENU");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1_2.setBounds(10, 10, 101, 50);
		Product.add(lblNewLabel_1_2);

		JButton btnNewButton_3_3 = new JButton("Foods");
		btnNewButton_3_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Foodtable.setVisible(true);
				Drink.setVisible(false);
				Coffee.setVisible(false);

			}
		});
		btnNewButton_3_3.setBackground(new Color(219, 160, 89));
		btnNewButton_3_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_3_3.setBounds(295, 29, 95, 29);
		Product.add(btnNewButton_3_3);

		JButton btnNewButton_3_1_1 = new JButton("Drinks");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Food.setVisible(false);
				Drink.setVisible(true);
				Coffee.setVisible(false);
			}
		});
		btnNewButton_3_1_1.setBackground(new Color(219, 160, 89));
		btnNewButton_3_1_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_3_1_1.setBounds(443, 29, 85, 29);
		Product.add(btnNewButton_3_1_1);

		JButton btnNewButton_3_2_1 = new JButton("Coffee");
		btnNewButton_3_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Food.setVisible(false);
				Drink.setVisible(false);
				Coffee.setVisible(true);
			}
		});
		btnNewButton_3_2_1.setBackground(new Color(219, 160, 89));
		btnNewButton_3_2_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_3_2_1.setBounds(569, 29, 95, 29);
		Product.add(btnNewButton_3_2_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(97, 64, 22));
		panel_3.setBounds(0, 113, 951, 677);
		Product.add(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));

		Food = new JPanel();
		panel_3.add(Food, "name_1075544892265900");
		Food.setLayout(null);

		Drink = new JPanel();
		Drink.setLayout(null);
		panel_3.add(Drink, "name_1075638959243200");

		Coffee = new JPanel();
		Coffee.setLayout(null);
		panel_3.add(Coffee, "name_1075652015749899");

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add add = new Add(Home.this);
				add.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(219, 160, 89));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setIcon(new ImageIcon(Home.class.getResource("/Image/icons8-plus-24.png")));
		btnNewButton.setBounds(793, 29, 77, 42);
		Product.add(btnNewButton);

		Statistic = new JPanel();
		Statistic.setBackground(new Color(255, 255, 255));
		Main.add(Statistic, "name_687066012739300");
		Statistic.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 951, 639);
		Statistic.add(scrollPane_1);
		scrollPane_1.setViewportView(purchaseTable);

		purchaseTable = new JTable(
				new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product", "Price", "Quantity", "Total"
			}
		));
		scrollPane_1.setViewportView(purchaseTable);
		
		JLabel lblNewLabel_3 = new JLabel("TOTAL");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(602, 669, 81, 41);
		Statistic.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_4.setBounds(722, 675, 219, 32);
		Statistic.add(lblNewLabel_4);
		 timer = new Timer(1000, new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	                lblNewLabel_4.setText(DTBase.getTotal()+".000 VND");
	            }
	        });
	        timer.start();
		
		JButton btnNewButton_4 = new JButton("CLEAR");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="DELETE FROM public.\"Purchase\"	";
				try {
					Connection con= Connect.getConnection();
					PreparedStatement ps= con.prepareStatement(sql);
					ps.executeUpdate();
				} catch (SQLException ex) {
					// TODO: handle exception
					ex.printStackTrace();
			}
				showData();
			}
		});
		btnNewButton_4.setForeground(new Color(228, 188, 139));
		btnNewButton_4.setBackground(new Color(97, 64, 22));
		btnNewButton_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_4.setBounds(20, 669, 90, 41);
		Statistic.add(btnNewButton_4);
		
		JButton btnNewButton_4_2 = new JButton("EXPORT");
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 StringBuilder builder= new StringBuilder();
		            try (
		            	 Connection con = Connect.getConnection();
		   	             Statement st = con.createStatement();
		   	             ResultSet rs = st.executeQuery("SELECT \"Product\", \"Quantity\", \"Price\", \"Total\" FROM \"Purchase\"")) {
		   	
		   	            while (rs.next()) {
		   	                builder.append("<Bill>\r\n");
		   	                builder.append("<Product>").append(rs.getString("Product")).append("</Product>\r\n");
		   	                builder.append("<Quantity>").append(rs.getString("Quantity")).append("</Quantity>\r\n");
		   	                builder.append("<Price>").append(rs.getString("Price")+"VND").append("</Price>\r\n");
		   	                builder.append("<Total>").append(rs.getString("Total")+".000VND").append("</Total>\r\n");
		   	                builder.append("</Bill>\r\n");
		   	            }
		   	        } catch (Exception ex) {
		   	            JOptionPane.showMessageDialog(null, "Error!");
		   	
		   	        }
			        String body= builder.toString();
			        String XML ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
			                + "<billList>\r\n"
			                + body
			                + "</billList>";
			        // Lưu vào tệp
			        JFileChooser fileChooser = new JFileChooser();
			        fileChooser.setDialogTitle("Specify a file to save");
			        int userSelection = fileChooser.showSaveDialog(null);

			        if (userSelection == JFileChooser.APPROVE_OPTION) {
			            File fileToSave = fileChooser.getSelectedFile();
			            try (FileOutputStream fos = new FileOutputStream(fileToSave)) {
			                byte[] data = XML.getBytes();
			                fos.write(data);
			                fos.close();
			                JOptionPane.showMessageDialog(null, "Exported successfully to " + fileToSave.getAbsolutePath());
			            } catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			        }
			}
		});
		btnNewButton_4_2.setForeground(new Color(228, 188, 139));
		btnNewButton_4_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_4_2.setBackground(new Color(97, 64, 22));
		btnNewButton_4_2.setBounds(145, 669, 90, 41);
		Statistic.add(btnNewButton_4_2);
		timeStart();
		setTime();
		ShowFood(FoodManager.getInstance().findAll());
		ShowDrink(DrinkManager.getInstance().findAll());
		ShowCoffee(CoffeeManager.getInstance().findAll());
	}

	private void displayFood() {
		Color mainColor = new Color(97, 64, 22);
		FoodManager foodManager = new FoodManager();
		List<Food> foods = foodManager.findAll();

		JPanel displayPanel = new JPanel(new GridLayout(0, 3, 120, 50));
		displayPanel.setBackground(Color.WHITE);

		for (Food food : foods) {
			KGradientPanel foodPanel = new KGradientPanel();
			foodPanel.setLayout(null);
			foodPanel.setBounds(0, 0, 216, 266);
			foodPanel.setBackground(Color.WHITE);
			foodPanel.setkStartColor(mainColor);
			foodPanel.setkEndColor(Color.gray);
			foodPanel.setkBorderRadius(50);
			foodPanel.setBackground(Color.WHITE);

			ImageIcon imageIcon = new ImageIcon(food.getImage());
			JLabel imageLabel = new JLabel(imageIcon);
			imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
			imageLabel.setBounds(45, 10, 145, 110);
			foodPanel.add(imageLabel);

			// Name
			JLabel nameLabel = new JLabel(food.getName());
			nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
			nameLabel.setBounds(35, 117, 142, 29);
			nameLabel.setForeground(new Color(219, 160, 89));
			foodPanel.add(nameLabel);

			// Price
			JLabel priceLabel = new JLabel(food.getPrice());
			priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
			priceLabel.setFont(new Font("Segoe UI", 1, 15));
			priceLabel.setBounds(35, 143, 142, 22);
			priceLabel.setForeground(Color.RED);
			foodPanel.add(priceLabel);

			JSpinner spinner = new JSpinner();
			spinner.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			spinner.setBounds(71, 175, 64, 29);
			spinner.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
	                checkSpinnerValue(spinner);
				}
			});

			foodPanel.add(spinner);
			KButton buyButton = new KButton();
			buyButton.setText("BUY");
			buyButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int qty = Integer.parseInt(spinner.getValue().toString());
					String name = nameLabel.getText();
					String cost = priceLabel.getText();

					if (qty == 0) {
						JOptionPane.showMessageDialog(null, "Please increase the item quantity");
					} else {
						x++;
						if (x == 1) {
							bill();
						}
						double price = qty * Double.parseDouble(priceLabel.getText());
						total += price;
						textArea.setText(textArea.getText() + " " + x + ". " + name + "\t" + price + "00 VND " + "    "
								+ qty + "\n");
						PurchaseManager.insertPurchase(name, qty,cost);
						spinner.setValue(0);
					}
				}
			});
			buyButton.setBackground(mainColor);
			buyButton.setkAllowGradient(false);
			buyButton.setkBorderRadius(30);
			buyButton.setkBackGroundColor(mainColor);
			buyButton.setkSelectedColor(Color.WHITE);
			buyButton.setkHoverForeGround(Color.BLACK);
			buyButton.setAlignmentX(Component.CENTER_ALIGNMENT);

			buyButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
			buyButton.setBounds(61, 227, 85, 29);
			foodPanel.add(buyButton);

			displayPanel.add(foodPanel);
		}

		JScrollPane scrollPane = new JScrollPane(displayPanel);

		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setViewportView(scrollPane);
	}

	private void checkSpinnerValue(JSpinner spinner) {
	    int value = (int) spinner.getValue();
	    if (value < 0) {
	        JOptionPane.showMessageDialog(null, "Lỗi: Giá trị của spinner không được nhỏ hơn 0");
	        spinner.setValue(0);
	    }
	}
	private void displayDrink() {
		Color mainColor = new Color(97, 64, 22);
		DrinkManager drinkManager = new DrinkManager();
		List<Drink> drinks = drinkManager.findAll();

		JPanel displayPanel = new JPanel(new GridLayout(0, 3, 120, 50));
		displayPanel.setBackground(Color.WHITE);

		for (Drink drink : drinks) {
			KGradientPanel drinkPanel = new KGradientPanel();
			drinkPanel.setLayout(null);
			drinkPanel.setBounds(0, 0, 216, 266);
			drinkPanel.setBackground(Color.WHITE);
			drinkPanel.setkStartColor(mainColor);
			drinkPanel.setkEndColor(Color.gray);
			drinkPanel.setkBorderRadius(50);
			drinkPanel.setBackground(Color.WHITE);

			ImageIcon imageIcon = new ImageIcon(drink.getImage());
			JLabel imageLabel = new JLabel(imageIcon);
			imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
			imageLabel.setBounds(45, 10, 145, 110);
			drinkPanel.add(imageLabel);

			// Name
			JLabel nameLabel = new JLabel(drink.getName());
			nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
			nameLabel.setBounds(35, 117, 142, 29);
			nameLabel.setForeground(new Color(219, 160, 89));
			drinkPanel.add(nameLabel);

			// Price
			JLabel priceLabel = new JLabel(drink.getPrice());
			priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
			priceLabel.setFont(new Font("Segoe UI", 1, 16));
			priceLabel.setBounds(35, 143, 142, 22);
			priceLabel.setForeground(Color.RED);
			drinkPanel.add(priceLabel);

			JSpinner spinner = new JSpinner();
			spinner.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			spinner.setBounds(71, 175, 64, 29);
			drinkPanel.add(spinner);

			KButton buyButton = new KButton();
			buyButton.setText("BUY");
			buyButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int qty = Integer.parseInt(spinner.getValue().toString());
					String name = nameLabel.getText();
					String cost = priceLabel.getText();
					if (qty == 0) {
						JOptionPane.showMessageDialog(null, "Please increase the item quantity");
					} else {
						x++;
						if (x == 1) {
							bill();
						}
						Double price = qty * Double.parseDouble(priceLabel.getText());
						total += price;
						textArea.setText(textArea.getText() + " " + x + ". " + name + "\t" + price + "00 VND " + "    "
								+ qty + "\n");
						PurchaseManager.insertPurchase(name,qty,cost);
					}
					spinner.setValue(0);
				}
			});
			buyButton.setBackground(mainColor);
			buyButton.setkAllowGradient(false);
			buyButton.setkBorderRadius(30);
			buyButton.setkBackGroundColor(mainColor);
			buyButton.setkSelectedColor(Color.WHITE);
			buyButton.setkHoverForeGround(Color.BLACK);
			buyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			buyButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
			buyButton.setBounds(61, 227, 85, 29);
			drinkPanel.add(buyButton);

			displayPanel.add(drinkPanel);
		}

		JScrollPane scrollPane = new JScrollPane(displayPanel);

		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setViewportView(scrollPane);
	}

	private void displayCoffee() {
		Color mainColor = new Color(97, 64, 22);
		CoffeeManager coffeeManager = new CoffeeManager();
		List<Coffee> coffees = coffeeManager.findAll();

		JPanel displayPanel = new JPanel(new GridLayout(0, 3, 120, 50));
		displayPanel.setBackground(Color.WHITE);

		for (Coffee coffee : coffees) {
			KGradientPanel cofffeePanel = new KGradientPanel();
			cofffeePanel.setLayout(null);
			cofffeePanel.setBounds(0, 0, 216, 266);
			cofffeePanel.setBackground(Color.WHITE);
			cofffeePanel.setkStartColor(mainColor);
			cofffeePanel.setkEndColor(Color.gray);
			cofffeePanel.setkBorderRadius(50);
			cofffeePanel.setBackground(Color.WHITE);

			ImageIcon imageIcon = new ImageIcon(coffee.getImage());
			JLabel imageLabel = new JLabel(imageIcon);
			imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
			imageLabel.setBounds(45, 10, 145, 110);
			cofffeePanel.add(imageLabel);

			// Name
			JLabel nameLabel = new JLabel(coffee.getName());
			nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
			nameLabel.setBounds(35, 117, 142, 29);
			nameLabel.setForeground(new Color(219, 160, 89));
			cofffeePanel.add(nameLabel);

			// Price
			JLabel priceLabel = new JLabel(coffee.getPrice());
			priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
			priceLabel.setFont(new Font("Segoe UI", 1, 16));
			priceLabel.setBounds(35, 143, 142, 22);
			priceLabel.setForeground(Color.RED);
			cofffeePanel.add(priceLabel);

			JSpinner spinner = new JSpinner();
			spinner.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			spinner.setBounds(71, 175, 64, 29);
			cofffeePanel.add(spinner);

			KButton buyButton = new KButton();
			buyButton.setText("BUY");
			buyButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int qty = Integer.parseInt(spinner.getValue().toString());
					String name = nameLabel.getText();
					String cost = priceLabel.getText();
					if (qty == 0) {
						JOptionPane.showMessageDialog(null, "Please increase the item quantity");
					} else {
						x++;
						if (x == 1) {
							bill();
						}
						Double price = qty * Double.parseDouble(priceLabel.getText());
						total += price;
						textArea.setText(textArea.getText() + " " + x + ". " + name + "\t\t" + price + "00 VND " + "    "
								+ qty + "\n");
						
						PurchaseManager.insertPurchase(name,qty,cost);
					}
					spinner.setValue(0);
				}
			});
			buyButton.setBackground(mainColor);
			buyButton.setkAllowGradient(false);
			buyButton.setkBorderRadius(30);
			buyButton.setkBackGroundColor(mainColor);
			buyButton.setkSelectedColor(Color.WHITE);
			buyButton.setkHoverForeGround(Color.BLACK);
			buyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			buyButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
			buyButton.setBounds(61, 227, 85, 29);
			cofffeePanel.add(buyButton);

			displayPanel.add(cofffeePanel);
		}

		JScrollPane scrollPane = new JScrollPane(displayPanel);

		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setViewportView(scrollPane);
	}

	private void ShowFood(List<Food> foods) {
		foodModel = new DefaultTableModel(new Object[][] {}, new String[] { "Image", "Product's name", "Price" });
		Foodtable = new JTable(foodModel);
		Foodtable.getColumnModel().getColumn(0).setPreferredWidth(50);
		Foodtable.getColumnModel().getColumn(1).setPreferredWidth(195);
		Foodtable.getColumnModel().getColumn(2).setPreferredWidth(104);
		Foodtable.setRowHeight(10);
		Foodtable.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		JScrollPane foodscrollPane = new JScrollPane(Foodtable);
		foodscrollPane.setBounds(0, 0, 968, 637);
		Food.setLayout(null);
		Food.add(foodscrollPane);
		for (Food food : foods) {
			foodModel.addRow(new Object[] { food.getImage(), food.getName(), food.getPrice() });
		}
		Foodtable.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
		Foodtable.getColumnModel().getColumn(0).setPreferredWidth(100);
		Foodtable.setRowHeight(150);

	}

	private void ShowDrink(List<Drink> drinks) {
		drinkModel = new DefaultTableModel(new Object[][] {}, new String[] { "Image", "Product's name", "Price" });
		Drinktable = new JTable(drinkModel);
		Drinktable.getColumnModel().getColumn(0).setPreferredWidth(50);
		Drinktable.getColumnModel().getColumn(1).setPreferredWidth(195);
		Drinktable.getColumnModel().getColumn(2).setPreferredWidth(104);
		Drinktable.setRowHeight(10);
		Drinktable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		JScrollPane drinkscrollPane = new JScrollPane(Drinktable);
		drinkscrollPane.setBounds(0, 0, 968, 637);
		Drink.setLayout(null);
		Drink.add(drinkscrollPane);
		for (Drink drink : drinks) {
			drinkModel.addRow(new Object[] { drink.getImage(), drink.getName(), drink.getPrice() });
		}
		Drinktable.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
		Drinktable.getColumnModel().getColumn(0).setPreferredWidth(100);
		Drinktable.setRowHeight(150);
	}

	private void ShowCoffee(List<Coffee> coffees) {
		coffeeModel = new DefaultTableModel(new Object[][] {}, new String[] { "Image", "Product's name", "Price" });
		Coffeetable = new JTable(coffeeModel);
		Coffeetable.getColumnModel().getColumn(0).setPreferredWidth(50);
		Coffeetable.getColumnModel().getColumn(1).setPreferredWidth(195);
		Coffeetable.getColumnModel().getColumn(2).setPreferredWidth(104);
		Coffeetable.setRowHeight(10);
		Coffeetable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		JScrollPane coffeescrollPane = new JScrollPane(Coffeetable);
		coffeescrollPane.setBounds(0, 0, 968, 637);
		Coffee.setLayout(null);
		Coffee.add(coffeescrollPane);
		for (Coffee coffee : coffees) {
			coffeeModel.addRow(new Object[] { coffee.getImage(), coffee.getName(), coffee.getPrice() });
		}
		Coffeetable.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
		Coffeetable.getColumnModel().getColumn(0).setPreferredWidth(100);
		Coffeetable.setRowHeight(150);
	}

	public void refreshTable() {
		List<Drink> updatedDrinks = DrinkManager.findAll();
		List<Food> updateFoods = FoodManager.findAll();
		List<Coffee> updateCoffees = CoffeeManager.findAll();
		if (updatedDrinks != null) {
			drinkModel.setRowCount(0);
			foodModel.setRowCount(0);
			coffeeModel.setRowCount(0);
			for (Drink drink : updatedDrinks) {
				drinkModel.addRow(new Object[] { drink.getImage(), drink.getName(), drink.getPrice() });
			}
			for (Food food : updateFoods) {
				foodModel.addRow(new Object[] { food.getImage(), food.getName(), food.getPrice() });
			}
		}

		if (updateCoffees != null) {
			for (Coffee coffee : updateCoffees) {
				coffeeModel.addRow(new Object[] { coffee.getImage(), coffee.getName(), coffee.getPrice() });
			}
		}
	}

	public void bill() {
		int ID = 1000 + (int) (Math.random() * 80800);
		textArea.setText("**********************Peanut Coffee***********************\n" + "           Time: "
				+ jTxttime.getText() + "\n" + "           Orders ID: " + ID + "\n"
				+ "*************************************************************\n" 
				+ "Item Name\t\t" + "Price    "+ "         Quantity\n");
	}

	private void showData() {
		String query = "SELECT * FROM \"Purchase\"";
		try (
			Connection connection = Connect.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query)) {
			ResultSet rs = pstmt.executeQuery();
			DefaultTableModel tableModel;
			tableModel = (DefaultTableModel) purchaseTable.getModel();
			tableModel.setRowCount(0);
			while (rs.next()) {
				String product = rs.getString("Product");
				String price = rs.getString("Price");
				int quantity = rs.getInt("quantity");
				double total = Double.parseDouble(price) * quantity;
				tableModel.addRow(new Object[] { product, price, quantity, total });
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	 }


