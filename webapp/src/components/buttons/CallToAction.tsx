type CallToActionProps = React.PropsWithChildren;

export default function CallToAction({ children }: CallToActionProps) {
  return (
    <button className="bg-primary px-4 font-medium py-2 drop-shadow-md rounded text-white">
      {children}
    </button>
  );
}
