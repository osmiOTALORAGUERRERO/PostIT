package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Note {
	
	private String title;
	private String note;
	private String path = null;
	
	public Note() {
		
	}
	
	public Note(String title, String note, String path) {
		this.title = title;
		this.note = note;
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public void delete() {
		
	}
	
	public boolean save() {
		boolean state = false;
		try {
			File f;
			BufferedWriter bw;
			if(this.path == null) {
				f = new File("/src/persistenceFiles/"+this.title);
				f.createNewFile();
				
			}else {
				f = new File(this.path);
			}
			bw = new BufferedWriter(new FileWriter(f));
			bw.write("Title: "+ this.title+"\n");
			bw.write("Note: "+this.note+"\n");
			bw.close();
			state = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return state;
	}
}
