package numbleTracking.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import numbleTracking.entity.dailyHit;
import numbleTracking.entity.viewCount;
import numbleTracking.repository.dailyHitRepository;
import numbleTracking.repository.viewCountRepository;

@Service
public class trackingService {
	
	
	@Autowired
	private dailyHitRepository dailyhitRepository;
	
	@Autowired
	private viewCountRepository viewcountRepository;
	
	

	public void increaseHitCount(viewCount viewcount) {
	Long currentViewCount = viewcount.getDailyHit();
	
	//조회수를 1 증가시킴
	viewcount.setDailyHit(currentViewCount + 1);
	
	//증가된 조회수를 업데이트
	viewcountRepository.save(viewcount);
	}



	public viewCount getHitById(Long id) {
		viewCount viewcount = viewcountRepository.getHitById(id);
		return null;
	}
	


	
	
}

