import cn from "../../utils/cn";

type CallToActionProps = React.PropsWithChildren &
  React.ComponentProps<"button"> & {
    className?: string;
  };

export default function CallToAction({
  children,
  className,
  ...props
}: CallToActionProps) {
  return (
    <button
      {...props}
      className={cn(
        "rounded bg-primary px-4 py-2 font-medium text-white drop-shadow-md",
        className,
      )}
    >
      {children}
    </button>
  );
}
