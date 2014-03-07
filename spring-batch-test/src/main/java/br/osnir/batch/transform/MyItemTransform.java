package br.osnir.batch.transform;

import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import br.osnir.batch.object.Person;
import br.osnir.batch.object.PersonTax;

/**
 * @author Osnir F CUNHA
 * 
 */
@Component("itemTransform")
public class MyItemTransform {

    @Transformer
    public PersonTax transformAluno(Person person) {
    	
        PersonTax personTax = new PersonTax();
        personTax.setPerson(person);
        return personTax;
    }
}
