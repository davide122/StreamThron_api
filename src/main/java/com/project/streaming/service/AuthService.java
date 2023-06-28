package com.project.streaming.service;

import com.project.streaming.payload.LoginDto;
import com.project.streaming.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
