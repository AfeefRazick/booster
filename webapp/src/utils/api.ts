import axios from "axios";
import { Job } from "../types/Job";

const BASE_URL = import.meta.env.VITE_SERVER_URL;

export const API = axios.create({ baseURL: BASE_URL });

export async function getJobAdverts() {
  const response = await API.get<Job[]>("jobs");
  return response.data;
}
