package ro.fiipractic.mycinema.services;

import ro.fiipractic.mycinema.entities.Person;

import javax.validation.constraints.Max;
import java.util.List;

public interface PersonService {

    Person savePerson(Person personToSave);

    Person findById(Long id);

    List<Person> findAll();

    void deletePerson (Long id);

    void updatePerson(Person personToUpdate);

    boolean existsById(Long id);

}
