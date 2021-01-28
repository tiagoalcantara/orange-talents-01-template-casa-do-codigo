package br.com.zup.casadocodigo.compra.controllers;

import br.com.zup.casadocodigo.compra.forms.IniciarCompraForm;
import br.com.zup.casadocodigo.compra.validators.CpfOuCnpjValidator;
import br.com.zup.casadocodigo.compra.validators.PaisEstadoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CpfOuCnpjValidator cpfOuCnpjValidator;

    @Autowired
    private PaisEstadoValidator paisEstadoValidator;

    @InitBinder
    protected void init(WebDataBinder binder){
        binder.addValidators(cpfOuCnpjValidator);
        binder.addValidators(paisEstadoValidator);
    }

    @PostMapping("/primeiro-passo")
    public ResponseEntity<?> iniciarCompra(@RequestBody @Validated IniciarCompraForm form) {
        // Faz apenas as validações
        return ResponseEntity.ok().build();
    }
}
