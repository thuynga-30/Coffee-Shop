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

import Controller.CoffeeManager;
import Controller.DrinkManager;
import Controller.FoodManager;
import Database.Connect;
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
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.util.*;
import javax.swing.Timer;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Home extends JFrame {

	private JPanel contentPane;
	private JLabel jTxttime;
	private JTable Drinktable;
	private JTable Coffeetable;
	private JPanel Home;
	private JPanel Product;
	private JPanel Food;
	private JPanel Drink;
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
	private double total = 0.000;
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
		total=0.000;
		x=0;
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
		home.setIcon(null);
		home.setForeground(new Color(219, 160, 89));
		home.setBackground(new Color(97, 64, 22));
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.setVisible(true);
				Product.setVisible(false);

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
			}
		});
		btnNewButton_1.setForeground(new Color(219, 160, 89));
		btnNewButton_1.setBackground(new Color(97, 64, 22));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_1.setBounds(84, 438, 113, 68);
		menu.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("STATISTIC");
		btnNewButton_2.setForeground(new Color(219, 160, 89));
		btnNewButton_2.setBackground(new Color(97, 64, 22));
		btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_2.setBounds(84, 546, 113, 68);
		menu.add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/Image/ffff.png")));
		lblNewLabel.setBounds(10, 31, 239, 178);
		menu.add(lblNewLabel);
		

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
									+ "Total: \t\t" + total + "00 VND\n");
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
		timeStart();
		setTime();
		showData();
		/*refreshTimer = new Timer(3, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshTable();	
			}
		});
		refreshTimer.start();*/

	}
	public void showData() {
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
			foodPanel.setLayout(new BoxLayout(foodPanel, BoxLayout.Y_AXIS));
			foodPanel.setPreferredSize(new Dimension(30, 250));
			foodPanel.setBackground(Color.WHITE);
			foodPanel.setkStartColor(mainColor);
			foodPanel.setkEndColor(Color.white);
			foodPanel.setkBorderRadius(100);
			foodPanel.setBackground(Color.WHITE);

			
			ImageIcon imageIcon = new ImageIcon(food.getImage()); 
			JLabel imageLabel = new JLabel(imageIcon); 
			imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			foodPanel.add(Box.createVerticalStrut(10));
			foodPanel.add(imageLabel);
			 

			// Name
			JLabel nameLabel = new JLabel(food.getName());
			nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			nameLabel.setFont(new Font("Segoe UI", 1, 20));
			nameLabel.setForeground(new Color(219, 160, 89));
			foodPanel.add(Box.createVerticalStrut(15));
			foodPanel.add(nameLabel);

			// Price
			JLabel priceLabel = new JLabel(food.getPrice());
			priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			priceLabel.setFont(new Font("Segoe UI", 1, 16));
			foodPanel.add(Box.createVerticalStrut(10));

			priceLabel.setForeground(Color.RED);
			
			foodPanel.add(priceLabel);

			JSpinner spinner = new JSpinner();
			spinner.setFont(new Font("Segoe UI", 1, 14));
			spinner.setBounds(106, 241, 60, 40);
			spinner.setSize(60, 50);
			foodPanel.add(Box.createVerticalStrut(5));
			foodPanel.add(spinner);

			KButton buyButton = new KButton();
			buyButton.setText("BUY");
			buyButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int qty = Integer.parseInt(spinner.getValue().toString());
					if (qty == 0) {
						JOptionPane.showMessageDialog(null, "Please increase the item quantity");
					} else {
						x++;
						if (x == 1) {
							bill();
						}
						Double price = qty * Double.parseDouble(priceLabel.getText());
						total += price;
						textArea.setText(textArea.getText() + " " + x + ". " + nameLabel.getText() + "\t" + price
								+ "00 VND " + "    " + qty + "\n");
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
			foodPanel.add(Box.createVerticalStrut(10));
			foodPanel.add(buyButton);

			displayPanel.add(foodPanel);
		}

		JScrollPane scrollPane = new JScrollPane(displayPanel);

		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setViewportView(scrollPane);
	}

	private void displayDrink() {
		Color mainColor = new Color(97, 64, 22);
		DrinkManager drinkManager = new DrinkManager();
		List<Drink> drinks = drinkManager.findAll();

		JPanel displayPanel = new JPanel(new GridLayout(0, 3, 120, 50));
		displayPanel.setBackground(Color.WHITE);

		for (Drink drink : drinks) {
			KGradientPanel drinkPanel = new KGradientPanel();
			drinkPanel.setLayout(new BoxLayout(drinkPanel, BoxLayout.Y_AXIS));
			drinkPanel.setPreferredSize(new Dimension(30, 250));
			drinkPanel.setBackground(Color.WHITE);
			drinkPanel.setkStartColor(mainColor);
			drinkPanel.setkEndColor(Color.white);
			drinkPanel.setkBorderRadius(100);
			drinkPanel.setBackground(Color.WHITE);

			
			  ImageIcon imageIcon = new ImageIcon(drink.getImage()); 
			  JLabel imageLabel =new JLabel(imageIcon); 
			  imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			  drinkPanel.add(Box.createVerticalStrut(5));
			  drinkPanel.add(imageLabel);
			 

			// Name
			JLabel nameLabel = new JLabel(drink.getName());
			nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			nameLabel.setFont(new Font("Segoe UI", 1, 16));
			nameLabel.setForeground(new Color(219, 160, 89));
			drinkPanel.add(Box.createVerticalStrut(10));
			drinkPanel.add(nameLabel);

			// Price
			JLabel priceLabel = new JLabel(drink.getPrice());
			priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			priceLabel.setFont(new Font("Segoe UI", 1, 14));
			priceLabel.setForeground(Color.RED);
			drinkPanel.add(Box.createVerticalStrut(10));
			drinkPanel.add(priceLabel);

			JSpinner spinner = new JSpinner();
			spinner.setFont(new Font("Tahoma", Font.BOLD, 14));
			spinner.setBounds(106, 241, 60, 40);
			drinkPanel.add(Box.createVerticalStrut(10));
			drinkPanel.add(spinner);

			KButton buyButton = new KButton();
			buyButton.setText("BUY");
			buyButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int qty = Integer.parseInt(spinner.getValue().toString());
					if (qty == 0) {
						JOptionPane.showMessageDialog(null, "Please increase the item quantity");
					} else {
						x++;
						if (x == 1) {
							bill();
						}
						Double price = qty * Double.parseDouble(priceLabel.getText());
						total += price;
						textArea.setText(textArea.getText() + " " + x + ". " + nameLabel.getText() + "\t" + price
								+ "00 VND " + "    " + qty + "\n");
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
			cofffeePanel.setLayout(new BoxLayout(cofffeePanel, BoxLayout.Y_AXIS));
			cofffeePanel.setPreferredSize(new Dimension(30, 250));
			cofffeePanel.setBackground(Color.WHITE);
			cofffeePanel.setkStartColor(mainColor);
			cofffeePanel.setkEndColor(Color.white);
			cofffeePanel.setkBorderRadius(100);
			cofffeePanel.setBackground(Color.WHITE);

			ImageIcon imageIcon = new ImageIcon(coffee.getImage());
			JLabel imageLabel = new JLabel(imageIcon);
			imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			cofffeePanel.add(Box.createVerticalStrut(5));
			cofffeePanel.add(imageLabel);

			// Name
			JLabel nameLabel = new JLabel(coffee.getName());
			nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			nameLabel.setFont(new Font("Segoe UI", 1, 14));
			nameLabel.setForeground(new Color(219, 160, 89));
			cofffeePanel.add(Box.createVerticalStrut(10));
			cofffeePanel.add(nameLabel);

			// Price
			JLabel priceLabel = new JLabel(coffee.getPrice());
			priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			priceLabel.setFont(new Font("Segoe UI", 1, 14));
			priceLabel.setForeground(Color.RED);
			cofffeePanel.add(Box.createVerticalStrut(10));
			cofffeePanel.add(priceLabel);

			JSpinner spinner = new JSpinner();
			spinner.setFont(new Font("Tahoma", Font.BOLD, 14));
			spinner.setBounds(95, 237, 69, 42);
			cofffeePanel.add(Box.createVerticalStrut(10));
			cofffeePanel.add(spinner);

			KButton buyButton = new KButton();
			buyButton.setText("BUY");
			buyButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int qty = Integer.parseInt(spinner.getValue().toString());
					if (qty == 0) {
						JOptionPane.showMessageDialog(null, "Please increase the item quantity");
					} else {
						x++;
						if (x == 1) {
							bill();
						}
						Double price = qty * Double.parseDouble(priceLabel.getText());
						total += price;
						textArea.setText(textArea.getText() + " " + x + ". " + nameLabel.getText() + "\t" + price
								+ "00 VND " + "    " + qty + "\n");
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

			cofffeePanel.add(buyButton);

			displayPanel.add(cofffeePanel);
		}

		JScrollPane scrollPane = new JScrollPane(displayPanel);

		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setViewportView(scrollPane);
	}

	private void ShowFood(List<Food> foods) {
		 foodModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Image", "Product's name", "Price" });
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
	 drinkModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Image", "Product's name", "Price" });
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
		coffeeModel = new DefaultTableModel(new Object[][] {},
				new String[] { "Image", "Product's name", "Price" });
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
		List<Coffee> updateCoffees= CoffeeManager.findAll() ;
		if (updatedDrinks != null) {
			drinkModel.setRowCount(0); 
			foodModel.setRowCount(0);
			coffeeModel.setRowCount(0);
			for (Drink drink : updatedDrinks) {
				drinkModel.addRow(new Object[] { drink.getImage(), drink.getName(), drink.getPrice() });
			}
			for (Food food : updateFoods ) {
				foodModel.addRow(new Object[] { food.getImage(), food.getName(), food.getPrice() });
			}
		}
		
		if (updateCoffees!= null) {
			for (Coffee coffee: updateCoffees) {
				coffeeModel.addRow(new Object[] {coffee.getImage(),coffee.getName(), coffee.getPrice()});
			}
		}
	}
	public void bill() {
		int ID = 1000 + (int) (Math.random() * 80800);
		textArea.setText("**********************Peanut Coffee***********************\n" 
				+ "           Time: "+ jTxttime.getText() + "\n"
				+ "           Orders ID: " + ID + "\n"
				+ "*************************************************************\n" 
				+ "Item Name\t" + "Price    "+ "         Quantity\n");
	}
}

	class ImageRenderer extends DefaultTableCellRenderer {
		JLabel lbl = new JLabel();

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (value != null) {
				// Đọc dữ liệu hình ảnh
				ImageIcon icon = new ImageIcon((byte[]) value);
				Image image = icon.getImage();

				// Kiểm tra hướng xoay của hình ảnh
				int width = image.getWidth(null);
				int height = image.getHeight(null);
				if (width > height) {
					// Nếu chiều rộng lớn hơn chiều cao, quay ảnh
					image = image.getScaledInstance(-1, 150, Image.SCALE_SMOOTH);
				} else {
					// Ngược lại, không cần quay ảnh
					image = image.getScaledInstance(150, -1, Image.SCALE_SMOOTH);
				}

				// Tạo mới ImageIcon từ hình ảnh đã được chỉnh sửa
				ImageIcon scaledIcon = new ImageIcon(image);
				lbl.setIcon(scaledIcon);
			} else {
				lbl.setIcon(null);
			}
			return lbl;
		}
	}


