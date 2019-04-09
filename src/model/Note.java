package model;

public class Note {
	
	private String title;
	private String note;
	private String path;
	
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
	
	public void saveNote() {
		
	}
}
