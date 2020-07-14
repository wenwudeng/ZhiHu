import axios from './request'
import {
  BASE_URL
} from './config'
// 获取我的关注的接口
export const getConcern = params => {
  return axios.post(`${BASE_URL}/attent/getConcern?` + params).then(res => res.data)
}
// 获取用户收藏夹列表
export const getUserFavorites = params => {
  console.log('c' + params)
  return axios.post(`${BASE_URL}/Favorites/getUserFavorites?` + params).then(res => res.data)
}

// 新增收藏夹
export const setFavorites = params => {
  return axios.post(`${BASE_URL}/Favorites/setFavorites`, params).then(res => res.data)
}
// 获取所有话题接口
export const getAllTopic = params => {
  return axios.post(`${BASE_URL}/topic/getAllTopic`, params).then(res => res.data)
}
// 设置收藏接口
export const setCollect = params => {
  return axios.post(`${BASE_URL}/collect/setCollect`, params).then(res => res.data)
}
// 取消收藏接口
export const deleteCollect = params => {
  return axios.post(`${BASE_URL}/collect/deleteCollect`, params).then(res => res.data)
}

// 获取我关注的问题
export const getAttentionQues = params => {
  return axios.post(`${BASE_URL}/attent/getAttentionQues?` + params).then(res => res.data)
}

// 获取我关注的问题
export const deleteAttentionUser = params => {
  return axios.post(`${BASE_URL}/attent/deleteAttentionUser`, params).then(res => res.data)
}

// 设置我的头像
export const setUserPortrait = params => {
  return axios.post(`${BASE_URL}/user/setUserPortrait`, params).then(res => res.data)
}
