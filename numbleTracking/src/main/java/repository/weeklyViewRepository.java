package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.weeklyView;

@Repository
public interface weeklyViewRepository extends JpaRepository<weeklyView, String> {

}
