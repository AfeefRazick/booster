import { useQuery } from "@tanstack/react-query";
import { getJobAdverts } from "../../utils/api";

export default function Jobs() {
  const { data } = useQuery({ queryKey: ["jobs"], queryFn: getJobAdverts });
  return <div>Jobs</div>;
}
