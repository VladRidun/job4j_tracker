package ru.job4j.ood.srp.report;

import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ReportXmlTest {

    @Test
    public void whenOldGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 180);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        String date = parser.parse(now);
        store.add(worker);
        Report engine = new ReportXml(store);
        String expect = String.format("""
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <employees>
                    <employee>
                        <fired>%s</fired>
                        <hired>%s</hired>
                        <name>Ivan</name>
                        <salary>180.0</salary>
                    </employee>
                </employees>
                                """, date, date);
        assertThat(engine.generate(em -> true)).isEqualTo(expect);
    }
}