import React from "react";
import {
	Create,
	Edit,
	List,
	Datagrid,
	TextField,
	TextInput,
	SimpleForm,
	ArrayInput,
	SimpleFormIterator,
	ArrayField,
	SingleFieldList,
	ChipField,
} from "react-admin";

export const ListProfessor = (props) => (
	<List {...props}>
		<Datagrid rowClick="edit">
			<TextField source="id" label="Id" />
			<TextField source="nome" label="Professor" />
			<ArrayField source="disciplinas">
				<SingleFieldList>
					<ChipField source="nome" label="Disciplinas" />
				</SingleFieldList>
			</ArrayField>
		</Datagrid>
	</List>
);

export const CreateProfessor = (props) => (
	<Create {...props}>
		<SimpleForm>
			<TextInput source="nome" label="Professor" />
			<ArrayInput source="disciplinas">
				<SimpleFormIterator>
					<TextInput source="nome" label="Disciplina" />
				</SimpleFormIterator>
			</ArrayInput>
		</SimpleForm>
	</Create>
);
export const EditProfessor = (props) => (
	<Edit {...props}>
		<SimpleForm>
			<TextInput disabled label="Id" source="id" />
			<TextInput source="nome" label="Professor" />
			<ArrayInput source="disciplinas">
				<SimpleFormIterator>
					<TextInput source="nome" label="Disciplina" />
				</SimpleFormIterator>
			</ArrayInput>
		</SimpleForm>
	</Edit>
);
