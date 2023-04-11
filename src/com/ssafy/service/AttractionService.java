package com.ssafy.service;

import com.ssafy.vo.Attraction;
import java.util.List;

public interface AttractionService {

    Attraction selectOne(String contentID);
    List<Attraction> search(String sidoCode, String contentTypeID);




}
