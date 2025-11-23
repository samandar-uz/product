package org.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.demo.entity.abs.BaseEntity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
public class Product extends BaseEntity {
    private String name;
    private String description;
    private String price;
    @ManyToOne
    private Attachment photo;

}
