package edu.unl.cse.gui;

import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

import edu.unl.cse.model.Album;
import edu.unl.cse.model.Band;
import edu.unl.cse.sql.AlbumAdder;
import edu.unl.cse.sql.AlbumBean;
import edu.unl.cse.sql.BandBean;

public class AlbumTable extends JFrame implements TableModelListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame 		rootFrame = this;
	private	JPanel		topPanel;
	private	JTable		table;
	private	JScrollPane scrollPane;

	private JPanel 		buttonPanel;
	private JButton     addButton;
	private JButton		removeAlbumButton;
	private JButton     showSongsButton;

	private	String		columnNames[] = {"Album Title", "Band Name", "Album Year", "Album Number"};

	public AlbumTable(Band b)
	{
		this.setupUI();
		this.loadAlbums(b);
		this.disableAppropriateButtons();
	}

	public AlbumTable()
	{
		this.setupUI();
		this.loadAlbums(null);
		this.disableAppropriateButtons();
	}

	private void setupUI()
	{
		WindowStack.addListener(this);
		setTitle( "Albums" );
		setSize( 1000, 400 );
		setBackground( Color.gray );
		this.setLocationByPlatform(true);

		topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		this.addButton = new JButton("Add Album");
		this.removeAlbumButton = new JButton("Remove Album");
		this.showSongsButton = new JButton("Show Songs");

		this.addButton.setActionCommand("Add Album");
		this.removeAlbumButton.setActionCommand("Remove Album");
		this.showSongsButton.setActionCommand("Show Songs");
		this.addButton.addActionListener(new ButtonListener());
		this.removeAlbumButton.addActionListener(new ButtonListener());
		this.showSongsButton.addActionListener(new ButtonListener());

		this.buttonPanel = new JPanel();
		this.buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));

		DefaultTableModel model = new DefaultTableModel();
		table = new JTable( model ) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		for (String str: this.columnNames)
		{
			model.addColumn(str);
		}

		this.setupPopupMenu();

		table.setShowHorizontalLines( false );
		table.setRowSelectionAllowed( true );
//		table.setAutoCreateRowSorter(true);
		
		table.setSelectionForeground( Color.white );
		table.setSelectionBackground( Color.blue );

		scrollPane = new JScrollPane( table );
		this.buttonPanel.add(this.addButton);
		this.buttonPanel.add(this.removeAlbumButton);
		this.buttonPanel.add(this.showSongsButton);
		topPanel.add(this.buttonPanel, BorderLayout.NORTH);
		topPanel.add( scrollPane, BorderLayout.CENTER );
		
		model.addTableModelListener(this);
	}
	
	private void disableAppropriateButtons()
	{
		DefaultTableModel model = (DefaultTableModel) this.table.getModel();
		if (model.getRowCount() == 0)
		{
			this.removeAlbumButton.setEnabled(false);
			this.showSongsButton.setEnabled(false);
		}
		else
		{
			this.addButton.setEnabled(true);
			this.removeAlbumButton.setEnabled(true);
			this.showSongsButton.setEnabled(true);
		}
	}

	private void setupPopupMenu()
	{
		JPopupMenu menu = new JPopupMenu();
		JMenuItem editMembersItem = new JMenuItem("View/Edit Band Members");
		JMenuItem showAlbums = new JMenuItem("Show All Albums From Band");
		editMembersItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if (rootFrame != WindowStack.peek())
				{
					WindowStack.showError(rootFrame);
					return;
				}
				
				Band b = getBandFromSelecton();

				JFrame bandFrame = new AddBandFrame(b);
				bandFrame.setSize( 600, 400 );
				bandFrame.setVisible(true);
				WindowStack.push(bandFrame);
			}
		});
		showAlbums.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (rootFrame != WindowStack.peek())
				{
					WindowStack.showError(rootFrame);
					return;
				}
				
				Band b = getBandFromSelecton();
				AlbumTable mainFrame = new AlbumTable(b);
				mainFrame.setVisible( true );
				WindowStack.push(mainFrame);

			}
		});
		menu.add(showAlbums);
		menu.add(editMembersItem);
		table.setComponentPopupMenu(menu);
	}

	private Band getBandFromSelecton()
	{
		int row = this.getRowSelection();
		BandBean bb = new BandBean();
		Band b = bb.getBand((String) table.getModel().getValueAt(row, 1)); 
		return b;
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

	private void loadAlbums(Band b)
	{
		AlbumBean ab = new AlbumBean();
		List<Album> albums = ab.getAlbums();
		DefaultTableModel model = (DefaultTableModel) this.table.getModel();
		if (b == null)
		{
			for (Album a: albums)
			{
				model.addRow(new String[] {a.getTitle(), a.getBand().getName(), a.getYear().toString(), a.getAlbumNumber().toString()});
			}
		}
		else
		{

			String name = b.getName();
			this.setTitle("Albums by \"" + name + "\"");
			for (Album a: albums)
			{
				if (name.equals(a.getBand().getName()))
				{
					model.addRow(new String[] {a.getTitle(), a.getBand().getName(), a.getYear().toString(), a.getAlbumNumber().toString()});
				}
			}
		}
	}

	private void prepareToAddAlbum()
	{
		JFrame albumFrame = new AddAlbumFrame(this.table.getModel());
		albumFrame.setSize(400, 400);
		albumFrame.setVisible(true);
		WindowStack.push(albumFrame);
	}

	private void prepareToRemoveAlbum()
	{
		int row = this.getRowSelection();
		DefaultTableModel model = (DefaultTableModel) this.table.getModel();
		String title = (String) model.getValueAt(row, 0),
				bandName = (String) model.getValueAt(row, 1),
				year = (String) model.getValueAt(row, 2),
				number = (String) model.getValueAt(row, 3);
		AlbumAdder aa = new AlbumAdder(title, bandName, year, number);
		aa.removeAlbumFromDatabase();
		model.removeRow(row);
	}

	private void prepareToShowSongs()
	{
		int row = this.getRowSelection();
		DefaultTableModel model = (DefaultTableModel) this.table.getModel();
		String title = (String) model.getValueAt(row, 0);
		AlbumBean ab = new AlbumBean();
		Album a = ab.getDetailedAlbum(title);

		SongDetailFrame frame = new SongDetailFrame(a);
		frame.setVisible(true);
		WindowStack.push(frame);
	}

	public static void main( String args[] )
	{
		AlbumTable mainFrame	= new AlbumTable();
		mainFrame.setVisible( true );
		WindowStack.push(mainFrame);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

			if (command.equals("Add Album"))
			{
				prepareToAddAlbum();
			}
			else if (command.equals("Remove Album"))
			{
				prepareToRemoveAlbum();
			}
			else if (command.equals("Show Songs"))
			{
				prepareToShowSongs();
			}
		}
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		this.disableAppropriateButtons();
		
	}

}
