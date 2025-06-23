package br.com.online.vendas.mvc.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.online.vendas.mvc.model.domains.Produto;
import br.com.online.vendas.mvc.model.repositories.ProdutoRepository;

@Service
public class PodutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public List<Produto> findByNome(String nome) {
        return produtoRepository.findByNome(nome);
    }

    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }

    public long count() {
        return produtoRepository.count();
    }
}