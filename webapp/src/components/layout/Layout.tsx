import { Outlet } from "react-router-dom";
import Header from "./Header";

export default function Layout() {
  return (
    <>
      <Header />
      <main className="w-full px-5 py-16 sm:px-[5%]">
        <Outlet />
      </main>
    </>
  );
}
