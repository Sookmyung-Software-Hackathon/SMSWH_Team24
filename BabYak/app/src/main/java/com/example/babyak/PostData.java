package com.example.babyak;

import java.util.HashMap;
import java.util.Map;

public class PostData {

    public String title;
    public String name;
    public String content;
    public String place;
    public String numberperson;

    public PostData(){}

    public PostData(String title, String name, String content, String place, String numberperson){
        this.title = title;
        this.name = name;
        this.content = content;
        this.place = place;
        this.numberperson = numberperson;
    }

    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("title",title);
        result.put("name",name);
        result.put("content",content);
        result.put("place",place);
        result.put("numberperson",numberperson);

        return result;
    }

}
