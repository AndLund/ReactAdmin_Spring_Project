package tads.eaj.ufrn.loja.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import tads.eaj.ufrn.loja.model.Aluno;
import tads.eaj.ufrn.loja.repository.AlunoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public Aluno insert(Aluno a){
        return repository.save(a);
    }

    public Aluno update(Aluno a) {
        return repository.save(a);
    }

    public void delete(Aluno a){
        repository.delete(a);
    }

    public Aluno getOne(Long id){
        return repository.findById(id).orElse(null);
    }

    //salva e atualiza ao mesmo tempo
    public Aluno saveAndFlush(Aluno a){
        return repository.saveAndFlush(a);
    }

    public Optional<Aluno> findById(Long id) {
        return repository.findById(id);
    }

    public List<Aluno> getAll(){
        return repository.findAll();
    }
}
