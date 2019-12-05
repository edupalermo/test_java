package test.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Builder
//@Builder(builderClassName = "PersonBuilder", toBuilder = true)
// @JsonDeserialize(builder = Person.PersonBuilder.class)
@AllArgsConstructor
@ToString
public class Person {

    private String uuid;
    private String firstName;
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;
}
