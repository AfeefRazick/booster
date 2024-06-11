import JobSearchInput from "./components/JobSearchInput";
import SearchResults from "./components/SearchResults";

export default function Home() {
  return (
    <>
      <div className="absolute right-0 top-0 -z-10 h-[400px] w-screen bg-slate-50" />

      <h1 className="mb-20 max-w-2xl text-5xl font-semibold text-stone-800">
        Find your dream job or let companies find you
      </h1>

      <JobSearchInput />

      <SearchResults />
    </>
  );
}
