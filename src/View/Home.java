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

import Database.FoodManager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.DefaultTableModel;

public class Home extends JFrame {

	private JPanel contentPane;
	private JLabel jTxttime;
	private JTable Foodtable;
	private JTable Drinktable;
	private JTable Coffeetable;
	private JPanel Home;
	private JPanel Product;
	private JPanel Food;
	private JPanel Drink;
	private JPanel Coffee;
    private JScrollPane jScrollPane1;






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
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(0, 54, 101, 50);
		order.add(lblNewLabel_1_1);

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
		btnNewButton_3_1.setBackground(new Color(219, 160, 89));
		btnNewButton_3_1.setForeground(new Color(0, 0, 0));
		btnNewButton_3_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_3_1.setBounds(422, 28, 85, 29);
		Home.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("Coffee");
		btnNewButton_3_2.setBackground(new Color(219, 160, 89));
		btnNewButton_3_2.setForeground(new Color(0, 0, 0));
		btnNewButton_3_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_3_2.setBounds(548, 28, 95, 29);
		Home.add(btnNewButton_3_2);
		
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
				
			}
		});
		btnNewButton_3_3.setBackground(new Color(219, 160, 89));
		btnNewButton_3_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_3_3.setBounds(295, 29, 95, 29);
		Product.add(btnNewButton_3_3);
		
		JButton btnNewButton_3_1_1 = new JButton("Drinks");
		btnNewButton_3_1_1.setBackground(new Color(219, 160, 89));
		btnNewButton_3_1_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_3_1_1.setBounds(443, 29, 85, 29);
		Product.add(btnNewButton_3_1_1);
		
		JButton btnNewButton_3_2_1 = new JButton("Coffee");
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 968, 637);
		Food.add(scrollPane);
		
		Foodtable = new JTable();
		Foodtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Image", "Product's name", "Price"
			}
		));
		Foodtable.getColumnModel().getColumn(1).setPreferredWidth(195);
		Foodtable.getColumnModel().getColumn(2).setPreferredWidth(104);
		Foodtable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		Foodtable.setBackground(new Color(97, 64, 22));
		scrollPane.setViewportView(Foodtable);
		
		Drink = new JPanel();
		Drink.setLayout(null);
		panel_3.add(Drink, "name_1075638959243200");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 951, 637);
		Drink.add(scrollPane_2);
		
		Drinktable = new JTable();
		Drinktable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Image", "Product's name", "Price"
			}
		));
		Drinktable.getColumnModel().getColumn(1).setPreferredWidth(169);
		Drinktable.getColumnModel().getColumn(2).setPreferredWidth(95);
		Drinktable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		Drinktable.setBackground(new Color(97, 64, 22));
		scrollPane_2.setViewportView(Drinktable);
		
		Coffee = new JPanel();
		Coffee.setLayout(null);
		panel_3.add(Coffee, "name_1075652015749899");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 951, 637);
		Coffee.add(scrollPane_1);
		
		Coffeetable = new JTable();
		Coffeetable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Image", "Product's name", "Price"
			}
		));
		Coffeetable.getColumnModel().getColumn(1).setPreferredWidth(162);
		Coffeetable.getColumnModel().getColumn(2).setPreferredWidth(101);
		Coffeetable.setBackground(new Color(97, 64, 22));
		scrollPane_1.setViewportView(Coffeetable);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(219, 160, 89));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setIcon(new ImageIcon(Home.class.getResource("/Image/icons8-plus-24.png")));
		btnNewButton.setBounds(793, 29, 77, 42);
		Product.add(btnNewButton);
		timeStart();
		setTime();
	}
	private void displayFood() {
		Color mainColor = new Color(51, 153, 255);
        FoodManager foodManager = new FoodManager();
        List<Model.Food> foods = foodManager.findAll(); 

        JPanel displayPanel = new JPanel(new GridLayout(0, 3, 120, 50)); 
        displayPanel.setBackground(Color.WHITE);

        for (Model.Food food : foods) {
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
        nameLabel.setFont(new Font("Segoe UI",1,12));
        foodPanel.add(Box.createVerticalStrut(10));
        foodPanel.add(nameLabel);

        
        // Price
        JLabel priceLabel = new JLabel(food.getPrice());
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        priceLabel.setFont(new Font("Segoe UI",1,12));
        priceLabel.setForeground(Color.red);
        foodPanel.add(Box.createVerticalStrut(10));
        foodPanel.add(priceLabel);
        
        KButton buyButton = new KButton();
        buyButton.setText("BUY");
        buyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   
                }
            });
        buyButton.setBackground(mainColor);
        buyButton.setkAllowGradient(false);
        buyButton.setkBorderRadius(30);
        buyButton.setkBackGroundColor(mainColor);
        buyButton.setkSelectedColor(Color.WHITE);
        buyButton.setkHoverForeGround(Color.BLACK);
        buyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      
       foodPanel.add(buyButton);
        
        
        displayPanel.add(foodPanel);
    }

     JScrollPane scrollPane = new JScrollPane(displayPanel);
    
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane1.setViewportView(scrollPane);
	}
	
}
