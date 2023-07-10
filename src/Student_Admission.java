import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.sql.*;


@SuppressWarnings("unused")
class Student_Admission implements ActionListener, KeyListener, ItemListener {
	
JFrame f1;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25,l26,F_no,R_no,Datetimes;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,dob;
JTextArea ta1;
JRadioButton r1,r2;
ButtonGroup bu1;
@SuppressWarnings("rawtypes")
JComboBox cb1,cb2,cb3,cb4,cb5,ch1;
JButton b1,b2,b3;
Font fo1,fo2,fo3,fo4;
Connection con;
String url1,path1,gender,nation,R_Type;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Student_Admission(){
		f1=new JFrame("Student Admission");
		fo1=new Font("Cooper Black",Font.PLAIN,25);
		fo2=new Font("Cambria",Font.PLAIN,18);
		fo3=new Font("Bell MT",Font.PLAIN,20);
		fo4=new Font("Bookman Old Style",Font.BOLD,22);
		
		path1="C:/Users/LENOVO/workspace/eclipse/School Management/DateBase/School_Detail.accdb";
		url1="jdbc:ucanaccess://"+path1;
		
		String category[]={"--(Select)--","General","OBC","SC","ST"};
		
		String Blood[]={"Select","O -","O +","A -","A +","B -","B +","AB -","AB +",};
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat year=new SimpleDateFormat("yyyy");
		
		Date date=new Date();
		
		
		l1=new JLabel("Student Admission");
		l1.setFont(fo1);
		l1.setBounds(275, 0, 250, 50);
		
		l2=new JLabel("Admission Form No. :");
		l2.setFont(fo2);
		l2.setBounds(30, 50, 175, 25);
		
		F_no=new JLabel();//F_no for Admission Form Number;
		try{
			con=DriverManager.getConnection(url1);
			String sql1="SELECT COUNT(Admiss_F_No)+1 FROM Student_Admission";
			Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery(sql1);
			if(rs1.next()){
				F_no.setText(rs1.getString(1));
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		F_no.setFont(fo3);
		F_no.setBounds(205, 50, 50, 25);
		
		l3=new JLabel("Admission Date :");
		l3.setFont(fo2);
		l3.setBounds(475, 50, 175, 25);
		
		Datetimes=new JLabel(sdf.format(date));//Datetimes for Admission Date;
		Datetimes.setFont(fo2);
		Datetimes.setBounds(615, 50, 175, 25);
		
		l4=new JLabel("Registation Id :");
		l4.setFont(fo2);
		l4.setBounds(30, 85, 175, 25);
		
		R_no=new JLabel("1");//R_no for Registation Id;
		try{
			con=DriverManager.getConnection(url1);
			String sql2="SELECT COUNT(Registation_Id)+1 FROM Student_Admission";
			Statement st2=con.createStatement();
			ResultSet rs2=st2.executeQuery(sql2);
			if(rs2.next()){
				R_no.setText("00"+rs2.getString(1)+'/'+year.format(date));
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		R_no.setFont(fo3);
		R_no.setBounds(205, 85, 150, 25);
		
		l5=new JLabel("Class :");
		l5.setFont(fo2);
		l5.setBounds(475, 85, 175, 25);
		
		cb1=new JComboBox();//cb1 for select Class;
		cb1.addItem("-Select-");
		try{
			con=DriverManager.getConnection(url1);
			String sql1="SELECT * FROM Class ";
			Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery(sql1);
			while(rs1.next()){
				cb1.addItem(rs1.getString("Class"));
				
			}
			con.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		cb1.setFont(fo3);
		cb1.addKeyListener(this);
		cb1.setBounds(575, 85, 100, 25);
		
		l6=new JLabel("<HTML><U>Student Information</U></HTML>");
		l6.setFont(fo4);
		l6.setBounds(10, 120, 250, 30);
		
		l7=new JLabel("Name :");
		l7.setFont(fo2);
		l7.setBounds(30, 160, 175, 25);
		
		t1=new JTextField("");//t1 for Student Name;
		t1.setFont(fo3);
		t1.addKeyListener(this);
		t1.setBounds(205, 160, 200, 25);
		
		l8=new JLabel("Father's Name :");
		l8.setFont(fo2);
		l8.setBounds(30, 195, 175, 25);
		
		t2=new JTextField("");//t2 for Father's Name;
		t2.setFont(fo3);
		t2.addKeyListener(this);
		t2.setBounds(205, 195, 200, 25);
		
		l9=new JLabel("Mother's Name :");
		l9.setFont(fo2);
		l9.setBounds(30, 230, 175, 25);
		
		t3=new JTextField("");//t3 for Mother's Name;
		t3.setFont(fo3);
		t3.addKeyListener(this);
		t3.setBounds(205, 230, 200, 25);
		
		l10=new JLabel("Date Of Birth :");
		l10.setFont(fo2);
		l10.setBounds(30, 265, 175, 25);

		dob=new JTextField();//dob for Date Of Birth;
		dob.setFont(fo3);
		dob.addKeyListener(this);
		dob.setBounds(205, 265, 150, 25);
		
		l11=new JLabel("Category :");
		l11.setFont(fo2);
		l11.setBounds(30, 300, 175, 25);
		
		cb2=new JComboBox(category);//cb2 for Choose Category;
		cb2.setFont(fo3);
		cb2.addKeyListener(this);
		cb2.setBounds(205, 300, 200, 25);
		
		l12=new JLabel("Gender :");
		l12.setFont(fo2);
		l12.setBounds(30, 335, 175, 25);
		
		r1=new JRadioButton("Male");
		r1.setFont(fo2);
		r1.addKeyListener(this);
		r1.setBounds(205, 335, 75, 25);
		
		r2=new JRadioButton("Female");
		r2.setFont(fo2);
		r2.addKeyListener(this);
		r2.setBounds(310, 335, 100, 25);
		
		bu1=new ButtonGroup();//bu1 for Choose Gender;
		
		l13=new JLabel("Nationality :");
		l13.setFont(fo2);
		l13.setBounds(30, 370, 175, 25);
		
		ch1=new JComboBox();//ch1 for Select Nationality;
		ch1.addItem("Indian");
		ch1.addItem("Others");
		ch1.setFont(fo3);
		ch1.addKeyListener(this);
		ch1.addItemListener(this);
		ch1.setBounds(205, 370, 100, 25);
		
		t4=new JTextField();//t4 for Nationality when you Choose other then it works;
		t4.setFont(fo3);
		t4.setVisible(false);
		t4.addKeyListener(this);
		t4.setBounds(310, 370, 125, 25);
		
		l14=new JLabel("Identification Marks :");
		l14.setFont(fo2);
		l14.setBounds(30, 405, 175, 25);
		
		t5=new JTextField();//t5 for Identification Mark;
		t5.setFont(fo3);
		t5.addKeyListener(this);
		t5.setBounds(205, 405, 230, 25);
		
		l15=new JLabel("Address :");
		l15.setFont(fo2);
		l15.setBounds(475, 160, 175, 25);
		
		ta1=new JTextArea("");//ta1 for Address;
		ta1.setFont(fo3);
		ta1.setLineWrap(true);
		ta1.setBorder(BorderFactory.createLineBorder(Color.gray));
		ta1.addKeyListener(this);
		ta1.setBounds(585, 160, 200, 50);
		
		l16=new JLabel("City :");
		l16.setFont(fo2);
		l16.setBounds(475, 230, 175, 25);
		
		t6=new JTextField();//t6 for City;
		t6.setFont(fo3);
		t6.addKeyListener(this);
		t6.setBounds(585, 230, 200, 25);
		
		l17=new JLabel("Pin Code :");
		l17.setFont(fo2);
		l17.setBounds(475, 265, 175, 25);
		
		t7=new JTextField("");//t7 for PinCode;
		t7.setFont(fo3);
		t7.addKeyListener(this);
		t7.setBounds(585, 265, 200, 25);
		
		l18=new JLabel("State :");
		l18.setFont(fo2);
		l18.setBounds(475, 300, 175, 25);
		
		t8=new JTextField("");//t8 for State;
		t8.setFont(fo3);
		t8.addKeyListener(this);
		t8.setBounds(585, 300, 200, 25);
		
		l19=new JLabel("E-mail Id:");
		l19.setFont(fo2);
		l19.setBounds(475, 335, 175, 25);
		
		t9=new JTextField("");//t9 for E-mail id;
		t9.setFont(fo3);
		t9.addKeyListener(this);
		t9.setBounds(585, 335, 200, 25);
		
		l20=new JLabel("Contact No.1 :");
		l20.setFont(fo2);
		l20.setBounds(475, 370, 175, 25);
		
		t10=new JTextField("");//t10 for Contact No.1;
		t10.setFont(fo3);
		t10.addKeyListener(this);
		t10.setBounds(585, 370, 200, 25);
		
		l21=new JLabel("Contact No.2 :");
		l21.setFont(fo2);
		l21.setBounds(475, 405, 175, 25);
		
		t11=new JTextField("");//t11 for Contact No.2;
		t11.setFont(fo3);
		t11.addKeyListener(this);
		t11.setBounds(585, 405, 200, 25);
		
		l24=new JLabel("Blood Group :");
		l24.setFont(fo2);
		l24.setBounds(30, 440, 175, 25);
		
		cb4=new JComboBox(Blood);//cb4 for Select Blood Group;
		cb4.setFont(fo3);
		cb4.addKeyListener(this);
		cb4.setBounds(155, 440, 75, 25);
		
		l25=new JLabel("Rebate Type :");
		l25.setFont(fo2);
		l25.setBounds(240, 440, 175, 25);
		
		cb5=new JComboBox();//cb5 for Select Rebate Type;
		cb5.addItem("--(Select)--");
		cb5.addItem("One");
		cb5.addKeyListener(this);
		cb5.addActionListener(this);
		cb5.addItem("Multiple");
		cb5.setFont(fo3);
		cb5.setBounds(375, 440, 125, 25);
		
		l26=new JLabel("Rebate Amount :");
		l26.setFont(fo2);
		l26.setVisible(false);
		l26.setBounds(510, 440, 175, 25);
		
		t16=new JTextField("");//t16 for Rebate Amount;
		t16.setFont(fo3);
		t16.setVisible(false);
		t16.addKeyListener(this);
		t16.setBounds(650, 440, 100, 25);
		
		l22=new JLabel("<HTML><U>Previous Qualification</U></HTML>");
		l22.setFont(fo4);
		l22.setBounds(10, 475, 300, 30);
		
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
		cb3.setBounds(30, 510, 100, 45);
		
		t12=new JTextField("");//t12 for Previous School Name;
		t12.setFont(fo3);
		t12.addKeyListener(this);
		t12.setBorder(BorderFactory.createTitledBorder("School Name"));
		t12.setBounds(150, 510, 400, 45);
		
		t13=new JTextField("");//t13 for Previous Year;
		t13.setFont(fo3);
		t13.addKeyListener(this);
		t13.setBorder(BorderFactory.createTitledBorder("Year"));
		t13.setBounds(565, 510, 100, 45);
		
		t14=new JTextField("");//t14 for Previous Status;
		t14.setFont(fo3);
		t14.addKeyListener(this);
		t14.setBorder(BorderFactory.createTitledBorder("Status"));
		t14.setBounds(685, 510, 100, 45);
		
		l23=new JLabel("Test Remarks :");
		l23.setFont(fo2);
		l23.setBounds(30, 560, 175, 25);
		
		t15=new JTextField("");//t15 for Test Remarks;
		t15.setFont(fo3);
		t15.addKeyListener(this);
		t15.setBounds(205, 560, 200, 25);
		
		b1=new JButton("Next");
		b1.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b1.setForeground(new Color(75,0,0));
	    b1.setBackground(new Color(248, 227, 250));
		b1.setFont(fo4);
		b1.addActionListener(this);
		b1.addKeyListener(this);
		b1.setBounds(100, 600, 125, 35);
		
		b2=new JButton("Home");
		b2.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b2.setForeground(new Color(75,0,0));
	    b2.setBackground(new Color(248, 227, 250));
		b2.setFont(fo4);
		b2.addActionListener(this);
		b2.setBounds(325, 600, 125, 35);
		
		b3=new JButton("Clear");
		b3.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b3.setForeground(new Color(75,0,0));
	    b3.setBackground(new Color(248, 227, 250));
		b3.setFont(fo4);
		b3.addActionListener(this);
		b3.setBounds(550, 600, 125, 35);
		
		f1.add(l1);f1.add(l2);
		f1.add(l3);f1.add(l4);
		f1.add(l5);f1.add(l6);
		f1.add(l7);f1.add(l8);
		f1.add(l9);f1.add(l10);
		f1.add(l11);f1.add(l12);
		f1.add(l13);f1.add(l14);
		f1.add(l15);f1.add(l16);
		f1.add(l17);f1.add(l18);
		f1.add(l19);f1.add(l20);
		f1.add(l21);f1.add(l22);
		f1.add(l23);f1.add(l24);
		f1.add(l25);f1.add(l26);
		f1.add(F_no);f1.add(R_no);
		f1.add(Datetimes);
		
		
		f1.add(t1);f1.add(t2);
		f1.add(t3);f1.add(t4);
		f1.add(t5);f1.add(t6);
		f1.add(t7);f1.add(t8);
		f1.add(t9);f1.add(t10);
		f1.add(t11);f1.add(t12);
		f1.add(t13);f1.add(t14);
		f1.add(t15);f1.add(t16);
		f1.add(dob);
		
		bu1.add(r1);bu1.add(r2);
		f1.add(r1);f1.add(r2);
		
		f1.add(ta1);
		
		f1.add(ch1);
		
		f1.add(cb1);f1.add(cb2);
		f1.add(cb3);f1.add(cb4);
		f1.add(cb5);
		
		f1.add(b1);
//		f1.add(b2);
		f1.add(b3);
		
		f1.setSize(800,675);
		f1.setLayout(null);
		f1.setLocationRelativeTo(null);
        f1.setResizable(false);
//        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
	}
	public void itemStateChanged(ItemEvent e) {
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
				String sql2="INSERT INTO Student_Admission(Admiss_F_No,Admiss_Date,Registation_Id,Class,Name,Fathers_Name,Mothers_Name,DOB,Category,Gender,Nationality,Identi_Marks,Address,City,Pin_Code,State,E_Mail_Id,Contact_No_1,Contact_No_2,Blood_Group,Rebate_Type,Rebate_Amt,P_Class,P_School_Name,P_Year,P_Status,Test_Remarks) VALUES('"+F_no.getText()+"','"+Datetimes.getText()+"','"+R_no.getText()+"','"+cb1.getSelectedItem()+"','"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+dob.getText()+"','"+cb2.getSelectedItem()+"','"+gender+"','"+nation+"','"+t5.getText()+"','"+ta1.getText()+"','"+t6.getText()+"','"+t7.getText()+"','"+t8.getText()+"','"+t9.getText()+"','"+t10.getText()+"','"+t11.getText()+"','"+cb4.getSelectedItem()+"','"+R_Type+"','"+t16.getText()+"','"+cb3.getSelectedItem()+"','"+t12.getText()+"','"+t13.getText()+"','"+t14.getText()+"','"+t15.getText()+"')";
				Statement st2=con.createStatement();
				st2.executeUpdate(sql2);
				con.close();
				JOptionPane.showMessageDialog(null, "Saved");
				new Upload_Photo(R_no.getText());
				f1.setVisible(false);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
		}
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){
			NextClick();
		}
		else if(e.getSource()==b2){
			
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
			cb1.setSelectedIndex(0);
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
		}
		else{
			
		}
		
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==10){
			if(e.getSource()==cb1){
				if(cb1.getSelectedItem().equals("-Select-")){
					JOptionPane.showMessageDialog(null, "Please Choose Class");
					cb1.requestFocus();
				}
				else{
					t1.requestFocus();
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
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] arg){
		new Student_Admission();
	}
}