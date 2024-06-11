import axios from "axios";
import { Job } from "../types/Job";

const BASE_URL = process.env.SERVER_URL;

export const API = axios.create({ baseURL: BASE_URL });

export async function getJobAdverts(): Promise<Job[]> {
  const response = await axios.get<Job[]>("jobs");
  return response.data;
}
