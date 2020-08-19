package tads.eaj.ufrn.loja.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import tads.eaj.ufrn.loja.model.Professor;
import tads.eaj.ufrn.loja.repository.ProfessorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public Professor insert(Professor p){
        return repository.save(p);
    }

    public Professor update(Professor p) {
        return repository.save(p);
    }

    public void delete(Professor p){
        repository.delete(p);
    }

    public Professor getOne(Long id){
        return repository.findById(id).orElse(null);
    }

    public Professor saveAndFlush(Professor p){
        return repository.saveAndFlush(p);
    }

    public Optional<Professor> findById(Long id) {
        return repository.findById(id);
    }

    public List<Professor> getAll(){
        return repository.findAll();
    }
}
