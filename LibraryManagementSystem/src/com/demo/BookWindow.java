package com.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BookWindow {

	public static void constructWindow() {

		JFrame jFrameMember = new JFrame("Book");															// create a frame.
		jFrameMember.setBounds(500, 0, 490, 490);
		jFrameMember.getContentPane().setLayout(null);
		jFrameMember.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);				
		jFrameMember.setVisible(true);
		
		JLabel userLabel1 = new JLabel("ISBN");												// Create label
		userLabel1.setBounds(20, 30, 195, 14);
		jFrameMember.getContentPane().add(userLabel1);			
		
		JTextField jTextField1 = new JTextField();															// Text field to enter the name
		jTextField1.setBounds(145, 30, 188, 20);
		jFrameMember.getContentPane().add(jTextField1);
		jTextField1.setColumns(10);
		
		JLabel userLabel2 = new JLabel("Title");												// Create label
		userLabel2.setBounds(20, 60, 195, 14);
		jFrameMember.getContentPane().add(userLabel2);			
		
		JTextField jTextField2 = new JTextField();															// Text field to enter the name
		jTextField2.setBounds(145, 60, 188, 20);
		jFrameMember.getContentPane().add(jTextField2);
		jTextField2.setColumns(10);
		
		JLabel userLabel3 = new JLabel("Author");												// Create label
		userLabel3.setBounds(20, 90, 195, 14);
		jFrameMember.getContentPane().add(userLabel3);			
		
		JTextField jTextField3 = new JTextField();															// Text field to enter the name
		jTextField3.setBounds(145, 90, 188, 20);
		jFrameMember.getContentPane().add(jTextField3);
		jTextField3.setColumns(10);
		
		
		JLabel userLabel4 = new JLabel("Subject");												// Create label
		userLabel4.setBounds(20, 120, 195, 14);
		jFrameMember.getContentPane().add(userLabel4);			
		
		JTextField jTextField4 = new JTextField();															// Text field to enter the name
		jTextField4.setBounds(145, 120, 188, 20);
		jFrameMember.getContentPane().add(jTextField4);
		jTextField4.setColumns(10);
		
		JLabel userLabel5 = new JLabel("Language");												// Create label
		userLabel5.setBounds(20, 150, 195, 14);
		jFrameMember.getContentPane().add(userLabel5);			
		
		JTextField jTextField5 = new JTextField();															// Text field to enter the name
		jTextField5.setBounds(145, 150, 188, 20);
		jFrameMember.getContentPane().add(jTextField5);
		jTextField5.setColumns(10);
		
		JLabel userLabel6 = new JLabel("Bind");												// Create label
		userLabel6.setBounds(20, 180, 195, 14);
		jFrameMember.getContentPane().add(userLabel6);			
		
		JTextField jTextField6 = new JTextField();															// Text field to enter the name
		jTextField6.setBounds(145, 180, 188, 20);
		jFrameMember.getContentPane().add(jTextField6);
		jTextField6.setColumns(10);
		
		JLabel userLabel7 = new JLabel("Edition");												// Create label
		userLabel7.setBounds(20, 210, 195, 14);
		jFrameMember.getContentPane().add(userLabel7);			
				
		JTextField jTextField7 = new JTextField();															// Text field to enter the name
		jTextField7.setBounds(145, 210, 188, 20);
		jFrameMember.getContentPane().add(jTextField7);
		jTextField7.setColumns(10);
		
		JButton jButtonSend = new JButton("Save");												//Button for Exit functionality
		jButtonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				BookDao.save(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), jTextField4.getText(), jTextField5.getText(), jTextField6.getText(), jTextField7.getText());	
			}
		});
		jButtonSend.setBounds(200, 290, 89, 23);
		jFrameMember.getContentPane().add(jButtonSend);
	
		JButton jButtonInLibrary = new JButton("InLibrary");												//Button for Exit functionality
		jButtonInLibrary.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InLibraryBookWindow.constructWindow();
			}
		});
		jButtonInLibrary.setBounds(330, 130, 89, 23);
		jFrameMember.getContentPane().add(jButtonInLibrary);
		
		JButton jButtonneeded= new JButton("Needed?");												//Button for Exit functionality
		jButtonneeded.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NeededBookWindow.constructWindow();
			}
		});
		jButtonneeded.setBounds(330, 180, 89, 23);
		jFrameMember.getContentPane().add(jButtonneeded);
	}
}
