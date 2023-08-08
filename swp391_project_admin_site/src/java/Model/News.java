/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author doanq
 */
public class News {

    private String id;
    private String title;
    private String content;
    private String shortDes;
    private String img;
    private String createDate;
    private String modifired;
    private String createBy;
    private String modifiredBy;

    public News() {
    }

    public News(String id, String title, String content, String shortDes, String img, String createDate, String createBy) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.shortDes = shortDes;
        this.img = img;
        this.createDate = createDate;
        this.createBy = createBy;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getShortDes() {
        return shortDes;
    }

    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifired() {
        return modifired;
    }

    public void setModifired(String modifired) {
        this.modifired = modifired;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifiredBy() {
        return modifiredBy;
    }

    public void setModifiredBy(String modifiredBy) {
        this.modifiredBy = modifiredBy;
    }

    @Override
    public String toString() {
        return "News{" + "id=" + id + ", title=" + title + ", content=" + content + ", createDate=" + createDate + ", modifired=" + modifired + ", createBy=" + createBy + ", modifiredBy=" + modifiredBy + '}';
    }

}
