import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class School_Management implements MouseListener,ActionListener{

	JFrame f1;
	JPanel p1,p2,p3,p4,p30,p31,p32,p33,p40,p41,p42,p43;
	JMenuBar mb1;
	JMenu m1,m2,m3,m4,m5,m6,m7;
	JMenuItem mi11,mi12,mi21,mi22,mi23,mi31,mi32,mi41,mi42,mi51;
	JLabel l1,l2,l3,l4,l5,l301,l302,l311,l312,l313,l321,l322,l323,l331,l332,l333,l40,l41,email,contact,logout;
	Font fo1,fo2,fo3,fo4;
	String logo_address,School_Name,School_Address,Email,Contact,Students,boys,girls,url1,path1,bg;
	Connection con1,con2;
	FileDialog fd1;
	ImageIcon i1,img1;
	
	public School_Management() {
		f1=new JFrame("School Management");
		
		path1="C:/Users/LENOVO/workspace/eclipse/School Management/DateBase/School_Detail.accdb";
		url1="jdbc:ucanaccess://"+path1;
		
		fo1=new Font("Old English Text MT",Font.BOLD,72);
		fo2=new Font("Serif",Font.BOLD,25);
		fo3=new Font("Bell MT",Font.PLAIN,20);
		fo4=new Font("Bell MT",Font.BOLD,20);
		
//		"<HTML><a href=sangam.modern.school.chapra@gmail.com>sangam.modern.school.chapra@gmail.com</a></HTML>"
		
		try{
			con1=DriverManager.getConnection(url1);
			String sql1="SELECT * FROM School_Details";
			Statement st1=con1.createStatement();
			ResultSet rs1=st1.executeQuery(sql1);
			if(rs1.next()){
				School_Name=rs1.getString("School_Name");
				School_Address=rs1.getString("Address1")+", "+rs1.getString("State")+", "+rs1.getString("Pin_Code");
				Email="<HTML><a href="/*+rs1.getString("Email_Id")*/+'>'+rs1.getString("Email_Id")+"</a></HTML>";
				Contact=rs1.getString("Contact_No1");
				logo_address=rs1.getString("School_Logo");
			}
			String sql2="SELECT COUNT(Roll) FROM Student_Admission";
			Statement st2=con1.createStatement();
			ResultSet rs2=st2.executeQuery(sql2);
			if(rs2.next()){
				Students=rs2.getString(1);
			}
			
			String sql3="SELECT COUNT(Gender) FROM Student_Admission Where Gender='"+"Male"+"'";
			Statement st3=con1.createStatement();
			ResultSet rs3=st3.executeQuery(sql3);
			if(rs3.next()){
				boys=rs3.getString(1);
			}
			String sql4="SELECT COUNT(Gender) FROM Student_Admission Where Gender='"+"Female"+"'";
			Statement st4=con1.createStatement();
			ResultSet rs4=st4.executeQuery(sql4);
			if(rs4.next()){
				girls=rs4.getString(1);
			}
			con1.close();
		}
		catch(Exception e1){
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		
		p1=new JPanel();
		p1.setBounds(0, 0, 1200, 150);
		p1.setLayout(null);
		f1.add(p1);
		
		l1=new JLabel();//l1 for Logo of School;
		l1.setBounds(10, 0, 150, 150);
		p1.add(l1);
		
		ImageIcon img1=new ImageIcon(logo_address);
		Image img2=img1.getImage().getScaledInstance(l1.getWidth()-10, l1.getHeight()-20, Image.SCALE_SMOOTH);
		ImageIcon i=new ImageIcon(img2);
		l1.setIcon(i);
		
		l2=new JLabel(School_Name);//l2 for Name of School;
		l2.setFont(fo1);
		l2.setBounds(600-((School_Name.length()*20)), 0, 1050, 100);
		p1.add(l2);
		
		l3=new JLabel(School_Address);//l3 for Address of School;
		l3.setFont(fo2);
		l3.setBounds((600-(School_Address.length()*6)), 80, 1050, 50);
		p1.add(l3);
	
		l4=new JLabel("e-mail id :");
		l4.setFont(fo3);
		l4.setBounds(200, 125, 150, 25);
		p1.add(l4);
		
		email=new JLabel(Email);
		email.setFont(fo4);
		email.setBounds(310, 125, 450, 25);
		p1.add(email);
		
		l5=new JLabel("Contact No. :");
		l5.setFont(fo3);
		l5.setBounds(900, 125, 150, 25);
		p1.add(l5);
		
		contact=new JLabel(Contact);
		contact.setFont(fo4);
		contact.setBounds(1030, 125, 150, 25);
		p1.add(contact);
		
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(0, 150, 1200, 50);
		p2.setBackground(Color.green);
		
		mb1=new JMenuBar();
		mb1.setLayout(null);
		mb1.setBounds(0, 0, 1200, 50);
		p2.add(mb1);
		
		m1=new JMenu("User");
		m1.setFont(fo3);
		m1.setBounds(0, 0, 100, 50);
		mb1.add(m1);
		
		mi11=new JMenuItem("Change Password");
		mi11.addActionListener(this);
		mi11.setFont(fo3);
		m1.add(mi11);
		
		mi12=new JMenuItem("Edit Profile");
		mi12.setFont(fo3);
		mi12.addActionListener(this);
//		m1.add(mi12);
		
		m2=new JMenu("Fee");
		m2.setFont(fo3);
		m2.setBounds(100, 0, 100, 50);
		mb1.add(m2);
		
		mi21=new JMenuItem("Fee Particular");
		mi21.addActionListener(this);
		mi21.setFont(fo3);
		m2.add(mi21);
		
		mi22=new JMenuItem("Fee Creation");
		mi22.addActionListener(this);
		mi22.setFont(fo3);
		m2.add(mi22);
		
		mi23=new JMenuItem("Monthly Fee Creation");
		mi23.addActionListener(this);
		mi23.setFont(fo3);
		m2.add(mi23);
		
		m3=new JMenu("Admission");
		m3.setFont(fo3);
		m3.setBounds(200, 0, 150, 50);
		mb1.add(m3);
		
		mi31=new JMenuItem("New Admission");
		mi31.addActionListener(this);
		mi31.setFont(fo3);
		mi31.addActionListener(this);
		m3.add(mi31);
		
		mi32=new JMenuItem("");
		mi32.addActionListener(this);
		mi32.setFont(fo3);
		m3.add(mi32);
		
		m4=new JMenu("Payment");
		m4.setFont(fo3);
		m4.setBounds(350, 0, 150, 50);
		mb1.add(m4);
		
		mi41=new JMenuItem("Monthly Payment");
		mi41.addActionListener(this);
		mi41.setFont(fo3);
		m4.add(mi41);
		
		mi42=new JMenuItem("Payment Details");
		mi42.addActionListener(this);
		mi42.setFont(fo3);
		m4.add(mi42);
		
		m5=new JMenu("Student");
		m5.setFont(fo3);
		m5.setBounds(500, 0, 150, 50);
		mb1.add(m5);
		
		mi51=new JMenuItem("Student Details");
		mi51.addActionListener(this);
		mi51.setFont(fo3);
		m5.add(mi51);
		
		
		logout=new JLabel(new ImageIcon("images/logout.png"));
		logout.setToolTipText("Logout");
		logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logout.setBounds(1150, 0, 30, 50);
		logout.addMouseListener(this);
		mb1.add(logout);
		
		p3=new JPanel();
		p3.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.gray));
		p3.setBounds(0, 200, 400, 690);
		p3.setLayout(null);
		f1.add(p3);
		
		p30=new JPanel();
		p30.setBackground(new Color(240,255,255));
		p30.setBounds(80, 10, 300, 100);
		p30.setLayout(null);
		p3.add(p30);
		
		l301=new JLabel("Home");
		l301.setFont(new Font("Serif",Font.BOLD,30));
		l301.setBounds(50, 25, 100, 50);
		p30.add(l301);
		
		l302=new JLabel(new ImageIcon("images/home.png"));
		l302.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l302.addMouseListener(this);
		l302.setBounds(200, 10, 80, 80);
		p30.add(l302);
		
		p31=new JPanel();
		p31.setBackground(new Color(255,250,240));
		p31.setBounds(10, 150, 300, 100);
		p31.setLayout(null);
		p3.add(p31);
		
		l311=new JLabel("Total Number of Students");
		l311.setFont(new Font("Serif",Font.BOLD,20));
		l311.setBounds(0, 0, 225, 50);
		p31.add(l311);
		
		l312=new JLabel(Students);
		l312.setFont(new Font("Serif",Font.BOLD,25));
		l312.setForeground(Color.BLUE);
		l312.setVisible(false);
		l312.setBounds(110, 50, 150, 50);
		p31.add(l312);
		
		l313=new JLabel(new ImageIcon("images/student.png"));
		l313.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l313.addMouseListener(this);
		l313.setBounds(225, 10, 75, 75);
		p31.add(l313);
		
		p32=new JPanel();
		p32.setBackground(new Color(255,255,224));
		p32.setBounds(80, 300, 300, 100);
		p32.setLayout(null);
		p3.add(p32);
		
		l321=new JLabel("Total Number of Boys");
		l321.setFont(new Font("Serif",Font.BOLD,20));
		l321.setBounds(100, 0, 200, 50);
		p32.add(l321);
		
		l322=new JLabel(boys);
		l322.setFont(new Font("Serif",Font.BOLD,25));
		l322.setForeground(Color.BLUE);
		l322.setVisible(false);
		l322.setBounds(160, 50, 150, 50);
		p32.add(l322);
		
		l323=new JLabel(new ImageIcon("images/boys.png"));
		l323.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l323.addMouseListener(this);
		l323.setBounds(10, 10, 75, 75);
		p32.add(l323);
		
		p33=new JPanel();
		p33.setBackground(new Color(255,255,224));
		p33.setBounds(80, 450, 300, 100);
		p33.setLayout(null);
		p3.add(p33);
		
		l331=new JLabel("Total Number of Girls");
		l331.setFont(new Font("Serif",Font.BOLD,20));
		l331.setBounds(100, 0, 200, 50);
		p33.add(l331);
		
		l332=new JLabel(girls);
		l332.setFont(new Font("Serif",Font.BOLD,25));
		l332.setForeground(Color.BLUE);
		l332.setVisible(false);
		l332.setBounds(160, 50, 150, 50);
		p33.add(l332);
		
		l333=new JLabel(new ImageIcon("images/girls.png"));
		l333.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l333.addMouseListener(this);
		l333.setBounds(10, 10, 75, 75);
		p33.add(l333);
		
		p4=new JPanel();
		p4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.darkGray));
		p4.setBounds(400, 200, 794, 688);
		p4.setLayout(null);
		f1.add(p4);
		
		l40=new JLabel();
		l40.setBounds(0, 0, 794, 688);
		p4.add(l40);
		
		try{
			con1=DriverManager.getConnection(url1);
			String sql1="SELECT Background FROM BackGround ";
			Statement st1=con1.createStatement();
			ResultSet rs1=st1.executeQuery(sql1);
			if(rs1.next()){
				bg=rs1.getString(1);
				
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		fd1=new FileDialog(f1,"Open",FileDialog.LOAD);
		
		ImageIcon img11=new ImageIcon(bg);
		Image img21=img11.getImage().getScaledInstance(l40.getWidth(), l40.getHeight(), Image.SCALE_SMOOTH);
		i1=new ImageIcon(img21);
		l40.setIcon(i1);
		
		l41=new JLabel(new ImageIcon("images/image_editing.png"));
		l41.setToolTipText("Change Image");
		l41.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l41.addMouseListener(this);
		l41.setBounds(740, 640, 32, 32);
		l40.add(l41);
	
//		p41=new JPanel();
//		p41.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.darkGray));
//		p41.setBounds(400, 200, 794, 688);
//		p41.setLayout(null);
//		p4.add(p41);
		
		f1.add(p2);
	
		f1.setSize(1200,920);
		f1.setLayout(null);
		f1.setLocationRelativeTo(null);
        f1.setResizable(false);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
	}

	public static void main(String[] args) {
		new School_Management();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mi11){
			new Change_Password();
		}
		else if(e.getSource()==mi21){
			new Fee_Particular();
		}
		else if(e.getSource()==mi22){
			new Fee_Creation();
		}
		else if(e.getSource()==mi23){
			new Monthly_Fee_Creation();
		}
		else if(e.getSource()==mi31){
			new Student_Admission();
		}
		else if(e.getSource()==mi41){
			new Monthly_Payment();
		}
		else if(e.getSource()==mi42){
			new Payment_Details();
		}
		else if(e.getSource()==mi51){
			new Student_Details();
		}
		else{
			
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==logout){
			f1.dispose();
			new LogIn();
			
		}
		else if(e.getSource()==l41){
			fd1.show();
			bg=(fd1.getDirectory()+fd1.getFile());
			if(fd1.getDirectory()==null){
				l40.setIcon(i1);
			} else {
				ImageIcon img1=new ImageIcon(bg);
				Image img2=img1.getImage().getScaledInstance(l40.getWidth(), l40.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon i1=new ImageIcon(img2);
				l40.setIcon(i1);
			}
			try{
				con1=DriverManager.getConnection(url1);
				Statement st12 = con1.createStatement();
				st12.executeUpdate("INSERT INTO BackGround(Background) values('"+bg+"')");
				st12.executeUpdate("UPDATE BackGround SET Background='"+bg+"'");
				con1.close();
			}
			catch(Exception e1){
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
//			JOptionPane.showMessageDialog(null, SP);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==l302){
			
		}
		else if(e.getSource()==l313){
			l312.setVisible(true);
		}
		else if(e.getSource()==l323){
			l322.setVisible(true);
		}
		else if(e.getSource()==l333){
			l332.setVisible(true);
		}
		else{
			
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==l302){
			
		}
		else if(e.getSource()==l313){
			l312.setVisible(false);
		}
		else if(e.getSource()==l323){
			l322.setVisible(false);
		}
		else if(e.getSource()==l333){
			l332.setVisible(false);
		}
		else{
			
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
