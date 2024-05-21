import { PiCaretDown } from "react-icons/pi";

type DropdownProps = {
  displayName: string;
};

export default function Dropdown({ displayName }: DropdownProps) {
  return (
    <div className="flex items-center justify-between gap-x-2 rounded border border-stone-300 px-4 py-1 text-sm font-medium text-stone-500">
      {displayName} <PiCaretDown />
    </div>
  );
}
