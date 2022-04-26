import React, { createContext, useState } from "react";

const RegisterContext = createContext({
  state: {
    email: "",
    password: "",
    nickname: "",
    sex: "",
    birth: "",
    level: "",
  },
  actions: {
    setEmail: () => {},
    setPassword: () => {},
    setNickname: () => {},
    setSex: () => {},
    setbirth: () => {},
    setLevel: () => {},
  },
});

const RegisterProvider = ({ children }) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [nickname, setNickname] = useState("");
  const [sex, setSex] = useState("");
  const [birth, setBirth] = useState("");
  const [level, setLevel] = useState("");

  const value = {
    state: { email, password, nickname, sex, birth, level },
    actions: { setEmail, setPassword, setSex, setBirth, setNickname, setLevel },
  };

  return (
    <RegisterContext.Provider value={value}>
      {children}
    </RegisterContext.Provider>
  );
};

const { Consumer: RegisterConsumer } = RegisterContext;

export { RegisterProvider, RegisterConsumer };

export default RegisterContext;
