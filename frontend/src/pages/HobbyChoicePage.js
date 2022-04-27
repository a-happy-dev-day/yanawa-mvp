import React, { useState } from "react";
import styled from "styled-components";
import { FaChevronLeft } from "react-icons/fa";
import { useLocation, useNavigate } from "react-router-dom";

const HobbyChoicePage = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const [activeButton, setActiveButton] = useState(1);

  const sports = [
    {
      name: "tennis",
      title: "🎾테니스",
    },
    // {
    //   name: "soccer",
    //   title: "⚽축구",
    // },
    // {
    //   name: "basketball",
    //   title: "🏀농구",
    // },
    // {
    //   name: "golf",
    //   title: "⛳골프",
    // },
  ];

  const changeHandler = (checked) => {
    setActiveButton(!checked);
  };

  const onClickHandler = () => {
    navigate("/levelyear", { state: location.state });
  };

  const onClickHeaderHandler = () => {
    navigate(-1);
  };
  return (
    <Wrapper>
      <Header onClick={onClickHeaderHandler}>
        <FaChevronLeft style={{ paddingRight: "3px" }} /> 취미선택
      </Header>
      <Title>매칭받고 싶은 취미를 선택해 주세요! (1가지)</Title>
      <form>
        {sports.map((data, index) => (
          <div key={index}>
            <Input
              onChange={(e) => {
                changeHandler(e.currentTarget.checked);
              }}
              type='radio'
              id={data.name}
              name='hobby'
            />
            <Label htmlFor={data.name}>{data.title}</Label>
          </div>
        ))}
      </form>

      <NextButton disabled={activeButton} onClick={onClickHandler}>
        레벨 측정 시작
      </NextButton>
    </Wrapper>
  );
};

export default HobbyChoicePage;

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

const Title = styled.div`
  font-size: 12px;
  color: rgba(112, 112, 112, 1);
  margin-bottom: 44px;
`;

const Label = styled.label`
  display: block;
  text-align: center;
  background-color: transparent;
  cursor: pointer;
  border: 1px solid rgba(68, 68, 68, 1);
  font-size: 14px;
  font-family: inherit;
  padding: 14px 0 13px;
  border-radius: 22px;
  margin-bottom: 10px;
  &:hover {
    background-color: rgba(0, 39, 253, 1);
    color: #fff;
  }
`;

const Input = styled.input`
  display: none;
  &:checked + ${Label} {
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
  transition: all 0.7s ease;
  &:disabled {
    background-color: #999;
  }
`;
