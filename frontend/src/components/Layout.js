import React from "react";
import { Container } from "react-bootstrap";
import { Outlet } from "react-router-dom";
import Footer from "./Footer";
import Header from "./Header";

const Layout = () => {
  return (
    <div>
      <Header></Header>
      <Container>
        <Outlet />
      </Container>
      <Footer></Footer>
    </div>
  );
};

export default Layout;
