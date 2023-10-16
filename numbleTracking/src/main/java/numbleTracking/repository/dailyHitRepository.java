package numbleTracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import numbleTracking.entity.dailyHit;


@Repository
public interface dailyHitRepository extends JpaRepository<dailyHit, Long>{

}
