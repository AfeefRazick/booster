import rooster from "../../assets/rooster.svg";

export default function Logo() {
  return (
    <div className="flex items-center justify-center">
      <img src={rooster} />
      <h2 className="ml-0.5 mt-0.5 hidden text-3xl font-semibold lg:block">
        ROOSTER
      </h2>
    </div>
  );
}
