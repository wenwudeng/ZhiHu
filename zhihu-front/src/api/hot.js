import axios from './request'
import {
  BASE_URL
} from './config'

export const getHotTopic = params => {
  return axios.post(`${BASE_URL}/topic/getHotTopic`, params).then(res => res.data)
}

export const getHotQues = params => {
  return axios.post(`${BASE_URL}/user/getHotQues?` + params).then(res => res.data)
}
