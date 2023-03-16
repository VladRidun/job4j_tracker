package ru.job4j.ood.template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GeneratorFirstTest {

    @Test
    public void whenStringFromProduceEqualsTemplate() {
        Generator generator = new GeneratorFirst();
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        assertThat(generator.produce(template, args)).isEqualTo("I am Petr Arsentev, Who are you?");
    }

    @Test
    public void whenKeyDoesNotExists()  {
        Generator generator = new GeneratorFirst();
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        assertThatThrownBy(() -> generator.produce(template, args)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenProcedureExistsExcessKey() {
        Generator generator = new GeneratorFirst();
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        args.put("name1", "Vlad");
        assertThatThrownBy(() -> generator.produce(template, args)).
                isInstanceOf(IllegalArgumentException.class);
    }
}