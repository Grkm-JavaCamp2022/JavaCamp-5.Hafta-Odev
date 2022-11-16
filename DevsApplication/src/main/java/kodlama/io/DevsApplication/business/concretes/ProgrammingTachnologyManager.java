package kodlama.io.DevsApplication.business.concretes;

import kodlama.io.DevsApplication.business.abstracts.ProgrammingLanguageService;
import kodlama.io.DevsApplication.business.abstracts.ProgrammingTechnologyService;
import kodlama.io.DevsApplication.business.requests.programmingTechnologyRequest.CreateProgrammingTechnology;
import kodlama.io.DevsApplication.business.requests.programmingTechnologyRequest.DeleteProgrammingTechnology;
import kodlama.io.DevsApplication.business.requests.programmingTechnologyRequest.UpdateProgrammingTechnology;
import kodlama.io.DevsApplication.business.responses.programmingTechnologyResponse.GetListProgrammingTechnology;
import kodlama.io.DevsApplication.business.responses.programmingTechnologyResponse.GetProgrammingTechnologyById;
import kodlama.io.DevsApplication.dataAccess.abstracts.ProgrammingTechnologyRepository;
import kodlama.io.DevsApplication.entities.concretes.ProgrammingTechnology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgrammingTachnologyManager implements ProgrammingTechnologyService {
    private ProgrammingTechnologyRepository programmingTechnologyRepository;

    @Autowired
    private ProgrammingLanguageService programmingLanguageService;


    public ProgrammingTachnologyManager(ProgrammingTechnologyRepository programmingTechnologyRepository) {
        this.programmingTechnologyRepository = programmingTechnologyRepository;
    }


    @Override
    public void add(CreateProgrammingTechnology createProgrammingTechnology) throws Exception {
        if (createProgrammingTechnology.getName().isBlank()) {
            throw new Exception("İsim boş olamaz.");
        }
        if (isNameExist(createProgrammingTechnology.getName())) {
            throw new Exception("Eklemek istediğiniz programlama dili zaten mevcut.");
        }

        ProgrammingTechnology programmingTechnology = new ProgrammingTechnology();
        programmingTechnology.setName(createProgrammingTechnology.getName());
        programmingTechnology.setProgrammingLanguage(programmingLanguageService.GetProgrammingLanguage(createProgrammingTechnology.getProgrammingLanguageId()));
        this.programmingTechnologyRepository.save(programmingTechnology);
    }

    @Override
    public void delete(DeleteProgrammingTechnology deleteProgrammingTechnology) throws Exception {
        if (!isIdExist(deleteProgrammingTechnology.getId())) {
            throw new Exception("İd bulunamadı.");
        }
        ProgrammingTechnology programmingTechnology = new ProgrammingTechnology();
        programmingTechnology.setId(deleteProgrammingTechnology.getId());
        programmingTechnologyRepository.delete(programmingTechnology);
    }

    @Override
    public void update(int id,UpdateProgrammingTechnology updateProgrammingTechnology) throws Exception {
        if (isNameExist(updateProgrammingTechnology.getName())) {
            throw new Exception("Aynı isimde bir programlama dili zaten mevcut.");
        }
        if (!isIdExist(id)) {
            throw new Exception("bu id ile tanımlanmış programlama dili mevcut değil.");
        }
        ProgrammingTechnology programmingTechnology = programmingTechnologyRepository.findById(id).get();
        programmingTechnology.setName(updateProgrammingTechnology.getName());
        this.programmingTechnologyRepository.save(programmingTechnology);
    }

    @Override
    public List<GetListProgrammingTechnology> getall() {
        List<ProgrammingTechnology> technologies = programmingTechnologyRepository.findAll();
        List<GetListProgrammingTechnology> technologyResponse = new ArrayList<GetListProgrammingTechnology>();

        for (ProgrammingTechnology lng:technologies) {
            GetListProgrammingTechnology responseItem = new GetListProgrammingTechnology();
            responseItem.setId(lng.getId());
            responseItem.setName(lng.getName());
            responseItem.setProgrammingLanguageId(lng.getProgrammingLanguage().getId());
            responseItem.setProgrammingLanguageName(lng.getProgrammingLanguage().getName());
            technologyResponse.add(responseItem);
        }
        return technologyResponse;
    }

    @Override
    public GetListProgrammingTechnology getListProgrammingTechnology (int id) {
        GetListProgrammingTechnology technology = new GetListProgrammingTechnology();
        ProgrammingTechnology lng = programmingTechnologyRepository.findById(id).get();
        technology.setName(lng.getName());
        technology.setId(lng.getId());
        technology.setProgrammingLanguageId(lng.getProgrammingLanguage().getId());
        technology.setProgrammingLanguageName(lng.getProgrammingLanguage().getName());
        return technology;

    }

    public boolean isIdExist (int id) {
        for (ProgrammingTechnology lng:programmingTechnologyRepository.findAll()) {
            if (lng.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean isNameExist (String name) {

        return programmingTechnologyRepository.existsByNameIgnoreCase(name);
    }
}
