import rooster from "../../assets/rooster.svg";
import cn from "../../utils/cn";

type LogoProps = React.PropsWithChildren &
  React.ComponentProps<"h2"> & {
    responsive?: boolean;
    className?: string;
  };

export default function Logo({ responsive, className }: LogoProps) {
  return (
    <a href="/jobs" className="flex items-center justify-center">
      <img src={rooster} />
      <h2
        className={cn(
          "ml-0.5 mt-0.5 font-semibold",
          {
            "hidden lg:block": responsive,
          },
          className,
        )}
      >
        ROOSTER
      </h2>
    </a>
  );
}
