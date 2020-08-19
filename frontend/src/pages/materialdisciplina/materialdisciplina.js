import React from "react";
import {
	Create,
	Edit,
	List,
	Datagrid,
	TextField,
	TextInput,
	SimpleForm,
} from "react-admin";

export const ListMaterialDisciplina = (props) => (
	<List {...props}>
		<Datagrid rowClick="edit">
			<TextField source="id" label="Id" />
			<TextField source="material" label="Material da Disciplina" />
			<TextField source="disciplina.nome" label="Disciplina" />
		</Datagrid>
	</List>
);

export const CreateMaterialDisciplina = (props) => (
	<Create {...props}>
		<SimpleForm>
			<TextInput source="material" label="Material da Disciplina" />
			<TextInput source="disciplina.nome" label="Disciplina" />
		</SimpleForm>
	</Create>
);
export const EditMaterialDisciplina = (props) => (
	<Edit {...props}>
		<SimpleForm>
			<TextInput disabled label="Id" source="id" />
			<TextInput source="material" label="Material da Disciplina" />
			<TextInput source="disciplina.nome" label="Disciplina" />
		</SimpleForm>
	</Edit>
);
