package com.project.offer.entities;

import com.project.offer.enums.Genre;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "User_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @Column(name = "name")
    private String name;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @ElementCollection
    @Column(name = "genres")
    private Set<Genre> favouriteGenres;
    @ElementCollection
    @Column(name = "movies")
    private Set<String> favouriteMovies;
    @ElementCollection
    @Column(name = "tvshows")
    private Set<String> favouriteTVShows;
    @ElementCollection
    @Column(name = "directors")
    private Set<String> favouriteDirectors;
    @ElementCollection
    @Column(name = "artists")
    private Set<String> favouriteArtists;
    @Column(name = "generatedString")
    private String generatedString;
    @Column(name = "confirmFlag")
    private boolean confirmFlag;


    public User() {
    }

    public User(String name, String login, String password, String generatedString){
        this.name = name;
        this.login = login;
        this.password = password;
        this.generatedString = generatedString;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Set<Genre> getFavouriteGenres() {
        return favouriteGenres;
    }

    public void setFavouriteGenres(Set<Genre> favouriteGenres) {
        this.favouriteGenres = favouriteGenres;
    }

    public Set<String> getFavouriteMovies() {
        return favouriteMovies;
    }

    public void setFavouriteMovies(Set<String> favouriteMovies) {
        this.favouriteMovies = favouriteMovies;
    }

    public Set<String> getFavouriteTVShows() {
        return favouriteTVShows;
    }

    public void setFavouriteTVShows(Set<String> favouriteTVShows) {
        this.favouriteTVShows = favouriteTVShows;
    }

    public Set<String> getFavouriteDirectors() {
        return favouriteDirectors;
    }

    public void setFavouriteDirectors(Set<String> favouriteDirectors) {
        this.favouriteDirectors = favouriteDirectors;
    }

    public Set<String> getFavouriteArtists() {
        return favouriteArtists;
    }

    public void setFavouriteArtists(Set<String> favouriteArtist) {
        this.favouriteArtists = favouriteArtist;
    }

    public String getGeneratedString() {
        return generatedString;
    }

    public void setGeneratedString(String generatedString) {
        this.generatedString = generatedString;
    }

    public boolean isConfirmFlag() {
        return confirmFlag;
    }

    public void setConfirmFlag(boolean confirmFlag) {
        this.confirmFlag = confirmFlag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", favouriteGenres=" + favouriteGenres +
                ", favouriteMovies=" + favouriteMovies +
                ", favouriteTVShows=" + favouriteTVShows +
                ", favouriteDirectors=" + favouriteDirectors +
                ", favouriteArtists=" + favouriteArtists +
                ", generatedString='" + generatedString + '\'' +
                ", confirmFlag=" + confirmFlag +
                '}';
    }
}
