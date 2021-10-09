import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Students extends JFrame{
	
	private JLayeredPane pnSide, pnMain;
	private JButton btnExit, btnMin;
	private JTextField tfID;
	private JLabel lblTitle, label;
	private JButton btnBack, btnId;
	
	Connection connection;
	Statement pst;
	ResultSet rs;
	
	public Students() {
		Font f = new Font("Courier New", Font.BOLD, 35);
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
		
		lblTitle = new JLabel("Students");
		lblTitle.setBounds(80, 10, 500, 50);
		lblTitle.setFont(f);
		
		pnMain = new JLayeredPane();
		pnMain.setBounds(0, 0, 655, 500);	
		pnMain.setOpaque(true);
		
		JLayeredPane pnTabcon = new JLayeredPane();
		pnTabcon.setBounds(80, 80, 520, 380);
		pnTabcon.setBorder(BorderFactory.createRaisedBevelBorder());
		pnTabcon.setOpaque(true);
		pnTabcon.setBackground(Color.gray);
		
		pnSide = new JLayeredPane();
		pnSide.setBounds(655, 0, 45, 500);
		pnSide.setOpaque(true);
		pnSide.setBackground(new Color(10, 61, 115));
		pnSide.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.YELLOW));
	
		btnBack = new JButton();
		btnBack.setBounds(20, 15, 40, 40);
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
		
		tfID = new JTextField();
		tfID.setBounds(100, 470, 100, 20);
		
		label = new JLabel();
		label.setBounds(10, 10, 200, 100);
		
		btnId = new JButton("VIEW");
		btnId.setBounds(200, 470, 90, 20);
		btnId.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 try{
		                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbEnrollment","root","");
		                Statement st = con.createStatement();
		                ResultSet rs = st.executeQuery("select * from tbl_students where ID = '"+tfID.getText()+"'");
		                if(rs.next()){
		                    byte[] img = rs.getBytes("StudentImage");



		                    ImageIcon image = new ImageIcon(img);
		                    Image im = image.getImage();
		                    Image myImg = im.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
		                    ImageIcon newImage = new ImageIcon(myImg);
		                    label.setIcon(newImage);
		                }
		                
		                else{
		                    JOptionPane.showMessageDialog(null, "No Data");
		                }
		            }catch(Exception ex){
		                ex.printStackTrace();
		            }
		        
		        }
		});
		
				
		pnSide.add(btnExit);
		pnSide.add(btnMin);
		pnMain.add(label);
		pnMain.add(btnId);
		pnMain.add(tfID);
		pnMain.add(btnBack);
		pnMain.add(lblTitle);
		pnMain.add(pnTabcon);
		pnMain.add(main);
		
		add(pnSide);
		add(pnMain);
		
		this.setLayout(null);
		this.setBounds(330, 110, 700, 500);
		this.setUndecorated(true);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[]args) {
		
		new Students();
		
	}

}
