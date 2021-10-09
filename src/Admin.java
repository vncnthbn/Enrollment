import javax.swing.*;
import javax.swing.border.Border;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Admin extends JFrame{

	private JButton btnBack, btnExit, btnMin;
	private JLabel lblTitle;
	public JTable tblUsers;
	Connection connection;
	PreparedStatement pst;
	ResultSet set;
	public Admin() {
		Font f = new Font("Courier New", Font.BOLD, 30);
		Border brdr = BorderFactory.createEmptyBorder();
		//bg
		ImageIcon conImg = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\lightspeed-wallpaper-1366x768.jpg");
		
		//gui
		ImageIcon backbtn = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\back.png");
		ImageIcon backHov = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\backHover.png");
		ImageIcon imgExit = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\exit.png");
		ImageIcon exYellow = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\exitYellow.png");
		ImageIcon imgMini = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\minimize.png");
		ImageIcon minYellow = new ImageIcon("C:\\Users\\owner\\Documents\\EclipseWorkspace\\Enrollment\\sources\\minimizeYellow.png");
		
		lblTitle = new JLabel("Account Settings");
		lblTitle.setBounds(80, 20, 500, 30);
		lblTitle.setFont(f);
			
		JLabel lblBg = new JLabel(conImg);
		lblBg.setBounds(0, 0, 894, 530);
		
		JLayeredPane pnCon = new JLayeredPane();
		pnCon.setBounds(0, 0, 894, 530);
		pnCon.setOpaque(true);
		
		//GUIS
		
		JLabel lblId = new JLabel("User's ID: ");
		lblId.setFont(new Font("Courier New", Font.BOLD, 12));
		lblId.setBounds(20, 100, 100, 20);
		
		JLabel lblIdval = new JLabel("Sample id ");
		lblIdval.setFont(new Font("Courier New", Font.BOLD, 12));
		lblIdval.setBounds(100, 100, 100, 20);
		
		JLabel lbluser = new JLabel("Name: ");
		lbluser.setFont(new Font("Courier New", Font.BOLD, 12));
		lbluser.setBounds(20, 140, 100, 20);
		
		JTextField tfUser = new JTextField();
		tfUser.setFont(new Font("Courier New", Font.BOLD, 12));
		tfUser.setBounds(20, 160, 150, 20);
		
		JLabel lblusername = new JLabel("Username: ");
		lblusername.setFont(new Font("Courier New", Font.BOLD, 12));
		lblusername.setBounds(20, 200, 100, 20);
		
		JTextField tfUsername = new JTextField();
		tfUsername.setFont(new Font("Courier New", Font.BOLD, 12));
		tfUsername.setBounds(20, 220, 150, 20);
		
		JLabel lblpass = new JLabel("Password: ");
		lblpass.setFont(new Font("Courier New", Font.BOLD, 12));
		lblpass.setBounds(20, 260, 100, 20);
		
		JTextField tfpass = new JTextField();
		tfpass.setFont(new Font("Courier New", Font.BOLD, 12));
		tfpass.setBounds(20, 280, 150, 20);
		
		JButton btnCreate = new JButton("Create Account");
		btnCreate.setBounds(700, 20, 140, 40);
		btnCreate.setContentAreaFilled(false);
		btnCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new addAccount();
			}
		});
		
		JButton btnUpdate = new JButton("Update Account");
		btnUpdate.setBounds(20, 330, 150, 40);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost/dbenrollment", "root", "");
				pst = connection.prepareStatement("UPDATE tbl_users SET NAME = ?, Username = ?, Password = ? WHERE ID = ?");
				
					if(lblIdval.getText().equals("")) {
							
						JOptionPane.showMessageDialog(null, "There's Nothing to Update");
						
					}
					else {
						pst.setString(1, tfUser.getText());
						pst.setString(2, tfUsername.getText());
						pst.setString(3, tfpass.getText());
						pst.setString(4, lblIdval.getText());
						
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Updated Successfully!");
						showdata(tblUsers);
					}
				
				}
				catch (SQLException eSA) {
					
				}
				
			}
		});

		JButton btnDelete = new JButton("Delete Account");
		btnDelete.setBounds(20, 390, 150, 40);
		btnDelete.setContentAreaFilled(false);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost/dbenrollment", "root", "");
					pst = connection.prepareStatement("DELETE FROM tbl_users WHERE ID = ?");
					pst.setString(1, lblIdval.getText());
					
					if(lblIdval.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "There's Nothing to Delete");
					}
					else {
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Deleted Successfully!");
						showdata(tblUsers);
						
						lblIdval.setText("");
						tfUser.setText("");
						tfUsername.setText("");
						tfpass.setText("");
						
						dis(tfUser, tfUsername, tfpass);
					}
				}
				catch (SQLException e1) {
					
				}
				
			}
		});
		
		JButton btnRefresh = new JButton("Refresh Table");
		btnRefresh.setBounds(20, 450, 150, 40);
		btnRefresh.setContentAreaFilled(false);
		btnRefresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showdata(tblUsers);
				
			}
		});
		
		//GUIS
		
		JLayeredPane pnSide = new JLayeredPane(); 
		pnSide.setBounds(895, 0, 45, 530);
		pnSide.setOpaque(true);
		pnSide.setBackground(new Color(10, 61, 115));
		pnSide.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.YELLOW));
		
		JLayeredPane pnMain = new JLayeredPane();
		pnMain.setBounds(230, 75, 630, 425);
		pnMain.setOpaque(true);
		pnMain.setBackground(new Color(160,82,45));
				
		JLayeredPane pnInside = new JLayeredPane();
		pnInside.setBounds(10, 10, 610, 405);
		pnInside.setOpaque(true);
		pnInside.setBackground(new Color(222,184,135));
		pnInside.setBorder(BorderFactory.createRaisedBevelBorder());
		
		tblUsers = new JTable(null);
		tblUsers.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblUsers.setBounds(23, 23, 565, 360);
		tblUsers.setRowHeight(30);
		tblUsers.addMouseListener(new MouseListener() {
			
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
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = tblUsers.getSelectedRow();
					String tblclick = (tblUsers.getModel().getValueAt(row, 0).toString());
					pst = connection.prepareStatement("SELECT * FROM tbl_Users WHERE ID ='"+tblclick+"'");
					set = pst.executeQuery();
					
					if(set.next()) {
						String id = set.getString("ID");
						String Name = set.getString("Name");
						String username = set.getString("Username");
						String password = set.getString("Password");
						
						lblIdval.setText(id);
						tfUser.setText(Name);
						tfUsername.setText(username);
						tfpass.setText(password);
						
						tfUser.setEnabled(true);
						tfUsername.setEnabled(true);
						tfpass.setEnabled(true);
					}
				}
				catch (SQLException e1) {
				
				}
				
			}
		});
				
		JScrollPane scrlpn = new JScrollPane(tblUsers);
		scrlpn.setBounds(23, 23, 565, 360);
				
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				showdata(tblUsers);
				lblIdval.setText("");
				dis(tfUser, tfpass, tfUsername);
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
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
		
		pnSide.add(btnMin);
		pnSide.add(btnExit);
		
		pnInside.add(scrlpn);
		pnMain.add(pnInside);
		
		pnCon.add(btnRefresh);
		pnCon.add(btnCreate);
		pnCon.add(btnDelete);
		pnCon.add(btnUpdate);
		pnCon.add(tfpass);
		pnCon.add(lblpass);
		pnCon.add(tfUsername);
		pnCon.add(lblusername);
		pnCon.add(tfUser);
		pnCon.add(lbluser);
		pnCon.add(lblIdval);
		pnCon.add(lblId);
		pnCon.add(pnMain);
		pnCon.add(lblTitle);
		pnCon.add(btnBack);
		pnCon.add(lblBg);
		
		add(pnSide);
		add(pnCon);
		this.setUndecorated(true);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setBounds(225, 100, 940, 530);
		
	}
	
	public static void main(String[]arg) {
		
		new Admin();
		
	}
	
	public void dis(JTextField tf1,JTextField tf2, JTextField tf3) {
		
		tf1.setEnabled(false);
		tf2.setEnabled(false);
		tf3.setEnabled(false);
		
	}
	
	public void showdata(JTable tblsample) {
		try {				
			connection = DriverManager.getConnection("jdbc:mysql://localhost/dbenrollment", "root", "");
			pst = connection.prepareStatement("SELECT * FROM tbl_Users");
			set= pst.executeQuery();
			
			tblsample.setModel(DbUtils.resultSetToTableModel(set));
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
