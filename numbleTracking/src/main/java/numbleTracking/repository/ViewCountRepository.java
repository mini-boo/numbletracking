package numbleTracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import numbleTracking.entity.ViewCount;


@Repository
public interface ViewCountRepository extends JpaRepository<ViewCount, Long>{
	
	//id에 따라 하나의 viewcount만 가져오기
	@Query("SELECT v FROM ViewCount v WHERE v.id = :id")
	ViewCount getViewCountById(Long id);

}
