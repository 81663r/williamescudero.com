package com.williamescudero.favorites.models.favorites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Header{

    String title;

    String background;

    String color;

    String  icon;

    @Override
    public String toString(){

        return "title->"+this.title+", background->"+this.background+", color->"+this.color+", icon->"+this.icon;
    }
}