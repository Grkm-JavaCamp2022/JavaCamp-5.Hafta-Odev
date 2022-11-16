package kodlama.io.DevsApplication.business.responses.programmingLanguageResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListProgrammingLanguage {
    private int id;
    private String name;
}
