package com.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InLibraryBookWindow {

	public static void constructWindow() {

		JFrame jFrameMember = new JFrame("InLibraryBook");															// create a frame.
		jFrameMember.setBounds(500, 0, 490, 490);
		jFrameMember.getContentPane().setLayout(null);
		jFrameMember.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);				
		jFrameMember.setVisible(true);
		
		List<String> rsList= new ArrayList<String>();
		rsList=BookDao.getAllISBN();
		
		JLabel userLabel1 = new JLabel("ISBN");																// Create label
		userLabel1.setBounds(20, 30, 195, 14);
		jFrameMember.getContentPane().add(userLabel1);			
		String[] ISBNStrings = Arrays.copyOf(rsList.toArray(), rsList.toString().length(), String[].class);

		JComboBox jISBNListComboBox = new JComboBox(ISBNStrings);
		jISBNListComboBox.setBounds(145, 30, 188, 20);
		jFrameMember.getContentPane().add(jISBNListComboBox);
		
		JLabel userLabel2 = new JLabel("Can Rent");												// Create label
		userLabel2.setBounds(20, 60, 195, 14);
		jFrameMember.getContentPane().add(userLabel2);			
		
		JTextField jTextField2 = new JTextField();															// Text field to enter the name
		jTextField2.setBounds(145, 60, 188, 20);
		jFrameMember.getContentPane().add(jTextField2);
		jTextField2.setColumns(10);
		
		JLabel userLabel3 = new JLabel("NoOfCopies");												// Create label
		userLabel3.setBounds(20, 90, 195, 14);
		jFrameMember.getContentPane().add(userLabel3);			
		
		JTextField jTextField3 = new JTextField();															// Text field to enter the name
		jTextField3.setBounds(145, 90, 188, 20);
		jFrameMember.getContentPane().add(jTextField3);
		jTextField3.setColumns(10);
		
		
		JLabel userLabel4 = new JLabel("RentedCopies");												// Create label
		userLabel4.setBounds(20, 120, 195, 14);
		jFrameMember.getContentPane().add(userLabel4);			
		
		JTextField jTextField4 = new JTextField();															// Text field to enter the name
		jTextField4.setBounds(145, 120, 188, 20);
		jFrameMember.getContentPane().add(jTextField4);
		jTextField4.setColumns(10);
		
		JLabel userLabel5 = new JLabel("BookDesc");												// Create label
		userLabel5.setBounds(20, 150, 195, 14);
		jFrameMember.getContentPane().add(userLabel5);			
		
		JTextField jTextField5 = new JTextField();															// Text field to enter the name
		jTextField5.setBounds(145, 150, 188, 20);
		jFrameMember.getContentPane().add(jTextField5);
		jTextField5.setColumns(10);
		
		JButton jButtonSend = new JButton("Save");												//Button for Exit functionality
		jButtonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InLibraryBookDao.save((String)jISBNListComboBox.getSelectedItem(), jTextField2.getText(), jTextField3.getText(), jTextField4.getText(), jTextField5.getText());	
			}
		});
		jButtonSend.setBounds(200, 290, 89, 23);
		jFrameMember.getContentPane().add(jButtonSend);
	}
}
