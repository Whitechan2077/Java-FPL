package poly.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/poly/icons/fpt.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 177);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 56, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(10, 43, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		txtUser = new JTextField();
		txtUser.setBounds(92, 40, 210, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(10, 68, 72, 14);
		contentPane.add(lblNewLabel_2);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(92, 65, 210, 21);
		contentPane.add(txtPass);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBounds(213, 97, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnLogin.setBackground(Color.GREEN);
		btnLogin.setBounds(121, 97, 82, 23);
		contentPane.add(btnLogin);
		timer();
	}

	public void timer() {
		new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isvalid();
			}
		}).start();
	}
	
	public boolean isvalid() {
		String user = txtUser.getText();
		String pass = txtPass.getText();
		
		if(user.equals("admin") && pass.equals("123")) {
			txtUser.setBackground(Color.WHITE);
			txtPass.setBackground(Color.WHITE);
			return true;
			
		}else {
			if (!user.equals("admin"))
				txtUser.setBackground(Color.YELLOW);
			else
				txtUser.setBackground(Color.WHITE);
			if (!pass.equals("123"))
				txtPass.setBackground(Color.YELLOW);
			else
				txtPass.setBackground(Color.WHITE);
			
			return false;
		}
		
	}
	
	public void login() {
		if(isvalid()) {
			JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
			QuanLyNhanVien qlnv = new QuanLyNhanVien();
			qlnv.setVisible(true);
			this.dispose();
		}
		else 
			JOptionPane.showMessageDialog(this, "Đăng nhập thất bại");
	}
}









