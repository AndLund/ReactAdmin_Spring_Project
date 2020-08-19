package tads.eaj.ufrn.loja.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.ufrn.loja.model.Aluno;
import tads.eaj.ufrn.loja.service.AlunoService;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/aluno")
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
public class AlunoController {

    private AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @PostMapping
    public Aluno insert(@RequestBody Aluno a){
        return service.insert(a);
    }

    @GetMapping
    public List<Aluno> listAll(){
        return service.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Aluno> getOne(@PathVariable("id") Long id){
        Optional<Aluno> alunoOptional = service.findById(id);

        if(alunoOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{

            Aluno aluno = alunoOptional.get();
            //mim mesmo
            aluno.add(linkTo(AlunoController.class).slash(id).withSelfRel());
            //para todos
            aluno.add(linkTo(AlunoController.class).withRel("all-alunos"));

            return ResponseEntity.ok().body(aluno);
        }

        //retorna 200 quando encontra e erro 404 quando não encontra
//        return service
//                .findById(id)
//                .map(record -> ResponseEntity.ok().body(record)).orElse(ResponseEntity.notFound().build());

//        return service
//                .findById(id)
//                .map(record -> {
//                    return ResponseEntity.ok().body(record);
//                }).orElse(ResponseEntity.notFound().build());

//        Optional<Aluno> alunoOptional = service.findById(id);
//
//        if(alunoOptional.isPresent()){
//            return ResponseEntity.ok().body(alunoOptional.get());
//        }else{
//            return ResponseEntity.notFound().build();
//        }

        //return service.findById(id).orElse(null);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno a){
        return service
                .findById(id)
                .map(record -> {
                    service.saveAndFlush(a);
                    return ResponseEntity.ok().body(a);
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
