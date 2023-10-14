package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.URL;

@Repository
public interface URLRepository extends JpaRepository<URL, String> {

}
