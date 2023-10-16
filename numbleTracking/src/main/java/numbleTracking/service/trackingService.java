package numbleTracking.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.apache.jasper.tagplugins.jstl.core.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.dailyView;
import repository.URLRepository;
import repository.dailyToWeeklyMappingRepository;
import repository.dailyViewBackupRepository;
import repository.dailyViewRepository;
import repository.weeklyViewRepository;

@Service
public class trackingService {
	
	@Autowired
	private URLRepository urlRepository;
	
	@Autowired
	private dailyViewRepository dailyviewRepository;
	
	@Autowired
	private weeklyViewRepository weeklyviewRepository;
	
	@Autowired
	private dailyViewBackupRepository dailyviewBackupRepository;
	
	@Autowired
	private dailyToWeeklyMappingRepository dailytoweeklyMappingRepository;
	
}

