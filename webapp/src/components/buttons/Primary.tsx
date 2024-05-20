type PrimaryProps = React.PropsWithChildren;

export default function Primary({ children }: PrimaryProps) {
  return (
    <button className="flex px-1 items-center text-stone-950 hover:text-primary drop-shadow-lg">
      {children}
    </button>
  );
}
