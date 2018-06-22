package edu.unl.cse.gui;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import java.util.ArrayList;
import java.util.Vector;

import edu.unl.cse.model.*;
import edu.unl.cse.sql.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddBandFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Band band;
	private JTextField nameTextField;
	private DefaultTableModel model;
	private JFrame rootFrame = this;
	
	private	JPanel		topPanel;
	private	JTable		table;
	private	JScrollPane scrollPane;
	
	private JPanel 		namePanel;
	private JButton     addButton;
	private JButton     removeButton;
	private	String		columnNames[] = {"First Name", "Last Name", "Country"};
	
	public AddBandFrame(Band b)
	{
		WindowStack.addListener(this);
		
		this.setLocationByPlatform(true);
		
		this.band = b;
		
		this.topPanel = new JPanel(new BorderLayout());
		this.getContentPane().add(topPanel);
		
		this.setTitle("Add Band Information");
		JLabel labelForBandNameLiteral = new JLabel("Band Name: ");
		JLabel bandName;
		this.namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		this.namePanel.add(labelForBandNameLiteral);
		
		if (this.band == null)
		{
			this.nameTextField = new JTextField(36);
			this.namePanel.add(this.nameTextField);
		}
		else
		{
			bandName = new JLabel(this.band.getName(), JLabel.LEFT);
			this.namePanel.add(bandName);
		}
		
		this.topPanel.add(this.namePanel, BorderLayout.NORTH);
		
		this.model = new DefaultTableModel();
		this.table = new JTable(this.model); // {
//			public boolean isCellEditable(int row, int column) {
//				return false;       implement for student lab
//			}
//		};
		
		for (String column: this.columnNames)
		{
			model.addColumn(column);
		}
		
		this.loadData();
		
		this.table.setShowHorizontalLines( false );
		this.table.setRowSelectionAllowed( true );
		this.table.setAutoCreateRowSorter(true);
		
		this.scrollPane = new JScrollPane(table);
		this.topPanel.add(this.scrollPane, BorderLayout.CENTER);
		this.addButton = new JButton("Add Member");
		this.addButton.setActionCommand("Add Member");
		this.addButton.addActionListener(new ButtonListener());
		this.removeButton = new JButton("Remove Member");
		this.removeButton.setActionCommand("Remove Member");
		this.removeButton.addActionListener(new ButtonListener());
		JButton submitButton = new JButton("Submit");
		submitButton.setActionCommand("Submit");
		submitButton.addActionListener(new ButtonListener());
		
		JPanel buttonPanel = new JPanel(new GridLayout(1,3));
		buttonPanel.add(this.removeButton);
		buttonPanel.add(this.addButton);
		buttonPanel.add(submitButton);
		
		this.topPanel.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	private void loadData()
	{
		for (Member m: this.band.getMembers())
		{
			this.model.addRow(new String[] {m.getFirstName(), m.getLastName(), m.getCountry()});
		}
	}
	
	private void addMember()
	{
		this.model.addRow(new String[] {"", "", ""});
		int count = this.table.getRowCount();
		this.table.setRowSelectionInterval(count - 1, count - 1);
	}
	
	private void removeMember()
	{
		int selectedRowIndex = this.table.getSelectedRow();

		this.model.removeRow(selectedRowIndex);
	}
	
	private void finalizeBand()
	{
		Vector<Vector<String>> data = (Vector<Vector<String>>) this.model.getDataVector();
		ArrayList<Member> members = new ArrayList<Member>();
		for(Vector<String> vec: data)
		{
			members.add(new Member(vec.get(0), vec.get(1), vec.get(2)));
		}
		this.band.setMembers(members);
		BandAdder bb = new BandAdder(this.band.getBandId(), this.band.getName(), this.band.getMembers());
		bb.addBandToDatabase();
		WindowStack.pop();
		this.dispose();
	}

	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (rootFrame != WindowStack.peek())
			{
				WindowStack.showError(rootFrame);
				return;
			}
			
			String command = e.getActionCommand();
			
			if (command.equals("Add Member"))
			{
				addMember();
			}
			else if (command.equals("Remove Member"))
			{
				removeMember();
			}
			else if (command.equals("Submit"))
			{
				finalizeBand();
			}
		}
	}
}
