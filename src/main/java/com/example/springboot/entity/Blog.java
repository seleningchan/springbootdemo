package com.example.springboot.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("blog")
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Blog{
    @Id
    private Integer id;

    private String title;

    private String content;

    /*@Override
    public String toString(){
        return "Blog{" +
                "id=" + 0 +
                ", title='" + title + '\'' +
                ", content=" + content +
                '}';
    }*/

    public Blog(String title, String content)
    {
        this.title = title;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}