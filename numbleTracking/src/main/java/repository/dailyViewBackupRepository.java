package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.URL;
import entity.dailyView;

@Repository
public interface dailyViewBackupRepository extends JpaRepository<dailyView, String> {

}
