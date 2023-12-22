
package backend.models;


    public class Movie {
        
        public int id;
        private String originalLenguage;
        private String originalTitle;
        private String overwiew;
        private double popularity;
        private String releaseDate;
        private int runtime;
        private String tag;
        private String title;
        private double voteAvg;
        private int voteCount;
        private double price;

    public Movie(int id, String originalLenguage, String originalTitle, String overwiew, double popularity, String date, int runtime, String tag, String title, double voteAvg, int voteCount, double price) {
        this.id = id;
        this.originalLenguage = originalLenguage;
        this.originalTitle = originalTitle;
        this.overwiew = overwiew;
        this.popularity = popularity;
        this.releaseDate = releaseDate;
        this.runtime = runtime;
        this.tag = tag;
        this.title = title;
        this.voteAvg = voteAvg;
        this.voteCount = voteCount;
        this.price = price;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getOriginalLenguage() {
        return originalLenguage;
    }


    public void setOriginalLenguage(String originalLenguage) {
        this.originalLenguage = originalLenguage;
    }


    public String getOriginalTitle() {
        return originalTitle;
    }


    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }


    public String getOverwiew() {
        return overwiew;
    }


    public void setOverwiew(String overwiew) {
        this.overwiew = overwiew;
    }


    public double getPopularity() {
        return popularity;
    }


    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }


    public String getReleaseDate() {
        return releaseDate;
    }


    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


    public int getRuntime() {
        return runtime;
    }


    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }


    public String getTag() {
        return tag;
    }


    public void setTag(String tag) {
        this.tag = tag;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public double getVoteAvg() {
        return voteAvg;
    }


    public void setVoteAvg(double voteAvg) {
        this.voteAvg = voteAvg;
    }


    public int getVoteCount() {
        return voteCount;
    }


    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", originalLenguage=" + originalLenguage + ", originalTitle=" + originalTitle + ", overwiew=" + overwiew + ", popularity=" + popularity + ", releaseDate=" + releaseDate + ", runtime=" + runtime + ", tag=" + tag + ", title=" + title + ", voteAvg=" + voteAvg + ", voteCount=" + voteCount + ", price=" + price + '}';
    }
}
