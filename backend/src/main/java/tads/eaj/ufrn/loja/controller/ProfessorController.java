package tads.eaj.ufrn.loja.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.ufrn.loja.model.Professor;
import tads.eaj.ufrn.loja.service.ProfessorService;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/professor")
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
public class ProfessorController {

    private ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @PostMapping
    public Professor insert(@RequestBody Professor p){
        return service.insert(p);
    }

    @GetMapping
    public List<Professor> listAll(){
        return service.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Professor> getOne(@PathVariable("id") Long id){

        Optional<Professor> professorOptional = service.findById(id);

        if(professorOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{

            Professor professor = professorOptional.get();
            //mim mesmo
            professor.add(linkTo(Professor.class).slash(id).withSelfRel());
            //para todos
            professor.add(linkTo(Professor.class).withRel("all-professores"));

            return ResponseEntity.ok().body(professor);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Professor> update(@PathVariable Long id, @RequestBody Professor p){
        return service
                .findById(id)
                .map(record -> {
                    service.saveAndFlush(p);
                    return ResponseEntity.ok().body(p);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    //como está apenas deletando está retornando um tipo genérico '?'
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service
                .findById(id)
                .map(record -> {
                    service.delete(record);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
