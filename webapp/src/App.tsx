import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Provider from "./Provider";
import Layout from "./components/layout/Layout";
import Home from "./pages/Home/Home";

const router = createBrowserRouter([
  {
    element: <Layout />,
    children: [
      {
        path: "/",
        element: <Home />,
      },
    ],
  },
]);

function App() {
  return (
    <Provider>
      <RouterProvider router={router}></RouterProvider>
    </Provider>
  );
}

export default App;
