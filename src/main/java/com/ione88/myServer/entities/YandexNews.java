package com.ione88.myServer.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "yandex_news")
public class YandexNews  {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

	@Column
	@CreationTimestamp
	private LocalDateTime created;

	@Column
	@UpdateTimestamp
    private LocalDateTime updated;

    private String title;

	private String url;

	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public YandexNews() {
	}
}

