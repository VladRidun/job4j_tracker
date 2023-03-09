package ru.job4j.cache;

import java.io.IOException;

public class Emulator {
    public static void main(String[] args) throws IOException {
        String dir = "src/main/java/ru/job4j/cache/files/names.txt";
        DirFileCache dirFileCache = new DirFileCache(dir);
        System.out.println(dirFileCache.get(dir));
    }
}
