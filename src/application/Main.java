package application;

import entities.Funcionario;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat numeroFormatter = NumberFormat.getInstance(new Locale("pt", "BR"));
        numeroFormatter.setMinimumFractionDigits(2);
        numeroFormatter.setMaximumFractionDigits(2);

        List<Funcionario> empList = new ArrayList<>();

        //ITEM 3.1
        empList.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        empList.add(new Funcionario("João", LocalDate.of(1990, 12, 05), new BigDecimal("2284.38"), "Operador"));
        empList.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        empList.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        empList.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        empList.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 9), new BigDecimal("1582.72"), "Operador"));
        empList.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        empList.add(new Funcionario("Laura", LocalDate.of(1994, 3, 8), new BigDecimal("3017.45"), "Gerente"));
        empList.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        empList.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        //ITEM 3.2
        empList.removeIf(f -> "João".equals(f.getName()));

        System.out.println("==============ITEM 3.3==============");
        System.out.println("----------------------");

        for (Funcionario func : empList){
            System.out.println("Nome: " + func.getName());
            System.out.println("Data Nascimento: " + func.getNascimento().format(dataFormatter));
            System.out.println("Salário: " + numeroFormatter.format(func.getSalary()));
            System.out.println("Função: " + func.getFunction());
            System.out.println("----------------------");
        }

        System.out.println("==============ITEM 3.4==============");
        System.out.println("----------------------");


        for (Funcionario f : empList) {
            f.reajustarSalario(new BigDecimal("0.10"));
        }

        for (Funcionario func : empList){
            System.out.println("Nome: " + func.getName());
            System.out.println("Data Nascimento: " + func.getNascimento().format(dataFormatter));
            System.out.println("Salário (Reajustado): " + numeroFormatter.format(func.getSalary()));
            System.out.println("Função: " + func.getFunction());
            System.out.println("----------------------");
        }

        System.out.println("==============ITEM 3.5 e 3.6==============");
        System.out.println("----------------------");

        Map<String, List<Funcionario>> empMap = new HashMap<>();

        empList.forEach(f -> {
            empMap.computeIfAbsent(f.getFunction(), k -> new ArrayList<>()).add(f);
        });

        empMap.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);

            lista.forEach(f -> {
                System.out.println(f.getName() + " | " + f.getNascimento() + " | " + f.getSalary());
            });
            System.out.println("----------------------");
        });
    }
}
