package tads.eaj.ufrn.loja.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Professor extends RepresentationModel<Professor> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    List<Disciplina> disciplinas;
}
