package com.tiaa.ApplicationHealth.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class SystemService {
	
	public System getRealTime(){
		ObjectMapper objectMapper=new ObjectMapper();		
		InputStream inStream=null;
		try {
			inStream = new FileInputStream(new File("C:\\Users\\Dell\\Desktop\\SpringProjects\\ApplicationHealthAPI\\src\\\\main\\resources\\realtimeSystemData.json"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TypeReference<System> typeReference=new TypeReference<System>() {};
		System realtimeData=null;
		try {
			realtimeData = objectMapper.readValue(inStream, typeReference);
			inStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return realtimeData;	
	}
	
	public System postRealTime(System realtimeData) {
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			objectMapper.writeValue(new File("C:\\Users\\Dell\\Desktop\\SpringProjects\\ApplicationHealthAPI\\src\\main\\resources\\realtimeSystemData.json"),realtimeData);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return realtimeData;
	}
}
