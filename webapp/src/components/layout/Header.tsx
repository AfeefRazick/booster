import Hamburger from "hamburger-react";
import CallToAction from "../buttons/CallToAction";
import Primary from "../buttons/Primary";
import Logo from "./Logo";
import { useState } from "react";
import clsx from "clsx";

export default function Header() {
  const [isOpen, setIsOpen] = useState(false);

  const closeDropdown = () => setIsOpen(false);

  return (
    <>
      <Overlay isOpen={isOpen} onClick={closeDropdown} />

      <header className="relative flex h-20 w-full items-center justify-center shadow-sm">
        <nav className="z-20 flex h-full w-full items-center justify-between bg-white px-6 sm:px-[5%]">
          <div className="flex items-center">
            <Logo responsive={true} className="text-[26px]" />
            <div className="lg:hidden">
              <Hamburger toggled={isOpen} toggle={setIsOpen} size={20} />
            </div>
          </div>

          <div className="hidden items-center gap-4 md:flex">
            <Primary>
              <span className="mr-1 text-2xl">+ </span> Post a job
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

function Overlay({
  isOpen,
  onClick,
}: {
  isOpen: boolean;
  onClick: () => void;
}) {
  return (
    <div
      onClick={onClick}
      className={clsx(
        "absolute w-screen bg-black transition-all delay-75 duration-300 lg:hidden",
        { "h-screen opacity-40": isOpen, "h-0 opacity-0 ": !isOpen },
      )}
    />
  );
}

function Dropdown({ isOpen }: { isOpen: boolean }) {
  return (
    <nav
      className={clsx(
        "absolute z-10 h-60 w-full bg-slate-100 p-6 transition-all ease-out lg:hidden",
        {
          "-top-40": !isOpen,
          "top-20": isOpen,
        },
      )}
    >
      <div className="flex flex-col items-start gap-3">
        <Primary>
          <span className="mr-1 text-2xl">+ </span> Post a job
        </Primary>
        <Primary>Sign in</Primary>
        <CallToAction>Register now</CallToAction>
      </div>
    </nav>
  );
}
