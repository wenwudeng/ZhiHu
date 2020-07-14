package com.demo.service.Impl;

import com.demo.ResultVO;
import com.demo.entity.Favorites;
import com.demo.mapper.CollectMapper;
import com.demo.mapper.FavoritesMapper;
import com.demo.service.FavoritesService;
import com.demo.uuid.CommonToolkit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class FavoritesServiceImpl implements FavoritesService {
    @Autowired
    private FavoritesMapper favoritesMapper;
    @Autowired
    private CollectMapper collectMapper;
    @Override
    public ResultVO setFavorites(Favorites favorites) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        favorites.setCreateTime(date);            //插入时间.
        favorites.setFavoritesId(CommonToolkit.getUuid());
        favoritesMapper.setFavorites(favorites);
        return new ResultVO(200,null,"新建我的收藏夹");
    }

    @Override
    public ResultVO deleteFavorites(String favoritesId) {
        favoritesMapper.deleteFavorites(favoritesId);
        return new ResultVO(200,null,"删除收藏");
    }
    /*获取用户的收藏夹列表*/
    @Override
    public ResultVO getUserFavorites(String id) {
        List<Map<String,Object>> favoritesList=favoritesMapper.getUserFavorites(id);
        /*获取收藏夹的收藏总数*/
        for(Map<String,Object> favorites : favoritesList) {
            favorites.put("collectCount", collectMapper.getCollectCount((String)favorites.get("favorites_id")));//获取用户的回答次数
        }
        System.out.println(favoritesList);
        return new ResultVO(200,favoritesList,"用户的收藏列表");
    }
}
