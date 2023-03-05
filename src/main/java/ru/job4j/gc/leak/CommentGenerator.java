package ru.job4j.gc.leak;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommentGenerator implements Generate {

    public final String pathPhrases = "src/main/java/ru/job4j/gc/leak/files/phrases.txt";
    private String separator = System.lineSeparator();
    private static List<Comment> comments = new ArrayList<>();
    private List<String> phrases;
    private UserGenerator userGenerator;
    private int count = 50;
    private Random random;

    public CommentGenerator(Random random, UserGenerator userGenerator) {
        this.userGenerator = userGenerator;
        this.random = random;
        read();
    }

    private void read() {
        try {
            phrases = read(pathPhrases);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static List<Comment> getComments() {
        return comments;
    }

    @Override
    public void generate() {
        comments.clear();
        for (int i = 0; i < count; i++) {
            var comment = String.join(" ",
                    phrases.get(random.nextInt(phrases.size())),
                    phrases.get(random.nextInt(phrases.size())),
                    phrases.get(random.nextInt(phrases.size())));
            comments.add(new Comment(comment,
                    userGenerator.randomUser()));
        }
    }
}