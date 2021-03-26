package com.one.innovation.digital.basicjpa.classes;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int agesold;

    @ManyToOne(fetch = FetchType.LAZY)
    private State state;

    public Student(String name, int agesold) {
        this.name = name;
        this.agesold = agesold;
    }

    public Student(String name, int agesold, State state) {
        this.name = name;
        this.agesold = agesold;
        this.state = state;
    }

    public Student() { }

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

    public int getAgesold() {
        return agesold;
    }

    public void setAgesold(int agesold) {
        this.agesold = agesold;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(name).append('\'');
        sb.append(", idade=").append(agesold);
        sb.append(", estado='").append(state).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
