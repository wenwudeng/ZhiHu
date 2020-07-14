import axios from './request'
import {
  BASE_URL
} from './config'

// 获取问题的所有回答
export const getUserById = params => {
  return axios.post(`${BASE_URL}/user/getUserById?` + params).then(res => res.data)
}
