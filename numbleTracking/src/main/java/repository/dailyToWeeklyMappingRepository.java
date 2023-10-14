package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import entity.dailyToWeeklyMapping;

@Repository
public interface dailyToWeeklyMappingRepository extends JpaRepository<dailyToWeeklyMapping, String> {

}
