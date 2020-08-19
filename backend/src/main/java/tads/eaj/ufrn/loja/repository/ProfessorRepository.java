package tads.eaj.ufrn.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.ufrn.loja.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
