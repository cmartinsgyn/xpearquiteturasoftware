package br.com.online.vendas.mvc.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.online.vendas.mvc.model.domains.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
   List<Produto> findByNome(String nome);
   long count();
    
}
