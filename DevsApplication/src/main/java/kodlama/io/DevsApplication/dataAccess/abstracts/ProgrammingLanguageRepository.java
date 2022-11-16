package kodlama.io.DevsApplication.dataAccess.abstracts;

import kodlama.io.DevsApplication.entities.concretes.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {
    List<ProgrammingLanguage> findAllByNameContainsIgnoreCase (String q);

    boolean existsByNameIgnoreCase (String name);

}
