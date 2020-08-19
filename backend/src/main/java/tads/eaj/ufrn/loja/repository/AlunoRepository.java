package tads.eaj.ufrn.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.ufrn.loja.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
