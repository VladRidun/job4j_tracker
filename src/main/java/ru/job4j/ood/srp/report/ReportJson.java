package ru.job4j.ood.srp.report;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportJson implements Report {
    private final MemStore store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReportJson(MemStore store, DateTimeParser<Calendar> dateTimeParser) {
        this.store =  store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;
        for (Employee employee : store.findBy(filter)) {
            jsonObject = new JSONObject();
            jsonObject.put("name", employee.getName());
            jsonObject.put("hired", dateTimeParser.parse(employee.getHired()));
            jsonObject.put("fired", dateTimeParser.parse(employee.getFired()));
            jsonObject.put("salary", employee.getSalary());
            jsonArray.put(jsonObject);
        }
        return jsonArray.toString();
    }
}
