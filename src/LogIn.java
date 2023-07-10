import java.awt.*;
import java.awt.event.*;
import java.sql.*;


import javax.swing.*;

public class LogIn implements ActionListener,MouseListener,KeyListener {

	JFrame f1;
    JPanel p1,p2;
    JLabel l1,l2,l3,l4,l5,l6,l7,pi1,pi2,pi3,pi4,sp1,sp2,bg1;
    JTextField t1;
    JPasswordField pf1,pf2;
    JButton b1;
    Font fo1,fo2,fo3;
    Color c1=new Color(233,90,75);
    
    String path;
	String url;
	Connection con;
    
	public LogIn() {
		f1=new JFrame("LogIn");
		
		path="C:/Users/LENOVO/workspace/eclipse/School Management/DateBase/CreateNew.mdb";
		url="jdbc:ucanaccess://"+path;

        fo1=new Font("Century Schoolbook",Font.BOLD,28);
        fo2=new Font("Serif",Font.PLAIN,16);
        fo3=new Font("Serif",Font.BOLD,18);
        
        l1=new JLabel("Login");
        l1.setFont(fo1);
        l1.setForeground(new Color(75,0,0));
        l1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.red));
        l1.setBounds(187, 20, 90, 50);
        
        l2=new JLabel("User Id");
        l2.setFont(fo2);
        l2.setForeground(c1);
        l2.setBounds(0, 5, 150, 30);
        
        t1=new JTextField();
        t1.setFont(fo3);
        t1.setOpaque(false);
        t1.setBounds(0, 30, 200, 25);
        t1.addKeyListener(this);
        
        l3=new JLabel("Password");
        l3.setFont(fo2);
        l3.setForeground(c1);
        l3.setBounds(0, 60, 150, 30);
        
        pf1=new JPasswordField();
        pf1.setEchoChar('•');
        pf1.setFont(fo2);
        pf1.setOpaque(false);
        pf1.setBounds(0, 85, 200, 25);
        pf1.addKeyListener(this);
        
        sp1=new JLabel(new ImageIcon("images/view.png"));
        sp1.setBounds(170, 0, 28, 24);
        sp1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sp1.setToolTipText("Show Password");
        sp1.setOpaque(false);
        sp1.addMouseListener(this);
        
        l4=new JLabel("Re-enter Password");
        l4.setFont(fo2);
        l4.setForeground(c1);
        l4.setBounds(0, 115, 200, 30);
        
        pf2=new JPasswordField(); 
        pf2.setEchoChar('•');
        pf2.setFont(fo2);
        pf2.setOpaque(false);
        pf2.setBounds(0, 140, 200, 25);
        pf2.addKeyListener(this);
        
        sp2=new JLabel(new ImageIcon("images/view.png"));
        sp2.setBounds(170, 0, 28, 24);
        sp2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sp2.setToolTipText("Show Password");
        sp2.setOpaque(false);
        sp2.addMouseListener(this);
        
        l5=new JLabel("<html><U>Forgot Password</U></html>");
        l5.setFont(fo2);
        l5.setForeground(Color.blue.darker());
        l5.setBounds(0, 175, 200, 30);
        l5.addMouseListener(this);
        l5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        l6=new JLabel("Don't have an account?");
        l6.setFont(new Font("Serif",Font.PLAIN,14));
        l6.setForeground(Color.gray);
        l6.setBounds(110, 330, 150, 30);
        
        l7=new JLabel("<html><U>Create new User</U></html>");
        l7.setFont(fo2);
        l7.setForeground(Color.blue.darker());
        l7.setBounds(250, 330, 200, 30);
        l7.addMouseListener(this);
        l7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        b1=new JButton("Login");
        b1.setFont(new Font("Serif",Font.BOLD,20));
        b1.setBorder(BorderFactory.createBevelBorder(0, new Color(80,245,255), new Color(80,105,255)));
        b1.setBounds(110, 300, 245, 30);
        b1.addActionListener(this);
        b1.addKeyListener(this);
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b1.setForeground(new Color(75,0,0));
        b1.setBackground(new Color(248, 227, 250));
        
        p1=new JPanel();
        p1.setBounds(110, 95, 40, 200);
        p1.setOpaque(false);
        p1.setLayout(null);
        
        p2=new JPanel();
        p2.setBounds(150, 85, 200, 220);
        p2.setOpaque(false);
        p2.setLayout(null);
        
        pi1=new JLabel(new ImageIcon("images/idcard.png"));
        pi1.setBounds(2, 10, 35, 35);
        
        pi2=new JLabel(new ImageIcon("images/password.png"));
        pi2.setBounds(2, 65, 35, 35);
        
        pi3=new JLabel(new ImageIcon("images/password.png"));
        pi3.setBounds(2, 120, 35, 35);
        
        pi4=new JLabel(new ImageIcon("images/forgot.png"));
        pi4.setBounds(2, 165, 35, 35);
        
        bg1=new JLabel(new ImageIcon("images/1010.png"));  
        bg1.setBounds(0,0,475,450);
        
        f1.add(l1);f1.add(p1);
        f1.add(p2);f1.add(b1);
        f1.add(l6);f1.add(l7);
        
        p1.add(pi1);p1.add(pi2);
        p1.add(pi3);p1.add(pi4);
        
        p2.add(l2);p2.add(l3);
        p2.add(l4);p2.add(t1);
        p2.add(pf1);p2.add(pf2);
        p2.add(l5);
        
        pf1.add(sp1);pf2.add(sp2);
        
        f1.add(bg1);
        
        f1.setSize(475,450);
        f1.setLayout(null);
        f1.setLocationRelativeTo(null);
        f1.setResizable(false);
        //f1.setUndecorated(true);
