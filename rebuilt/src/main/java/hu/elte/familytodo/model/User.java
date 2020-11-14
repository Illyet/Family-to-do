package hu.elte.familytodo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer id;




    @Column(nullable = false)
    private String username;


    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public enum UserRole{
        ROLE_GUEST, ROLE_USER, ROLE_ADMIN
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserRole role;

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private List<Task> tasks;


    @OneToMany(mappedBy = "creator")
    @JsonIgnore
    private List<Message> messages;

   @ManyToOne
   @JsonIgnore
   @JoinColumn
   private Family family;


}
