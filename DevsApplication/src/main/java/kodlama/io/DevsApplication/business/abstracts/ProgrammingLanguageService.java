package kodlama.io.DevsApplication.business.abstracts;

import kodlama.io.DevsApplication.business.requests.programmingLanguageRequest.CreateProgrammingLanguage;
import kodlama.io.DevsApplication.business.requests.programmingLanguageRequest.DeleteProgrammingLanguage;
import kodlama.io.DevsApplication.business.requests.programmingLanguageRequest.UpdateProgrammingLanguage;
import kodlama.io.DevsApplication.business.responses.programmingLanguageResponse.GetListProgrammingLanguage;
import kodlama.io.DevsApplication.business.responses.programmingLanguageResponse.GetProgrammingLanguageById;
import kodlama.io.DevsApplication.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {
    void add (CreateProgrammingLanguage createProgrammingLanguage) throws Exception;
    void delete (int id) throws Exception;
    void update (int id,UpdateProgrammingLanguage updateProgrammingLanguage) throws Exception;

    ProgrammingLanguage GetProgrammingLanguage (int id);

    List<GetListProgrammingLanguage> getall();
    GetProgrammingLanguageById getProgrammingLanguageById(int id) throws Exception;
}
