export type Job = {
  logo: string;
  title: string;
  companyName: string;
  classification: string;
  subClassification: string;
  type: JobType;
  location: string;
  salary: Salary;
  postedDate: string;
  jobUrl: string;
  companyUrl: string;
};

type JobType = "Full-Time" | "Part-Time" | "Casual" | "Internship" | "Contract";
type PaidEvery = "Year" | "Month" | "Week" | "Day" | "Hour";

export type Salary = {
  min: number;
  max: number;
  currency: string;
  paidEvery: PaidEvery;
};
