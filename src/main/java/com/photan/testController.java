package com.photan;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("sam")
	public String hii() {
		return "hello THEREEE IT MEEE sammm";
		
	}
	@PreAuthorize("hasRole('USER')")
@GetMapping("sam2")
	public Integer mam() {
		return 785496;
		
	}
	@GetMapping("/api/data")
  public String configer() {
	return "csrf not autorizeddd";
	
}
}
