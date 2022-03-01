package spring.java.webapp.web.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import spring.java.webapp.domain.posts.Posts;

@Getter
public class PostsListsResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostsListsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        
        this.modifiedDate = entity.getModifiedDate();
    }
}
