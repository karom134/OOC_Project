package ooc.project.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ingredient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "ingredient_menu_map",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private Set<Menu> menuSet;
}
