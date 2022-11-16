package kodlama.io.DevsApplication.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "programmingLanguage")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private int id;

    @Column(name = "language_name")
    private String name;

    //@JsonIgnore   // JSON verisinde görünmesi istenmeyen anahtarlar özel olarak belirtiliyor.
    @OneToMany(mappedBy = "programmingLanguage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProgrammingTechnology> programmingTechnologies; // bizim özel verimizdir.

}
