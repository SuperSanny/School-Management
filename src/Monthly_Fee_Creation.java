import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Monthly_Fee_Creation implements ActionListener,KeyListener{

	JFrame f1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,fi1;
	JTextField t1,t2,t3;
	@SuppressWarnings("rawtypes")
	DefaultListModel dlm1,dlm2,dlm3;
	@SuppressWarnings("rawtypes")
	JComboBox cb1,cb2,cb3,cb4;
	@SuppressWarnings("rawtypes")
	JList li1,li2,li3;
	JButton b1,b2,b3,b4;
	Font fo1,fo2,fo3,fo4;
	
	String path1,url1,id;
	Connection con;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Monthly_Fee_Creation() {
		f1=new JFrame("Monthly Fee Creation");
		
		path1="C:/Users/LENOVO/workspace/eclipse/School Management/DateBase/School_Detail.accdb";
		url1="jdbc:ucanaccess://"+path1;
		
		id="101";
		
		String Month[]={"(Select)","January","February","March","April","May","June","July","August","September","October","November","December"};
		String Year[]={"(Select)","2020","2021","2022","2023","2024","2025"};
		
		fo1=new Font("Cooper Black",Font.PLAIN,24);
		fo2=new Font("Cambria",Font.BOLD,18);
		fo3=new Font("Bell MT",Font.BOLD,20);
		fo4=new Font("Bell MT",Font.BOLD,22);
		
		l1=new JLabel("Monthly Fee Creation");
		l1.setFont(fo1);
		l1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.red));
		l1.setBounds(115, 10, 270, 30);
		
		l2=new JLabel("Class :");
		l2.setFont(fo2);
		l2.setBounds(30, 50, 75, 25);
		
		l3=new JLabel("Fee ID :");
		l3.setFont(fo2);
		l3.setBounds(280, 50, 75, 25);
		
		fi1=new JLabel();//fi1 for Fee Id;
		fi1.setFont(fo3);
		fi1.setBounds(355, 50, 125, 25);
		
		cb1=new JComboBox();//cb1 for Select Class;
		cb1.addItem("-Select-");
		try{
			con=DriverManager.getConnection(url1);
			String sql1="SELECT Class FROM Class ";
			Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery(sql1);
			while(rs1.next()){
				cb1.addItem(rs1.getString(1));
			}
			fi1.setText("mfc00"+(cb1.getSelectedIndex()+1));
			con.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		cb1.setFont(fo3);
		cb1.addKeyListener(this);
		cb1.addActionListener(this);
		cb1.setBounds(105, 50, 100, 25);
		
		l4=new JLabel("Month :");
		l4.setFont(fo2);
		l4.setBounds(30, 90, 75, 25);
		
		cb2=new JComboBox(Month);//cb2 for Select Month;
		cb2.setFont(fo3);
		cb2.addKeyListener(this);
		cb2.addActionListener(this);
		cb2.setBounds(105, 90, 100, 25);
		
		l5=new JLabel("Year :");
		l5.setFont(fo2);
		l5.setBounds(280, 90, 75, 25);
		
		cb3=new JComboBox(Year);//cb3 for Select Year;
		cb3.setFont(fo3);
		cb3.addKeyListener(this);
		cb3.addActionListener(this);
		cb3.setBounds(355, 90, 100, 25);
		
		l6=new JLabel("Sr.No.");
		l6.setFont(fo2);
		l6.setBounds(35, 130, 60, 25);
		
		t1=new JTextField("1");//t1 for Serial Number;
		t1.setFont(fo3);
		t1.setEditable(false);
		t1.setBounds(32, 160, 60, 25);
		
		dlm1=new DefaultListModel();
		li1=new JList(dlm1);//li1 for Store Serial Number in a row;
		li1.setFont(fo3);
		li1.setBorder(BorderFactory.createLineBorder(Color.gray));
		li1.setBounds(32, 200, 60, 150);
		
		l7=new JLabel("Particular");
		l7.setFont(fo2);
		l7.setBounds(135, 130, 95, 25);
		
		cb4=new JComboBox();// cb4 for Choose Particular Name;
		cb4.addItem("--Select--");
		cb4.setFont(fo3);
		cb4.addKeyListener(this);
		cb4.addActionListener(this);
		cb4.setBounds(120, 160, 120, 25);
		
		dlm2=new DefaultListModel();
		li2=new JList(dlm2);//li2 for Store Particular Name in a row;
		li2.setFont(fo3);
		li2.setBorder(BorderFactory.createLineBorder(Color.gray));
		li2.setBounds(120, 200, 120, 150);
		
		l8=new JLabel("Amount");
		l8.setFont(fo2);
		l8.setBounds(285, 130, 100, 25);
		
		t2=new JTextField();//t2 for Amount;
		t2.setFont(fo3);
		t2.addKeyListener(this);
		t2.setBounds(270, 160, 100, 25);
		
		dlm3=new DefaultListModel();
		li3=new JList(dlm3);//li3 for Store Amount in a row;
		li3.setFont(fo3);
		li3.setBorder(BorderFactory.createLineBorder(Color.gray));
		li3.setBounds(270, 200, 100, 150);
		
		l9=new JLabel("Total :");
		l9.setFont(fo2);
		l9.setBounds(185, 370, 60, 25);
		
		t3=new JTextField("0");//t3 for Total amount;
		t3.setFont(fo3);
		t3.setBounds(270, 370, 100, 25);
		
		b1=new JButton("Add");
		b1.setFont(fo4);
		b1.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b1.setForeground(new Color(75,0,0));
	    b1.setBackground(new Color(248, 227, 250));
		b1.addActionListener(this);
		b1.addKeyListener(this);
		b1.setBounds(390, 157, 75, 30);
		
		b2=new JButton("Ok");
		b2.setFont(fo4);
		b2.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b2.setForeground(new Color(75,0,0));
	    b2.setBackground(new Color(248, 227, 250));
		b2.addActionListener(this);
		b2.setBounds(33, 420, 123, 35);
		
		b3=new JButton("Clear");
		b3.setFont(fo4);
		b3.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b3.setForeground(new Color(75,0,0));
	    b3.setBackground(new Color(248, 227, 250));
		b3.addActionListener(this);
		b3.setBounds(189, 420, 123, 35);
		
		b4=new JButton("Close");
		b4.setFont(fo4);
		b4.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b4.setForeground(new Color(75,0,0));
	    b4.setBackground(new Color(248, 227, 250));
		b4.addActionListener(this);
		b4.setBounds(347, 420, 123, 35);
		
		f1.add(l1);f1.add(l2);
		f1.add(l3);f1.add(l4);
		f1.add(l5);f1.add(l6);
		f1.add(l7);f1.add(l8);
		f1.add(l9);
		
		f1.add(fi1);f1.add(cb2);
		f1.add(cb3);f1.add(t1);
		f1.add(t2);f1.add(t3);
		
		f1.add(cb1);f1.add(cb4);
		
		f1.add(li1);f1.add(li2);
		f1.add(li3);
		
		f1.add(b1);f1.add(b2);
		f1.add(b3);f1.add(b4);
		
		f1.setSize(500,500);
        f1.setLayout(null);
        f1.setLocationRelativeTo(null);
        f1.setResizable(false);
//        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
	}

	public static void main(String[] args) {
		new Monthly_Fee_Creation();

	}

	@SuppressWarnings("unchecked")
	public void ClassClick(){
		try{
			cb4.removeAllItems();
			cb4.addItem("--Select--");
			con=DriverManager.getConnection(url1);
			String sql2="SELECT Particular_Id FROM Fee_Creation WHERE Class='"+cb1.getSelectedItem()+"'";
			Statement st2=con.createStatement();
			ResultSet rs2=st2.executeQuery(sql2);
			while(rs2.next()){
				String sql3="SELECT Particular_Name FROM Fee_Creation WHERE Particular_Id='"+rs2.getString(1)+"'";
				Statement st3=con.createStatement();
				ResultSet rs3=st3.executeQuery(sql3);
				if(rs3.next()){
					cb4.addItem(rs3.getString(1));
				}
				cb2.setSelectedIndex(0);
				cb3.setSelectedIndex(0);
				t1.setText("1");
				t2.setText(" ");
				t3.setText("0");
				dlm1.removeAllElements();
				dlm2.removeAllElements();
				dlm3.removeAllElements();
			}
			fi1.setText("mfc00"+(cb1.getSelectedIndex()+1));
			con.close();
		}
	catch(Exception e1){
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
	public void ParticularClick(){
		try{
			con=DriverManager.getConnection(url1);
			String sql4="SELECT Amount FROM Fee_Creation WHERE Class='"+cb1.getSelectedItem()+"' and Particular_Name='"+cb4.getSelectedItem()+"'";
			Statement st4=con.createStatement();
			ResultSet rs4=st4.executeQuery(sql4);
			if(rs4.next()){
				t2.setText(rs4.getString(1));
			}
			else{
				t2.setText("");
			}
		}
		catch(Exception e){
			
		}
	}
	@SuppressWarnings("unchecked")
	public void AddClick(){
		if(cb1.getSelectedItem().equals("-Select-")){
			JOptionPane.showMessageDialog(null, "Please Choose Class");
			cb1.requestFocus();
		}
		else if(cb2.getSelectedIndex()==0){
			JOptionPane.showMessageDialog(null, "Please Choose Month");
			cb2.requestFocus();
		}
		else if(cb3.getSelectedIndex()==0){
			JOptionPane.showMessageDialog(null, "Please Choose Year");
			cb3.requestFocus();
		}
		else if(cb4.getSelectedIndex()==0){
			JOptionPane.showMessageDialog(null, "Please Choose Particular");
			cb4.requestFocus();
		}
//		else if(t2.getText().equals("")){
//			JOptionPane.showMessageDialog(null, "Please Enter Amount");
//			t2.requestFocus();
//		}
		else{
			dlm1.addElement(t1.getText());
			dlm2.addElement(cb4.getSelectedItem());
			dlm3.addElement(t2.getText());
			t1.setText(String.valueOf(li1.getModel().getSize()+1));
			t3.setText(String.valueOf(Integer.parseInt(t3.getText())+Integer.parseInt(t2.getText())));
			cb4.requestFocus();
			t2.setText(null);
		}
	}
	public void ClearAll(){
		cb1.setSelectedIndex(0);
		cb2.setSelectedIndex(0);
		cb3.setSelectedIndex(0);
		t1.setText("1");
		cb4.setSelectedIndex(0);
		t2.setText(null);
		dlm1.removeAllElements();
		dlm2.removeAllElements();
		dlm3.removeAllElements();
		t3.setText("");
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==10){
			if(e.getSource()==cb1){
				if(cb1.getSelectedItem().equals("-Select-")){
					JOptionPane.showMessageDialog(null, "Please Choose Class");
					cb1.requestFocus();
				}
				else{
					cb3.requestFocus();
				}
				ClassClick();
				cb2.requestFocus();
			}
			else if(e.getSource()==cb2){
				if(cb2.getSelectedItem().equals("(Select)")){
					JOptionPane.showMessageDialog(null, "Please Choose Month");
					cb2.requestFocus();
				}
				else{
					cb3.requestFocus();
				}
			}
			else if(e.getSource()==cb3){
				if(cb3.getSelectedItem().equals("(Select)")){
					JOptionPane.showMessageDialog(null, "Please Choose Year");
					cb3.requestFocus();
				}
				else{
					cb4.requestFocus();
				}
			}
			else if(e.getSource()==cb4){
				if(cb4.getSelectedItem().equals("--Select--")){
					JOptionPane.showMessageDialog(null, "Please Choose Particular");
					cb4.requestFocus();
				}
				else{
					t2.requestFocus();
				}
			}
			else if(e.getSource()==t2){
				if(t2.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Amount");
					t2.requestFocus();
				}
				else{
					b1.requestFocus();
				}
			}
			else if(e.getSource()==b1){
				AddClick();
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

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){
			AddClick();
			
		}
		else if(e.getSource()==b2){
			if((li1.getModel().getSize())==0){
				JOptionPane.showMessageDialog(null, "Please choose Particular");
				cb4.requestFocus();
			}
			else{
				if((li1.getModel().getSize())==0){
					JOptionPane.showMessageDialog(null, "Please Add Particular with Amount");
					cb4.requestFocus();
				}
				else{
					try{
						con=DriverManager.getConnection(url1);
						for(int i=0; i<li1.getModel().getSize(); i++){
							String sql5="INSERT INTO Monthly_Fee_Creation(Class,Fee_Id,Month,Year,Sr_No,Particular,Amount,Total) VALUES('"+cb1.getSelectedItem()+"','"+fi1.getText()+"','"+cb2.getSelectedItem()+"','"+cb3.getSelectedItem()+"','"+li1.getModel().getElementAt(i)+"','"+li2.getModel().getElementAt(i)+"','"+li3.getModel().getElementAt(i)+"','"+t3.getText()+"')";
							Statement st5=con.createStatement();
							st5.executeUpdate(sql5);
						}
						con.close();
						JOptionPane.showMessageDialog(null, "Monthly Fee Creation SucessFully");
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
		else if(e.getSource()==cb4){
			ParticularClick();
		}
		else{
			
		}
		
	}

}
