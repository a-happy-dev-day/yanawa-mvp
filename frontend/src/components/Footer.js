import React from "react";
import { Container, Nav, Navbar } from "react-bootstrap";
import { Link } from "react-router-dom";
import add from "./add.png";
import main from "./main.png";
import chat from "./chat.png";
import alarm from "./alarm.png";
import mypage from "./mypage.png";

const Footer = () => {
  return (
    <>
      <Navbar
        style={{
          width: "100%",
          height: "30px",
          position: "relative",
          zIndex: 2,
        }}
        bg="white"
      >
        <Container
          className="justify-content-center"
          style={{
            position: "relative",
            zIndex: 2,
            height: "20px",
          }}
        >
          <Link to="/saveForm" className="nav-link">
            <img
              src={add}
              width="50"
              height="50"
              className="d-inline-block"
              alt="new match button"
            />
          </Link>
        </Container>
      </Navbar>
      <Navbar
        style={{
          width: "100%",
          height: "70px",
          position: "relative",
        }}
        bg="white"
      >
        <Container
          className="justify-content-around"
          style={{
            position: "relative",
            zIndex: 1,
            height: "1px",
          }}
        >
          <Link to="/main" className="nav-link">
            <img
              src={main}
              width="28"
              height="28"
              className="d-inline-block"
              alt="main button"
            />
          </Link>
          <Link to="/chatting" className="nav-link">
            <img
              src={chat}
              width="28"
              height="28"
              className="d-inline-block"
              alt="chat button"
            />
          </Link>
          <Link to="/alarm" className="nav-link">
            <img
              src={alarm}
              width="28"
              height="28"
              className="d-inline-block"
              alt="alarm button"
            />
          </Link>
          <Link to="/myPage" className="nav-link">
            <img
              src={mypage}
              width="28"
              height="28"
              className="d-inline-block"
              alt="mypage button"
            />
          </Link>
        </Container>
      </Navbar>
    </>
  );
};

export default Footer;
