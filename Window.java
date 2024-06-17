import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;




class HomePage extends JFrame{
	
	private JButton btnAddContact;
	private JButton btnSearchContact;
	private JButton btnDeleteContact; 
	private JButton btnUpdateContact;
	private JButton btnViewContact;
	private JButton btnExit;
	
	private ViewContactLists viewContactList;
	private  AddContacts addContact;
	private  SearchContacts searchContact;
	private  Remove deleteContact;
	private  UpdateContacts updateContact;

	
	
	HomePage(){
		setSize(900,600);
		setTitle("Home Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(1,2));
		setLocationRelativeTo(null);
		
		
//--------------------LEFT SIDE---------------------------------------------------------------//

		
		JPanel leftSide=new JPanel(new GridLayout(4,1,1,1));
		
		JPanel leftTitle=new JPanel(new GridLayout(2,1));
		
		JLabel leftTitleFirstRow=new JLabel("iFRIEND" , SwingConstants.CENTER);
		leftTitleFirstRow.setFont(new Font("",1,40));
		leftTitleFirstRow.setBackground(Color.decode("#00b894"));
		leftTitleFirstRow.setOpaque(true);
		leftTitleFirstRow.setForeground(Color.WHITE);
		leftTitle.add("North" , leftTitleFirstRow);
		
		JLabel leftTitleSecondRow=new JLabel("CONTACT MANAGER" , SwingConstants.CENTER);
		leftTitleSecondRow.setFont(new Font("",1,40));
		leftTitleSecondRow.setBackground(Color.decode("#00b894"));
		leftTitleSecondRow.setOpaque(true);
		leftTitleSecondRow.setForeground(Color.WHITE);
		leftTitle.add("South" , leftTitleSecondRow);
		
		
		
		leftSide.add("North" , leftTitle);
		add("West" , leftSide);
		
		
//---------------END LEFT SIDE---------------------------------------------------------------//	

	
//----------------RIGHT SIDE-----------------------------------------------------------------//

        JPanel rightSide = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		rightSide.setLayout(new GridLayout(7,0,2,2));
		
		JLabel rightTitle=new JLabel("HOME PAGE",SwingConstants.CENTER);
		rightTitle.setFont(new Font("",1,30));
		rightTitle.setHorizontalAlignment(JLabel.CENTER);
		rightSide.add("North",rightTitle);
        
        
        
        btnAddContact=new JButton("Add Contact");
		btnAddContact.setFont(new Font("",1,20));
		btnAddContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(addContact==null){
					addContact=new AddContacts();
				}
				addContact.setVisible(true);
			}
		});

		rightSide.add(btnAddContact);
		

				
		btnUpdateContact=new JButton("Update Contact");
		btnUpdateContact.setFont(new Font("",1,20));
		btnUpdateContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if (updateContact==null) {
					updateContact=new UpdateContacts();
				}
				updateContact.setVisible(true);
			}
		});
		
		rightSide.add(btnUpdateContact);

		
		
		btnSearchContact=new JButton("Search Contact");
		btnSearchContact.setFont(new Font("",1,20));
		btnSearchContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if (searchContact==null) {
					searchContact=new SearchContacts();
				}
				searchContact.setVisible(true);
			}
		});
		rightSide.add(btnSearchContact);

		
		
		btnDeleteContact=new JButton("Delete Contact");
		btnDeleteContact.setFont(new Font("",1,20));
		btnDeleteContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if (deleteContact==null) {
					deleteContact=new Remove();
				}
				deleteContact.setVisible(true);
			}
		});

		rightSide.add(btnDeleteContact);
		
		
		
		btnViewContact=new JButton("View contact");
		btnViewContact.setFont(new Font("",1,20));
		btnViewContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if (viewContactList==null) {
					viewContactList=new ViewContactLists();
				}
				viewContactList.setVisible(true);
			}
		});

		rightSide.add(btnViewContact);
		
		
		JPanel buttonFooterPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnExit=new JButton("Exit");
		btnExit.setFont(new Font("",1,20)); 
		buttonFooterPanel.add(btnExit);
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
			}
		});
		
		
		rightSide.add("South",buttonFooterPanel);
		
		
		add("East" , rightSide);

//---------------END RIGHT SIDE--------------------------------------------------------------//


		
		
		
	}
 }



class Window{
	public static void main(String args[]){
		new HomePage().setVisible(true);;
		
	}
}
