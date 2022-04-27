import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import logo from "../assets/image/logo_blue.png";

const LoginPage = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [errMessage, setErrMessage] = useState("");
  const navigate = useNavigate();

  const onChangeEmailHandler = (Event) => {
    setEmail(Event.currentTarget.value);
    if (errMessage) {
      setErrMessage("");
    }
  };
  const onChangePasswordHandler = (Event) => {
    setPassword(Event.currentTarget.value);
  };

  const onClickSignHandler = () => {
    navigate("/register");
  };

  const onClickHandler = async () => {
    try {
      const res = await fetch("/api/user/login/", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          email: email,
          password: password,
        }),
      });
      const resJson = await res.json();
      console.log(resJson);
      if (resJson.message) {
        setErrMessage(resJson.message);
      } else if (resJson.email) {
        navigate("/main");
      }
    } catch (err) {}
  };
  return (
    <Wrapper>
      <LogoImage src={logo} alt='다나와' />
      <Title>
        정확한 레벨 정보로
        <br />
        다양한 사람을 만나 경기하고
        <br />
        점점 내 레벨을 업 해보세요!
      </Title>

      <form style={{ position: "relative" }}>
        <SignLink type='button' onClick={onClickSignHandler}>
          회원가입
        </SignLink>
        <Input
          value={email}
          onChange={onChangeEmailHandler}
          placeholder='이메일'
          type='email'
        />
        <ErrText>{errMessage}</ErrText>
        <Input
          value={password}
          onChange={onChangePasswordHandler}
          placeholder='비밀번호'
          type='password'
        />
      </form>
      <NextButton onClick={onClickHandler}>로그인</NextButton>
    </Wrapper>
  );
};

export default LoginPage;

const Wrapper = styled.div`
  font-family: "Noto Sans KR", sans-serif;
  display: flex;
  flex-direction: column;
  align-items: center;
  box-sizing: border-box;
  position: relative;
  background-color: #fff;
  width: 375px;
  height: 812px;
  margin-top: 40px;
  padding: 0 20px 0;
`;

const LogoImage = styled.img`
  margin: 280px auto 20px;
`;

const Title = styled.p`
  text-align: center;
  font-size: 15px;
  line-height: 1.5;
  margin-bottom: 150px;
`;

const Input = styled.input`
  border: none;
  width: 100%;
  font-size: 24px;
  line-height: 1.5;
  font-family: inherit;
  font-weight: 700;
  border-bottom: 1px solid #ced4da;
  outline: none;
  transition: all 0.8s ease-in-out;
  margin-bottom: 3px;
  &::placeholder {
    color: rgba(219, 219, 219, 1);
  }
  &:focus {
    border-bottom: 1px solid rgba(0, 39, 253, 1);
  }
  & + & {
    margin-top: 1rem;
  }
`;

const SignLink = styled.button`
  position: absolute;
  border: none;
  cursor: pointer;
  right: 0;
  top: -20px;
  text-decoration: none;
  color: #000;
  background-color: transparent;
`;

const ErrText = styled.p`
  color: red;
  margin-bottom: 6px;
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
