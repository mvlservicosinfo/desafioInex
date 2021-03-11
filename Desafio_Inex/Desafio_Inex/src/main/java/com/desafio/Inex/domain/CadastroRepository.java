package com.desafio.Inex.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.Inex.model.Tabela;

@Repository
public interface CadastroRepository extends JpaRepository<Tabela, Long> {
	
	List<Tabela> findByNome(String nome);
	List<Tabela> findByCPF(String cpf);
	List<Tabela> findByEndereco(String endereco);
	
	List<Tabela> findByNomeContaining(String nome);
	List<Tabela> findByCPFContaining(String cpf);
	List<Tabela> findByEnderecoContaining(String endereco);
	
	List<Tabela> findByIdContaining(Long id);
	
	List<Tabela> deleteList(Long id);
	
	List<Tabela> updateList(Long id);
	
	List<Tabela> insertList(String nome, String cpf, String endereco);

	

	



}
