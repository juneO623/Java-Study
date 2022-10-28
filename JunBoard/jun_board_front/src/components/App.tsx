import React from "react";
import { Route, Routes } from "react-router-dom";
import Nav from "./common/Nav/Nav";
import PostList from "./PostList/PostList";
import Register from "./Register/Register";

function App() {
  return (
    <>
      <Routes>
        <Route index element={<PostList />} />
        <Route path="/register" element={<Register />} />
      </Routes>
    </>
  );
}

export default App;
