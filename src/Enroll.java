import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Enroll extends JFrame{

	private JTextField tfPayValue;
	private JLabel lblImage;
	private JLayeredPane pnSide, pnMain, secPane, thirdPane;
	private JLabel lblTitle;
	private JButton btnSubmit, btnImage;
	private JButton btnExit, btnMin, btnBack;
	String s, path;
	Border brdr = BorderFactory.createEmptyBorder();
	TitledBorder studInfo, famInfo, EdInfom;
	
public Enroll() {
		Border guis = BorderFactory.createLoweredBevelBorder();
		Font f = new Font("Courier New", Font.BOLD, 35);
		Font ff = new Font("Courier New", Font.BOLD, 12);
		MatteBorder mainBorder = BorderFactory.createMatteBorder(15, 15, 15, 15, new Color(160,82,45));
		
		ImageIcon imgPlus = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\addImage.png");
		ImageIcon imgExit = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\exit.png");
		ImageIcon exYellow = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\exitYellow.png");
		ImageIcon imgMini = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\minimize.png");
		ImageIcon minYellow = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\minimizeYellow.png");
		ImageIcon backbtn = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\back.png");
		ImageIcon backHov = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\backHover.png");
		ImageIcon submit = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\if_send_326692.png");
		ImageIcon bg = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\lightspeed-wallpaper-1366x768.jpg");
		
		JLabel main = new JLabel(bg);
		main.setBounds(0, 0, 855, 730);
		
		lblTitle = new JLabel("Enroll");
		lblTitle.setBounds(80, 10, 500, 50);
		lblTitle.setFont(f);
		
		pnMain = new JLayeredPane();
		pnMain.setBounds(0, 0, 855, 730);	
		pnMain.setOpaque(true);
		
		btnExit = new JButton();
		btnExit.setBounds(15, 15, 20, 20);
		btnExit.setIcon(imgExit);
		btnExit.setBorder(brdr);
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
		
		
		pnSide = new JLayeredPane();
		pnSide.setBounds(855, 0, 45, 750);
		pnSide.setOpaque(true);
		pnSide.setBackground(new Color(10, 61, 115));
		pnSide.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, Color.YELLOW));
		
		secPane = new JLayeredPane();
		secPane.setBounds(40, 65, 780, 600);
		secPane.setBorder(mainBorder);
		
		thirdPane = new JLayeredPane();
		thirdPane.setBounds(15, 15, 750, 570);
		thirdPane.setBorder(BorderFactory.createRaisedBevelBorder());
		thirdPane.setOpaque(true);
		thirdPane.setBackground(new Color(222,184,135));
		
		
		btnBack = new JButton();
		btnBack.setBounds(20, 15, 40, 40);
		btnBack.setContentAreaFilled(false);
		btnBack.setIcon(backHov);
		btnBack.setBorder(BorderFactory.createEmptyBorder());
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
							new ctrlCenter();
							dispose();
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
		
		TitledBorder studInfo = BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),"Student Info");
		TitledBorder educBG = BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),"Educational Background");
		TitledBorder fam = BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black),"Family Information");
		
		fam.setTitleJustification(TitledBorder.CENTER);
		educBG.setTitleJustification(TitledBorder.CENTER);
		studInfo.setTitleJustification(TitledBorder.CENTER);
		
		JLayeredPane studPane = new JLayeredPane();
		studPane.setBounds(10, 5, 730, 300);
		studPane.setBorder(studInfo);
		
		JLayeredPane educbg = new JLayeredPane();
		educbg.setBounds(370, 310, 370, 250);
		educbg.setBorder(educBG);
		
		JLayeredPane famInfo = new JLayeredPane();
		famInfo.setBounds(10, 310, 350, 250);
		famInfo.setBorder(fam);
		
		//studentInfo
		
		lblImage = new JLabel();
		lblImage.setBounds(20, 20, 150, 140);
		
		
		btnImage = new JButton(imgPlus);
		btnImage.setBounds(20, 20, 150, 140);
		btnImage.setContentAreaFilled(false);
		btnImage.setBorder(BorderFactory.createDashedBorder(null, 5, 5));
		btnImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooseImage = new JFileChooser();
				chooseImage.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "png");
				chooseImage.addChoosableFileFilter(filter);
				int result = chooseImage.showSaveDialog(null);
				
				if(result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = chooseImage.getSelectedFile();
					path = selectedFile.getAbsolutePath();
					s = path;	
					lblImage.setIcon(ResizeImage(path));
					btnImage.setVisible(false);
					lblImage.setBorder(BorderFactory.createEtchedBorder());
				}
				
			}
		});
		

		JLabel lblFname = new JLabel("First Name: ");
		lblFname.setBounds(200, 30, 200, 25);
		lblFname.setFont(ff);
		
		JTextField tfFname = new JTextField();
		tfFname.setBounds(280, 30, 180, 20);
		tfFname.setFont(ff);
		tfFname.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JLabel lblMname = new JLabel("Middle Name: ");
		lblMname.setBounds(193, 60, 200, 25);
		lblMname.setFont(ff);
	
		JTextField tfMname = new JTextField();
		tfMname.setBounds(280, 60, 180, 20);
		tfMname.setFont(ff);
		tfMname.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JLabel lblLname = new JLabel("Last Name: ");
		lblLname.setBounds(208, 90, 200, 25);
		lblLname.setFont(ff);
	
		JTextField tfLname = new JTextField();
		tfLname.setBounds(280, 90, 180, 20);
		tfLname.setFont(ff);
		tfLname.setBorder(BorderFactory.createLoweredBevelBorder());
	
		JLabel lblAddress = new JLabel();
		lblAddress = new JLabel("Address: ");
		lblAddress.setBounds(200, 100,150, 80);
		lblAddress.setFont(ff);

		JTextArea txtAddress = new JTextArea();
		txtAddress.setBorder(BorderFactory.createLoweredBevelBorder());
		txtAddress.setFont(ff);
		txtAddress.setLineWrap(true);
		txtAddress.setWrapStyleWord(true);
		
		JScrollPane scrlAddress = new JScrollPane(txtAddress);
		scrlAddress.setBounds(260, 130, 200, 50);
		 	

		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setBounds(480, 20, 200, 20);
		lblCourse.setFont(ff);
		
		String[] courseList = {"Select Course","ABM", "CA", "GAS","ICT", "RBO", "STEM", "TO", "BS TOURISM MANAGEMENT", "BS BUSINESS MANAGEMENT", "BS ACCOUNTING TECHNOLOGY", "BS COMPUTER SCIENCE", "BS COMPUTER ENGINEERING", "BS INFORMATION TECHNOLOGY"};
		JComboBox boxCourse = new JComboBox(courseList);
		boxCourse.setBounds(480, 40, 220, 26);
		boxCourse.setFont(ff);
		boxCourse.setBorder(BorderFactory.createRaisedBevelBorder());
		
		JLabel lblReligion = new JLabel("Religion: ");
		lblReligion.setBounds(501,80, 100, 20);
		lblReligion.setFont(ff);
		
		JTextField tfRel = new JTextField();
		tfRel.setBounds(565, 80, 100, 20);
		tfRel.setBorder(guis);
		tfRel.setFont(ff);
		
		JLabel lblCitizenship = new JLabel("Citizenship: ");
		lblCitizenship.setBounds(480, 120, 200, 20);
		lblCitizenship.setFont(ff);
		
		JTextField tfCp = new JTextField();
		tfCp.setBounds(565, 118, 135, 20);
		tfCp.setFont(ff);
		tfCp.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JLabel lblSex = new JLabel("Gender: ");
		lblSex.setBounds(515, 160, 100, 20);
		lblSex.setFont(ff);
		
		String[] Gndr = {"", "Male", "Female"};
		JComboBox boxGndr = new JComboBox(Gndr);
		boxGndr.setBounds(567, 158, 100, 25);
		boxGndr.setBorder(BorderFactory.createRaisedBevelBorder());
		boxGndr.setFont(ff);
		

		JLabel lblBday = new JLabel("Birthday: ");
		lblBday.setBounds(40,190, 100, 20 );
		lblBday.setFont(ff);
		
		JDateChooser clndrbday = new JDateChooser();
		clndrbday.setDateFormatString("yyyy-MM-dd");
		clndrbday.setBounds(115, 190, 200, 20);
		clndrbday.setFont(ff);
		
		JLabel lblbPlace = new JLabel("BirthPlace: ");
		lblbPlace.setBounds(25, 225, 200, 20);
		lblbPlace.setFont(ff);
		
		JTextField tfbPlace = new JTextField();
		tfbPlace.setBounds(115, 225, 185, 20);
		tfbPlace.setFont(ff);
		tfbPlace.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JLabel lblcntctNo = new JLabel("Contact No: ");
		lblcntctNo.setBounds(25, 260, 300, 20);
		lblcntctNo.setFont(ff);
		
		JTextField tfcntctNo = new JTextField();
		tfcntctNo.setBounds(115, 260, 185, 20);
		tfcntctNo.setFont(ff);
		tfcntctNo.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JLabel lblType = new JLabel("Payment Type: ");
		lblType.setBounds(340, 210, 100, 20);
		lblType.setFont(ff);
		
		String[] paymentMethod = {"", "Cash", "Installment"};
		JComboBox boxPayment = new JComboBox(paymentMethod);
		boxPayment.setBounds(440, 210, 100, 20);
		
		JLabel lblValue = new JLabel("Payment Value: ");
		lblValue.setBounds(340, 250, 200, 20);
		lblValue.setFont(ff);
		
		tfPayValue = new JTextField();
		tfPayValue.setBounds(440, 250, 100, 20);
		tfPayValue.setFont(ff);

		
	
		//educBg
		
		JLabel pEduc = new JLabel("Primary Education: ");
		pEduc.setBounds(10, 30, 200, 20);
		pEduc.setFont(new Font("Courier New", Font.BOLD, 12));
		
		JTextField tfpEduc = new JTextField();
		tfpEduc.setBounds(10, 50, 320, 20);
		tfpEduc.setFont(new Font("Courier New", Font.BOLD, 12));
		tfpEduc.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JLabel lblpeducIY = new JLabel("Inclusive Year: ");
		lblpeducIY.setBounds(10, 80, 200, 20);
		lblpeducIY.setFont(new Font("Courier New", Font.BOLD, 12));
		
		JTextField tfpeducIY = new JTextField();
		tfpeducIY.setBounds(10, 100, 70, 20);
		tfpeducIY.setFont(new Font("Courier New", Font.BOLD, 12));
		
		JLabel sEduc = new JLabel("Secondary Education: ");
		sEduc.setBounds(10, 130, 200, 20);
		sEduc.setFont(new Font("Courier New", Font.BOLD, 12));
		
		JTextField tfsEduc = new JTextField();
		tfsEduc.setBounds(10, 150, 320, 20);
		tfsEduc.setFont(new Font("Courier New", Font.BOLD, 12));
		tfsEduc.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JLabel lblseducIY = new JLabel("Inclusive Year: ");
		lblseducIY.setBounds(10, 180, 200, 20);
		lblseducIY.setFont(new Font("Courier New", Font.BOLD, 12));
		
		
		JTextField tfseducIY = new JTextField();
		tfseducIY.setBounds(10, 200, 70, 20);
		tfseducIY.setFont(new Font("Courier New", Font.BOLD, 12));
		
		//famInfo
		
		JLabel lblFatherName = new JLabel("Father's Name:");
		lblFatherName.setBounds(10, 30, 200, 20);
		lblFatherName.setFont(new Font("Courier New", Font.BOLD, 12));
		
		JTextField tfFatherName = new JTextField();
		tfFatherName.setBounds(10, 50, 320, 20);
		tfFatherName.setFont(new Font("Courier New", Font.BOLD, 12));
		tfFatherName.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JLabel lblFatherOcc = new JLabel("Occupation: ");
		lblFatherOcc.setBounds(10, 80, 200, 20);
		lblFatherOcc.setFont(new Font("Courier New", Font.BOLD, 12));
		
		JTextField tfFatherOcc = new JTextField();
		tfFatherOcc.setBounds(10, 100, 320, 20);
		tfFatherOcc.setFont(new Font("Courier New", Font.BOLD, 12));
		tfFatherOcc.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JLabel lblMotherName = new JLabel("Mother's Name:");
		lblMotherName.setBounds(10, 130, 200, 20);
		lblMotherName.setFont(new Font("Courier New", Font.BOLD, 12));
		
		JTextField tfMotherName = new JTextField();
		tfMotherName.setBounds(10, 150, 320, 20);
		tfMotherName.setFont(new Font("Courier New", Font.BOLD, 12));
		tfMotherName.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JLabel lblMotherOcc = new JLabel("Occupation: ");
		lblMotherOcc.setBounds(10, 180, 200, 20);
		lblMotherOcc.setFont(new Font("Courier New", Font.BOLD, 12));
		
		JTextField tfMotherOcc = new JTextField();
		tfMotherOcc.setBounds(10, 200, 320, 20);
		tfMotherOcc.setFont(new Font("Courier New", Font.BOLD, 12));
		tfMotherOcc.setBorder(BorderFactory.createLoweredBevelBorder());
		
		//submit
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(670, 680, 150, 40);
		btnSubmit.setIcon(submit);
		btnSubmit.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		btnSubmit.setContentAreaFilled(false);
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
			    String d = sdf.format(clndrbday.getDate());
			    try {

					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dbenrollment","root","");
		             PreparedStatement ps = con.prepareStatement("insert into tbl_students(Course, Religion, FirstName, MiddleName, LastName, Address, Birthday, Citizenship, Gender, ContactNo, FatherName, FatherOccupation, MotherName,MotherOccupation, pEduc, pEducIY, sEduc, sEducIY, StudentImage, PaymentType, PaymentValue) values(?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ? ,?, ?, ?, ?, ? ,?, ?, ?, ?, ?)");
		             PreparedStatement psid = con.prepareStatement("SELECT MAX(ID) FROM tbl_Students");
		             InputStream is = new FileInputStream(new File(s));
					 
					 
					 ps.setString(1, boxCourse.getSelectedItem().toString());
					 ps.setString(2, tfRel.getText());
					 ps.setString(3, tfFname.getText());
					 ps.setString(4, tfMname.getText());
					 ps.setString(5, tfLname.getText());
					 ps.setString(6, txtAddress.getText());
					 ps.setString(7, d);
					 ps.setString(8, tfCp.getText());
					 ps.setString(9, boxGndr.getSelectedItem().toString());
					 ps.setString(10, tfcntctNo.getText());
					 ps.setString(11, tfFatherName.getText());
					 ps.setString(12, tfFatherOcc.getText());
					 ps.setString(13, tfMotherName.getText());
					 ps.setString(14, tfMotherOcc.getText());
					 ps.setString(15, tfpEduc.getText());
					 ps.setString(16, tfpeducIY.getText());
					 ps.setString(17, tfsEduc.getText());
					 ps.setString(18, tfseducIY.getText());
					 ps.setBlob(19, is);
					 ps.setString(20, boxPayment.getSelectedItem().toString());
					 ps.setString(21, tfPayValue.getText());

					 ps.executeUpdate();
					 ResultSet set = psid.executeQuery();
					 
					 if(set.next()) {
						 String id = set.getString(1);  
						
						JOptionPane.showMessageDialog(null, "Enrolled Successfully!" + "Your Student Id: " + id);
					 }
					
					
				
			    	
			    }catch (SQLException | FileNotFoundException exx) {
					
					
				}
				
			}
		});
		
		
		//ADD COMPONENTS
				famInfo.add(tfMotherOcc);
				famInfo.add(lblMotherOcc);
				famInfo.add(tfMotherName);
				famInfo.add(lblMotherName);
				famInfo.add(tfFatherOcc);
				famInfo.add(lblFatherOcc);
				famInfo.add(lblFatherName);
				famInfo.add(tfFatherName);
				educbg.add(tfseducIY);
				educbg.add(lblseducIY);
				educbg.add(tfsEduc);
				educbg.add(sEduc);
				educbg.add(tfpeducIY);
				educbg.add(lblpeducIY);
				educbg.add(tfpEduc);
				educbg.add(pEduc);
				
				studPane.add(btnSubmit);
				studPane.add(tfPayValue);
				studPane.add(lblValue);
				studPane.add(boxPayment);
				studPane.add(lblType);
				studPane.add(tfcntctNo);
				studPane.add(lblcntctNo);
				studPane.add(tfbPlace);
				studPane.add(lblbPlace);
				studPane.add(clndrbday);
				studPane.add(lblBday);
				studPane.add(boxGndr);
				studPane.add(lblSex);
				studPane.add(tfCp);
				studPane.add(lblCitizenship);
				studPane.add(scrlAddress);
				studPane.add(lblAddress);
				studPane.add(tfRel);
				studPane.add(lblReligion);
				studPane.add(boxCourse);
				studPane.add(lblCourse);
				studPane.add(tfLname);
				studPane.add(lblLname);
				studPane.add(tfMname);
				studPane.add(lblMname);
				studPane.add(tfFname);
				studPane.add(lblFname);
				studPane.add(btnImage);
				studPane.add(lblImage);				
			
				
				thirdPane.add(famInfo);
				thirdPane.add(educbg);
				thirdPane.add(studPane);
				secPane.add(thirdPane);
				
				
				pnMain.add(lblTitle);
				pnMain.add(btnBack);
				pnMain.add(secPane);
				pnMain.add(main);
				
				add(btnSubmit);
				add(pnSide);
				add(pnMain);
				
				pnSide.add(btnExit);
				pnSide.add(btnMin);
				
		
		this.setLayout(null);
	    this.getContentPane().setBackground(Color.WHITE);
		this.setBounds(265, 0, 900, 730);
	    this.setUndecorated(true);
	    this.setResizable(false);
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public ImageIcon ResizeImage(String imgPath){
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }
	

	public static void main(String[] args) {
		
		new Enroll();

	}

}
