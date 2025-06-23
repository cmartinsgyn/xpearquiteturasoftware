package br.com.online.vendas.mvc.control;

import br.com.online.vendas.mvc.model.domains.Produto;
import br.com.online.vendas.mvc.model.services.PodutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private PodutoService podutoService;

    @GetMapping
    public List<Produto> listarTodosProdutos() {
        return podutoService.findAll();
    }

    @GetMapping("/buscar")
    public List<Produto> buscarProdutosPorNome(@RequestParam String nome) {
        return podutoService.findByNome(nome);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
        Optional<Produto> produto = podutoService.findById(id);
        return produto.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto gravarProduto(@RequestBody Produto produto) {
        return podutoService.save(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerProduto(@PathVariable Long id) {
        podutoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/count")
    public long contarProdutos() {
        return podutoService.count();
    }
}