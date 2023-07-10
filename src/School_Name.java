import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class School_Name implements ActionListener,MouseListener {
	
	JFrame f1;
	JLabel l1,l2,l3,SN,bg1;
	ImageIcon i,i1,i2;
	Font fo1, fo2, fo3;
	String School_Name1,path1,url1;
	Connection con;
	
	public School_Name() {
		
		f1=new JFrame("Welcome");
		
		fo1 = new Font("Bell MT", Font.BOLD, 28);
		fo2 = new Font("Bell MT", Font.BOLD, 22);
		fo3 = new Font("Algerian", Font.BOLD, 30);
		
		
		path1="C:/Users/LENOVO/workspace/eclipse/School Management/DateBase/School_Detail.accdb";
		url1="jdbc:ucanaccess://"+path1;
		
		
		JPanel p1=new JPanel();
		p1.setBounds(190, 350, 512, 60);
		p1.setOpaque(false);

		f1.add(p1);
		
		l2=new JLabel("Enter");
		l2.setFont(fo1);
		l2.setForeground(new Color(75,0,130));
		l2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l2.setBounds(530, 670, 75, 50);
		l2.addMouseListener(this);
		l2.setVisible(true);
		f1.add(l2);
		
		l3=new JLabel("<HTML>Regist-<br/>ration</HTML>");
		l3.setFont(fo1);
		l3.setForeground(new Color(75,0,130));
		l3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l3.setBounds(520, 670, 85, 60);
		l3.setVisible(false);
		l3.addMouseListener(this);
		f1.add(l3);
		
		l1= new JLabel();
		l1.setBounds(485, 550, 200, 300);
		ImageIcon img1=new ImageIcon("images/School_ER.png");
		Image imgi1=img1.getImage().getScaledInstance(l1.getWidth(), l1.getHeight(), Image.SCALE_SMOOTH);
		i1=new ImageIcon(imgi1);		
		l1.setIcon(i1);
		f1.add(l1);
		
		bg1=new JLabel();  
        bg1.setBounds(0,0,900,1000);
		
		ImageIcon img=new ImageIcon("images/School_Name.jpg");
		Image imgi=img.getImage().getScaledInstance(bg1.getWidth(), bg1.getHeight(), Image.SCALE_SMOOTH);
		i=new ImageIcon(imgi);		
		bg1.setIcon(i);
		f1.add(bg1);
		
		
		try{
			con=DriverManager.getConnection(url1);
			String sql1="SELECT * FROM School_Details";
			Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery(sql1);
			String sql2="SELECT School_Name FROM School_Details";
			Statement st2=con.createStatement();
			ResultSet rs2=st2.executeQuery(sql2);
			if(rs1.next()){
				l2.setVisible(true);
				l3.setVisible(false);
				if(rs2.next()){
				School_Name1 =rs2.getString(1);
				}
			}
			else{
				l3.setVisible(true);
				l2.setVisible(false);
				School_Name1 ="School";
			}
			con.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		SN=new JLabel(School_Name1);
		SN.setFont(fo3);
		SN.setForeground(Color.BLUE);
		SN.setBounds(95-((School_Name1.length()*10)), 10, 510, 60);
		p1.add(SN);
		
		f1.setSize(900,1000);
		f1.setLayout(null);
		f1.setLocationRelativeTo(null);
        f1.setResizable(false);
//        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
	}

	public static void main(String[] args) {
		new School_Name();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==l3){
			new S_Details();
			f1.dispose();
		}
		else if(e.getSource()==l2){
			new School_Management();
			f1.dispose();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==l2){
			l2.setForeground(new Color(220,20,60));
			l2.setFont(new Font("Bell MT", Font.BOLD, 29));
		}
		else if(e.getSource()==l3){
			l3.setForeground(new Color(220,20,60));
			l3.setFont(new Font("Bell MT", Font.BOLD, 29));
	
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==l2){
			l2.setForeground(new Color(75,0,130));
			l2.setFont(new Font("Bell MT", Font.BOLD, 28));
		}
		else if(e.getSource()==l3){
			l3.setForeground(new Color(75,0,130));
			l3.setFont(new Font("Bell MT", Font.BOLD, 28));
		}
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
