package seang.spring.springtestingfirstday.model;

import lombok.*;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@ToString
public class Student{
    private Long id;
    private String fullName;
    private String gender;
    private Double score;
}
