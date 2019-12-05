package test.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
@SecondaryTable(name = "PERSON_DETAIL", pkJoinColumns = @PrimaryKeyJoinColumn(name = "PERSON_ID", referencedColumnName = "ID"))
@SequenceGenerator(name = PersonEntity.SEQUENCE_INTERNAL_NAME, sequenceName = "PERSON_SEQ", initialValue = 1, allocationSize = 1)
@Data
public class PersonEntity {

    static final String SEQUENCE_INTERNAL_NAME = "PERSON_SEQ_GENERATOR";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_INTERNAL_NAME)
    @Column(insertable = false, updatable = false, nullable = false)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String uuid;
    private String firstName;
    private String lastName;

    @Column(table = "PERSON_DETAIL")
    private LocalDate birthday;
}
