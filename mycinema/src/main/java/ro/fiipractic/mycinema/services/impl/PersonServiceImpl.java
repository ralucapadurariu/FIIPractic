package ro.fiipractic.mycinema.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fiipractic.mycinema.entities.Person;
import ro.fiipractic.mycinema.repositories.PersonRepository;
import ro.fiipractic.mycinema.services.PersonService;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public String helloFormService() {
        return "hello from service";
    }

    @Override
    public Person savePerson(Person personToSave) {
        return personRepository.save(personToSave);
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void updatePerson(Person personToUpdate) {
        Person personFromDb = personRepository.findById(personToUpdate.getId()).orElse(null);
        personFromDb.setFullName(personToUpdate.getFullName());
        personFromDb.setEmail(personToUpdate.getEmail());
        personFromDb.setPhone(personToUpdate.getPhone());
        personRepository.save(personFromDb);

    }

//    public void updateUser(Userinfos u) {
//    User userFromDb = userRepository.findById(u.getid());
//crush the variables of the object found
//        userFromDb.setFirstname("john");
//        userFromDb.setLastname("dew");
//        userFromDb.setAge(16);
//
//        userRepository.save(userFromDb);
   // }


}
