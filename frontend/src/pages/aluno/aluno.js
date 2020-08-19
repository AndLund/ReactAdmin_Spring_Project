import React from "react";
import {
	Create,
	Edit,
	List,
	Datagrid,
	TextField,
	TextInput,
	SimpleForm,
	ArrayField,
	SingleFieldList,
	ChipField,
	ArrayInput,
	SimpleFormIterator,
} from "react-admin";

export const ListAluno = (props) => (
	<List {...props}>
		<Datagrid rowClick="edit">
			<TextField source="id" label="Id" />
			<TextField source="nome" label="Nome" />
			<ArrayField source="disciplinas">
				<SingleFieldList>
					<ChipField source="nome" label="Disciplinas" />
				</SingleFieldList>
			</ArrayField>
		</Datagrid>
	</List>
);

export const CreateAluno = (props) => (
	<Create {...props}>
		<SimpleForm>
			<TextInput source="nome" />
			<ArrayInput source="disciplinas">
				<SimpleFormIterator>
					<TextInput source="nome" label="Disciplina" />
				</SimpleFormIterator>
			</ArrayInput>
		</SimpleForm>
	</Create>
);
export const EditAluno = (props) => (
	<Edit {...props}>
		<SimpleForm>
			<TextInput disabled label="Id" source="id" />
			<TextInput source="nome" label="Nome" />
			<ArrayInput source="disciplinas">
				<SimpleFormIterator>
					<TextInput source="nome" label="Disciplina" />
					{/* <AutocompleteInput
						source="disciplinas"
						choices={[
							{ id: 5, name: "Autoria Web" },
							{ id: 2, name: "Estrutura de Dados" },
							{ id: 4, name: "Programação Web" },
							{ id: 9, name: "Contexto Geográfico" },
						]}
					/> */}
				</SimpleFormIterator>
			</ArrayInput>
		</SimpleForm>
	</Edit>
);
