import { Admin, Resource } from "react-admin";
import React from "react";
import jsonServerProvider from "ra-data-json-server";
import { CreateAluno, EditAluno, ListAluno } from "./pages/aluno/aluno";
import {
	CreateDisciplina,
	EditDisciplina,
	ListDisciplina,
} from "./pages/disciplina/disciplina";
import {
	CreateMaterialDisciplina,
	EditMaterialDisciplina,
	ListMaterialDisciplina,
} from "./pages/materialdisciplina/materialdisciplina";
import {
	CreateProfessor,
	EditProfessor,
	ListProfessor,
} from "./pages/professor/professor";
const dataProvider = jsonServerProvider("http://localhost:8080");

function App() {
	return (
		<Admin dataProvider={dataProvider}>
			<Resource
				name="aluno"
				list={ListAluno}
				edit={EditAluno}
				create={CreateAluno}
			/>
			<Resource
				name="disciplina"
				list={ListDisciplina}
				edit={EditDisciplina}
				create={CreateDisciplina}
			/>
			<Resource
				name="materialdisciplina"
				list={ListMaterialDisciplina}
				edit={EditMaterialDisciplina}
				create={CreateMaterialDisciplina}
			/>
			<Resource
				name="professor"
				list={ListProfessor}
				edit={EditProfessor}
				create={CreateProfessor}
			/>
		</Admin>
	);
}

export default App;
