import React from "react";
import styled from "styled-components";
import { FaChevronLeft } from "react-icons/fa";
import { useNavigate } from "react-router-dom";

const LevelYear = () => {
  const navigate = useNavigate();

  return (
    <Wrapper>
      <Header>
        <FaChevronLeft style={{ paddingRight: "3px" }} /> 취미선택
      </Header>
      <form>
        <Label htmlFor='year'>테니스를 얼마동안 하셨나요?</Label>
        <Input type='number' min='0' id='year' placeholder='N년차'></Input>
      </form>

      <NextButton onClick={() => navigate("/levelcheck")}>
        레벨 측정 시작
      </NextButton>
    </Wrapper>
  );
};

export default LevelYear;

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

const Label = styled.label`
  font-size: 12px;
  color: rgba(112, 112, 112, 1);
  margin-bottom: 6px;
  display: block;
`;

const Input = styled.input`
  border: none;
  font-size: 24px;
  font-family: inherit;
  &::placeholder {
    color: rgba(219, 219, 219, 1);
  }
`;

const NextButton = styled.button`
  position: absolute;
  bottom: 70px;
  width: 335px;
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
