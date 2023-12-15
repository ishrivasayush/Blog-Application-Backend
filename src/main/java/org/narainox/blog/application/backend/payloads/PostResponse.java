package org.narainox.blog.application.backend.payloads;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.narainox.blog.application.backend.entity.Post;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostResponse {
    private List<PostDto> content;
    private long pageNumber;
    private long pageSize;
    private long totalElements;
    private long totalPages;
    private boolean lastPage;


}
