package com.williamescudero.favorites.models.favorites;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Favorite {
    
    UUID id;

    Header header;

    List<Item> items;
}