package numbleTracking.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import numbleTracking.entity.DailyHit;
import numbleTracking.entity.ViewCount;
import numbleTracking.repository.ViewCountRepository;
import numbleTracking.repository.DailyHitRepository;

@Service
public class TrackingService {

    @Autowired
    private DailyHitRepository dailyhitRepository;

    @Autowired
    private ViewCountRepository viewcountRepository;
    
    //일일 조회수 관련 기능
    public void increaseHitCount(ViewCount viewcount) {
        if (viewcount != null) {
            Long currentViewCount = viewcount.getDailyHit();

            // 조회수를 1 증가시킴
            viewcount.setDailyHit(currentViewCount + 1);

            try {
                // 증가된 조회수를 업데이트
                viewcountRepository.save(viewcount);
                
                //dailyHit 엔티티를 생성하고 저장
                DailyHit dailyHitCnt = new DailyHit();
                
                dailyHitCnt.setViewCount(viewcount);
                dailyHitCnt.setDailyHit(1L);
                dailyHitCnt.setHitDate(new Date());
                
                //dailyHit 저장
                dailyhitRepository.save(dailyHitCnt);
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


