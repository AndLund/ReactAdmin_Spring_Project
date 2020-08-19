package tads.eaj.ufrn.loja.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import tads.eaj.ufrn.loja.model.Disciplina;
import tads.eaj.ufrn.loja.repository.DisciplinaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    private DisciplinaRepository repository;

    public DisciplinaService(DisciplinaRepository repository) {
        this.repository = repository;
    }

    public Disciplina insert(Disciplina d){
        return repository.save(d);
    }

    public Disciplina update(Disciplina d) {
        return repository.save(d);
    }

    public void delete(Disciplina d){
        repository.delete(d);
    }

    public Disciplina getOne(Long id){
        return repository.findById(id).orElse(null);
    }

    public Disciplina saveAndFlush(Disciplina d){
        return repository.saveAndFlush(d);
    }

    public Optional<Disciplina> findById(Long id) {
        return repository.findById(id);
    }

    public List<Disciplina> getAll(){
        return repository.findAll();
    }
}
