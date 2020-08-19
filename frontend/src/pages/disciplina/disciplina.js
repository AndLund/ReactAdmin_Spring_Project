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

export const ListDisciplina = (props) => (
	<List {...props}>
		<Datagrid rowClick="edit">
			<TextField source="id" label="Id" />
			<TextField source="nome" label="Disciplina" />
		</Datagrid>
	</List>
);

export const CreateDisciplina = (props) => (
	<Create {...props}>
		<SimpleForm>
			<TextInput source="nome" label="Disciplina" />
		</SimpleForm>
	</Create>
);
export const EditDisciplina = (props) => (
	<Edit {...props}>
		<SimpleForm>
			<TextInput disabled label="Id" source="id" />
			<TextInput source="nome" label="Nome" />
		</SimpleForm>
	</Edit>
);
