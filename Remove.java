import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Remove extends JFrame{
	
	private JButton btnDelete;
	private JButton btnCancel;
	private JButton btnBackToHomePage; 
	private JButton btnSearchContact;
	
	private JTextField searchTextPanel;
	private JTextField txConatactID;
	private JTextField txName;
	private JTextField txCNumber;
	private JTextField txCompany;
	private JTextField txSalary;
	private JTextField txBDay;
	
	
	Remove(){
		setSize(600,600);
		setTitle("Delete Contact");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
//------------------------LABELS-----------------------------------------------------//
		
		JLabel titleLabel=new JLabel("DELETE CONTACT");
        titleLabel.setFont(new Font("",1,40));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBackground(Color.decode("#00b894"));
		titleLabel.setOpaque(true);
		titleLabel.setForeground(Color.WHITE);
		add("North",titleLabel);
		
		
		
		JPanel labelPanel=new JPanel(new GridLayout(8,0,2,2));
		JLabel lbID=new JLabel("Contact ID", SwingConstants.CENTER);
		lbID.setFont(new Font("",1,30));
		labelPanel.add(lbID);
		
		JLabel lbName=new JLabel("Name", SwingConstants.CENTER);
		lbName.setFont(new Font("",1,30));
		labelPanel.add(lbName);
		
		JLabel lbCNumber=new JLabel("Contact Number", SwingConstants.CENTER);
		lbCNumber.setFont(new Font("",1,30));
		labelPanel.add(lbCNumber);
		
		JLabel lbCompany=new JLabel("Company", SwingConstants.CENTER);
		lbCompany.setFont(new Font("",1,30));
		labelPanel.add(lbCompany);
		
		JLabel lbSalary=new JLabel("Salary", SwingConstants.CENTER);
		lbSalary.setFont(new Font("",1,30));
		labelPanel.add(lbSalary);
		
		JLabel lbBDay=new JLabel("Birth Day", SwingConstants.CENTER);
		lbBDay.setFont(new Font("",1,30));
		labelPanel.add(lbBDay);
		
		
	
		
		
		add("West",labelPanel);
		
//-------------------------------END LABELS--------------------------------------//	

//---------------------------TEXTFILEDS--------------------------------------------//

        JPanel textPanel=new JPanel(new GridLayout(6,0,2,2));
        txConatactID=new JTextField(10);
        txConatactID.setFont(new Font("",1,25));
        JPanel ConatactIDTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        ConatactIDTextPanel.add(txConatactID);
        textPanel.add(ConatactIDTextPanel);
        
        txName=new JTextField(10);
        txName.setFont(new Font("",1,25));
        JPanel NameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        NameTextPanel.add(txName);
        textPanel.add(NameTextPanel);
        
        txCNumber=new JTextField(10);
        txCNumber.setFont(new Font("",1,25));
        JPanel CNumberTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        CNumberTextPanel.add(txCNumber);
        textPanel.add(CNumberTextPanel);
        
        txCompany=new JTextField(10);
        txCompany.setFont(new Font("",1,25));
        JPanel CompanyTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        CompanyTextPanel.add(txCompany);
        textPanel.add(CompanyTextPanel);
        
        txSalary=new JTextField(10);
        txSalary.setFont(new Font("",1,25));
        JPanel SalaryTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        SalaryTextPanel.add(txSalary);
        textPanel.add(SalaryTextPanel);
        
        txBDay=new JTextField(10);
        txBDay.setFont(new Font("",1,25));
        JPanel BDayTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        BDayTextPanel.add(txBDay);
        textPanel.add(BDayTextPanel);
        
        add("East",textPanel);
        
        
//-------------------------------END TEXTFILDES-----------------------------------//	
	
	
		
//---------------BUTTONS------------------------------------------------------------//		
        
       
        
		JPanel footerMain=new JPanel(new GridLayout(4,1,1,1));
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnDelete=new JButton("Delete");
		btnDelete.setFont(new Font("",1,20)); 
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				String nameOrPhone = searchTextPanel.getText();
				int index=ContactController.searchContacts(nameOrPhone);
				ContactController.Remove(index);
				if (searchTextPanel.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Text field is empty");
				}else if(index==-1){
					JOptionPane.showMessageDialog(null, "Deleted fail...");
				}else{
					JOptionPane.showMessageDialog(null, "Deleted successfully...");
				}
				int option =JOptionPane.showConfirmDialog(null, "Do you want to update another contact? ", "Confirm",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (option==JOptionPane.YES_OPTION) {
						 searchTextPanel.setText("");
		                 searchTextPanel.requestFocus();
		                  txConatactID.setText("");
	                      txName.setText("");
	                      txCNumber.setText("");
	                      txCompany.setText("");
	                      txSalary.setText("");
	                      txBDay.setText("");

					}else if(option==JOptionPane.NO_OPTION){
						searchTextPanel.setText("");
						  txConatactID.setText("");
						  txName.setText("");
						  txCNumber.setText("");
				       	  txCompany.setText("");
						  txSalary.setText("");
						  txBDay.setText("");
						    dispose();
					}

			}
		});
		buttonPanel.add(btnDelete);
		
		
		
		
		
		
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,20)); 
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				
					int option =JOptionPane.showConfirmDialog(null, "Are you sure to cancel this?", "Confirm",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (option==JOptionPane.YES_OPTION) {
						
						txConatactID.setText(ContactController.generateID());
						txName.setText("");
						txCNumber.setText("");
						txCompany.setText("");
						txSalary.setText("");
						txBDay.setText("");
						dispose();

					}else if(option==JOptionPane.NO_OPTION){
						txConatactID.setText(ContactController.generateID());
						txName.setText("");
						txCNumber.setText("");
						txCompany.setText("");
						txSalary.setText("");
						txBDay.setText("");
						txName.requestFocus();
						
					}
			}
		});
		buttonPanel.add(btnCancel);
		
		footerMain.add(buttonPanel);
		
		JPanel buttonPanelBottom=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnBackToHomePage=new JButton("Back to Home Page");
		btnBackToHomePage.setFont(new Font("",1,20)); 
		btnBackToHomePage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				Remove.this.dispose();
			}
		});
		buttonPanelBottom.add(btnBackToHomePage);
		footerMain.add(buttonPanelBottom);
		
		searchTextPanel=new JTextField(10);
		searchTextPanel.setFont(new Font("",1,30)); 
		JPanel searchPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		searchPanel.add(searchTextPanel);
		footerMain.add(searchPanel);
		
		btnSearchContact=new JButton("Search");
		btnSearchContact.setFont(new Font("",1,25)); 
		JPanel btnSearchPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnSearchContact.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent evt){
			 ContactList contactList=DBConnection.getInstance().getContactList();
				String nameOrPhone = searchTextPanel.getText();
				int index=ContactController.searchContacts(nameOrPhone);
				if(searchTextPanel.getText().equals("")){
					JOptionPane.showConfirmDialog(null, "Text field is Empty....Search Contact again..");
		            searchTextPanel.requestFocus();
				}else if(index!=-1){
					txConatactID.setText(contactList.get(index).getId());
					txName.setText(contactList.get(index).getName());
					txCNumber.setText(contactList.get(index).getPhoneNumber());
					txCompany.setText(contactList.get(index).getCompanyName());
					txSalary.setText(""+contactList.get(index).getSalary());
					txBDay.setText(contactList.get(index).getBirthday());
				}else{
					JOptionPane.showConfirmDialog(null, "No Contact found for"+nameOrPhone);
		            searchTextPanel.setText("");
		            searchTextPanel.requestFocus();
				}
			}
		});
		btnSearchPanel.add(btnSearchContact);
		footerMain.add(btnSearchPanel);
		
		add("South",footerMain);
//---------------------END BUTTONS---------------------------------------------//		
	}
 




	
}

