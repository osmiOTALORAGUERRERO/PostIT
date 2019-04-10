package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PostItGUI extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel panelHeader;
	public JLabel title;
	public JButton jbNewNote;
	public JPanel panelBody;
	public JScrollPane jspNotes;
	public ArrayList<JButton> jbNotes;
	public ArrayList<NoteGUI> guiNotes;
	public ArrayList<NoteGUI> guiNewNotes;
	
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
		guiNewNotes = new ArrayList<NoteGUI>();
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
		guiNotes = new ArrayList<NoteGUI>();
		add(jspNotes);
	}
	
	public void addButtonNote(String name) {
		JButton button = new JButton(name);
		button.setPreferredSize(new Dimension(100, 20));
		button.setMaximumSize(new Dimension(100, 20));
		NoteGUI noteGUI = new NoteGUI(this);
		jbNotes.add(button);
		guiNotes.add(noteGUI);
		panelBody.add(button);
		panelBody.updateUI();
	}
	
	public void addButtonNote(NoteGUI noteGui) {
		JButton button = new JButton(noteGui.jtfTitle.getText());
		button.setPreferredSize(new Dimension(100, 20));
		button.setMaximumSize(new Dimension(100, 20));
		jbNotes.add(button);
		guiNotes.add(noteGui);
		panelBody.add(button);
		panelBody.updateUI();
	}
	
	public void openNewNote() {
		NoteGUI ng = new NoteGUI(this);
		ng.setLocationRelativeTo(null);
		ng.pack();
		ng.setVisible(true);
		guiNewNotes.add(ng);
	}
	
}
