import React, { useState } from "react";
import styled from "styled-components";
import { FaChevronLeft } from "react-icons/fa";
import { useLocation, useNavigate } from "react-router-dom";

const LevelYearPage = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const [activeButton, setActiveButton] = useState(1);
  const [year, setYear] = useState();

  const changeHandler = (value) => {
    setYear(value);
    if (value.length > 0) {
      setActiveButton(0);
    } else {
      setActiveButton(1);
    }
  };

  const onClickHandler = () => {
    navigate("/levelcheck", {
      state: {
        email: location.state.email,
        password: location.state.password,
        sex: location.state.sex,
        birth: location.state.birth,
        nickname: location.state.nickname,
        year: parseInt(year),
      },
    });
  };

  const onClickHeaderHandler = () => {
    navigate(-1);
  };

  return (
    <Wrapper>
      <Header onClick={onClickHeaderHandler}>
        <FaChevronLeft style={{ paddingRight: "3px" }} /> 취미선택
      </Header>
      <form>
        <Label htmlFor='year'>테니스를 얼마동안 하셨나요?</Label>
        <Input
          onChange={(e) => {
            changeHandler(e.currentTarget.value);
          }}
          value={year}
          type='number'
          min='0'
          id='year'
          placeholder='N년차'
        ></Input>
      </form>

      <NextButton disabled={activeButton} onClick={onClickHandler}>
        다음으로 (1/5)
      </NextButton>
    </Wrapper>
  );
};

export default LevelYearPage;

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
  cursor: pointer;
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
  transition: all 0.7s ease;
  &:disabled {
    background-color: #999;
  }
`;
