package com.williamescudero.favorites.models.favorites;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    UUID id;

    String title;

    Integer likes;

    HashMap<String, String> tags;
}