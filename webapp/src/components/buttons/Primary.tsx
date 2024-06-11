type PrimaryProps = React.PropsWithChildren;

export default function Primary({ children }: PrimaryProps) {
  return (
    <button className="flex items-center text-stone-700 hover:text-primary">
      {children}
    </button>
  );
}
