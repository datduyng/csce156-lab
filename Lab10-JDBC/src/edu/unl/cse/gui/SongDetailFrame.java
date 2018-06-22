package edu.unl.cse.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.List;
import java.util.Vector;

import edu.unl.cse.model.*;
import edu.unl.cse.sql.*;

public class SongDetailFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Album album;
	private JTable table;
	private JFrame rootFrame = this;
	
	
	public SongDetailFrame(Album a)
	{
		this.album = a;
		this.setupUI();
	}
	
	private void setupUI()
	{
		this.setLocationByPlatform(true);
		
		WindowStack.addListener(this);
		
		this.setTitle("Songs on \"" + this.album.getTitle() +"\"");
		this.setSize(500, 400);
		
		JPanel topPanel = new JPanel(new BorderLayout());
		this.getContentPane().add(topPanel);
		this.table = new JTable(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				if (rootFrame != WindowStack.peek())
				{
					return false;
				}
				return true;
			}
		};;
		
		JLabel albumTitleLabel = new JLabel("Album: " + this.album.getTitle(), JLabel.CENTER),
//				albumTitleLiteral = new JLabel(),
				albumYearLabel = new JLabel("Year: " + this.album.getYear().toString(), JLabel.CENTER),
//				albumYearLiteral = new JLabel(),
				bandLabel = new JLabel("Band: " + this.album.getBand().getName(), JLabel.CENTER);
//				bandLiteral = new JLabel("Band: ");
		JPanel infoPanel = new JPanel(new GridLayout(2, 1));
		JPanel albumPanel = new JPanel(new GridLayout(1, 2));
		
		albumPanel.add(albumTitleLabel);
		albumPanel.add(albumYearLabel);
		infoPanel.add(albumPanel);
		infoPanel.add(bandLabel);
		
		topPanel.add(infoPanel, BorderLayout.NORTH);
		
		DefaultTableModel model = (DefaultTableModel) this.table.getModel();
		model.addColumn("Song Title");
		
		JScrollPane scroll = new JScrollPane(table);
		topPanel.add(scroll, BorderLayout.CENTER);
		this.loadData();
		
		JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
		JButton addSongButton = new JButton("Add Song"),
				removeButton = new JButton("Remove Song"),
				submitButton = new JButton("Submit");
		
		addSongButton.setActionCommand("Add Song");
		removeButton.setActionCommand("Remove Song");
		submitButton.setActionCommand("Submit");
		addSongButton.addActionListener(new ButtonListener());
		removeButton.addActionListener(new ButtonListener());
		submitButton.addActionListener(new ButtonListener());
		
		buttonPanel.add(removeButton);
		buttonPanel.add(addSongButton);
		buttonPanel.add(submitButton);
		topPanel.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	private void loadData()
	{
		SongBean sb = new SongBean(this.album);
		List<String> songs = sb.getSongs();
		DefaultTableModel model = (DefaultTableModel) this.table.getModel();
		
		for (String song: songs)
		{
			model.addRow(new String[] {song});
		}
	}
	
	private int getRowSelection()
	{
		int row = table.getSelectedRow();
		if (row < 0)
		{
			row = 0;
			table.setRowSelectionInterval(0, 0);
		}

		return row;
	}
	
	private void prepareToAddSong()
	{
		((DefaultTableModel) this.table.getModel()).addRow(new String[] {"<Double-click to Edit>"});
		int count = this.table.getRowCount();
		this.table.setRowSelectionInterval(count - 1, count - 1);
	}
	
	private void prepareToRemoveSong()
	{
		((DefaultTableModel) this.table.getModel()).removeRow(this.getRowSelection());
	}
	
	private void prepareToSubmit()
	{
		Vector<Vector<String>> data = (Vector<Vector<String>>) ((DefaultTableModel) this.table.getModel()).getDataVector();
		Vector<String> songs = new Vector<String>();
		for (Vector<String> vec: data)
		{
			songs.add(vec.get(0));
		}
		
		String temp = null;
		for (int i = 1; i < songs.size(); i++)
		{
			if (songs.get(i).equals(songs.get(i - 1)))
			{
				String duplicate = songs.remove(i);
				songs.add(i, duplicate + "(1)"); 
			}
		}
		
		SongAdder sa = new SongAdder(songs, this.album);
		sa.addSongs();
		WindowStack.pop();
		this.dispose();
	}
	
	public class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (rootFrame != WindowStack.peek())
			{
				WindowStack.showError(rootFrame);
				return;
			}
			
			String command = e.getActionCommand();
			
			if (command.equals("Add Song"))
			{
				prepareToAddSong();
			}
			else if (command.equals("Remove Song"))
			{
				prepareToRemoveSong();
			}
			else if (command.equals("Submit"))
			{
				prepareToSubmit();
			}
		}
	}
}
