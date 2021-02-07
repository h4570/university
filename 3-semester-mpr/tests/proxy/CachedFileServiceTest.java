package pl.edu.pjwstk.mpr.proxy;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class CachedFileServiceTest {

    @Test
    public void should_books_file_read_count_should_be_0() throws IOException {
        FileService fService = new FileService();
        CachedFileService cFService = new CachedFileService(fService);
        assertThat(fService.booksReadCounter == 0);
    }

    @Test
    public void should_books_file_read_count_should_be_1() throws IOException {
        FileService fService = new FileService();
        CachedFileService cFService = new CachedFileService(fService);
        for (int i = 0; i < 100; i++)
            cFService.getBooks();
        assertThat(fService.booksReadCounter == 1);
    }

    @Test
    public void should_shelfs_file_read_count_should_be_1() throws IOException {
        FileService fService = new FileService();
        CachedFileService cFService = new CachedFileService(fService);
        for (int i = 0; i < 100; i++)
            cFService.getShelfs();
        assertThat(fService.shelfsReadCounter == 1);
    }

    @Test
    public void should_guests_file_read_count_should_be_1() throws IOException {
        FileService fService = new FileService();
        CachedFileService cFService = new CachedFileService(fService);
        for (int i = 0; i < 100; i++)
            cFService.getGuests();
        assertThat(fService.guestsReadCounter == 1);
    }

}
