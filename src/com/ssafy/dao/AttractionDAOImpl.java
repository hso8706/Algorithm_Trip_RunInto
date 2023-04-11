package com.ssafy.dao;

import com.ssafy.util.DBUtil;
import com.ssafy.vo.Attraction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttractionDAOImpl implements AttractionDAO{
    DBUtil util;
    static List<Attraction> attractions;

    public AttractionDAOImpl() {
        util=DBUtil.getInstance();
        attractions=new ArrayList<>();
    }

    @Override
    public Attraction selectOne(String contentID) {
        Attraction attraction=null;
        try {

            Connection connection= util.getConnection();
            String q="select info.content_id contentID, content_type_id, title, concat(addr1,' ',addr2) address, tel, first_image, sido_code,  latitude, longitude, overview "
                + "from attraction_info info left join attraction_description `description` "
                + "on info.content_id= `description`.content_id  where info.content_id=?";
            PreparedStatement statement=connection.prepareStatement(q);
            statement.setString(1,contentID);
            ResultSet resultSet=statement.executeQuery();

            while (resultSet.next()){
                 contentID=resultSet.getString(1);
                String contentTypeID=resultSet.getString(2);
                String title=resultSet.getString(3);
                String address=resultSet.getString(4);
                String tel=resultSet.getString(5);
                String firstImage=resultSet.getString(6);
                String sidoCode=resultSet.getString(7);
                String latitude=resultSet.getString(8);
                String longitude=resultSet.getString(9);
                String overview=resultSet.getString(10);

                attraction=new Attraction(contentID,contentTypeID,title,address,tel,firstImage,sidoCode,latitude,longitude,overview);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return attraction;
    }

    @Override
    public List<Attraction> search(String sidoCode, String contentTypeID) {
        try {
            Connection connection= util.getConnection();
            attractions.clear();

            String q="select info.content_id contentID, content_type_id, title, concat(addr1,' ',addr2) address, tel, first_image, sido_code,  latitude, longitude, overview"
                + " from attraction_info info left join attraction_description `description` "
                + "on info.content_id= `description`.content_id where sido_code=? and content_type_id=? ";
            PreparedStatement statement=connection.prepareStatement(q);
            statement.setString(1,sidoCode);
            statement.setString(2,contentTypeID);
            ResultSet resultSet=statement.executeQuery();

            while (resultSet.next()){

                String contentID=resultSet.getString(1);
                contentTypeID=resultSet.getString(2);
                String title=resultSet.getString(3);
                String address=resultSet.getString(4);
                String tel=resultSet.getString(5);
                String firstImage=resultSet.getString(6);
                 sidoCode=resultSet.getString(7);
                String latitude=resultSet.getString(8);
                String longitude=resultSet.getString(9);
                String overview=resultSet.getString(10);

                attractions.add(new Attraction(contentID,contentTypeID,title,address,tel,firstImage,sidoCode,latitude,longitude,overview));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return attractions;
    }
}
