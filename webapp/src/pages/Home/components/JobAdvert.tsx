import { AiOutlineDollar } from "react-icons/ai";
import { Job, Salary } from "../../../types/Job";
import jobTypeIcon from "../../../assets/job-type-icon.svg";
import locationIcon from "../../../assets/location-icon.svg";
import verifyIcon from "../../../assets/verify-badge.svg";
import { capitalize, dateToStringMMDDYYYY } from "../../../utils/common";

type JobProps = {
  job: Job;
};

export default function JobAdvert({ job }: JobProps) {
  return (
    <div className="flex w-full flex-col items-start rounded-md border border-gray-200 p-6 shadow-[0px_5px_20px_#0c4bb50f]">
      <div className="flex">
        <img src={job.logo} className="mr-5 h-11 w-11" />
        <div className="flex flex-col items-start gap-3 font-medium">
          <a
            href={`rooster.jobs/job/${job.id}`}
            className="text-lg leading-none text-stone-800 decoration-1 hover:font-semibold hover:underline"
          >
            <h5>{job.title}</h5>
          </a>
          <a
            href={job.companyUrl}
            className="flex text-sm text-accent hover:font-semibold hover:underline"
          >
            <h6>{job.companyName} </h6>
            <img src={verifyIcon} alt="Verified" />
          </a>
        </div>
      </div>

      <p className="py-3 text-sm">
        {job.classification} {">"} {job.subClassification}
      </p>

      <div className="flex flex-wrap gap-4 pb-4">
        <JobInfo icon={<img src={jobTypeIcon} />} text={capitalize(job.type)} />
        <JobInfo icon={<img src={locationIcon} />} text={job.location} />

        <JobInfo
          icon={<AiOutlineDollar />}
          text={buildSalaryText(job.salary)}
        />
      </div>

      <p className="text-sm text-stone-400">
        Posted on {dateToStringMMDDYYYY(new Date(job.postedDate))}
      </p>
    </div>
  );
}

type JobInfoProps = { icon: JSX.Element; text: string };

function JobInfo({ icon, text }: JobInfoProps) {
  return (
    <div className="flex items-center gap-2.5 text-gray-400">
      {icon}
      <p className="text-sm font-normal">{text}</p>
    </div>
  );
}

function buildSalaryText(salary: Salary) {
  return `${salary.currency} ${salary.min.toLocaleString()} - ${salary.max.toLocaleString()}/${salary.paidEvery.toLowerCase()}`;
}
