package kodlama.io.DevsApplication.business.responses.programmingTechnologyResponse;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetListProgrammingTechnology {
    private int id;
    private String name;
    private int programmingLanguageId;
    private String programmingLanguageName;
}
