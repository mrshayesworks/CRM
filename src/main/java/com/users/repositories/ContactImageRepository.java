package com.users.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.users.beans.ContactImage;
import com.users.beans.UserImage;

public interface ContactImageRepository extends CrudRepository<ContactImage, Long> {

	List<ContactImage> findByContactId(long contactId);
}