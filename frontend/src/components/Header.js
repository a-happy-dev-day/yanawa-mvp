import React from 'react';
import {
  Button,
  Container,
  Nav,
  Navbar,
  OverlayTrigger,
  Tooltip,
} from 'react-bootstrap';
import { Link } from 'react-router-dom';
import yanawa from './yanawa.png';

const Header = () => {
  return (
    <>
      <Navbar bg="white">
        <Container>
          <Link to="/" className="navbar-brand">
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
          <Link to="/" className="nav-link ">
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
                  backgroundColor: 'white',
                  border: 'white',
                  color: 'black',
                  pointerEvents: 'none',
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
                backgroundColor: 'white',
                border: 'white',
                color: 'black',
                pointerEvents: 'none',
              }}
            >
              내글
            </Button>
          </span>
        </OverlayTrigger>
      </Nav>
    </>
  );
};

export default Header;
