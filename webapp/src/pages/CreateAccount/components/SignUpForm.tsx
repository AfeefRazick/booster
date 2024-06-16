import { Input } from "antd";

export default function SignUpForm() {
  return (
    <form className="w-full">
      <div className="font-manrope flex gap-10 font-light">
        <div className="w-1/2">
          <h6 className="pb-2 text-stone-600">First name</h6>
          <Input size="large" className="w-full" />
        </div>
        <div className="w-1/2">
          <h6 className="pb-2 text-stone-600">Last name</h6>
          <Input size="large" className="w-full" />
        </div>
      </div>
    </form>
  );
}
