import axios from './request'
import {
  BASE_URL
} from './config'

// 获取问题所属的话题
export const getTopic = params => {
  return axios.post(`${BASE_URL}/topic/getTopic?` + params).then(res => res.data)
}
// 根据问题id来获取问题
export const getQuestion = params => {
  return axios.post(`${BASE_URL}/user/getQues?` + params).then(res => res.data)
}
