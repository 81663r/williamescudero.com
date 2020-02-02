package com.williamescudero.favorites.services;

import java.util.ArrayList;
import java.util.List;

import com.williamescudero.favorites.entities.FavoriteItemsEntity;
import com.williamescudero.favorites.entities.FavoritesEntity;
import com.williamescudero.favorites.models.favorites.Favorite;
import com.williamescudero.favorites.models.favorites.Item;
import com.williamescudero.favorites.repositories.FavoriteItemsRepository;
import com.williamescudero.favorites.repositories.FavoritesRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class FavoritesServiceImpl implements FavoritesService {

    @Autowired
    private FavoritesRepository favoritesRepository;

    @Autowired
    private FavoriteItemsRepository favoriteItemsRespository;

    @Override
    public List<Favorite> getFavorites(){

        List<FavoritesEntity> fav_lst = this.favoritesRepository.findAll();
        List<FavoriteItemsEntity> fav_itm_lst = null;
        List<Favorite> favorites = new ArrayList<>();

        for(FavoritesEntity entity : fav_lst){

            Favorite favorite = new Favorite();
            List<Item> items = new ArrayList<>();

            fav_itm_lst = this.favoriteItemsRespository.findAllByfavoriteid(entity.getId());

            favorite.setId(entity.getId());
            favorite.setHeader(entity.getHeader());

            for (FavoriteItemsEntity _item: fav_itm_lst){

                Item item = new Item();

                item.setId(_item.getId());
                item.setLikes(_item.getLikes());
                item.setTitle(_item.getTitle());
                item.setTags(_item.getTags());

                items.add(item);
            }

            favorite.setItems(items);

            favorites.add(favorite);
        }

        return favorites;
    }
}