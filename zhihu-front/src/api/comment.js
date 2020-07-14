import axios from './request'
import {
  BASE_URL
} from './config'

export const getComment = params => {
  return axios.post(`${BASE_URL}/user/getByQues?` + params).then(res => res.data)
}

export const saveComment = params => {
  return axios.post(`${BASE_URL}/user/saveComment`, params).then(res => res.data)
}

export const getAnswerComment = params => {
  return axios.post(`${BASE_URL}/user/getCommentByAnswerId?` + params).then(res => res.data)
}
