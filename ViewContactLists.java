import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ViewContactLists extends JFrame{
	private JButton btnListByName;
	private JButton btnListBySalary;
	private JButton btnListByBirthday;
	private JButton btnBackToHomePage; 
	private ListByBirthday listByBirthday;
	private ListByName listByName;
	private ListBySalary listBySalary;
	
	ViewContactLists(){
		setSize(700,400);
		setTitle("Contact List");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		JLabel titleLabel=new JLabel("CONTACT LIST");
		titleLabel.setFont(new Font("",1,35)); 
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBackground(Color.decode("#00b894"));
		titleLabel.setOpaque(true);
		titleLabel.setForeground(Color.WHITE);
		add("North",titleLabel);
		
		
		JPanel mainPanel=new JPanel(new GridLayout(3,1,1,1));
		
		JPanel topPanel=new JPanel(new GridLayout(1,1,1,1));
		JPanel topButtonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		btnListByName=new JButton("List by Name");
		btnListByName.setFont(new Font("",1,30)); 
		btnListByName.setPreferredSize(new Dimension(300, 50));
		btnListByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				if (listByName==null) {
					listByName=new ListByName();
				}
				listByName.setVisible(true);
			}
		});
		topButtonPanel.add(btnListByName);
		
		topPanel.add(topButtonPanel);
		
		mainPanel.add(topPanel);
		
		
		JPanel centerPanel=new JPanel(new GridLayout(1,1,1,1));
		JPanel centerButtonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		btnListBySalary=new JButton("List by Salary");
		btnListBySalary.setFont(new Font("",1,30)); 
		btnListBySalary.setPreferredSize(new Dimension(300, 50));
		btnListBySalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				if (listBySalary==null) {
					listBySalary=new ListBySalary();
				}
				listBySalary.setVisible(true);
			}
		});
		
		centerButtonPanel.add(btnListBySalary);
		
		centerPanel.add(centerButtonPanel);
		
		mainPanel.add(centerPanel);
		
		
		JPanel bottomPanel=new JPanel(new GridLayout(1,1,1,1));
		JPanel bottomButtonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		btnListByBirthday=new JButton("List by Birthday");
		btnListByBirthday.setFont(new Font("",1,30)); 
		btnListByBirthday.setPreferredSize(new Dimension(300, 50));
		btnListByBirthday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				if (listByBirthday==null) {
					listByBirthday=new ListByBirthday();
				}
				listByBirthday.setVisible(true);
			}
		});
		bottomButtonPanel.add(btnListByBirthday);
		
		bottomPanel.add(bottomButtonPanel);
		
		mainPanel.add(bottomPanel);
		
		add(mainPanel);
				//---------------------footer buttons------------------------
		
		JPanel footerMain=new JPanel(new GridLayout(1,1,1,1));
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
	
		JPanel buttonPanelBottom=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnBackToHomePage=new JButton("Back to Home Page");
		btnBackToHomePage.setFont(new Font("",1,20)); 
		buttonPanelBottom.add(btnBackToHomePage);
		btnBackToHomePage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ViewContactLists.this.dispose();
			}
		});
		buttonPanelBottom.add(btnBackToHomePage);
		footerMain.add(buttonPanelBottom);
		
		add("South",footerMain);
		
	}



	
}
