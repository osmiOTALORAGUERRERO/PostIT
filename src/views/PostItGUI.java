package views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

public class PostItGUI extends JFrame{
	
	public JLabel title;
	public JScrollPane jspNotes;
	public JButton jbNewNote;
	public JPanel panelHeader;
	public JPanel panelBody;
	public ArrayList<JButton> jbNotes;
	
	
	public PostItGUI() {
		setTitle("Post It");
		setLayout(new BorderLayout(2,2));
		setSize(250, 500);
		setMinimumSize(new Dimension(100,250));
		componentesInit();
	}
	
	public void componentesInit() {
		panelHeader();
		panelBody();
	}
	
	public void panelHeader() {
		panelHeader = new JPanel();
		panelHeader.setLayout(new GridLayout(1,2));
		title = new JLabel("Your Notes");
		jbNewNote = new JButton("+");
		
		panelHeader.add(title);
		panelHeader.add(jbNewNote);
		
		add(panelHeader, BorderLayout.NORTH);
	}
	
	public void panelBody() {
		
		panelBody = new JPanel();
		panelBody.setLayout(new GridLayout(0,1,2,2));
		//panelBody.setPreferredSize(new Dimension(250,500));
		
		jspNotes = new JScrollPane(panelBody);
		jspNotes.setBounds(0,0,100,250);
		jspNotes.setViewportView(panelBody);
		jbNotes = new ArrayList<JButton>();
		
		add(jspNotes);
	}
	
	public void addButtonNote(String name) {
		JButton button = new JButton(name);
		button.setPreferredSize(new Dimension(100, 20));
		button.setMaximumSize(new Dimension(100, 20));
		jbNotes.add(button);
		panelBody.add(button);
		panelBody.updateUI();
	}

}
