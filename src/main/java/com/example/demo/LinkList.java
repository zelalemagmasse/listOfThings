package com.example.demo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class LinkList {
    private String person;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    private String imageURL;

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;

    private LocalDateTime dayEntered;

    public LocalDateTime getDayEntered() {
        return dayEntered;
    }

    public void setDayEntered(LocalDateTime dayEntered) {
        this.dayEntered = dayEntered;
    }

    public LinkList() {
        dayEntered = LocalDateTime.now();
    }


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String url;


}
