import searchIcon from "../../../assets/search-icon.svg";
import locationIcon from "../../../assets/location-icon.svg";
import Dropdown from "../../../components/inputs/Dropdown";
import CallToAction from "../../../components/buttons/CallToAction";

export default function JobSearchInput() {
  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const formData = new FormData(event.currentTarget);
    for (const [key, value] of formData.entries()) {
      console.log(`${key}: ${value}`);
    }
  };
  return (
    <form
      onSubmit={handleSubmit}
      className="w-full rounded-md border border-solid border-gray-200 bg-white shadow-[0px_8px_20px_#0c4bb51f]"
    >
      <div className="grid w-full grid-cols-1 gap-x-3 gap-y-4 border-b px-5 py-5 md:grid-cols-[repeat(2,1fr)] md:grid-rows-2 md:gap-y-8 lg:grid-cols-[1fr_1fr_auto] lg:grid-rows-1 lg:pb-8">
        <div className="flex items-center border-gray-200 md:pl-4 lg:border-r">
          <img src={searchIcon} className="mr-3 w-5" />
          <input
            type="text"
            name="query"
            placeholder="Job title or keywords"
            className="w-full p-1 text-lg font-[300] text-stone-500 outline-none placeholder:text-slate-300"
          />
          <button
            type="reset"
            className="px-5 text-sm font-medium text-slate-400 "
          >
            Clear
          </button>
        </div>

        <div className="flex items-center md:pl-4">
          <img src={locationIcon} className="mr-4 w-5" />
          <input
            type="text"
            name="location"
            placeholder="Anywhere"
            className="w-full p-1 text-lg font-[300] text-stone-500 outline-none placeholder:text-slate-300"
          />
        </div>

        <CallToAction
          type="submit"
          classname="lg:w-max md:col-span-2 mt-4 md:mt-0 col-span-1 lg:col-span-1"
        >
          Search
        </CallToAction>
      </div>

      <div className="flex justify-between border-t px-3 py-5">
        <div className="flex items-center gap-6">
          <Dropdown displayName="Job Type" />
          <Dropdown displayName="Modality" />
          <Dropdown displayName="Country" />
          <Dropdown displayName="Salary" />
        </div>
        <button className="mr-3 text-sm text-primary">Clear</button>
      </div>
    </form>
  );
}
