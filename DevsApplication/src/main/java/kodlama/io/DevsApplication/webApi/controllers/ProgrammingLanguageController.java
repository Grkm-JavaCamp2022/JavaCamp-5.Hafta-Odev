package kodlama.io.DevsApplication.webApi.controllers;

import kodlama.io.DevsApplication.business.abstracts.ProgrammingLanguageService;
import kodlama.io.DevsApplication.business.requests.programmingLanguageRequest.CreateProgrammingLanguage;
import kodlama.io.DevsApplication.business.requests.programmingLanguageRequest.DeleteProgrammingLanguage;
import kodlama.io.DevsApplication.business.requests.programmingLanguageRequest.UpdateProgrammingLanguage;
import kodlama.io.DevsApplication.business.responses.programmingLanguageResponse.GetListProgrammingLanguage;
import kodlama.io.DevsApplication.business.responses.programmingLanguageResponse.GetProgrammingLanguageById;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/language")
public class ProgrammingLanguageController {
    private ProgrammingLanguageService programmingLanguageService;

    public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping
    public List<GetListProgrammingLanguage> getall() {
       return programmingLanguageService.getall();
    }

    @GetMapping("/{id}")
    public GetProgrammingLanguageById getProgrammingLanguageById (int id) throws Exception {
        return programmingLanguageService.getProgrammingLanguageById(id);
    }

    @PostMapping
    public void add (CreateProgrammingLanguage createProgrammingLanguage) throws Exception {
        programmingLanguageService.add(createProgrammingLanguage);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable int id) throws Exception {
        programmingLanguageService.delete(id);
    }

    @PutMapping("/{id}")
    public void update (@PathVariable int id,@RequestBody UpdateProgrammingLanguage updateProgrammingLanguage) throws Exception {
        programmingLanguageService.update(id,updateProgrammingLanguage);
    }

}
