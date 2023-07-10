import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableModel;

import org.hsqldb.Table;

import java.sql.*;

public class Payment_Details implements ActionListener,KeyListener,MouseListener {

	JFrame f1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,R_Id,A_F_No,S_Name,Bal,F_Name,M_Name;
	JTextField t1;
	JComboBox cb1;
	JButton b1,b2;
	JPanel p1;
	JTable table,table1;
	Font fo1,fo2,fo3,fo4;
	Connection con;
	String path,url;
	String Col[]={"Reciept No.","Payment Date","Monthly","Total","Discount","Grand Total","Paid Amount","Dues",};
	String Row[][]=new String [25][8];
	
	String Col1[]={"Particular","Amount"};
	String Row1[][]=new String [25][2];
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	Payment_Details(){
		
		f1=new JFrame("Payment Details");
		
		path="C:/Users/LENOVO/workspace/eclipse/School Management/DateBase/School_Detail.accdb";
		url="jdbc:ucanaccess://"+path;
		
		
		fo1=new Font("Bookman Old Style",Font.BOLD,22);
		fo2=new Font("Cambria",Font.PLAIN,18);
		fo3=new Font("Cambria",Font.BOLD,18);
		fo4=new Font("Cambria",Font.BOLD,20);
		
		l1=new JLabel("Payment Details");
		l1.setFont(fo1);
		l1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.red));
		l1.setBounds(290, 0, 190, 35);
		f1.add(l1);
		
		l2=new JLabel("Class :");
		l2.setFont(fo2);
		l2.setBounds(125, 75, 100, 25);
		f1.add(l2);
		
		cb1=new JComboBox();
		cb1.addItem("--Select--");
		try{
			con=DriverManager.getConnection(url);
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
		cb1.setBounds(200, 75, 125, 25);
		f1.add(cb1);
		
		l3=new JLabel("Roll :");
		l3.setFont(fo2);
		l3.setBounds(375, 75, 175, 25);
		f1.add(l3);
		
		t1=new JTextField();
		t1.setFont(fo3);
		t1.addKeyListener(this);
		t1.setBounds(425, 75, 100, 25);
		f1.add(t1);

		b1=new JButton("Search");
		b1.setFont(fo4);
		b1.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
	    b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b1.setForeground(new Color(75,0,0));
	    b1.setBackground(new Color(248, 227, 250));
		b1.addKeyListener(this);
		b1.addActionListener(this);
		b1.setBounds(575, 75, 100, 25);
		f1.add(b1);
		
		p1= new JPanel();
//		p1.setBackground(Color.red);
		p1.setLayout(null);
		p1.setVisible(false);
		p1.setBounds(0, 120, 800,520);
		f1.add(p1);
		
		l4=new JLabel();// l4 = Student Photo
		l4.setBounds(10, 5, 150, 150);
		l4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		p1.add(l4);
		
		l5=new JLabel("Registation Id:");
		l5.setFont(fo2); 
		l5.setBounds(185, 5, 175, 25);
		p1.add(l5);
		
		R_Id=new JLabel();
		R_Id.setFont(fo3);
		R_Id.setBounds(315, 5, 125, 25);
		p1.add(R_Id);
		
		l6=new JLabel("Admission Form No. :");
		l6.setFont(fo2);
		l6.setBounds(460, 5, 175, 25);
		p1.add(l6);
		
		A_F_No=new JLabel();
		A_F_No.setFont(fo3);
		A_F_No.setBounds(635, 5, 100, 25);
		p1.add(A_F_No);
		
		l7=new JLabel("Student Name :");
		l7.setFont(fo2); 
		l7.setBounds(185, 45, 175, 25);
		p1.add(l7);
		
		S_Name=new JLabel();
		S_Name.setFont(fo3);
		S_Name.setBounds(315, 45, 250, 25);
		p1.add(S_Name);
		
		l8=new JLabel("Balance :");
		l8.setFont(fo2); 
		l8.setBounds(560, 45, 100, 25);
		p1.add(l8);
		
		Bal=new JLabel();
		Bal.setFont(fo3);
		Bal.setBounds(635, 45, 100, 25);
		p1.add(Bal);
		
		l9=new JLabel("Father's Name :");
		l9.setFont(fo2); 
		l9.setBounds(185, 85, 175, 25);
		p1.add(l9);
		
		F_Name=new JLabel();
		F_Name.setFont(fo3);
		F_Name.setBounds(315, 85, 250, 25);
		p1.add(F_Name);
		
		l10=new JLabel("Mother's Name :");
		l10.setFont(fo2); 
		l10.setBounds(185, 125, 175, 25);
		p1.add(l10);
		
		M_Name=new JLabel();
		M_Name.setFont(fo3);
		M_Name.setBounds(315, 125, 250, 25);
		p1.add(M_Name);

		table=new JTable(Row,Col);
		table.addMouseListener(this);
		p1.add(table);
		JScrollPane pane=new JScrollPane(table);
		pane.setBounds(10, 170, 600, 275);
		p1.add(pane);
		
		table1=new JTable(Row1,Col1);
		p1.add(table1);
		JScrollPane pane1=new JScrollPane(table1);
		pane1.setBounds(610, 170, 180, 275);
		p1.add(pane1);
		
		b2=new JButton("Close");
		b2.setFont(fo4);
		b2.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
	    b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b2.setForeground(new Color(75,0,0));
	    b2.setBackground(new Color(248, 227, 250));
		b2.addKeyListener(this);
		b2.addActionListener(this);
		b2.setBounds(340, 485, 100, 25);
		p1.add(b2);
		
		f1.setSize(800,675);
		f1.setLayout(null);
		f1.setLocationRelativeTo(null);
        f1.setResizable(false);
//        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
		
	}
	public void SearchClick(){
		try{
			con=DriverManager.getConnection(url);
			String sql1="SELECT * FROM Student_Admission Where Class='"+cb1.getSelectedItem()+"' and Roll='"+t1.getText()+"' ";
			Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery(sql1);
			
			if(!rs1.next()){
				JOptionPane.showMessageDialog(null, "Class And Roll not Found!");
				cb1.requestFocus();
			}
			else{
				p1.setVisible(true);
				A_F_No.setText(rs1.getString("Admiss_F_No"));
				R_Id.setText(rs1.getString("Registation_Id"));
				ImageIcon img1=new ImageIcon(rs1.getString("S_Photo"));
				Image img2=img1.getImage().getScaledInstance(l4.getWidth(), l4.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon i=new ImageIcon(img2);
				l4.setIcon(i);
				S_Name.setText(rs1.getString("Name"));
				F_Name.setText(rs1.getString("Fathers_Name"));
				M_Name.setText(rs1.getString("Mothers_Name"));
				con=DriverManager.getConnection(url);
				String sql2="SELECT * FROM Student_Payment Where Class='"+cb1.getSelectedItem()+"' and Roll='"+t1.getText()+"' ";
				Statement st2=con.createStatement();
				ResultSet rs2=st2.executeQuery(sql2);
				int a=0,b=0;
				while(rs2.next()){
					Row[a][b++]=rs2.getString("Receipt_No");
					Row[a][b++]=rs2.getString("Payment_Date");
					Row[a][b++]=rs2.getString("Month");
					Row[a][b++]=rs2.getString("Total");
					Row[a][b++]=rs2.getString("Discount");
					Row[a][b++]=rs2.getString("Grant_Total");
					Row[a][b++]=rs2.getString("Paid_Amt");
					Row[a][b++]=rs2.getString("Dues");
					a++;
					b=0;
				}
			}
			con.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public static void main(String[] args) {
		new Payment_Details();

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
			f1.dispose();
		}
		
	}

	@Override
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
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
