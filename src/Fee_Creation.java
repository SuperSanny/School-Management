import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Fee_Creation implements ActionListener, KeyListener{

JFrame f1;
JLabel l1,l2,l3,l4,l5,l6,l7,t1,bg32;
JTextField t2,t3,t4;
JComboBox cb1,cb2;
JList li1,li2,li3,li4;
JButton b1,b2,b3,b4;
Font fo1,fo2,fo3,fo4;
DefaultListModel dlm1,dlm2,dlm3,dlm4;
String path1,url1,id;
Connection con;
	
JPanel p1;
ImageIcon i1;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Fee_Creation() {
		f1=new JFrame("Fee Creation");
		
		path1="C:/Users/LENOVO/workspace/eclipse/School Management/DateBase/School_Detail.accdb";
		url1="jdbc:ucanaccess://"+path1;
		
		id="1001";
		
		fo1=new Font("Cooper Black",Font.PLAIN,24);
		fo2=new Font("Cambria",Font.BOLD,18);
		fo3=new Font("Bell MT",Font.BOLD,20);
		fo4=new Font("Bell MT",Font.BOLD,22);
		
		l1=new JLabel("Fee Creation");
		l1.setFont(fo1);
		l1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.red));
		l1.setBounds(210, 10, 160, 30);
		
		l2=new JLabel("Fee Id :");
		l2.setFont(fo2);
		l2.setBounds(30, 70, 100, 25);
		
		t1=new JLabel();//t1 for Fee id;
