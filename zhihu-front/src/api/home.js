import axios from './request'
import {
  BASE_URL
} from './config'

export const getAllQues = params => {
  return axios.post(`${BASE_URL}/user/getAllQues?` + params).then(res => res.data)
}

export const getAllTopic = params => {
  return axios.post(`${BASE_URL}/topic/getAllTopic`).then(res => res.data)
}
