import React, { useState } from "react";
import styled, { css } from "styled-components";
import { FaChevronLeft } from "react-icons/fa";
import { useNavigate } from "react-router-dom";

const RegisterPage = () => {
  const navigate = useNavigate();
  const [registerStep, setRegisterStep] = useState(0);

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [passwordConfirm, setPasswordConfirm] = useState("");
  const [nickname, setNickname] = useState("");
  const [sex, setSex] = useState("");
  const [birth, setBirth] = useState("");

  const [emailMessage, setEmailMessage] = useState("");
  const [passwordMessage, setPasswordMessage] = useState("");
  const [passwordConfirmMessage, setPasswordConfirmMessage] = useState("");
  const [nicknameMessage, setNicknameMessage] = useState("");

  const [isEmail, setIsEmail] = useState(false);
  const [isPassword, setIsPassword] = useState(false);
  const [isPasswordConfirm, setIsPasswordConfirm] = useState(false);
  const [isNickname, setIsNickname] = useState(false);

  const onChangeEmailHandler = (Event) => {
    const emailCurrent = Event.target.value;
    setEmail(emailCurrent);
    const emailRegex =
      /([\w-.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    if (email.length < 2) {
      setEmailMessage("");
    } else if (!emailRegex.test(emailCurrent)) {
      setEmailMessage("이메일 형식이 틀렸어요! 다시 확인해주세요");
      setIsEmail(false);
    } else {
      setEmailMessage("올바른 이메일 형식이에요");
      setIsEmail(true);
    }
  };

  const onChangePasswordHandler = (Event) => {
    const passwordRegex =
      /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;
    const passwordCurrent = Event.target.value;
    setPassword(passwordCurrent);
    if (password.length < 2) {
      setPasswordMessage("");
    } else if (!passwordRegex.test(passwordCurrent)) {
      setPasswordMessage(
        "숫자+영문자+특수문자 조합으로 8자리 이상 입력해주세요!"
      );
      setIsPassword(false);
    } else {
      setPasswordMessage("안전한 비밀번호입니다");
      setIsPassword(true);
    }
  };

  const onChangeConfirmPassworHandler = (Event) => {
    const passwordConfirmCurrent = Event.target.value;
    setPasswordConfirm(passwordConfirmCurrent);
    if (passwordConfirm.length < 2) {
      setPasswordConfirmMessage("");
    } else if (password === passwordConfirmCurrent) {
      setPasswordConfirmMessage("비밀번호가 동일합니다.");
      setIsPasswordConfirm(true);
    } else {
      setPasswordConfirmMessage("비밀번호가 틀립니다. 다시 확인해주세요");
      setIsPasswordConfirm(false);
    }
  };

  const onChangeNicknameHandler = (Event) => {
    const nicknameCurrent = Event.target.value;
    setNickname(nicknameCurrent);
    if (nicknameCurrent < 2 || nicknameCurrent > 5) {
      setNicknameMessage("2글자 이상 5글자 미만으로 입력해주세요.");
      setIsNickname(false);
    } else {
      setNicknameMessage("올바른 이름 형식입니다 :)");
      setIsNickname(true);
    }
  };

  const onChangeSexHandler = (Event) => {
    setSex(Event.currentTarget.value);
  };

  const onChangeBirthHandler = (Event) => {
    setBirth(Event.currentTarget.value);
    console.log(Event.currentTarget.value);
  };

  const onClickHeaderHandler = () => {
    navigate(-1);
  };

  const onClickHandler = async () => {
    if (registerStep === 0) {
      try {
        const res = await fetch(`/api/user/emails/${email}/exists`);
        const resJson = await res.json();
        if (resJson) {
          setEmailMessage("이미 존재하는 이메일입니다. 다시 확인해주세요");
          setIsEmail(false);
        } else {
          setRegisterStep(registerStep + 1);
        }
      } catch (err) {}
    } else if (registerStep === 1) {
      try {
        const res = await fetch(`/api/user/nicknames/${nickname}/exists`);
        const resJson = await res.json();
        console.log(resJson);
        if (resJson) {
          setNicknameMessage("이미 존재하는 닉네임입니다. 다시 확인해주세요");
          setIsNickname(false);
        } else {
          setRegisterStep(registerStep + 1);
        }
      } catch (err) {}
    } else if (registerStep === 2) {
      setRegisterStep(registerStep + 1);
    } else if (registerStep === 3) {
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
        <Header onClick={onClickHeaderHandler}>
          <FaChevronLeft style={{ paddingRight: "3px" }} /> 기본정보
        </Header>
        <form style={{ display: "flex", flexDirection: "column" }}>
          <Label htmlFor='email'>이메일</Label>
          <Input
            id='email'
            type='email'
            placeholder='이메일'
            autoComplete='off'
            value={email}
            onChange={onChangeEmailHandler}
            required
          ></Input>
          <ErrMessage inverted={isEmail}>{emailMessage}</ErrMessage>
          <Label htmlFor='password'>비밀번호</Label>
          <Input
            id='password'
            type='password'
            placeholder='비밀번호'
            value={password}
            onChange={onChangePasswordHandler}
            required
          ></Input>
          <ErrMessage inverted={isPassword}>{passwordMessage}</ErrMessage>
          <Label htmlFor='confirmPassword'>비빌번호 확인</Label>
          <Input
            id='confirmPassword'
            type='password'
            placeholder='비밀번호 확인'
            value={passwordConfirm}
            onChange={onChangeConfirmPassworHandler}
            required
          ></Input>
          <ErrMessage inverted={isPasswordConfirm}>
            {passwordConfirmMessage}
          </ErrMessage>
        </form>
        <NextButton
          disabled={!(isEmail && isPassword && isPasswordConfirm)}
          onClick={onClickHandler}
        >
          다음으로(1/4)
        </NextButton>
      </Wrapper>
    );
  } else if (registerStep === 1) {
    return (
      <Wrapper>
        <Header onClick={onClickHeaderHandler}>
          <FaChevronLeft style={{ paddingRight: "3px" }} /> 기본정보
        </Header>
        <form style={{ display: "flex", flexDirection: "column" }}>
          <Label htmlFor='nickname'>닉네임을 입력해주세요!</Label>
          <Input
            id='nickname'
            type='text'
            autoComplete='off'
            maxLength='4'
            placeholder='닉네임 입력'
            value={nickname}
            onChange={onChangeNicknameHandler}
          ></Input>
          <ErrMessage inverted={isNickname}>{nicknameMessage}</ErrMessage>
        </form>
        <NextButton disabled={!isNickname} onClick={onClickHandler}>
          다음으로(2/4)
        </NextButton>
      </Wrapper>
    );
  } else if (registerStep === 2) {
    return (
      <Wrapper>
        <Header onClick={onClickHeaderHandler}>
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
          <NextButton disabled={!sex} onClick={onClickHandler}>
            다음으로(3/4)
          </NextButton>
        </form>
      </Wrapper>
    );
  } else if (registerStep === 3) {
    return (
      <Wrapper>
        <Header onClick={onClickHeaderHandler}>
          <FaChevronLeft style={{ paddingRight: "3px" }} /> 기본정보
        </Header>
        <form style={{ display: "flex", flexDirection: "column" }}>
          <Label htmlFor='birth'>생년월일을 알려주세요!</Label>
          <Input
            min='1800-00-00'
            max='2200-12-31'
            id='birth'
            type='date'
            value={birth}
            onChange={onChangeBirthHandler}
            placeholder='YYYY/MM/DD'
          ></Input>
        </form>
        <NextButton disabled={!birth} onClick={onClickHandler}>
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
  cursor: pointer;
`;

const Title = styled.div`
  font-size: 12px;
  color: rgba(112, 112, 112, 1);
  margin-bottom: 6px;
`;

const ErrMessage = styled.p`
  color: red;
  font-size: 12px;
  margin-bottom: 6px;
  ${(props) =>
    props.inverted &&
    css`
      color: rgba(0, 39, 253, 1);
    `}
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
  margin-bottom: 6px;
  outline: none;
  border-bottom: 1px solid #ced4da;
  transition: all 0.8s ease-in-out;
  &:focus {
    border-bottom: 1px solid rgba(0, 39, 253, 1);
  }
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
