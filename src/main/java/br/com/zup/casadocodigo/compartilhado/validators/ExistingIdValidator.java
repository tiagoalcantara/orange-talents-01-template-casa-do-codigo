package br.com.zup.casadocodigo.compartilhado.validators;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.List;

public class ExistingIdValidator implements ConstraintValidator<ExistingId, Object> {
    private String domainAttribute;
    private Class<?> aClass;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ExistingId constraintAnnotation) {
        domainAttribute = constraintAnnotation.fieldName();
        aClass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Query query = manager.createQuery("select o from " + aClass.getName() + " o where " + domainAttribute + " = :value");
        query.setParameter("value", o);

        List<?> list = query.getResultList();

        return !list.isEmpty();
    }
}
