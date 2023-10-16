package numbleTracking.service;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import numbleTracking.entity.ViewCount;
import numbleTracking.repository.ViewCountRepository;
import numbleTracking.repository.dailyHitRepository;

@Service
public class TrackingService {

    @Autowired
    private dailyHitRepository dailyhitRepository;

    @Autowired
    private ViewCountRepository viewcountRepository;
    
    public void increaseHitCount(ViewCount viewcount) {
        if (viewcount != null) {
            Long currentViewCount = viewcount.getDailyHit();

            // 조회수를 1 증가시킴
            viewcount.setDailyHit(currentViewCount + 1);

            try {
                // 증가된 조회수를 업데이트
                viewcountRepository.save(viewcount);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


	public ViewCount getViewCountById(Long id) {
		ViewCount viewcount = viewcountRepository.getViewCountById(id);
		
		return viewcount;
	}
}


