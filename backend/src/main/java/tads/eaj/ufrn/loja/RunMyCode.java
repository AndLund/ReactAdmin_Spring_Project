package tads.eaj.ufrn.loja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import tads.eaj.ufrn.loja.model.Aluno;
import tads.eaj.ufrn.loja.model.Disciplina;
import tads.eaj.ufrn.loja.model.MaterialDisciplina;
import tads.eaj.ufrn.loja.model.Professor;
import tads.eaj.ufrn.loja.repository.AlunoRepository;
import tads.eaj.ufrn.loja.repository.DisciplinaRepository;
import tads.eaj.ufrn.loja.repository.MaterialDisciplinaRepository;
import tads.eaj.ufrn.loja.repository.ProfessorRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class RunMyCode implements ApplicationRunner {

	@Autowired
	AlunoRepository alunoRepository;
	@Autowired
	DisciplinaRepository disciplinaRepository;
	@Autowired
	MaterialDisciplinaRepository materialDisciplinaRepository;
	@Autowired
	ProfessorRepository professorRepository;

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {

//
//		//ONETOONE
//		//MATERIALDISCIPLINA E DISCIPLINA
//		//CASO 4 - RELACIONAMENTO BIDIRECIONAL - PQ PARECE MAIS SIMPLES
//
//		MaterialDisciplina md1 = new MaterialDisciplina();
//		Disciplina d1 = new Disciplina();
//
//		md1.setMaterial("Apostila");
//		d1.setNomeDisciplina("Autoria Web");
//
//		disciplinaRepository.save(d1);
//		md1.setDisciplina(d1);
//		d1.setMaterialDisciplina(md1);
//		materialDisciplinaRepository.save(md1);
//
//		//ONETOMANY
//
//		//PROFESSOR E DISCIPLINAS
//		//CASO 3 - RELACIONAMENTO BIDIRECIONAL - PQ FAZ MENOS BUSCAS
//		Professor p1 = new Professor();
//		p1.setNome("Taniro");
//
//		Disciplina d1 = new Disciplina();
//		Disciplina d2 = new Disciplina();
//
//		d1.setNomeDisciplina("Programacao Web");
//		d2.setNomeDisciplina("Estrutura de Dados");
//
//		List<Disciplina> disciplinas = new ArrayList<>();
//		disciplinas.add(d1);
//		disciplinas.add(d2);
//
//		p1.setDisciplinas(disciplinas);
//		d1.setProfessor(p1);
//		d2.setProfessor(p1);
//
//		professorRepository.save(p1);
//
		//MANYTOMANY
		//ALUNOS E DISCIPLINAS
		// CASO 1 - MAIS SIMPLES
		//Professor p1 = new Professor();
		//p1.setNome("Taniro");

//		Disciplina d1 = new Disciplina();
//		Disciplina d2 = new Disciplina();
//
//		d1.setNomeDisciplina("Autoria Web");
//		d2.setNomeDisciplina("Contexto");
//
//		List<Disciplina> disciplinaList = new ArrayList<>();
//		disciplinaList.add(d1);
//		disciplinaList.add(d2);
//
//		//d1.setProfessor(p1);
//		//p1.setDisciplinas(disciplinaList);
//
//		Aluno a1 = new Aluno();
//		Aluno a2 = new Aluno();
//
//		a1.setNome("Anderson");
//		a2.setNome("Antonio");
//
//		List<Aluno> alunoList = new ArrayList<>();
//		alunoList.add(a1);
//		alunoList.add(a2);
//
//		a1.setDisciplinas(disciplinaList);
//		a2.setDisciplinas(disciplinaList);
//
//		alunoRepository.save(a1);
//		alunoRepository.save(a2);

		//professorRepository.save(p1);
	}
}
