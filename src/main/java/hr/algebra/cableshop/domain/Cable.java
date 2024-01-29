package hr.algebra.cableshop.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity /// automatski se SQL postavlja u H2 bazi
public class Cable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "the name should not be empty")
    private String name;
    private Boolean conductivity;

    @NotNull(message = "it should not be emtpy")
    @Positive(message = "the number should be higher than 0")
    private BigDecimal price;

    @ManyToMany
    private List<CableTag> cableTags;

    public Cable(String name, Boolean conductivity, BigDecimal price, List<CableTag> cableTagList) {
        this.cableTags = cableTagList;
        this.name = name;
        this.conductivity = conductivity;
        this.price = price;
    }
}
