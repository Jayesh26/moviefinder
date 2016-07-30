package com.assignment.moviefinder.db.bean;


import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


/**
 * @Author jayesh
 * @Since 27/7/16.
 */
@Table(name = MovieBean.Table.NAME)
public class MovieBean extends Model implements Serializable {

    public static class Builder {

        private String title = "";
        private String year = "";
        private String rated = "";
        private String genre = "";
        private String releases = "";
        private String plot = "";
        private String poster = "";
        private String runTime = "";
        private String director = "";
        private String writer = "";
        private String actor = "";
        private String language = "";
        private String country = "";
        private String awards = "";
        private String metascore = "";
        private String imdbRating = "";
        private String imdbVotes = "";
        private String imdbId = "";
        private String type = "";
        private String response = "";


        /**
         * The builder constructor with default values
         *
         * @param title
         * @param mYEAR
         * @param rated
         * @param mGENRE
         * @param mRELEASES
         * @param mPLOT
         * @param mPOSTER
         */
        public Builder(String title, String mYEAR, String rated, String mGENRE, String mRELEASES, String mPLOT, String mPOSTER) {

            this.title = title;
            this.year = mYEAR;
            this.rated = rated;
            this.genre = mGENRE;
            this.releases = mRELEASES;
            this.plot = mPLOT;
            this.poster = mPOSTER;
        }

