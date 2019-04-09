package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.Note;
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
			// TODO Auto-generated catch block
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
	}
	
	public void newNote() {
		
	}
	
	public void openNote() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.postItGUI.jbNewNote) {
			newNote();
		}
		
	}
	
}
