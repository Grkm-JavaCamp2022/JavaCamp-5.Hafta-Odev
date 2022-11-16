package kodlama.io.DevsApplication.dataAccess.abstracts;

import kodlama.io.DevsApplication.entities.concretes.ProgrammingTechnology;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProgrammingTechnologyRepository extends JpaRepository<ProgrammingTechnology, Integer> {
    boolean existsByNameIgnoreCase (String name); // var mı yokmu kontrolunü veritabanına bıraktırk


}
