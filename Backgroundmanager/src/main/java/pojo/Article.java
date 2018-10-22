package pojo;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable{
    private Integer id;

    private String category;

    private Date date;

    private String imghref;

    private String backimghref;

    private String autor;

    private String title;

    private Integer liulanliang;

    private String tag;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImghref() {
        return imghref;
    }

    public void setImghref(String imghref) {
        this.imghref = imghref == null ? null : imghref.trim();
    }

    public String getBackimghref() {
        return backimghref;
    }

    public void setBackimghref(String backimghref) {
        this.backimghref = backimghref == null ? null : backimghref.trim();
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor == null ? null : autor.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getLiulanliang() {
        return liulanliang;
    }

    public void setLiulanliang(Integer liulanliang) {
        this.liulanliang = liulanliang;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}