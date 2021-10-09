import java.sql.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.*;
import java.awt.*;


public class Login extends JFrame{
  Connection con;
  PreparedStatement pst;
  public String type;
  private JLayeredPane pnTop, pnMessage, pnMain;
  private JLabel lblUser, lblPass, lblMsg;
  private JTextField tfUser;
  private JPasswordField pfPass;
  private JButton btnLogin, btnexit, btnMin, btnex; 
  
  public Login(){
	  
	Font font = new Font("Courier New", Font.BOLD, 12);
	//logo
	ImageIcon image = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\stiLogo.png");
	
	//GUIs
	ImageIcon imgExit = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\exit.png");
	ImageIcon exYellow = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\exitYellow.png");
	ImageIcon imgMini = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\minimize.png");
	ImageIcon minYellow = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\minimizeYellow.png");
	
	//ErrorMessage
	ImageIcon red = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\exitRed.png");
	
	//bg
	ImageIcon bg = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\lightspeed-wallpaper-1366x768.jpg");
	
	JLabel stilogo = new JLabel(image);
	stilogo.setBounds(10, 0, 90, 50);
	Border emptyBorder = BorderFactory.createEmptyBorder();	

	JLabel lblbg = new JLabel(bg);
	lblbg.setBounds(0, 0, 430, 400);
	
	pnMain = new JLayeredPane();
	pnMain.setBounds(0, 0, 430, 400);
	pnMain.setOpaque(true);
	
	btnex = new JButton();
	btnex.setBounds(399, 0, 20, 20);
	btnex.setBorder(emptyBorder);
	btnex.setIcon(red);
	btnex.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			pnMessage.setVisible(false);
			
		}
	});
	
	lblMsg = new JLabel();
	lblMsg.setBounds(10, 1, 200, 20);
	lblMsg.setForeground(Color.WHITE);
	
	pnMessage = new JLayeredPane();
	pnMessage.setBounds(0, 65, 430, 20);
	pnMessage.setOpaque(true);
	pnMessage.setBackground(Color.RED);
	
	
	this.addWindowListener(new WindowListener() {
		
		@Override
		public void windowOpened(WindowEvent e) {
			pnMessage.setVisible(false);
			tfUser.requestFocus();
			
		}
		
		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	
	pnTop = new JLayeredPane();
	pnTop.setBounds(0, 0, 430, 65);
	pnTop.setOpaque(true);
	pnTop.setBackground(new Color(10, 61, 115));
	pnTop.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.YELLOW));
	
	lblUser = new JLabel("Username: ");
	lblUser.setBounds(100, 100, 100, 20);
	lblUser.setFont(font);
	
	tfUser = new JTextField();
	tfUser.setBounds(180, 100, 150, 20);
	tfUser.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
	tfUser.setOpaque(false);
	tfUser.setFont(font);
	tfUser.getDocument().addDocumentListener(new DocumentListener() {
		
		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void insertUpdate(DocumentEvent e) {
			if(!tfUser.getText().isEmpty()) {
				pnMessage.setVisible(false);
			}
			
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	
	lblPass = new JLabel("Password: ");
	lblPass.setBounds(100, 150, 100, 20);
	lblPass.setFont(font);
	
	pfPass = new JPasswordField();
	pfPass.setBounds(180, 150, 150, 20);
	pfPass.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
	pfPass.setOpaque(false);
	pfPass.setFont(font);
	pfPass.addKeyListener(new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyPressed(KeyEvent ky) {
			if(ky.getKeyCode() == KeyEvent.VK_ENTER) {
				btnLogin.doClick();
			}
			
		}
	});
	
	btnLogin = new JButton("Login");
	btnLogin.setBounds(205, 200, 80, 30);
	btnLogin.setContentAreaFilled(false);
	btnLogin.setFont(font);
	btnLogin.addActionListener(new ActionListener(){
		
		public void actionPerformed(ActionEvent evt){
			
		try{
				
				String pass = String.valueOf(pfPass.getPassword());
				con = DriverManager.getConnection("jdbc:mysql://localhost/dbenrollment", "root", "");
				pst = con.prepareStatement("SELECT  `username`, `password`, `Name` FROM tbl_users WHERE `username` = ? AND `password` = ?");
				pst.setString(1, tfUser.getText());
				pst.setString(2, String.valueOf(pfPass.getPassword()));
				 
				  ResultSet result = pst.executeQuery();
				
				  if(result.next()){
						  JOptionPane.showMessageDialog(null, "Access Granted");
						  ctrlCenter ct = new ctrlCenter();
						  dispose();		  
				  }
				  else if(tfUser.getText().equals("") || pass.equals("")) {
					  tfUser.requestFocus();
					  pnMessage.setVisible(true);
					  lblMsg.setText("Please fill up the form");
				  }
				  else{ 
					  tfUser.requestFocus();
					  lblMsg.setText("Access Denied!");
					  pnMessage.setVisible(true);
					  tfUser.setText("");
					  pfPass.setText("");
				  }
				  
				}
			catch(SQLException ec){

			}
		
		}

	});
	

	
	btnexit = new JButton();
	btnexit.setBounds(400, 3, 20, 20);
	btnexit.setIcon(imgExit);
	btnexit.setBorder(emptyBorder);
	btnexit.setToolTipText("Exit");
	//btnexit.setCursor(Cursor.CROSSHAIR_CURSOR);
	btnexit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
	});
	btnexit.addMouseListener(new MouseListener() {
		
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
		
			btnexit.setIcon(imgExit);
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			
			btnexit.setIcon(exYellow);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	
	btnMin = new JButton();
	btnMin.setBounds(365, 1, 20, 20);
	btnMin.setIcon(imgMini);
	btnMin.setBorder(emptyBorder);
	btnMin.setToolTipText("Minimize");
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
	
	
	add(pnTop);
	
	pnTop.add(stilogo);
	pnTop.add(btnexit);
	pnTop.add(btnMin);
	
	
	pnMessage.add(lblMsg);
	pnMessage.add(btnex);
	
	pnMain.add(lblUser);
	pnMain.add(tfUser);
	pnMain.add(lblPass);
	pnMain.add(pfPass);
	pnMain.add(btnLogin);
	pnMain.add(lblbg);
	
	add(pnMessage);
	add(pnMain);
	
    this.setLayout(null);
    this.setUndecorated(true);
    this.setBounds(440, 190, 430, 300);
    this.setResizable(false);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public static void main(String[] args) {

      new Login();

  }

}
