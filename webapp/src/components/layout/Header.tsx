import Hamburger from "hamburger-react";
import CallToAction from "../buttons/CallToAction";
import Primary from "../buttons/Primary";
import Logo from "./Logo";

export default function Header() {
  return (
    <header className="h-20 shadow w-full px-6 flex items-center justify-center">
      <nav className="max-w-5xl w-full sm:w-11/12 flex items-center justify-between">
        <div className="flex items-center">
          <Logo />
          <div className="lg:hidden">
            <Hamburger size={20} />
          </div>
        </div>

        <div className="gap-3 items-center hidden md:flex">
          <Primary>
            <span className="text-2xl mr-1">+ </span> Post a job
          </Primary>
          <Primary>Sign in</Primary>
          <CallToAction>Register now</CallToAction>
        </div>
      </nav>
    </header>
  );
}
