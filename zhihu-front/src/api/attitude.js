import axios from './request'
import {
  BASE_URL
} from './config'

// 初次建立态度
export const setAttitude = params => {
  return axios.post(`${BASE_URL}/user/setEndorse`, params).then(res => res.data)
}
// 更新态度
export const updataAttitude = params => {
  return axios.post(`${BASE_URL}/user/updataEndorse`, params).then(res => res.data)
}
// 删除态度
export const deleteAttitude = params => {
  return axios.post(`${BASE_URL}/user/deleteAttitude`, params).then(res => res.data)
}
