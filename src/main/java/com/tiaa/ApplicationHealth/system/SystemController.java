package com.tiaa.ApplicationHealth.system;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemController {
	private final SystemService systemService;
	
	
	public SystemController(SystemService systemService) {
		this.systemService = systemService;
	}

	@GetMapping("/realtime")
	public System getRealTime() throws Exception {
		return systemService.getRealTime();
	}
	
	@PostMapping("/realtime")
	public ResponseEntity<?> postRealTime(@RequestBody System realtimeData) {
		System realtimeData1=systemService.postRealTime(realtimeData);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
