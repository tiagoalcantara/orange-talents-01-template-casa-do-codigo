package br.com.zup.casadocodigo.autor.validators;


import br.com.zup.casadocodigo.autor.forms.CadastrarAutorForm;
import br.com.zup.casadocodigo.autor.models.Autor;
import br.com.zup.casadocodigo.autor.repositories.AutorRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailUnicoValidator implements Validator {
    private final AutorRepository autorRepository;

    public EmailUnicoValidator(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return CadastrarAutorForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        CadastrarAutorForm form = (CadastrarAutorForm) o;
        Optional<Autor> autor = autorRepository.findByEmail(form.getEmail());

        if(autor.isPresent()) {
            errors.rejectValue("email", "Email.unico", "E-mail deve ser único");
        }
    }
}
