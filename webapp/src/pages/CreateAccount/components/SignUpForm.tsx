import { Button, Input } from "antd";
import { FormEvent } from "react";

export default function SignUpForm() {
  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const formData = new FormData(event.currentTarget);
    const data = Object.fromEntries(formData.entries());
    console.log(data);
  };

  return (
    <form onSubmit={handleSubmit} className="w-full font-manrope space-y-6">
      <div className="flex gap-10 font-light">
        <div className="w-1/2">
          <h6 className="pb-2 text-stone-600">First name</h6>
          <Input name="fname" size="large" className="w-full" />
        </div>
        <div className="w-1/2">
          <h6 className="pb-2 text-stone-600">Last name</h6>
          <Input name="lname" size="large" className="w-full" />
        </div>
      </div>
      <div>
        <h6 className="pb-2 text-stone-600">Work email address</h6>
        <Input name="email" size="large" className="w-full" />
      </div>
      <div>
        <h6 className="pb-2 text-stone-600">Phone</h6>
        <Input name="phone" size="large" className="w-full" />
      </div>
      <div>
        <h6 className="pb-2 text-stone-600">Company Name</h6>
        <Input name="company" size="large" className="w-full" />
      </div>
      <div>
        <h6 className="pb-2 text-stone-600">Set your password</h6>
        <Input.Password name="password" size="large" className="w-full" />
      </div>

      <Button className="bg-accent text-white" htmlType="submit" size="large" block >Get started</Button>
      <div className="flex justify-center">
        <p>Already using Rooster? </p><a href="/sign-in" className="ml-1 font-semibold text-accent"> Sign in here</a>
      </div>

    </form>
  );
}
