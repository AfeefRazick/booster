type PrimaryProps = React.PropsWithChildren;

export default function Primary({ children }: PrimaryProps) {
  return (
    <button className="flex items-center text-stone-950 drop-shadow-lg hover:text-primary">
      {children}
    </button>
  );
}
