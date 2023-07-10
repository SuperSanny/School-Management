import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;

import javax.swing.*;
class Payment_Process implements ActionListener,KeyListener{

JFrame f1;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,Recipt_no,Registation_no,Adm_Form_no,Payment_date,Roll,Rol,Class,Cls,S_Name,S_Father_Name,Balance,Dues1,Dues2,Bal;
@SuppressWarnings("rawtypes")
JList li1,li2;
@SuppressWarnings("rawtypes")
DefaultListModel dlm1,dlm2;
@SuppressWarnings("rawtypes")
JComboBox cb1;
JTextField t1,t2,t3,t4,Amt;
JButton b1,b2,b3,Add;
Font fo1,fo2,fo3,fo4;
String R_Id,Registaion_Id;
String url1,path1;
Connection con;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	Payment_Process(String R_Id){
		f1=new JFrame("Payment Process");
		
		path1="C:/Users/LENOVO/workspace/eclipse/School Management/DateBase/School_Detail.accdb";
		url1="jdbc:ucanaccess://"+path1;

		Registaion_Id=R_Id;
		
		fo1=new Font("Bookman Old Style",Font.BOLD,22);
		fo2=new Font("Cambria",Font.PLAIN,18);
		fo3=new Font("Cambria",Font.BOLD,18);
		fo4=new Font("Cambria",Font.BOLD,20);
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date date=new Date();
		
		l1=new JLabel("<HTML><U>Payment Process</U></HTML>");
		l1.setFont(fo1);
		l1.setBounds(10, 10, 250, 30);
		
		l2=new JLabel("Receipt No. :");
		l2.setFont(fo2);
		l2.setBounds(30, 50, 175, 25);
		
		Recipt_no=new JLabel();
		try{
			con=DriverManager.getConnection(url1);
			String sql1="SELECT COUNT(Receipt_No)+1 FROM Student_Payment";
			Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery(sql1);
			if(rs1.next()){
				Recipt_no.setText(rs1.getString(1));
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		Recipt_no.setFont(fo3);
		Recipt_no.setBounds(150, 50, 50, 25);
		
		l3=new JLabel("Payment Date :");
		l3.setFont(fo2);
		l3.setBounds(425, 50, 175, 25);
		
		Payment_date=new JLabel(sdf.format(date));
		Payment_date.setFont(fo3);
		Payment_date.setBounds(600, 50, 125, 25);
		
		l4=new JLabel("Registaion Id :");
		l4.setFont(fo2);
		l4.setBounds(30, 85, 175, 25);
		
		Registation_no=new JLabel(Registaion_Id);
		Registation_no.setFont(fo3);
		Registation_no.setBounds(150, 85, 150, 25);
		
		l5=new JLabel("Admission Form No. :");
		l5.setFont(fo2);
		l5.setBounds(425, 85, 175, 25);
		
		Adm_Form_no=new JLabel();
		Adm_Form_no.setFont(fo3);
		Adm_Form_no.setBounds(600, 85, 100, 25);

		Class=new JLabel("Class :");
		Class.setFont(fo2);
		Class.setBounds(30, 120, 100, 25);
		
		Cls=new JLabel();
		Cls.setFont(fo3);
		Cls.setBounds(150, 120, 125, 25);
		
		Roll=new JLabel("Roll :");
		Roll.setFont(fo2);
		Roll.setBounds(425, 120, 125, 25);
		
		Rol=new JLabel("");
		Rol.setFont(fo3);
		Rol.setBounds(550, 120, 125, 25);
		
		l6=new JLabel("Student Name :");
		l6.setFont(fo2);
		l6.setBounds(30, 155, 175, 25);
		
		S_Name=new JLabel();
		S_Name.setFont(fo3);
		S_Name.setBounds(150, 155, 250, 25);
	
		l7=new JLabel("Father's Name :");
		l7.setFont(fo2);
		l7.setBounds(425, 155, 175, 25);
		
		S_Father_Name=new JLabel();
		S_Father_Name.setFont(fo3);
		S_Father_Name.setBounds(550, 155, 250, 25);
		
		l8=new JLabel("Particular");
		l8.setFont(fo4);
		l8.setBounds(150, 190, 100, 30);
		
		cb1=new JComboBox();
//		cb1.addItem("---(Select)---");
		cb1.setFont(fo3);
		cb1.addActionListener(this);
		cb1.addKeyListener(this);
		cb1.setBounds(115, 225, 175, 25);
		
		dlm1=new DefaultListModel();
		li1=new JList(dlm1);
		li1.setFont(fo3);
		li1.setBorder(BorderFactory.createLineBorder(Color.gray));
		li1.setBounds(115, 255, 175, 175);
		
		l9=new JLabel("Amount");
		l9.setFont(fo4);
		l9.setBounds(350, 190, 100, 30);
		
		Amt=new JTextField();
		Amt.setFont(fo3);
		Amt.setEditable(false);
		Amt.setBounds(340, 225, 100, 25);
		
		dlm2=new DefaultListModel();
		li2=new JList(dlm2);
		li2.setFont(fo3);
		li2.setBorder(BorderFactory.createLineBorder(Color.gray));
		li2.setBounds(340, 255, 100, 175);
		
		Add=new JButton("Add");
		Add.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		Add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    Add.setForeground(new Color(75,0,0));
	    Add.setBackground(new Color(248, 227, 250));
		Add.setFont(fo4);
		Add.addKeyListener(this);
		Add.addActionListener(this);
		Add.setBounds(450, 225, 75, 25);
		
		l10=new JLabel("Total :");
		l10.setFont(fo2);
		l10.setBounds(240, 450, 100, 25);
		
		t1=new JTextField("0");
		t1.setEditable(false);
		t1.setFont(fo3);
		t1.setBounds(340, 450, 100, 25);
		
		l11=new JLabel("Discount :");
		l11.setFont(fo2);
		l11.setBounds(240, 485, 100, 25);
		
		t2=new JTextField("0");
		t2.setFont(fo3);
		t2.addKeyListener(this);
		t2.setBounds(340, 485, 100, 25);
		
		l12=new JLabel("Grant Total :");
		l12.setFont(fo2);
		l12.setBounds(240, 520, 100, 25);
		
		t3=new JTextField();
		t3.setFont(fo3);
		t3.setEditable(false);
		t3.setBounds(340, 520, 100, 25);
		
		l13=new JLabel("Paid Amt :");
		l13.setFont(fo2);
		l13.setBounds(240, 555, 100, 25);
		
		t4=new JTextField();
		t4.setFont(fo3);
		t4.addKeyListener(this);
		t4.setBounds(340, 555, 100, 25);
		
		Dues1=new JLabel("Dues :");
		Dues1.setFont(fo2);
		Dues1.setBounds(475, 555, 100, 25);
		
		Dues2=new JLabel();
		Dues2.setFont(fo2);
		Dues2.setBounds(550, 555, 100, 25);
		
		Balance=new JLabel("Balance :");
		Balance.setFont(fo4);
		Balance.setBounds(550, 190, 125, 30);
		
		Bal=new JLabel();
		Bal.setFont(fo3);
		Bal.setBounds(650, 190, 100, 30);
		
		b1=new JButton("Pay");
		b1.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b1.setForeground(new Color(75,0,0));
	    b1.setBackground(new Color(248, 227, 250));
		b1.setFont(fo4);
		b1.addActionListener(this);
		b1.addKeyListener(this);
		b1.setBounds(100, 600, 125, 35);
		
		b2=new JButton("Back");
		b2.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b2.setForeground(new Color(75,0,0));
	    b2.setBackground(new Color(248, 227, 250));
		b2.setFont(fo4);
		b2.addActionListener(this);
		b2.setBounds(325, 600, 125, 35);
		
		b3=new JButton("Print");
		b3.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b3.setForeground(new Color(75,0,0));
	    b3.setBackground(new Color(248, 227, 250));
		b3.setFont(fo4);
		b3.addActionListener(this);
		b3.setBounds(550, 600, 125, 35);
		
		try{
			con=DriverManager.getConnection(url1);
			String sql2="SELECT * FROM Student_Admission Where Registation_Id='"+Registation_no.getText()+"'";
			ResultSet rs2=con.createStatement().executeQuery(sql2);
			if(rs2.next()){
				Cls.setText(rs2.getString("Class"));
				Adm_Form_no.setText(rs2.getString("Admiss_F_No"));
				S_Name.setText(rs2.getString("Name"));
				S_Father_Name.setText(rs2.getString("Fathers_Name"));
				String sql3="SELECT COUNT(Roll)+1 FROM Student_Admission WHERE Class='"+rs2.getString("Class")+"'";
				ResultSet rs3=con.createStatement().executeQuery(sql3);
				if(rs3.next()){
					Rol.setText(rs3.getString(1));
				}
			}
//			String sql8="SELECT Rebate_Type FROM Student_Admission Where Registation_Id='"+Registation_no.getText()+"'";
//			ResultSet rs8=con.createStatement().executeQuery(sql8);
//			String sql9="SELECT Rebate_Amt FROM Student_Admission Where Registation_Id='"+Registation_no.getText()+"'";
//			ResultSet rs9=con.createStatement().executeQuery(sql9);
//			if(rs8.next()){
//				if(rs8.getString(1).equals("")){
//					t2.setText("0");
//				}
//				else if(rs8.getString(1).equals("One")){
//					t2.setText(rs9.getString(1));
//				}
//				else if(rs8.getString(1).equals("Multiple")){
//					t2.setText(rs9.getString(1));
//				}
//				else{
//					t2.setText("0");
//				}
//			}
			String sql6="SELECT Particular_Name FROM Fee_Creation WHERE Class='"+Cls.getText()+"'";
			Statement st6=con.createStatement();
			ResultSet rs6=st6.executeQuery(sql6);
			cb1.addItem("---(Select)---");
			while(rs6.next()){
				cb1.addItem(rs6.getString(1));
			}
			
			con.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		f1.add(l1);f1.add(l2);
		f1.add(l3);f1.add(l4);
		f1.add(l5);f1.add(l6);
		f1.add(l7);f1.add(l8);
		f1.add(l9);f1.add(l10);
		f1.add(l11);f1.add(l12);
		f1.add(l13);
		
		f1.add(Recipt_no);f1.add(Registation_no);
		f1.add(Payment_date);f1.add(Adm_Form_no);
		f1.add(Class);f1.add(Cls);
		f1.add(Roll);f1.add(Rol);
		f1.add(S_Name);f1.add(S_Father_Name);
		f1.add(Dues1);f1.add(Dues2);
		f1.add(Balance);f1.add(Bal);
		
		f1.add(li1);f1.add(li2);
		
		f1.add(cb1);f1.add(Amt);
		
		f1.add(t1);f1.add(t2);
		f1.add(t3);f1.add(t4);
		
		f1.add(b1);
//		f1.add(b2);
		f1.add(b3);f1.add(Add);
		
		f1.setSize(800,675);
		f1.setLayout(null);
		f1.setLocationRelativeTo(null);
        f1.setResizable(false);
        f1.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		f1.setVisible(true);
	}
	public void ParticularClick(){
		try{
			con=DriverManager.getConnection(url1);
			String sql4="SELECT Amount FROM Fee_Creation WHERE Class='"+Cls.getText()+"' and Particular_Name='"+cb1.getSelectedItem()+"'";
			Statement st4=con.createStatement();
			ResultSet rs4=st4.executeQuery(sql4);
			if(rs4.next()){
				Amt.setText(rs4.getString(1));
			}
			else{
				Amt.setText("");
			}
		}
		catch(Exception e){
			
		}
	}
	@SuppressWarnings("unchecked")
	public void AddClick(){
		if(cb1.getSelectedItem().equals("---(Select)---")){
			JOptionPane.showMessageDialog(null, "Please Choose Particular");
			cb1.requestFocus();
		}
		else{
//			if(dlm1.getElementAt(5).equals(cb1.getSelectedItem())){
//				JOptionPane.showMessageDialog(null, "Particular already exist in List");
//			}
//			else{
				dlm1.addElement(cb1.getSelectedItem());
				dlm2.addElement(Amt.getText());
				t1.setText(String.valueOf(Integer.parseInt(t1.getText())+Integer.parseInt(Amt.getText())));
				t3.setText(String.valueOf(Integer.parseInt(t1.getText())-Integer.parseInt(t2.getText())));
				cb1.requestFocus();
//			}
		}
	}
	public void PayClick(){
		if((li1.getModel().getSize())==0){
			JOptionPane.showMessageDialog(null, "Please Add Particular");
			cb1.requestFocus();
		}
		else if(t4.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please Enter Paid Amount");
			t4.requestFocus();
		}
		else{
			try{
				con=DriverManager.getConnection(url1);
				for(int i=0; i<li1.getModel().getSize(); i++){
					String sql5="INSERT INTO Particular_Amt(Receipt_No,Registation_Id,Class,Roll,Particular,Amount) VALUES('"+Recipt_no.getText()+"','"+Registation_no.getText()+"','"+Cls.getText()+"','"+Rol.getText()+"','"+li1.getModel().getElementAt(i)+"','"+li2.getModel().getElementAt(i)+"')";
					Statement st5=con.createStatement();
					st5.executeUpdate(sql5);
				}
				String sql8="INSERT INTO Student_Payment(Receipt_No,Payment_Date,Registation_Id,Admiss_F_No,Class,Roll,Student_Name,Fathers_Name,Total,Discount,Grant_Total,Paid_Amt) VALUES('"+Recipt_no.getText()+"','"+Payment_date.getText()+"','"+Registation_no.getText()+"','"+Adm_Form_no.getText()+"','"+Cls.getText()+"','"+Rol.getText()+"','"+S_Name.getText()+"','"+S_Father_Name.getText()+"','"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"')";
				Statement st8=con.createStatement();
				st8.executeUpdate(sql8);
				JOptionPane.showMessageDialog(null, "Payment SucessFully");
				Dues2.setText(String.valueOf(Integer.parseInt(t4.getText())-Integer.parseInt(t3.getText())));
				Bal.setText(Dues2.getText());
				String sql6="UPDATE Student_Payment SET Balance='"+Bal.getText()+"'WHERE Receipt_No='"+Recipt_no.getText()+"'";
				Statement st6=con.createStatement();
				st6.executeUpdate(sql6);
				String sql61="UPDATE Student_Payment SET Dues='"+Dues2.getText()+"'WHERE Receipt_No='"+Recipt_no.getText()+"'";
				Statement st61=con.createStatement();
				st6.executeUpdate(sql61);
				String sql7="UPDATE Student_Admission SET Roll='"+Rol.getText()+"' WHERE Registation_Id='"+Registation_no.getText()+"'";
				Statement st7=con.createStatement();
				st7.executeUpdate(sql7);
				con.close();
				b1.setEnabled(false);
//				f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
			catch(Exception e1){
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}	
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cb1){
			ParticularClick();
		}
		else if(e.getSource()==Add){
			AddClick();
		}
		else if(e.getSource()==b1){
			PayClick();
		}
		
	}
	public static void main(String[] args) {
//		new Payment_Process();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==10){
			if(e.getSource()==cb1){
				if(cb1.getSelectedItem().equals("---(Select)---")){
					JOptionPane.showMessageDialog(null, "Please Choose Particular");
					cb1.requestFocus();
				}
				else{
					Add.requestFocus();
				}
			}
			else if(e.getSource()==Add){
				AddClick();
			}
			else if(e.getSource()==t2){
				if(t2.getText().equals("")){
					t4.requestFocus();
				}
				else{
					t3.setText(String.valueOf(Integer.parseInt(t1.getText())-Integer.parseInt(t2.getText())));
					t4.requestFocus();
				}
			}
			else if(e.getSource()==t4){
				if(t4.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Paid Amount");
					t4.requestFocus();
				}
				else{
					b1.requestFocus();
				}
			}
			else if(e.getSource()==b1){
				PayClick();
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
}
