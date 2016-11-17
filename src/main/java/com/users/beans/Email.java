package com.users.beans;

public class Email {
 public String to;
 public String subject;
 public String message;
 public String custom;
public Email(String to, String subject, String message, String custom) {
	super();
	this.to = to;
	this.subject = subject;
	this.message = message;
	this.custom = custom;
}
public Email(String custom) {
	super();
	this.custom = custom;
}
public String getTo() {
	return to;
}
public void setTo(String to) {
	this.to = to;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getCustom() {
	return custom;
}
public void setCustom(String custom) {
	this.custom = custom;
}

 
 
}
