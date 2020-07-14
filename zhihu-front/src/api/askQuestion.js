import axios from './request'
import {
  BASE_URL
} from './config'

export const askQuestion = params => {
  return axios.post(`${BASE_URL}/user/setQues`, params).then(res => res.data)
}
