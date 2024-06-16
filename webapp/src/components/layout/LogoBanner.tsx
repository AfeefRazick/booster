import Logo from "./Logo";

export default function LogoBanner() {
  return (
    <header className="fixed top-0 flex h-14 w-full items-center justify-center border-y border-slate-200">
      <Logo className="text-[22px]" />
    </header>
  );
}
