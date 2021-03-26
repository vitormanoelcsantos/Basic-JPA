package com.one.innovation.digital.basicjpa.classes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class State{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String acronym;

    @OneToMany(
            mappedBy = "state",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Student> students = new ArrayList<>();

    public State() { }

    public State(String name, String acronym) {
        this.name = name;
        this.acronym = acronym;
    }

    public State(String name, String acronym, List<Student> students) {
        this.name = name;
        this.acronym = acronym;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + name + '\'' +
                ", sigla='" + acronym + '\'' +
                ", alunos=" + students +
                '}';
    }
}
