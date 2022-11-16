package kodlama.io.DevsApplication.business.concretes;

import kodlama.io.DevsApplication.business.abstracts.ProgrammingLanguageService;
import kodlama.io.DevsApplication.business.requests.programmingLanguageRequest.CreateProgrammingLanguage;
import kodlama.io.DevsApplication.business.requests.programmingLanguageRequest.DeleteProgrammingLanguage;
import kodlama.io.DevsApplication.business.requests.programmingLanguageRequest.UpdateProgrammingLanguage;
import kodlama.io.DevsApplication.business.responses.programmingLanguageResponse.GetListProgrammingLanguage;
import kodlama.io.DevsApplication.business.responses.programmingLanguageResponse.GetProgrammingLanguageById;
import kodlama.io.DevsApplication.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.DevsApplication.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepository programmingLanguageRepository;

    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }


    @Override
    public void add(CreateProgrammingLanguage createProgrammingLanguage) throws Exception {
        if (createProgrammingLanguage.getName().isBlank()) {
            throw new Exception("Lütfen bir programlama dili giriniz.");
        }
        if (isNameExist(createProgrammingLanguage.getName())) {
            throw new Exception("Eklemek istediğiniz programlama dili zaten mevcut.");
        }

        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        programmingLanguage.setName(createProgrammingLanguage.getName());
        programmingLanguageRepository.save(programmingLanguage);
    }

    @Override
    public void delete(int id) throws Exception {
        if (!isIdExist(id)) {
            throw new Exception("Böyle bir id bulunamamaktadır.");
        }
        programmingLanguageRepository.deleteById(id);
    }

    @Override
    public void update(int id,UpdateProgrammingLanguage updateProgrammingLanguage) throws Exception {
        if (isNameExist(updateProgrammingLanguage.getName())) {
            throw new Exception("Aynı isimde bir programlama dili zaten mevcut.");
        }
        if (!isIdExist(updateProgrammingLanguage.getId())) {
            throw new Exception("Bu id ile tanımlanmış programlama dili mavcut değil.");
        }
        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id).get();
        programmingLanguage.setName(updateProgrammingLanguage.getName());
        this.programmingLanguageRepository.save(programmingLanguage);
    }

    @Override
    public ProgrammingLanguage GetProgrammingLanguage(int id) {
        return programmingLanguageRepository.findById(id).get();
    }

    @Override
    public List<GetListProgrammingLanguage> getall() {
        List<ProgrammingLanguage> programmingLanguages = programmingLanguageRepository.findAll();
        List<GetListProgrammingLanguage> getListProgrammingLanguagesResponse = new ArrayList<>();

        for (ProgrammingLanguage lng : programmingLanguages) {
            GetListProgrammingLanguage programmingLanguageResponseItem = new GetListProgrammingLanguage();
            programmingLanguageResponseItem.setId(lng.getId());
            programmingLanguageResponseItem.setName(lng.getName());

            getListProgrammingLanguagesResponse.add(programmingLanguageResponseItem);
        }
        return getListProgrammingLanguagesResponse;
    }


    @Override
    public GetProgrammingLanguageById getProgrammingLanguageById(int id) throws Exception {

        if (!this.programmingLanguageRepository.findById(id).isPresent()) {
            throw new Exception("İd bulunamadı");
        }

        ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findById(id).get();
        GetProgrammingLanguageById getProgrammingLanguageById = new GetProgrammingLanguageById();
        getProgrammingLanguageById.setName(programmingLanguage.getName());

        return  getProgrammingLanguageById;

    }
    public boolean isIdExist (int id) {
        for (ProgrammingLanguage lng:programmingLanguageRepository.findAll()) {
            if (lng.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean isNameExist (String name) {
        if (programmingLanguageRepository.existsByNameIgnoreCase(name)) {
            return true;
        }
        return false;
    }
}