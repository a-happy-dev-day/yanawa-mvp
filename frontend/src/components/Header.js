import React from "react";
import {
  Button,
  Container,
  Nav,
  Navbar,
  OverlayTrigger,
  Tooltip,
} from "react-bootstrap";
import { Link } from "react-router-dom";
import yanawa from "./yanawa.png";
import styled from "styled-components";

const Header = () => {
  return (
    <>
      <HeaderBox>
        <Navbar bg="white">
          <Container>
            <Link to="/main" className="navbar-brand">
              <img
                src={yanawa}
                width="70"
                height="14"
                className="d-inline-block align-left"
                alt="Ya!Nawa logo"
              />
            </Link>
          </Container>
        </Navbar>

        <Nav className="justify-content-center" activeKey="/">
          <Nav.Item>
            <Link to="/main" className="nav-link ">
              매칭
            </Link>
          </Nav.Item>

          <Nav.Item>
            <OverlayTrigger
              overlay={<Tooltip id="tooltip-disabled">준비중입니다!</Tooltip>}
            >
              <span className="d-inline-block ">
                <Button
                  disabled
                  style={{
                    backgroundColor: "white",
                    border: "white",
                    color: "black",
                    pointerEvents: "none",
                  }}
                >
                  양도
                </Button>
              </span>
            </OverlayTrigger>
          </Nav.Item>
          <OverlayTrigger
            overlay={<Tooltip id="tooltip-disabled">준비중입니다!</Tooltip>}
          >
            <span className="d-inline-block">
              <Button
                disabled
                style={{
                  backgroundColor: "white",
                  border: "white",
                  color: "black",
                  pointerEvents: "none",
                }}
              >
                내글
              </Button>
            </span>
          </OverlayTrigger>
        </Nav>
      </HeaderBox>
    </>
  );
};

export default Header;

const HeaderBox = styled.div`
  font-family: "Noto Sans KR", sans-serif;
  display: flex;
  flex-direction: column;
  align-items: center;
  box-sizing: border-box;
  position: relative;
  background-color: #fff;
`;
