import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Student_Details implements ActionListener, KeyListener {

	JFrame f1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25,l26,l27,l28,l29,photo,Bal;
	JLabel A_F_No,R_Id,A_D,Name,Balance,F_Name,M_Name,Dob,Category,Gender,Nationality,Identi_Mark,B_G,R_Type,R_Amt,Add,City,P_Code,State,E_mail,Con1,Con2,P_Class,P_S_Name,P_year,P_Status,T_Remark;
	JPanel p1,p2,p3;
	JTextField t1;
	@SuppressWarnings("rawtypes")
	JComboBox cb1;
	Font fo1,fo2,fo3,fo4;
	JButton b1,b2,b3;
	Connection con;
	String path1,url1;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Student_Details() {
		f1=new JFrame();
		
		path1="C:/Users/LENOVO/workspace/eclipse/School Management/DateBase/School_Detail.accdb";
		url1="jdbc:ucanaccess://"+path1;
		
		fo1=new Font("Bookman Old Style",Font.BOLD,22);
		fo2=new Font("Cambria",Font.PLAIN,18);
		fo3=new Font("Cambria",Font.BOLD,18);
		fo4=new Font("Cambria",Font.BOLD,20);
		
		l1=new JLabel("Student Details");
		l1.setFont(fo1);
		l1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.red));
		l1.setBounds(290, 0, 190, 35);
		
		l2=new JLabel("Class :");
		l2.setFont(fo2);
		l2.setBounds(125, 55, 100, 25);
		
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
		
		l3=new JLabel("Roll :");
		l3.setFont(fo2);
		l3.setBounds(375, 55, 175, 25);
		
		t1=new JTextField();
		t1.setFont(fo3);
		t1.addKeyListener(this);
		t1.setBounds(425, 55, 100, 25);
		
		b1=new JButton("Search");
		b1.setFont(fo4);
		b1.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
	    b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b1.setForeground(new Color(75,0,0));
	    b1.setBackground(new Color(248, 227, 250));
		b1.addActionListener(this);
		b1.addKeyListener(this);
		b1.setBounds(575, 55, 100, 25);
		
		p1=new JPanel();
		p1.setVisible(false);
		p1.setLayout(null);
		p1.setBounds(0, 80, 795, 560);
		
		p2=new JPanel();
		p2.setVisible(true);
		p2.setLayout(null);
		p2.setBorder(BorderFactory.createTitledBorder("Student Information"));
		p2.setBounds(0, 0, 790, 500);
		
		l4=new JLabel("Admission Form No. :");
		l4.setFont(fo2);
		l4.setBounds(15, 25, 175, 25);
		
		A_F_No=new JLabel();
		A_F_No.setFont(fo3);
		A_F_No.setBounds(190, 25, 50, 25);
		
		l5=new JLabel("Registation Id :");
		l5.setFont(fo2);
		l5.setBounds(250, 25, 175, 25);
		
		R_Id=new JLabel();
		R_Id.setFont(fo3);
		R_Id.setBounds(375, 25, 125, 25);
		
		l6=new JLabel("Admission Date :");
		l6.setFont(fo2);
		l6.setBounds(515, 25, 175, 25);

		A_D=new JLabel();
		A_D.setFont(fo3);
		A_D.setBounds(650, 25, 175, 25);
		
		photo=new JLabel("");
		photo.setFont(fo2);
		photo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		photo.setBounds(15, 50, 125, 125);
		
		l7=new JLabel("Name :");
		l7.setFont(fo2);
		l7.setBounds(150, 50, 100, 25);
		
		Name=new JLabel();
		Name.setFont(fo3);
		Name.setBounds(225, 50, 250, 25);
		
		Bal=new JLabel("Balance :");
		Bal.setFont(fo2);
		Bal.setBounds(585, 50, 100, 25);
		
		Balance=new JLabel();
		Balance.setFont(fo3);
		Balance.setBounds(660, 50, 100, 25);
		
		l8=new JLabel("Father's Name :");
		l8.setFont(fo2);
		l8.setBounds(150, 85, 175, 25);
		
		F_Name=new JLabel();
		F_Name.setFont(fo3);
		F_Name.setBounds(285, 85, 250, 25);
		
		l9=new JLabel("Mother's Name :");
		l9.setFont(fo2);
		l9.setBounds(150, 120, 175, 25);
		
		M_Name=new JLabel();
		M_Name.setFont(fo3);
		M_Name.setBounds(285, 120, 250, 25);
		
		l10=new JLabel("Date Of Birth :");
		l10.setFont(fo2);
		l10.setBounds(150, 155, 175, 25);
		
		Dob=new JLabel();
		Dob.setFont(fo3);
		Dob.setBounds(265, 155, 175, 25);
		
		l11=new JLabel("Category :");
		l11.setFont(fo2);
		l11.setBounds(390, 155, 150, 25);
		
		Category=new JLabel();
		Category.setFont(fo3);
		Category.setBounds(470, 155, 150, 25);
		
		l12=new JLabel("Gender :");
		l12.setFont(fo2);
		l12.setBounds(585, 155, 175, 25);
		
		Gender=new JLabel();
		Gender.setFont(fo3);
		Gender.setBounds(655, 155, 150, 25);
		
		l13=new JLabel("Nationality :");
		l13.setFont(fo2);
		l13.setBounds(15, 190, 175, 25);
		
		Nationality=new JLabel();
		Nationality.setFont(fo3);
		Nationality.setBounds(115, 190, 150, 25);
		
		l14=new JLabel("Identification Marks :");
		l14.setFont(fo2);
		l14.setBounds(250, 190, 175, 25);
		
		Identi_Mark=new JLabel();
		Identi_Mark.setFont(fo3);
		Identi_Mark.setBounds(425, 190, 350, 25);
		
		l15=new JLabel("Blood Group :");
		l15.setFont(fo2);
		l15.setBounds(15, 225, 150, 25);
		
		B_G=new JLabel();
		B_G.setFont(fo3);
		B_G.setBounds(125, 225, 100, 25);
		
		l16=new JLabel("Rebate Type :");
		l16.setFont(fo2);
		l16.setBounds(250, 225, 150, 25);
		
		R_Type=new JLabel();
		R_Type.setFont(fo3);
		R_Type.setBounds(360, 225, 150, 25);
		
		l17=new JLabel("Rebate Amount :");
		l17.setFont(fo2);
		l17.setBounds(525, 225, 150, 25);
		
		R_Amt=new JLabel();
		R_Amt.setFont(fo3);
		R_Amt.setBounds(660, 225, 100, 25);
		
		l18=new JLabel("Address :");
		l18.setFont(fo2);
		l18.setBounds(15, 260, 150, 25);
		
		Add=new JLabel();
		Add.setFont(fo3);
		Add.setBounds(95, 260, 400, 25);
		
		l19=new JLabel("City :");
		l19.setFont(fo2);
		l19.setBounds(15, 295, 150, 25);
		
		City=new JLabel();
		City.setFont(fo3);
		City.setBounds(95, 295, 200, 25);
		
		l20=new JLabel("Pin Code :");
		l20.setFont(fo2);
		l20.setBounds(250, 295, 150, 25);
		
		P_Code=new JLabel();
		P_Code.setFont(fo3);
		P_Code.setBounds(335, 295, 150, 25);
		
		l21=new JLabel("State :");
		l21.setFont(fo2);
		l21.setBounds(485, 295, 150, 25);
		
		State=new JLabel();
		State.setFont(fo3);
		State.setBounds(550, 295, 200, 25);
		
		l22=new JLabel("E-mail Id :");
		l22.setFont(fo2);
		l22.setBounds(15, 330, 150, 25);
		
		E_mail=new JLabel();
		E_mail.setFont(fo3);
		E_mail.setBounds(95, 330, 250, 25);
		
		l23=new JLabel("Contact No. 1 :");
		l23.setFont(fo2);
		l23.setBounds(15, 360, 150, 25);
		
		Con1=new JLabel();
		Con1.setFont(fo3);
		Con1.setBounds(130, 360, 200, 25);
		
		l24=new JLabel("Contact No. 2 :");
		l24.setFont(fo2);
		l24.setBounds(325, 360, 150, 25);
		
		Con2=new JLabel();
		Con2.setFont(fo3);
		Con2.setBounds(440, 360, 200, 25);
		
		p3=new JPanel();
		p3.setVisible(true);
		p3.setLayout(null);
		p3.setBorder(BorderFactory.createTitledBorder("Previous Qualification"));
		p3.setBounds(10, 385, 750, 80);
		
		l25=new JLabel("Class :");
		l25.setFont(fo2);
		l25.setBounds(15, 15, 100, 25);
		
		P_Class=new JLabel();
		P_Class.setFont(fo3);
		P_Class.setBounds(75, 15, 100, 25);
		
		l26=new JLabel("School Name :");
		l26.setFont(fo2);
		l26.setBounds(200, 15, 120, 25);
		
		P_S_Name=new JLabel();
		P_S_Name.setFont(fo3);
		P_S_Name.setBounds(315, 15, 400, 25);
		
		l27=new JLabel("Year :");
		l27.setFont(fo2);
		l27.setBounds(15, 50, 100, 25);
		
		P_year=new JLabel();
		P_year.setFont(fo3);
		P_year.setBounds(85, 50, 100, 25);
		
		l28=new JLabel("Status :");
		l28.setFont(fo2);
		l28.setBounds(250, 50, 120, 25);
		
		P_Status=new JLabel();
		P_Status.setFont(fo3);
		P_Status.setBounds(325, 50, 200, 25);
		
		l29=new JLabel("Test Remark :");
		l29.setFont(fo2);
		l29.setBounds(15, 470, 120, 25);
		
		T_Remark=new JLabel();
		T_Remark.setFont(fo3);
		T_Remark.setBounds(150, 470, 350, 25);
		
		
		b2=new JButton("Update");
		b2.setFont(fo4);
		b2.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
	    b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b2.setForeground(new Color(75,0,0));
	    b2.setBackground(new Color(248, 227, 250));
		b2.addActionListener(this);
		b2.addKeyListener(this);
		b2.setBounds(200, 600, 100, 25);
		b2.setVisible(false);
		
		b3=new JButton("delete");
		b3.setFont(fo4);
		b3.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
	    b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b3.setForeground(new Color(75,0,0));
	    b3.setBackground(new Color(248, 227, 250));
		b3.addActionListener(this);
		b3.addKeyListener(this);
		b3.setBounds(450, 600, 100, 25);
		b3.setVisible(false);
		
		f1.add(l1);f1.add(l2);
		f1.add(l3);
		
		f1.add(t1);
		
		f1.add(cb1);
		
		f1.add(b1);f1.add(b2);
		f1.add(b3);
		
		f1.add(p1);
		
		p1.add(p2);
		
		p2.add(l4);p2.add(l5);
		p2.add(l6);p2.add(photo);
		p2.add(Bal);
		p2.add(l7);p2.add(l8);
		p2.add(l9);p2.add(l10);
		p2.add(l11);p2.add(l12);
		p2.add(l13);p2.add(l14);
		p2.add(l15);p2.add(l16);
		p2.add(l17);p2.add(l18);
		p2.add(l19);p2.add(l20);
		p2.add(l21);p2.add(l22);
		p2.add(l23);p2.add(l24);
		p2.add(l29);
		
		p2.add(A_F_No);p2.add(R_Id);
		p2.add(A_D);p2.add(Name);
		p2.add(Balance);p2.add(F_Name);
		p2.add(M_Name);p2.add(Dob);
		p2.add(Category);p2.add(Gender);
		p2.add(Nationality);p2.add(Identi_Mark);
		p2.add(B_G);p2.add(R_Type);
		p2.add(R_Amt);p2.add(Add);
		p2.add(City);p2.add(P_Code);
		p2.add(State);p2.add(E_mail);
		p2.add(Con1);p2.add(Con2);
		p2.add(T_Remark);
		
		p2.add(p3);
		
		p3.add(l25);p3.add(l26);
		p3.add(l27);p3.add(l28);
		
		p3.add(P_Class);p3.add(P_S_Name);
		p3.add(P_year);p3.add(P_Status);
		
		f1.setSize(800,675);
		f1.setLayout(null);
		f1.setLocationRelativeTo(null);
        f1.setResizable(false);
