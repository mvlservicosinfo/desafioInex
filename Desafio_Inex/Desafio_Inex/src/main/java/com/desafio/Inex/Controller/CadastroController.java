package com.desafio.Inex.Controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.Inex.domain.CadastroRepository;
import com.desafio.Inex.model.Tabela;


@RestController
public class CadastroController {
		
	@Autowired
	private CadastroRepository cadRepository;
	
	@GetMapping("/cadastro")
	private List<Tabela> listarPorNome(String nome){
		return cadRepository.findByNome(nome);
	}

	@GetMapping("/cadastro")
	private List<Tabela> listarPorNomeQueContem(String nome){
		return cadRepository.findByNomeContaining(nome);
		
		/*Esta codificado também e é só escolher:
		 * @GetMapping("/cadastro")
		 * private List<Tabela> listarPorCPFQueContem(String cpf){
		 * 		return cadRepository.findByCPFContaining(cpf);
		 * }
		 * @GetMapping("/cadastro")
		 *  private List<Tabela> listarPorEnderecoQueContem(String endereco){
		 * 		return cadRepository.findByEnderecoContaining(endereco);
		 * }
		 *  @GetMapping("/cadastro")
		 *  private List<Tabela> listarPorId(Long id){
		 * 		return cadRepository.findByIdContaining(id);
		 * }
		 * 
		 */
	}
	
	 @GetMapping("/cadastro/{TabelaId}")
	   private Tabela listarPorId(@PathVariable Long TabelaId){
	 		Optional<Tabela> tab = cadRepository.findById(TabelaId);
	 		return tab.orElse(null);
	 }
	
	
	@GetMapping("/cadastro")
	private void Inserir(String nome, String cpf, String endereco) {
		cadRepository.insertList(nome, cpf, endereco);
	}
	
	@GetMapping("/cadastro")
	private void ApagarPorId(Long id) {
		cadRepository.deleteList(id);
	}
	
	
	@GetMapping("/cadastro")
	private void AtulizarPorId(Long id) {
		cadRepository.updateList(id);
	}
	
}