        public MovieBean build() {
            MovieBean movieBean = new MovieBean();

            movieBean.setTitle(title);
            movieBean.setYear(year);
            movieBean.setRated(rated);
            movieBean.setGenre(genre);
            movieBean.setReleased(releases);
            movieBean.setPlot(plot);
            movieBean.setPoster(poster);
            movieBean.setActors(actor);
            movieBean.setAwards(awards);
            movieBean.setCountry(country);
            movieBean.setDirector(director);
            movieBean.setImdbID(imdbId);
            movieBean.setImdbRating(imdbRating);
            movieBean.setImdbVotes(imdbVotes);
            movieBean.setLanguage(language);
            movieBean.setMetascore(metascore);
            movieBean.setRuntime(runTime);
            movieBean.setWriter(writer);
            movieBean.setType(type);
            movieBean.setResponse(response);

            return movieBean;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setPoster(String poster) {
            this.poster = poster;
            return this;
        }

        public Builder setPlot(String plot) {
            this.plot = plot;
            return this;
        }

        public Builder setYear(String year) {
            this.year = year;
            return this;
        }

        public Builder setRated(String rated) {
            this.rated = rated;
            return this;
        }

        public Builder setReleases(String releases) {
            this.releases = releases;
            return this;
        }

        public Builder setRunTime(String runTime) {
            this.runTime = runTime;
            return this;
        }

        public Builder setDirector(String director) {
            this.director = director;
            return this;
        }

        public Builder setWriter(String writer) {
            this.writer = writer;
            return this;
        }

        public Builder setActor(String actor) {
            this.actor = actor;
            return this;
        }

        public Builder setLanguage(String language) {
            this.language = language;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Builder setAwards(String awards) {
            this.awards = awards;
            return this;
        }

        public Builder setMetascore(String metascore) {
            this.metascore = metascore;
            return this;
        }

        public Builder setImdbRating(String imdbRating) {
            this.imdbRating = imdbRating;
            return this;
        }

        public Builder setImdbVotes(String imdbVotes) {
            this.imdbVotes = imdbVotes;
            return this;
        }

        public Builder setImdbId(String imdbId) {
            this.imdbId = imdbId;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setResponse(String response) {
            this.response = response;
            return this;
        }
    }


    public interface Table {
        String NAME = "MovieBean";

        interface Columns {
            String TITLE = "title";
            String YEAR = "year";
            String RATED = "rated";
            String RELEASES = "released";
            String RUNTIME = "runTime";
            String GENRE = "genre";
            String DIRECTOR = "director";
            String WRITER = "writer";
            String ACTOR = "actor";
            String PLOT = "plot";
            String LANGUAGE = "language";
            String COUNTRY = "country";
            String AWARDS = "awards";
            String POSTER = "poster";
            String METASCORE = "metaScore";
            String IMDBRATING = "imdbRating";
            String IMDBVOTES = "imdbVotes";
            String IMDBID = "imdbId";
            String TYPE = "TYPE";
            String RESPONSE = "response";
        }
    }

    @Column(name = Table.Columns.TITLE)
    @SerializedName("Title")
    @Expose
    private String title;

    @Column(name = Table.Columns.YEAR)
    @SerializedName("Year")
    @Expose
    private String year;

    @Column(name = Table.Columns.RATED)
    @SerializedName("Rated")
    @Expose
    private String rated;

    @Column(name = Table.Columns.RELEASES)
    @SerializedName("Released")
    @Expose
    private String released;

    @Column(name = Table.Columns.RUNTIME)
    @SerializedName("Runtime")
    @Expose
    private String runtime;

    @Column(name = Table.Columns.GENRE)
    @SerializedName("Genre")
    @Expose
    private String genre;

    @Column(name = Table.Columns.DIRECTOR)
    @SerializedName("Director")
    @Expose
    private String director;

    @Column(name = Table.Columns.WRITER)
    @SerializedName("Writer")
    @Expose
    private String writer;

    @Column(name = Table.Columns.ACTOR)
    @SerializedName("Actors")
    @Expose
    private String actors;

    @Column(name = Table.Columns.PLOT)
    @SerializedName("Plot")
    @Expose
    private String plot;

    @Column(name = Table.Columns.LANGUAGE)
    @SerializedName("Language")
    @Expose
    private String language;

    @Column(name = Table.Columns.COUNTRY)
    @SerializedName("Country")
    @Expose
    private String country;

    @Column(name = Table.Columns.AWARDS)
    @SerializedName("Awards")
    @Expose
    private String awards;

    @Column(name = Table.Columns.POSTER)
    @SerializedName("Poster")
    @Expose
    private String poster;

    @Column(name = Table.Columns.METASCORE)
    @SerializedName("Metascore")
    @Expose
    private String metascore;

    @Column(name = Table.Columns.IMDBRATING)
    @SerializedName("imdbRating")
    @Expose
    private String imdbRating;

    @Column(name = Table.Columns.IMDBVOTES)
    @SerializedName("imdbVotes")
    @Expose
    private String imdbVotes;

    @Column(name = Table.Columns.IMDBID)
    @SerializedName("imdbID")
    @Expose
    private String imdbID;

    @Column(name = Table.Columns.TYPE)
    @SerializedName("Type")
    @Expose
    private String type;

    @Column(name = Table.Columns.RESPONSE)
    @SerializedName("Response")
    @Expose
    private String response;

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The Title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year The Year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return The rated
     */
    public String getRated() {
        return rated;
    }

    /**
     * @param rated The Rated
     */
    public void setRated(String rated) {
        this.rated = rated;
    }

    /**
     * @return The released
     */
    public String getReleased() {
        return released;
    }

    /**
     * @param released The Released
     */
    public void setReleased(String released) {
        this.released = released;
    }

    /**
     * @return The runtime
     */
    public String getRuntime() {
        return runtime;
    }

    /**
     * @param runtime The Runtime
     */
    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    /**
     * @return The genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre The Genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @return The director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director The Director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return The writer
     */
    public String getWriter() {
        return writer;
    }

    /**
     * @param writer The Writer
     */
    public void setWriter(String writer) {
        this.writer = writer;
    }

    /**
     * @return The actors
     */
    public String getActors() {
        return actors;
    }

    /**
     * @param actors The Actors
     */
    public void setActors(String actors) {
        this.actors = actors;
    }

    /**
     * @return The plot
     */
    public String getPlot() {
        return plot;
    }

    /**
     * @param plot The Plot
     */
    public void setPlot(String plot) {
        this.plot = plot;
    }

    /**
     * @return The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language The Language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country The Country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return The awards
     */
    public String getAwards() {
        return awards;
    }

    /**
     * @param awards The Awards
     */
    public void setAwards(String awards) {
        this.awards = awards;
    }

    /**
     * @return The poster
     */
    public String getPoster() {
        return poster;
    }

    /**
     * @param poster The Poster
     */
    public void setPoster(String poster) {
        this.poster = poster;
    }

    /**
     * @return The metascore
     */
    public String getMetascore() {
        return metascore;
    }

    /**
     * @param metascore The Metascore
     */
    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    /**
     * @return The imdbRating
     */
    public String getImdbRating() {
        return imdbRating;
    }

    /**
     * @param imdbRating The imdbRating
     */
    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    /**
     * @return The imdbVotes
     */
    public String getImdbVotes() {
        return imdbVotes;
    }

    /**
     * @param imdbVotes The imdbVotes
     */
    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    /**
     * @return The imdbID
     */
    public String getImdbID() {
        return imdbID;
    }

    /**
     * @param imdbID The imdbID
     */
    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The Type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The response
     */
    public String getResponse() {
        return response;
    }

    /**
     * @param response The Response
     */
    public void setResponse(String response) {
        this.response = response;
    }
}