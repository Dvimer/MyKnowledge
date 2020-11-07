package reader;

import reactor.core.publisher.Flux;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.BaseStream;

/**
 * https://simonbasle.github.io/2017/10/file-reading-in-reactor/
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String defaultFileName = System.getProperty("user.home") + "/bookshelf.txt";
        Scanner c = new Scanner(System.in);

        System.out.printf("Please enter a path to a large text file [%s]:", defaultFileName);
        String fileName = c.nextLine();
        c.close();
        if (fileName == null || fileName.isEmpty()) {
            fileName = defaultFileName;
        }

        Path path = Paths.get(fileName);

        if (!path.toFile().isFile()) {
            System.err.println("The file " + path + " doesn't exist or is not a text file");
            System.exit(-1);
        }

        Flux<String> books = fluxVersion(path);
        books.doOnNext(System.out::println)
                .blockLast();

    }


    private static Flux<String> fluxVersion(Path path) {
        return fromPath(path)
                .filter(s -> s.startsWith("Title: ") || s.startsWith("Author: ")
                        || s.equalsIgnoreCase("##BOOKSHELF##"))
                .map(s -> s.replaceFirst("Title: ", ""))
                .map(s -> s.replaceFirst("Author: ", " by "))
                .windowWhile(s -> !s.contains("##"))
                .flatMap(bookshelf -> bookshelf
                        .window(2)
                        .flatMap(bookInfo -> bookInfo.reduce(String::concat))
                        .collectList()
                        .doOnNext(s -> System.gc())
                        .flatMapMany(bookList -> Flux.just(
                                "\n\nFound new Bookshelf of " + bookList.size() + " books:",
                                bookList.toString())
                        ));
    }

    private static Flux<String> fromPath(Path path) {
        return Flux.using(() -> Files.lines(path),
                Flux::fromStream,
                BaseStream::close
        );
    }
}
