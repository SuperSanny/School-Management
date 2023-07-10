import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class CreateNewUser implements KeyListener,MouseListener, ActionListener {
	
	JFrame f1;
    JPanel p1;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,pi1,pi2,pi3,pi4,pi5,sp1,sp2,bg1;
    JTextField t1,t2,t3;
    JPasswordField pf1,pf2;
    JButton b1,b2;
    Font fo1,fo2,fo3;
    Color c1=new Color(233,90,75);
    
    String path;
	String url;
	Connection con;

	public CreateNewUser() {
		f1=new JFrame("New User");
		
		path="C:/Users/LENOVO/workspace/eclipse/School Management/DateBase/CreateNew.mdb";
		url="jdbc:ucanaccess://"+path;

        Image icon=Toolkit.getDefaultToolkit().getImage("images/1.png");
        
        f1.setIconImage(icon);
        
        fo1=new Font("Century Schoolbook",Font.BOLD,28);
        fo2=new Font("Serif",Font.PLAIN,16);
        fo3=new Font("Serif",Font.BOLD,18);
       
        l1=new JLabel("Create New User");
        l1.setFont(fo1);
        l1.setForeground(new Color(75,0,0));
        l1.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
        l1.setBounds(110, 20, 250, 50);
        
        l2=new JLabel("Name");
        l2.setFont(fo2);
        l2.setForeground(c1);
        l2.setBounds(150, 85, 150, 30);
        
        t1=new JTextField();
        t1.setFont(fo3);
        t1.setOpaque(false);
        t1.addKeyListener(this);
        t1.setBounds(150, 110, 200, 25);
        
        l3=new JLabel("E-mail Id");
        l3.setFont(fo2);
        l3.setForeground(c1);
        l3.setBounds(150, 140, 150, 30);
        
        t2=new JTextField();
        t2.setFont(fo3);
        t2.setOpaque(false);
        t2.addKeyListener(this);
        t2.setBounds(150, 165, 200, 25);
        
        l4=new JLabel("User Id");
        l4.setFont(fo2);
        l4.setForeground(c1);
        l4.setBounds(150, 195, 150, 30);
        
        t3=new JTextField();
        t3.setFont(fo3);
        t3.setOpaque(false);
        t3.addKeyListener(this);
        t3.setBounds(150, 220, 200, 25);
        
        l5=new JLabel("Password");
        l5.setFont(fo2);
        l5.setForeground(c1);
        l5.setBounds(150, 250, 150, 30);
        
        pf1=new JPasswordField();
        pf1.setEchoChar('•');
        pf1.setFont(fo2);
        pf1.setOpaque(false);
        pf1.addKeyListener(this);
        pf1.setBounds(150, 275, 200, 25);
        
        sp1=new JLabel(new ImageIcon("images/view.png"));
        sp1.setBounds(170, 0, 28, 24);
        sp1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sp1.setToolTipText("Show Password");
        sp1.setOpaque(false);
        sp1.addMouseListener(this);
        
        l6=new JLabel("Confirm Password");
        l6.setFont(fo2);
        l6.setForeground(c1);
        l6.setBounds(150, 305, 200, 30);
        
        pf2=new JPasswordField(); 
        pf2.setEchoChar('•');
        pf2.setFont(fo2);
        pf2.setOpaque(false);
        pf2.setBounds(150, 330, 200, 25);
        pf2.addKeyListener(this);
        
        sp2=new JLabel(new ImageIcon("images/view.png"));
        sp2.setBounds(170, 0, 28, 24);
        sp2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sp2.setToolTipText("Show Password");
        sp2.setOpaque(false);
        sp2.addMouseListener(this);
        
        l7=new JLabel("Already a member?");
        l7.setFont(new Font("Serif",Font.PLAIN,14));
        l7.setForeground(Color.gray);
        l7.setBounds(120, 402, 150, 30);
        
        l8=new JLabel("<html><u>Login Here</u></html>");
        l8.setFont(fo2);
        l8.setForeground(Color.blue.darker());
        l8.setBounds(250, 400, 200, 30);
        l8.addMouseListener(this);
        l8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        b1=new JButton("Submit");
        b1.setFont(new Font("Serif",Font.BOLD,20));
        b1.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b1.setBounds(80, 370, 100, 30);
        b1.addActionListener(this);
        b1.addKeyListener(this);
        b1.setForeground(new Color(75,0,0));
        b1.setBackground(new Color(220, 200, 255));
        
        b2=new JButton("Reset");
        b2.setFont(new Font("Serif",Font.BOLD,20));
        b2.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b2.setBounds(280, 370, 100, 30);
        b2.addActionListener(this);
        b2.setForeground(new Color(75,0,0));
        b2.setBackground(new Color(220, 200, 255));
        
        p1=new JPanel();
        p1.setBounds(110, 90, 40, 270);
        p1.setOpaque(false);
        p1.setLayout(null);
        
        pi1=new JLabel(new ImageIcon("images/name.png"));
        pi1.setBounds(2, 10, 35, 35);
        
        pi2=new JLabel(new ImageIcon("images/email.png"));
        pi2.setBounds(2, 65, 35, 35);
        
        pi3=new JLabel(new ImageIcon("images/idcard.png"));
        pi3.setBounds(2, 120, 35, 35);
        
        pi4=new JLabel(new ImageIcon("images/password.png"));
        pi4.setBounds(2, 180, 35, 35);
        
        pi5=new JLabel(new ImageIcon("images/password.png"));
        pi5.setBounds(2, 232, 35, 35);
        
        bg1=new JLabel(new ImageIcon("E:\\JavaImage\\buttons\\1111.png"));
        bg1.setBounds(0,0,480,480);
        
        f1.add(l1);f1.add(l2);
        f1.add(l3);f1.add(l4);
        f1.add(l5);f1.add(l6);
        f1.add(l7);f1.add(l8);
        
        f1.add(t1);f1.add(t2);
        f1.add(t3);
        
        f1.add(pf1);
        f1.add(pf2);f1.add(p1);
        
        p1.add(pi1);p1.add(pi2);
        p1.add(pi3);p1.add(pi4);
        p1.add(pi5);
        
        pf1.add(sp1);pf2.add(sp2);
        
        f1.add(b1);f1.add(b2);
        
        f1.add(bg1);
        
        f1.setLayout(null);
        f1.setSize(475, 475);
        f1.setResizable(false);
        f1.setLocationRelativeTo(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
	}

	public void submitpressed(){
		if(t1.getText().equals("")){
			JOptionPane.showMessageDialog(f1, "Please Enter Name");
    		t1.requestFocus();
		}
		else if(t2.getText().equals("")){
			JOptionPane.showMessageDialog(f1, "Please Enter E-mail id");
    		t2.requestFocus();
		}
		else if(t3.getText().equals("")){
			JOptionPane.showMessageDialog(f1, "Please Enter User Id");
    		t3.requestFocus();
		}
		else if(pf1.getText().equals("")){
			JOptionPane.showMessageDialog(f1, "Please Enter Password");
    		pf1.requestFocus();
		}
		else if(pf2.getText().equals("")){
			JOptionPane.showMessageDialog(f1, "Please Enter Confirm Password");
    		pf2.requestFocus();
		}
		else if(!(pf1.getText().equals(pf2.getText()))){
			JOptionPane.showMessageDialog(f1, "Password And Re-enter Password are Not Matched");
			pf2.setText("");
			pf2.requestFocus();
		}
		else{
			try{
				con = DriverManager.getConnection(url);
				String sql1="SELECT * FROM New_User WHERE Email_Id='"+t2.getText()+"' ";
				Statement st1=con.createStatement();
				ResultSet rs1=st1.executeQuery(sql1);
				String sql2="SELECT * FROM New_User WHERE User_Id='"+t3.getText()+"' ";
				Statement st2=con.createStatement();
				ResultSet rs2=st2.executeQuery(sql2);
				if(rs1.next()){
					JOptionPane.showMessageDialog(null, "Sorry... E-mail id already taken ");
					t2.setText("");
					t2.requestFocus();
				}
				else if(rs2.next()){
					JOptionPane.showMessageDialog(null, "Sorry... User Id already taken ");
					t3.setText("");
					t3.requestFocus();
				}
				else{
					String sql3 ="INSERT INTO New_User(Name,Email_Id,User_Id,Password) VALUES('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+pf1.getText()+"')";
					Statement st3=con.createStatement();
					st3.executeUpdate(sql3);
					con.close();
					JOptionPane.showMessageDialog(null, "Create SucessFully");
					new LogIn();
		        	f1.dispose();
//					t1.setText("");
//					t2.setText("");
//					t3.setText("");
//					pf1.setText("");
//	    			pf2.setText("");
//	    			t1.requestFocus();
				}
				
			}
			catch(Exception e1){
				JOptionPane.showMessageDialog(f1, e1.getMessage());
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){
			submitpressed();
		}
		else if(e.getSource()==b2){
			t1.setText(null);
			t2.setText(null);
			t3.setText(null);
			pf1.setText(null);
			pf2.setText(null);
			t1.requestFocus();
		}
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==10){
			if(e.getSource()==t1){
				if(t1.getText().equals("")){
					JOptionPane.showMessageDialog(f1, "Please Enter Name");
					t1.requestFocus();
				}
				else{
					t2.requestFocus();
				}
			}
			else if(e.getSource()==t2){
				if(t2.getText().equals("")){
					JOptionPane.showMessageDialog(f1, "Please Enter E-mail id");
					t2.requestFocus();
				}
				else{
					try{
						con = DriverManager.getConnection(url);
						String sql1="SELECT * FROM New_User WHERE Email_Id='"+t2.getText()+"' ";
						Statement st1=con.createStatement();
						ResultSet rs1=st1.executeQuery(sql1);
						if(rs1.next()){
							JOptionPane.showMessageDialog(null, "Sorry... E-mail id already taken ");
							t2.setText("");
							t2.requestFocus();
						}
						else{
							t3.requestFocus();
						}
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
				}
			}
			else if(e.getSource()==t3){
				if(t3.getText().equals("")){
					JOptionPane.showMessageDialog(f1, "Please Enter User id");
					t3.requestFocus();
				}
				else{
					try{
						con = DriverManager.getConnection(url);
						String sql2="SELECT * FROM New_User WHERE User_Id='"+t3.getText()+"'";
						Statement st2=con.createStatement();
						ResultSet rs2=st2.executeQuery(sql2);
						if(rs2.next()){
							JOptionPane.showMessageDialog(null, "Sorry... User Id already taken ");
							t3.setText("");
							t3.requestFocus();
						}
						else{
							pf1.requestFocus();	
						}
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
			else if(e.getSource()==pf1){
				if(pf1.getText().equals("")){
					JOptionPane.showMessageDialog(f1, "Please Enter Password");
					pf1.requestFocus();
				}
				else{
					pf2.requestFocus();
				}
			}
			else if(e.getSource()==pf2){
				if(pf2.getText().equals("")){
					JOptionPane.showMessageDialog(f1, "Please Enter Confirm Password");
					pf2.requestFocus();
				}
				else{
					if(!(pf1.getText().equals(pf2.getText()))){
						JOptionPane.showMessageDialog(null, "Password and Confirm Password do not Match");
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

	public void keyReleased(KeyEvent e) {
		
		
	}

	public void keyTyped(KeyEvent e) {
		
		
	}

	public void mouseClicked(MouseEvent e) {
		 if(e.getSource()==sp1){
	            pf1.setEchoChar((char) 0);
	        }
	        else if(e.getSource()==sp2){
	            pf2.setEchoChar((char) 0);
	        }
	        else if(e.getSource()==l8){
	        	new LogIn();
	        	f1.dispose();
	        }
	        else{
	        }
		 
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		if(e.getSource()==sp1){
            pf1.setEchoChar('•');
        }
        else if(e.getSource()==sp2){
            pf2.setEchoChar('•');
        }
        else{
        }
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public static void main(String[] e) {
		new CreateNewUser();
	}
}
