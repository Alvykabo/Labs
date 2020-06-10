package com.company;


public class Track {
    private String name;
    private Double duration;
    private MusicStyles style;

    public Track(String name, Double duration, MusicStyles style) {
        this.name = name;
        this.duration = duration;
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public MusicStyles getStyle() {
        return style;
    }

    public void setStyle(MusicStyles style) {
        this.style = style;
    }

    public String toString() {
        return "Name: " + getName() +
                ", Duration: " + getDuration() +
                ", Style: " + getStyle();
    }
}
