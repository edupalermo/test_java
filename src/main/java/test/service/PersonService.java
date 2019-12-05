package test.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.bean.Person;
import test.entity.PersonEntity;
import test.repository.PersonRepository;

import java.util.Optional;

@Service
@Transactional
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Optional<Person> findByUuid(String uuid) {
        return personRepository.findByUuid(uuid).map(personEntity -> Person.builder()
                .uuid(personEntity.getUuid())
                .firstName(personEntity.getFirstName())
                .lastName(personEntity.getLastName())
                .birthday(personEntity.getBirthday())
                .build());
    }

    public Person create(Person person) {
        return toDomain(personRepository.save(toModel(person)));
    }

    public Optional<Person> update(Person person) {
        return personRepository.findByUuid(person.getUuid()).map(personEntity -> {
            personEntity.setFirstName(person.getFirstName());
            personEntity.setLastName(person.getLastName());
            personEntity.setBirthday(person.getBirthday());
            return personEntity;
        }).map(personRepository::save).map(this::toDomain);
    }

    private Person toDomain(PersonEntity personEntity) {
        return Person.builder()
                .uuid(personEntity.getUuid())
                .firstName(personEntity.getFirstName())
                .lastName(personEntity.getLastName())
                .birthday(personEntity.getBirthday())
                .build();
    }

    private PersonEntity toModel(Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setUuid(person.getUuid());
        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        personEntity.setBirthday(person.getBirthday());
        return personEntity;
    }
}
