import axios from './request'
import {
  BASE_URL
} from './config'

// 用户关注问题
export const doAttentionQues = params => {
  return axios.post(`${BASE_URL}/attent/setAttentionQues`, params).then(res => res.data)
}
// 用户取消关注问题
export const unAttentionQues = params => {
  return axios.post(`${BASE_URL}/attent/deleteAttentionQues`, params).then(res => res.data)
}

// 获取当前用户对某个用户的关注情况——以及该用户的个人信息
export const getAttentionWithOtherUser = params => {
  return axios.post(`${BASE_URL}/attent/getAttentionWithOtherUser?` + params).then(res => res.data)
}

// 关注用户
export const setAttentionUser = params => {
  return axios.post(`${BASE_URL}/attent/setAttentionUser`, params).then(res => res.data)
}

// 取消关注用户
export const deleteAttentionUser = params => {
  return axios.post(`${BASE_URL}/attent/deleteAttentionUser`, params).then(res => res.data)
}

// 获取某个用户的粉丝数
export const getFansCount = params => {
  return axios.post(`${BASE_URL}/attent/getFansCount?` + params).then(res => res.data)
}
// 获取关注该问题的人数
export const getQuesAttentionCount = params => {
  return axios.post(`${BASE_URL}/attent/getQuesAttentionCount?` + params).then(res => res.data)
}

// 通用接口！获取关注某个东西的用户！并判断我是否已经关注了TA！
export const getUserByFocusId = params => {
  return axios.post(`${BASE_URL}/attent/getUserByFocusId?` + params).then(res => res.data)
}

// 通用接口！判断用户是否关注了某个东西！
export const isAttention = params => {
  return axios.post(`${BASE_URL}/attent/isAttention?` + params).then(res => res.data)
}
