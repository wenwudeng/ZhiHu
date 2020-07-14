package com.demo.service;

import com.demo.ResultVO;
import com.demo.entity.Favorites;

public interface FavoritesService {
    /*用户创建一个新的收藏夹*/
    ResultVO setFavorites(Favorites favorites);
    /*用户删除收藏夹*/
    ResultVO deleteFavorites(String favoritesId);
    /*获取用户的收藏夹列表*/
    ResultVO getUserFavorites(String id);
}
