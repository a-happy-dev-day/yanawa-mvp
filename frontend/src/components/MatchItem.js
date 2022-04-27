import React from "react";
import { Badge, Card } from "react-bootstrap";
import { Link } from "react-router-dom";
import goDetail from "./in.png";

const MatchItem = (props) => {
  // 백엔드에서 넘겨받은 데이터 대략 이렇게....
  const {
    matchingId,
    age,
    content,
    matchingDate,
    maximumLevel,
    minimumLevel,
    numberOfMember,
    recruitmentAnnual,
    rentalCost,
    sex,
    teamGame,
    tennisCourtName,
    userId,
  } = props.mhg;

  const id = matchingId;

  //   To-Do : 값이 없는 경우 default 값 처리
  //   MatchItem.defaultProps = {
  //     // sex: '여',
  //   };

  return (
    <Card
      style={{
        border: "white",
        marginBottom: "7px",
      }}
    >
      <Card.Body>
        <Card.Title
          style={{
            fontSize: "13px",
            fontWeight: "bold",
            width: "80%",
          }}
        >
          {/* <Card.Text
            className="btn btn-primary"
            style={{
              backgroundColor: '#FF8D9E',
              borderColor: '#FF8D9E',
              fontSize: '5px',
            }}
          >
            {sex === 'MEN' ? '남' : '여'}복
          </Card.Text>{' '} */}
          <Badge bg="info">{sex === "MEN" ? "남" : "여"}복</Badge>{" "}
          {tennisCourtName}
        </Card.Title>
        <Card.Text
          style={{
            fontSize: "8px",
            width: "80%",
            display: "inline",
          }}
        >
          {matchingDate} | {sex === "MEN" ? "남" : "여"} | {recruitmentAnnual}년
          이하 | {minimumLevel}
          부터 ~ {maximumLevel}까지
        </Card.Text>
        <Link
          to={"/api/matching/" + id}
          className="btn btn-primary"
          style={{
            backgroundColor: "white",
            border: "white",
            color: "black",
            justifyContent: "end",
            alignItems: "center",
            display: "inline",
          }}
        >
          <img src={goDetail} width="20" height="20" alt="Detail" />
        </Link>
      </Card.Body>
    </Card>
  );
};

export default MatchItem;
