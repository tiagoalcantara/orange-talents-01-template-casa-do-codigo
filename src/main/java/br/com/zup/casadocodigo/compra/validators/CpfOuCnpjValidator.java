package br.com.zup.casadocodigo.compra.validators;

import br.com.zup.casadocodigo.compra.forms.IniciarCompraForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CpfOuCnpjValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return IniciarCompraForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        IniciarCompraForm form = (IniciarCompraForm) o;
        if(!form.documentoValido()){
            errors.rejectValue("documento", "CpfOuCnpj", "Documento deve ser cpf ou cnpj.");
        }

    }
}
