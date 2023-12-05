package org.narainox.blog.application.backend.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private Integer categoryId;
    @NotEmpty
    @Size(min = 8, max = 100,message = "Size of Title is less than 8 or More than 100")
    private String categoryTitle;
    @NotEmpty
    private String categoryDescription;
}
