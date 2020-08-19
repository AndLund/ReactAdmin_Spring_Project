package tads.eaj.ufrn.loja.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Disciplina extends RepresentationModel<Disciplina> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;

//    @ManyToOne
//    @JoinColumn(name = "professor_id")
//    Professor professor;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "professor_id")
//    Professor professor;

//    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
//    @JoinColumn(name = "material_disciplina_id")
//    MaterialDisciplina materialDisciplina;

//    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
//    MaterialDisciplina materialDisciplina;
}
