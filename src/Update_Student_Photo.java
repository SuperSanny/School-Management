import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

class Update_Student_Photo implements ActionListener,MouseListener {
JFrame f1;
JLabel l1,l2,l3,l4,l5,l6;
JButton b1,b2,b3;
Font fo1,fo2,fo3;
FileDialog fd1,fd2,fd3,fd4,fd5;

String path1,url1,R_Id,Sp,Ss,Ps,Bc,Sa;
Connection con1;

ImageIcon i1,i2,i3,i4,i5,img10,img11,img12,img13,img14;
ImageIcon img1=new ImageIcon("images/upload.png");

String SP,SS,PS,BC,SA;/*SP=Student Photo, SS=Student Signature, PS=Parent Signature, BC=Birth Certificate, SA=Student Aadhar-card  */
	public Update_Student_Photo(String Registaion_Id){
		
		R_Id=Registaion_Id;
		
		f1=new JFrame("Upload Photo");
		fo1=new Font("Bookman Old Style",Font.BOLD,22);
		fo2=new Font("Cambria",Font.PLAIN,18);
		fo3=new Font("Cambria",Font.BOLD,18);
		
		path1="C:/Users/LENOVO/workspace/eclipse/School Management/DateBase/School_Detail.accdb";
		url1="jdbc:ucanaccess://"+path1;
		
		l1=new JLabel("<HTML><U>Update Student Photo</U></HTML>");
		l1.setFont(fo1);
		l1.setBounds(10, 10, 300, 30);
		f1.add(l1);
		
		l2=new JLabel();
		l2.setFont(fo2);
//		l2.setBorder(BorderFactory.createTitledBorder("Student Photo"));
		l2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Student Photo"));
		l2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l2.addMouseListener(this);
		l2.setBounds(30, 50, 250, 250);
		f1.add(l2);
		
		l3=new JLabel("");
		l3.setFont(fo2);
		l3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Student Signature"));
		l3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l3.addMouseListener(this);
		l3.setBounds(300, 50, 250, 100);
		f1.add(l3);
		
		l4=new JLabel("");
		l4.setFont(fo2);
		l4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Parent Signature"));
		l4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l4.addMouseListener(this);
		l4.setBounds(300, 200, 250, 100);
		f1.add(l4);
		
		l5=new JLabel("");
		l5.setFont(fo2);
		l5.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Student Aadhar-card"));
		l5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l5.addMouseListener(this);
		l5.setBounds(100, 350, 570, 200);
		f1.add(l5);
		
		l6=new JLabel();
		l6.setFont(fo2);
		l6.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Birth Certificate"));
		l6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l6.addMouseListener(this);
		l6.setBounds(570, 50, 200, 250);
		f1.add(l6);
		
		b1=new JButton("Update");
		b1.setFont(fo1);
		b1.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
	    b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b1.setForeground(new Color(75,0,0));
	    b1.setBackground(new Color(248, 227, 250));
		b1.addActionListener(this);
		b1.setBounds(100, 600, 125, 35);
		f1.add(b1);
		
		b2=new JButton("Close");
		b2.setFont(fo1);
		b2.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
	    b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b2.setForeground(new Color(75,0,0));
	    b2.setBackground(new Color(248, 227, 250));
		b2.addActionListener(this);
		b2.setBounds(325, 600, 125, 35);
		f1.add(b2);
		
		b3=new JButton("Clear");
		b3.setFont(fo1);
		b3.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
	    b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b3.setForeground(new Color(75,0,0));
	    b3.setBackground(new Color(248, 227, 250));
		b3.addActionListener(this);
		b3.setBounds(550, 600, 125, 35);
		f1.add(b3);
		
		fd1=new FileDialog(f1,"Open",FileDialog.LOAD);
		fd2=new FileDialog(f1,"Open",FileDialog.LOAD);
		fd3=new FileDialog(f1,"Open",FileDialog.LOAD);
		fd4=new FileDialog(f1,"Open",FileDialog.LOAD);
		fd5=new FileDialog(f1,"Open",FileDialog.LOAD);
		
		
		try{
			con1=DriverManager.getConnection(url1);
			String sql1="SELECT * FROM Student_Admission Where Registation_Id='"+R_Id+"' ";
			Statement st1=con1.createStatement();
			ResultSet rs1=st1.executeQuery(sql1);
			if(rs1.next()){
				Sp=rs1.getString("S_Photo");
				Ss=rs1.getString("S_Signature");
				Ps=rs1.getString("P_Signature");
				Bc=rs1.getString("B_Certificate");
				Sa=rs1.getString("S_Aadhar_Card");
				
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		ImageIcon img10=new ImageIcon(Sp);
		ImageIcon img11=new ImageIcon(Ss);
		ImageIcon img12=new ImageIcon(Ps);
		ImageIcon img13=new ImageIcon(Bc);
		ImageIcon img14=new ImageIcon(Sa);
		
        
		Image img2=img10.getImage().getScaledInstance(l2.getWidth(), l2.getHeight()-10, Image.SCALE_SMOOTH);
		i1=new ImageIcon(img2);
		l2.setIcon(i1);
		
		Image img21=img11.getImage().getScaledInstance(l3.getWidth(), l3.getHeight()-10, Image.SCALE_SMOOTH);
		i2=new ImageIcon(img21);
		l3.setIcon(i2);
		
		Image img22=img12.getImage().getScaledInstance(l4.getWidth(), l4.getHeight()-10, Image.SCALE_SMOOTH);
		i3=new ImageIcon(img22);
		l4.setIcon(i3);
		
		Image img23=img13.getImage().getScaledInstance(l5.getWidth(), l5.getHeight()-10, Image.SCALE_SMOOTH);
		i4=new ImageIcon(img23);
		l5.setIcon(i4);
		
		Image img24=img14.getImage().getScaledInstance(l6.getWidth(), l6.getHeight()-10, Image.SCALE_SMOOTH);
		i5=new ImageIcon(img24);
		l6.setIcon(i5);
		
		f1.setSize(800,675);
		f1.setLayout(null);
		f1.setLocationRelativeTo(null);
        f1.setResizable(false);
        f1.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		f1.setVisible(true);	
	}
	@SuppressWarnings({ "deprecation", "deprecation", "deprecation" })
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){
			if (l2.getIcon()==null) {
				JOptionPane.showMessageDialog(null, "Please Insert Student Photo");
				l2.requestFocus();
			}
			else if (l3.getIcon()==null) {
				JOptionPane.showMessageDialog(null, "Please Insert Student Signature");
				l3.requestFocus();
			}
			else if (l4.getIcon()==null) {
				JOptionPane.showMessageDialog(null, "Please Insert Parent Signature");
				l4.requestFocus();
			}
			else if (l5.getIcon()==null) {
				JOptionPane.showMessageDialog(null, "Please Insert Student Aadhar-Card");
				l5.requestFocus();
			}
			else if (l6.getIcon()==null) {
				JOptionPane.showMessageDialog(null, "Please Insert Birth Certificate");
				l6.requestFocus();
			}
			else{
				try {
					con1=DriverManager.getConnection(url1);
					String sql12 = "UPDATE Student_Admission SET S_Photo='"+SP+"',S_Signature='"+SS+"',P_Signature='"+PS+"',B_Certificate='"+SA+"',S_Aadhar_Card='"+BC+"' WHERE Registation_Id='"+R_Id+"'";
					Statement st12 = con1.createStatement();
					st12.executeUpdate(sql12);
					con1.close();
					JOptionPane.showMessageDialog(null, " Update SucessFully");
					f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		}
		else if(e.getSource()==b2){
			f1.dispose();
		}
		else if(e.getSource()==b3){
			ImageIcon img1=new ImageIcon("images/upload.png");
			
			Image img2=img1.getImage().getScaledInstance(l2.getWidth(), l2.getHeight(), Image.SCALE_SMOOTH);
			i1=new ImageIcon(img2);
			l2.setIcon(i1);
			
			Image img21=img1.getImage().getScaledInstance(l3.getWidth(), l3.getHeight(), Image.SCALE_SMOOTH);
			i2=new ImageIcon(img21);
			l3.setIcon(i2);
			
			Image img22=img1.getImage().getScaledInstance(l4.getWidth(), l4.getHeight(), Image.SCALE_SMOOTH);
			i3=new ImageIcon(img22);
			l4.setIcon(i3);
			
			Image img23=img1.getImage().getScaledInstance(l5.getWidth(), l5.getHeight(), Image.SCALE_SMOOTH);
			i4=new ImageIcon(img23);
			l5.setIcon(i4);
			
			Image img24=img1.getImage().getScaledInstance(l6.getWidth(), l6.getHeight(), Image.SCALE_SMOOTH);
			i5=new ImageIcon(img24);
			l6.setIcon(i5);
		}
		else{
			
		}
		
	}
	public static void main(String[] args) {
//		new Update_Student_Photo();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == l2) {
			fd1.show();
			SP=(fd1.getDirectory()+fd1.getFile());
			if(fd1.getDirectory()==null){
				l2.setIcon(i1);
			} else {
				ImageIcon img1=new ImageIcon(SP);
				Image img2=img1.getImage().getScaledInstance(l2.getWidth()-10, l2.getHeight()-20, Image.SCALE_SMOOTH);
				ImageIcon i1=new ImageIcon(img2);
				l2.setIcon(i1);
			}
//			JOptionPane.showMessageDialog(null, SP);
		} 
		else if (e.getSource() == l3) {
			fd2.show();
			SS=(fd2.getDirectory()+fd2.getFile());
			if(fd2.getDirectory()==null){
				l3.setIcon(i2);
			} else{
				ImageIcon img1=new ImageIcon(SS);
				Image img2=img1.getImage().getScaledInstance(l3.getWidth()-10,l3.getHeight()-20, Image.SCALE_SMOOTH);
				ImageIcon i2=new ImageIcon(img2);
				l3.setIcon(i2);
			}
//			JOptionPane.showMessageDialog(null, SS);
		} 
		else if (e.getSource() == l4) {
			fd3.show();
			PS=(fd3.getDirectory()+fd3.getFile());
			if(fd3.getDirectory()==null){
				l4.setIcon(i3);
			} else{
				ImageIcon img1=new ImageIcon(PS);
				Image img2=img1.getImage().getScaledInstance(l4.getWidth()-10,l4.getHeight()-20, Image.SCALE_SMOOTH);
				ImageIcon i3=new ImageIcon(img2);
				l4.setIcon(i3);
			}
//			JOptionPane.showMessageDialog(null, PS);
		}
		else if(e.getSource()==l5){
			fd4.show();
			SA=(fd4.getDirectory()+fd4.getFile());
			if(fd4.getDirectory()==null){
				l5.setIcon(i4);
			} else{
				ImageIcon img1=new ImageIcon(SA);
				Image img2=img1.getImage().getScaledInstance(l5.getWidth()-10,l5.getHeight()-20, Image.SCALE_SMOOTH);
				ImageIcon i4=new ImageIcon(img2);
				l5.setIcon(i4);
			}
//			JOptionPane.showMessageDialog(null, SA);
		}
		else if(e.getSource()==l6){
			fd5.show();
			BC=(fd5.getDirectory()+fd5.getFile());
			if(fd5.getDirectory()==null){
				l6.setIcon(i5);
			} else{
				ImageIcon img1=new ImageIcon(BC);
				Image img2=img1.getImage().getScaledInstance(l6.getWidth()-10,l6.getHeight()-20, Image.SCALE_SMOOTH);
				ImageIcon i5=new ImageIcon(img2);
				l6.setIcon(i5);
			}
//			JOptionPane.showMessageDialog(null, BC);
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
