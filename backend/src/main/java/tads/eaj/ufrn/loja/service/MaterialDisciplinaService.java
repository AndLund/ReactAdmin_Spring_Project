package tads.eaj.ufrn.loja.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import tads.eaj.ufrn.loja.model.MaterialDisciplina;
import tads.eaj.ufrn.loja.repository.MaterialDisciplinaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialDisciplinaService {

    private MaterialDisciplinaRepository repository;

    public MaterialDisciplinaService(MaterialDisciplinaRepository repository) {
        this.repository = repository;
    }

    public MaterialDisciplina insert(MaterialDisciplina md){
        return repository.save(md);
    }

    public MaterialDisciplina update(MaterialDisciplina md) {
        return repository.save(md);
    }

    public void delete(MaterialDisciplina md){
        repository.delete(md);
    }

    public MaterialDisciplina getOne(Long id){
        return repository.findById(id).orElse(null);
    }

    public MaterialDisciplina saveAndFlush(MaterialDisciplina md){
        return repository.saveAndFlush(md);
    }

    public Optional<MaterialDisciplina> findById(Long id) {
        return repository.findById(id);
    }

    public List<MaterialDisciplina> getAll(){
        return repository.findAll();
    }
}
