import React, { useState } from "react";
import { Button, Form } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

const SaveForm = (props) => {
  const navigate = useNavigate();
  const [match, setMatch] = useState({
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

  // {
  //   "userId": 1,
  //   "tennisCourtName": "구로테니스",
  //   "matchingDate": "2022-05-07T20:30",
  //   "numberOfMember": 2,
  //   "age": "OVERFIFTIES",
  //   "minimumLevel": "A",
  //   "maximumLevel": "B",
  //   "content": "content",
  //   "recruitmentAnnual": 1,
  //   "teamGame": "RELLY",
  //   "rentalCost": 10000,
  //   "sex": "WOMEN"
  // }

  const changeValue = (e) => {
    setMatch({
      ...match,
      [e.target.name]: e.target.value,
    });
  };

  const submitMatch = (e) => {
    console.log("값 체킹 f : " + match.matchingDate); // 값 체킹
    console.log("값 체킹 f : " + match.matchingDate); // 값 체킹
    e.preventDefault();

    fetch("http://3.34.47.146:14122/api/matching", {
      method: "POST",
      headers: {
        "Content-Type": "application/json; charset=utf-8",
      },
      body: JSON.stringify(match),
    })
      .then((res) =>
        //   res.JSON()
        {
          console.log("값 체킹123" + match); // 값 체킹
          if (res.status === 201) {
            console.log("값 체킹" + res); // 값 체킹
            return res.JSON();
          } else {
            return null;
          }
        }
      )
      .then((res) => {
        // 백엔드 서버 실행 후 넘기는 값 테스트 해 볼 부분
        console.log("테스트 af go main" + res);
        console.log("navigate ??"); // 값 체킹
        navigate("/main");
        if (res !== null) {
          // 일단 등록 성공 후 매칭리스트(메인)페이지로 가도록 .. 현재 기획안 상태에서는 완성 상세 페이지로 가게 되어있는데.. 이 부분은 구현현황에 따라 변경
          console.log("navigate ??"); // 값 체킹
          navigate("/main");
        } else {
          // alert("오류로 인해 매칭 등록이 안되었습니다.");
        }
      });
  };

  return (
    <div
      style={{
        width: "375px",
        height: "141%",
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
        매칭 만들기
      </h6>
      <Form onSubmit={submitMatch}>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>코트장 선택</Form.Label>
          <Form.Control
            type="text"
            placeholder="코드장 입력"
            onChange={changeValue}
            name="tennisCourtName"
          />
          <Form.Text className="text-muted"></Form.Text>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>일시</Form.Label>
          <Form.Control
            type="text"
            placeholder="날짜/시간 선택"
            onChange={changeValue}
            name="matchingDate"
          />
          <Form.Text className="text-muted"></Form.Text>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>최소 레벨</Form.Label>
          <Form.Control
            type="text"
            placeholder="레벨 입력 (A ~ E )"
            onChange={changeValue}
            name="minimumLevel"
          />
          <Form.Text className="text-muted"></Form.Text>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>최대 레벨</Form.Label>
          <Form.Control
            type="text"
            placeholder="레벨 입력 (A ~ E )"
            onChange={changeValue}
            name="maximumLevel"
          />
          <Form.Text className="text-muted"></Form.Text>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>모집연령</Form.Label>
          <Form.Control
            type="text"
            placeholder="모집 연령 입력"
            onChange={changeValue}
            name="age"
          />
          <Form.Text className="text-muted"></Form.Text>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>모집 성별</Form.Label>
          <Form.Control
            type="text"
            placeholder="모집성별"
            onChange={changeValue}
            name="sex"
          />
          <Form.Text className="text-muted"></Form.Text>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>선호게임</Form.Label>
          <Form.Control
            type="text"
            placeholder="매칭 / 랠리"
            onChange={changeValue}
            name="teamGame"
          />
          <Form.Text className="text-muted"></Form.Text>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>모집인원</Form.Label>
          <Form.Control
            type="text"
            placeholder="2명 / 4명"
            onChange={changeValue}
            name="numberOfMember"
          />
          <Form.Text className="text-muted"></Form.Text>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>코트비용</Form.Label>
          <Form.Control
            type="text"
            placeholder="1인 코트 비용 입력 (원)"
            onChange={changeValue}
            name="rentalCost"
          />
          <Form.Text className="text-muted"></Form.Text>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>하고 싶은 말</Form.Label>
          <Form.Control
            type="text"
            placeholder="매칭할 상대에게 하고 싶은 말을 적어주세요."
            onChange={changeValue}
            name="content"
          />
          <Form.Text className="text-muted"></Form.Text>
        </Form.Group>

        <Button
          variant="primary"
          type="submit"
          style={
            {
              // width: "40px",
            }
          }
        >
          매칭 만들기 완료
        </Button>
      </Form>
    </div>
  );
};

export default SaveForm;
