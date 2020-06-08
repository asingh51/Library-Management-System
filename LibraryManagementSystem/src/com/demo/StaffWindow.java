package com.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StaffWindow {

	public static void constructWindow() {

		JFrame jFrameMember = new JFrame("Staff");															// create a frame.
		jFrameMember.setBounds(500, 0, 490, 490);
		jFrameMember.getContentPane().setLayout(null);
		jFrameMember.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);				
		jFrameMember.setVisible(true);
		
		JLabel userLabel1 = new JLabel("SSN");												// Create label
		userLabel1.setBounds(20, 30, 195, 14);
		jFrameMember.getContentPane().add(userLabel1);			
		
		JTextField jTextField1 = new JTextField();															// Text field to enter the name
		jTextField1.setBounds(145, 30, 188, 20);
		jFrameMember.getContentPane().add(jTextField1);
		jTextField1.setColumns(10);
		
		
		JLabel userLabel2 = new JLabel("Name");												// Create label
		userLabel2.setBounds(20, 60, 195, 14);
		jFrameMember.getContentPane().add(userLabel2);			
		
		JTextField jTextField2 = new JTextField();															// Text field to enter the name
		jTextField2.setBounds(145, 60, 188, 20);
		jFrameMember.getContentPane().add(jTextField2);
		jTextField2.setColumns(10);
		
		JLabel userLabel7 = new JLabel("Type");												// Create label
		userLabel7.setBounds(20, 210, 195, 14);
		jFrameMember.getContentPane().add(userLabel7);			
				
		String[] ProfStrings = { "chief librarian", "departmental associate librarian", "reference librarian", "check-out staff", "library assistant"};
		JComboBox jProfListComboBox = new JComboBox(ProfStrings);
		jProfListComboBox.setBounds(145, 210, 188, 20);
		jFrameMember.getContentPane().add(jProfListComboBox);
		
		JButton jButtonSend = new JButton("Save");												//Button for Exit functionality
		jButtonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				StaffDao.save(jTextField1.getText(), jTextField2.getText(), (String)jProfListComboBox.getSelectedItem());	
			}
		});
		jButtonSend.setBounds(200, 290, 89, 23);
		jFrameMember.getContentPane().add(jButtonSend);
	
	}
}
