package com.github.ron99.poke.api.model.database;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ability_table")
public class AbilityDB {

    @Id
    private Integer id;

    @Column(name = "name")
    private String name;
}
