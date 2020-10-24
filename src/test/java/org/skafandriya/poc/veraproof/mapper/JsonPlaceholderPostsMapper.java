package org.skafandriya.poc.veraproof.mapper;

import org.json.JSONException;
import org.json.JSONObject;
import org.skafandriya.poc.veraproof.model.dto.PostDto;

public class JsonPlaceholderPostsMapper {

    public static PostDto getPostDtoFromJsonObject(JSONObject jsonObject) throws JSONException {
        return new PostDto(
                jsonObject.getString("title"),
                jsonObject.getString("body")
        );
    }

}
