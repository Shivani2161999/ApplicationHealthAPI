package com.tiaa.ApplicationHealth.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class SystemService {
	
	public System getRealTime() throws IOException {
		ObjectMapper objectMapper=new ObjectMapper();
	
		//InputStream inStream = TypeReference.class.getResourceAsStream("C:\\Users\\Dell\\Desktop\\SpringProjects\\ApplicationHealthAPI\\src\\main\\resources\\realtimeSystemData.json");
		
	
			System realtimeData=objectMapper.readValue(new FileInputStream("C:\\Users\\Dell\\Desktop\\SpringProjects\\ApplicationHealthAPI\\src\\main\\resources\\realtimeSystemData.json"), System.class);
			return realtimeData;
		
	}
	
	public System postRealTime(System realtimeData) {
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			objectMapper.writeValue(new File("C:\\\\Users\\\\Dell\\\\Desktop\\\\SpringProjects\\\\ApplicationHealthAPI\\\\src\\\\main\\\\resources\\\\realtimeSystemData.json"),realtimeData);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return realtimeData;
	}
}
