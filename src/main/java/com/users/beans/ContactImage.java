package com.users.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.util.Base64Utils;
@Entity
@Table(name = "contact_images")
public class ContactImage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(unique = true)
	private long userId;

	private String contentType;
	@Column(unique = true)
	private long contactId;

	@Lob
	private byte[] image;

	
	public ContactImage(long id, String contentType, byte[] image) {
		this.id = id;
		this.contentType = contentType;
		this.image = image;
	}
	
	

	public ContactImage(String contentType, long contactId, byte[] image) {
		super();
		this.contentType = contentType;
		this.contactId = contactId;
		this.image = image;
	}



	public ContactImage(long contactId) {
		super();
		this.contactId = contactId;
	}



	protected ContactImage(long id, long userId, String contentType, long contactId, byte[] image) {
		super();
		this.id = id;
		this.userId = userId;
		this.contentType = contentType;
		this.contactId = contactId;
		this.image = image;
	}



	@Override
	public String toString() {
			return "Contact [contactId=" + contactId + ", contentType=" + contentType +"]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}


	public long isContactId() {
		return contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public String getHtmlSrc() {
		return "data:" + this.contentType + ";base64," + Base64Utils.encodeToString(image);
	}
	
}


