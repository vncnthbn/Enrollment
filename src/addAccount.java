import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class addAccount extends JDialog{

	private JButton btnExit, btnMin;
	Border brdr = BorderFactory.createEmptyBorder();
	Border in = BorderFactory.createLoweredBevelBorder();
	public addAccount() {
		Font f = new Font("Courier New", Font.BOLD, 20);
			
		ImageIcon bg = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\lightspeed-wallpaper-1366x768.jpg");
		ImageIcon imgExit = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\exit.png");
		ImageIcon exYellow = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\exitYellow.png");
		
		JLayeredPane pnTop = new JLayeredPane();
		pnTop.setBounds(0, 0, 380, 50);
		pnTop.setOpaque(true);
		pnTop.setBackground(new Color(10, 61, 115));
		pnTop.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.YELLOW));
		
		btnExit = new JButton();
		btnExit.setBounds(345, 15, 20, 20);
		btnExit.setIcon(imgExit);
		btnExit.setBorder(brdr);
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		btnExit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setIcon(imgExit);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setIcon(exYellow);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JLabel main = new JLabel(bg);
		main.setBounds(0, 0, 380, 350);
		
		JLabel lblTitle = new JLabel("Create Account");
		lblTitle.setBounds(20, 0, 500, 50);
		lblTitle.setForeground(Color.white);
		lblTitle.setFont(f);
		
		JLayeredPane pnInside = new JLayeredPane();
		pnInside.setBounds(0, 50, 380, 350);
		pnInside.setOpaque(true);
		
		//GUIS
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(80, 60, 100, 20);
		lblName.setFont(new Font("Courier New", Font.BOLD, 16));
		
		JTextField tfName = new JTextField();
		tfName.setBounds(135, 60, 180, 20);
		tfName.setFont(new Font("Courier New", Font.PLAIN, 12));
		tfName.setBorder(in);
		
		JLabel lblUserName = new JLabel("Username: ");
		lblUserName.setBounds(40, 110, 100, 20);
		lblUserName.setFont(new Font("Courier New", Font.BOLD, 16));
		
		JTextField tfUsername = new JTextField();
		tfUsername.setBounds(135, 110, 180, 20);
		tfUsername.setFont(new Font("Courier New", Font.PLAIN, 12));
		tfUsername.setBorder(in);
		
		JLabel lblpassword = new JLabel("Password: ");
		lblpassword.setBounds(40,160, 100, 20);
		lblpassword.setFont(new Font("Courier New", Font.BOLD, 16));
		
		JTextField tfPassword = new JTextField();
		tfPassword.setBounds(135, 160, 180, 20);
		tfPassword.setFont(new Font("Courier New", Font.PLAIN, 12));
		tfPassword.setBorder(in);
		
		JButton btnCreate = new JButton("Create Account");
		btnCreate.setBounds(140, 210, 125, 40);
		btnCreate.setContentAreaFilled(false);
		btnCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbenrollment","root","");
					 PreparedStatement pst = con.prepareStatement("INSERT INTO tbl_Users(Name, Username, Password)values(?, ?, ?)");
					 pst.setString(1, tfName.getText());
					 pst.setString(2, tfUsername.getText());
					 pst.setString(3, tfPassword.getText());
					 if(tfName.getText().equals("")|| tfUsername.getText().equals("") || tfPassword.getText().equals("")) {
						 JOptionPane.showMessageDialog(null, "Please Complete The Form");
					 }
					 else {
						 pst.executeUpdate();
						 JOptionPane.showMessageDialog(null, "Account Successfully Created");
						 dispose();
						
					 }
				}
				catch (SQLException example) {
					
				}
				
			}
		});
		
		//GUIS
		
		this.setUndecorated(true);
		this.setLayout(null);
		this.setResizable(false);
		

		this.setVisible(true);
		this.setBounds(480, 140, 380, 400);
		
		pnInside.add(btnCreate);
		pnInside.add(lblpassword);
		pnInside.add(tfPassword);
		pnInside.add(lblUserName);
		pnInside.add(tfUsername);
		pnInside.add(lblName);
		pnInside.add(tfName);
		
		pnTop.add(lblTitle);
		
		pnTop.add(btnExit);
		pnInside.add(main);
		
		add(pnTop);
		add(pnInside);
	}
	
	public static void main(String[]args) {
		new addAccount();
	}

}
