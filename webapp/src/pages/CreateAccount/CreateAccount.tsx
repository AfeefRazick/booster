import LogoBanner from "../../components/layout/LogoBanner";
import SignUpForm from "./components/SignUpForm";

export default function CreateAccount() {
  return (
    <>
      <LogoBanner />
      <div className="mx-auto flex w-96 flex-col items-center justify-center pb-16 pt-32">
        <h2 className="font-manrope pb-4 text-[32px] font-bold">
          Get started with Rooster
        </h2>
        <p className="font-manrope pb-10 text-center font-thin">
          Hire and manage all your employees from one single platfrom
        </p>

        <SignUpForm />
      </div>
    </>
  );
}
