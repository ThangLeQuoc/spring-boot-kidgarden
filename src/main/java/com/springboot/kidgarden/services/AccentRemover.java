package com.springboot.kidgarden.services;

import java.text.Normalizer;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import java.lang.*;

@Service
public class AccentRemover {
	private String inputString;
	
	public AccentRemover(){
		
	}
	
	public void setString(String inputString){
		this.inputString = inputString;
	}
	public String getCovertedString(){
		String converted = Normalizer.normalize(inputString, Normalizer.Form.NFD );
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(converted).replaceAll("").replaceAll("Đ","D").replaceAll("đ", "d").replaceAll("\\s+", "").toLowerCase();
	}
	
	
}
