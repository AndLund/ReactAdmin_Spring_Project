package tads.eaj.ufrn.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.ufrn.loja.model.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
