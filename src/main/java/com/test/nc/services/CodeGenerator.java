package com.test.nc.services;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Component;

@Component
public class CodeGenerator {
    private RandomStringGenerator randomStringGenerator;

    public CodeGenerator() {
        this.randomStringGenerator = new RandomStringGenerator
                .Builder().filteredBy(c -> isLatinLetterOrDigit(c))
                .build();
    }

    public String generate(int length) {
        return randomStringGenerator.generate(length);
    }

    //проверяем
    private static boolean isLatinLetterOrDigit(int codePoint) {
        return ('a' <= codePoint && codePoint <= 'z')
                || ('A' <= codePoint && codePoint <= 'Z')
                || ('0' <= codePoint && codePoint <= '9')
                || ('+' == codePoint)
                || ('_' == codePoint)
                || ('-' == codePoint);

    }
}
