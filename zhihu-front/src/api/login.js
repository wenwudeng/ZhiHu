import axios from './request'
import {
  BASE_URL
} from './config'

export const reqLogin = params => { // 登陆
  return axios.post(`${BASE_URL}/user/Login`, params).then(res => res.data)
}
