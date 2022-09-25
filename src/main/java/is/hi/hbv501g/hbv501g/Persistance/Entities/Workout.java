package is.hi.hbv501g.hbv501g.Persistance.Entities;

public class Workout {
    private long ID;
    private String title;
    private int duration;

    private String description;

   // private List<Rental> rental = new ArrayList<>();

    public Workout() {
    }

    public Workout(String title, int duration, String description) {
        this.title = title;
        this.duration = duration;
        this.description = description;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

