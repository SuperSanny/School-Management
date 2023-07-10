import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Update_Student implements ActionListener, KeyListener, ItemListener{

	JFrame f1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25,l26,S_I,A_F_No,R_Id,A_D;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,dob,Roll;
	JRadioButton r1,r2;
	ButtonGroup bu1;
	@SuppressWarnings("rawtypes")
	JComboBox cb1,cb2,cb3,cb4,cb5,ch1;
	JTextArea ta1;
	JButton b1,b2,b3;
	JPanel p1;
	Font fo1,fo2,fo3,fo4;
	
	Connection con;
	String path1,url1,gender,nation,R_Type;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Update_Student() {
		// TODO Auto-generated constructor stub
		f1=new JFrame("Update Student Details");
		
		path1="C:/Users/LENOVO/workspace/eclipse/School Management/DateBase/School_Detail.accdb";
		url1="jdbc:ucanaccess://"+path1;
		
		String category[]={"--(Select)--","General","OBC","SC","ST"};
		
		String Blood[]={"Select","O -","O +","A -","A +","B -","B +","AB -","AB +",};
		
		fo1=new Font("Bookman Old Style",Font.BOLD,22);
		fo2=new Font("Cambria",Font.PLAIN,18);
		fo3=new Font("Cambria",Font.BOLD,18);
		fo4=new Font("Cambria",Font.BOLD,18);
		
		l1=new JLabel("Update Student Details");
		l1.setFont(fo1);
		l1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.red));
		l1.setBounds(265, 0, 270, 35);
		f1.add(l1);
		
		l2=new JLabel("Class :");
		l2.setFont(fo2);
		l2.setBounds(125, 55, 100, 25);
		f1.add(l2);
		
		cb1=new JComboBox();
		cb1.addItem("--Select--");
		try{
			con=DriverManager.getConnection(url1);
			String sql1="SELECT Class FROM Class ";
			Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery(sql1);
			while(rs1.next()){
				cb1.addItem(rs1.getString(1));
			}
			con.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		cb1.setFont(fo3);
		cb1.addActionListener(this);
		cb1.addKeyListener(this);
		cb1.setBounds(200, 55, 125, 25);
		f1.add(cb1);
		
		l3=new JLabel("Roll :");
		l3.setFont(fo2);
		l3.setBounds(375, 55, 175, 25);
		f1.add(l3);
		
		Roll=new JTextField();
		Roll.setFont(fo3);
		Roll.addKeyListener(this);
		Roll.setBounds(425, 55, 100, 25);
		f1.add(Roll);
		
		b1=new JButton("Search");
		b1.setFont(fo4);
		b1.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
	    b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b1.setForeground(new Color(75,0,0));
	    b1.setBackground(new Color(248, 227, 250));
		b1.addActionListener(this);
		b1.addKeyListener(this);
		b1.setBounds(575, 55, 100, 25);
		f1.add(b1);
		
		p1=new JPanel();
		p1.setBounds(5, 90, 785, 550);
		p1.setLayout(null);
		p1.setVisible(false);
		f1.add(p1);
		
		l4=new JLabel("Admission Form No. :");
		l4.setFont(fo2);
		l4.setBounds(15, 10, 175, 25);
		p1.add(l4);
		
		A_F_No=new JLabel();
		A_F_No.setFont(fo3);
		A_F_No.setBounds(190, 10, 50, 25);
		p1.add(A_F_No);
		
		l5=new JLabel("Registation Id :");
		l5.setFont(fo2);
		l5.setBounds(250, 10, 175, 25);
		p1.add(l5);
		
		R_Id=new JLabel();
		R_Id.setFont(fo3);
		R_Id.setBounds(375, 10, 125, 25);
		p1.add(R_Id);
		
		l6=new JLabel("Admission Date :");
		l6.setFont(fo2);
		l6.setBounds(515, 10, 175, 25);
		p1.add(l6);
		
		A_D=new JLabel();
		A_D.setFont(fo3);
		A_D.setBounds(650, 10, 175, 25);
		p1.add(A_D);
		
		S_I=new JLabel("<HTML><U>Student Information</U></HTML>");
		S_I.setFont(fo4);
		S_I.setBounds(5, 30, 250, 30);
		p1.add(S_I);
		
		l7=new JLabel("Name :");
		l7.setFont(fo2);
		l7.setBounds(15, 60, 175, 25);
		p1.add(l7);
		
		t1=new JTextField("");//t1 for Student Name;
		t1.setFont(fo3);
		t1.addKeyListener(this);
		t1.setBounds(190, 60, 200, 25);
		p1.add(t1);
		
		l8=new JLabel("Father's Name :");
		l8.setFont(fo2);
		l8.setBounds(15, 95, 175, 25);
		p1.add(l8);
		
		t2=new JTextField("");//t2 for Father's Name;
		t2.setFont(fo3);
		t2.addKeyListener(this);
		t2.setBounds(190, 95, 200, 25);
		p1.add(t2);
		
		l9=new JLabel("Mother's Name :");
		l9.setFont(fo2);
		l9.setBounds(15, 130, 175, 25);
		p1.add(l9);
		
		t3=new JTextField("");//t3 for Mother's Name;
		t3.setFont(fo3);
		t3.addKeyListener(this);
		t3.setBounds(190, 130, 200, 25);
		p1.add(t3);
		
		l10=new JLabel("Date Of Birth :");
		l10.setFont(fo2);
		l10.setBounds(15, 165, 175, 25);
		p1.add(l10);

		dob=new JTextField();//dob for Date Of Birth;
		dob.setFont(fo3);
		dob.addKeyListener(this);
		dob.setBounds(190, 165, 150, 25);
		p1.add(dob);
		
		l11=new JLabel("Category :");
		l11.setFont(fo2);
		l11.setBounds(15, 200, 175, 25);
		p1.add(l11);
		
		cb2=new JComboBox(category);//cb2 for Choose Category;
		cb2.setFont(fo3);
		cb2.addKeyListener(this);
		cb2.setBounds(190, 200, 200, 25);
		p1.add(cb2);
		
		l12=new JLabel("Gender :");
		l12.setFont(fo2);
		l12.setBounds(15, 235, 175, 25);
		p1.add(l12);
		
		r1=new JRadioButton("Male");
		r1.setFont(fo2);
		r1.addKeyListener(this);
		r1.setBounds(190, 235, 75, 25);
		p1.add(r1);
		
		r2=new JRadioButton("Female");
		r2.setFont(fo2);
		r2.addKeyListener(this);
		r2.setBounds(295, 235, 100, 25);
		p1.add(r2);
		
		bu1=new ButtonGroup();//bu1 for Choose Gender;
		bu1.add(r1);bu1.add(r2);
		
		l13=new JLabel("Nationality :");
		l13.setFont(fo2);
		l13.setBounds(15, 270, 175, 25);
		p1.add(l13);
		
		ch1=new JComboBox();//ch1 for Select Nationality;
		ch1.addItem("Indian");
		ch1.addItem("Others");
		ch1.setFont(fo3);
		ch1.addKeyListener(this);
		ch1.addItemListener(this);
		ch1.setBounds(190, 270, 100, 25);
		p1.add(ch1);
		
		t4=new JTextField();//t4 for Nationality when you Choose other then it works;
		t4.setFont(fo3);
		t4.setVisible(false);
		t4.addKeyListener(this);
		t4.setBounds(295, 270, 125, 25);
		p1.add(t4);
		
		l14=new JLabel("Identification Marks :");
		l14.setFont(fo2);
		l14.setBounds(15, 305, 175, 25);
		p1.add(l14);
		
		t5=new JTextField();//t5 for Identification Mark;
		t5.setFont(fo3);
		t5.addKeyListener(this);
		t5.setBounds(190, 305, 230, 25);
		p1.add(t5);
		
		l15=new JLabel("Address :");
		l15.setFont(fo2);
		l15.setBounds(460, 60, 175, 25);
		p1.add(l15);
		
		ta1=new JTextArea("");//ta1 for Address;
		ta1.setFont(fo3);
		ta1.setLineWrap(true);
		ta1.setBorder(BorderFactory.createLineBorder(Color.gray));
		ta1.addKeyListener(this);
		ta1.setBounds(570, 60, 200, 50);
		p1.add(ta1);
		
		l16=new JLabel("City :");
		l16.setFont(fo2);
		l16.setBounds(460, 130, 175, 25);
		p1.add(l16);
		
		t6=new JTextField();//t6 for City;
		t6.setFont(fo3);
		t6.addKeyListener(this);
		t6.setBounds(570, 130, 200, 25);
		p1.add(t6);
		
		l17=new JLabel("Pin Code :");
		l17.setFont(fo2);
		l17.setBounds(460, 165, 175, 25);
		p1.add(l17);
		
		t7=new JTextField("");//t7 for PinCode;
		t7.setFont(fo3);
		t7.addKeyListener(this);
		t7.setBounds(570, 165, 200, 25);
		p1.add(t7);
		
		l18=new JLabel("State :");
		l18.setFont(fo2);
		l18.setBounds(460, 200, 175, 25);
		p1.add(l18);
		
		t8=new JTextField("");//t8 for State;
		t8.setFont(fo3);
		t8.addKeyListener(this);
		t8.setBounds(570, 200, 200, 25);
		p1.add(t8);
		
		l19=new JLabel("E-mail Id:");
		l19.setFont(fo2);
		l19.setBounds(460, 235, 175, 25);
		p1.add(l19);
		
		t9=new JTextField("");//t9 for E-mail id;
		t9.setFont(fo3);
		t9.addKeyListener(this);
		t9.setBounds(570, 235, 200, 25);
		p1.add(t9);
		
		l20=new JLabel("Contact No.1 :");
		l20.setFont(fo2);
		l20.setBounds(460, 270, 175, 25);
		p1.add(l20);
		
		t10=new JTextField("");//t10 for Contact No.1;
		t10.setFont(fo3);
		t10.addKeyListener(this);
		t10.setBounds(570, 270, 200, 25);
		p1.add(t10);
		
		l21=new JLabel("Contact No.2 :");
		l21.setFont(fo2);
		l21.setBounds(460, 305, 175, 25);
		p1.add(l21);
		
		t11=new JTextField("");//t11 for Contact No.2;
		t11.setFont(fo3);
		t11.addKeyListener(this);
		t11.setBounds(570, 305, 200, 25);
		p1.add(t11);
		
		l24=new JLabel("Blood Group :");
		l24.setFont(fo2);
		l24.setBounds(15, 340, 175, 25);
		p1.add(l24);
		
		cb4=new JComboBox(Blood);//cb4 for Select Blood Group;
		cb4.setFont(fo3);
		cb4.addKeyListener(this);
		cb4.setBounds(140, 340, 75, 25);
		p1.add(cb4);
		
		l25=new JLabel("Rebate Type :");
		l25.setFont(fo2);
		l25.setBounds(225, 340, 175, 25);
		p1.add(l25);
		
		cb5=new JComboBox();//cb5 for Select Rebate Type;
		cb5.addItem("--(Select)--");
		cb5.addItem("One");
		cb5.addKeyListener(this);
		cb5.addActionListener(this);
		cb5.addItem("Multiple");
		cb5.setFont(fo3);
		cb5.setBounds(360, 340, 125, 25);
		p1.add(cb5);
		
		l26=new JLabel("Rebate Amount :");
		l26.setFont(fo2);
		l26.setVisible(false);
		l26.setBounds(495, 340, 175, 25);
		p1.add(l26);
		
		t16=new JTextField("");//t16 for Rebate Amount;
		t16.setFont(fo3);
		t16.setVisible(false);
		t16.addKeyListener(this);
		t16.setBounds(635, 340, 100, 25);
		p1.add(t16);
		
		l22=new JLabel("<HTML><U>Previous Qualification</U></HTML>");
		l22.setFont(fo4);
		l22.setBounds(5, 375, 300, 30);
		p1.add(l22);
		
		cb3=new JComboBox();//cb3 for Choose Previous Class; 
		cb3.addItem("-Select-");
		try{
			con=DriverManager.getConnection(url1);
			String sql1="SELECT Class FROM Class ";
			Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery(sql1);
			while(rs1.next()){
				cb3.addItem(rs1.getString(1));
			}
			con.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		cb3.setFont(fo3);
		cb3.addKeyListener(this);
		cb3.setBorder(BorderFactory.createTitledBorder("Class"));
		cb3.setBounds(15, 410, 100, 45);
		p1.add(cb3);
		
		t12=new JTextField("");//t12 for Previous School Name;
		t12.setFont(fo3);
		t12.addKeyListener(this);
		t12.setBorder(BorderFactory.createTitledBorder("School Name"));
		t12.setBounds(135, 410, 400, 45);
		p1.add(t12);
		
		t13=new JTextField("");//t13 for Previous Year;
		t13.setFont(fo3);
		t13.addKeyListener(this);
		t13.setBorder(BorderFactory.createTitledBorder("Year"));
		t13.setBounds(550, 410, 100, 45);
		p1.add(t13);
		
		t14=new JTextField("");//t14 for Previous Status;
		t14.setFont(fo3);
		t14.addKeyListener(this);
		t14.setBorder(BorderFactory.createTitledBorder("Status"));
		t14.setBounds(670, 410, 100, 45);
		p1.add(t14);
		
		l23=new JLabel("Test Remarks :");
		l23.setFont(fo2);
		l23.setBounds(15, 460, 175, 25);
		p1.add(l23);
		
		t15=new JTextField("");//t15 for Test Remarks;
		t15.setFont(fo3);
		t15.addKeyListener(this);
		t15.setBounds(190, 460, 200, 25);
		p1.add(t15);
		
		b2=new JButton("Next");
		b2.setFont(fo4);
		b2.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
	    b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b2.setForeground(new Color(75,0,0));
	    b2.setBackground(new Color(248, 227, 250));
		b2.addActionListener(this);
		b2.addKeyListener(this);
		b2.setBounds(90, 500, 125, 35);
		p1.add(b2);
		
		b3=new JButton("Clear");
		b3.setFont(fo4);
		b3.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
	    b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b3.setForeground(new Color(75,0,0));
	    b3.setBackground(new Color(248, 227, 250));
		b3.addActionListener(this);
		b3.setBounds(540, 500, 125, 35);
		p1.add(b3);
		
		f1.setSize(800,675);
		f1.setLayout(null);
		f1.setLocationRelativeTo(null);
        f1.setResizable(false);
//        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Update_Student();

	}
	
	public void SearchClick(){
		try{
			con=DriverManager.getConnection(url1);
			String sql1="SELECT * FROM Student_Admission Where Class='"+cb1.getSelectedItem()+"' and Roll='"+Roll.getText()+"' ";
			Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery(sql1);
			
			if(!rs1.next()){
				JOptionPane.showMessageDialog(null, "Class And Roll not Found!");
				cb1.requestFocus();
				p1.setVisible(false);
			}
			else{
				p1.setVisible(true);
				A_F_No.setText(rs1.getString("Admiss_F_No"));
				R_Id.setText(rs1.getString("Registation_Id"));
				A_D.setText(rs1.getString("Admiss_Date"));
				t1.setText(rs1.getString("Name"));
				t2.setText(rs1.getString("Fathers_Name"));
				t3.setText(rs1.getString("Mothers_Name"));
				dob.setText(rs1.getString("DOB"));
				cb2.setSelectedItem(rs1.getString("Category"));
				
				ch1.setSelectedItem(rs1.getString("Nationality"));
				t5.setText(rs1.getString("Identi_Marks"));
				cb4.setSelectedItem(rs1.getString("Blood_Group"));
				cb5.setSelectedItem(rs1.getString("Rebate_Type"));
				t16.setText(rs1.getString("Rebate_Amt"));
				ta1.setText(rs1.getString("Address"));
				t6.setText(rs1.getString("City"));
				t7.setText(rs1.getString("Pin_Code"));
				t8.setText(rs1.getString("State"));
				t9.setText(rs1.getString("E_Mail_Id"));
				t10.setText(rs1.getString("Contact_No_1"));
				t11.setText(rs1.getString("Contact_No_2"));
				cb3.setSelectedItem(rs1.getString("P_Class"));
				t12.setText(rs1.getString("P_School_Name"));
				t13.setText(rs1.getString("P_Year"));
				t14.setText(rs1.getString("P_Status"));
				t15.setText(rs1.getString("Test_Remarks"));
			}
			con.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void NextClick(){
		if(cb1.getSelectedIndex()==0){
			JOptionPane.showMessageDialog(null, "Please Choose Class");
			cb1.requestFocus();
		}
		else if(t1.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please Enter Name");
			t1.requestFocus();
		}
		else if(t2.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please Enter Father's Name");
			t2.requestFocus();
		}
		else if(t3.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please Enter Mother's Name");
			t3.requestFocus();
		}
		else if(dob.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please Enter Date of Birth");
			dob.requestFocus();
		}
		else if(cb2.getSelectedItem().equals("--(Select)--")){
			JOptionPane.showMessageDialog(null, "Please Choose Category");
			cb2.requestFocus();
		}
		else if(bu1.isSelected(null)){
			JOptionPane.showMessageDialog(null, "Please Choose Gender");
			r1.requestFocus();
		}
		else if(t5.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please Enter Identification Marks");
			t5.requestFocus();
		}
		else if(ta1.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please Enter Address");
			ta1.requestFocus();
		}
		else if(t6.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please Enter City");
			t6.requestFocus();
		}
		else if(t7.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please Enter Pin Code");
			t7.requestFocus();
		}
		else if(t8.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please Enter State");
			t8.requestFocus();
		}
		else if(t9.getText().equals("")){
			
		}
		else if(t10.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please Enter Contact Number 1");
			t10.requestFocus();
		}
//		else if(cb4.getSelectedItem().equals("Select")){
//			JOptionPane.showMessageDialog(null, "Please Choose Blood Group");
//			cb4.requestFocus();
//		}
		else{
			if(r1.isSelected()){
				gender="Male";
			}
			else if(r2.isSelected()){
				gender="Female";
			}
			else{}
			if(ch1.getSelectedItem().equals("Indian")){
				nation="Indian";
			}
			else{
				nation=t4.getText();
			}
			if(cb5.getSelectedIndex()==0){
				R_Type="";
			}
			else if(cb5.getSelectedIndex()==1){
				R_Type="One";
				if(t16.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Rebate Amount");
					t16.requestFocus();
				}
				else{
				}
			}
			else if(cb5.getSelectedIndex()==2){
				R_Type="Multiple";
				if(t16.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Rebate Amount");
					t16.requestFocus();
				}
				else{
				}
			}
			try{
				con=DriverManager.getConnection(url1);
				String sql2="Update Student_Admission SET Name='"+t1.getText()+"',Fathers_Name='"+t2.getText()+"',Mothers_Name='"+t3.getText()+"',DOB='"+dob.getText()+"',Category='"+cb2.getSelectedItem()+"',Gender='"+gender+"',Nationality='"+nation+"',Identi_Marks='"+t5.getText()+"',Address='"+ta1.getText()+"',City='"+t6.getText()+"',Pin_Code='"+t7.getText()+"',State='"+t8.getText()+"',E_Mail_Id='"+t9.getText()+"',Contact_No_1='"+t10.getText()+"',Contact_No_2='"+t11.getText()+"',Blood_Group='"+cb4.getSelectedItem()+"',Rebate_Type='"+R_Type+"',Rebate_Amt='"+t16.getText()+"',P_Class='"+cb3.getSelectedItem()+"',P_School_Name='"+t12.getText()+"',P_Year='"+t13.getText()+"',P_Status='"+t14.getText()+"',Test_Remarks='"+t15.getText()+"' WHERE Class='"+cb1.getSelectedItem()+"' and Roll='"+Roll.getText()+"'";
				Statement st2=con.createStatement();
				st2.executeUpdate(sql2);
				con.close();
//				JOptionPane.showMessageDialog(null, "Saved");
				new Update_Student_Photo(R_Id.getText());
				f1.setVisible(false);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cb1){
			if(cb1.getSelectedIndex()==0){
				JOptionPane.showMessageDialog(null, "Please Choose Class");
				cb1.requestFocus();
			}
			else{
				Roll.requestFocus();
			}
		}
		else if(e.getSource()==Roll){
			if(Roll.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Please Enter Roll");
				Roll.requestFocus();
			}
			else {
				b1.requestFocus();
			}
		}
		else if(e.getSource()==b1){
			if(cb1.getSelectedIndex()==0){
				JOptionPane.showMessageDialog(null, "Please Choose Class");
				cb1.requestFocus();
			}
			else if(Roll.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Please Enter Roll");
				Roll.requestFocus();
			}
			else{
				SearchClick();
			}
		}
		else if(e.getSource()==b2){
			NextClick();
		}
		else if(e.getSource()==cb5){
			if(cb5.getSelectedItem().equals("--(Select)--")){
				l26.setVisible(false);
				t16.setVisible(false);
				cb3.requestFocus();
			}
			else{
				l26.setVisible(true);
				t16.setVisible(true);
				t16.requestFocus();
			}
		}
		else if(e.getSource()==b3){
			t1.setText(null);
			t2.setText(null);
			t3.setText(null);
			dob.setText(null);
			cb2.setSelectedIndex(0);
			t5.setText(null);
			ta1.setText(null);
			t6.setText(null);
			t7.setText(null);
			t8.setText(null);
			t9.setText(null);
			t10.setText(null);
			t11.setText(null);
			cb3.setSelectedIndex(0);
			cb4.setSelectedIndex(0);
			cb5.setSelectedIndex(0);
			t12.setText(null);
			t13.setText(null);
			t14.setText(null);
			t15.setText(null);
			t1.requestFocus();
		}
		else{
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==10){
			if(e.getSource()==cb1){
				if(cb1.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "Please Choose Class");
					cb1.requestFocus();
				}
				else{
					Roll.requestFocus();
				}
			}
			else if(e.getSource()==Roll){
				if(Roll.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Roll");
					Roll.requestFocus();
				}
				else {
					b1.requestFocus();
				}
			}
			else if(e.getSource()==b1){
				if(cb1.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "Please Choose Class");
					cb1.requestFocus();
				}
				else if(Roll.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Roll");
					Roll.requestFocus();
				}
				else{
					SearchClick();
				}
			}
			else if(e.getSource()==t1){
				if(t1.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Name");
					t1.requestFocus();
				}
				else{
					t2.requestFocus();
				}
			}
			else if(e.getSource()==t2){
				if(t2.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Father's Name");
				t2.requestFocus();
				}
				else{
					t3.requestFocus();
				}
			}
			else if(e.getSource()==t3){
				if(t3.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Mother's Name");
					t3.requestFocus();
				}
				else{
					dob.requestFocus();
				}
			}
			else if(e.getSource()==dob){
				if(dob.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Date of Birth");
					dob.requestFocus();
				}
				else{
					cb2.requestFocus();
				}
			}
			else if(e.getSource()==cb2){
				if(cb2.getSelectedItem().equals("--(Select)--")){
					JOptionPane.showMessageDialog(null, "Please Choose Category");
					cb2.requestFocus();
				}
				else{
					r1.requestFocus();
				}
			}
			else if(e.getSource()==r1){
				if(r1.getText().equals("")){
					
				}
				else{
					ch1.requestFocus();
				}
			}
			else if(e.getSource()==r2){
				if(r2.getText().equals("")){
					
				}
				else{
					ch1.requestFocus();
				}
			}
			else if(e.getSource()==ch1){
				if(ch1.getSelectedItem().equals("Others")){
					t4.setVisible(true);
					t4.requestFocus();
				}
				else{
					if(ch1.getSelectedItem().equals("Indian")){
						t5.requestFocus();	
						t4.setVisible(false);
					}
				}
			}
			else if(e.getSource()==t4){
				if(t4.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Nationality");
					t4.requestFocus();
				}
				else{
					t5.requestFocus();
				}
			}
			else if(e.getSource()==t5){
				if(t5.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Identification Marks");
					t5.requestFocus();
				}
				else{
					ta1.requestFocus();
				}
			}
			else if(e.getSource()==ta1){
				if(ta1.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Address");
					ta1.requestFocus();
				}
				else{
					t6.requestFocus();
				}
			}
			else if(e.getSource()==t6){
				if(t6.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter City");
					t6.requestFocus();
				}
				else{
					t7.requestFocus();
				}
			}
			else if(e.getSource()==t7){
				if(t7.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Pin Code");
					t7.requestFocus();
				}
				else{
					t8.requestFocus();
				}
			}
			else if(e.getSource()==t8){
				if(t8.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter State");
					t8.requestFocus();
				}
				else{
					t9.requestFocus();
				}
			}
			else if(e.getSource()==t9){
				if(t9.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter E-mail Id");
					t9.requestFocus();
				}
				else{
					t10.requestFocus();
				}
			}
			else if(e.getSource()==t10){
				if(t10.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Contact No.1");
					t10.requestFocus();
				}
				else{
					t11.requestFocus();
				}
			}
			else if(e.getSource()==t11){
				if(t11.getText().equals("")){
					cb4.requestFocus();
				}
				else{
					cb4.requestFocus();
				}
			}
			else if(e.getSource()==cb4){
				if(cb4.getSelectedItem().equals("Select")){
//					JOptionPane.showMessageDialog(null, "Please Choose Blood Group");
//					cb4.requestFocus();
					cb5.requestFocus();
				}
				else{
					cb5.requestFocus();
				}
			}
			else if(e.getSource()==cb5){
				if(cb5.getSelectedItem().equals("--(Select)--")){
					l26.setVisible(false);
					t16.setVisible(false);
					cb3.requestFocus();
				}
				else{
					l26.setVisible(true);
					t16.setVisible(true);
					t16.requestFocus();
				}
			}
			else if(e.getSource()==t16){
				if(t16.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Rebate Amount");
					t16.requestFocus();
				}
				else{
					cb3.requestFocus();
				}
			}
			else if(e.getSource()==cb3){
				if(cb3.getSelectedIndex()==0){
					t12.requestFocus();
				}
				else{
					t12.requestFocus();
				}
			}
			else if(e.getSource()==t12){
				if(cb3.getSelectedIndex()!=0){
					if(t12.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Please Enter Previous School Name");
						t12.requestFocus();
					}
					else{
						t13.requestFocus();
					}
				}
				else{
					t13.requestFocus();
				}
			}
			else if(e.getSource()==t13){
				if(cb3.getSelectedIndex()!=0){
					if(t13.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Please Enter Year");
						t13.requestFocus();
					}
					else{
						t14.requestFocus();
					}
				}
				else{
					t14.requestFocus();
				}
			}
			else if(e.getSource()==t14){
				if(cb3.getSelectedIndex()!=0){
					if(t14.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Please Enter Status");
						t14.requestFocus();
					}
					else{
						t15.requestFocus();
					}
				}
				else{
					t15.requestFocus();
				}
				
			}
			else if(e.getSource()==t15){
				if(t15.getText().equals("")){
					b1.requestFocus();
				}
				else{
					b1.requestFocus();
				}
			}
			else if(e.getSource()==b1){
				NextClick();
				
			}
			else{
				
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		if(ch1.getSelectedItem().equals("Others")){
			t4.setVisible(true);
			t4.requestFocus();
		}
		else{
			if(ch1.getSelectedItem().equals("Indian")){
				t5.requestFocus();	
				t4.setVisible(false);
			}
		}
		
	}

}
