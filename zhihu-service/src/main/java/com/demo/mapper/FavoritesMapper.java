package com.demo.mapper;

import com.demo.entity.Favorites;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FavoritesMapper {
    /*用户新建一个收藏夹*/
    void setFavorites(Favorites favorites);
    /*用户删除收藏夹*/
    void deleteFavorites(String favoritesId);
    /*获取用户的收藏夹列表*/
    List<Map<String,Object>> getUserFavorites(String id);

}