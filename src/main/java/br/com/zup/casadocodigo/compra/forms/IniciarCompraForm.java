package br.com.zup.casadocodigo.compra.forms;

import br.com.zup.casadocodigo.compartilhado.validators.ExistingId;
import br.com.zup.casadocodigo.estados.models.Estado;
import br.com.zup.casadocodigo.paises.models.Pais;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class IniciarCompraForm {
    @NotEmpty
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ExistingId(domainClass = Pais.class)
    private Long paisId;
    @ExistingId(domainClass = Estado.class)
    private Long estadoId;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public IniciarCompraForm(@NotEmpty @Email String email,
                             @NotBlank String nome,
                             @NotBlank String sobrenome,
                             @NotBlank String documento,
                             @NotBlank String endereco,
                             @NotBlank String complemento,
                             @NotBlank String cidade,
                             @NotNull Long paisId,
                             Long estadoId,
                             @NotBlank String telefone,
                             @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public String getDocumento() {
        return documento;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public boolean documentoValido() {
        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(this.documento, null) || cnpjValidator.isValid(this.documento, null);
    }
}
