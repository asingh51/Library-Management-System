package com.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NeededBookWindow {

	public static void constructWindow() {

		JFrame jFrameMember = new JFrame("Book");															// create a frame.
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
		
		JLabel userLabel2 = new JLabel("No Of Copies Needed");												// Create label
		userLabel2.setBounds(20, 210, 195, 14);
		jFrameMember.getContentPane().add(userLabel2);			
				
		JTextField jTextField2 = new JTextField();															// Text field to enter the name
		jTextField2.setBounds(145, 210, 188, 20);
		jFrameMember.getContentPane().add(jTextField2);
		jTextField2.setColumns(10);
		
		JButton jButtonSend = new JButton("Save");															//Button for Exit functionality
		jButtonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				NeededBookDao.save((String)jISBNListComboBox.getSelectedItem(), jTextField2.getText());	
			}
		});
		jButtonSend.setBounds(200, 290, 89, 23);
		jFrameMember.getContentPane().add(jButtonSend);
	
		
	}
}
