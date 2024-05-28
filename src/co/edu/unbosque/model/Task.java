package co.edu.unbosque.model;

import java.util.Date;

public class Task {
	 
	    private String Title;
	    private String Description;
	    private String State;
	    private Date CreationDate;
	    private Date DueDate;

	    public Task( String Title, String Description,String State, Date CreationDate, Date DueDate) {
	       
	        this.Title = Title;
	        this.Description = Description;
	        this.State = State;
	        this.CreationDate = CreationDate;
	        this.DueDate = DueDate;
	    }

	

	    public String getTitle() {
	        return Title;
	    }

	    public void setTitle(String title) {
	        Title = title;
	    }

	    public String getDescription() {
	        return Description;
	    }

	    public void setDescription(String description) {
	        Description = description;
	    }

	    public String isState() {
	        return State;
	    }

	    public void setState(String state) {
	        State = state;
	    }

	    public Date getCreationDate() {
	        return CreationDate;
	    }

	    public void setCreationDate(Date creationDate) {
	        CreationDate = creationDate;
	    }

	    public Date getDueDate() {
	        return DueDate;
	    }

	    public void setDueDate(Date dueDate) {
	        DueDate = dueDate;
	    }

	    @Override
	    public String toString() {
	        return "Task [, Title=" + Title + ", Description=" + Description + ", State=" + State
	                + ", CreationDate=" + CreationDate + ", DueDate=" + DueDate + "]";
	    }
}
