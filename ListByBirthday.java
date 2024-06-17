import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.table.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ListByBirthday extends JFrame{
	private JTable tblContactName;
	private DefaultTableModel dtm;

	
	private JButton btnHome;
	private JButton btnReload;
	
	
	ListByBirthday(){
		setSize(700,400);
		setTitle("List by BrithDay");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		JLabel titleLabel=new JLabel("LIST CONTACT BY BIRTHDAY");
		titleLabel.setFont(new Font("",1,35)); 
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBackground(Color.decode("#00b894"));
		titleLabel.setOpaque(true);
		titleLabel.setForeground(Color.WHITE);
		add("North",titleLabel);
		
		
		String[] columnName={"Contact ID", "Name","Contact Number","Salary", "Birthday"};
		dtm=new DefaultTableModel(columnName,0);
		tblContactName=new JTable(dtm);
		JScrollPane tablePane=new JScrollPane(tblContactName);
		add("Center",tablePane);

		
		
		
				//---------------------footer buttons------------------------
		
		JPanel footerMain=new JPanel(new GridLayout(1,1,1,1));
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				Contacts[] contactArray=ContactController.ListByName();

				dtm.setRowCount(0);
				for(int i=0; i<contactArray.length; i++){
					Contacts contact=contactArray[i];
					Object[] rowData = {contact.getId(),contact.getName(),contact.getPhoneNumber(),contact.getCompanyName(),contact.getSalary(),contact.getBirthday()};
					dtm.addRow(rowData);
				}
			}
		});
		buttonPanel.add(btnReload);
		
		footerMain.add(buttonPanel);
	
		btnHome=new JButton("Back to Home");
		btnHome.setFont(new Font("",1,20)); 
		btnHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ListByBirthday.this.dispose();
			}
		});
		buttonPanel.add(btnHome);
		
		footerMain.add(buttonPanel);
		
		add("South",footerMain);
		
	}
}



