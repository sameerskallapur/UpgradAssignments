package com.example.service;

import com.example.entity.EmailDetails;

public interface EmailService {
	// Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);
}
