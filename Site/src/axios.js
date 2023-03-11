import axios from 'axios';

const api = axios.create({
  baseURL: "http://23.21.241.160:8090/"
})

export default api;