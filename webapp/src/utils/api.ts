import axios from "axios";

const BASE_URL = import.meta.env.VITE_SERVER_URL;

export const API = axios.create({ baseURL: BASE_URL });

export const getJobAdverts = async (page: number, limit: number) => {
  const response = await API.get("jobs", {
    params: { page, limit },
  });
  return response.data;
};
