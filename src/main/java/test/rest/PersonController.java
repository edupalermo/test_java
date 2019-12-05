package test.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import test.bean.Person;
import test.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/{uuid}")
    public Person retrieve(@PathVariable("uuid") String uuid) {
        return personService.findByUuid(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public void create(@RequestBody(required = true) Person person) {
        personService.create(person);
    }

    @PutMapping
    public Person update(@RequestBody(required = true) Person person) {
        return personService.update(person).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }
}
