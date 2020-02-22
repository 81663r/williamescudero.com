package com.williamescudero.favorites.services;

import java.util.List;

import com.williamescudero.favorites.models.favorites.Favorite;


public interface FavoritesService {

    public List<Favorite> getFavorites();

}