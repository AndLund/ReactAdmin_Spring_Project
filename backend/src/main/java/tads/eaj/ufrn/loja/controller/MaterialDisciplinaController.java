package tads.eaj.ufrn.loja.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.ufrn.loja.model.MaterialDisciplina;
import tads.eaj.ufrn.loja.service.MaterialDisciplinaService;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/materialdisciplina")
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
public class MaterialDisciplinaController {

    private MaterialDisciplinaService service;

    public MaterialDisciplinaController(MaterialDisciplinaService service) {
        this.service = service;
    }

    @PostMapping
    public MaterialDisciplina insert(@RequestBody MaterialDisciplina md){
        return service.insert(md);
    }

    @GetMapping
    public List<MaterialDisciplina> listAll(){
        return service.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<MaterialDisciplina> getOne(@PathVariable("id") Long id){

        Optional<MaterialDisciplina> materialDisciplinaOptional = service.findById(id);

        if(materialDisciplinaOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{

            MaterialDisciplina materialDisciplina = materialDisciplinaOptional.get();
            //mim mesmo
            materialDisciplina.add(linkTo(MaterialDisciplinaController.class).slash(id).withSelfRel());
            //para todos
            materialDisciplina.add(linkTo(MaterialDisciplinaController.class).withRel("all-materiais-disciplinas"));

            return ResponseEntity.ok().body(materialDisciplina);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<MaterialDisciplina> update(@PathVariable Long id, @RequestBody MaterialDisciplina md){
        return service
                .findById(id)
                .map(record -> {
                    service.saveAndFlush(md);
                    return ResponseEntity.ok().body(md);
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
