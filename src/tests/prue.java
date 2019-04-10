package tests;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class prue extends JFrame implements ActionListener{
	public JButton jb;
	public JDialog jp;
	public prue() {
		setVisible(true);
		jb = new JButton("nuevo");
		jb.addActionListener(this);
		
		add(jb);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		jp = new JDialog(this, false);
		jp.setModal(true);
		jp.setVisible(true);
	}
}
