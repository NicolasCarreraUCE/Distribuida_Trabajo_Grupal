package com.distribuida.client;

import com.distribuida.config.FeignClientConfig;
import com.distribuida.dto.AuthorsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "AuthorsClient", url = "${app.authors.url}", configuration = FeignClientConfig.class)
public interface AuthorsClient {
    @GetMapping(value = "/author")
    public List<AuthorsDto> findAllAuthors();

    @GetMapping(value = "/author/{id}")
    public AuthorsDto findAuthorById (@PathVariable("id") Integer id);
}
