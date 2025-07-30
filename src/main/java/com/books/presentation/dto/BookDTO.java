package com.books.presentation.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    @NotBlank(message = "Title Invalid")
    @Size(max = 100)
    private String title;
    @NotBlank(message = "Author Invalid")
    @Size(max = 50)
    private String author;
    @Size(max = 50)
    private String gender;
    @Min(1800)
    @Max(2025)
    private Integer yearPublication;
}
