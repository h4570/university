package pl.edu.pjwstk.mpr.proxy;

import java.io.IOException;

public interface IFileService {

    String getBooks() throws IOException, IllegalArgumentException;

    String getShelfs() throws IOException, IllegalArgumentException;

    String getGuests() throws IOException, IllegalArgumentException;
    
}
