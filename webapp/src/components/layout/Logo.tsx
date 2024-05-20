import rooster from "../../assets/rooster.svg";

export default function Logo() {
  return (
    <div className="flex items-center justify-center">
      <img src={rooster} className="" />
      <h2 className="text-3xl lg:block hidden mt-0.5 ml-0.5 font-semibold">
        ROOSTER
      </h2>
    </div>
  );
}
