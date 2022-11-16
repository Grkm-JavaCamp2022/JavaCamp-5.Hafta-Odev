package kodlama.io.DevsApplication.webApi.controllers;

import kodlama.io.DevsApplication.business.abstracts.ProgrammingTechnologyService;
import kodlama.io.DevsApplication.business.requests.programmingTechnologyRequest.CreateProgrammingTechnology;
import kodlama.io.DevsApplication.business.requests.programmingTechnologyRequest.DeleteProgrammingTechnology;
import kodlama.io.DevsApplication.business.requests.programmingTechnologyRequest.UpdateProgrammingTechnology;
import kodlama.io.DevsApplication.business.responses.programmingTechnologyResponse.GetListProgrammingTechnology;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technology")
public class ProgrammingTechnologyController {
    private ProgrammingTechnologyService programmingTechnologyService;

    public ProgrammingTechnologyController(ProgrammingTechnologyService programmingTechnologyService) {
        this.programmingTechnologyService = programmingTechnologyService;
    }

    @GetMapping
    public List<GetListProgrammingTechnology> getall() {
        return programmingTechnologyService.getall();
    }

    @GetMapping("/{id}")
    public GetListProgrammingTechnology getListProgrammingTechnology (int id) throws Exception {
        return programmingTechnologyService.getListProgrammingTechnology(id);
    }

    @PostMapping
    public void add (@RequestBody CreateProgrammingTechnology createProgrammingTechnology) throws Exception {
        programmingTechnologyService.add(createProgrammingTechnology);
    }

    @DeleteMapping("/{id}")
    public void delete (DeleteProgrammingTechnology deleteProgrammingTechnology) throws Exception {
        programmingTechnologyService.delete(deleteProgrammingTechnology);
    }

    @PutMapping("/{id}")
    public void update (@PathVariable int id,@RequestBody UpdateProgrammingTechnology updateProgrammingTechnology) throws Exception {
        programmingTechnologyService.update(id, updateProgrammingTechnology);
    }
}
