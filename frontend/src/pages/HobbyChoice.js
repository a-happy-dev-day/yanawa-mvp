import React from "react";
import styled from "styled-components";
import { FaChevronLeft } from "react-icons/fa";
import { useNavigate } from "react-router-dom";

const HobbyChoice = () => {
  const navigate = useNavigate();
  return (
    <Wrapper>
      <Header>
        <FaChevronLeft style={{ paddingRight: "3px" }} /> 취미선택
      </Header>
      <Title>매칭받고 싶은 취미를 선택해 주세요! (1가지)</Title>
      <Button>🎾테니스</Button>
      <Button>⚽축구</Button>
      <Button>🏀테니스</Button>
      <Button>⛳골프</Button>
      <NextButton onClick={() => navigate("/levelyear")}>
        레벨 측정 시작
      </NextButton>
    </Wrapper>
  );
};

export default HobbyChoice;

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
  padding: 22px 0 22px;
  font-size: 14px;
  line-height: 1.2;
  margin-bottom: 44px;
  display: flex;
  align-items: center;
`;

const Title = styled.div`
  font-size: 12px;
  color: rgba(112, 112, 112, 1);
  margin-bottom: 44px;
`;

const Button = styled.button`
  width: 100%;
  background-color: transparent;
  cursor: pointer;
  border: 1px solid rgba(68, 68, 68, 1);
  font-size: 14px;
  font-family: inherit;
  padding: 12px 0 11px;
  border-radius: 22px;
  margin-bottom: 10px;
  &:hover {
    background-color: rgba(0, 39, 253, 1);
    color: #fff;
  }
`;

const NextButton = styled.button`
  position: absolute;
  bottom: 70px;
  left: 20px;
  width: 335px;
  background-color: transparent;
  cursor: pointer;
  border: none;
  background-color: rgba(52, 58, 64, 1);
  font-size: 14px;
  font-family: inherit;
  padding: 15px 0 14px;
  border-radius: 10px;
  color: #fff;
  margin-top: 324px;
`;