//        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);

	}
	
	public void loginpressed(){
		if((t1.getText().equals(""))){
    		JOptionPane.showMessageDialog(f1, "Please Enter User Id");
    		t1.requestFocus();
    	}
    	else if((pf1.getText().equals(""))){
    		JOptionPane.showMessageDialog(f1, "Please Enter Password");
    		pf1.requestFocus();
    	}
    	else if((pf2.getText().equals(""))){
    		JOptionPane.showMessageDialog(f1, "Please Enter Re-enter Password");
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
				String sql1="select * from New_User where User_Id='"+t1.getText()+"' ";						
				Statement st1=con.createStatement();
				ResultSet rs1=st1.executeQuery(sql1);
				String sql2="select * from New_User where User_Id='"+t1.getText()+"' and Password='"+pf1.getText()+"'";						
				Statement st2=con.createStatement();
				ResultSet rs2=st2.executeQuery(sql2);
			
				if(!rs1.next()){
					JOptionPane.showMessageDialog(f1, "User Id does not exist.");
					t1.setText("");
					pf1.setText("");
					pf2.setText("");
					t1.requestFocus();
				}
				else if((rs1.next())||(!rs2.next())){
					JOptionPane.showMessageDialog(f1, "Password wrong!");
					pf1.setText("");
					pf2.setText("");
					pf1.requestFocus();
				}
//				else if(!(rs1.next())&&(rs2.next())){
//					JOptionPane.showMessageDialog(f1, "Not a valid User");
//					t1.setText("");
//					pf1.setText("");
//					pf2.setText("");
//					t1.requestFocus();
//				}
				else{
					con.close();
					JOptionPane.showMessageDialog(f1, "LogIn SucessFully");
	        		f1.dispose();
	        		new School_Name();	
				}
				
			}
			catch(Exception e1){
				JOptionPane.showMessageDialog(f1, e1.getMessage());
			}
    	}
	}

	public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
        	loginpressed();
        }
        else{
        }
    }
	
    public void mouseClicked(MouseEvent e) {  
        if(e.getSource()==sp1){
            pf1.setEchoChar((char) 0);
        }
        else if(e.getSource()==sp2){
            pf2.setEchoChar((char) 0);
        }
        else if(e.getSource()==l5){
        	new ForgotPassword();
        	f1.dispose();
        }
        else if(e.getSource()==l7){
        	new CreateNewUser();
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
						String sql="select * from New_User where User_Id='"+t1.getText()+"' ";						
						Statement st=con.createStatement();
						ResultSet rs=st.executeQuery(sql);
						if(rs.next()){
							con.close();
							pf1.requestFocus();
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
					JOptionPane.showMessageDialog(f1, "Please Re-enter Password");
					pf2.requestFocus();
				}
				else{
					if(!(pf1.getText().equals(pf2.getText()))){
						JOptionPane.showMessageDialog(null, "Password and Re-enter Password do not Match");
						pf2.setText("");
					}
					else{
						b1.requestFocus();	
					}
				}
			}
			else if(e.getSource()==b1){
				loginpressed();
			}
			else{
				
			}
			
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
	public static void main(String[] e) {
		new LogIn();
	}

}