//		try{
//			con=DriverManager.getConnection(url1);
//			String sql1="SELECT COUNT(Particular_Id)+1001 FROM Fee_Creation";
//			Statement st1=con.createStatement();
//			ResultSet rs1=st1.executeQuery(sql1);
//			if(rs1.next()){
//				t1.setText(rs1.getString(1));
//			}
//			con.close();
//		}
//		catch(Exception e){
//			JOptionPane.showMessageDialog(null, e.getMessage());
//		}
		t1.setFont(fo3);
		t1.setBounds(130, 70, 125, 25);
		
		
		l3=new JLabel("Class :");
		l3.setFont(fo2);
		l3.setBounds(300, 70, 100, 25);
		
		cb1=new JComboBox();//cb1 for Select Class;
		try{
			con=DriverManager.getConnection(url1);
			String sql1="SELECT Class FROM Class ";
			Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery(sql1);
			while(rs1.next()){
				cb1.addItem(rs1.getString(1));
			}
			con.close();
			t1.setText("fc00"+(cb1.getSelectedIndex()+1));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		cb1.setFont(fo3);
		cb1.addKeyListener(this);
		cb1.addActionListener(this);
		cb1.setBounds(375, 70, 100, 25);
		
		l4=new JLabel("Sr.No. ");
		l4.setFont(fo2);
		l4.setBounds(25, 125, 60, 25);
		
		t2=new JTextField("1");//t2 for Srial Number;
		t2.setFont(fo3);
		t2.setOpaque(false);
		t2.setEditable(false);
		t2.setBounds(25, 160, 60, 25);
		
		dlm1=new DefaultListModel();
		li1=new JList(dlm1);//li1 for Store Srial Number in a row;
		li1.setFont(fo3);
		li1.setOpaque(false);
		li1.setBorder(BorderFactory.createLineBorder(Color.gray));
		li1.setBounds(25, 200, 60, 180);

		l5=new JLabel("Particular Id");
		l5.setFont(fo2);
		l5.setBounds(105, 125, 115, 25);
		
		t3=new JTextField();//t3 for Particular Id;
		t3.setFont(fo3);
		t3.setOpaque(false);
		t3.setEditable(false);
		t3.setBounds(105, 160, 115, 25);
		
		dlm2=new DefaultListModel();
		li2=new JList(dlm2);//li2 for store Particular in a row;
		li2.setFont(fo3);
		li2.setOpaque(false);
		li2.setBorder(BorderFactory.createLineBorder(Color.gray));
		li2.setBounds(105, 200, 115, 180);
		
		l6=new JLabel("Particular Name");
		l6.setFont(fo2);
		l6.setBounds(240, 125, 150, 25);
		
		cb2=new JComboBox();//cb2 for choose Particular Name;
		cb2.setFont(fo3);
		try{
			con=DriverManager.getConnection(url1);
			String sql2="SELECT Particular_Name FROM Fee_Particular Order by(Particular_Name)";
			Statement st2=con.createStatement();
			ResultSet rs2=st2.executeQuery(sql2);
			cb2.addItem("--Select--");
			while(rs2.next()){
				cb2.addItem(rs2.getString(1));
			}
			con.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		cb2.addKeyListener(this);
		cb2.addActionListener(this);
		cb2.setBounds(240, 160, 150, 25);
		
		dlm3=new DefaultListModel();
		li3=new JList(dlm3);//li3 for store Particular Name in a row;
		li1.setAutoscrolls(true);
		li3.setFont(fo3);
		li3.setOpaque(false);
		li3.setBorder(BorderFactory.createLineBorder(Color.gray));
		li3.setBounds(240, 200, 150, 180);
		
		
		l7=new JLabel("Amount");
		l7.setFont(fo2);
		l7.setBounds(410, 125, 75, 25);
		
		t4=new JTextField();//t4 for Amount;
		t4.setFont(fo3);
		t4.setOpaque(false);
		t4.addKeyListener(this);
		t4.setBounds(410, 160, 75, 25);
		
		dlm4=new DefaultListModel();
		li4=new JList(dlm4);//li4 for Store amount in a row;
		li4.setFont(fo3);
		li4.setOpaque(false);
		li4.setBorder(BorderFactory.createLineBorder(Color.gray));
		li4.setBounds(410, 200, 75, 180);
		
		b1=new JButton("Add");
		b1.setFont(fo4);
		b1.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b1.setForeground(new Color(75,0,0));
	    b1.setBackground(new Color(248, 227, 250));
		b1.addActionListener(this);
		b1.addKeyListener(this);
		b1.setBounds(500, 155, 75, 30);
		
		b2=new JButton("Define");
		b2.setFont(fo4);
		b2.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b2.setForeground(new Color(75,0,0));
	    b2.setBackground(new Color(248, 227, 250));
		b2.addActionListener(this);
		b2.setBounds(55, 420, 125, 35);
		
		b3=new JButton("Clear");
		b3.setFont(fo4);
		b3.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b3.setForeground(new Color(75,0,0));
	    b3.setBackground(new Color(248, 227, 250));
		b3.addActionListener(this);
		b3.setBounds(235, 420, 125, 35);
		
		b4=new JButton("Close");
		b4.setFont(fo4);
		b4.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b4.setForeground(new Color(75,0,0));
	    b4.setBackground(new Color(248, 227, 250));
		b4.addActionListener(this);
		b4.setBounds(420, 420, 125, 35);
		
		bg32=new JLabel();  
	    bg32.setBounds(0,0,600,500);
	    bg32.setBackground(Color.LIGHT_GRAY);
		ImageIcon img=new ImageIcon("images/bg32.png");
		Image img1=img.getImage().getScaledInstance(bg32.getWidth(), bg32.getHeight(), Image.SCALE_SMOOTH);
		i1=new ImageIcon(img1);
//		bg32.setIcon(i1);
		
		f1.add(l1);f1.add(l2);
		f1.add(l3);f1.add(l4);
		f1.add(l5);f1.add(l6);
		f1.add(l7);
		
		f1.add(t1);f1.add(t2);
		f1.add(t3);f1.add(t4);
		f1.add(li1);
		f1.add(li2);
		f1.add(li3);f1.add(li4);
		f1.add(cb1);f1.add(cb2);
		f1.add(b1);f1.add(b2);
		f1.add(b3);f1.add(b4);
		
		f1.add(bg32);
		
		f1.setSize(600,500);
        f1.setLayout(null);
        f1.setLocationRelativeTo(null);
        f1.setResizable(false);
//        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
	}

	public static void main(String[] args) {
		new Fee_Creation();

	}

	@SuppressWarnings("unchecked")
	public void AddClick(){
		if(cb1.getSelectedItem().equals("")){
			
		}
		else if(cb2.getSelectedItem().equals("--Select--")){
			JOptionPane.showMessageDialog(null, "Please choose Particular Name");
			cb2.requestFocus();
		}
		else if(t4.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please Enter Amount");
			t4.requestFocus();
		}
		else{
			try{
				con=DriverManager.getConnection(url1);
				String sql6="SELECT * FROM Fee_Creation WHERE Fee_Id='"+t1.getText()+"' and Particular_Id='"+t3.getText()+"'";
				Statement st6=con.createStatement();
				ResultSet rs6=st6.executeQuery(sql6);
				if(rs6.next()){
					JOptionPane.showMessageDialog(null, "Particular already Exist");
					cb2.setSelectedIndex(0);
					cb2.requestFocus();
				}
				else{
					dlm1.addElement(t2.getText());
					dlm2.addElement(t3.getText());
					dlm3.addElement(cb2.getSelectedItem());
					dlm4.addElement(t4.getText());
					cb2.setSelectedIndex(0);
					t2.setText(String.valueOf(li1.getModel().getSize()+1));
					t4.setText("");
					cb2.requestFocus();
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		
		
	}
	public void ClassClick(){
		try{
			con=DriverManager.getConnection(url1);
			String sql3="SELECT * FROM Class Where Class='"+cb1.getSelectedItem()+"'";
			Statement st3=con.createStatement();
			ResultSet rs3=st3.executeQuery(sql3);
			while(rs3.next()){
				t1.setText("fc00"+(cb1.getSelectedIndex()+1));
				t2.setText("1");
				t3.setText("");
				cb2.setSelectedIndex(0);
				t4.setText("");
				dlm1.removeAllElements();
				dlm2.removeAllElements();
				dlm3.removeAllElements();
				dlm4.removeAllElements();
			}
			con.close();
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
		
	}
	public void ParticularClick(){
		if(cb2.getSelectedItem().equals("--Select--")){
			cb2.requestFocus();
			t3.setText("");
		}
		else{
			try{
				con=DriverManager.getConnection(url1);
				String sql4="SELECT * FROM Fee_Particular Where Particular_Name='"+cb2.getSelectedItem()+"'";
				Statement st4=con.createStatement();
				ResultSet rs4=st4.executeQuery(sql4);
//				String sql7="SELECT COUNT(Sr_No)+1 FROM Fee_Creation Where Fee_Id='"+t1.getText()+"'";
//				Statement st7=con.createStatement();
//				ResultSet rs7=st7.executeQuery(sql7);
				while(rs4.next()){
					t3.setText(rs4.getString(1));
				}
//				while(rs7.next()){
//					t2.setText(rs7.getString(1));
//				}
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
		
	}
	public void ClearAll(){
		cb1.setSelectedIndex(0);
		t2.setText("1");
		t3.setText(null);
		cb2.setSelectedIndex(0);
		t4.setText(null);
		dlm1.removeAllElements();
		dlm2.removeAllElements();
		dlm3.removeAllElements();
		dlm4.removeAllElements();
		
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==10){
			if(e.getSource()==cb1){
				ClassClick();
				cb2.requestFocus();
			}
			else if(e.getSource()==cb2){
				if(cb2.getSelectedItem().equals("--Select--")){
					JOptionPane.showMessageDialog(null, "Please Choose Particular Name");
					cb2.requestFocus();
					t3.setText("");
				}
				else{
					ParticularClick();	
					t4.requestFocus();
				}
			}
			else if(e.getSource()==t4){
				if(t4.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Amount");
					t4.requestFocus();
				}
				else{
					b1.requestFocus();
					
				}
			}
			else if(e.getSource()==b1){
				AddClick();
			}
			else{
				
			}
		}
		
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){
			AddClick();
		}
		else if(e.getSource()==b2){
			if((li1.getModel().getSize())==0){
				JOptionPane.showMessageDialog(null, "Please choose Particular");
				cb2.requestFocus();
			}
			else{
				if((li1.getModel().getSize())==0){
					JOptionPane.showMessageDialog(null, "Please Add Particular Name with Amount");
					cb2.requestFocus();
					
				}
				else{
					try{
						con=DriverManager.getConnection(url1);
						for(int i=0; i<li1.getModel().getSize(); i++){
							String sql5="INSERT INTO Fee_Creation(Fee_Id,Class,Sr_No,Particular_Id,Particular_Name,Amount) VALUES('"+t1.getText()+"','"+cb1.getSelectedItem()+"','"+li1.getModel().getElementAt(i)+"','"+li2.getModel().getElementAt(i)+"','"+li3.getModel().getElementAt(i)+"','"+li4.getModel().getElementAt(i)+"')";
							Statement st5=con.createStatement();
							st5.executeUpdate(sql5);
						}
						con.close();
						JOptionPane.showMessageDialog(null, "Define SucessFully");
						ClearAll();
						cb1.requestFocus();
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
			
		}
		else if(e.getSource()==b3){
			ClearAll();
		}
		else if(e.getSource()==b4){
			f1.dispose();
		}
		else if(e.getSource()==cb1){
			ClassClick();
		}
		else if(e.getSource()==cb2){
			ParticularClick();
		}
	}

}
