package com.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;


public class LibrarySystem {
	static Map valueList= new HashMap<>();
	private JFrame jFrame;
	private void constructWindow(String clientWindow) {
		jFrame = new JFrame(clientWindow);															// create a frame.
		jFrame.setBounds(500, 0, 490, 490);
		jFrame.getContentPane().setLayout(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);									// Client will close the Frame and counting
		
		JButton jButtonMember = new JButton("Add Member");										// Button to Send the Username to Server
		jButtonMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberWindow.constructWindow();
			}
		});
		jButtonMember.setBounds(50, 31, 89, 35);
		jFrame.getContentPane().add(jButtonMember);
		
		JButton jButtonStaff = new JButton("Add Staff");										// Button to Send the Username to Server
		jButtonStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffWindow.constructWindow();
			}
		});
		jButtonStaff.setBounds(150, 31, 89, 35);
		jFrame.getContentPane().add(jButtonStaff);
		
		
		JButton jButtonBook = new JButton("Add Book");										// Button to Send the Username to Server
		jButtonBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookWindow.constructWindow();
			}
		});
		jButtonBook.setBounds(250, 31, 89, 35);
		jFrame.getContentPane().add(jButtonBook);

		JButton jButtonLoan = new JButton("Loan Book");										// Button to Send the Username to Server
		jButtonLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IssueBookWindow();
				IssueBookWindow.constructWindow();
			}
		});
		jButtonLoan.setBounds(350, 31, 89, 35);
		jFrame.getContentPane().add(jButtonLoan);
		
		JButton jButtonViewMember = new JButton("View Member");										// Button to Send the Username to Server
		jButtonViewMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMember.constructWindow();
				
			}
		});
		jButtonViewMember.setBounds(50, 81, 89, 35);
		jFrame.getContentPane().add(jButtonViewMember);
		
		
		JButton jButtonViewStaff = new JButton("View Staff");										// Button to Send the Username to Server
		jButtonViewStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewStaff.constructWindow();
			}
		});
		jButtonViewStaff.setBounds(150, 81, 89, 35);
		jFrame.getContentPane().add(jButtonViewStaff);

		JButton jButtonViewBook = new JButton("View Book");										// Button to Send the Username to Server
		jButtonViewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBook.constructWindow();
			}
		});
		jButtonViewBook.setBounds(250, 81, 89, 35);
		jFrame.getContentPane().add(jButtonViewBook);
		
		
		JButton jButtonViewLoan = new JButton("View Loan");										// Button to Send the Username to Server
		jButtonViewLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewIssueBook.constructWindow();
			}
		});
		jButtonViewLoan.setBounds(350, 81, 89, 35);
		jFrame.getContentPane().add(jButtonViewLoan);
		
		JButton jButtonReturnBook = new JButton("Return Book");										// Button to Send the Username to Server
		jButtonReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBookWindow.constructWindow();
				
			}
		});
		jButtonReturnBook.setBounds(50, 131, 89, 35);
		jFrame.getContentPane().add(jButtonReturnBook);
		
		JButton jButtonRenewBook = new JButton("Renew Member");										// Button to Send the Username to Server
		jButtonRenewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RenewMemberShipWindow.constructWindow();
				
			}
		});
		jButtonRenewBook.setBounds(150, 131, 89, 35);
		jFrame.getContentPane().add(jButtonRenewBook);
		
		
		JButton jButtonWeeklyReport = new JButton("Borrowing Report");										// Button to Send the Username to Server
		jButtonWeeklyReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WeeklyReportGetDatesWindow.constructWindow();
				
			}
		});
		jButtonWeeklyReport.setBounds(250, 131, 89, 35);
		jFrame.getContentPane().add(jButtonWeeklyReport);
		
		JButton jButtonExit = new JButton("Exit");												//Button for Exit functionality
		jButtonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		jButtonExit.setBounds(200, 440, 89, 35);
		jFrame.getContentPane().add(jButtonExit);
		jFrame.setVisible(true);
	}

	public static void main(String[] args) {
		LibrarySystem ls= new LibrarySystem();
		valueList=ValueListDao.fetchAll();
		ls.constructWindow("Library Management System");
	}
}
