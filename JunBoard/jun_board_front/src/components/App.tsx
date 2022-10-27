import React from "react";
import { Route, Routes } from "react-router-dom";
import PostList from "./components/PostList/PostList";
import Register from "./components/Register/Register";

function App() {
  return (
    <Routes>
      <Route index element={<PostList />} />
      <Route path="/register" element={<Register />} />
    </Routes>
  );
}

export default App;
