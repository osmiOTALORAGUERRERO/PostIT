package views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NoteGUI extends JPanel{
	
	public JTextField jtfTitle;
	public JTextArea jtaNote;
	public JButton jbSave;
	
	public NoteGUI() {

		setBackground(new Color(34,34,34));
		setVisible(true);
		setLayout(new GridBagLayout());
		
		this.jtfTitle = new JTextField("Your Title", 20);
		
		jtaNote = new JTextArea("Your note", 10, 20);
		JScrollPane scrollNote = new JScrollPane(this.jtaNote);
		
		jbSave = new JButton("save");
		
		GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;
        add(this.jtfTitle, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollNote, c);
		add(jbSave, c);
	}
}
