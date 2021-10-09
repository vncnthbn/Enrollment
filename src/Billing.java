import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
public class Billing extends JFrame{
	private JTextField  tfpay;
	private JButton btnMin, btnExit, btnBack, btnPay;
	private JLabel lblTitle, tfName, tfCourse;
	int in;
	Connection con;
	public Billing() {

		Font f = new Font("Courier New", Font.BOLD, 35);
		Font ff = new Font("Courier New", Font.BOLD, 12);
		Border brdr = BorderFactory.createEmptyBorder();
		//GUIS
		ImageIcon backbtn = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\back.png");
		ImageIcon backHov = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\backHover.png");
		ImageIcon imgExit = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\exit.png");
		ImageIcon exYellow = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\exitYellow.png");
		ImageIcon imgMini = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\minimize.png");
		ImageIcon minYellow = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\minimizeYellow.png");
		
		ImageIcon bg = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\lightspeed-wallpaper-1366x768.jpg");
		JLabel main = new JLabel(bg);
		main.setBounds(0, 0, 655, 500);
		
		lblTitle = new JLabel("Cashier");
		lblTitle.setBounds(80, 10, 500, 50);
		lblTitle.setFont(f);
		
		JLayeredPane pnMain = new JLayeredPane();
		pnMain.setBounds(0, 0, 500, 380);	
		pnMain.setOpaque(true);
		
		JLayeredPane pnSide = new JLayeredPane();
		pnSide.setBounds(500, 0, 45, 380);
		pnSide.setOpaque(true);
		pnSide.setBackground(new Color(10, 61, 115));
		pnSide.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.YELLOW));
		
		JLayeredPane pnCon = new JLayeredPane();
		pnCon.setBounds(50, 70, 410, 270);
		pnCon.setOpaque(true);
		pnCon.setBackground(new Color(217, 188, 141));
		pnCon.setBorder(BorderFactory.createRaisedBevelBorder());
		
		JLabel lblSearch = new JLabel("Search Student By ID: ");
		lblSearch.setBounds(18, 23, 180, 20);
		lblSearch.setFont(ff);
		
		JTextField tfSearch = new JTextField();
		tfSearch.setBounds(172, 23, 130, 20);
		tfSearch.setFont(ff);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(308, 21, 80, 25);
		btnSearch.setContentAreaFilled(false);
		btnSearch.setFont(ff);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					con = DriverManager.getConnection("jdbc:mysql://localhost/dbenrollment", "root", "");
					PreparedStatement ps = con.prepareStatement("SELECT * FROM tbl_Students WHERE ID = ?");
					ps.setString(1, tfSearch.getText());
					ResultSet set = ps.executeQuery();
					
					if(set.next()) {
						String t = set.getString(22);
						String course = set.getString(2);
						String Fname = set.getString(4);
						String Lname = set.getString(6);
						
						in = Integer.parseInt(t);
						tfName.setText(Fname + " "  + Lname);
						tfName.setForeground(Color.black);
						tfCourse.setText(course);
						tfCourse.setForeground(Color.black);
					}
					else {
						JOptionPane.showMessageDialog(null, "No data");
					}
					
				}
				catch (Exception e) {
					
				}
				
			}
		});
		
		JLabel lblName = new JLabel("Full Name: ");
		lblName.setBounds(18, 78, 100, 20);
		lblName.setFont(ff);
		
		tfName = new JLabel();
		tfName.setBounds(100, 78, 260, 20);
		tfName.setFont(ff);
		
		JLabel lblCourse = new JLabel("Course: ");
		lblCourse.setBounds(18, 120, 100, 20);
		lblCourse.setFont(ff);
		
		tfCourse = new JLabel();
		tfCourse.setBounds(100, 120, 260, 20);
		tfCourse.setFont(ff);
		
		TitledBorder payments = BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),"Tuition");
		payments.setTitleJustification(TitledBorder.LEFT);
		payments.setTitleFont(ff);
		
		JLayeredPane pnPayment = new JLayeredPane();
		pnPayment.setBounds(21, 155, 370,105);
		pnPayment.setBorder(payments);
		
		JLabel lblPay = new JLabel("Cash: ");
		lblPay.setBounds(40, 38, 100, 20);
		lblPay.setFont(new Font("Courier New", Font.BOLD, 20));
		
		tfpay = new JTextField();
		tfpay.setBounds(100, 38, 150, 20);
		tfpay.setFont(ff);
		

		btnPay = new JButton("Pay");
		btnPay.setBounds(270, 33, 80, 30);
		btnPay.setContentAreaFilled(false);
		btnPay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				try {
					int p = Integer.parseInt(tfpay.getText());
					int insert = p + in;
					con = DriverManager.getConnection("jdbc:mysql://localhost/dbenrollment", "root", "");
					PreparedStatement pst = con.prepareStatement("UPDATE tbl_students SET PaymentValue = ? WHERE ID = ?");
					pst.setInt(1, insert);
					pst.setString(2, tfSearch.getText());
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Tuition Updated!");
				}
				catch (SQLException |NumberFormatException e1) {
					e1.printStackTrace();
				
				} 
				
			}
		});
			
		
		btnBack = new JButton();
		btnBack.setBounds(28, 15, 40, 40);
		btnBack.setContentAreaFilled(false);
		btnBack.setIcon(backHov);
		btnBack.setBorder(BorderFactory.createEmptyBorder());
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new ctrlCenter();
				
			}
		});
		btnBack.addMouseListener(new MouseListener() {
			
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
				btnBack.setIcon(backHov);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setIcon(backbtn);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnExit = new JButton();
		btnExit.setBounds(15, 15, 20, 20);
		btnExit.setIcon(imgExit);
		btnExit.setBorder(brdr);
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			
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
		

		btnMin = new JButton();
		btnMin.setBounds(15, 55, 20, 20);
		btnMin.setIcon(imgMini);
		btnMin.setBorder(brdr);
		btnMin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setState(Frame.ICONIFIED);
				
			}
		});
		btnMin.addMouseListener(new MouseListener() {
			
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
				btnMin.setIcon(imgMini);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMin.setIcon(minYellow);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		pnSide.add(btnExit);
		pnSide.add(btnMin);
		
		pnPayment.add(btnPay);
		pnPayment.add(tfpay);
		pnPayment.add(lblPay);
		
		pnCon.add(pnPayment);
		pnCon.add(tfCourse);
		pnCon.add(lblCourse);
		pnCon.add(tfName);
		pnCon.add(lblName);
		pnCon.add(btnSearch);
		pnCon.add(lblSearch);
		pnCon.add(tfSearch);
		
		pnMain.add(pnCon);
		//pnMain.add(btnPay);
		pnMain.add(lblTitle);
		pnMain.add(btnBack);
		pnMain.add(main);
	
		add(pnMain);
		add(pnSide);
		
		this.setLayout(null);
		this.setBounds(430, 110, 545, 380);
	    this.setUndecorated(true);
	    this.setResizable(false);
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[]args) {
		new Billing();
		
	}

}
