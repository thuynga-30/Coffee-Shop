package View;

import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.DefaultKeyboardFocusManager;

import net.miginfocom.swing.MigLayout;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import Controller.PanelCover;
import Controller.PanelLoginAndSignup;

public class LoginAndSingup extends JFrame {

	private JPanel bg;
	private PanelCover coverr;
	private PanelLoginAndSignup loginandSignup;
	private final double addSize=30;
	private final double coverSize=40;
	private final double loginsize=60;
	private MigLayout layout;
	private boolean isLogin;
	private  final DecimalFormat decimalFormat= new DecimalFormat("##0.###");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAndSingup frame = new LoginAndSingup();
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
	public LoginAndSingup() {
		coverr = new PanelCover();
		layout= new MigLayout("fill, insets 0");
		loginandSignup = new PanelLoginAndSignup();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 557);
		bg = new JPanel();
		bg.setBackground(new Color(255, 255, 255));
		bg.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(bg);
		bg.setLayout(layout);
		
		TimingTarget target= new TimingTargetAdapter() {
			@Override
			public void timingEvent(float fraction) {
				double fractionCover;
				double fractionLogin;
				double  size = coverSize;
				if (fraction<=0.5f) {
					size+=(fraction * addSize);
				}else {
					size+= addSize- fraction*addSize;
				}
				if (isLogin) {
					fractionCover = 1f -fraction;
					fractionLogin = fraction;
					if (fraction >=0.5f) {
						coverr.signupRight(fractionCover*100);
					}else {
						coverr.loginRight((fractionLogin *100));
					}
			}
				else {
					fractionCover = fraction;
					fractionLogin = 1f- fraction;
					if (fraction<=0.5f) {
						coverr.signupLeft(fraction * 100);
					}else {
						coverr.loginLeft((1f-fraction)*100);
					}
				}
				if (fraction>=0.5f) {
					loginandSignup.showSignUp(isLogin);
				}
				fractionCover = Double.valueOf(decimalFormat.format(fractionCover));
				fractionLogin = Double.valueOf(decimalFormat.format(fractionLogin));
				layout.setComponentConstraints(coverr,"width "+size+"%, pos "+fractionCover+"al 0 n 100%" );
				layout.setComponentConstraints(loginandSignup,"width "+loginsize+"%, pos "+fractionLogin+"al 0 n 100%" );
				bg.revalidate();
			}
			@Override
			public void end() {
				isLogin = !isLogin;
			}
		};
		Animator animator = new Animator(1000 , target);
		animator.setAcceleration(0.5f);
		animator.setDeceleration(0.5f);
		animator.setResolution(0);// for smooth
		bg.add(coverr,"width "+coverSize+"%, pos 0al 0 n 100%");
		bg.add(loginandSignup,"width "+loginsize+"%, pos 1al 0 n 100%");//1al as 100%
		coverr.addEvent(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!animator.isRunning()) {
					animator.start();
				}
			}
		});
	}

}
