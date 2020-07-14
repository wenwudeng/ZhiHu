import axios from './request'
import {
  BASE_URL
} from './config'

export const reqRegister = params => { // 登陆
  return axios.post(`${BASE_URL}/user/register`, params).then(res => res.data)
}
