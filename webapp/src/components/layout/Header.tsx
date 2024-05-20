import Hamburger from "hamburger-react";
import CallToAction from "../buttons/CallToAction";
import Primary from "../buttons/Primary";
import Logo from "./Logo";
import { useState } from "react";
import clsx from "clsx";

export default function Header() {
  const [isOpen, setIsOpen] = useState(false);

  return (
    <>
      <Overlay isOpen={isOpen} />

      <header className="h-20 relative shadow w-full flex items-center justify-center">
        <nav className="z-20 w-full px-6 sm:px-[5%] bg-white h-full flex items-center justify-between">
          <div className="flex items-center">
            <Logo />
            <div className="lg:hidden">
              <Hamburger toggled={isOpen} toggle={setIsOpen} size={20} />
            </div>
          </div>

          <div className="gap-4 items-center hidden md:flex">
            <Primary>
              <span className="text-2xl mr-1">+ </span> Post a job
            </Primary>
            <Primary>Sign in</Primary>
            <CallToAction>Register now</CallToAction>
          </div>
        </nav>
        <Dropdown isOpen={isOpen} />
      </header>
    </>
  );
}

function Overlay({ isOpen }: { isOpen: boolean }) {
  return (
    <div
      className={clsx(
        "absolute w-screen lg:hidden duration-300 delay-75 h-screen transition-opacity opacity-0 bg-black",
        { "opacity-40": isOpen }
      )}
    />
  );
}

function Dropdown({ isOpen }: { isOpen: boolean }) {
  return (
    <nav
      className={clsx(
        "w-full p-6 transition-all ease-out z-10 h-60 bg-slate-100 absolute lg:hidden",
        {
          "-top-40": !isOpen,
          "top-20": isOpen,
        }
      )}
    >
      <div className="gap-3 items-start flex flex-col">
        <Primary>
          <span className="text-2xl mr-1">+ </span> Post a job
        </Primary>
        <Primary>Sign in</Primary>
        <CallToAction>Register now</CallToAction>
      </div>
    </nav>
  );
}
