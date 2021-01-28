package br.com.zup.casadocodigo.compra.validators;

import br.com.zup.casadocodigo.compra.forms.IniciarCompraForm;
import br.com.zup.casadocodigo.estados.models.Estado;
import br.com.zup.casadocodigo.paises.models.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class PaisEstadoValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return IniciarCompraForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        IniciarCompraForm form = (IniciarCompraForm) o;
        Pais pais = manager.find(Pais.class, form.getPaisId());

        if (form.getEstadoId() == null) {
            if (!pais.getEstados().isEmpty()) {
                errors.rejectValue("estadoId", "PaisEstado.estadoAusente", "Você deve informar um estado para esse " +
                        "país.");
            }
        } else {
            Estado estado = manager.find(Estado.class, form.getEstadoId());

            if (!pais.getEstados().contains(estado)) {
                errors.rejectValue("estadoId", "PaisEstado.estadoInexistente", "O estado não pertence ao país " +
                        "informado.");
            }
        }
    }
}
