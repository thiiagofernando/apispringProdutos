package com.produtos.apirest.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value="Api Rest Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping("/produtos")
	@ApiOperation(value="Retorna Uma Lista de Produtos")
	public List<Produto> listaProduto() {
		return produtoRepository.findAll();
	}

	@GetMapping("/produtos/{id}")
	@ApiOperation(value="Retorna Um Produto pelo Id")
	public Produto listaProdutoId(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	@PostMapping("/produtos")
	@ApiOperation(value="Adiciona Um Produto")
	public Produto adicionarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);

	}

	@DeleteMapping("/produtos/{id}")
	@ApiOperation(value="Deleta um Produto")
	public String deletaProdutoId(@PathVariable(value = "id") long id) {
		try {
			produtoRepository.deleteById(id);
			return "Produto Deletado!!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@PutMapping("/produtos")
	@ApiOperation(value="Atualiza um Produto")
	public Produto atualizarProduto(@RequestBody Produto produtoAtualizado) {
		return produtoRepository.save(produtoAtualizado);
	}

}
