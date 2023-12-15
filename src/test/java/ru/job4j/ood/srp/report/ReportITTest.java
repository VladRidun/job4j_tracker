package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import javax.xml.bind.JAXBException;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReportITTest {
    @Test
    public void whenITGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        List<Employee> workerList = List.of(
                new Employee("Ivan", now, now, 100),
                new Employee("Vlad", now, now, 150),
                new Employee("Misha", now, now, 30),
                new Employee("Sveta", now, now, 180),
                new Employee("Semen", now, now, 80)
        );
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        for (Employee worker : workerList) {
            store.add(worker);
        }
        Report engine = new ReportIT(store, parser);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee worker : workerList) {
            expect.append(worker.getName()).append(";")
                    .append(parser.parse(worker.getHired())).append(";")
                    .append(parser.parse(worker.getFired())).append(";")
                    .append(worker.getSalary()).append(";")
                    .append(System.lineSeparator());
        }

        assertThat(engine.generate(em -> true)).isEqualTo(expect.toString());
    }
}