package com.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RenewMemberShipWindow {
	
	public static void constructWindow() {

		JFrame jFrameMember = new JFrame("Renew Membership");															// create a frame.
		jFrameMember.setBounds(500, 0, 490, 490);
		jFrameMember.getContentPane().setLayout(null);
		jFrameMember.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);				
		jFrameMember.setVisible(true);
		
		JLabel userLabel1 = new JLabel("Members SSN");												// Create label
		userLabel1.setBounds(20, 30, 195, 14);
		jFrameMember.getContentPane().add(userLabel1);			
		
		JTextField jTextField1 = new JTextField();															// Text field to enter the name
		jTextField1.setBounds(195, 30, 188, 20);
		jFrameMember.getContentPane().add(jTextField1);
		jTextField1.setColumns(10);
		
		
		
		
		JButton jButtonSend = new JButton("Renew");												//Button for Exit functionality
		jButtonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					MemberDao.renewMemberShip(jTextField1.getText());	
				}
		});
		jButtonSend.setBounds(200, 290, 89, 23);
		jFrameMember.getContentPane().add(jButtonSend);
	
	}
}
