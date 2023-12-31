package numbleTracking.controller;

import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import numbleTracking.entity.DailyHit;
import numbleTracking.entity.ViewCount;
import numbleTracking.service.TrackingService;


@Controller
public class HomeController {
	
	@Autowired
	private TrackingService trackingService;
	
	
	@GetMapping("/home/{id}")
	public String viewCounts(@PathVariable Long id, Model model) {
		
	    // id 따라 viewcount 가져오기
	    ViewCount viewcount = trackingService.getViewCountById(id);

	    if (viewcount != null) {
	    
	        // url에 접속하면 일일조회수가 1씩 증가
	        trackingService.increaseHitCount(viewcount);
	        System.out.println("일일 조회수 : " + viewcount.getDailyHit());
			
	        // 누적조회수 출력
	        trackingService.increaseTotalHitCount(viewcount);
	        System.out.println("누적 조회수 : " + viewcount.getTotalHit());
	        
	     // 주간 통계 출력
	        System.out.println("<주간 통계>");
            List<Object[]> counts = trackingService.countAllDailyHits();
            for (Object[] count : counts) {
                Date hitDate = (Date) count[0];
                Long dailyHit = (Long) count[1];
                System.out.println(hitDate + " : " + dailyHit + "회");
            }

	    } else {
	        // 해당 ID에 해당하는 ViewCount를 찾지 못한 경우에 대한 처리
	        System.out.println("ViewCount not found for ID: " + id);
	    }

	    return "index";
	}

}

