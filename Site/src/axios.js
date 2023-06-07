import axios from 'axios';

const api = axios.create({
  baseURL: "https://23.21.241.160:8090/"
})

export default api;