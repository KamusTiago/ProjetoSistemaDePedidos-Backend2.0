package com.kamustiago.kamus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kamustiago.kamus.domain.Categoria;
import com.kamustiago.kamus.domain.Produto;
import com.kamustiago.kamus.repositories.CategoriaRepository;
import com.kamustiago.kamus.repositories.ProdutoRepository;
import com.kamustiago.kamus.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	// Instanciei ProdutoRepository com a anotacao Autorired
	@Autowired
	private ProdutoRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto find(Integer id) {
		 Optional<Produto> obj = repo.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
				} 

	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest =  PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.findDistinctByNomeContainingAndCategorasIn(nome, categorias, pageRequest);
	}
	
	
	}

