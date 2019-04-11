package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Note;
import views.NoteGUI;
import views.PostItGUI;

public class PostIt implements ActionListener{
	
	public ArrayList<Note> notes;
	public PostItGUI postItGUI;
	public File directory = new File("src/persistenceFiles"); 
	public ArrayList<File> fileNotes;
	
	public PostIt(PostItGUI postItGUI) {
		this.postItGUI = postItGUI;
		loadSavedNotes();
		startGUI();
	}
	
	private void loadSavedNotes() {
		fileNotes = new ArrayList<File>();
		notes = new ArrayList<Note>();
		if(this.directory.exists()) {
			File[] dirNotes = directory.listFiles();
			for(int i=0; i<dirNotes.length; i++) {
				this.fileNotes.add(dirNotes[i]);
			}
		}
		
		for(int i=0; i<fileNotes.size(); i++) {
			String title = titleParser(fileNotes.get(i));
			String note = noteParser(fileNotes.get(i));
			String path = fileNotes.get(i).getPath();
			notes.add(new Note(title, note, path));
		}
	}
	
	private String titleParser(File file) {
		String title = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			title = br.readLine();
			title = title.replaceFirst("Title: ", "");
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return title;
	}
	
	private String noteParser(File file) {
		String note = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			br.readLine();
			String text = br.readLine();
			while(text != null) {
				note += text+"\n";
				text = br.readLine();
			}
			note = note.replaceFirst("Note: ", "");
			br.close();
			note = note.replaceFirst("Title: ", "");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return note;
	}
	
	private void startGUI() {
		this.postItGUI.setVisible(true);
		this.postItGUI.setResizable(true);
		this.postItGUI.setLocationRelativeTo(null);
		this.postItGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.postItGUI.jbNewNote.addActionListener(this);
		for(int i=0; i<notes.size(); i++) {
			this.postItGUI.addButtonNote(notes.get(i).getTitle());
		}
		for(int i=0; i<notes.size(); i++) {
			this.postItGUI.jbNotes.get(i).addActionListener(this);
			
		}
	}
	
	public void newNote() {
		this.postItGUI.openNewNote();
		this.postItGUI.guiNewNotes.get(this.postItGUI.guiNewNotes.size()-1).jbSave.addActionListener(this);
		this.postItGUI.guiNewNotes.get(this.postItGUI.guiNewNotes.size()-1).jbDelete.addActionListener(this);
	}
	
	public void openNote(int i) {
		this.postItGUI.guiNotes.get(i).jtfTitle.setText(this.notes.get(i).getTitle());
		this.postItGUI.guiNotes.get(i).jtaNote.setText(this.notes.get(i).getNote());
		this.postItGUI.guiNotes.get(i).jbSave.addActionListener(this);
		this.postItGUI.guiNotes.get(i).jbDelete.addActionListener(this);
		this.postItGUI.guiNotes.get(i).setLocationRelativeTo(null);
		this.postItGUI.guiNotes.get(i).pack();
		this.postItGUI.guiNotes.get(i).setVisible(true);
	}
	
	public void saveNote(NoteGUI noteGui, int i) {
		this.notes.get(i).setTitle(noteGui.jtfTitle.getText());
		this.notes.get(i).setNote(noteGui.jtaNote.getText());
		if(!this.notes.get(i).save()) {
			JOptionPane.showMessageDialog(noteGui, "Error saving the note, try again", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void deleteNote(int i) {
		if(this.notes.get(i).delete()) {
			this.postItGUI.guiNotes.get(i).closeWindow();
			this.postItGUI.guiNotes.remove(i);
			this.postItGUI.panelBody.remove(this.postItGUI.jbNotes.get(i));
			this.postItGUI.jbNotes.remove(i);
			this.postItGUI.panelBody.updateUI();
			this.notes.remove(i);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.postItGUI.jbNewNote) {
			newNote();
		}else
		{
			for(int i=0; i<notes.size(); i++) {
				if(e.getSource() == this.postItGUI.jbNotes.get(i)) {
					openNote(i);
					return;
				}
			}
			for(int i=0; i<this.postItGUI.guiNewNotes.size(); i++) {
				if(e.getSource() == this.postItGUI.guiNewNotes.get(i).jbSave) {
					Note note = new Note();
					this.notes.add(note);
					saveNote(this.postItGUI.guiNewNotes.get(i), this.notes.indexOf(note));
					this.postItGUI.addButtonNote(this.postItGUI.guiNewNotes.remove(i));
					this.postItGUI.jbNotes.get(this.notes.indexOf(note)).addActionListener(this);
					return;
				}
			}
			for(int i=0; i<this.postItGUI.guiNotes.size(); i++) {
				if(e.getSource() == this.postItGUI.guiNotes.get(i).jbSave) {
					saveNote(this.postItGUI.guiNotes.get(i), i);
					return;
				}
			}
			for(int i=0; i<this.postItGUI.guiNewNotes.size(); i++) {
				if(e.getSource() == this.postItGUI.guiNewNotes.get(i).jbDelete) {
					JOptionPane.showMessageDialog(this.postItGUI.guiNewNotes.get(i), "Note not saved", "Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
			for(int i=0; i<this.postItGUI.guiNotes.size(); i++) {
				if(e.getSource() == this.postItGUI.guiNotes.get(i).jbDelete) {
					int confirmation = JOptionPane.showConfirmDialog(this.postItGUI.guiNotes.get(i), "Are you sure?", "Confirmation message", JOptionPane.YES_NO_OPTION);
					if(confirmation == JOptionPane.YES_OPTION) {
						System.out.println(i);
						System.out.println(this.notes.size());
						System.out.println(this.notes.get(i).getTitle());
						deleteNote(i);
					}
					return;
				}
			}
		}
		
	}
	
}
