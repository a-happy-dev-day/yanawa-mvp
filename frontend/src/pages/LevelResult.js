import React, { useState } from "react";
import styled from "styled-components";
import { FaChevronLeft } from "react-icons/fa";
import level1 from "../assets/image/level1.png";
// import { useNavigate } from "react-router-dom";

const LevelResult = () => {
  return (
    <div>
      {" "}
      <Wrapper>
        <Header>
          <FaChevronLeft style={{ paddingRight: "3px" }} /> 측정 결과 확인
        </Header>
        <Main>
          <MainTitle>
            테린이 님의
            <br /> 테니스 레벨은 1.0입니다
          </MainTitle>
          <LevelImg src={level1} alt='level'></LevelImg>
          <Title>매칭을 통해 꾸준히 당신의 레벨을 올려보세요</Title>
        </Main>
        <NextButton>시작하기</NextButton>
      </Wrapper>
    </div>
  );
};

export default LevelResult;

const Wrapper = styled.div`
  position: relative;
  font-family: "Noto Sans KR", sans-serif;
  box-sizing: border-box;
  background-color: #fff;
  width: 375px;
  height: 812px;
  margin-top: 40px;
  padding: 0 20px 0;
`;

const Header = styled.header`
  display: flex;
  position: absolute;
  padding: 22px 0 22px;
  font-size: 14px;
  line-height: 1.2;
  margin-bottom: 44px;
  align-items: center;
`;

const Main = styled.div`
  display: flex;
  align-items: center;
  flex-direction: column;
  padding-top: 250px;
  height: 100%;
`;

const MainTitle = styled.p`
  text-align: center;
  margin-bottom: 40px;
  font-size: 18px;
  line-height: 1.4;
  font-weight: 500;
`;

const LevelImg = styled.img`
  margin-bottom: 220px;
`;

const Title = styled.div`
  margin-bottom: 44px;
  font-size: 12px;
  color: rgba(112, 112, 112, 1);
`;

const NextButton = styled.button`
  position: absolute;
  bottom: 70px;
  left: 20px;
  width: 335px;
  background-color: transparent;
  cursor: pointer;
  border: none;
  background-color: #0027fd;
  font-size: 14px;
  font-family: inherit;
  padding: 15px 0 14px;
  border-radius: 10px;
  color: #fff;
  transition: all 0.7s ease;
  &:disabled {
    background-color: #999;
  }
`;
