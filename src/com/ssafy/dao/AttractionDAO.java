package com.ssafy.dao;

import com.ssafy.vo.Attraction;
import java.util.List;

public interface AttractionDAO {

    Attraction selectOne(String contentID);
    List<Attraction> search(String sidoCode, String contentTypeID);



}
