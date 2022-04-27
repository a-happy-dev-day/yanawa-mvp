import React, { useState, useRef } from "react";
import styled from "styled-components";
import { FaChevronLeft } from "react-icons/fa";
import { useLocation, useNavigate } from "react-router-dom";
import { LevelCheckData } from "../assets/data/levelcheckdata";

const LevelCheckPage = () => {
  const [levelCheckNum, setLevelCheckNum] = useState(0);
  const [activeButton, setActiveButton] = useState(1);
  const [levelScore, setLevelScore] = useState(0);
  const levelScoreTotal = useRef(0);
  const navigate = useNavigate();
  const location = useLocation();

  const changeHandler = (checked, grade) => {
    setActiveButton(!checked);
    setLevelScore(grade);
  };

  const clickNextButton = () => {
    levelScoreTotal.current += Number(levelScore);
    const everage = levelScoreTotal.current / 4;
    let level = 0;
    if (everage < 2) {
      level = 1;
    } else if (everage < 3) {
      level = 2;
    } else if (everage < 4) {
      level = 3;
    } else if (everage < 5) {
      level = 4;
    } else if (everage < 6) {
      level = 5;
    } else if (everage >= 6) {
      level = 6;
    }

    if (LevelCheckData.length !== levelCheckNum + 1) {
      setLevelCheckNum(levelCheckNum + 1);
    } else {
      navigate("/levelresult", {
        state: {
          email: location.state.email,
          password: location.state.password,
          sex: location.state.sex,
          birth: location.state.birth,
          nickname: location.state.nickname,
          year: location.state.year,
          level: level,
        },
      });
    }
  };
  const onClickHeaderHandler = () => {
    navigate(-1);
  };

  return (
    <Wrapper>
      <Header onClick={onClickHeaderHandler}>
        <FaChevronLeft style={{ paddingRight: "3px" }} /> 레벨 측정(
        {LevelCheckData[levelCheckNum].title})
      </Header>
      <Title>
        나의 {LevelCheckData[levelCheckNum].title} 실력은 어느정도 인가요?
      </Title>
      <CheckListForm>
        <form>
          {LevelCheckData[levelCheckNum].level.map((data, index) => (
            <div key={index}>
              <Input
                id={index}
                type='radio'
                name='check'
                data-grade={data.grade}
                onChange={(e) => {
                  changeHandler(
                    e.currentTarget.checked,
                    e.target.dataset.grade
                  );
                }}
              ></Input>
              <Label htmlFor={index}>{data.desc}</Label>
            </div>
          ))}
        </form>
      </CheckListForm>

      <NextButton disabled={activeButton} onClick={clickNextButton}>
        다음으로 ({levelCheckNum + 2}/5)
      </NextButton>
    </Wrapper>
  );
};

export default LevelCheckPage;

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

const CheckListForm = styled.div`
  overflow: scroll;
  height: 500px;
  -ms-overflow-style: none; /* IE and Edge */
  scrollbar-width: none; /* Firefox */
  &::-webkit-scrollbar {
    display: none;
  }
`;

const Label = styled.label`
  position: relative;
  box-sizing: border-box;
  display: flex;
  align-items: center;
  height: 70px;
  text-align: left;
  background-color: rgba(235, 236, 237, 1);
  cursor: pointer;
  border: none;
  font-size: 12px;
  font-family: inherit;
  padding: 0 46px;
  border-radius: 10px;
  margin-bottom: 10px;
  line-height: 1.5;
  color: rgba(112, 112, 112, 1);
  &::before {
    position: absolute;
    left: 20px;
    width: 10px;
    height: 10px;
    border: 2px solid rgba(0, 39, 253, 1);
    content: " ";
    border-radius: 10px;
    margin-right: 10px;
    cursor: pointer;
  }
`;

const Input = styled.input`
  display: none;
  &:checked + ${Label} {
    border: 2px solid #0027fd;
    background-color: #cbd3ff;
  }
  &:checked + ${Label} {
    &::after {
      position: absolute;
      top: 30px;
      left: 24px;
      content: "";
      color: #61768b;
      width: 6px;
      height: 6px;
      background-color: rgba(0, 39, 253, 1);
      border-radius: 5px;
      cursor: pointer;
    }
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
  transition: all 0.7s ease;
  &:disabled {
    background-color: #999;
  }
`;
