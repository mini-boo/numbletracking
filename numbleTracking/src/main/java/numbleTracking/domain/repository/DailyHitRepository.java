package numbleTracking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import numbleTracking.entity.DailyHit;


@Repository
public interface DailyHitRepository extends JpaRepository<DailyHit, Long> {
    @Query("SELECT d.hitDate, COUNT(d) FROM DailyHit d GROUP BY d.hitDate")
    List<Object[]> countAllDailyHits();
}
