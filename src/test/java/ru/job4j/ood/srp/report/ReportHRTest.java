package ru.job4j.ood.srp.report;

import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReportHRTest {
    @Test
    public void whenHRGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        List<Employee> workerListInput = List.of(
                new Employee("Ivan", now, now, 100),
                new Employee("Vlad", now, now, 150),
                new Employee("Misha", now, now, 30),
                new Employee("Sveta", now, now, 180),
                new Employee("Semen", now, now, 80)
        );
        List<Employee> workerListExpected = List.of(
                new Employee("Sveta", now, now, 180),
                new Employee("Vlad", now, now, 150),
                new Employee("Ivan", now, now, 100),
                new Employee("Semen", now, now, 80),
                new Employee("Misha", now, now, 30)
        );
        for (Employee worker : workerListInput) {
            store.add(worker);
        }
        Report engine = new ReportHR(store);
        StringBuilder expect = new StringBuilder().append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee worker : workerListExpected) {
            expect.append(worker.getName()).append(" ")
                    .append(worker.getSalary())
                    .append(System.lineSeparator());
        }
        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}