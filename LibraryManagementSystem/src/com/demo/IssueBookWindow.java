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

public class IssueBookWindow {
	private static int DUE_PERIOD;
	private static int GRACE_PERIOD;
	private static int CHECK_OUT_PERIOD;
	private static int MAXBOOK;
	private static int PROF_CHECK_OUT_PERIOD;
	private static int PROF_DUE_PERIOD;
	private static int PROF_GRACE_PERIOD;
	
	public static void constructWindow() {

		Map<String, Integer> valueList=ValueListDao.fetchAll();
		DUE_PERIOD=valueList.get("due_period");
		GRACE_PERIOD=valueList.get("grace_period");
		CHECK_OUT_PERIOD=valueList.get("check_out_period");
		MAXBOOK=valueList.get("max_books");
		PROF_CHECK_OUT_PERIOD=valueList.get("prof_check_out_period");
		PROF_DUE_PERIOD=valueList.get("prof_due_period");
		PROF_GRACE_PERIOD=valueList.get("prof_grace_period");
//		
		
		JFrame jFrameMember = new JFrame("Issue Book");															// create a frame.
		jFrameMember.setBounds(500, 0, 490, 490);
		jFrameMember.getContentPane().setLayout(null);
		jFrameMember.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);				
		jFrameMember.setVisible(true);
		
		JLabel userLabel1 = new JLabel("IssueId");												// Create label
		userLabel1.setBounds(20, 30, 195, 14);
		jFrameMember.getContentPane().add(userLabel1);			
		
		JTextField jTextField1 = new JTextField();															// Text field to enter the name
		jTextField1.setBounds(195, 30, 188, 20);
		jFrameMember.getContentPane().add(jTextField1);
		jTextField1.setColumns(10);
		
		JLabel userLabel2 = new JLabel("Member SSN");												// Create label
		userLabel2.setBounds(20, 60, 195, 14);
		jFrameMember.getContentPane().add(userLabel2);			
		
		List<String> rsMemberDaoList= new ArrayList<String>();
		rsMemberDaoList=MemberDao.getAllMemberId();		
		String[] MemberStrings = Arrays.copyOf(rsMemberDaoList.toArray(), rsMemberDaoList.toString().length(), String[].class);
		JComboBox jMemberListComboBox = new JComboBox(MemberStrings);
		jMemberListComboBox.setBounds(195, 60, 188, 20);
		jFrameMember.getContentPane().add(jMemberListComboBox);
		
		JLabel userLabel3 = new JLabel("Staff SSN");												// Create label
		userLabel3.setBounds(20, 90, 195, 14);
		jFrameMember.getContentPane().add(userLabel3);			
				
		List<String> rsStaffDaoList= new ArrayList<String>();
		rsStaffDaoList=StaffDao.getAllStaddId();		
		String[] StaffStrings = Arrays.copyOf(rsStaffDaoList.toArray(), rsStaffDaoList.toString().length(), String[].class);
		JComboBox jStaffListComboBox = new JComboBox(StaffStrings);
		jStaffListComboBox.setBounds(195, 90, 188, 20);
		jFrameMember.getContentPane().add(jStaffListComboBox);
		
		JLabel userLabel7 = new JLabel("Book ISBN");												// Create label
		userLabel7.setBounds(20, 120, 195, 14);
		jFrameMember.getContentPane().add(userLabel7);			
				
		List<String> rsBookDaoList= new ArrayList<String>();
		rsBookDaoList=BookDao.getAllISBN();		
		String[] ISBNStrings = Arrays.copyOf(rsBookDaoList.toArray(), rsBookDaoList.toString().length(), String[].class);
		JComboBox jISBNListComboBox = new JComboBox(ISBNStrings);
		jISBNListComboBox.setBounds(195, 120, 195, 14);
		jFrameMember.getContentPane().add(jISBNListComboBox);
		
		
		JLabel userLabelDate = new JLabel("Issuing Date(YYYYmmdd)");												// Create label
		userLabelDate.setBounds(20, 150, 195, 14);
		jFrameMember.getContentPane().add(userLabelDate);			
		
		JTextField jTextFieldDate = new JTextField();															// Text field to enter the name
		jTextFieldDate.setBounds(195, 150, 188, 20);
		jFrameMember.getContentPane().add(jTextFieldDate);
		jTextFieldDate.setColumns(10);
		
		
		JButton jButtonSend = new JButton("Save");												//Button for Exit functionality
		jButtonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag=MemberDao.isProf((String)jMemberListComboBox.getSelectedItem());
				if(flag=true)
					IssueBookDao.save(jTextField1.getText(), (String)jMemberListComboBox.getSelectedItem(),(String)jStaffListComboBox.getSelectedItem(), (String)jISBNListComboBox.getSelectedItem(), PROF_DUE_PERIOD, PROF_GRACE_PERIOD, PROF_CHECK_OUT_PERIOD, "Rented");	
				else
					IssueBookDao.save(jTextField1.getText(), (String)jMemberListComboBox.getSelectedItem(),(String)jStaffListComboBox.getSelectedItem(), (String)jISBNListComboBox.getSelectedItem(), DUE_PERIOD, GRACE_PERIOD, CHECK_OUT_PERIOD, "Rented");	
			}
		});
		jButtonSend.setBounds(200, 290, 89, 23);
		jFrameMember.getContentPane().add(jButtonSend);
	
	}
}
