import axios from './request'
import {
  BASE_URL
} from './config'

// 获取问题的所有回答
export const getAnswer = params => {
  return axios.post(`${BASE_URL}/answer/getAnswer`, params).then(res => res.data)
}

// 发布回答
export const setAnswer = params => {
  return axios.post(`${BASE_URL}/answer/setAnswer`, params).then(res => res.data)
}
