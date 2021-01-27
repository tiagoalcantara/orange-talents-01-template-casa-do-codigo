package br.com.zup.casadocodigo.compartilhado.validators;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {
    private String domainAttribute;
    private Class<?> aClass;
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        domainAttribute = constraintAnnotation.fieldName();
        aClass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Query query = manager.createQuery("select 1 from " + aClass.getName() + " where " + domainAttribute + " = :value");
        query.setParameter("value", o);
        List<?> list = query.getResultList();

        return list.isEmpty();
    }
}
