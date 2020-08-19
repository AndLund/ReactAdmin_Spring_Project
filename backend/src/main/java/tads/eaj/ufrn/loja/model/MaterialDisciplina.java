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
public class MaterialDisciplina extends RepresentationModel<MaterialDisciplina> {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String material;

//    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
//    @JoinColumn(name="disciplina_id")
//    Disciplina disciplina;

    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    @MapsId
    @JoinColumn(name="disciplina_id")
    Disciplina disciplina;
}
