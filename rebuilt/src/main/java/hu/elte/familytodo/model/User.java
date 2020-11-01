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
    private Integer id;

    @Column
    @NotNull
    private String name;


    @Column
    @NotNull
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String username;


    @Column
    @NotNull
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public enum UserRole{
        GUEST, USER, ADMIN
    }

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany(mappedBy = "creator")
    @JsonIgnore
    private List<Task> createdTasks;

    @OneToMany(mappedBy = "creator")
    @JsonIgnore
    private List<Message> messages;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private Family family;


}
