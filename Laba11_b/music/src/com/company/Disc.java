package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Disc {
    private static final String FILE = "./src/resources/file.txt";

    public Disc() {
        List<Track> trackList = new ArrayList<>();
        trackList.add(new Track("Queen - we will rock you ", 2.49, MusicStyles.ROCK));
        trackList.add(new Track("Twenty One Pilots – Stressed out ", 3.22, MusicStyles.RAP_AND_HIPHOP));
        trackList.add(new Track("Nickback - SEX ", 3.55, MusicStyles.ROCK));
        trackList.add(new Track("Twenty One Pilots – Heavydirtysoul ", 3.03, MusicStyles.RAP_AND_HIPHOP));
        trackList.add(new Track("Kygo - Fragile", 3.51, MusicStyles.POP));
        trackList.add(new Track("Nickback - Hero ", 3.21, MusicStyles.ROCK));
        trackList.add(new Track("Shakira - Waka waka ", 3.22, MusicStyles.POP));
        trackList.add(new Track("Mozart - Requiem", 4.35, MusicStyles.CLASSIC));

            MusicService service = new MusicService();
            service.getTracklist(trackList);
            service.getTotalDuration(trackList);
            service.sortingByStyle(trackList, MusicStyles.ROCK);
            service.findByRange(2.49, 3.03, trackList);
            Disc.readFile();
    }
    public static void readFile() {
        try {
            FileReader reader = new FileReader(FILE);
            Scanner scanner = new Scanner(reader);
            int i = 1;
            while (scanner.hasNextLine()) {
                System.out.println(i + " : " + scanner.nextLine());
                i++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

