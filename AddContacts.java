import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AddContacts extends JFrame{
	
	private JButton btnAddContact;
	private JButton btnCancel;
	private JButton btnBackToHomePage; 
	
	private JLabel txConatactID;
	private JTextField txName;
	private JTextField txCNumber;
	private JTextField txCompany;
	private JTextField txSalary;
	private JTextField txBDay;
	
	
	AddContacts(){
		setSize(700,500);
		setTitle("Add Contact");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
//------------------------LABELS-----------------------------------------------------//
		
		JLabel titleLabel=new JLabel("ADD CONTACT");
        titleLabel.setFont(new Font("",1,40));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBackground(Color.decode("#00b894"));
		titleLabel.setOpaque(true);
		titleLabel.setForeground(Color.WHITE);
		add("North",titleLabel);
		
		
		
		JPanel labelPanel=new JPanel(new GridLayout(6,0,2,2));
		JLabel lbID=new JLabel("Contact ID", SwingConstants.CENTER);
		lbID.setFont(new Font("",1,30));
		labelPanel.add(lbID);
		
		JLabel lbName=new JLabel("Name", SwingConstants.CENTER);
		lbName.setFont(new Font("",1,25));
		labelPanel.add(lbName);
		
		JLabel lbCNumber=new JLabel("Contact Number", SwingConstants.CENTER);
		lbCNumber.setFont(new Font("",1,25));
		labelPanel.add(lbCNumber);
		
		JLabel lbCompany=new JLabel("Company", SwingConstants.CENTER);
		lbCompany.setFont(new Font("",1,25));
		labelPanel.add(lbCompany);
		
		JLabel lbSalary=new JLabel("Salary", SwingConstants.CENTER);
		lbSalary.setFont(new Font("",1,25));
		labelPanel.add(lbSalary);
		
		JLabel lbBDay=new JLabel("Birth Day", SwingConstants.CENTER);
		lbBDay.setFont(new Font("",1,25));
		labelPanel.add(lbBDay);
		
		add("West",labelPanel);
		
//-------------------------------END LABELS--------------------------------------//	

//---------------------------TEXTFILEDS--------------------------------------------//

        JPanel textPanel=new JPanel(new GridLayout(6,0,2,2));
        txConatactID=new JLabel(ContactController.generateID());
        txConatactID.setFont(new Font("",1,30)); 
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		idTextPanel.add(txConatactID);
		textPanel.add(idTextPanel);
		
        
        txName=new JTextField(10);
        txName.setFont(new Font("",1,25));
        JPanel NameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        NameTextPanel.add(txName);
        textPanel.add(NameTextPanel);
        
        
        txCNumber=new JTextField(10);
        txCNumber.setFont(new Font("",1,25));
        JPanel CNumberTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        CNumberTextPanel.add(txCNumber);
        txCNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				String phoneNumber = txCNumber.getText();
				boolean isValidPhoneNumber=ContactController.isValidPhoneNumber(phoneNumber);
				
				if (!isValidPhoneNumber) {
					int option =JOptionPane.showConfirmDialog(null, "Invalid Phone Number.. Do you want to input number again?", "Confirm",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (option==JOptionPane.YES_OPTION) {
						txCNumber.setText("");
						txCNumber.requestFocus();
					}else if(option==JOptionPane.NO_OPTION){
						ContactController.count();
						txConatactID.setText(ContactController.generateID());
						txName.setText("");
						txCNumber.setText("");
						txCompany.setText("");
						txSalary.setText("");
						txBDay.setText("");
						dispose();
					}

				}
			}
		});
        
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

		JPanel footerMain=new JPanel(new GridLayout(2,1,1,1));
		
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnAddContact=new JButton("Add Contact");
		btnAddContact.setFont(new Font("",1,20));
		btnAddContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id=txConatactID.getText();
				String name=txName.getText();
				String phoneNumber=txCNumber.getText();
				String company=txCompany.getText();
				double salary=Double.parseDouble(txSalary.getText());
				String birthday=txBDay.getText();
				Contacts contact=new Contacts(id,name,phoneNumber,company,salary,birthday);
				

				boolean isValidPhoneNumber=ContactController.isValidPhoneNumber(phoneNumber);
				boolean isValidSalary=ContactController.isValidSalary(salary);
				boolean isValidBirthday=ContactController.isValidBirthday(birthday);

				if (!isValidPhoneNumber) {
					int option =JOptionPane.showConfirmDialog(null, "Invalid Phone Number.. Do you want to input number again?", "Confirm",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (option==JOptionPane.YES_OPTION) {
						txCNumber.setText("");
						txCNumber.requestFocus();
					}else if(option==JOptionPane.NO_OPTION){
						ContactController.count();
						txConatactID.setText(ContactController.generateID());
						txName.setText("");
						txCNumber.setText("");
						txCompany.setText("");
						txSalary.setText("");
						txBDay.setText("");
						dispose();
					}
				}else if(!isValidSalary){
					int option =JOptionPane.showConfirmDialog(null, "Invalid Salary.. Do you want to input Salary again?", "Confirm",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (option==JOptionPane.YES_OPTION) {
						txSalary.setText("");
						txSalary.requestFocus();
					}else if(option==JOptionPane.NO_OPTION){
						ContactController.count();
						txConatactID.setText(ContactController.generateID());
						txName.setText("");
						txCNumber.setText("");
						txCompany.setText("");
						txSalary.setText("");
						txBDay.setText("");
						dispose();
					}
				}else if(!isValidBirthday){
					int option =JOptionPane.showConfirmDialog(null, "Invalid Birthday.. Do you want to input Birthday again?", "Confirm",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (option==JOptionPane.YES_OPTION) {
						txBDay.setText("");
						txBDay.requestFocus();
					}else if(option==JOptionPane.NO_OPTION){
						ContactController.count();
						txConatactID.setText(ContactController.generateID());
						txName.setText("");
						txCNumber.setText("");
						txCompany.setText("");
						txSalary.setText("");
						txBDay.setText("");
						dispose();
					}
				}else{
					ContactController.AddContacts(contact);
					int option =JOptionPane.showConfirmDialog(null, "Added Successfull.. Do you want to add another contact?", "Confirm",JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (option==JOptionPane.YES_OPTION) {
						txConatactID.setText(ContactController.generateID());
						txName.setText("");
						txCNumber.setText("");
						txCompany.setText("");
						txSalary.setText("");
						txBDay.setText("");
						txName.requestFocus();

					}else if(option==JOptionPane.NO_OPTION){
						txConatactID.setText(ContactController.generateID());
						txName.setText("");
						txCNumber.setText("");
						txCompany.setText("");
						txSalary.setText("");
						txBDay.setText("");
						dispose();
					}
				}
			}
		});
 
		
		buttonPanel.add(btnAddContact);
		
		
		
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
		buttonPanelBottom.add(btnBackToHomePage);
		btnBackToHomePage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				AddContacts.this.dispose();
			}
		});
		buttonPanelBottom.add(btnBackToHomePage);
		footerMain.add(buttonPanelBottom);
		
		add("South",footerMain);
//---------------------END BUTTONS---------------------------------------------//		
	}
 




	
 }
