import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Provider from "./Provider";
import Layout from "./components/layout/Layout";
import Home from "./pages/Home/Home";
import Dashboard from "./pages/Dashboard/Dashboard";
import Jobs from "./pages/Jobs/Jobs";
import CreateJob from "./pages/CreateJob/CreateJob";

const router = createBrowserRouter([
  {
    element: <Layout />,
    children: [
      {
        path: "/",
        element: <Home />,
      },
      {
        path: "/dashboard",
        element: <Dashboard />,
        children: [
          {
            path: "hire",
            children: [
              { path: "jobs", element: <Jobs /> },
              { path: "create-job", element: <CreateJob /> },
            ],
          },
        ],
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
