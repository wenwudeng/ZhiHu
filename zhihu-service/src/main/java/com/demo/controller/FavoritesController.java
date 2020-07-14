package com.demo.controller;

import com.demo.ResultVO;
import com.demo.entity.Favorites;
import com.demo.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Favorites")
public class FavoritesController {
    @Autowired
    private FavoritesService favoritesService;
    @RequestMapping("/setFavorites")
    private ResultVO setFavorites(@RequestBody Favorites favorites){
        /*以下是测试数据*/
//        Favorites favorites=new Favorites();
//        favorites.setFavoritesId("FABC932037E04450AE3CD74D4B3CE804");
//        favorites.setUserId("F3667642610543F5A3992D0F7E3EA1C9");
//        favorites.setFavoritesName("我是测试收藏夹的名字");
//        favorites.setFavoritesDescribe("我是测试收藏夹的描述");
//        favorites.setOpen(1);
        return favoritesService.setFavorites(favorites);
    }
    //
    @RequestMapping("/deleteFavorites")
    private ResultVO deleteFavorites(@RequestParam String favoritesId){
        /*以下是测试数据*/
//        String favoritesId="FABC932037E04450AE3CD74D4B3CE804";
        return favoritesService.deleteFavorites(favoritesId);
    }
    @RequestMapping("/getUserFavorites")
    private ResultVO getUserFavorites(@RequestParam String id){
        /*以下是测试数据*/
//        String id="14C32C1BD22C499899F0DA167C239112";
        System.out.println("id="+id);
        return favoritesService.getUserFavorites(id);
    }
}
