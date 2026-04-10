package entities;

import java.time.LocalDate;

public class Pessoa {
    private String name;
    private LocalDate nascimento;

    public Pessoa(String name, LocalDate nascimento) {
        this.name = name;
        this.nascimento = nascimento;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
