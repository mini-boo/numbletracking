package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.viewCount;

public interface viewCountRepository extends JpaRepository<viewCount, Long>{

}
