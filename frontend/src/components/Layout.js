import React from "react";
import { Container } from "react-bootstrap";
import { Outlet } from "react-router-dom";
import Footer from "./Footer";
import Header from "./Header";
import styled from "styled-components";

const Layout = () => {
  return (
    <div>
      <Wrapper>
        <Header></Header>
        {/* <Container> */}
        <ContentsBox>
          <Outlet />
        </ContentsBox>
        {/* </Container> */}
        <Footer></Footer>
      </Wrapper>
    </div>
  );
};

export default Layout;

const Wrapper = styled.div`
  font-family: "Noto Sans KR", sans-serif;
  display: flex;
  flex-direction: column;
  align-items: center;
  box-sizing: border-box;
  position: relative;
  background-color: #fff;
  width: 375px;
  height: 812px;
  margin-top: 40px;
  padding: 0 20px 0;
`;

const ContentsBox = styled.div`
  overflow: auto;
`;
