package com.williamescudero.favorites.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

import com.williamescudero.favorites.models.favorites.Favorite;
import com.williamescudero.favorites.services.FavoritesService;

@RestController
@RequestMapping("/api/v1")
public class FavoritesControllerV1 {

    @Autowired
    private FavoritesService favoritesService;

    @ApiOperation(value = "Get all favorite things")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful")})
    @GetMapping(value = "/favorites", produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin(origins = "http://localhost:8081")
    public List<Favorite> getFavorites() {

        return this.favoritesService.getFavorites();
    }
}