//        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
		
	}

	public static void main(String[] args) {
		new Student_Details();

	}

	public void SearchClick(){
		try{
			con=DriverManager.getConnection(url1);
			String sql1="SELECT * FROM Student_Admission Where Class='"+cb1.getSelectedItem()+"' and Roll='"+t1.getText()+"' ";
			Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery(sql1);
			
			if(!rs1.next()){
				JOptionPane.showMessageDialog(null, "Class And Roll not Found!");
				cb1.requestFocus();
				p1.setVisible(false);
				b2.setVisible(false);
				b3.setVisible(false);
			}
			else{
				p1.setVisible(true);
				b2.setVisible(true);
				b3.setVisible(true);
				A_F_No.setText(rs1.getString("Admiss_F_No"));
				R_Id.setText(rs1.getString("Registation_Id"));
				A_D.setText(rs1.getString("Admiss_Date"));
				ImageIcon img1=new ImageIcon(rs1.getString("S_Photo"));
				Image img2=img1.getImage().getScaledInstance(photo.getWidth(), photo.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon i=new ImageIcon(img2);
				photo.setIcon(i);
				Name.setText(rs1.getString("Name"));
				F_Name.setText(rs1.getString("Fathers_Name"));
				M_Name.setText(rs1.getString("Mothers_Name"));
				Dob.setText(rs1.getString("DOB"));
				Category.setText(rs1.getString("Category"));
				Gender.setText(rs1.getString("Gender"));
				Nationality.setText(rs1.getString("Nationality"));
				Identi_Mark.setText(rs1.getString("Identi_Marks"));
				B_G.setText(rs1.getString("Blood_Group"));
				R_Type.setText(rs1.getString("Rebate_Type"));
				R_Amt.setText(rs1.getString("Rebate_Amt"));
				Add.setText(rs1.getString("Address"));
				City.setText(rs1.getString("City"));
				P_Code.setText(rs1.getString("Pin_Code"));
				State.setText(rs1.getString("State"));
				E_mail.setText(rs1.getString("E_Mail_Id"));
				Con1.setText(rs1.getString("Contact_No_1"));
				Con2.setText(rs1.getString("Contact_No_2"));
				P_Class.setText(rs1.getString("P_Class"));
				P_S_Name.setText(rs1.getString("P_School_Name"));
				P_year.setText(rs1.getString("P_Year"));
				P_Status.setText(rs1.getString("P_Status"));
				T_Remark.setText(rs1.getString("Test_Remarks"));
				
				String sql2="SELECT * FROM Student_Payment Where Class='"+cb1.getSelectedItem()+"' and Roll='"+t1.getText()+"' ";
				Statement st2=con.createStatement();
				ResultSet rs2=st2.executeQuery(sql2);
				if(rs2.next()){
					Balance.setText(rs2.getString("Balance"));
				}	
			}
			con.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==10){
			if(e.getSource()==cb1){
				if(cb1.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "Please Choose Class");
					cb1.requestFocus();
				}
				else{
					t1.requestFocus();
				}
			}
			else if(e.getSource()==t1){
				if(t1.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Roll");
					t1.requestFocus();
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
				else if(t1.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Roll");
					t1.requestFocus();
				}
				else{
					SearchClick();
				}
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cb1){
			if(cb1.getSelectedIndex()==0){
				JOptionPane.showMessageDialog(null, "Please Choose Class");
				cb1.requestFocus();
			}
			else{
				t1.requestFocus();
			}
		}
		else if(e.getSource()==t1){
			if(t1.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Please Enter Roll");
				t1.requestFocus();
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
			else if(t1.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Please Enter Roll");
				t1.requestFocus();
			}
			else{
				SearchClick();
			}
		}
		else if(e.getSource()==b2){
			
		}
		else if(e.getSource()==b3){
			int a=JOptionPane.showConfirmDialog(f1, "Are You Sure To Delete?", "Delete", JOptionPane.YES_NO_OPTION);
			if(a==JOptionPane.YES_OPTION){
				try{
					con=DriverManager.getConnection(url1);
					String sql1="DELETE FROM Student_Admission Where Class='"+cb1.getSelectedItem()+"' and Roll='"+t1.getText()+"' ";
					Statement st1=con.createStatement();
					int i=st1.executeUpdate(sql1);
					String sql2="DELETE FROM Student_Payment Where Class='"+cb1.getSelectedItem()+"' and Roll='"+t1.getText()+"' ";
					Statement st2=con.createStatement();
					int i1=st2.executeUpdate(sql2);
					String sql3="DELETE FROM Particular_Amt Where Class='"+cb1.getSelectedItem()+"' and Roll='"+t1.getText()+"' ";
					Statement st3=con.createStatement();
					int i2=st3.executeUpdate(sql3);
				JOptionPane.showMessageDialog(null, "Delete SuccessFul!");
				p1.setVisible(false);
				b2.setVisible(false);
				b3.setVisible(false);
				con.close();
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
			else{
				
			}
			
			
		}
		
	}

}
