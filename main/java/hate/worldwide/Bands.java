package hate.worldwide;

import lombok.Getter;

public class Bands {
    @Getter
    private String Bandname;
    @Getter
    private String hometown;
    @Getter
    private String genre;
    @Getter
    private String last_ablbum;
    @Getter
    private String Singer;
    @Getter
    private int idInDatabase;

    public Bands(String Bandname, String hometown, String genre, String last_ablbum, String Singer, int idInDatabase) {
        this.Bandname = Bandname;
        this.hometown = hometown;
        this.genre = genre;
        this.last_ablbum = last_ablbum;
        this.Singer = Singer;
        this.idInDatabase = idInDatabase;
    }

    public String getBandname() {
        return Bandname;
    }

    public String getHometown() {
        return hometown;
    }

    public String getGenre() {
        return genre;
    }

    public String getlast_ablbum() {
        return last_ablbum;
    }

    public String getSinger() {
        return Singer;
    }

    public int getIdInDatabase() {return idInDatabase;}

    @Override
    public boolean equals(Object obj) {
        Bands bands = (Bands) obj;
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!Bandname.equals(bands.Bandname)) return false;
        if (!hometown.equals(bands.hometown)) return false;
        if (!genre.equals(bands.genre)) return false;
        if (!last_ablbum.equals(bands.last_ablbum)) return false;
        if (idInDatabase!=bands.idInDatabase) return false;

        return false;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Bandname.hashCode();
        result = 31 * result + hometown.hashCode();
        result = 31 * result + genre.hashCode();
        result = 31 * result + last_ablbum.hashCode();
        result = 31*  result + idInDatabase;
        return result;
    }



}
