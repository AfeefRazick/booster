import cn from "../../utils/cn";

type SecondaryProps = React.PropsWithChildren &
  React.ComponentProps<"button"> & {
    classname?: string;
  };

export default function SecondaryButton({
  children,
  classname,
  ...props
}: SecondaryProps) {
  return (
    <button
      {...props}
      className={cn(
        "flex items-center justify-between gap-x-2 rounded border border-stone-300 px-4 py-1 text-sm font-medium text-stone-600",
        classname,
      )}
    >
      {children}
    </button>
  );
}
