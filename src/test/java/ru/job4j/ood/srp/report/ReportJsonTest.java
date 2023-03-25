package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportJsonTest {

    @Test
    void generate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 180);
        Employee worker2 = new Employee("Vlad", now, now, 120);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        String date = parser.parse(now);
        store.add(worker1);
        store.add(worker2);
        Report engine = new ReportJson(store);
        String expect = String.format("""
                        [{"fired":"%s","name":"Ivan","hired":"%s","salary":180},{"fired":"%s","name":"Vlad","hired":"%s","salary":120}]""",
                date, date, date, date);
        assertThat(engine.generate(em -> true)).isEqualTo(expect);
    }
}