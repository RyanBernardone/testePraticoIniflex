package entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private BigDecimal salary;
    private String function;

    public Funcionario(String name, LocalDate nascimento, BigDecimal salary, String function) {
        super(name, nascimento);
        this.salary = salary;
        this.function = function;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void reajustarSalario(BigDecimal percentual) {
        this.salary = this.salary.add(this.salary.multiply(percentual));
    }
}
