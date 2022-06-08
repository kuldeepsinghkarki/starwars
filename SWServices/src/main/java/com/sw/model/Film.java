package com.sw.model;

import org.springframework.hateoas.RepresentationModel;

/**
 * Film representation model
 */
public class Film extends RepresentationModel<Film> {


    private String name;
    private Integer episodeId;
    private String producer;

    /**
     * @param name
     * @param episodeId
     * @param producer
     */
    public Film(String name, Integer episodeId, String producer) {
        this.name = name;
        this.episodeId = episodeId;
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(Integer episodeId) {
        this.episodeId = episodeId;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
