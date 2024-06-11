import rooster from "../../../assets/rooster.svg";
import JobAdvert from "./JobAdvert";

export default function SearchResults() {
  const job = {
    logo: rooster,
    title: "Accounts Executive / Bookkeeper in a Export Business",
    companyName: "D&R Exports (Pty) Ltd",
    classification: "Accounting",
    subClassification: "Accounts Officers/Clerks",
    type: "Full-Time",
    location: "Wellampitiya, Sri Lanka",
    salary: { min: 40000, max: 50000, currency: "LKR", paidEvery: "Month" },
    postedDate: "21/05/24",
    jobUrl: "example.com",
    companyUrl: "example.com",
  } as const;

  return (
    <div className="mt-8 ">
      <h2 className="mb-5 text-2xl font-bold">843 total jobs</h2>
      <div className="space-y-4">
        <JobAdvert job={job} />
        <JobAdvert job={job} />
        <JobAdvert job={job} />
      </div>
    </div>
  );
}
