package cn.alexpy.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Accessors(chain = true)
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    @NonNull
    private String name;

}
