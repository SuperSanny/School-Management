import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Fee_Particular implements ActionListener, KeyListener {

JFrame f1;
JLabel l1,l2,l3,l4,t1,bg22;
JTextField t2;
JTextArea t3;
JButton b1,b2;
Font fo1,fo2,fo3,fo4;

String path1,url1;
Connection con;

ImageIcon i1;

	public Fee_Particular() {
		f1=new JFrame("Fee Particular");
		
		path1="C:/Users/LENOVO/workspace/eclipse/School Management/DateBase/School_Detail.accdb";
		url1="jdbc:ucanaccess://"+path1;
		
		fo1=new Font("Cooper Black",Font.PLAIN,24);
		fo2=new Font("Cambria",Font.BOLD,18);
		fo3=new Font("Bell MT",Font.BOLD,20);
		fo4=new Font("Bell MT",Font.BOLD,22);

		l1=new JLabel("Fee Particular");
		l1.setFont(fo1);
		l1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.red));
		l1.setBounds(145, 10, 180, 30);
		
		l2=new JLabel("Particular Id :");
		l2.setFont(fo2);
		l2.setBounds(30, 70, 175, 25);
		
		t1=new JLabel(); //t1 for Particular id;
		try{
			Connection con=DriverManager.getConnection(url1);
			String sql1="SELECT COUNT(Particular_Name)+101 FROM Fee_Particular";
			Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery(sql1);
			if(rs1.next()){
				t1.setText(rs1.getString(1));
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		t1.setFont(fo3);
		t1.setBounds(200, 70, 125, 25);
		
		l3=new JLabel("Particular Name :");
		l3.setFont(fo2);
		l3.setBounds(30, 105, 175, 25);
		
		t2=new JTextField();// t2 for Particular Name;
		t2.setFont(fo3);
		t2.setOpaque(false);
		t2.addKeyListener(this);
		t2.requestFocus();
		t2.setBounds(200, 105, 175, 25);
		
		l4=new JLabel("Comment :");
		l4.setFont(fo2);
		l4.setBounds(30, 140, 175, 25);
		
		t3=new JTextArea(); //t4 for Comment;
		t3.setFont(fo3);
		t3.setOpaque(false);
		t3.addKeyListener(this);
		t3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		t3.setBounds(200, 140, 225, 50);
		
		b1=new JButton("Add");
		b1.setFont(fo4);
		b1.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b1.setForeground(new Color(75,0,0));
	    b1.setBackground(new Color(248, 227, 250));
		b1.addActionListener(this);
		b1.addKeyListener(this);
		b1.setBounds(75, 220, 125, 35);
		
		b2=new JButton("Cancel");
		b2.setFont(fo4);
		b2.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b2.setForeground(new Color(75,0,0));
	    b2.setBackground(new Color(248, 227, 250));
		b2.addActionListener(this);
		b2.setBounds(255, 220, 125, 35);
		
		
		bg22=new JLabel();  
	    bg22.setBounds(0,0,475,300);
	    bg22.setBackground(Color.LIGHT_GRAY);
		ImageIcon img=new ImageIcon("images/bg22.png");
		Image img1=img.getImage().getScaledInstance(bg22.getWidth(), bg22.getHeight(), Image.SCALE_SMOOTH);
		i1=new ImageIcon(img1);
//		bg22.setIcon(i1);
		
		f1.add(l1);f1.add(l2);
		f1.add(l3);f1.add(l4);
		
		f1.add(t1);f1.add(t2);
		f1.add(t3);
		
		f1.add(b1);f1.add(b2);
		
		f1.add(bg22);
		
        f1.setSize(475,300);
        f1.setLayout(null);
        f1.setLocationRelativeTo(null);
        f1.setResizable(false);
//        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
	}

	public static void main(String[] args) {
		new Fee_Particular();

	}
	public void AddClick(){
		if(t2.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please Enter Particular Name");
			t2.requestFocus();
		}
		else if(t3.getText().equals("")){
			
		}
		else{
			try{
				con=DriverManager.getConnection(url1);
				String sql2="SELECT * FROM Fee_Particular WHERE Particular_Name='"+t2.getText()+"'";
				Statement st2=con.createStatement();
				ResultSet rs2=st2.executeQuery(sql2);
				if(rs2.next()){
					JOptionPane.showMessageDialog(null, "Particular Name already exist.");
					t2.setText("");
					t2.requestFocus();
				}
				else{
					String sql3="INSERT INTO Fee_Particular(Particular_Id,Particular_Name,Comment) VALUES('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"')";
					Statement st3=con.createStatement();
					st3.executeUpdate(sql3);
					con.close();
					JOptionPane.showMessageDialog(null, "Fee Particular Added Successfully");
					t1.setText("");
					t2.requestFocus();
					t2.setText("");
					t3.setText("");
					try{
						Connection con=DriverManager.getConnection(url1);
						String sql1="SELECT COUNT(Particular_Name)+1001 FROM Fee_Particular";
						Statement st1=con.createStatement();
						ResultSet rs1=st1.executeQuery(sql1);
						if(rs1.next()){
							t1.setText(rs1.getString(1));
						}
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}

		}
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==10){
			if(e.getSource()==t2){
				if(t2.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please Enter Particular Name.");
					t2.requestFocus();
				}
				else{
					t3.requestFocus();
				}
			}
			else if(e.getSource()==t3){
				if(t3.getText().equals("")){
					b1.requestFocus();
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
			f1.dispose();
		}
		else{
			
		}
		
	}

}
