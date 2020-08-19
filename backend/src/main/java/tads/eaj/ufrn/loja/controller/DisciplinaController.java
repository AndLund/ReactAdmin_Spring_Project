package tads.eaj.ufrn.loja.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.ufrn.loja.model.Disciplina;
import tads.eaj.ufrn.loja.service.DisciplinaService;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/disciplina")
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
public class DisciplinaController {

    private DisciplinaService service;

    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }

    @PostMapping
    public Disciplina insert(@RequestBody Disciplina d){
        return service.insert(d);
    }

    @GetMapping
    public List<Disciplina> listAll(){
        return service.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Disciplina> getOne(@PathVariable("id") Long id){

        Optional<Disciplina> disciplinaOptional = service.findById(id);

        if(disciplinaOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{

            Disciplina disciplina = disciplinaOptional.get();
            //mim mesmo
            disciplina.add(linkTo(DisciplinaController.class).slash(id).withSelfRel());
            //para todos
            disciplina.add(linkTo(DisciplinaController.class).withRel("all-disciplinas"));

            return ResponseEntity.ok().body(disciplina);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Disciplina> update(@PathVariable Long id, @RequestBody Disciplina d){
        return service
                .findById(id)
                .map(record -> {
                    service.saveAndFlush(d);
                    return ResponseEntity.ok().body(d);
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
