package kodlama.io.DevsApplication.business.abstracts;

import kodlama.io.DevsApplication.business.requests.programmingLanguageRequest.CreateProgrammingLanguage;
import kodlama.io.DevsApplication.business.requests.programmingTechnologyRequest.CreateProgrammingTechnology;
import kodlama.io.DevsApplication.business.requests.programmingTechnologyRequest.DeleteProgrammingTechnology;
import kodlama.io.DevsApplication.business.requests.programmingTechnologyRequest.UpdateProgrammingTechnology;
import kodlama.io.DevsApplication.business.responses.programmingLanguageResponse.GetListProgrammingLanguage;
import kodlama.io.DevsApplication.business.responses.programmingLanguageResponse.GetProgrammingLanguageById;
import kodlama.io.DevsApplication.business.responses.programmingTechnologyResponse.GetListProgrammingTechnology;
import kodlama.io.DevsApplication.business.responses.programmingTechnologyResponse.GetProgrammingTechnologyById;

import java.util.List;

public interface ProgrammingTechnologyService {
    void add (CreateProgrammingTechnology createProgrammingTechnology) throws Exception;
    void delete (DeleteProgrammingTechnology deleteProgrammingTechnology) throws Exception;
    void update (int id,UpdateProgrammingTechnology updateProgrammingTechnology) throws Exception;

    List<GetListProgrammingTechnology> getall();
    GetListProgrammingTechnology getListProgrammingTechnology (int id);

}
