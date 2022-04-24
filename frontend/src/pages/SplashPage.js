import React from "react";
import styled from "styled-components";
import logo from "../assets/image/logo1.png";

const SplashPage = () => {
  return (
    <Wrapper>
      <img src={logo} alt='야나와' />
    </Wrapper>
  );
};

export default SplashPage;

const Wrapper = styled.div`
  font-family: "Noto Sans KR", sans-serif;
  display: flex;
  align-items: center;
  justify-content: center;
  box-sizing: border-box;
  background-color: #0027fd;
  width: 375px;
  height: 812px;
  margin-top: 40px;
  padding: 0 20px 0;
`;
