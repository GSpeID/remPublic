package ru.x3m.rem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Table(name = "charts")
@NoArgsConstructor
@Getter
@Setter
public class Chart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    @Positive
    private Long testId;

    @Column(name = "test_description")
    @NotBlank
    private String testDescription;

    @Column(name = "test_price")
    @Positive
    private Double testPrice;

    @Column(name = "test_date")
    @NotBlank
    private Date testDate;

}
