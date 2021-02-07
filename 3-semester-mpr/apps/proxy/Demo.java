package pl.edu.pjwstk.mpr.proxy;

import java.io.IOException;
import java.util.ArrayList;

public class Demo {

    private static IFileService fileService;

    public static void main(String[] args) throws IOException {
        fileService = new CachedFileService();
        var booksReqs = new ArrayList<String>();
        var shelfsReqs = new ArrayList<String>();
        var guestsReqs = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            booksReqs.add(fileService.getBooks());
            shelfsReqs.add(fileService.getShelfs());
            guestsReqs.add(fileService.getGuests());
        }
        System.out.println("Done!");
    }

}
