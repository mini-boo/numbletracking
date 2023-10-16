package numbleTracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import numbleTracking.entity.viewCount;


@Repository
public interface viewCountRepository extends JpaRepository<viewCount, Long>{
	
	//아이디에 따라 데이터 가져오기
	viewCount getHitById(Long id);

}
