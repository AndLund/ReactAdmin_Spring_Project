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
//O representationmodel permite fazer uso dos links, ou seja, permite criar links para ele mesmo e as para as outras coisas
public class Aluno extends RepresentationModel<Aluno> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "aluno_disciplina",
            joinColumns = @JoinColumn(name = "aluno_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    List<Disciplina> disciplinas;
}