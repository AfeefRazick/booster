import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Provider from "./Provider";
import Layout from "./components/layout/Layout";
import Home from "./pages/Home/Home";
import CreateJob from "./pages/CreateJob/CreateJob";
import CreateAccount from "./pages/CreateAccount/CreateAccount";
import AdminLayout from "./pages/AdminLayout/AdminLayout";
import Jobs from "./pages/Jobs/Jobs";

const router = createBrowserRouter([
  {
    element: <Layout />,
    children: [
      {
        path: "/",
        element: <Home />,
      },
      {
        path: "/admin",
        element: <AdminLayout />,
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
  { path: "/create-account", element: <CreateAccount /> },
]);

function App() {
  return (
    <Provider>
      <RouterProvider router={router}></RouterProvider>
    </Provider>
  );
}

export default App;
