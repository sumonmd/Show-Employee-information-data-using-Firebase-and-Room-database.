package com.example.user.internproject;

import android.content.Context;
import android.view.View;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.List;

/**
 * Created by Belal on 2/26/2017.
 */

//Artist model for ServerFragment
@IgnoreExtraProperties
public class Artist {
    private String artistId;
    private String artistName;
    private String artistDesignation;
    private String artistTeam;
    private String artistImage;

    public Artist(List<Artist> artists, Context context){
        //this constructor is required
    }

    public Artist() {
    }

    public Artist(String artistId, String artistName, String artistDesignation, String artistTeam, String artistImage) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.artistDesignation = artistDesignation;
        this.artistTeam = artistTeam;
        this.artistImage = artistImage;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setArtistDesignation(String artistDesignation) {
        this.artistDesignation = artistDesignation;
    }

    public void setArtistTeam(String artistTeam) {
        this.artistTeam = artistTeam;
    }

    public void setArtistImage(String artistImage) {
        this.artistImage = artistImage;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getArtistDesignation() {
        return artistDesignation;
    }
    public String getArtistTeam() {
        return artistTeam;
    }
    public String getArtistImage() {
        return artistImage;
    }



}