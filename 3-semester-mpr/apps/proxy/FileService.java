package pl.edu.pjwstk.mpr.proxy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService implements IFileService {

    public int booksReadCounter;
    public int shelfsReadCounter;
    public int guestsReadCounter;

    public String getBooks() throws IOException, IllegalArgumentException {
        System.out.println("Opened books.txt!");
        booksReadCounter++;
        return Files.readString(Path.of("./src/test/resources/books.txt"));
    }

    public String getShelfs() throws IOException, IllegalArgumentException {
        System.out.println("Opened shelfs.txt!");
        shelfsReadCounter++;
        return Files.readString(Path.of("./src/test/resources/shelfs.txt"));
    }

    public String getGuests() throws IOException, IllegalArgumentException {
        System.out.println("Opened guests.txt!");
        guestsReadCounter++;
        return Files.readString(Path.of("./src/test/resources/guests.txt"));
    }

}