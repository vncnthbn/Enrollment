import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class ctrlCenter extends JFrame{
	
	private JButton btnExit, btnMin;
	private JLayeredPane pnSide, pnMain;
	public JLabel lblStiCreed, lblTime, lblDate;
	public JButton btnEnroll, btnCashier, btnStudents, btnAccSettings;
	
	public ctrlCenter() {
		Font font = new Font("Courier New", Font.BOLD, 12);
		Border brdr = BorderFactory.createEmptyBorder();
		//GUIS
		ImageIcon imgExit = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\exit.png");
		ImageIcon exYellow = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\exitYellow.png");
		ImageIcon imgMini = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\minimize.png");
		ImageIcon minYellow = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\minimizeYellow.png");
		
		//btn
		
		ImageIcon addStudent = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\EnrollStuds.png");
		ImageIcon Cashier = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\Cahsier.png");
		ImageIcon sec = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\sections.png");
		ImageIcon admin = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\Administrator.png");
		
		//logo
		ImageIcon logo = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\logoctrl.png");
		JLabel lg = new JLabel(logo);
		lg.setBounds(10, 20, 200, 100);
		
		//bg 
		ImageIcon bg = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\lightspeed-wallpaper-1366x768.jpg");
		JLabel main = new JLabel(bg);
		main.setBounds(0, 0, 655, 500);
		
		lblDate = new JLabel();
		lblDate.setBounds(499, 15, 400, 20);
		lblDate.setFont(new Font("Courier New", Font.BOLD, 12));
		
		lblTime = new JLabel();
		lblTime.setBounds(499, 40, 400, 20);
		lblTime.setFont(new Font("Courier New", Font.BOLD, 12));
		
		lblStiCreed = new JLabel("<html>STIer's Creed</br><p><br> I am an STIer, I am here to learn.</br><br>I thirst for knowledge and skills that</br> <br>will make me a leader of tomorrow.</br></p><p><br>I am an STIer, I keep an open mind.</br> <br>I challenge every knowledge i seek</br> <br>and understand</br></p> <p><br>I am an STIer, i embrace change.</br> <br>I continuously reinvent myself</br></p> <p> <br>I am an STIer, I am a person of character.</br> <br>I speak, I act, and I live for the common good.</br></p> <p> <br>I am an STIer, I am determined.</br> <br>I accept the challenge to become</br> <br>the best that i can be.</br></p> <p><br>I am an STIer, a proud STIer!</br></p></html>");
		lblStiCreed.setBounds(280, 10, 300, 500);
		lblStiCreed.setForeground(Color.BLACK);
		lblStiCreed.setFont(font);
				
		pnMain = new JLayeredPane();
		pnMain.setBounds(0, 0, 655, 500);	
		pnMain.setOpaque(true);
		
		
		pnSide = new JLayeredPane();
		pnSide.setBounds(655, 0, 45, 500);
		pnSide.setOpaque(true);
		pnSide.setBackground(new Color(10, 61, 115));
		pnSide.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.YELLOW));
				
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
		
		
		btnEnroll = new JButton("Enroll Student");
		btnEnroll.setBounds(20, 170, 190, 50);
		btnEnroll.setContentAreaFilled(false);
		btnEnroll.setIcon(addStudent);
		btnEnroll.setFont(font);
		btnEnroll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Enroll();
				dispose();
				
			}
		});
		
		btnCashier = new JButton("Cashier");
		btnCashier.setBounds(20, 240, 190, 50);
		btnCashier.setContentAreaFilled(false);
		btnCashier.setIcon(Cashier);
		btnCashier.setFont(font);
		btnCashier.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Billing();
				dispose();
				
			}
		});
		
		btnStudents = new JButton("Students");
		btnStudents.setBounds(20, 313, 190, 50);
		btnStudents.setContentAreaFilled(false);
		btnStudents.setIcon(sec);
		btnStudents.setFont(font);
		btnStudents.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Students();
				dispose();
				
			}
		});
		
		btnAccSettings = new JButton("Account Settings");
		btnAccSettings.setBounds(20, 383, 190, 50);
		btnAccSettings.setContentAreaFilled(false);
		btnAccSettings.setIcon(admin);
		btnAccSettings.setFont(font);
		btnAccSettings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Admin();
				dispose();			
			}
		});
		
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				clock();
				
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
		
		pnSide.add(btnMin);
		pnSide.add(btnExit);
				
		pnMain.add(lblDate);
		pnMain.add(lblTime);	
		pnMain.add(lblStiCreed);
		pnMain.add(lg);
		pnMain.add(btnAccSettings);
		pnMain.add(btnStudents);
		pnMain.add(btnCashier);
		pnMain.add(btnEnroll);
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
	
	public void clock() {
		Thread t = new Thread() {
			public void run() {
				
				try {
					for (;;) {
						Calendar cl = new GregorianCalendar();
						SimpleDateFormat sdf  = new SimpleDateFormat("MMM dd, yyyy");
						String formatted = sdf.format(cl.getTime());
				
						int hour = cl.get(Calendar.HOUR);
						int minute = cl.get(Calendar.MINUTE);
						int sec = cl.get(Calendar.SECOND);
						
						lblDate.setText("Date: " + formatted);
						lblTime.setText("Time: " + hour + ":" + minute + ":" + sec);
						
						
						sleep(1000);
						
					}
				} 
				catch (InterruptedException e) {
				
				}
				
			}
		};
		t.start();
	}
}
