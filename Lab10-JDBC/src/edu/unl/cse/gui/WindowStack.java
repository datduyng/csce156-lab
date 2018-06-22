package edu.unl.cse.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public abstract class WindowStack {
	static private Stack<JFrame> stack = new Stack<JFrame>();

	static public JFrame pop()
	{
		return stack.pop();
	}

	static public void push(JFrame f)
	{
		stack.push(f);
	}

	static public JFrame peek()
	{
		return stack.peek();
	}

	static public void showError(JFrame f)
	{
		JOptionPane.showMessageDialog(f, "That window has been disabled by a newer one. Close the new one to access older windows.", "Oops", JOptionPane.PLAIN_MESSAGE);
	}

	static public void addListener(final JFrame f)
	{
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f. addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				f.dispose();
				pop();
			}
		} );
	}
}
