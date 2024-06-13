import { QueryClient, QueryClientProvider } from "@tanstack/react-query";

const queryClient = new QueryClient();

function Provider({ children }: React.PropsWithChildren) {
  return (
    <>
      {/* providers nested */}
      <QueryClientProvider client={queryClient}>{children}</QueryClientProvider>
    </>
  );
}
export default Provider;
