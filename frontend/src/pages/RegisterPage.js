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
        <form id='submit' style={{ display: "flex", flexDirection: "column" }}>
          <Label htmlFor='email'>이메일</Label>
          <Input
            id='email'
            type='email'
            placeholder='이메일'
            value={email}
            onChange={onChangeEmailHandler}
            required
          ></Input>
          <Label htmlFor='password'>비밀번호</Label>
          <Input
            id='password'
            type='password'
            placeholder='비밀번호'
            value={password}
            onChange={onChangePasswordHandler}
            required
          ></Input>
          <Label htmlFor='confirmPassword'>비빌번호 확인</Label>
          <Input
            id='confirmPassword'
            type='password'
            placeholder='비밀번호 확인'
            value={confirmPassword}
            onChange={onChangeConfirmPassworHandler}
            required
          ></Input>
        </form>
        <NextButton
          form='submit'
          disabled={activeButton}
          onClick={onClickHandler}
        >
          다음으로(1/4)
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
          <Label htmlFor='nickname'>닉네임을 입력해주세요!</Label>
          <Input
            id='nickname'
            type='text'
            placeholder='닉네임 입력'
            value={nickname}
            onChange={onChangeNicknameHandler}
          ></Input>
        </form>
        <NextButton disabled={activeButton} onClick={onClickHandler}>
          다음으로(2/4)
        </NextButton>
      </Wrapper>
    );
  } else if (registerStep === 2) {
    return (
      <Wrapper>
        <Header>
          <FaChevronLeft style={{ paddingRight: "3px" }} /> 기본정보
        </Header>
        <Title htmlFor='sex'>성별을 선택해 주세요!</Title>
        <form>
          <RadioInput
            id='male'
            type='radio'
            name='sex'
            value='남성'
            onChange={onChangeSexHandler}
          ></RadioInput>
          <RadioLabel htmlFor='male'>남성</RadioLabel>
          <RadioInput
            id='female'
            type='radio'
            name='sex'
            value='여성'
            onChange={onChangeSexHandler}
          ></RadioInput>
          <RadioLabel htmlFor='female'>여성</RadioLabel>
          <NextButton disabled={activeButton} onClick={onClickHandler}>
            다음으로(3/4)
          </NextButton>
        </form>
      </Wrapper>
    );
  } else if (registerStep === 3) {
    return (
      <Wrapper>
        <Header>
          <FaChevronLeft style={{ paddingRight: "3px" }} /> 기본정보
        </Header>
        <form style={{ display: "flex", flexDirection: "column" }}>
          <Label htmlFor='birth'>생년월일을 알려주세요!</Label>
          <Input
            id='birth'
            type='date'
            value={birth}
            onChange={onChangeBirthHandler}
            placeholder='YYYY/MM/DD'
          ></Input>
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
  margin-bottom: 6px;
`;

const Label = styled.label`
  color: #707070;
  margin-bottom: 6px;
  font-size: 12px;
`;

const Input = styled.input`
  border: none;
  font-size: 24px;
  font-family: inherit;
  margin-bottom: 12px;
  &::placeholder {
    color: rgba(219, 219, 219, 1);
  }
`;
const RadioLabel = styled.label`
  font-size: 24px;
  margin-right: 25px;
  font-weight: 700;
  color: rgba(219, 219, 219, 1);
`;

const RadioInput = styled.input`
  display: none;
  &:checked + ${RadioLabel} {
    color: #343a40;
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
