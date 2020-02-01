package com.williamescudero.favorites.converters;

import java.util.HashMap;
import java.util.Map.Entry;

import com.williamescudero.favorites.models.favorites.Header;

import org.springframework.core.convert.converter.Converter;

public class HeaderConverter implements Converter<HashMap<String, String>, Header> {

    @Override
    public Header convert(HashMap<String, String> source) {

        Header header = new Header();

        for (Entry<String, String> entry : source.entrySet()) {
            switch(entry.getKey()){
                case "background":
                    header.setBackground(entry.getValue());
                    break;
                case "color":
                    header.setColor(entry.getValue());
                    break;
                case "title":
                    header.setTitle(entry.getValue());
                    break;
                case "icon":
                    header.setIcon(entry.getValue());
                    break;
            }
        }

        return header;

    }

}