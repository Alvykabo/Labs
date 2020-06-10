package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class MusicService {
    private static final String TOTAL_DURATION = "Total duration: ";
    private static final String MIN = " min";
    private Double duration = 0.0;
    private static final String FILE = "./src/resources/file.txt";
    private FileWriter writer;


    public void getTracklist(List<Track> tracklist) {
        try {
            writer = new FileWriter(FILE, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            for (Track t : tracklist) {
                bufferWriter.write(t.toString());
                bufferWriter.newLine();
            }
            bufferWriter.newLine();
            bufferWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getTotalDuration(List<Track> tracklist) {
        try {
            writer = new FileWriter(FILE, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            for (Track track : tracklist) {
                duration += track.getDuration();
            }
            bufferWriter.newLine();
            bufferWriter.write(TOTAL_DURATION + duration + MIN);
            bufferWriter.newLine();
            bufferWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortingByStyle(List<Track> tracklist, MusicStyles style) {
        try {
            writer = new FileWriter(FILE, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            for (Track t : tracklist) {
                if (t.getStyle() == style) {
                    bufferWriter.newLine();
                    bufferWriter.write(t.toString());
                }
            }
            bufferWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findByRange(Double from, Double to, List<Track> tracklist) {
        try {
            writer = new FileWriter(FILE, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            for (Track track : tracklist) {
                if (track.getDuration() >= from && track.getDuration() <= to) {
                    bufferWriter.newLine();
                    bufferWriter.write(track.toString());
                }
            }
            bufferWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
