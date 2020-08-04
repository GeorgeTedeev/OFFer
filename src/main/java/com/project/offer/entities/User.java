package com.project.offer.entities;

import com.project.offer.enums.Genre;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.Set;

@Entity
//@Scope("prototype")
@Table(name = "appUser")
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

    @Generated(GenerationTime.INSERT)
    @Column(name = "registrationValue")
    private String registrationValue;


    public User() {
    }

    public User(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationValue() {
        return registrationValue;
    }

    public void setRegistrationValue(String registrationValue) {
        this.registrationValue = registrationValue;
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


}
