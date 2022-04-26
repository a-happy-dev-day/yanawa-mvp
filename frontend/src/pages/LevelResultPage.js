import React from "react";
import styled from "styled-components";
import { FaChevronLeft } from "react-icons/fa";
import { useLocation, useNavigate } from "react-router-dom";
import { resultData } from "../assets/data/resultdata";

const LevelResultPage = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const level = location.state.level;

  console.log(location.state);

  return (
    <div>
      {" "}
      <Wrapper>
        <Header>
          <FaChevronLeft style={{ paddingRight: "3px" }} /> 측정 결과 확인
        </Header>
        <Main>
          <MainTitle>
            {location.state.nickname} 님의
            <br />
            {resultData[level - 1].level}
          </MainTitle>
          <LevelImg src={resultData[level - 1].image} alt='level'></LevelImg>
          <Title>매칭을 통해 꾸준히 당신의 레벨을 올려보세요</Title>
        </Main>
        <NextButton
          onClick={() => {
            navigate("/home");
          }}
        >
          시작하기
        </NextButton>
        <BgStyle backgroundColor={resultData[level - 1].color} />
      </Wrapper>
    </div>
  );
};

export default LevelResultPage;

const Wrapper = styled.div`
  position: relative;
  font-family: "Noto Sans KR", sans-serif;
  box-sizing: border-box;
  background-color: #fff;
  width: 375px;
  height: 812px;
  margin-top: 40px;
  padding: 0 20px 0;
  overflow: hidden;
  z-index: -20;
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

const BgStyle = styled.div`
  width: 488px;
  height: 860px;
  border-bottom-left-radius: 311px;
  border-bottom-right-radius: 311px;
  position: absolute;
  top: -471px;
  left: -56.5px;
  background-color: ${(props) => props.backgroundColor};
  z-index: -10;
`;
