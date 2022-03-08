package testtask;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
//        List<Word> list = List.of(
//                Word.of("large", 3),
//                Word.of("phone", -6),
//                Word.of("newspaper", 2),
//                Word.of("chocolate", -10),
//                Word.of("connection", 13),
//                Word.of("engineering", 10)
//        );
//
//        System.out.println(
//                list.stream()
//                        .filter(Predicate.not(Word::isBad))
//                        .max(Comparator.comparing(Word::getPriority))
//                        .map(Word::getValue)
//                        .orElse("Nothing found")
//        );
        Tournament tournament = new Tournament();
        System.out.println(tournament.numberOfGames(28));
    }

    public static class Word {
        private final String value;
        private final int priority;

        public Word(String value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        static Word of(String value, int priority){
            return new Word(value, priority);
        }

        public String getValue() {
            return value;
        }

        public int getPriority() {
            return priority;
        }

        public boolean isBad() {
            return this.value.contains("la");
        }
    }
}
