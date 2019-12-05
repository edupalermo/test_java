package test.repository;

import org.springframework.data.repository.CrudRepository;
import test.entity.PersonEntity;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

    Optional<PersonEntity> findByUuid(String uuid);

}
