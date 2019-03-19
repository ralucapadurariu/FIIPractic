package ro.fiipractic.mycinema.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.fiipractic.mycinema.entities.Person;
import ro.fiipractic.mycinema.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping(value = "/hello1")
    public String helloWorld() {
        return "hello world";
    }

    @GetMapping(value = "/hello2")
    public String helloWorld2() {
        return "hello world 2";
    }

    @PostMapping(value = "/number/{number}")
    public String printMyNumber(@PathVariable("number") Integer myNumber) {
        return "My number is " + myNumber;
    }

    @PostMapping(value = "/name")
    public String printMyName(@RequestBody String myName) {
        return "My name is " + myName;
    }

    @GetMapping(value = "/helloService")
    public String helloWorldFromService() {
        return personService.helloFormService();
    }

    @PostMapping(value = "/saveMyPerson")
    public Person saveMyPerson(@RequestBody Person personForSave) {
        return personService.savePerson(personForSave);
    }

    @GetMapping(value = "/findPerson/{id}")
    public Person findById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    @GetMapping(value = "/findAllPersons/")
    public List<Person> findAllPersons() {
        return personService.findAll();
    }

    @DeleteMapping(value = "/deletePerson/{id}")
    public void deleteById(@PathVariable Long id) {
        personService.deletePerson(id);
    }

    @PutMapping(value = "/updatePerson")
    public void updateUser(@RequestBody Person personToUpdate) {
        personService.updatePerson(personToUpdate);

    }


}
