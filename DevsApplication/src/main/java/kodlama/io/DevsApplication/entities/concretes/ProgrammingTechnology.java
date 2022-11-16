package kodlama.io.DevsApplication.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(name = "technology")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingTechnology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technology_id")
    private int id;


    @Column(name = "technology_name")
    private String name;

    @ManyToOne()
    private ProgrammingLanguage programmingLanguage;
}
