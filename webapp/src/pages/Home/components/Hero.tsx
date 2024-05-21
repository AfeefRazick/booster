import JobSearchInput from "./JobSearchInput";

export default function Hero() {
  return (
    <div>
      <h1 className="mb-20 max-w-2xl text-5xl font-semibold text-stone-800">
        Find your dream job or let companies find you
      </h1>

      <JobSearchInput />
    </div>
  );
}
