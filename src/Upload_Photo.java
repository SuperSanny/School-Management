import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

class Upload_Photo implements ActionListener {
JFrame f1;
JLabel l1,l2,l3,l4,l5,l6;
JButton b1,b2,b3,br1,br2,br3,br4,br5;
Font fo1,fo2,fo3;
FileDialog fd1,fd2,fd3,fd4,fd5;

String path1,url1,R_Id;
Connection con1;

String SP,SS,PS,BC,SA;/*SP=Student Photo, SS=Student Signature, PS=Parent Signature, BC=Birth Certificate, SA=Student Aadhar-card  */
	Upload_Photo(String Registaion_Id){
		R_Id=Registaion_Id;

		f1=new JFrame("Upload Photo");
		fo1=new Font("Bookman Old Style",Font.BOLD,22);
		fo2=new Font("Cambria",Font.PLAIN,18);
		fo3=new Font("Cambria",Font.BOLD,18);
		
		path1="C:/Users/LENOVO/workspace/eclipse/School Management/DateBase/School_Detail.accdb";
		url1="jdbc:ucanaccess://"+path1;
		
		l1=new JLabel("<HTML><U>Upload Photo</U></HTML>");
		l1.setFont(fo1);
		l1.setBounds(10, 10, 250, 30);
		
		l2=new JLabel();
		l2.setFont(fo2);
		l2.setBorder(BorderFactory.createTitledBorder("Student Photo"));
		l2.setBounds(30, 50, 250, 250);
		
		br1=new JButton("Browse");
		br1.setFont(fo3);
		br1.addActionListener(this);
		br1.setBounds(100, 310, 100, 30);
		
		l3=new JLabel("");
		l3.setFont(fo2);
		l3.setBorder(BorderFactory.createTitledBorder("Student Signature"));
		l3.setBounds(300, 50, 250, 100);
		
		br2=new JButton("Browse");
		br2.setFont(fo3);
		br2.addActionListener(this);
		br2.setBounds(370, 160, 100, 30);
		
		l4=new JLabel("");
		l4.setFont(fo2);
		l4.setBorder(BorderFactory.createTitledBorder("Parent Signature"));
		l4.setBounds(300, 200, 250, 100);
		
		br3=new JButton("Browse");
		br3.setFont(fo3);
		br3.addActionListener(this);
		br3.setBounds(370, 310, 100, 30);
		
		l5=new JLabel("");
		l5.setFont(fo2);
		l5.setBorder(BorderFactory.createTitledBorder("Student Aadhar-card"));
		l5.setBounds(100, 350, 570, 200);
		
		br4=new JButton("Browse");
		br4.setFont(fo3);
		br4.addActionListener(this);
		br4.setBounds(340, 560, 100, 30);
		
		l6=new JLabel();
		l6.setFont(fo2);
		l6.setBorder(BorderFactory.createTitledBorder("Birth Certificate"));
		l6.setBounds(570, 50, 200, 250);
		
		br5=new JButton("Browse");
		br5.setFont(fo3);
		br5.addActionListener(this);
		br5.setBounds(620, 310, 100, 30);
		
		
		b1=new JButton("Next");
		b1.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b1.setForeground(new Color(75,0,0));
	    b1.setBackground(new Color(248, 227, 250));
		b1.setFont(fo1);
		b1.addActionListener(this);
		b1.setBounds(100, 600, 125, 35);
		
		b2=new JButton("Back");
		b2.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b2.setForeground(new Color(75,0,0));
	    b2.setBackground(new Color(248, 227, 250));
		b2.setFont(fo1);
		b2.addActionListener(this);
		b2.addActionListener(this);
		b2.setBounds(325, 600, 125, 35);
		
		b3=new JButton("Clear");
		b3.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
		b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    b3.setForeground(new Color(75,0,0));
	    b3.setBackground(new Color(248, 227, 250));
		b3.setFont(fo1);
		b3.addActionListener(this);
		b3.setBounds(550, 600, 125, 35);
		
		fd1=new FileDialog(f1,"Open",FileDialog.LOAD);
		fd2=new FileDialog(f1,"Open",FileDialog.LOAD);
		fd3=new FileDialog(f1,"Open",FileDialog.LOAD);
		fd4=new FileDialog(f1,"Open",FileDialog.LOAD);
		fd5=new FileDialog(f1,"Open",FileDialog.LOAD);
		
		f1.add(l1);f1.add(l2);
		f1.add(l3);f1.add(l4);
		f1.add(l5);f1.add(l6);
		
		f1.add(b1);
//		f1.add(b2);
		f1.add(b3);f1.add(br1);
		f1.add(br2);f1.add(br3);
		f1.add(br4);f1.add(br5);
		
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
			if (fd1.getFile()==null) {
				JOptionPane.showMessageDialog(null, "Please Insert Student Photo");
				br1.requestFocus();
			}
			else if (fd2.getFile()==null) {
				JOptionPane.showMessageDialog(null, "Please Insert Student Signature");
				br2.requestFocus();
			}
			else if (fd3.getFile()==null) {
				JOptionPane.showMessageDialog(null, "Please Insert Parent Signature");
				br3.requestFocus();
			}
			else if (fd4.getFile()==null) {
				JOptionPane.showMessageDialog(null, "Please Insert Student Aadhar-Card");
				br4.requestFocus();
			}
			else if (fd5.getFile()==null) {
				JOptionPane.showMessageDialog(null, "Please Insert Birth Certificate");
				br1.requestFocus();
			}
			else{
				try {
					con1=DriverManager.getConnection(url1);
					String sql12 = "UPDATE Student_Admission SET S_Photo='"+SP+"',S_Signature='"+SS+"',P_Signature='"+PS+"',B_Certificate='"+SA+"',S_Aadhar_Card='"+BC+"' WHERE Registation_Id='"+R_Id+"'";
					Statement st12 = con1.createStatement();
					st12.executeUpdate(sql12);
					con1.close();
					JOptionPane.showMessageDialog(null, "Photo Uploaded SucessFully");
					new Payment_Process(R_Id);
					f1.setVisible(false);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		}
		else if(e.getSource()==b2){
			f1.setVisible(false);
			
		}
		else if(e.getSource()==b3){
			l2.setIcon(null);
			l3.setIcon(null);
			l4.setIcon(null);
			l5.setIcon(null);
			l6.setIcon(null);
		}
		else if (e.getSource() == br1) {
			fd1.show();
			SP=(fd1.getDirectory()+fd1.getFile());
			ImageIcon img1=new ImageIcon(SP);
			Image img2=img1.getImage().getScaledInstance(l2.getWidth(), l2.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon i=new ImageIcon(img2);
			l2.setIcon(i);
//			JOptionPane.showMessageDialog(null, SP);
		} 
		else if (e.getSource() == br2) {
			fd2.show();
			SS=(fd2.getDirectory()+fd2.getFile());
			ImageIcon img1=new ImageIcon(SS);
			Image img2=img1.getImage().getScaledInstance(l3.getWidth(),l3.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon i=new ImageIcon(img2);
			l3.setIcon(i);
//			JOptionPane.showMessageDialog(null, SS);
		} 
		else if (e.getSource() == br3) {
			fd3.show();
			PS=(fd3.getDirectory()+fd3.getFile());
			ImageIcon img1=new ImageIcon(PS);
			Image img2=img1.getImage().getScaledInstance(l4.getWidth(),l4.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon i=new ImageIcon(img2);
			l4.setIcon(i);
//			JOptionPane.showMessageDialog(null, PS);
		}
		else if(e.getSource()==br4){
			fd4.show();
			SA=(fd4.getDirectory()+fd4.getFile());
			ImageIcon img1=new ImageIcon(SA);
			Image img2=img1.getImage().getScaledInstance(l5.getWidth(),l5.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon i=new ImageIcon(img2);
			l5.setIcon(i);
//			JOptionPane.showMessageDialog(null, SA);
		}
		else if(e.getSource()==br5){
			fd5.show();
			BC=(fd5.getDirectory()+fd5.getFile());
			ImageIcon img1=new ImageIcon(BC);
			Image img2=img1.getImage().getScaledInstance(l6.getWidth(),l6.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon i=new ImageIcon(img2);
			l6.setIcon(i);
//			JOptionPane.showMessageDialog(null, BC);
		}	
		else{
			
		}
		
	}
	public static void main(String[] args) {
	}
	
}
