import React, { useState } from "react";
import styled from "styled-components";
import { FaChevronLeft } from "react-icons/fa";
import { useNavigate } from "react-router-dom";

const RegisterPage = () => {
  const navigate = useNavigate();
  const [activeButton, setActiveButton] = useState(0);
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [registerStep, setRegisterStep] = useState(0);
  const [nickname, setNickname] = useState("");
  const [sex, setSex] = useState("");
  const [birth, setBirth] = useState("");

  const onChangeEmailHandler = (Event) => {
    setEmail(Event.currentTarget.value);
  };

  const onChangePasswordHandler = (Event) => {
    setPassword(Event.currentTarget.value);
  };

  const onChangeConfirmPassworHandler = (Event) => {
    setConfirmPassword(Event.currentTarget.value);
  };

  const onChangeNicknameHandler = (Event) => {
    setNickname(Event.currentTarget.value);
  };

  const onChangeSexHandler = (Event) => {
    setSex(Event.currentTarget.value);
  };

  const onChangeBirthHandler = (Event) => {
    setBirth(Event.currentTarget.value);
    console.log(Event.currentTarget.value);
  };

  const onClickHandler = () => {
    if (registerStep < 3) {
      setRegisterStep(registerStep + 1);
    } else {
      navigate("/hobbychoice", {
        state: {
          email: email,
          password: password,
          sex: sex,
          birth: birth,
          nickname: nickname,
        },
      });
    }
  };

  if (registerStep === 0) {
    return (
      <Wrapper>
        <Header>
          <FaChevronLeft style={{ paddingRight: "3px" }} /> 기본정보
        </Header>
        <form style={{ display: "flex", flexDirection: "column" }}>
          <label htmlFor='email'>이메일을 입력해주세요.</label>
          <input
            id='email'
            type='email'
            value={email}
            onChange={onChangeEmailHandler}
          ></input>
          <label htmlFor='password'>비밀번호를 입력해주세요.</label>
          <input
            id='password'
            type='password'
            value={password}
            onChange={onChangePasswordHandler}
          ></input>
          <label htmlFor='confirmPassword'>비빌번호 확인</label>
          <input
            id='confirmPassword'
            type='password'
            value={confirmPassword}
            onChange={onChangeConfirmPassworHandler}
          ></input>
        </form>
        <NextButton disabled={activeButton} onClick={onClickHandler}>
          레벨 측정 시작
        </NextButton>
      </Wrapper>
    );
  } else if (registerStep === 1) {
    return (
      <Wrapper>
        <Header>
          <FaChevronLeft style={{ paddingRight: "3px" }} /> 기본정보
        </Header>
        <form style={{ display: "flex", flexDirection: "column" }}>
          <label htmlFor='nickname'>닉네임을 입력해주세요!</label>
          <input
            id='nickname'
            type='text'
            value={nickname}
            onChange={onChangeNicknameHandler}
          ></input>
        </form>
        <NextButton disabled={activeButton} onClick={onClickHandler}>
          레벨 측정 시작
        </NextButton>
      </Wrapper>
    );
  } else if (registerStep === 2) {
    return (
      <Wrapper>
        <Header>
          <FaChevronLeft style={{ paddingRight: "3px" }} /> 기본정보
        </Header>
        <form style={{ display: "flex", flexDirection: "column" }}>
          <label htmlFor='sex'>성별을 선택해 주세요!</label>
          <input
            id='male'
            type='radio'
            name='sex'
            value='남성'
            onChange={onChangeSexHandler}
          ></input>
          <label htmlFor='male'>남성</label>
          <input
            id='female'
            type='radio'
            name='sex'
            value='여성'
            onChange={onChangeSexHandler}
          ></input>
          <label htmlFor='female'>여성</label>
        </form>
        <NextButton disabled={activeButton} onClick={onClickHandler}>
          레벨 측정 시작
        </NextButton>
      </Wrapper>
    );
  } else if (registerStep === 3) {
    return (
      <Wrapper>
        <Header>
          <FaChevronLeft style={{ paddingRight: "3px" }} /> 기본정보
        </Header>
        <form style={{ display: "flex", flexDirection: "column" }}>
          <label htmlFor='birth'>생년월일을 알려주세요!</label>
          <input
            id='birth'
            type='date'
            value={birth}
            onChange={onChangeBirthHandler}
            placeholder='YYYY/MM/DD'
          ></input>
        </form>
        <NextButton disabled={activeButton} onClick={onClickHandler}>
          레벨 측정 시작
        </NextButton>
      </Wrapper>
    );
  }
};

export default RegisterPage;

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
