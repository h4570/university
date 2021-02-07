package pl.edu.pjwstk.mpr.proxy;

import java.io.IOException;

public class CachedFileService implements IFileService {

    private String latestBooks;
    private String latestShelfs;
    private String latestGuests;

    private FileService fileService;

    public CachedFileService(FileService theFileService) {
        fileService = theFileService;
    }

    public CachedFileService() {
        fileService = new FileService();
    }

    public String getBooks() throws IOException, IllegalArgumentException {
        if (latestBooks == null) latestBooks = fileService.getBooks();
        return latestBooks;
    }

    public String getShelfs() throws IOException, IllegalArgumentException {
        if (latestShelfs == null) latestShelfs = fileService.getShelfs();
        return latestShelfs;
    }

    public String getGuests() throws IOException, IllegalArgumentException {
        if (latestGuests == null) latestGuests = fileService.getGuests();
        return latestGuests;
    }

}