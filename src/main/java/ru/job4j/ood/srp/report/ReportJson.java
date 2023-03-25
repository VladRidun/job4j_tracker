package ru.job4j.ood.srp.report;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportJson implements Report {
    private final MemStore store;
    private final DateTimeParser<Calendar> dateTimeParser;
    JSONArray jsonArray;

    public ReportJson(MemStore store) {
        this.store = store;
        this.dateTimeParser = new ReportDateTimeParser();
        this.jsonArray = new JSONArray();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        for (Employee employee : store.findBy(filter)) {
            jsonArray.put(new JSONObject()
                    .put("name", employee.getName())
                    .put("hired", dateTimeParser.parse(employee.getHired()))
                    .put("fired", dateTimeParser.parse(employee.getFired()))
                    .put("salary", employee.getSalary()));
        }
        return jsonArray.toString();
    }
}
