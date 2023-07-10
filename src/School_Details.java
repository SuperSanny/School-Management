import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import java.sql.*;
import java.util.*;

class S_Details implements ActionListener, KeyListener, ItemListener, MouseListener {

	JFrame f1;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, logo, P_sign, D_sign, t1, bg1;
	JTextField t2, t3, t4, t5, t8, t9, t10, t11, t12, t13;
	JComboBox cob1, cob2, cob3;
	JCheckBox cb1;
	JButton b1, b2, b3, br1, br2, br3;
	Font fo1, fo2, fo3, fo4;
	FileDialog fd1,fd2,fd3;
	String path, path1, url, url1,logo_p, P_sign_p, D_sign_p;
	Connection conn, con1;

	ImageIcon i,i3,i21,i22;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	S_Details() {
		
		f1 = new JFrame("Student Details");

		path = "C:/Users/LENOVO/workspace/eclipse/School Management/DateBase/State_City.accdb";
		url = "jdbc:ucanaccess://" + path;

		path1 = "C:/Users/LENOVO/workspace/eclipse/School Management/DateBase/School_Detail.accdb";
		url1 = "jdbc:ucanaccess://" + path1;

		fo1 = new Font("Cooper Black", Font.PLAIN, 24);
		fo2 = new Font("Cambria", Font.BOLD, 18);
		fo3 = new Font("Bell MT", Font.BOLD, 20);
		fo4 = new Font("Bell MT", Font.BOLD, 22);

		String stype[] = { "", "Pre-Primary", "Primary", "Uper-Primary", "Secondary", "Higher-Secondary" };

		l1 = new JLabel("School Details");
		l1.setFont(fo1);
		l1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.red));
		l1.setBounds(310, 10, 175, 25);

		l2 = new JLabel("Registration id :");
		l2.setFont(fo2);
		l2.setBounds(10, 50, 150, 25);

		t1 = new JLabel();//t1 for Registation Id;
		try {
			con1 = DriverManager.getConnection(url1);
			String sql1 = "SELECT COUNT(School_Name)+10001 FROM School_Details";
			Statement st1 = con1.createStatement();
			ResultSet rs1 = st1.executeQuery(sql1);
			if (rs1.next()) {
				t1.setText(rs1.getString(1));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		t1.setFont(fo3);
		t1.addKeyListener(this);
		t1.setBounds(160, 50, 150, 25);

		l3 = new JLabel("Establish Date :");
		l3.setFont(fo2);
		l3.setBounds(475, 50, 150, 25);

		t2 = new JTextField("");//t2 for Establish Date;
		t2.setOpaque(false);
		t2.setFont(fo3);
		t2.addKeyListener(this);
		t2.setBounds(625, 50, 150, 25);

		l4 = new JLabel("School Name :");
		l4.setFont(fo2);
		l4.setBounds(10, 85, 150, 25);

		t3 = new JTextField(""); //t3 for School Name;
		t3.setFont(fo3);
		t3.setOpaque(false);
		t3.addKeyListener(this);
		t3.setBounds(160, 85, 400, 25);

		l5 = new JLabel("School Type :");
		l5.setFont(fo2);
		l5.setBounds(10, 120, 150, 25);

		cob1 = new JComboBox(stype); //cob1 for School Type;
		cob1.setFont(fo3);
		cob1.addKeyListener(this);
		cob1.setBounds(160, 120, 150, 25);

		logo = new JLabel(); //logo for School logo;
		logo.setFont(fo2);
		logo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"School Logo"));
		logo.addMouseListener(this);
		logo.setBounds(600, 75, 175, 175);
		logo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

