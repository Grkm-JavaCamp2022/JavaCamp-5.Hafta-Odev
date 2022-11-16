package kodlama.io.DevsApplication.business.requests.programmingTechnologyRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProgrammingTechnology {
    private String name;
    private int programmingLanguageId;
}
