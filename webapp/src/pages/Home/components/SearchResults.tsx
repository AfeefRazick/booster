import { ImSpinner8 } from "react-icons/im";
import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import JobAdvert from "./JobAdvert";
import { getJobAdverts } from "../../../utils/api";
import SecondaryButton from "../../../components/buttons/Secondary";
import { Job } from "../../../types/Job";
import { useSearchParams } from "react-router-dom";

export default function SearchResults() {
  const queryClient = useQueryClient();
  const [searchParams] = useSearchParams();

  const page = parseInt(searchParams.get("page") || "0");
  const limit = parseInt(searchParams.get("limit") || "20");

  const { data, isPending, isFetched } = useQuery({
    queryKey: ["jobs"],
    queryFn: () => getJobAdverts(page, limit),
  });

  const { mutate } = useMutation({
    mutationFn: () =>
      getJobAdverts(data?.pageable?.pageNumber + 1, data?.pageable?.pageSize),
    onSuccess: (data) =>
      queryClient.setQueryData(["jobs"], (previous: any) => {
        return { ...data, content: [...previous.content, ...data.content] };
      }),
  });

  return (
    <div className="mt-8 flex flex-col items-center">
      <h2 className="mb-5 w-full text-2xl font-bold">
        {data?.totalElements || 0} total jobs
      </h2>

      <div className="mb-5 flex w-full flex-col items-center space-y-4">
        {isPending ? (
          <ImSpinner8 className="animate-spin fill-blue-600 text-2xl" />
        ) : (
          data?.content?.map((job: Job, i: number) => (
            <JobAdvert job={job} key={i} />
          ))
        )}
      </div>

      {isFetched ? (
        <SecondaryButton onClick={() => mutate()}>Load More</SecondaryButton>
      ) : (
        <></>
      )}
    </div>
  );
}

// const job = {
//   logo: rooster,
//   title: "Accounts Executive / Bookkeeper in a Export Business",
//   companyName: "D&R Exports (Pty) Ltd",
//   classification: "Accounting",
//   subClassification: "Accounts Officers/Clerks",
//   type: "Full-Time",
//   location: "Wellampitiya, Sri Lanka",
//   salary: { min: 40000, max: 50000, currency: "LKR", paidEvery: "Month" },
//   postedDate: "21/05/24",
//   jobUrl: "example.com",
//   companyUrl: "example.com",
// } as const;
// const getJobAdverts = useGetJobAdverts();
