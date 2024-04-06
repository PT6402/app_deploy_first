import { Route, Routes } from "react-router-dom";
import { Home, Login, UserPage } from "./pages";

export default function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="/login" element={<Login />}></Route>
        <Route path="/user-page" element={<UserPage />}></Route>
      </Routes>
    </>
  );
}
