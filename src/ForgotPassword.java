import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class ForgotPassword implements ActionListener,MouseListener,KeyListener{

	JFrame f1;
    JPanel p1,p2,p3;
    JLabel l1,l2,l3,l4,l5,pi1,pi2,pi3,pi4,sp1,sp2,bg1;
    JPasswordField pf1,pf2;
    JTextField t1,t2;
    JButton b1,b2;
    Font fo1,fo2,fo3;
    Color c1=new Color(233,90,75);
    
	String path;
	String url;
	Connection con;
    
	public ForgotPassword() {
		f1=new JFrame("Forgot Password");
		
		path="C:/Users/LENOVO/workspace/eclipse/School Management/DateBase/CreateNew.mdb";
		url="jdbc:ucanaccess://"+path;
		
        fo1=new Font("Century Schoolbook",Font.BOLD,28);
        fo2=new Font("Serif",Font.PLAIN,16);
        fo3=new Font("Serif",Font.BOLD,18);
        
        l1=new JLabel("Forgot Password");
        l1.setFont(fo1);
        l1.setForeground(new Color(75,0,0));
        l1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.red));
        l1.setBounds(110, 20, 250, 50);
        
        l2=new JLabel("E-mail Id");
        l2.setFont(fo2);
        l2.setForeground(c1);
        l2.setBounds(0, 5, 150, 30);
        
        t2=new JTextField();
        t2.setFont(fo3);
        t2.addKeyListener(this);
        t2.setOpaque(false);
        t2.setBounds(0, 30, 200, 25);
        
        l3=new JLabel("New Password");
        l3.setFont(fo2);
        l3.setForeground(c1);
        l3.setBounds(0, 60, 150, 30);
        
        pf1=new JPasswordField();
        pf1.setEchoChar('�');
        pf1.setFont(fo3);
        pf1.addKeyListener(this);
        pf1.setOpaque(false);
        pf1.setBounds(0, 85, 200, 25);
        
        sp1=new JLabel(new ImageIcon("images/view.png"));
        sp1.setBounds(170, 0, 28, 24);
        sp1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sp1.setOpaque(false);
        sp1.addMouseListener(this);
        
        l4=new JLabel("Confirm New Password");
        l4.setFont(fo2);
        l4.setForeground(c1);
        l4.setBounds(0, 115, 200, 30);
        
        pf2=new JPasswordField(); 
        pf2.setEchoChar('�');
        pf2.setFont(fo3);
        pf2.addKeyListener(this);
        pf2.setOpaque(false);
        pf2.setBounds(0, 140, 200, 25);
        
        sp2=new JLabel(new ImageIcon("images/view.png"));
        sp2.setBounds(170, 0, 28, 24);
        sp2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sp2.setOpaque(false);
        sp2.addMouseListener(this);
        
        l5=new JLabel("User Id");
        l5.setFont(fo2);
        l5.setForeground(c1);
        l5.setBounds(40, 0, 200, 30);
        
        t1=new JTextField();
        t1.setFont(fo3);
        t1.addKeyListener(this);
        t1.setOpaque(false);
        t1.setBounds(40, 25, 200, 25);
        
        p1=new JPanel();
        p1.setBounds(110, 145, 40, 160);
        p1.setOpaque(false);
        p1.setLayout(null);
        
        p2=new JPanel();
        p2.setBounds(150, 135, 200, 170);
        p2.setOpaque(false);
        p2.setLayout(null);
        
        p3=new JPanel();
        p3.setBounds(110, 90, 240, 60);
        p3.setOpaque(false);
        p3.setLayout(null);
       
        b1=new JButton("Submit");
        b1.setFont(new Font("Serif",Font.BOLD,20));
        b1.setBorder(BorderFactory.createBevelBorder(0, new Color(75,200,255), new Color(75,80,255)));
        b1.setBounds(90, 320, 120, 30);
        b1.addActionListener(this);
        b1.addKeyListener(this);
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b1.setForeground(new Color(75,0,0));
        b1.setBackground(new Color(167, 234, 241));
        
        b2=new JButton("Cancel");
        b2.setFont(new Font("Serif",Font.BOLD,20));
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b2.setBorder(BorderFactory.createBevelBorder(0, new Color(75,200,255), new Color(75,80,255)));
        b2.setBounds(260, 320, 120, 30);
        b2.addActionListener(this);
        b2.setForeground(new Color(75,0,0));
        b2.setBackground(new Color(167, 234, 241));

        pi1=new JLabel(new ImageIcon("images/email.png"));
        pi1.setBounds(2, 10, 35, 35);
        
        pi2=new JLabel(new ImageIcon("images/password.png"));
        pi2.setBounds(2, 65, 35, 35);
        
        pi3=new JLabel(new ImageIcon("images/password.png"));
        pi3.setBounds(2, 120, 35, 35);
        
        pi4=new JLabel(new ImageIcon("images/idcard.png"));
        pi4.setBounds(2, 20, 35, 35);
    
        bg1=new JLabel(new ImageIcon("images/1122.jpg"));
        bg1.setBounds(0,0,475,425);
        
        f1.add(l1);f1.add(p1);
        f1.add(p2);f1.add(b1);
        f1.add(p3);f1.add(b2);
        
        p1.add(pi1);p1.add(pi2);
        p1.add(pi3);
        
        p2.add(l2);p2.add(l3);
        p2.add(l4);p2.add(t2);
        p2.add(pf1);p2.add(pf2);
        
        p3.add(t1);p3.add(l5);
        p3.add(pi4);
        
        pf1.add(sp1);pf2.add(sp2);
        
        f1.add(bg1);
        f1.setSize(475,425);
        f1.setLayout(null);
        f1.setLocationRelativeTo(null);
        f1.setResizable(false);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
	}

	public static void main(String[] args) {
		new ForgotPassword();

	}

	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==sp1){
            pf1.setEchoChar((char) 0);
        }
        else if(e.getSource()==sp2){
            pf2.setEchoChar((char) 0);
        }
        else{
        }
		
	}

	public void mouseEntered(MouseEvent arg0) {
		
	}

	public void mouseExited(MouseEvent e) {
		if(e.getSource()==sp1){
            pf1.setEchoChar('�');
        }
        else if(e.getSource()==sp2){
            pf2.setEchoChar('�');
        }
        else{
        }
		
	}

	public void mousePressed(MouseEvent arg0) {
		
	}

	public void mouseReleased(MouseEvent arg0) {
		
	}
	
	public void submitpressed(){
		if(pf1.getText().equals(pf2.getText())){
			try{
				con=DriverManager.getConnection(url);
				String sql="SELECT * FROM New_User WHERE User_Id='"+t1.getText()+"' and Email_Id='"+t2.getText()+"'";
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(sql);
				if(!rs.next()){
					JOptionPane.showMessageDialog(null,"Not a valid User");
					t1.setText("");
					t2.setText("");
					pf1.setText("");
					pf2.setText("");
					t1.requestFocus();
				}
				else{
					String sql1="UPDATE New_User set Password='"+pf1.getText()+"' WHERE User_Id='"+t1.getText()+"' and Email_Id='"+t2.getText()+"'";
					Statement st1=con.createStatement();
					st1.executeUpdate(sql1);
					con.close();
					JOptionPane.showMessageDialog(f1, " Password Changed SucessFully");
					new LogIn();
					f1.dispose();
//        			t1.setText("");
//        			t2.setText("");
//					pf1.setText("");
//        			pf2.setText("");
//        			t1.requestFocus();
				}
			}catch(Exception e1){
				JOptionPane.showMessageDialog(f1, e1.getMessage());
			}
		}
		else{
			JOptionPane.showMessageDialog(f1, "New Password And Confirm New Password are Not Matched");
			pf2.setText("");
			pf2.requestFocus();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){
        	if((t1.getText().equals(""))){
        		JOptionPane.showMessageDialog(f1, "Please Enter User Id");
        		t1.requestFocus();
        	}
        	else if((t2.getText().equals(""))){
        		JOptionPane.showMessageDialog(f1, "Please Enter E-mail Id");
        		t2.requestFocus();
        	}
        	else if((pf1.getText().equals(""))){
        		JOptionPane.showMessageDialog(f1, "Please Enter New Password");
        		pf1.requestFocus();
        	}
        	else if((pf2.getText().equals(""))){
        		JOptionPane.showMessageDialog(f1, "Please Enter Confirm New Password");
        		pf2.requestFocus();
        	}
        	else{
        		submitpressed();
        	}
        }
        else{
        	f1.dispose();
        }
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==10){
			if(e.getSource()==t1){
				if(t1.getText().equals("")){
					JOptionPane.showMessageDialog(f1, "Please Enter User Id");
					t1.requestFocus();
				}
				else{
					try{
						con = DriverManager.getConnection(url);
						String sql1="select * from New_User where User_Id='"+t1.getText()+"' ";						
						Statement st1=con.createStatement();
						ResultSet rs1=st1.executeQuery(sql1);
						if(rs1.next()){
							con.close();
							t2.requestFocus();
						}
						else{
							JOptionPane.showMessageDialog(f1, "Sorry... User Id does not exist.");
							t1.setText("");
							t1.requestFocus();
						}
						
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
			else if(e.getSource()==t2){
				if(t2.getText().equals("")){
					JOptionPane.showMessageDialog(f1, "Please Enter E-mail Id");
					t2.requestFocus();
				}
				else{
					try{
						con = DriverManager.getConnection(url);
						String sql2="SELECT Email_Id FROM New_User WHERE User_Id='"+t1.getText()+"' and Email_Id='"+t2.getText()+"'";
						Statement st2=con.createStatement();
						ResultSet rs2=st2.executeQuery(sql2);
						if(rs2.next()){
							con.close();
							pf1.requestFocus();
						}
						else{
							JOptionPane.showMessageDialog(null, "E-mail Id Wrong!");
							t2.setText("");
							t2.requestFocus();
						}
					}catch(Exception e1){
						
					}
					
				}
			}
			else if(e.getSource()==pf1){
				if(pf1.getText().equals("")){
					JOptionPane.showMessageDialog(f1, "Please Enter New Password");
					pf1.requestFocus();
				}
				else{
					pf2.requestFocus();
					}
				}
			else if(e.getSource()==pf2){
				if(pf2.getText().equals("")){
					JOptionPane.showMessageDialog(f1, "Please Enter Confirm New Password");
					pf2.requestFocus();
				}
				else{
					if(!(pf1.getText().equals(pf2.getText()))){
						JOptionPane.showMessageDialog(null, "New Password and Confirm New Password do not Match");
						pf2.setText("");
						pf2.requestFocus();
					}
					else{
						b1.requestFocus();
					}
				}
			}
			else if(e.getSource()==b1){
				submitpressed();
			}
			else{
				
			}
		}
	}

	public void keyReleased(KeyEvent arg0) {
		
	}

	public void keyTyped(KeyEvent arg0) {
		
	}

}
