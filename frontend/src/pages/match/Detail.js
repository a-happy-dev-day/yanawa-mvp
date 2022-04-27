import React, { useEffect, useState } from "react";
import { Badge, ListGroup } from "react-bootstrap";
import { useParams } from "react-router-dom";

const Detail = (props) => {
  console.log("detail log 확인", props);
  //   const {
  //     matchingId,
  //     age,
  //     content,
  //     matchingDate,
  //     maximumLevel,
  //     minimumLevel,
  //     numberOfMember,
  //     recruitmentAnnual,
  //     rentalCost,
  //     sex,
  //     teamGame,
  //     tennisCourtName,
  //     userId,
  //   } = props.match;

  const propsParam = useParams();
  const matchingId = propsParam.id;
  console.log("propsParam", propsParam);
  console.log("matchingId", matchingId);

  const [matching, setMatching] = useState({
    matchingId: "",
    age: "",
    content: "",
    matchingDate: "",
    maximumLevel: "",
    minimumLevel: "",
    numberOfMember: "",
    recruitmentAnnual: "",
    rentalCost: "",
    sex: "",
    teamGame: "",
    tennisCourtName: "",
    userId: "",
  });

  useEffect(() => {
    fetch("http://3.34.47.146:14122/api/matching/" + matchingId)
      .then((res) => res.json())
      .then((res) => {
        console.log(res);
        setMatching(res);
      });
  }, []);

  console.log("props 확인", matching.tennisCourtName);

  return (
    <div
      style={{
        width: "375px",
        height: "677px",
        borderRadius: "20px",
        marginBottom: "20px",
        padding: "10px 10px 10px 10px",
        backgroundColor: "#F4F4F4",
      }}
    >
      <h6
        style={{
          fontWeight: "bold",
          marginTop: "30px",
          marginBottom: "20px",
        }}
      >
        매칭 자세히 보기
      </h6>

      <ListGroup as="ul">
        <ListGroup.Item
          as="li"
          className="d-flex justify-content-between align-items-start"
        >
          <div className="ms-2 me-auto">
            <div
              className="fw-bold"
              style={{
                backgroundColor: "white",
                border: "white",
                color: "black",
                pointerEvents: "none",
              }}
            >
              코트
            </div>
          </div>
          <Badge bg="primary" pill>
            <h6>{matching.tennisCourtName}</h6>
          </Badge>
        </ListGroup.Item>
        <ListGroup.Item
          as="li"
          className="d-flex justify-content-between align-items-start"
        >
          <div className="ms-2 me-auto">
            <div className="fw-bold">일시</div>
          </div>
          <Badge bg="primary" pill>
            <h6>{matching.matchingDate}</h6>
          </Badge>
        </ListGroup.Item>
        <ListGroup.Item
          as="li"
          className="d-flex justify-content-between align-items-start"
        >
          <div className="ms-2 me-auto">
            <div className="fw-bold">선호게임</div>
          </div>
          <Badge bg="primary" pill>
            <h6>{matching.teamGame === "MATCH" ? "매치" : "랠리"}</h6>
          </Badge>
        </ListGroup.Item>
        <ListGroup.Item
          as="li"
          className="d-flex justify-content-between align-items-start"
        >
          <div className="ms-2 me-auto">
            <div className="fw-bold">모집성별</div>
          </div>
          <Badge bg="primary" pill>
            <h6>{matching.sex === "MEN" ? "남" : "여"}</h6>
          </Badge>
        </ListGroup.Item>
        <ListGroup.Item
          as="li"
          className="d-flex justify-content-between align-items-start"
        >
          <div className="ms-2 me-auto">
            <div className="fw-bold">모집인원</div>
          </div>
          <Badge bg="primary" pill>
            <h6>{matching.numberOfMember}명</h6>
          </Badge>
        </ListGroup.Item>
        <ListGroup.Item
          as="li"
          className="d-flex justify-content-between align-items-start"
        >
          <div className="ms-2 me-auto">
            <div className="fw-bold">구력</div>
          </div>
          <Badge bg="primary" pill>
            <h6>{matching.recruitmentAnnual}명</h6>
          </Badge>
        </ListGroup.Item>
        <ListGroup.Item
          as="li"
          className="d-flex justify-content-between align-items-start"
        >
          <div className="ms-2 me-auto">
            <div className="fw-bold">레벨</div>
          </div>
          <Badge bg="primary" pill>
            <h6>
              {matching.minimumLevel}~{matching.maximumLevel}
            </h6>
          </Badge>
        </ListGroup.Item>
        <ListGroup.Item
          as="li"
          className="d-flex justify-content-between align-items-start"
        >
          <div className="ms-2 me-auto">
            <div className="fw-bold">모집연령</div>
          </div>
          <Badge bg="primary" pill>
            <h6>{matching.age === "TWENTIES" ? "20대" : "무관"}</h6>
          </Badge>
        </ListGroup.Item>
        <ListGroup.Item
          as="li"
          className="d-flex justify-content-between align-items-start"
        >
          <div className="ms-2 me-auto">
            <div className="fw-bold">1인 코트비용</div>
          </div>
          <Badge bg="primary" pill>
            <h6>{matching.rentalCost}원</h6>
          </Badge>
        </ListGroup.Item>
        <ListGroup.Item
          as="li"
          className="d-flex justify-content-between align-items-start"
        >
          <div className="ms-2 me-auto">
            <div className="fw-bold">남길 말</div>
          </div>
          <Badge bg="primary" pill>
            잘 부탁드립니다!
          </Badge>
        </ListGroup.Item>
        <ListGroup.Item
          as="li"
          className="d-flex justify-content-between align-items-start"
        >
          <div className="ms-2 me-auto">
            <div className="fw-bold">매칭 멤버</div>
          </div>
          <Badge bg="primary" pill>
            심바
          </Badge>
        </ListGroup.Item>
      </ListGroup>
    </div>
  );
};

export default Detail;
