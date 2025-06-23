package br.com.online.vendas.mvc.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/produtos-view")
    public String exibirProdutos() {
        return "produtos";
    }
}