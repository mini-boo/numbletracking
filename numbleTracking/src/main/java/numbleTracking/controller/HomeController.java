package numbleTracking.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import numbleTracking.entity.viewCount;
import numbleTracking.service.trackingService;


@Controller
public class HomeController {
	
	@Autowired
	private trackingService TrackingService;
	
	
	@GetMapping("/home")
	public String viewCounts(@PathVariable Long id, Model model) {
		
		//id 따라 dailyHit, viewcount 가져오기
		viewCount viewcount = TrackingService.getHitById(id);
		
		//url에 접속하면 일일조회수가 1씩 증가
		TrackingService.increaseHitCount(viewcount);
		
		return "index";
	}
}

