import LogoBanner from "../../components/layout/LogoBanner";

export default function SignIn() {
  return (
    <>
      <LogoBanner />
      <div className="flex flex-col items-center justify-center">
        <h2 className="font-manrope text-3xl font-medium">Welcome back!</h2>
      </div>
    </>
  );
}
