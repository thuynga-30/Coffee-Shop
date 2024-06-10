package Controller;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import View.Home;
import net.miginfocom.swing.MigLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PanelCover extends JPanel {
	private ActionListener event;
	private MigLayout layout;
	private boolean  isLogin;
	private JLabel title;
	private JLabel description;
	private JButton Button;
	private final DecimalFormat df= new DecimalFormat("##0.###");
	public PanelCover() {
		setOpaque(false);
		setLayout(null);
		init();
	}
	private void init() {
		
		
		title = new JLabel("");
		title.setIcon(new ImageIcon(PanelCover.class.getResource("/Image/ffff.png")));
		title.setBounds(24, 10, 244, 187);
		add(title);
		
		description = new JLabel("Have a good day !!!");
		description.setForeground(new Color(255, 255, 255));
		description.setFont(new Font("Segoe UI", Font.BOLD, 25));
		description.setHorizontalAlignment(SwingConstants.CENTER);
		description.setBounds(24, 238, 265, 59);
		add(description);
		
		Button = new JButton("LOG IN");
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				event.actionPerformed(e);
			}
		});
		Button.setForeground(new Color(255, 255, 255));
		Button.setFont(new Font("Segoe UI", Font.BOLD, 16));
		Button.setBackground(new Color(97, 64, 22));
		Button.setBounds(89, 374, 113, 46);
		add(Button);
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D graphics2d = (Graphics2D) g;
		GradientPaint gradientPaint = new GradientPaint(0,0, new Color(231, 170, 97),0, getHeight(),new Color(219,160,89));
		graphics2d.setPaint(gradientPaint);
		graphics2d.fillRect(0, 0, getWidth(),getHeight());
		super.paintComponent(g);
	}
	public void addEvent(ActionListener event) {
		this.event= event;
	}
	public void signupLeft(double v) {
		v = Double.valueOf(df.format(v));
		login(false);
	}
	public void signupRight(double v) {
		v = Double.valueOf(df.format(v));
		login(false);
	}
	public void loginLeft(double v) {
		v = Double.valueOf(df.format(v));
		login(true);
	}
	public void loginRight(double v) {
		v = Double.valueOf(df.format(v));
		login(true);
	}
	private void login(boolean login) {
		if (this.isLogin != login) {
			if (login) {
				
				description.setText("Welcome back !!!");
				Button.setText("SIGN UP");
			}else {
				description.setText("Have a good day !!!");
				Button.setText("LOG IN");

			}
			this.isLogin=login;
		}
	}
}