//		br1 = new JButton("Browse");
//		br1.setFont(fo3);
//		br1.addKeyListener(this);
//		br1.addActionListener(this);
//		br1.setBounds(640, 210, 100, 30);

		l6 = new JLabel("Address-1 :");
		l6.setFont(fo2);
		l6.setBounds(10, 155, 150, 25);

		t4 = new JTextField(""); //t4 for Address-1;
		t4.setFont(fo3);
		t4.setOpaque(false);
		t4.addKeyListener(this);
		t4.setBounds(160, 155, 400, 25);

		cb1 = new JCheckBox("Same As");
		cb1.setFont(fo2);
		cb1.setOpaque(false);
		cb1.addItemListener(this);
		cb1.setBounds(185, 185, 150, 25);

		l7 = new JLabel("Address-2 :");
		l7.setFont(fo2);
		l7.setBounds(10, 215, 150, 25);

		t5 = new JTextField("");// t5 for Address-2;
		t5.setFont(fo3);
		t5.setOpaque(false);
		t5.addKeyListener(this);
		t5.setBounds(160, 215, 400, 25);

		l8 = new JLabel("City :");
		l8.setFont(fo2);
		l8.setBounds(10, 250, 150, 25);

		l9 = new JLabel("State :");
		l9.setFont(fo2);
		l9.setBounds(375, 250, 150, 25);

		cob3 = new JComboBox(); // cob3 for Select State;
		try {
			conn = DriverManager.getConnection(url);
			String sql3 = "SELECT State_Name FROM State Order by(State_Name)";
			Statement st3 = conn.createStatement();
			ResultSet rs3 = st3.executeQuery(sql3);
			while (rs3.next()) {
				cob3.addItem(rs3.getString(1));
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		cob3.setFont(fo3);
		cob3.addKeyListener(this);
		cob3.addActionListener(this);
		cob3.setBounds(525, 250, 150, 25);

		cob2 = new JComboBox();//cob2 for Select City;
		cob2.setFont(fo3);
		cob2.addKeyListener(this);
		cob2.setBounds(160, 250, 150, 25);

		l10 = new JLabel("Pin Code :");
		l10.setFont(fo2);
		l10.setBounds(10, 285, 150, 25);

		t8 = new JTextField(""); // t8 for Pin Code;
		t8.setFont(fo3);
		t8.setOpaque(false);
		t8.addKeyListener(this);
		t8.setBounds(160, 285, 150, 25);

		l11 = new JLabel("E-mail id :");
		l11.setFont(fo2);
		l11.setBounds(375, 285, 150, 25);

		t9 = new JTextField(""); // t9 for E-mail id;
		t9.setFont(fo3);
		t9.setOpaque(false);
		t9.addKeyListener(this);
		t9.setBounds(525, 285, 250, 25);

		l12 = new JLabel("Principle Name :");
		l12.setFont(fo2);
		l12.setBounds(10, 320, 150, 25);

		t10 = new JTextField(""); // t10 for Principle Name;
		t10.setFont(fo3);
		t10.setOpaque(false);
		t10.addKeyListener(this);
		t10.setBounds(160, 320, 200, 25);

		l13 = new JLabel("Director Name :");
		l13.setFont(fo2);
		l13.setBounds(10, 355, 150, 25);

		t11 = new JTextField("");// t11 for Director name;
		t11.setFont(fo3);
		t11.setOpaque(false);
		t11.addKeyListener(this);
		t11.setBounds(160, 355, 200, 25);

		l14 = new JLabel("Contact no.-1 :");
		l14.setFont(fo2);
		l14.setBounds(375, 320, 150, 25);

		t12 = new JTextField("");// t12 for Contact no.-1;
		t12.setFont(fo3);
		t12.setOpaque(false);
		t12.addKeyListener(this);
		t12.setBounds(525, 320, 150, 25);

		l15 = new JLabel("Contact no.-2 :");
		l15.setFont(fo2);
		l15.setBounds(375, 355, 150, 25);

		t13 = new JTextField("");// t13 for Contact no.-2;
		t13.setFont(fo3);
		t13.setOpaque(false);
		t13.addKeyListener(this);
		t13.setBounds(525, 355, 150, 25);

		P_sign = new JLabel(); // P_sign for Principle Signature;
		P_sign.setFont(fo2);
		P_sign.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Principle Signature"));
		P_sign.setBounds(60, 400, 300, 170);
		P_sign.addMouseListener(this);
		P_sign.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

//		br2 = new JButton("Browse");
//		br2.setFont(fo3);
//		br2.addKeyListener(this);
//		br2.addActionListener(this);
//		br2.setBounds(160, 540, 100, 30);

		D_sign = new JLabel();// D_sign for Director Signature;
		D_sign.setFont(fo2);
		D_sign.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Director Signature"));
		D_sign.setBounds(425, 400, 300, 170);
		D_sign.addMouseListener(this);
		D_sign.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

//		br3 = new JButton("Browse");
//		br3.setFont(fo3);
//		br3.addKeyListener(this);
//		br3.addActionListener(this);
//		br3.setBounds(525, 540, 100, 30);

		b1 = new JButton("Create");
		b1.setFont(fo4);
        b1.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b1.setForeground(new Color(75,0,0));
        b1.setBackground(new Color(248, 227, 250));
		b1.addKeyListener(this);
		b1.addActionListener(this);
		b1.setBounds(100, 600, 125, 35);

		b2 = new JButton("Clear");
		b2.setFont(fo4);
		b2.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b2.setForeground(new Color(75,0,0));
	    b2.setBackground(new Color(248, 227, 250));
		b2.addActionListener(this);
		b2.setBounds(325, 600, 125, 35);

		b3 = new JButton("Cancel");
		b3.setFont(fo4);
		b3.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b3.setForeground(new Color(75,0,0));
	    b3.setBackground(new Color(248, 227, 250));
		b3.addActionListener(this);
		b3.setBounds(550, 600, 125, 35);
		fd1=new FileDialog(f1,"Open",FileDialog.LOAD);
		fd2=new FileDialog(f1,"Open",FileDialog.LOAD);
		fd3=new FileDialog(f1,"Open",FileDialog.LOAD);
		
        bg1=new JLabel();  
        bg1.setBounds(0,0,800,675);
        bg1.setBackground(Color.LIGHT_GRAY);
        
        ImageIcon img1=new ImageIcon("images/upload.png");
        
		Image img2=img1.getImage().getScaledInstance(logo.getWidth()-10, logo.getHeight()-50, Image.SCALE_SMOOTH);
		i=new ImageIcon(img2);
		logo.setIcon(i);
		
		Image img21=img1.getImage().getScaledInstance(P_sign.getWidth()-10, P_sign.getHeight()-50, Image.SCALE_SMOOTH);
		i21=new ImageIcon(img21);
		P_sign.setIcon(i21);
		
		Image img22=img1.getImage().getScaledInstance(D_sign.getWidth()-10, D_sign.getHeight()-50, Image.SCALE_SMOOTH);
		i22=new ImageIcon(img22);
		D_sign.setIcon(i22);
        
//        ImageIcon img3=new ImageIcon("images/bg11.jpg");
//		Image img4=img3.getImage().getScaledInstance(bg1.getWidth(), bg1.getHeight(), Image.SCALE_SMOOTH);
//		i3=new ImageIcon(img4);
//		
//		bg1.setIcon(i3);
		

		f1.add(l1);f1.add(l2);
		f1.add(l3);f1.add(l4);
		f1.add(l5);f1.add(l6);
		f1.add(l7);f1.add(l8);
		f1.add(l9);f1.add(l10);
		f1.add(l11);f1.add(l12);
		f1.add(l13);f1.add(l14);
		f1.add(l15);f1.add(logo);
		f1.add(P_sign);f1.add(D_sign);

		f1.add(t1);f1.add(t2);
		f1.add(t3);f1.add(t4);
		f1.add(t5);f1.add(cob3);
		f1.add(cob2);f1.add(t8);
		f1.add(t9);f1.add(t10);
		f1.add(t11);f1.add(t12);
		f1.add(t13);

		f1.add(cob1);

		f1.add(cb1);

		f1.add(b1);f1.add(b2);
		f1.add(b3);
//		f1.add(br1);
//		f1.add(br2);
//		f1.add(br3);

		f1.add(bg1);
		
		f1.setSize(800, 675);
		f1.setLayout(null);
		f1.setLocationRelativeTo(null);
		f1.setResizable(false);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
	}

	@SuppressWarnings("unchecked")
	public void comboclick() {
		cob2.requestFocus();
		try {
			cob2.removeAllItems();
			conn = DriverManager.getConnection(url);
			String sql2 = "SELECT City_Name FROM City WHERE State_Name='" + cob3.getSelectedItem() + "' ";
			Statement st2 = conn.createStatement();
			ResultSet rs2 = st2.executeQuery(sql2);
			while (rs2.next()) {
				cob2.addItem(rs2.getString(1));
			}
			conn.close();

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}

	}
	
	public void ClearClick(){
		t2.setText(null);
		t3.setText(null);
		cob1.setSelectedItem("");
		t4.setText(null);
		cb1.setSelected(false);
		t5.setText(null);
		cob3.setSelectedIndex(1);
		t8.setText(null);
		t9.setText(null);
		t10.setText(null);
		t11.setText(null);
		t12.setText(null);
		t13.setText(null);
		t2.requestFocus();
		logo.setIcon(i);
		P_sign.setIcon(i21);
		D_sign.setIcon(i22);
		cob2.removeAllItems();
	}
	public void CreateClick() {

		if (t2.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please Enter Establish Date");
			t2.requestFocus();
		} else if (t3.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please Enter School Name");
			t3.requestFocus();
		} else if (fd1.getFile()==null) {
			JOptionPane.showMessageDialog(null, "Please choose School Logo");
			logo.requestFocus();
//			br1.requestFocus();
		} else if (cob1.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Please choose School Type.");
			cb1.requestFocus();
		} else if (t4.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please Enter Address-1");
			t4.requestFocus();
		} else if (t5.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please Enter Address-2");
			t5.requestFocus();
		} else if (cob2.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Please choose City");
			cob2.requestFocus();
		} else if (cob3.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Please choose State");
			cob3.requestFocus();
		} else if (t8.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please Enter Pin Code");
			t8.requestFocus();
		} else if (t9.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please Enter E-mail Id");
			t9.requestFocus();
		} else if (t10.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please Enter Principle Name");
			t10.requestFocus();
		} else if (fd2.getFile()==null) {
			JOptionPane.showMessageDialog(null, "Please choose Principle Signature");
			P_sign.requestFocus();
//			br2.requestFocus();
		} else if (t12.getText().equals("")) {
			JOptionPane.showMessageDialog(f1, "Please Enter Contact no.-1");
			t12.requestFocus();
		} else {
			try {
				con1 = DriverManager.getConnection(url1);
				String sql12 = "INSERT INTO School_Details(Registration_Id,Establish_Date,School_Name,School_Logo,School_Type,Address1,Address2,City,State,Pin_Code,Email_Id,Principle_Name,Director_Name,Contact_No1,Contact_No2,Principle_Signature,Director_Signature) VALUES('"
						+ t1.getText() + "','" + t2.getText() + "','" + t3.getText() + "','" + logo_p + "','"
						+ cob1.getSelectedItem() + "','" + t4.getText() + "','" + t5.getText() + "','"
						+ cob2.getSelectedItem() + "','" + cob3.getSelectedItem() + "','" + t8.getText() + "','"
						+ t9.getText() + "','" + t10.getText() + "','" + t11.getText() + "','" + t12.getText() + "','"
						+ t13.getText() + "','" + P_sign_p + "','" + D_sign_p + "')";
				Statement st12 = con1.createStatement();
				st12.executeUpdate(sql12);
				con1.close();
				JOptionPane.showMessageDialog(null, "Create SucessFully");
				ClearClick();
				try {
					con1 = DriverManager.getConnection(url1);
					String sql1 = "SELECT COUNT(School_Name)+10001 FROM School_Details";
					Statement st1 = con1.createStatement();
					ResultSet rs1 = st1.executeQuery(sql1);
					if (rs1.next()) {
						t1.setText(rs1.getString(1));
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			new School_Name();
			f1.dispose();
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10) {
			if (e.getSource() == t1) {
				if (t1.getText().equals("")) {
					JOptionPane.showMessageDialog(f1, "Please Enter Registration id");
					t1.requestFocus();
				} else {
					t2.requestFocus();
				}
			} else if (e.getSource() == t2) {
				if (t2.getText().equals("")) {
					JOptionPane.showMessageDialog(f1, "Please Enter Establish Date");
					t2.requestFocus();
				} else {
					t3.requestFocus();
				}
			} else if (e.getSource() == t3) {
				if (t3.getText().equals("")) {
					JOptionPane.showMessageDialog(f1, "Please Enter School Name");
					t3.requestFocus();
				} else {
					cob1.requestFocus();
				}
			} else if (e.getSource() == cob1) {
				if (cob1.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(f1, "Please Choose School Type");
					cob1.requestFocus();
				} else {
					t4.requestFocus();
				}
			} else if (e.getSource() == t4) {
				if (t4.getText().equals("")) {
					JOptionPane.showMessageDialog(f1, "Please Enter Address-1");
					t4.requestFocus();
				} else {
					t5.requestFocus();
				}
			} else if (e.getSource() == t5) {
				if (t5.getText().equals("")) {
					JOptionPane.showMessageDialog(f1, "Please Enter Address-2");
					t5.requestFocus();
				} else {
					cob3.requestFocus();
				}
			} else if (e.getSource() == cob3) {
				if (cob3.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(f1, "Please Choose State");
					cob3.requestFocus();
				} else {
					comboclick();
				}
			} else if (e.getSource() == cob2) {
				if (cob2.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(f1, "Please Choose City");
					cob2.requestFocus();
				} else {
					t8.requestFocus();
				}
			} else if (e.getSource() == t8) {
				if (t8.getText().equals("")) {
					JOptionPane.showMessageDialog(f1, "Please Enter Pin Code");
					t8.requestFocus();
				} else {
					t9.requestFocus();
				}
			} else if (e.getSource() == t9) {
				if (t9.getText().equals("")) {
					// JOptionPane.showMessageDialog(f1, "Please Enter E-mail
					// Id");
					// t9.requestFocus();
					t10.requestFocus();
				} else {
					t10.requestFocus();
				}
			} else if (e.getSource() == t10) {
				if (t10.getText().equals("")) {
					JOptionPane.showMessageDialog(f1, "Please Enter Principle Name");
					t10.requestFocus();
				} else {
					t11.requestFocus();
				}
			} else if (e.getSource() == t11) {
				if (t11.getText().equals("")) {
					// JOptionPane.showMessageDialog(f1, "Please Enter Director
					// Name");
					// t11.requestFocus();
					t12.requestFocus();
				} else {
					t12.requestFocus();
				}
			} else if (e.getSource() == t12) {
				if (t12.getText().equals("")) {
					JOptionPane.showMessageDialog(f1, "Please Enter Contact no.-1");
					t12.requestFocus();
				} else {
					t13.requestFocus();
				}
			} else if (e.getSource() == t13) {
				if (t13.getText().equals("")) {
					// JOptionPane.showMessageDialog(f1, "Please Enter Contact
					// no.-2");
					// t13.requestFocus();
					b1.requestFocus();
				} else {
					b1.requestFocus();
				}
			} else {
				CreateClick();
			}
		}
	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == b1) {
			CreateClick();

		} else if (e.getSource() == cob3) {
			if (cob3.getSelectedItem().equals(null)) {

			} else {
				comboclick();
			}

		} else if (e.getSource() == b2) {
			ClearClick();
		} else if (e.getSource() == b3) {
			f1.dispose();
		} 
//		else if (e.getSource() == br1) {
//			fd1.show();
//			logo_p=(fd1.getDirectory()+fd1.getFile());
//			ImageIcon img1=new ImageIcon(logo_p);
//			Image img2=img1.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
//			ImageIcon i=new ImageIcon(img2);
//			logo.setIcon(i);
//			JOptionPane.showMessageDialog(null, logo_p);
//		} else if (e.getSource() == br2) {
//			fd2.show();
//			P_sign_p=(fd2.getDirectory()+fd2.getFile());
//			ImageIcon img1=new ImageIcon(P_sign_p);
//			Image img2=img1.getImage().getScaledInstance(P_sign.getWidth(),P_sign.getHeight(), Image.SCALE_SMOOTH);
//			ImageIcon i=new ImageIcon(img2);
//			P_sign.setIcon(i);
//			JOptionPane.showMessageDialog(null, P_sign_p);
//		} else if (e.getSource() == br3) {
//			fd3.show();
//			D_sign_p=(fd3.getDirectory()+fd3.getFile());
//			ImageIcon img1=new ImageIcon(D_sign_p);
//			Image img2=img1.getImage().getScaledInstance(D_sign.getWidth(),D_sign.getHeight(), Image.SCALE_SMOOTH);
//			ImageIcon i=new ImageIcon(img2);
//			D_sign.setIcon(i);
//			JOptionPane.showMessageDialog(null, D_sign_p);
//		}
		else{
			
		}

	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cb1) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				t5.setText(t4.getText());
				t5.setEditable(false);
				cob3.requestFocus();
			} else {
				t5.setEditable(true);
				t5.setText("");
				t5.requestFocus();
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==logo){
			fd1.show();
			logo_p=(fd1.getDirectory()+fd1.getFile());
			if(fd1.getDirectory()==null){
				logo.setIcon(i);
			} else {
				ImageIcon img1=new ImageIcon(logo_p);
				Image img2=img1.getImage().getScaledInstance(logo.getWidth()-10, logo.getHeight()-20, Image.SCALE_SMOOTH);
				ImageIcon i=new ImageIcon(img2);
				logo.setIcon(i);
			}
			
//			JOptionPane.showMessageDialog(null, logo_p);
		}
		else if(e.getSource()==P_sign){
			fd2.show();
			P_sign_p=(fd2.getDirectory()+fd2.getFile());
			if(fd2.getDirectory()==null){
				P_sign.setIcon(i21);
			} else{
				ImageIcon img1=new ImageIcon(P_sign_p);
				Image img2=img1.getImage().getScaledInstance(P_sign.getWidth()-10,P_sign.getHeight()-20, Image.SCALE_SMOOTH);
				ImageIcon i21=new ImageIcon(img2);
				P_sign.setIcon(i21);
			}
//			JOptionPane.showMessageDialog(null, P_sign_p);
		}
		else if(e.getSource()==D_sign){
			fd3.show();
			D_sign_p=(fd3.getDirectory()+fd3.getFile());
			if(fd3.getDirectory()==null){
				D_sign.setIcon(i22);
			}
			else{
				ImageIcon img1=new ImageIcon(D_sign_p);
				Image img2=img1.getImage().getScaledInstance(D_sign.getWidth()-10,D_sign.getHeight()-20, Image.SCALE_SMOOTH);
				ImageIcon i22=new ImageIcon(img2);
				D_sign.setIcon(i22);
			}
//			JOptionPane.showMessageDialog(null, D_sign_p);
		}
		else{
			
		}
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
class School_Details{
	public static void main(String[] args) {
		new S_Details();
	}
}
