package views;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NoteGUI extends JDialog{
	
	public JTextField jtfTitle;
	public JTextArea jtaNote;
	public JButton jbSave;
	public JButton jbDelete;

	public NoteGUI(Frame frame) {
		super(frame, false);
		setBackground(new Color(34,34,34));
		setLayout(new GridBagLayout());
		
		this.jtfTitle = new JTextField("Your Title", 20);
		
		jtaNote = new JTextArea("Your note", 10, 20);
		JScrollPane scrollNote = new JScrollPane(this.jtaNote);
		
		jbSave = new JButton("save");
		jbDelete = new JButton("delete");
		
		GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        c.fill = GridBagConstraints.HORIZONTAL;
        add(this.jtfTitle, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollNote, c);
		add(jbSave, c);
		add(jbDelete, c);
	}
	public void closeWindow() {
		this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}
}
