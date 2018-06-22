package edu.unl.cse.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.*;

import edu.unl.cse.sql.AlbumAdder;

public class AddAlbumFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private JPanel panel;
	
	private JLabel title, band, year, number;
	private JTextField titleField, bandField, yearField, numberField;
	private JButton submit;
	
	public AddAlbumFrame(TableModel model)
	{
		this.setLocationByPlatform(true);
		WindowStack.addListener(this);
		this.model = (DefaultTableModel) model;
		
		this.setTitle("Add an Album");
		
		this.setLayout(new GridLayout(2,1));
		
		this.panel = new JPanel(new GridLayout(5, 2));
		
		this.title = new JLabel("Title: ", JLabel.RIGHT);
		this.band = new JLabel("Band Name: ", JLabel.RIGHT);
		this.year = new JLabel("Year of Release: ", JLabel.RIGHT);
		this.number = new JLabel("Album Number", JLabel.RIGHT);
		
		this.titleField = new JTextField(36);
		this.bandField = new JTextField(36);
		this.yearField = new JTextField(36);
		this.numberField = new JTextField(36);
		
		this.panel.add(this.title);
		this.panel.add(this.titleField);
		this.panel.add(this.band);
		this.panel.add(this.bandField);
		this.panel.add(this.year);
		this.panel.add(this.yearField);
		this.panel.add(this.number);
		this.panel.add(this.numberField);
		
		this.add(this.panel);
		
		this.submit = new JButton("Submit");
		this.submit.setActionCommand("Submit");
		this.submit.addActionListener(new ButtonListener());
		this.submit.setPreferredSize(new Dimension(80, 30));
		
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.add(this.submit);
		
		this.add(buttonPanel);
	}
	
	public void submitAlbum()
	{	
		AlbumAdder aa = new AlbumAdder(this.titleField.getText(), this.bandField.getText(), this.yearField.getText(), this.numberField.getText());
		aa.AddAlbumToDatabase();
		this.model.addRow(new String[] {this.titleField.getText(), this.bandField.getText(), this.yearField.getText(), this.numberField.getText()});
		WindowStack.pop();
		this.dispose();
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String command = e.getActionCommand();
			
			if (command.equals("Submit"))
			{
				submitAlbum();
			}
		}
	}
	
}
