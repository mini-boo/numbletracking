package numbleTracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import numbleTracking.entity.DailyHit;


@Repository
public interface DailyHitRepository extends JpaRepository<DailyHit, Long>{

}
